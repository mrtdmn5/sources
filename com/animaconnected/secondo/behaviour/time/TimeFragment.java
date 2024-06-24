package com.animaconnected.secondo.behaviour.time;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.behaviour.time.timepicker.TimePickerFragment;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.timezone.TimeZoneCity;
import com.animaconnected.secondo.provider.timezone.TimeZoneProvider;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPager;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.SlotScalesHelper;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.BehaviourChangeListener;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.kronaby.watch.app.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class TimeFragment extends BaseDetailsFragment implements BehaviourChangeListener {
    private static final String HOME_TIMEZONE_TOGGLE_DISABLE = "HomeTimeZone_toggle_disable";
    private static final String HOME_TIMEZONE_TOGGLE_ENABLE = "HomeTimeZone_toggle_enable";
    private Capabilities mCapabilities;
    private TextView mDisplayedTime;
    private View mHomeTimeZoneChevron;
    private View mHomeTimeZoneContainer;
    private TextView mHomeTimeZoneGmtOffset;
    private TextView mHomeTimeZoneName;
    private CompoundButton mHomeTimeZoneSwitch;
    private DetailWatchPagerAdapter mPagerAdapter;
    private Time mTimeBehaviour;
    private DateFormat mTimeFormat12Hour;
    private DateFormat mTimeFormat24Hour;
    private TextView mTimeZoneName;
    private TextView mTimeZoneNameGmtOffset;
    private TimeZoneProvider mTimeZoneProvider;
    private WatchProvider mWatch;

    private void disableHomeTimeZonePicker() {
        this.mHomeTimeZoneSwitch.setChecked(false);
        this.mHomeTimeZoneName.setAlpha(0.3f);
        this.mHomeTimeZoneGmtOffset.setAlpha(0.3f);
        this.mHomeTimeZoneChevron.setAlpha(0.3f);
        this.mHomeTimeZoneContainer.setClickable(false);
    }

    private void enableHomeTimeZonePicker() {
        this.mHomeTimeZoneSwitch.setChecked(true);
        this.mHomeTimeZoneName.setAlpha(1.0f);
        this.mHomeTimeZoneGmtOffset.setAlpha(1.0f);
        this.mHomeTimeZoneChevron.setAlpha(1.0f);
        this.mHomeTimeZoneContainer.setClickable(true);
    }

    private List<BaseDetailWatchPage> getPagerData(List<SlotScalesHelper.SlotScale> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (SlotScalesHelper.SlotScale slotScale : list) {
            Slot slot = slotScale.getSlot();
            Slot slot2 = Slot.MainComplication;
            if ((slot == slot2 || slotScale.getSlot() == Slot.MainComplicationDouble || slotScale.getScale() == Scale.ZeroToTwelve) && !z) {
                arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout, slot2, this.type));
                z = true;
            } else if (slotScale.getScale() == Scale.ZeroToTwentyFour) {
                arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, slotScale.getSlot(), this.type));
            }
        }
        return arrayList;
    }

    public /* synthetic */ void lambda$onCreateView$0(View view) {
        getMainController().gotoNextFragment(TimePickerFragment.newInstance(false));
    }

    public /* synthetic */ void lambda$onCreateView$1(View view) {
        getMainController().gotoNextFragment(TimePickerFragment.newInstance(true));
    }

    public /* synthetic */ void lambda$onCreateView$2(CompoundButton compoundButton, boolean z) {
        String str;
        if (compoundButton.isPressed()) {
            TimeStorage.setHomeTimezoneEnabled(getContext(), z);
            AppEvents appAnalytics = ProviderFactory.getAppAnalytics();
            if (z) {
                str = HOME_TIMEZONE_TOGGLE_ENABLE;
            } else {
                str = HOME_TIMEZONE_TOGGLE_DISABLE;
            }
            appAnalytics.sendAction(str);
            Time time = this.mTimeBehaviour;
            time.setDeviceTimezoneId(time.getActiveTimezone().getID());
            update();
        }
    }

    public static TimeFragment newInstance(Slot slot) {
        TimeFragment timeFragment = new TimeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", Time.TYPE);
        timeFragment.setArguments(bundle);
        return timeFragment;
    }

    private void update() {
        DateFormat dateFormat;
        TimeZoneCity cityByTimeZone = this.mTimeZoneProvider.getCityByTimeZone(this.mTimeBehaviour.getTimezone());
        this.mTimeZoneName.setText(cityByTimeZone.getName());
        this.mTimeZoneNameGmtOffset.setText(cityByTimeZone.getGmtRawOffsetString());
        if (TimeStorage.getHomeTimezoneEnabled(getContext())) {
            enableHomeTimeZonePicker();
        } else {
            disableHomeTimeZonePicker();
        }
        TimeZoneCity cityByTimeZone2 = this.mTimeZoneProvider.getCityByTimeZone(this.mTimeBehaviour.getHomeTimezone());
        this.mHomeTimeZoneName.setText(cityByTimeZone2.getName());
        this.mHomeTimeZoneGmtOffset.setText(cityByTimeZone2.getGmtRawOffsetString());
        Iterator<BaseDetailWatchPage> it = this.mPagerAdapter.getItems().iterator();
        while (it.hasNext()) {
            it.next().updateHands(true);
        }
        TimeZone activeTimezone = this.mTimeBehaviour.getActiveTimezone();
        TimeZoneCity cityByTimeZone3 = this.mTimeZoneProvider.getCityByTimeZone(activeTimezone);
        if (android.text.format.DateFormat.is24HourFormat(getContext())) {
            dateFormat = this.mTimeFormat24Hour;
        } else {
            dateFormat = this.mTimeFormat12Hour;
        }
        dateFormat.setTimeZone(activeTimezone);
        this.mDisplayedTime.setText(String.format(getString(R.string.time_zone_displayed), cityByTimeZone3.getName(), dateFormat.format(new Date())));
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.watch.behaviour.BehaviourChangeListener
    public void onBehaviourChanged() {
        update();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTimeBehaviour = (Time) getBehaviourPlugin().getBehaviour();
        this.mTimeZoneProvider = TimeZoneProvider.getProvider(getContext());
        WatchProvider watch = ProviderFactory.getWatch();
        this.mWatch = watch;
        this.mCapabilities = watch.getCapabilities();
        Locale translationCompatibleLocale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
        this.mTimeFormat12Hour = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(translationCompatibleLocale, "hma"), translationCompatibleLocale);
        this.mTimeFormat24Hour = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(translationCompatibleLocale, "Hm"), translationCompatibleLocale);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_time, viewGroup, false);
        List<SlotScalesHelper.SlotScale> slotScales = SlotScalesHelper.INSTANCE.getSlotScales(this.mCapabilities, this.mWatch.getBehaviours().getBehaviour(this.type), this.slot);
        DetailWatchPager detailWatchPager = (DetailWatchPager) inflate.findViewById(R.id.detail_watch_layout_pager);
        DetailWatchPagerAdapter detailWatchPagerAdapter = new DetailWatchPagerAdapter(getChildFragmentManager());
        this.mPagerAdapter = detailWatchPagerAdapter;
        detailWatchPagerAdapter.setData(getPagerData(slotScales));
        detailWatchPager.setAdapter(this.mPagerAdapter);
        inflate.findViewById(R.id.set_time_zone_container).setOnClickListener(new TimeFragment$$ExternalSyntheticLambda0(this, 0));
        this.mTimeZoneName = (TextView) inflate.findViewById(R.id.time_zone_name);
        this.mTimeZoneNameGmtOffset = (TextView) inflate.findViewById(R.id.time_zone_gmt_offset);
        View findViewById = inflate.findViewById(R.id.home_set_time_zone_container);
        this.mHomeTimeZoneContainer = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.time.TimeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeFragment.this.lambda$onCreateView$1(view);
            }
        });
        CompoundButton compoundButton = (CompoundButton) inflate.findViewById(R.id.home_time_zone_switch);
        this.mHomeTimeZoneSwitch = compoundButton;
        compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.behaviour.time.TimeFragment$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton2, boolean z) {
                TimeFragment.this.lambda$onCreateView$2(compoundButton2, z);
            }
        });
        this.mHomeTimeZoneName = (TextView) inflate.findViewById(R.id.home_time_zone_name);
        this.mHomeTimeZoneGmtOffset = (TextView) inflate.findViewById(R.id.home_time_zone_gmt_offset);
        this.mHomeTimeZoneChevron = inflate.findViewById(R.id.home_chevron);
        this.mDisplayedTime = (TextView) inflate.findViewById(R.id.displayed_time);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.overview_crown_container);
        ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.overview_sub_dial_container);
        for (SlotScalesHelper.SlotScale slotScale : slotScales) {
            if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                if (slotScale.getScale() == Scale.ZeroToTwentyFour || slotScale.getScale() == Scale.ZeroToTwelve) {
                    viewGroup3.setVisibility(0);
                }
            } else {
                viewGroup2.setVisibility(0);
            }
        }
        if (viewGroup2.getVisibility() == 0 && viewGroup3.getVisibility() == 0) {
            inflate.findViewById(R.id.slot_divider).setVisibility(0);
        }
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void startRefreshing() {
        this.mTimeBehaviour.startRefreshing();
        this.mTimeBehaviour.registerChangeListener(this);
        update();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void stopRefreshing() {
        this.mTimeBehaviour.stopRefreshing();
        this.mTimeBehaviour.unregisterChangeListener(this);
    }
}

package com.animaconnected.secondo.behaviour.time.timepicker;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.time.Time;
import com.animaconnected.secondo.behaviour.time.TimeStorage;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.timezone.TimeZoneCity;
import com.animaconnected.secondo.provider.timezone.TimeZoneProvider;
import com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment;
import com.animaconnected.secondo.screens.detailspicker.PickerOption;
import com.animaconnected.watch.WatchProvider;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class TimePickerFragment extends BaseDetailsPickerFragment {
    private static final String HOME_TIMEZONE = "homeTimeZone";
    private boolean mHomeTimeZone;
    private List<PickerOption> mPickerOptions;
    private final WatchProvider mWatch = ProviderFactory.getWatch();

    /* loaded from: classes3.dex */
    public static class TimeZoneOption implements PickerOption {
        private final TimeZoneCity mCity;

        public TimeZoneOption(TimeZoneCity timeZoneCity) {
            this.mCity = timeZoneCity;
        }

        @Override // com.animaconnected.secondo.screens.detailspicker.PickerOption
        public String getDisplayText() {
            return this.mCity.getName();
        }

        @Override // com.animaconnected.secondo.screens.detailspicker.PickerOption
        public String getSubText() {
            return this.mCity.getGmtRawOffsetString();
        }

        public TimeZone getTimeZone() {
            return this.mCity.getTimeZone();
        }
    }

    private int findSelectedIndex() {
        String str;
        Time time = (Time) this.mWatch.getBehaviours().getBehaviour(Time.TYPE);
        String timezoneId = time.getTimezoneId();
        String homeTimezoneId = time.getHomeTimezoneId();
        Iterator<PickerOption> it = this.mPickerOptions.iterator();
        int r3 = 0;
        while (it.hasNext()) {
            String str2 = ((TimeZoneOption) it.next()).getTimeZone().getID();
            if (this.mHomeTimeZone) {
                str = homeTimezoneId;
            } else {
                str = timezoneId;
            }
            if (str2.compareTo(str) == 0) {
                break;
            }
            r3++;
        }
        return r3;
    }

    public static BaseDetailsPickerFragment newInstance(boolean z) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(HOME_TIMEZONE, z);
        timePickerFragment.setArguments(bundle);
        return timePickerFragment;
    }

    private void updateDevice(Time time) {
        if (this.mHomeTimeZone) {
            time.setDeviceTimezoneId(time.getActiveTimezone().getID());
            return;
        }
        time.setDeviceTimezoneId(time.getTimezoneId());
        if (time.isHomeTimezoneActive()) {
            TimeStorage.setHomeTimezoneEnabled(getContext(), false);
        }
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_complications);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mHomeTimeZone = arguments.getBoolean(HOME_TIMEZONE);
        }
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter.DetailsPickerAdapterListener
    public void onListItemClicked(PickerOption pickerOption) {
        Time time = (Time) this.mWatch.getBehaviours().getBehaviour(Time.TYPE);
        TimeZoneOption timeZoneOption = (TimeZoneOption) pickerOption;
        if (!this.mHomeTimeZone) {
            time.setTimezoneId(timeZoneOption.getTimeZone().getID());
        } else {
            time.setHomeTimezoneId(timeZoneOption.getTimeZone().getID());
        }
        updateDevice(time);
        this.mAdapter.setSelectedIndex(findSelectedIndex());
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        List<TimeZoneCity> citiesRawOffsetOrder = TimeZoneProvider.getProvider(getContext()).getCitiesRawOffsetOrder();
        this.mPickerOptions = new ArrayList(citiesRawOffsetOrder.size());
        Iterator<TimeZoneCity> it = citiesRawOffsetOrder.iterator();
        while (it.hasNext()) {
            this.mPickerOptions.add(new TimeZoneOption(it.next()));
        }
        this.mAdapter.setData(this.mPickerOptions);
        this.mAdapter.setDetailsPickerAdapterListener(this);
        this.mAdapter.setSelectedIndex(findSelectedIndex());
        if (!this.mHomeTimeZone) {
            this.mAdapter.setHeadline(view.getContext().getString(R.string.time_zone_picker_title));
        } else {
            this.mAdapter.setHeadline(view.getContext().getString(R.string.home_time_zone_picker_title));
        }
    }
}

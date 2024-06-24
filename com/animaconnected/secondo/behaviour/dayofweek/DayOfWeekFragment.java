package com.animaconnected.secondo.behaviour.dayofweek;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DayOfWeekFragment extends BaseDetailsFragment implements BehaviourChangeListener {
    private Capabilities mCapabilities;
    private SimpleDateFormat mDateFormat;
    private DayOfWeek mDayOfWeekBehaviour;
    private TextView mDisplayedDayOfWeek;
    private DetailWatchPagerAdapter mPagerAdapter;
    private WatchProvider mWatch;

    public static DayOfWeekFragment newInstance(Slot slot) {
        DayOfWeekFragment dayOfWeekFragment = new DayOfWeekFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", DayOfWeek.TYPE);
        dayOfWeekFragment.setArguments(bundle);
        return dayOfWeekFragment;
    }

    private void update() {
        Iterator<BaseDetailWatchPage> it = this.mPagerAdapter.getItems().iterator();
        while (it.hasNext()) {
            it.next().updateHands(true);
        }
        this.mDisplayedDayOfWeek.setText(this.mDateFormat.format(new Date()));
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public List<BaseDetailWatchPage> getPagerData() {
        ArrayList arrayList = new ArrayList();
        for (SlotScalesHelper.SlotScale slotScale : SlotScalesHelper.INSTANCE.getSlotScales(this.mCapabilities, this.mWatch.getBehaviours().getBehaviour(this.type), this.slot)) {
            if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                if (slotScale.getScale() == Scale.DaysOfWeek) {
                    arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, slotScale.getSlot(), this.type));
                }
            } else {
                arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, this.slot, this.type));
            }
        }
        return arrayList;
    }

    @Override // com.animaconnected.watch.behaviour.BehaviourChangeListener
    public void onBehaviourChanged() {
        update();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDayOfWeekBehaviour = (DayOfWeek) getBehaviourPlugin().getBehaviour();
        WatchProvider watch = ProviderFactory.getWatch();
        this.mWatch = watch;
        this.mCapabilities = watch.getCapabilities();
        Locale translationCompatibleLocale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
        this.mDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(translationCompatibleLocale, "EEEE"), translationCompatibleLocale);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_dayofweek, viewGroup, false);
        this.mDisplayedDayOfWeek = (TextView) inflate.findViewById(R.id.displayed_dayofweek);
        DetailWatchPager detailWatchPager = (DetailWatchPager) inflate.findViewById(R.id.detail_watch_layout_pager);
        DetailWatchPagerAdapter detailWatchPagerAdapter = new DetailWatchPagerAdapter(getChildFragmentManager());
        this.mPagerAdapter = detailWatchPagerAdapter;
        detailWatchPagerAdapter.setData(getPagerData());
        detailWatchPager.setAdapter(this.mPagerAdapter);
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void startRefreshing() {
        this.mDayOfWeekBehaviour.startRefreshing();
        this.mDayOfWeekBehaviour.registerChangeListener(this);
        update();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void stopRefreshing() {
        this.mDayOfWeekBehaviour.stopRefreshing();
        this.mDayOfWeekBehaviour.unregisterChangeListener(this);
    }
}

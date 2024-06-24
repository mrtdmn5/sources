package com.animaconnected.secondo.behaviour.date;

import android.os.Bundle;
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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DateFragment extends BaseDetailsFragment implements BehaviourChangeListener {
    private Capabilities mCapabilities;
    private Date mDateBehaviour;
    private DateFormat mDateFormat;
    private TextView mDisplayedDate;
    private DetailWatchPagerAdapter mPagerAdapter;
    private List<SlotScalesHelper.SlotScale> mSlotCapabilities;
    private TextView mSubComplicationText;
    private WatchProvider mWatch;

    public static DateFragment newInstance(Slot slot) {
        DateFragment dateFragment = new DateFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", Date.TYPE);
        dateFragment.setArguments(bundle);
        return dateFragment;
    }

    private void update() {
        Iterator<BaseDetailWatchPage> it = this.mPagerAdapter.getItems().iterator();
        while (it.hasNext()) {
            it.next().updateHands(true);
        }
        this.mDisplayedDate.setText(String.format(getContext().getString(R.string.date_displayed), this.mDateFormat.format(new java.util.Date())));
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public List<BaseDetailWatchPage> getPagerData(List<SlotScalesHelper.SlotScale> list) {
        ArrayList arrayList = new ArrayList();
        for (SlotScalesHelper.SlotScale slotScale : list) {
            Slot slot = slotScale.getSlot();
            Slot slot2 = Slot.MainComplication;
            if (slot != slot2 && slotScale.getSlot() != Slot.MainComplicationDouble) {
                if (slotScale.getScale() == Scale.ZeroToThirtyOne) {
                    arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, slotScale.getSlot(), this.type));
                }
            } else {
                arrayList.add(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, slot2, this.type));
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
        this.mDateBehaviour = (Date) getBehaviourPlugin().getBehaviour();
        this.mDateFormat = DateFormat.getDateInstance(2, ProviderFactory.createConfigProvider().getTranslationCompatibleLocale());
        WatchProvider watch = ProviderFactory.getWatch();
        this.mWatch = watch;
        this.mCapabilities = watch.getCapabilities();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_date, viewGroup, false);
        this.mDisplayedDate = (TextView) inflate.findViewById(R.id.displayed_date);
        this.mSubComplicationText = (TextView) inflate.findViewById(R.id.sub_complication_title);
        this.mSlotCapabilities = SlotScalesHelper.INSTANCE.getSlotScales(this.mCapabilities, this.mWatch.getBehaviours().getBehaviour(this.type), this.slot);
        DetailWatchPager detailWatchPager = (DetailWatchPager) inflate.findViewById(R.id.detail_watch_layout_pager);
        DetailWatchPagerAdapter detailWatchPagerAdapter = new DetailWatchPagerAdapter(getChildFragmentManager());
        this.mPagerAdapter = detailWatchPagerAdapter;
        detailWatchPagerAdapter.setData(getPagerData(this.mSlotCapabilities));
        detailWatchPager.setAdapter(this.mPagerAdapter);
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.overview_sub_dial_container);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.overview_crown_container);
        for (SlotScalesHelper.SlotScale slotScale : this.mSlotCapabilities) {
            if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                if (slotScale.getScale() == Scale.ZeroToThirtyOne) {
                    this.mSubComplicationText.setText(R.string.sub_dial);
                    viewGroup.setVisibility(0);
                }
            } else {
                viewGroup2.setVisibility(0);
            }
        }
        if (viewGroup2.getVisibility() == 0 && viewGroup.getVisibility() == 0) {
            view.findViewById(R.id.slot_divider).setVisibility(0);
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void startRefreshing() {
        this.mDateBehaviour.startRefreshing();
        this.mDateBehaviour.registerChangeListener(this);
        update();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void stopRefreshing() {
        this.mDateBehaviour.stopRefreshing();
        this.mDateBehaviour.unregisterChangeListener(this);
    }
}

package com.animaconnected.secondo.behaviour.watchbattery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.battery.BatteryProvider;
import com.animaconnected.secondo.screens.activity.StepFormatHelper;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPager;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.SlotScalesHelper;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.BehaviourChangeListener;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchBatteryFragment.kt */
/* loaded from: classes3.dex */
public final class WatchBatteryFragment extends BaseDetailsFragment {
    private WatchBattery behaviour;
    private DetailWatchPagerAdapter pagerAdapter;
    private TextView percentageText;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final WatchProvider watchProvider = ProviderFactory.getWatch();
    private final BatteryProvider batteryProvider = ProviderFactory.getBatteryProvider();
    private final StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());
    private final WatchBatteryFragment$behaviorListener$1 behaviorListener = new BehaviourChangeListener() { // from class: com.animaconnected.secondo.behaviour.watchbattery.WatchBatteryFragment$behaviorListener$1
        @Override // com.animaconnected.watch.behaviour.BehaviourChangeListener
        public void onBehaviourChanged() {
            WatchBatteryFragment.this.update();
        }
    };

    /* compiled from: WatchBatteryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchBatteryFragment newInstance(Slot slot) {
            WatchBatteryFragment watchBatteryFragment = new WatchBatteryFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", WatchBattery.TYPE);
            watchBatteryFragment.setArguments(bundle);
            return watchBatteryFragment;
        }

        private Companion() {
        }
    }

    private final List<BaseDetailWatchPage> getPagerData(List<SlotScalesHelper.SlotScale> list) {
        for (SlotScalesHelper.SlotScale slotScale : list) {
            if (slotScale.getSlot() == Slot.MainComplication || slotScale.getSlot() == Slot.MainComplicationDouble || slotScale.getScale() == Scale.ZeroToHundred) {
                return CollectionsKt__CollectionsKt.listOf(DetailWatchPageFragment.newInstance(R.layout.watch_layout_one_hand, getSlot(), getType()));
            }
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update() {
        Float percentage = this.batteryProvider.getPercentage();
        if (percentage != null) {
            float floatValue = percentage.floatValue();
            TextView textView = this.percentageText;
            if (textView != null) {
                textView.setText(getResources().getString(R.string.behaviour_name_watch_battery_level, this.stepFormatHelper.formatPercent(floatValue)));
                DetailWatchPagerAdapter detailWatchPagerAdapter = this.pagerAdapter;
                if (detailWatchPagerAdapter != null) {
                    List<BaseDetailWatchPage> items = detailWatchPagerAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "getItems(...)");
                    Iterator<T> it = items.iterator();
                    while (it.hasNext()) {
                        ((BaseDetailWatchPage) it.next()).updateHands(true);
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("percentageText");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_details_watch_battery, viewGroup, false);
        Behaviour behaviour = getBehaviourPlugin().getBehaviour();
        Intrinsics.checkNotNull(behaviour, "null cannot be cast to non-null type com.animaconnected.secondo.behaviour.watchbattery.WatchBattery");
        this.behaviour = (WatchBattery) behaviour;
        View findViewById = inflate.findViewById(R.id.percentage_watch_battery);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.percentageText = (TextView) findViewById;
        SlotScalesHelper slotScalesHelper = SlotScalesHelper.INSTANCE;
        Capabilities capabilities = this.watchProvider.getCapabilities();
        WatchBattery watchBattery = this.behaviour;
        if (watchBattery != null) {
            List<SlotScalesHelper.SlotScale> slotScales = slotScalesHelper.getSlotScales(capabilities, watchBattery, getSlot());
            DetailWatchPagerAdapter detailWatchPagerAdapter = new DetailWatchPagerAdapter(getChildFragmentManager());
            detailWatchPagerAdapter.setData(getPagerData(slotScales));
            this.pagerAdapter = detailWatchPagerAdapter;
            DetailWatchPager detailWatchPager = (DetailWatchPager) inflate.findViewById(R.id.detail_watch_layout_pager);
            DetailWatchPagerAdapter detailWatchPagerAdapter2 = this.pagerAdapter;
            if (detailWatchPagerAdapter2 != null) {
                detailWatchPager.setAdapter(detailWatchPagerAdapter2);
                ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.overview_sub_dial_container);
                ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.overview_crown_container);
                List<SlotScalesHelper.SlotScale> list = slotScales;
                boolean z4 = list instanceof Collection;
                boolean z5 = true;
                if (!z4 || !list.isEmpty()) {
                    for (SlotScalesHelper.SlotScale slotScale : list) {
                        if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    viewGroup3.setVisibility(0);
                }
                if (!z4 || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((SlotScalesHelper.SlotScale) it.next()).getScale() == Scale.ZeroToHundred) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            break;
                        }
                    }
                }
                z5 = false;
                if (z5) {
                    viewGroup2.setVisibility(0);
                }
                if (viewGroup3.getVisibility() == 0 && viewGroup2.getVisibility() == 0) {
                    inflate.findViewById(R.id.slot_divider).setVisibility(0);
                }
                update();
                return inflate;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void startRefreshing() {
        WatchBattery watchBattery = this.behaviour;
        if (watchBattery != null) {
            watchBattery.startRefreshing();
            WatchBattery watchBattery2 = this.behaviour;
            if (watchBattery2 != null) {
                watchBattery2.registerChangeListener(this.behaviorListener);
                update();
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void stopRefreshing() {
        WatchBattery watchBattery = this.behaviour;
        if (watchBattery != null) {
            watchBattery.stopRefreshing();
            WatchBattery watchBattery2 = this.behaviour;
            if (watchBattery2 != null) {
                watchBattery2.unregisterChangeListener(this.behaviorListener);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }
}

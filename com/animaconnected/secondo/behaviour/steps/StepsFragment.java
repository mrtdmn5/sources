package com.animaconnected.secondo.behaviour.steps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.activity.ActivityFragment;
import com.animaconnected.secondo.screens.activity.ActivitySetupFragment;
import com.animaconnected.secondo.screens.activity.StepFormatHelper;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StepsFragment.kt */
/* loaded from: classes3.dex */
public final class StepsFragment extends BaseDetailsFragment implements BehaviourChangeListener {
    private DetailWatchPagerAdapter pagerAdapter;
    private List<SlotScalesHelper.SlotScale> slotScales;
    private Steps stepsBehaviour;
    private TextView subComplicationText;
    private TextView textStepsPercentage;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final WatchProvider watchProvider = ProviderFactory.getWatch();
    private final StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());

    /* compiled from: StepsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StepsFragment newInstance(Slot slot) {
            StepsFragment stepsFragment = new StepsFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, stepsFragment.getSLOT(), slot);
            bundle.putString(stepsFragment.getTYPE(), Steps.type);
            stepsFragment.setArguments(bundle);
            return stepsFragment;
        }

        private Companion() {
        }
    }

    private final BaseFragment getFirstActivityFragment() {
        if (ProviderFactory.getSettingProvider().getActivityOnboardingCompleted()) {
            return ActivityFragment.Companion.newInstance(true, DetailsFragment.NAME);
        }
        return ActivitySetupFragment.Companion.newInstance(true, DetailsFragment.NAME);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:            r1 = com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment.newInstance(com.kronaby.watch.app.R.layout.watch_layout_one_hand, getSlot(), getType());        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "newInstance(...)");        r0.add(r1);        r1 = true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage> getPagerData(java.util.List<com.animaconnected.watch.SlotScalesHelper.SlotScale> r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.util.Iterator r6 = r6.iterator()
            r1 = 0
        Ld:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L4c
            java.lang.Object r2 = r6.next()
            com.animaconnected.watch.SlotScalesHelper$SlotScale r2 = (com.animaconnected.watch.SlotScalesHelper.SlotScale) r2
            com.animaconnected.watch.Slot r3 = r2.getSlot()
            com.animaconnected.watch.Slot r4 = com.animaconnected.watch.Slot.MainComplication
            if (r3 == r4) goto L31
            com.animaconnected.watch.Slot r3 = r2.getSlot()
            com.animaconnected.watch.Slot r4 = com.animaconnected.watch.Slot.MainComplicationDouble
            if (r3 == r4) goto L31
            com.animaconnected.watch.device.Scale r2 = r2.getScale()
            com.animaconnected.watch.device.Scale r3 = com.animaconnected.watch.device.Scale.ZeroToHundred
            if (r2 != r3) goto Ld
        L31:
            if (r1 != 0) goto Ld
            com.animaconnected.watch.Slot r1 = r5.getSlot()
            java.lang.String r2 = r5.getType()
            r3 = 2131624297(0x7f0e0169, float:1.887577E38)
            com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment r1 = com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment.newInstance(r3, r1, r2)
            java.lang.String r2 = "newInstance(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.add(r1)
            r1 = 1
            goto Ld
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.steps.StepsFragment.getPagerData(java.util.List):java.util.List");
    }

    private final float getPercent() {
        Steps steps = this.stepsBehaviour;
        if (steps != null) {
            float stepsToday = steps.getStepsToday();
            if (this.stepsBehaviour != null) {
                double floor = Math.floor((stepsToday / r3.getStepGoal()) * 100) / 100;
                if (1.0d <= floor) {
                    floor = 1.0d;
                }
                return (float) floor;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
        throw null;
    }

    public static final void onViewCreated$lambda$2(StepsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(this$0.getFirstActivityFragment(), false);
    }

    private final void update() {
        TextView textView = this.textStepsPercentage;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.steps_percentage_description, this.stepFormatHelper.formatPercent(getPercent())));
            DetailWatchPagerAdapter detailWatchPagerAdapter = this.pagerAdapter;
            if (detailWatchPagerAdapter != null) {
                Iterator<BaseDetailWatchPage> it = detailWatchPagerAdapter.getItems().iterator();
                while (it.hasNext()) {
                    it.next().updateHands(true);
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textStepsPercentage");
        throw null;
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
        if (getArguments() != null) {
            Behaviour behaviour = getBehaviourPlugin().getBehaviour();
            Intrinsics.checkNotNull(behaviour, "null cannot be cast to non-null type com.animaconnected.secondo.behaviour.steps.Steps");
            this.stepsBehaviour = (Steps) behaviour;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_details_steps, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.percentage_steps);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.textStepsPercentage = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.sub_complication_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.subComplicationText = (TextView) findViewById2;
        Behaviour behaviour = this.watchProvider.getBehaviours().getBehaviour(getType());
        SlotScalesHelper slotScalesHelper = SlotScalesHelper.INSTANCE;
        Capabilities capabilities = this.watchProvider.getCapabilities();
        Intrinsics.checkNotNull(behaviour);
        this.slotScales = slotScalesHelper.getSlotScales(capabilities, behaviour, getSlot());
        View findViewById3 = inflate.findViewById(R.id.detail_watch_layout_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        DetailWatchPager detailWatchPager = (DetailWatchPager) findViewById3;
        DetailWatchPagerAdapter detailWatchPagerAdapter = new DetailWatchPagerAdapter(getChildFragmentManager());
        this.pagerAdapter = detailWatchPagerAdapter;
        List<SlotScalesHelper.SlotScale> list = this.slotScales;
        if (list != null) {
            detailWatchPagerAdapter.setData(getPagerData(list));
            DetailWatchPagerAdapter detailWatchPagerAdapter2 = this.pagerAdapter;
            if (detailWatchPagerAdapter2 != null) {
                detailWatchPager.setAdapter(detailWatchPagerAdapter2);
                return inflate;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slotScales");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int r0;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Button button = (Button) view.findViewById(R.id.goto_activity);
        button.setOnClickListener(new StepsFragment$$ExternalSyntheticLambda0(this, 0));
        if (ProviderFactory.getSettingProvider().getActivityOnboardingCompleted()) {
            r0 = R.string.activity_open;
        } else {
            r0 = R.string.activity_activate;
        }
        button.setText(getText(r0));
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.overview_sub_dial_container);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.overview_crown_container);
        List<SlotScalesHelper.SlotScale> list = this.slotScales;
        if (list != null) {
            for (SlotScalesHelper.SlotScale slotScale : list) {
                if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                    if (slotScale.getScale() != Scale.ZeroToHundred) {
                        continue;
                    } else {
                        TextView textView = this.subComplicationText;
                        if (textView != null) {
                            textView.setText(R.string.sub_dial);
                            viewGroup.setVisibility(0);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("subComplicationText");
                            throw null;
                        }
                    }
                } else {
                    viewGroup2.setVisibility(0);
                }
            }
            if (viewGroup2.getVisibility() == 0 && viewGroup.getVisibility() == 0) {
                view.findViewById(R.id.slot_divider).setVisibility(0);
            }
            update();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slotScales");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void startRefreshing() {
        Steps steps = this.stepsBehaviour;
        if (steps != null) {
            steps.startRefreshing();
            Steps steps2 = this.stepsBehaviour;
            if (steps2 != null) {
                steps2.registerChangeListener(this);
                update();
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment
    public void stopRefreshing() {
        Steps steps = this.stepsBehaviour;
        if (steps != null) {
            steps.stopRefreshing();
            Steps steps2 = this.stepsBehaviour;
            if (steps2 != null) {
                steps2.unregisterChangeListener(this);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepsBehaviour");
        throw null;
    }
}

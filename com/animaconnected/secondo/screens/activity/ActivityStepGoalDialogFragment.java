package com.animaconnected.secondo.screens.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.ActivitySetGoalDialogFragmentBinding;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ActivityStepGoalDialogFragment.kt */
/* loaded from: classes3.dex */
public final class ActivityStepGoalDialogFragment extends BottomSheetBaseDialogFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final int GOAL_INTERVAL = 1000;
    private static final int MAX_GOAL = 30000;
    private static final int MIN_GOAL = 1000;
    private static final String STEP_GOAL = "stepGoal";

    /* compiled from: ActivityStepGoalDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActivityStepGoalDialogFragment newInstance(int r4) {
            ActivityStepGoalDialogFragment activityStepGoalDialogFragment = new ActivityStepGoalDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ActivityStepGoalDialogFragment.STEP_GOAL, r4);
            activityStepGoalDialogFragment.setArguments(bundle);
            return activityStepGoalDialogFragment;
        }

        private Companion() {
        }
    }

    private final List<Integer> createStepGoals() {
        return CollectionsKt___CollectionsKt.toList(RangesKt___RangesKt.step(new IntRange(1000, MAX_GOAL), 1000));
    }

    private final ActivityStepGoalDialogFragmentCallback getActivityStepGoalDialogFragmentCallback() {
        ActivityResultCaller parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragmentCallback");
        return (ActivityStepGoalDialogFragmentCallback) parentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$4$lambda$3$lambda$2(List stepGoals, NumberPicker numberPicker, ActivityStepGoalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(stepGoals, "$stepGoals");
        Intrinsics.checkNotNullParameter(numberPicker, "$numberPicker");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivityStepGoalDialogFragmentCallback().onStepGoalPicked(((Number) stepGoals.get(numberPicker.getValue())).intValue());
        this$0.dismiss();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        ActivitySetGoalDialogFragmentBinding inflate = ActivitySetGoalDialogFragmentBinding.inflate(dialog.getLayoutInflater());
        int r0 = requireArguments().getInt(STEP_GOAL);
        StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());
        final List<Integer> createStepGoals = createStepGoals();
        List<Integer> list = createStepGoals;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(stepFormatHelper.formatNumber(((Number) it.next()).intValue()));
        }
        final NumberPicker numberPicker = inflate.setGoalNumberPicker;
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(createStepGoals.size() - 1);
        numberPicker.setValue(createStepGoals.indexOf(Integer.valueOf(r0)));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        inflate.btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityStepGoalDialogFragment.onCreateDialogView$lambda$4$lambda$3$lambda$2(createStepGoals, numberPicker, this, view);
            }
        });
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }
}

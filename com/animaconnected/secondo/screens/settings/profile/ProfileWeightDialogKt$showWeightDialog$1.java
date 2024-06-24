package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.ProfileWeightDialogFragmentBinding;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.watch.fitness.FitnessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* compiled from: ProfileWeightDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileWeightDialogKt$showWeightDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Integer, Unit> $picked;
    final /* synthetic */ FitnessProvider.Profile $profile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileWeightDialogKt$showWeightDialog$1(FitnessProvider.Profile profile, Context context, Function1<? super Integer, Unit> function1) {
        super(2);
        this.$profile = profile;
        this.$context = context;
        this.$picked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2(WeightData weightData, ProfileWeightDialogFragmentBinding this_apply, Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(weightData, "$weightData");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        picked.invoke(weightData.getToGram().invoke(Integer.valueOf(((Number) CollectionsKt___CollectionsKt.toList(weightData.getRange()).get(this_apply.weightPicker.getValue())).intValue())));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$3(Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        picked.invoke(null);
        dialog.dismiss();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(final BottomDialog dialog, LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final WeightData weightData = this.$profile.getMeasurement() == FitnessProvider.Profile.Measurement.Metric ? ProfileWeightDialogKt.metricWeightData : ProfileWeightDialogKt.imperialWeightData;
        final ProfileWeightDialogFragmentBinding inflate = ProfileWeightDialogFragmentBinding.inflate(inflater);
        Context context = this.$context;
        FitnessProvider.Profile profile = this.$profile;
        final Function1<Integer, Unit> function1 = this.$picked;
        NumberPicker numberPicker = inflate.weightPicker;
        IntRange range = weightData.getRange();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(range, 10));
        Iterator<Integer> it = range.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((IntIterator) it).nextInt()));
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(CollectionsKt___CollectionsKt.count(weightData.getRange()) - 1);
        IntRange range2 = weightData.getRange();
        Integer invoke = weightData.getToWeight().invoke(profile.getWeight());
        numberPicker.setValue(CollectionsKt___CollectionsKt.indexOf(range2, Integer.valueOf(invoke != null ? invoke.intValue() : weightData.getDefault())));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        inflate.buttonConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$showWeightDialog$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileWeightDialogKt$showWeightDialog$1.invoke$lambda$4$lambda$2(WeightData.this, inflate, function1, dialog, view);
            }
        });
        inflate.buttonNotSay.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$showWeightDialog$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileWeightDialogKt$showWeightDialog$1.invoke$lambda$4$lambda$3(Function1.this, dialog, view);
            }
        });
        inflate.weightUnitText.setText(context.getText(weightData.getUnitStringRes()));
        return inflate;
    }
}

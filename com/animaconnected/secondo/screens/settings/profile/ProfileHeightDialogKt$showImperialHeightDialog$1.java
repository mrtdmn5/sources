package com.animaconnected.secondo.screens.settings.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.ProfileHeightImperialDialogFragmentBinding;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.workout.utils.FeetInches;
import com.animaconnected.watch.workout.utils.ProfileUtilsKt;
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

/* compiled from: ProfileHeightDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileHeightDialogKt$showImperialHeightDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ Function1<Integer, Unit> $picked;
    final /* synthetic */ FitnessProvider.Profile $profile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileHeightDialogKt$showImperialHeightDialog$1(FitnessProvider.Profile profile, Function1<? super Integer, Unit> function1) {
        super(2);
        this.$profile = profile;
        this.$picked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$6$lambda$4(ProfileHeightImperialDialogFragmentBinding this_apply, Function1 picked, BottomDialog dialog, View view) {
        IntRange intRange;
        IntRange intRange2;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        intRange = ProfileHeightDialogKt.feetRange;
        int intValue = ((Number) CollectionsKt___CollectionsKt.toList(intRange).get(this_apply.feetPicker.getValue())).intValue();
        intRange2 = ProfileHeightDialogKt.inchesRange;
        picked.invoke(Integer.valueOf(ProfileUtilsKt.toMm(new FeetInches(intValue, ((Number) CollectionsKt___CollectionsKt.toList(intRange2).get(this_apply.inchesPicker.getValue())).intValue()))));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$6$lambda$5(Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        picked.invoke(null);
        dialog.dismiss();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(final BottomDialog dialog, LayoutInflater inflater) {
        IntRange intRange;
        IntRange intRange2;
        IntRange intRange3;
        IntRange intRange4;
        IntRange intRange5;
        IntRange intRange6;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final ProfileHeightImperialDialogFragmentBinding inflate = ProfileHeightImperialDialogFragmentBinding.inflate(inflater);
        FitnessProvider.Profile profile = this.$profile;
        final Function1<Integer, Unit> function1 = this.$picked;
        NumberPicker numberPicker = inflate.feetPicker;
        intRange = ProfileHeightDialogKt.feetRange;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((IntIterator) it).nextInt()));
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setMinValue(0);
        intRange2 = ProfileHeightDialogKt.feetRange;
        numberPicker.setMaxValue(CollectionsKt___CollectionsKt.count(intRange2) - 1);
        intRange3 = ProfileHeightDialogKt.feetRange;
        Integer height = profile.getHeight();
        numberPicker.setValue(CollectionsKt___CollectionsKt.indexOf(intRange3, Integer.valueOf(ProfileUtilsKt.mmToFeetAndInches(height != null ? height.intValue() : 1700).getFeet())));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        NumberPicker numberPicker2 = inflate.inchesPicker;
        intRange4 = ProfileHeightDialogKt.inchesRange;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange4, 10));
        Iterator<Integer> it2 = intRange4.iterator();
        while (it2.hasNext()) {
            arrayList2.add(String.valueOf(((IntIterator) it2).nextInt()));
        }
        numberPicker2.setDisplayedValues((String[]) arrayList2.toArray(new String[0]));
        numberPicker2.setMinValue(0);
        intRange5 = ProfileHeightDialogKt.inchesRange;
        numberPicker2.setMaxValue(CollectionsKt___CollectionsKt.count(intRange5) - 1);
        intRange6 = ProfileHeightDialogKt.inchesRange;
        Integer height2 = profile.getHeight();
        numberPicker2.setValue(CollectionsKt___CollectionsKt.indexOf(intRange6, Integer.valueOf(ProfileUtilsKt.mmToFeetAndInches(height2 != null ? height2.intValue() : 1700).getInches())));
        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setDescendantFocusability(393216);
        inflate.buttonConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileHeightDialogKt$showImperialHeightDialog$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeightDialogKt$showImperialHeightDialog$1.invoke$lambda$6$lambda$4(ProfileHeightImperialDialogFragmentBinding.this, function1, dialog, view);
            }
        });
        inflate.buttonNotSay.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileHeightDialogKt$showImperialHeightDialog$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeightDialogKt$showImperialHeightDialog$1.invoke$lambda$6$lambda$5(Function1.this, dialog, view);
            }
        });
        return inflate;
    }
}

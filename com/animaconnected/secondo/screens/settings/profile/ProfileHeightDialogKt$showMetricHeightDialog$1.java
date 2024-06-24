package com.animaconnected.secondo.screens.settings.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.ProfileHeightMetricDialogFragmentBinding;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.watch.fitness.FitnessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class ProfileHeightDialogKt$showMetricHeightDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ Function1<Integer, Unit> $picked;
    final /* synthetic */ FitnessProvider.Profile $profile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileHeightDialogKt$showMetricHeightDialog$1(FitnessProvider.Profile profile, Function1<? super Integer, Unit> function1) {
        super(2);
        this.$profile = profile;
        this.$picked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2(ProfileHeightMetricDialogFragmentBinding this_apply, Function1 picked, BottomDialog dialog, View view) {
        IntRange intRange;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        intRange = ProfileHeightDialogKt.cmRange;
        picked.invoke(Integer.valueOf(((Number) CollectionsKt___CollectionsKt.toList(intRange).get(this_apply.heightPicker.getValue())).intValue() * 10));
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
        IntRange intRange;
        IntRange intRange2;
        IntRange intRange3;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final ProfileHeightMetricDialogFragmentBinding inflate = ProfileHeightMetricDialogFragmentBinding.inflate(inflater);
        FitnessProvider.Profile profile = this.$profile;
        final Function1<Integer, Unit> function1 = this.$picked;
        NumberPicker numberPicker = inflate.heightPicker;
        intRange = ProfileHeightDialogKt.cmRange;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((IntIterator) it).nextInt()));
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setMinValue(0);
        intRange2 = ProfileHeightDialogKt.cmRange;
        numberPicker.setMaxValue(CollectionsKt___CollectionsKt.count(intRange2) - 1);
        intRange3 = ProfileHeightDialogKt.cmRange;
        List list = CollectionsKt___CollectionsKt.toList(intRange3);
        Integer height = profile.getHeight();
        numberPicker.setValue(list.indexOf(Integer.valueOf((height != null ? height.intValue() : 1700) / 10)));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        inflate.buttonConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileHeightDialogKt$showMetricHeightDialog$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeightDialogKt$showMetricHeightDialog$1.invoke$lambda$4$lambda$2(ProfileHeightMetricDialogFragmentBinding.this, function1, dialog, view);
            }
        });
        inflate.buttonNotSay.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileHeightDialogKt$showMetricHeightDialog$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeightDialogKt$showMetricHeightDialog$1.invoke$lambda$4$lambda$3(Function1.this, dialog, view);
            }
        });
        return inflate;
    }
}

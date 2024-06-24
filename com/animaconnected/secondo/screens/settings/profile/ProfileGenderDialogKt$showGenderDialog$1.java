package com.animaconnected.secondo.screens.settings.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.ProfileGenderDialogFragmentBinding;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.watch.fitness.FitnessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ProfileGenderDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileGenderDialogKt$showGenderDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ Function1<FitnessProvider.Profile.Gender, Unit> $picked;
    final /* synthetic */ FitnessProvider.Profile $profile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileGenderDialogKt$showGenderDialog$1(FitnessProvider.Profile profile, Function1<? super FitnessProvider.Profile.Gender, Unit> function1) {
        super(2);
        this.$profile = profile;
        this.$picked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2(ProfileGenderDialogFragmentBinding this_apply, Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        picked.invoke((FitnessProvider.Profile.Gender) CollectionsKt___CollectionsKt.toList(ProfileGenderDialogKt.getGenderValues().keySet()).get(this_apply.genderPicker.getValue()));
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
        final ProfileGenderDialogFragmentBinding inflate = ProfileGenderDialogFragmentBinding.inflate(inflater);
        FitnessProvider.Profile profile = this.$profile;
        final Function1<FitnessProvider.Profile.Gender, Unit> function1 = this.$picked;
        NumberPicker numberPicker = inflate.genderPicker;
        Map<FitnessProvider.Profile.Gender, String> genderValues = ProfileGenderDialogKt.getGenderValues();
        ArrayList arrayList = new ArrayList(genderValues.size());
        Iterator<Map.Entry<FitnessProvider.Profile.Gender, String>> it = genderValues.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(ProfileGenderDialogKt.getGenderValues().size() - 1);
        List list = CollectionsKt___CollectionsKt.toList(ProfileGenderDialogKt.getGenderValues().keySet());
        FitnessProvider.Profile.Gender gender = profile.getGender();
        if (gender == null) {
            gender = FitnessProvider.Profile.Gender.Male;
        }
        numberPicker.setValue(list.indexOf(gender));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        inflate.buttonConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileGenderDialogKt$showGenderDialog$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileGenderDialogKt$showGenderDialog$1.invoke$lambda$4$lambda$2(ProfileGenderDialogFragmentBinding.this, function1, dialog, view);
            }
        });
        inflate.buttonNotSay.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileGenderDialogKt$showGenderDialog$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileGenderDialogKt$showGenderDialog$1.invoke$lambda$4$lambda$3(Function1.this, dialog, view);
            }
        });
        return inflate;
    }
}

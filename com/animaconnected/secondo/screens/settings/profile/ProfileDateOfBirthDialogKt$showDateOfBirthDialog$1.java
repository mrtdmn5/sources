package com.animaconnected.secondo.screens.settings.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.ProfileDateOfBirthDialogFragmentBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.watch.fitness.FitnessProvider;
import j$.time.Month;
import j$.time.YearMonth;
import j$.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

/* compiled from: ProfileDateOfBirthDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ Function1<Long, Unit> $picked;
    final /* synthetic */ FitnessProvider.Profile $profile;

    /* compiled from: ProfileDateOfBirthDialog.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Month> entries$0 = EnumEntriesKt.enumEntries(Month.values());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1(FitnessProvider.Profile profile, Function1<? super Long, Unit> function1) {
        super(2);
        this.$profile = profile;
        this.$picked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$14$lambda$12(Calendar calendar, IntRange yearsValues, ProfileDateOfBirthDialogFragmentBinding this_apply, Ref$ObjectRef days, Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(yearsValues, "$yearsValues");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(days, "$days");
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        calendar.set(((Number) CollectionsKt___CollectionsKt.toList(yearsValues).get(this_apply.yearPicker.getValue())).intValue(), this_apply.monthPicker.getValue(), ((Number) CollectionsKt___CollectionsKt.toList((Iterable) days.element).get(this_apply.dayPicker.getValue())).intValue());
        picked.invoke(Long.valueOf(calendar.getTimeInMillis()));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$14$lambda$13(Function1 picked, BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(picked, "$picked");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        picked.invoke(null);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$14$lambda$6$lambda$5(Function0 updateDays, NumberPicker numberPicker, int r2, int r3) {
        Intrinsics.checkNotNullParameter(updateDays, "$updateDays");
        updateDays.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$14$lambda$9$lambda$8(Function0 updateDays, NumberPicker numberPicker, int r2, int r3) {
        Intrinsics.checkNotNullParameter(updateDays, "$updateDays");
        updateDays.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, kotlin.ranges.IntRange] */
    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(final BottomDialog dialog, LayoutInflater inflater) {
        Calendar calendar;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final Calendar calendar2 = Calendar.getInstance();
        int r4 = calendar2.get(1);
        final IntRange intRange = new IntRange(r4 - 125, r4 - 15);
        EnumEntries<Month> enumEntries = EntriesMappings.entries$0;
        final ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(enumEntries, 10));
        for (Month month : enumEntries) {
            arrayList.add(new Pair(month, month.getDisplayName(TextStyle.FULL_STANDALONE, ProviderFactory.createConfigProvider().getTranslationCompatibleLocale())));
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new IntRange(1, 31);
        Long dateOfBirth = this.$profile.getDateOfBirth();
        if (dateOfBirth != null) {
            long longValue = dateOfBirth.longValue();
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(longValue);
        } else {
            calendar2.add(1, -30);
            calendar = calendar2;
        }
        final ProfileDateOfBirthDialogFragmentBinding inflate = ProfileDateOfBirthDialogFragmentBinding.inflate(inflater);
        final Function1<Long, Unit> function1 = this.$picked;
        final Function0<NumberPicker> function0 = new Function0<NumberPicker>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1$1$updateDays$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlin.ranges.IntRange] */
            @Override // kotlin.jvm.functions.Function0
            public final NumberPicker invoke() {
                ref$ObjectRef.element = new IntRange(1, YearMonth.of(((Number) CollectionsKt___CollectionsKt.toList(intRange).get(inflate.yearPicker.getValue())).intValue(), (Month) ((Pair) CollectionsKt___CollectionsKt.toList(arrayList).get(inflate.monthPicker.getValue())).first).lengthOfMonth());
                NumberPicker numberPicker = inflate.dayPicker;
                Ref$ObjectRef<IntRange> ref$ObjectRef2 = ref$ObjectRef;
                numberPicker.setValue(Math.min(CollectionsKt___CollectionsKt.count(ref$ObjectRef2.element) - 1, numberPicker.getValue()));
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(CollectionsKt___CollectionsKt.count(ref$ObjectRef2.element) - 1);
                return numberPicker;
            }
        };
        NumberPicker numberPicker = inflate.yearPicker;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((IntIterator) it).nextInt()));
        }
        numberPicker.setDisplayedValues((String[]) arrayList2.toArray(new String[0]));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(CollectionsKt___CollectionsKt.count(intRange) - 1);
        numberPicker.setValue(CollectionsKt___CollectionsKt.indexOf(intRange, Integer.valueOf(calendar.get(1))));
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1$$ExternalSyntheticLambda0
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int r3, int r42) {
                ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1.invoke$lambda$14$lambda$6$lambda$5(Function0.this, numberPicker2, r3, r42);
            }
        });
        NumberPicker numberPicker2 = inflate.monthPicker;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((String) ((Pair) it2.next()).second);
        }
        numberPicker2.setDisplayedValues((String[]) arrayList3.toArray(new String[0]));
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(arrayList.size() - 1);
        numberPicker2.setValue(calendar.get(2));
        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setDescendantFocusability(393216);
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1$$ExternalSyntheticLambda1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker3, int r3, int r42) {
                ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1.invoke$lambda$14$lambda$9$lambda$8(Function0.this, numberPicker3, r3, r42);
            }
        });
        NumberPicker numberPicker3 = inflate.dayPicker;
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(CollectionsKt___CollectionsKt.count((Iterable) ref$ObjectRef.element) - 1);
        numberPicker3.setValue(calendar.get(5) - 1);
        Iterable iterable = (Iterable) ref$ObjectRef.element;
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(iterable, 10));
        Iterator it3 = iterable.iterator();
        while (it3.hasNext()) {
            arrayList4.add(String.valueOf(((Number) it3.next()).intValue()));
        }
        numberPicker3.setDisplayedValues((String[]) arrayList4.toArray(new String[0]));
        numberPicker3.setWrapSelectorWheel(false);
        numberPicker3.setDescendantFocusability(393216);
        function0.invoke();
        inflate.buttonConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1.invoke$lambda$14$lambda$12(calendar2, intRange, inflate, ref$ObjectRef, function1, dialog, view);
            }
        });
        inflate.buttonNotSay.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1.invoke$lambda$14$lambda$13(Function1.this, dialog, view);
            }
        });
        return inflate;
    }
}

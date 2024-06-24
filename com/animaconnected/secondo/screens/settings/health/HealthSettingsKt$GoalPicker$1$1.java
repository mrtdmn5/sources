package com.animaconnected.secondo.screens.settings.health;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.animaconnected.secondo.databinding.ActivitySetGoalDialogFragmentBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: HealthSettings.kt */
/* loaded from: classes3.dex */
public final class HealthSettingsKt$GoalPicker$1$1 extends Lambda implements Function1<Context, LinearLayout> {
    final /* synthetic */ int $currentValue;
    final /* synthetic */ Ref$IntRef $index;
    final /* synthetic */ Function1<Integer, Unit> $onConfirmGoalClick;
    final /* synthetic */ String $title;
    final /* synthetic */ List<Integer> $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HealthSettingsKt$GoalPicker$1$1(String str, List<Integer> list, int r3, Ref$IntRef ref$IntRef, Function1<? super Integer, Unit> function1) {
        super(1);
        this.$title = str;
        this.$values = list;
        this.$currentValue = r3;
        this.$index = ref$IntRef;
        this.$onConfirmGoalClick = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2$lambda$1(Ref$IntRef index, NumberPicker numberPicker, int r2, int r3) {
        Intrinsics.checkNotNullParameter(index, "$index");
        index.element = numberPicker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$3(List values, Ref$IntRef index, int r2, Function1 onConfirmGoalClick, View view) {
        Intrinsics.checkNotNullParameter(values, "$values");
        Intrinsics.checkNotNullParameter(index, "$index");
        Intrinsics.checkNotNullParameter(onConfirmGoalClick, "$onConfirmGoalClick");
        Integer num = (Integer) CollectionsKt___CollectionsKt.getOrNull(index.element, values);
        if (num != null) {
            r2 = num.intValue();
        }
        onConfirmGoalClick.invoke(Integer.valueOf(r2));
    }

    @Override // kotlin.jvm.functions.Function1
    public final LinearLayout invoke(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ActivitySetGoalDialogFragmentBinding inflate = ActivitySetGoalDialogFragmentBinding.inflate(LayoutInflater.from(it), null, false);
        String str = this.$title;
        final List<Integer> list = this.$values;
        final int r3 = this.$currentValue;
        final Ref$IntRef ref$IntRef = this.$index;
        final Function1<Integer, Unit> function1 = this.$onConfirmGoalClick;
        inflate.title.setText(str);
        NumberPicker numberPicker = inflate.setGoalNumberPicker;
        numberPicker.setDescendantFocusability(393216);
        numberPicker.setMaxValue(CollectionsKt__CollectionsKt.getLastIndex(list));
        numberPicker.setMinValue(0);
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(((Number) it2.next()).intValue()));
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalPicker$1$1$$ExternalSyntheticLambda0
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int r32, int r4) {
                HealthSettingsKt$GoalPicker$1$1.invoke$lambda$4$lambda$2$lambda$1(Ref$IntRef.this, numberPicker2, r32, r4);
            }
        });
        numberPicker.setValue(list.indexOf(Integer.valueOf(r3)));
        inflate.btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalPicker$1$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HealthSettingsKt$GoalPicker$1$1.invoke$lambda$4$lambda$3(list, ref$IntRef, r3, function1, view);
            }
        });
        return inflate.getRoot();
    }
}

package com.animaconnected.secondo.screens.debugsettings;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyDsl.kt */
/* loaded from: classes3.dex */
public final class DebugWatchThemeFragment$ThemePicker$4$invoke$$inlined$itemsIndexed$default$1 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugWatchThemeFragment$ThemePicker$4$invoke$$inlined$itemsIndexed$default$1(Function2 function2, List list) {
        super(1);
        this.$key = function2;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int r4) {
        return this.$key.invoke(Integer.valueOf(r4), this.$items.get(r4));
    }
}

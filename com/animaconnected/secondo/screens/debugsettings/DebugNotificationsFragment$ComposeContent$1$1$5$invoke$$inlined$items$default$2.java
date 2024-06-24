package com.animaconnected.secondo.screens.debugsettings;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyDsl.kt */
/* loaded from: classes3.dex */
public final class DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$2 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$2(Function1 function1, List list) {
        super(1);
        this.$key = function1;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int r3) {
        return this.$key.invoke(this.$items.get(r3));
    }
}

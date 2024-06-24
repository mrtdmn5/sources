package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutPager.kt */
/* loaded from: classes.dex */
public final class PagerIntervalContent implements LazyLayoutIntervalContent.Interval {
    public final Function4<PagerScope, Integer, Composer, Integer, Unit> item;
    public final Function1<Integer, Object> key;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerIntervalContent(Function1<? super Integer, ? extends Object> function1, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.key = function1;
        this.item = item;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public final Function1<Integer, Object> getKey() {
        return this.key;
    }
}

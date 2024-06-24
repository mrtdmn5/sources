package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutPager.kt */
/* loaded from: classes.dex */
public final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent<PagerIntervalContent> {
    public final MutableIntervalList intervals;
    public final Function1<Integer, Object> key;
    public final Function4<PagerScope, Integer, Composer, Integer, Unit> pageContent;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerLayoutIntervalContent(Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Function1<? super Integer, ? extends Object> function1, int r5) {
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        this.pageContent = pageContent;
        this.key = function1;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        mutableIntervalList.addInterval(r5, new PagerIntervalContent(function1, pageContent));
        this.intervals = mutableIntervalList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final MutableIntervalList getIntervals$1() {
        return this.intervals;
    }
}

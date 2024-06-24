package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* compiled from: LazyListIntervalContent.kt */
/* loaded from: classes.dex */
public final class LazyListInterval implements LazyLayoutIntervalContent.Interval {
    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> item;
    public final Function1<Integer, Object> key;
    public final Function1<Integer, Object> type;

    public LazyListInterval(Function1 function1, Function1 function12, ComposableLambdaImpl composableLambdaImpl) {
        this.key = function1;
        this.type = function12;
        this.item = composableLambdaImpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public final Function1<Integer, Object> getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public final Function1<Integer, Object> getType() {
        return this.type;
    }
}

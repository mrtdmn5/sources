package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.layout.Remeasurement;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyListState.kt */
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$scrollToItem$2", f = "LazyListState.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LazyListState$scrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ int $scrollOffset;
    public final /* synthetic */ LazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListState$scrollToItem$2(LazyListState lazyListState, int r2, int r3, Continuation<? super LazyListState$scrollToItem$2> continuation) {
        super(2, continuation);
        this.this$0 = lazyListState;
        this.$index = r2;
        this.$scrollOffset = r3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyListState$scrollToItem$2(this.this$0, this.$index, this.$scrollOffset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyListState$scrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        LazyListState lazyListState = this.this$0;
        LazyListScrollPosition lazyListScrollPosition = lazyListState.scrollPosition;
        lazyListScrollPosition.update(this.$index, this.$scrollOffset);
        lazyListScrollPosition.lastKnownFirstItemKey = null;
        LazyListItemPlacementAnimator lazyListItemPlacementAnimator = lazyListState.placementAnimator;
        lazyListItemPlacementAnimator.activeKeys.clear();
        lazyListItemPlacementAnimator.keyIndexMap = LazyLayoutKeyIndexMap.Empty.$$INSTANCE;
        lazyListItemPlacementAnimator.firstVisibleIndex = -1;
        Remeasurement remeasurement = lazyListState.remeasurement;
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
        return Unit.INSTANCE;
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ScrollableState.kt */
/* loaded from: classes.dex */
public final class DefaultScrollableState implements ScrollableState {
    public final Function1<Float, Float> onDelta;
    public final DefaultScrollableState$scrollScope$1 scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public final float scrollBy(float f) {
            if (Float.isNaN(f)) {
                return 0.0f;
            }
            return DefaultScrollableState.this.onDelta.invoke(Float.valueOf(f)).floatValue();
        }
    };
    public final MutatorMutex scrollMutex = new MutatorMutex();
    public final ParcelableSnapshotMutableState isScrollingState = Platform.mutableStateOf$default(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1] */
    public DefaultScrollableState(Function1<? super Float, Float> function1) {
        this.onDelta = function1;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.onDelta.invoke(Float.valueOf(f)).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return ((Boolean) this.isScrollingState.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultScrollableState$scroll$2(this, mutatePriority, function2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}

package androidx.compose.ui.platform;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.MotionDurationScale;
import com.google.common.base.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public final class MotionDurationScaleImpl implements MotionDurationScale {
    public final ParcelableSnapshotMutableFloatState scaleFactor$delegate = Objects.mutableFloatStateOf(1.0f);

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(r, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public final float getScaleFactor() {
        return this.scaleFactor$delegate.getFloatValue();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }
}

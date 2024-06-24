package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.StructuralEqualityPolicy;
import com.google.common.base.Objects;
import com.google.common.collect.Platform;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;
    public final ParcelableSnapshotMutableState anchors$delegate;
    public final AnimationSpec<Float> animationSpec;
    public final ParcelableSnapshotMutableState animationTarget$delegate;
    public final DerivedSnapshotState closestValue$delegate;
    public final Function1<T, Boolean> confirmValueChange;
    public final ParcelableSnapshotMutableState currentValue$delegate;
    public final InternalMutatorMutex dragMutex;
    public final AnchoredDraggableState$draggableState$1 draggableState;
    public final ParcelableSnapshotMutableFloatState lastVelocity$delegate;
    public final DerivedSnapshotState maxOffset$delegate;
    public final DerivedSnapshotState minOffset$delegate;
    public final ParcelableSnapshotMutableState offset$delegate;
    public final Function1<Float, Float> positionalThreshold;
    public final DerivedSnapshotState targetValue$delegate;
    public final Function0<Float> velocityThreshold;

    /* compiled from: AnchoredDraggable.kt */
    /* renamed from: androidx.compose.material.AnchoredDraggableState$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Lambda implements Function1<Object, Boolean> {
        public static final AnonymousClass1 INSTANCE = ;

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: AnchoredDraggable.kt */
    /* loaded from: classes.dex */
    public interface AnchorChangedCallback<T> {
        void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t, Function1<? super Float, Float> positionalThreshold, Function0<Float> function0, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = function0;
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue$delegate = Platform.mutableStateOf$default(t);
        this.targetValue$delegate = Platform.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$targetValue$2
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T currentValue;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                T value = anchoredDraggableState.animationTarget$delegate.getValue();
                if (value == null) {
                    float offset = anchoredDraggableState.getOffset();
                    if (!Float.isNaN(offset)) {
                        currentValue = (T) anchoredDraggableState.computeTarget(offset, 0.0f, anchoredDraggableState.getCurrentValue());
                    } else {
                        currentValue = anchoredDraggableState.getCurrentValue();
                    }
                    return currentValue;
                }
                return value;
            }
        });
        this.closestValue$delegate = Platform.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$closestValue$2
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object access$closestAnchor;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                T value = anchoredDraggableState.animationTarget$delegate.getValue();
                if (value == null) {
                    float offset = anchoredDraggableState.getOffset();
                    if (!Float.isNaN(offset)) {
                        T currentValue = anchoredDraggableState.getCurrentValue();
                        Map<T, Float> anchors$material_release = anchoredDraggableState.getAnchors$material_release();
                        Float f = anchors$material_release.get(currentValue);
                        if (!Intrinsics.areEqual(f, offset) && f != null) {
                            if (f.floatValue() < offset) {
                                access$closestAnchor = AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, true);
                            } else {
                                access$closestAnchor = AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, false);
                            }
                            return (T) access$closestAnchor;
                        }
                        return currentValue;
                    }
                    return anchoredDraggableState.getCurrentValue();
                }
                return value;
            }
        });
        this.offset$delegate = Platform.mutableStateOf$default(Float.valueOf(Float.NaN));
        Platform.derivedStateOf(StructuralEqualityPolicy.INSTANCE, new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$progress$2
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float f;
                float f2;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                Float f3 = (Float) anchoredDraggableState.getAnchors$material_release().get(anchoredDraggableState.getCurrentValue());
                float f4 = 0.0f;
                if (f3 != null) {
                    f = f3.floatValue();
                } else {
                    f = 0.0f;
                }
                Float f5 = (Float) anchoredDraggableState.getAnchors$material_release().get(anchoredDraggableState.closestValue$delegate.getValue());
                if (f5 != null) {
                    f2 = f5.floatValue();
                } else {
                    f2 = 0.0f;
                }
                float f6 = f2 - f;
                if (Math.abs(f6) > 1.0E-6f) {
                    float requireOffset = (anchoredDraggableState.requireOffset() - f) / f6;
                    if (requireOffset >= 1.0E-6f) {
                        if (requireOffset <= 0.999999f) {
                            f4 = requireOffset;
                        }
                    }
                    return Float.valueOf(f4);
                }
                f4 = 1.0f;
                return Float.valueOf(f4);
            }
        });
        this.lastVelocity$delegate = Objects.mutableFloatStateOf(0.0f);
        this.minOffset$delegate = Platform.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$minOffset$2
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float valueOf;
                float f;
                Iterator it = this.this$0.getAnchors$material_release().entrySet().iterator();
                if (!it.hasNext()) {
                    valueOf = null;
                } else {
                    float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                    while (it.hasNext()) {
                        floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                    }
                    valueOf = Float.valueOf(floatValue);
                }
                if (valueOf != null) {
                    f = valueOf.floatValue();
                } else {
                    f = Float.NEGATIVE_INFINITY;
                }
                return Float.valueOf(f);
            }
        });
        this.maxOffset$delegate = Platform.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$maxOffset$2
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float valueOf;
                float f;
                Iterator it = this.this$0.getAnchors$material_release().entrySet().iterator();
                if (!it.hasNext()) {
                    valueOf = null;
                } else {
                    float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                    while (it.hasNext()) {
                        floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                    }
                    valueOf = Float.valueOf(floatValue);
                }
                if (valueOf != null) {
                    f = valueOf.floatValue();
                } else {
                    f = Float.POSITIVE_INFINITY;
                }
                return Float.valueOf(f);
            }
        });
        this.animationTarget$delegate = Platform.mutableStateOf$default(null);
        this.anchors$delegate = Platform.mutableStateOf$default(EmptyMap.INSTANCE);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public final Object computeTarget(float f, float f2, Object obj) {
        Object access$closestAnchor;
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        Float f3 = anchors$material_release.get(obj);
        float floatValue = this.velocityThreshold.invoke().floatValue();
        if (!Intrinsics.areEqual(f3, f) && f3 != null) {
            float floatValue2 = f3.floatValue();
            Function1<Float, Float> function1 = this.positionalThreshold;
            if (floatValue2 < f) {
                if (f2 >= floatValue) {
                    return AnchoredDraggableKt.access$closestAnchor(anchors$material_release, f, true);
                }
                access$closestAnchor = AnchoredDraggableKt.access$closestAnchor(anchors$material_release, f, true);
                if (f < Math.abs(f3.floatValue() + Math.abs(function1.invoke(Float.valueOf(Math.abs(((Number) MapsKt__MapsKt.getValue(access$closestAnchor, anchors$material_release)).floatValue() - f3.floatValue()))).floatValue()))) {
                    return obj;
                }
            } else {
                if (f2 <= (-floatValue)) {
                    return AnchoredDraggableKt.access$closestAnchor(anchors$material_release, f, false);
                }
                access$closestAnchor = AnchoredDraggableKt.access$closestAnchor(anchors$material_release, f, false);
                float abs = Math.abs(f3.floatValue() - Math.abs(function1.invoke(Float.valueOf(Math.abs(f3.floatValue() - ((Number) MapsKt__MapsKt.getValue(access$closestAnchor, anchors$material_release)).floatValue()))).floatValue()));
                if (f < 0.0f) {
                    if (Math.abs(f) < abs) {
                        return obj;
                    }
                } else if (f > abs) {
                    return obj;
                }
            }
            return access$closestAnchor;
        }
        return obj;
    }

    public final float dispatchRawDelta(float f) {
        float offset;
        float newOffsetForDelta$material_release = newOffsetForDelta$material_release(f);
        if (Float.isNaN(getOffset())) {
            offset = 0.0f;
        } else {
            offset = getOffset();
        }
        this.offset$delegate.setValue(Float.valueOf(newOffsetForDelta$material_release));
        return newOffsetForDelta$material_release - offset;
    }

    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    public final float newOffsetForDelta$material_release(float f) {
        float offset;
        if (Float.isNaN(getOffset())) {
            offset = 0.0f;
        } else {
            offset = getOffset();
        }
        return RangesKt___RangesKt.coerceIn(offset + f, ((Number) this.minOffset$delegate.getValue()).floatValue(), ((Number) this.maxOffset$delegate.getValue()).floatValue());
    }

    public final float requireOffset() {
        if (!Float.isNaN(getOffset())) {
            return getOffset();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final Object settle(float f, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        Object computeTarget = computeTarget(requireOffset(), f, currentValue);
        if (((Boolean) this.confirmValueChange.invoke(computeTarget)).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(f, this, computeTarget, continuation);
            if (animateTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return animateTo;
            }
            return Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(f, this, currentValue, continuation);
        if (animateTo2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateTo2;
        }
        return Unit.INSTANCE;
    }

    public final boolean trySnapTo$material_release(final T t) {
        Function0<Unit> function0 = new Function0<Unit>(this) { // from class: androidx.compose.material.AnchoredDraggableState$trySnapTo$1
            public final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = anchoredDraggableState.anchoredDragScope;
                Map anchors$material_release = anchoredDraggableState.getAnchors$material_release();
                Object obj = t;
                Float f = (Float) anchors$material_release.get(obj);
                if (f != null) {
                    anchoredDraggableState$anchoredDragScope$1.dragTo(f.floatValue(), 0.0f);
                    anchoredDraggableState.animationTarget$delegate.setValue(null);
                }
                anchoredDraggableState.currentValue$delegate.setValue(obj);
                return Unit.INSTANCE;
            }
        };
        InternalMutatorMutex internalMutatorMutex = this.dragMutex;
        internalMutatorMutex.getClass();
        MutexImpl mutexImpl = internalMutatorMutex.mutex;
        boolean tryLock = mutexImpl.tryLock(null);
        if (tryLock) {
            try {
                function0.invoke();
            } finally {
                mutexImpl.unlock(null);
            }
        }
        return tryLock;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateAnchors$material_release(Map<T, Float> newAnchors, AnchorChangedCallback<T> anchorChangedCallback) {
        boolean z;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (!Intrinsics.areEqual(getAnchors$material_release(), newAnchors)) {
            Map<T, Float> anchors$material_release = getAnchors$material_release();
            Object value = this.targetValue$delegate.getValue();
            boolean isEmpty = getAnchors$material_release().isEmpty();
            this.anchors$delegate.setValue(newAnchors);
            if (getAnchors$material_release().get(getCurrentValue()) != null) {
                z = true;
            } else {
                z = false;
            }
            if (isEmpty && z) {
                trySnapTo$material_release(getCurrentValue());
            } else if (anchorChangedCallback != 0) {
                anchorChangedCallback.onAnchorsChanged(value, anchors$material_release, newAnchors);
            }
        }
    }
}

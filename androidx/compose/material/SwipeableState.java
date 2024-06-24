package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultDraggableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.base.Objects;
import com.google.common.collect.Platform;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: Swipeable.kt */
/* loaded from: classes.dex */
public final class SwipeableState<T> {
    public final ParcelableSnapshotMutableFloatState absoluteOffset;
    public final ParcelableSnapshotMutableState anchors$delegate;
    public final AnimationSpec<Float> animationSpec;
    public final ParcelableSnapshotMutableState animationTarget;
    public final Function1<T, Boolean> confirmStateChange;
    public final ParcelableSnapshotMutableState currentValue$delegate;
    public final DefaultDraggableState draggableState;
    public final ParcelableSnapshotMutableState isAnimationRunning$delegate;
    public final FlowKt__LimitKt$take$$inlined$unsafeFlow$1 latestNonEmptyAnchorsFlow;
    public float maxBound;
    public float minBound;
    public final ParcelableSnapshotMutableFloatState offsetState;
    public final ParcelableSnapshotMutableFloatState overflowState;
    public final ParcelableSnapshotMutableState resistance$delegate;
    public final ParcelableSnapshotMutableState thresholds$delegate;
    public final ParcelableSnapshotMutableFloatState velocityThreshold$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.material.SwipeableState$draggableState$1] */
    public SwipeableState(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        this.currentValue$delegate = Platform.mutableStateOf$default(t);
        this.isAnimationRunning$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
        this.offsetState = Objects.mutableFloatStateOf(0.0f);
        this.overflowState = Objects.mutableFloatStateOf(0.0f);
        this.absoluteOffset = Objects.mutableFloatStateOf(0.0f);
        this.animationTarget = Platform.mutableStateOf$default(null);
        this.anchors$delegate = Platform.mutableStateOf$default(EmptyMap.INSTANCE);
        final SafeFlow snapshotFlow = Platform.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            public final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return (Map) this.this$0.anchors$delegate.getValue();
            }
        });
        this.latestNonEmptyAnchorsFlow = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(new Flow<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            /* renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                public final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "androidx.compose.material.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", l = {223}, m = "emit")
                /* renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = (androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = new androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        r6 = r5
                        java.util.Map r6 = (java.util.Map) r6
                        boolean r6 = r6.isEmpty()
                        r6 = r6 ^ r3
                        if (r6 == 0) goto L47
                        r0.label = r3
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = snapshotFlow.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = Platform.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableState$thresholds$2
            @Override // kotlin.jvm.functions.Function2
            public final Float invoke(Float f, Float f2) {
                f.floatValue();
                f2.floatValue();
                return Float.valueOf(0.0f);
            }
        });
        this.velocityThreshold$delegate = Objects.mutableFloatStateOf(0.0f);
        this.resistance$delegate = Platform.mutableStateOf$default(null);
        this.draggableState = new DefaultDraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableState$draggableState$1
            public final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f) {
                boolean z;
                float floatValue = f.floatValue();
                SwipeableState<T> swipeableState = this.this$0;
                float floatValue2 = swipeableState.absoluteOffset.getFloatValue() + floatValue;
                float coerceIn = RangesKt___RangesKt.coerceIn(floatValue2, swipeableState.minBound, swipeableState.maxBound);
                float f2 = floatValue2 - coerceIn;
                ResistanceConfig resistanceConfig = (ResistanceConfig) swipeableState.resistance$delegate.getValue();
                float f3 = 0.0f;
                if (resistanceConfig != null) {
                    int r5 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    resistanceConfig.getClass();
                    if (0.0f == 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        resistanceConfig.getClass();
                        f3 = (0.0f / 0.0f) * ((float) Math.sin((RangesKt___RangesKt.coerceIn(f2 / 0.0f, -1.0f, 1.0f) * 3.1415927f) / 2));
                    }
                }
                swipeableState.offsetState.setFloatValue(coerceIn + f3);
                swipeableState.overflowState.setFloatValue(f2);
                swipeableState.absoluteOffset.setFloatValue(floatValue2);
                return Unit.INSTANCE;
            }
        });
    }

    public static Object animateTo$default(SwipeableState swipeableState, Object obj, Continuation continuation) {
        Object collect = swipeableState.latestNonEmptyAnchorsFlow.collect(new SwipeableState$animateTo$2(obj, swipeableState, swipeableState.animationSpec), continuation);
        if (collect != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object drag;
        drag = this.draggableState.drag(MutatePriority.Default, new SwipeableState$animateInternalToOffset$2(this, f, animationSpec, null), continuation);
        if (drag == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return drag;
        }
        return Unit.INSTANCE;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x022c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0228 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #4 {all -> 0x004f, blocks: (B:26:0x004a, B:30:0x020a, B:36:0x0228), top: B:25:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processNewAnchors$material_release(java.util.Map<java.lang.Float, ? extends T> r11, java.util.Map<java.lang.Float, ? extends T> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.processNewAnchors$material_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }
}

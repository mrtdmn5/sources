package androidx.compose.material;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;

/* compiled from: Swipeable.kt */
@DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$4$1", f = "Swipeable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SwipeableKt$swipeable$3$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    public final /* synthetic */ SwipeableState<Object> $state;
    public /* synthetic */ float F$0;
    public /* synthetic */ CoroutineScope L$0;

    /* compiled from: Swipeable.kt */
    @DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$4$1$1", f = "Swipeable.kt", l = {616}, m = "invokeSuspend")
    /* renamed from: androidx.compose.material.SwipeableKt$swipeable$3$4$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ SwipeableState<Object> $state;
        public final /* synthetic */ float $velocity;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, SwipeableState swipeableState, Continuation continuation) {
            super(2, continuation);
            this.$state = swipeableState;
            this.$velocity = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$velocity, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                final SwipeableState<Object> swipeableState = this.$state;
                FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$1 = swipeableState.latestNonEmptyAnchorsFlow;
                final float f = this.$velocity;
                Object collect = flowKt__LimitKt$take$$inlined$unsafeFlow$1.collect(new FlowCollector<Map<Float, Object>>() { // from class: androidx.compose.material.SwipeableState$performFling$2
                    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6  */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0180  */
                    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:62:0x0149  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.util.Map<java.lang.Float, java.lang.Object> r19, kotlin.coroutines.Continuation r20) {
                        /*
                            Method dump skipped, instructions count: 387
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$performFling$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }, this);
                if (collect != coroutineSingletons) {
                    collect = Unit.INSTANCE;
                }
                if (collect == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeable$3$4$1(SwipeableState<Object> swipeableState, Continuation<? super SwipeableKt$swipeable$3$4$1> continuation) {
        super(3, continuation);
        this.$state = swipeableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
        float floatValue = f.floatValue();
        SwipeableKt$swipeable$3$4$1 swipeableKt$swipeable$3$4$1 = new SwipeableKt$swipeable$3$4$1(this.$state, continuation);
        swipeableKt$swipeable$3$4$1.L$0 = coroutineScope;
        swipeableKt$swipeable$3$4$1.F$0 = floatValue;
        return swipeableKt$swipeable$3$4$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        BuildersKt.launch$default(this.L$0, null, null, new AnonymousClass1(this.F$0, this.$state, null), 3);
        return Unit.INSTANCE;
    }
}

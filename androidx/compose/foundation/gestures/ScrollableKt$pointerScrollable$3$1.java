package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
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

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1", f = "Scrollable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollableKt$pointerScrollable$3$1 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<NestedScrollDispatcher> $nestedScrollDispatcher;
    public final /* synthetic */ State<ScrollingLogic> $scrollLogic;
    public /* synthetic */ long J$0;

    /* compiled from: Scrollable.kt */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1", f = "Scrollable.kt", l = {286}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ State<ScrollingLogic> $scrollLogic;
        public final /* synthetic */ long $velocity;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(State<ScrollingLogic> state, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scrollLogic = state;
            this.$velocity = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$scrollLogic, this.$velocity, continuation);
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
                ScrollingLogic value = this.$scrollLogic.getValue();
                this.label = 1;
                if (value.m56onDragStoppedsFctU(this.$velocity, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$pointerScrollable$3$1(MutableState<NestedScrollDispatcher> mutableState, State<ScrollingLogic> state, Continuation<? super ScrollableKt$pointerScrollable$3$1> continuation) {
        super(3, continuation);
        this.$nestedScrollDispatcher = mutableState;
        this.$scrollLogic = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Velocity velocity, Continuation<? super Unit> continuation) {
        long j = velocity.packedValue;
        ScrollableKt$pointerScrollable$3$1 scrollableKt$pointerScrollable$3$1 = new ScrollableKt$pointerScrollable$3$1(this.$nestedScrollDispatcher, this.$scrollLogic, continuation);
        scrollableKt$pointerScrollable$3$1.J$0 = j;
        return scrollableKt$pointerScrollable$3$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        BuildersKt.launch$default(this.$nestedScrollDispatcher.getValue().getCoroutineScope(), null, null, new AnonymousClass1(this.$scrollLogic, this.J$0, null), 3);
        return Unit.INSTANCE;
    }
}

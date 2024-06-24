package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.MutatorMutex$mutateWith$2;
import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ScrollableState.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2", f = "ScrollableState.kt", l = {R.styleable.AppTheme_topPusherDropZoneSelected}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultScrollableState$scroll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<ScrollScope, Continuation<? super Unit>, Object> $block;
    public final /* synthetic */ MutatePriority $scrollPriority;
    public int label;
    public final /* synthetic */ DefaultScrollableState this$0;

    /* compiled from: ScrollableState.kt */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1", f = "ScrollableState.kt", l = {R.styleable.AppTheme_workoutDetailTintColor}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function2<ScrollScope, Continuation<? super Unit>, Object> $block;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ DefaultScrollableState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DefaultScrollableState defaultScrollableState, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = defaultScrollableState;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            DefaultScrollableState defaultScrollableState = this.this$0;
            try {
                if (r1 != 0) {
                    if (r1 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ScrollScope scrollScope = (ScrollScope) this.L$0;
                    defaultScrollableState.isScrollingState.setValue(Boolean.TRUE);
                    Function2<ScrollScope, Continuation<? super Unit>, Object> function2 = this.$block;
                    this.label = 1;
                    if (function2.invoke(scrollScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                defaultScrollableState.isScrollingState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                defaultScrollableState.isScrollingState.setValue(Boolean.FALSE);
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultScrollableState$scroll$2(DefaultScrollableState defaultScrollableState, MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultScrollableState$scroll$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultScrollableState;
        this.$scrollPriority = mutatePriority;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultScrollableState$scroll$2(this.this$0, this.$scrollPriority, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultScrollableState$scroll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            DefaultScrollableState defaultScrollableState = this.this$0;
            MutatorMutex mutatorMutex = defaultScrollableState.scrollMutex;
            DefaultScrollableState$scrollScope$1 defaultScrollableState$scrollScope$1 = defaultScrollableState.scrollScope;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(defaultScrollableState, this.$block, null);
            this.label = 1;
            MutatePriority mutatePriority = this.$scrollPriority;
            mutatorMutex.getClass();
            if (CoroutineScopeKt.coroutineScope(new MutatorMutex$mutateWith$2(mutatePriority, mutatorMutex, anonymousClass1, defaultScrollableState$scrollScope$1, null), this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}

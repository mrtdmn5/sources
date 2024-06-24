package com.animaconnected.secondo.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: ClickThrottle.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.ClickThrottle$handle$2", f = "ClickThrottle.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ClickThrottle$handle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClickThrottle this$0;

    /* compiled from: ClickThrottle.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.utils.ClickThrottle$handle$2$1", f = "ClickThrottle.kt", l = {22}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.utils.ClickThrottle$handle$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ClickThrottle this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClickThrottle clickThrottle, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = clickThrottle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
                if (DelayKt.delay(1000L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.this$0.isInUse = false;
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickThrottle$handle$2(ClickThrottle clickThrottle, Continuation<? super ClickThrottle$handle$2> continuation) {
        super(2, continuation);
        this.this$0 = clickThrottle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickThrottle$handle$2 clickThrottle$handle$2 = new ClickThrottle$handle$2(this.this$0, continuation);
        clickThrottle$handle$2.L$0 = obj;
        return clickThrottle$handle$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.this$0, null), 3);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickThrottle$handle$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

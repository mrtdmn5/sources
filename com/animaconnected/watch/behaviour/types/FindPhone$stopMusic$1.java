package com.animaconnected.watch.behaviour.types;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.RemoteAppImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FindPhone.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1", f = "FindPhone.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FindPhone$stopMusic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FindPhone this$0;

    /* compiled from: FindPhone.kt */
    @DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$3", f = "FindPhone.kt", l = {R.styleable.AppTheme_tabTextStyle}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FindPhone this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(FindPhone findPhone, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = findPhone;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
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
                FindPhone findPhone = this.this$0;
                this.label = 1;
                if (RemoteAppImpl.changeView$default(findPhone, 0, null, this, 2, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindPhone$stopMusic$1(FindPhone findPhone, Continuation<? super FindPhone$stopMusic$1> continuation) {
        super(2, continuation);
        this.this$0 = findPhone;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FindPhone$stopMusic$1 findPhone$stopMusic$1 = new FindPhone$stopMusic$1(this.this$0, continuation);
        findPhone$stopMusic$1.L$0 = obj;
        return findPhone$stopMusic$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:            r8 = r7.this$0.getCurrentDisplay();     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r7.label
            if (r0 != 0) goto L76
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r0 = r8
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            java.util.Set r8 = com.animaconnected.watch.behaviour.types.FindPhone.access$getFindPhoneListeners$p(r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L1a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L2a
            java.lang.Object r1 = r8.next()
            com.animaconnected.watch.behaviour.interfaces.FindPhoneListener r1 = (com.animaconnected.watch.behaviour.interfaces.FindPhoneListener) r1
            r1.onFindPhoneStopped()
            goto L1a
        L2a:
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer r8 = com.animaconnected.watch.behaviour.types.FindPhone.access$getMusicPlayer$p(r8)
            r8.stop()
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$2 r4 = new com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$2
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            r4.<init>()
            r5 = 7
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            java.lang.Integer r8 = com.animaconnected.watch.behaviour.types.FindPhone.access$getCurrentDisplay(r8)
            if (r8 == 0) goto L73
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            java.lang.Integer r8 = com.animaconnected.watch.behaviour.types.FindPhone.access$getCurrentDisplay(r8)
            if (r8 != 0) goto L53
            goto L59
        L53:
            int r8 = r8.intValue()
            if (r8 == 0) goto L73
        L59:
            com.animaconnected.watch.behaviour.types.FindPhone r8 = r7.this$0
            com.animaconnected.watch.DisplayWatch r8 = r8.getDisplayWatch$watch_release()
            if (r8 == 0) goto L73
            kotlinx.coroutines.CoroutineScope r8 = r8.getScope()
            if (r8 == 0) goto L73
            com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$3 r0 = new com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1$3
            com.animaconnected.watch.behaviour.types.FindPhone r1 = r7.this$0
            r2 = 0
            r0.<init>(r1, r2)
            r1 = 3
            kotlinx.coroutines.BuildersKt.launch$default(r8, r2, r2, r0, r1)
        L73:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L76:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.FindPhone$stopMusic$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FindPhone$stopMusic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.animaconnected.watch.provider.quiethours;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RefreshTimer.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.quiethours.RefreshTimer$setupReminder$2", f = "RefreshTimer.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RefreshTimer$setupReminder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Duration> $delays;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RefreshTimer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshTimer$setupReminder$2(List<Duration> list, RefreshTimer refreshTimer, Continuation<? super RefreshTimer$setupReminder$2> continuation) {
        super(2, continuation);
        this.$delays = list;
        this.this$0 = refreshTimer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RefreshTimer$setupReminder$2(this.$delays, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:6:0x0011, B:8:0x0049, B:9:0x002e, B:11:0x0034, B:21:0x0021), top: B:2:0x0005 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0046 -> B:8:0x0049). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r6.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r6.L$0
            com.animaconnected.watch.provider.quiethours.RefreshTimer r3 = (com.animaconnected.watch.provider.quiethours.RefreshTimer) r3
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L51
            r7 = r6
            goto L49
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List<kotlin.time.Duration> r7 = r6.$delays     // Catch: java.lang.Exception -> L51
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Exception -> L51
            com.animaconnected.watch.provider.quiethours.RefreshTimer r1 = r6.this$0     // Catch: java.lang.Exception -> L51
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> L51
            r3 = r1
            r1 = r7
            r7 = r6
        L2e:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Exception -> L51
            if (r4 == 0) goto L51
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Exception -> L51
            kotlin.time.Duration r4 = (kotlin.time.Duration) r4     // Catch: java.lang.Exception -> L51
            long r4 = r4.rawValue     // Catch: java.lang.Exception -> L51
            r7.L$0 = r3     // Catch: java.lang.Exception -> L51
            r7.L$1 = r1     // Catch: java.lang.Exception -> L51
            r7.label = r2     // Catch: java.lang.Exception -> L51
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.m1695delayVtjQ1oo(r4, r7)     // Catch: java.lang.Exception -> L51
            if (r4 != r0) goto L49
            return r0
        L49:
            kotlin.jvm.functions.Function0 r4 = com.animaconnected.watch.provider.quiethours.RefreshTimer.access$getCallback$p(r3)     // Catch: java.lang.Exception -> L51
            r4.invoke()     // Catch: java.lang.Exception -> L51
            goto L2e
        L51:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.quiethours.RefreshTimer$setupReminder$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RefreshTimer$setupReminder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

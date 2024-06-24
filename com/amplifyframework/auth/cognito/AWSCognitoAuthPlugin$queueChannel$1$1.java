package com.amplifyframework.auth.cognito;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

/* compiled from: AWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$queueChannel$1$1", f = "AWSCognitoAuthPlugin.kt", l = {845, 91}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin$queueChannel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Job> $this_apply;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthPlugin$queueChannel$1$1(Channel<Job> channel, Continuation<? super AWSCognitoAuthPlugin$queueChannel$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSCognitoAuthPlugin$queueChannel$1$1(this.$this_apply, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:15:0x004d, B:17:0x0055), top: B:14:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0068 -> B:9:0x003a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L76
            goto L39
        L18:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L20:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L76
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r7
            goto L4d
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.Channel<kotlinx.coroutines.Job> r4 = r7.$this_apply
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch: java.lang.Throwable -> L76
        L39:
            r8 = r7
        L3a:
            r8.L$0 = r4     // Catch: java.lang.Throwable -> L76
            r8.L$1 = r1     // Catch: java.lang.Throwable -> L76
            r8.label = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r5 = r1.hasNext(r8)     // Catch: java.lang.Throwable -> L76
            if (r5 != r0) goto L47
            return r0
        L47:
            r6 = r0
            r0 = r8
            r8 = r5
            r5 = r4
            r4 = r1
            r1 = r6
        L4d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L74
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L74
            if (r8 == 0) goto L6d
            java.lang.Object r8 = r4.next()     // Catch: java.lang.Throwable -> L74
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8     // Catch: java.lang.Throwable -> L74
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L74
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L74
            r0.label = r2     // Catch: java.lang.Throwable -> L74
            java.lang.Object r8 = r8.join(r0)     // Catch: java.lang.Throwable -> L74
            if (r8 != r1) goto L68
            return r1
        L68:
            r8 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            goto L3a
        L6d:
            r8 = 0
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r5, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L74:
            r8 = move-exception
            goto L78
        L76:
            r8 = move-exception
            r5 = r4
        L78:
            throw r8     // Catch: java.lang.Throwable -> L79
        L79:
            r0 = move-exception
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r5, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$queueChannel$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSCognitoAuthPlugin$queueChannel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

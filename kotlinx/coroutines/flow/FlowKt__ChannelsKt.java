package kotlinx.coroutines.flow;

/* compiled from: Channels.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:12:0x002e, B:14:0x0053, B:19:0x0068, B:21:0x0070, B:32:0x0044, B:35:0x004f), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:13:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L48
            if (r2 == r3) goto L3c
            if (r2 != r4) goto L34
            boolean r8 = r0.Z$0
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L85
        L31:
            r9 = r6
            r6 = r2
            goto L53
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            boolean r8 = r0.Z$0
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L85
            goto L68
        L48:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r6 instanceof kotlinx.coroutines.flow.ThrowingCollector
            if (r9 != 0) goto L98
            kotlinx.coroutines.channels.ChannelIterator r9 = r7.iterator()     // Catch: java.lang.Throwable -> L85
        L53:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L85
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L85
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L85
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L85
            r0.label = r3     // Catch: java.lang.Throwable -> L85
            java.lang.Object r2 = r9.hasNext(r0)     // Catch: java.lang.Throwable -> L85
            if (r2 != r1) goto L64
            return r1
        L64:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L68:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L85
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L85
            if (r9 == 0) goto L87
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L85
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L85
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L85
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L85
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L85
            r0.label = r4     // Catch: java.lang.Throwable -> L85
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L85
            if (r9 != r1) goto L31
            return r1
        L85:
            r6 = move-exception
            goto L90
        L87:
            if (r8 == 0) goto L8d
            r6 = 0
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r7, r6)
        L8d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L90:
            throw r6     // Catch: java.lang.Throwable -> L91
        L91:
            r9 = move-exception
            if (r8 == 0) goto L97
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r7, r6)
        L97:
            throw r9
        L98:
            kotlinx.coroutines.flow.ThrowingCollector r6 = (kotlinx.coroutines.flow.ThrowingCollector) r6
            java.lang.Throwable r6 = r6.e
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

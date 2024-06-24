package aws.smithy.kotlin.runtime.io;

/* compiled from: SdkByteReadChannel.kt */
/* loaded from: classes.dex */
public final class SdkByteReadChannelKt {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0046 -> B:10:0x0049). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readRemaining(aws.smithy.kotlin.runtime.io.SdkByteReadChannel r5, aws.smithy.kotlin.runtime.io.SdkBuffer r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1
            if (r0 == 0) goto L13
            r0 = r7
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1 r0 = (aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1 r0 = new aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            aws.smithy.kotlin.runtime.io.SdkBuffer r5 = r0.L$1
            r6 = 0
            r0.getClass()
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L49
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
        L3b:
            r0.getClass()
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.read()
            if (r7 != r1) goto L49
            return r1
        L49:
            boolean r7 = r5.isClosedForRead()
            if (r7 == 0) goto L3b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt.readRemaining(aws.smithy.kotlin.runtime.io.SdkByteReadChannel, aws.smithy.kotlin.runtime.io.SdkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readToBuffer(aws.smithy.kotlin.runtime.io.SdkByteReadChannel r4, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.io.SdkBuffer> r5) {
        /*
            boolean r0 = r5 instanceof aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1
            if (r0 == 0) goto L13
            r0 = r5
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1 r0 = (aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1 r0 = new aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            aws.smithy.kotlin.runtime.io.SdkBuffer r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            aws.smithy.kotlin.runtime.io.SdkBuffer r5 = new aws.smithy.kotlin.runtime.io.SdkBuffer
            r5.<init>()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = readRemaining(r4, r5, r0)
            if (r4 != r1) goto L44
            return r1
        L44:
            r4 = r5
        L45:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt.readToBuffer(aws.smithy.kotlin.runtime.io.SdkByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

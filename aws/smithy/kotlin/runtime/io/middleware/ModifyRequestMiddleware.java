package aws.smithy.kotlin.runtime.io.middleware;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifyRequest.kt */
/* loaded from: classes.dex */
public final class ModifyRequestMiddleware<Request, Response> implements Middleware<Request, Response> {
    public final ModifyRequest<Request> transform;

    public ModifyRequestMiddleware(ModifyRequest<Request> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.transform = transform;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0054 A[PHI: r8
  0x0054: PHI (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x0051, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r7v1, types: [aws.smithy.kotlin.runtime.io.Handler] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <H extends aws.smithy.kotlin.runtime.io.Handler<? super Request, ? extends Response>> java.lang.Object handle(Request r6, H r7, kotlin.coroutines.Continuation<? super Response> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1
            if (r0 == 0) goto L13
            r0 = r8
            aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1 r0 = (aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1 r0 = new aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            aws.smithy.kotlin.runtime.io.Handler r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.label = r4
            aws.smithy.kotlin.runtime.io.middleware.ModifyRequest<Request> r8 = r5.transform
            java.lang.Object r8 = r8.modifyRequest(r6, r0)
            if (r8 != r1) goto L48
            return r1
        L48:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r7.call(r8, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware.handle(java.lang.Object, aws.smithy.kotlin.runtime.io.Handler, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

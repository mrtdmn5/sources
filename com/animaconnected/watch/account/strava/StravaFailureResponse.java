package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.account.HttpUtilsKt;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Errors.kt */
/* loaded from: classes3.dex */
public final class StravaFailureResponse {
    public static final StravaFailureResponse INSTANCE = new StravaFailureResponse();

    private StravaFailureResponse() {
    }

    public final WatchLibResult.Failure<Boolean, WatchLibException> missingAccessToken() {
        WatchLibResult.Failure<Boolean, WatchLibException> createFailureResponse;
        createFailureResponse = ErrorsKt.createFailureResponse("Access token missing.", Integer.valueOf(HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE));
        return createFailureResponse;
    }

    public final WatchLibResult.Failure<Boolean, WatchLibException> revokeAccess(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return ErrorsKt.createFailureResponse$default("Access revocation failed. Reason: " + Reflection.getOrCreateKotlinClass(exception.getClass()).getSimpleName() + " - " + exception.getMessage(), null, 2, null);
    }

    public final WatchLibResult.Failure<Boolean, WatchLibException> upload(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return ErrorsKt.createFailureResponse$default("Session upload failed. Reason: " + Reflection.getOrCreateKotlinClass(exception.getClass()).getSimpleName() + " - " + exception.getMessage(), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object revokeAccess(io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult.Failure<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.account.strava.StravaFailureResponse$revokeAccess$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.account.strava.StravaFailureResponse$revokeAccess$1 r0 = (com.animaconnected.watch.account.strava.StravaFailureResponse$revokeAccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaFailureResponse$revokeAccess$1 r0 = new com.animaconnected.watch.account.strava.StravaFailureResponse$revokeAccess$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$1
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Access revocation failed. Status: "
            r7.append(r2)
            io.ktor.http.HttpStatusCode r2 = r6.getStatus()
            r7.append(r2)
            java.lang.String r2 = ". Details: "
            r7.append(r2)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = io.ktor.client.statement.HttpResponseKt.bodyAsText$default(r6, r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r4 = r0
            r0 = r6
            r6 = r7
            r7 = r4
        L61:
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            io.ktor.http.HttpStatusCode r7 = r0.getStatus()
            int r7 = r7.value
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r7)
            com.animaconnected.watch.utils.WatchLibResult$Failure r6 = com.animaconnected.watch.account.strava.ErrorsKt.access$createFailureResponse(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaFailureResponse.revokeAccess(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final WatchLibResult.Failure<Boolean, WatchLibException> upload(Upload upload) {
        return ErrorsKt.createFailureResponse$default("Session upload failed. Details: " + upload, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object upload(io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult.Failure<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.account.strava.StravaFailureResponse$upload$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.account.strava.StravaFailureResponse$upload$1 r0 = (com.animaconnected.watch.account.strava.StravaFailureResponse$upload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaFailureResponse$upload$1 r0 = new com.animaconnected.watch.account.strava.StravaFailureResponse$upload$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$1
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Session upload failed. Status: "
            r7.append(r2)
            io.ktor.http.HttpStatusCode r2 = r6.getStatus()
            r7.append(r2)
            java.lang.String r2 = ". Details: "
            r7.append(r2)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = io.ktor.client.statement.HttpResponseKt.bodyAsText$default(r6, r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r4 = r0
            r0 = r6
            r6 = r7
            r7 = r4
        L61:
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            io.ktor.http.HttpStatusCode r7 = r0.getStatus()
            int r7 = r7.value
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r7)
            com.animaconnected.watch.utils.WatchLibResult$Failure r6 = com.animaconnected.watch.account.strava.ErrorsKt.access$createFailureResponse(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaFailureResponse.upload(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

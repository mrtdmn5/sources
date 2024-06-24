package com.animaconnected.watch.account.fitness;

import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.GzipBackend;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: FitnessCloudSyncApi.kt */
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApi {
    private final GzipBackend gzipBackend;
    private final FitnessHttpClient httpClient;

    public FitnessCloudSyncApi(FitnessHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.httpClient = httpClient;
        this.gzipBackend = ServiceLocator.INSTANCE.getGzipBackend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a6 -> B:11:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchData(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<? extends java.util.List<com.animaconnected.watch.account.fitness.FitnessFile>>> r12) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.fetchData(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchDownloadUrls(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<com.animaconnected.watch.account.fitness.ResponseDownloadUrls>> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "fetchDownloadUrls -> response: "
            boolean r1 = r13 instanceof com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchDownloadUrls$1
            if (r1 == 0) goto L15
            r1 = r13
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchDownloadUrls$1 r1 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchDownloadUrls$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchDownloadUrls$1 r1 = new com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchDownloadUrls$1
            r1.<init>(r10, r13)
        L1a:
            java.lang.Object r13 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            java.lang.Object r11 = r1.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r11 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi) r11
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L2d
            goto L48
        L2d:
            r12 = move-exception
            goto L66
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.account.fitness.FitnessHttpClient r13 = r10.httpClient     // Catch: java.lang.Exception -> L68
            r1.L$0 = r10     // Catch: java.lang.Exception -> L68
            r1.label = r4     // Catch: java.lang.Exception -> L68
            java.lang.Object r13 = r13.fetchDownloadUrls(r11, r12, r1)     // Catch: java.lang.Exception -> L68
            if (r13 != r2) goto L47
            return r2
        L47:
            r11 = r10
        L48:
            com.animaconnected.watch.account.fitness.ResponseDownloadUrls r13 = (com.animaconnected.watch.account.fitness.ResponseDownloadUrls) r13     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r12.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r12.append(r13)     // Catch: java.lang.Exception -> L2d
            java.lang.String r4 = r12.toString()     // Catch: java.lang.Exception -> L2d
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r11
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L2d
            com.animaconnected.watch.account.fitness.FitnessApiResult$Success r12 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Success     // Catch: java.lang.Exception -> L2d
            r12.<init>(r13)     // Catch: java.lang.Exception -> L2d
            goto L80
        L66:
            r0 = r11
            goto L6b
        L68:
            r11 = move-exception
            r12 = r11
            r0 = r10
        L6b:
            java.lang.String r11 = "fetchDownloadUrls -> error: "
            java.lang.String r1 = com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0.m(r11, r12)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.account.fitness.FitnessApiResult$Failure r11 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Failure
            r11.<init>(r12)
            r12 = r11
        L80:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.fetchDownloadUrls(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchUploadUrls(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<com.animaconnected.watch.account.fitness.ResponseUploadUrls>> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "fetchUploadUrls -> response: "
            boolean r1 = r13 instanceof com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchUploadUrls$1
            if (r1 == 0) goto L15
            r1 = r13
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchUploadUrls$1 r1 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchUploadUrls$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchUploadUrls$1 r1 = new com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$fetchUploadUrls$1
            r1.<init>(r10, r13)
        L1a:
            java.lang.Object r13 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            java.lang.Object r11 = r1.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r11 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi) r11
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L2d
            goto L48
        L2d:
            r12 = move-exception
            goto L66
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.account.fitness.FitnessHttpClient r13 = r10.httpClient     // Catch: java.lang.Exception -> L68
            r1.L$0 = r10     // Catch: java.lang.Exception -> L68
            r1.label = r4     // Catch: java.lang.Exception -> L68
            java.lang.Object r13 = r13.fetchUploadUrls(r11, r12, r1)     // Catch: java.lang.Exception -> L68
            if (r13 != r2) goto L47
            return r2
        L47:
            r11 = r10
        L48:
            com.animaconnected.watch.account.fitness.ResponseUploadUrls r13 = (com.animaconnected.watch.account.fitness.ResponseUploadUrls) r13     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r12.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r12.append(r13)     // Catch: java.lang.Exception -> L2d
            java.lang.String r4 = r12.toString()     // Catch: java.lang.Exception -> L2d
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r11
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L2d
            com.animaconnected.watch.account.fitness.FitnessApiResult$Success r12 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Success     // Catch: java.lang.Exception -> L2d
            r12.<init>(r13)     // Catch: java.lang.Exception -> L2d
            goto L80
        L66:
            r0 = r11
            goto L6b
        L68:
            r11 = move-exception
            r12 = r11
            r0 = r10
        L6b:
            java.lang.String r11 = "fetchUploadUrls -> error: "
            java.lang.String r1 = com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0.m(r11, r12)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.account.fitness.FitnessApiResult$Failure r11 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Failure
            r11.<init>(r12)
            r12 = r11
        L80:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.fetchUploadUrls(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toTimestamp(String str) {
        String str2 = str + "T00:00:00Z";
        Intrinsics.checkNotNullParameter(str2, "<this>");
        Instant.Companion.getClass();
        return Instant.Companion.parse(str2).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object uploadData(java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<? extends io.ktor.client.statement.HttpResponse>> r14) {
        /*
            Method dump skipped, instructions count: 187
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.uploadData(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteData(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "deleteData -> response: "
            boolean r1 = r12 instanceof com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$deleteData$1
            if (r1 == 0) goto L15
            r1 = r12
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$deleteData$1 r1 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$deleteData$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$deleteData$1 r1 = new com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$deleteData$1
            r1.<init>(r10, r12)
        L1a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            java.lang.Object r11 = r1.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r11 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2d
            goto L48
        L2d:
            r12 = move-exception
            goto L61
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.account.fitness.FitnessHttpClient r12 = r10.httpClient     // Catch: java.lang.Exception -> L63
            r1.L$0 = r10     // Catch: java.lang.Exception -> L63
            r1.label = r4     // Catch: java.lang.Exception -> L63
            java.lang.Object r12 = r12.deleteData(r11, r1)     // Catch: java.lang.Exception -> L63
            if (r12 != r2) goto L47
            return r2
        L47:
            r11 = r10
        L48:
            io.ktor.client.statement.HttpResponse r12 = (io.ktor.client.statement.HttpResponse) r12     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r1.append(r12)     // Catch: java.lang.Exception -> L2d
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L2d
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r11
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L2d
            goto L75
        L61:
            r0 = r11
            goto L66
        L63:
            r11 = move-exception
            r12 = r11
            r0 = r10
        L66:
            java.lang.String r11 = "deleteData -> error: "
            java.lang.String r1 = com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0.m(r11, r12)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L75:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.deleteData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object downloadData(long j, long j2, String str, Continuation<? super FitnessApiResult<? extends List<FitnessFile>>> continuation) {
        String dateString;
        String dateString2;
        StringBuilder sb = new StringBuilder("date_from=");
        dateString = FitnessCloudSyncApiKt.toDateString(j);
        sb.append(dateString);
        sb.append("&date_to=");
        dateString2 = FitnessCloudSyncApiKt.toDateString(j2);
        sb.append(dateString2);
        return fetchData(sb.toString(), str, continuation);
    }

    public final Object downloadNewData(long j, String str, Continuation<? super FitnessApiResult<? extends List<FitnessFile>>> continuation) {
        return fetchData(FileSectionType$$ExternalSyntheticOutline0.m("updated_after=", j), str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object downloadData(java.lang.String r11, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<java.lang.String>> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "downloadData -> response (decompressed): "
            boolean r1 = r12 instanceof com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$downloadData$2
            if (r1 == 0) goto L15
            r1 = r12
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$downloadData$2 r1 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$downloadData$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$downloadData$2 r1 = new com.animaconnected.watch.account.fitness.FitnessCloudSyncApi$downloadData$2
            r1.<init>(r10, r12)
        L1a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L42
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            java.lang.Object r11 = r1.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r11 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L40
            goto L62
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            java.lang.Object r11 = r1.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r11 = (com.animaconnected.watch.account.fitness.FitnessCloudSyncApi) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L40
            goto L53
        L40:
            r12 = move-exception
            goto L80
        L42:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.account.fitness.FitnessHttpClient r12 = r10.httpClient     // Catch: java.lang.Exception -> L82
            r1.L$0 = r10     // Catch: java.lang.Exception -> L82
            r1.label = r5     // Catch: java.lang.Exception -> L82
            java.lang.Object r12 = r12.downloadData(r11, r1)     // Catch: java.lang.Exception -> L82
            if (r12 != r2) goto L52
            return r2
        L52:
            r11 = r10
        L53:
            byte[] r12 = (byte[]) r12     // Catch: java.lang.Exception -> L40
            com.animaconnected.watch.device.GzipBackend r3 = r11.gzipBackend     // Catch: java.lang.Exception -> L40
            r1.L$0 = r11     // Catch: java.lang.Exception -> L40
            r1.label = r4     // Catch: java.lang.Exception -> L40
            java.lang.Object r12 = r3.decompress(r12, r1)     // Catch: java.lang.Exception -> L40
            if (r12 != r2) goto L62
            return r2
        L62:
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Exception -> L40
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L40
            r1.<init>(r0)     // Catch: java.lang.Exception -> L40
            r1.append(r12)     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L40
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r11
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L40
            com.animaconnected.watch.account.fitness.FitnessApiResult$Success r0 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Success     // Catch: java.lang.Exception -> L40
            r0.<init>(r12)     // Catch: java.lang.Exception -> L40
            goto L99
        L80:
            r0 = r11
            goto L85
        L82:
            r11 = move-exception
            r12 = r11
            r0 = r10
        L85:
            java.lang.String r11 = "downloadData -> error: "
            java.lang.String r1 = com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0.m(r11, r12)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.account.fitness.FitnessApiResult$Failure r0 = new com.animaconnected.watch.account.fitness.FitnessApiResult$Failure
            r0.<init>(r12)
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.downloadData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00eb -> B:11:0x00f3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object uploadData(java.util.List<com.animaconnected.watch.account.fitness.FitnessFile> r20, java.lang.String r21, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.FitnessApiResult<kotlin.Unit>> r22) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudSyncApi.uploadData(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

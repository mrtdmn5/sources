package com.animaconnected.watch.account;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountApi.kt */
/* loaded from: classes3.dex */
public final class AccountApi {
    private final AccountHttpClient httpClient;

    public AccountApi(AccountHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkDownloadAccountDataStatus(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<com.animaconnected.watch.account.ResponseDownloadDataUrl, com.animaconnected.watch.utils.WatchLibException>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$1 r0 = (com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$1 r0 = new com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.account.AccountApi r0 = (com.animaconnected.watch.account.AccountApi) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L2f
            r7 = r0
            goto L83
        L2f:
            r9 = move-exception
            goto L9f
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.account.AccountApi r2 = (com.animaconnected.watch.account.AccountApi) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L57
        L42:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.ServiceLocator r9 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.AccountBackend r9 = r9.getAccountBackend()
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r9.token(r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            r2 = r8
        L57:
            com.animaconnected.watch.utils.WatchLibResult r9 = (com.animaconnected.watch.utils.WatchLibResult) r9
            boolean r4 = r9 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r4 == 0) goto L69
            com.animaconnected.watch.utils.WatchLibResult$Failure r0 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            com.animaconnected.watch.utils.WatchLibResult$Failure r9 = (com.animaconnected.watch.utils.WatchLibResult.Failure) r9
            java.lang.Throwable r9 = r9.getFailure()
            r0.<init>(r9)
            goto Lb2
        L69:
            boolean r4 = r9 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r4 == 0) goto Lb3
            com.animaconnected.watch.account.AccountHttpClient r4 = r2.httpClient     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            com.animaconnected.watch.utils.WatchLibResult$Success r9 = (com.animaconnected.watch.utils.WatchLibResult.Success) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            java.lang.Object r9 = r9.getSuccess()     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            java.lang.String r9 = (java.lang.String) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r0.L$0 = r2     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r0.label = r3     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            java.lang.Object r9 = r4.checkDownloadAccountDataStatus(r9, r0)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            if (r9 != r1) goto L82
            return r1
        L82:
            r7 = r2
        L83:
            com.animaconnected.watch.account.ResponseDownloadDataUrl r9 = (com.animaconnected.watch.account.ResponseDownloadDataUrl) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            java.lang.String r1 = "AccountApi"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$2 r4 = new com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$2     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            r4.<init>()     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            r5 = 6
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            com.animaconnected.watch.utils.WatchLibResult$Success r0 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            r0.<init>(r9)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9a
            goto Lb2
        L9a:
            r9 = move-exception
            r0 = r7
            goto L9f
        L9d:
            r9 = move-exception
            r0 = r2
        L9f:
            java.lang.String r1 = "AccountApi"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$3 r4 = new com.animaconnected.watch.account.AccountApi$checkDownloadAccountDataStatus$3
            r4.<init>()
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.utils.WatchLibResult$Failure r0 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            r0.<init>(r9)
        Lb2:
            return r0
        Lb3:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.AccountApi.checkDownloadAccountDataStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteAccount(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Integer, com.animaconnected.watch.utils.WatchLibException>> r11) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.AccountApi.deleteAccount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initiateDownloadAccountData(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<kotlin.Unit, com.animaconnected.watch.utils.WatchLibException>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$1 r0 = (com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$1 r0 = new com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.account.AccountApi r0 = (com.animaconnected.watch.account.AccountApi) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L2f
            r7 = r0
            goto L83
        L2f:
            r9 = move-exception
            goto La2
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.account.AccountApi r2 = (com.animaconnected.watch.account.AccountApi) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L57
        L42:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.ServiceLocator r9 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.AccountBackend r9 = r9.getAccountBackend()
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r9.token(r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            r2 = r8
        L57:
            com.animaconnected.watch.utils.WatchLibResult r9 = (com.animaconnected.watch.utils.WatchLibResult) r9
            boolean r4 = r9 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r4 == 0) goto L69
            com.animaconnected.watch.utils.WatchLibResult$Failure r0 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            com.animaconnected.watch.utils.WatchLibResult$Failure r9 = (com.animaconnected.watch.utils.WatchLibResult.Failure) r9
            java.lang.Throwable r9 = r9.getFailure()
            r0.<init>(r9)
            goto Lb5
        L69:
            boolean r4 = r9 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r4 == 0) goto Lb6
            com.animaconnected.watch.account.AccountHttpClient r4 = r2.httpClient     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            com.animaconnected.watch.utils.WatchLibResult$Success r9 = (com.animaconnected.watch.utils.WatchLibResult.Success) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            java.lang.Object r9 = r9.getSuccess()     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            java.lang.String r9 = (java.lang.String) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            r0.L$0 = r2     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            r0.label = r3     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            java.lang.Object r9 = r4.initiateDownloadAccountData(r9, r0)     // Catch: com.animaconnected.watch.utils.WatchLibException -> La0
            if (r9 != r1) goto L82
            return r1
        L82:
            r7 = r2
        L83:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            java.lang.String r1 = "AccountApi"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$2 r4 = new com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$2     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r4.<init>()     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r5 = 6
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            com.animaconnected.watch.utils.WatchLibResult$Success r9 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r9.<init>(r0)     // Catch: com.animaconnected.watch.utils.WatchLibException -> L9d
            r0 = r9
            goto Lb5
        L9d:
            r9 = move-exception
            r0 = r7
            goto La2
        La0:
            r9 = move-exception
            r0 = r2
        La2:
            java.lang.String r1 = "AccountApi"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$3 r4 = new com.animaconnected.watch.account.AccountApi$initiateDownloadAccountData$3
            r4.<init>()
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.utils.WatchLibResult$Failure r0 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            r0.<init>(r9)
        Lb5:
            return r0
        Lb6:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.AccountApi.initiateDownloadAccountData(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

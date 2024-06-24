package com.animaconnected.watch.account;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AccountHttpClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.AccountHttpClient", f = "AccountHttpClient.kt", l = {108, 109}, m = "checkDownloadAccountDataStatus")
/* loaded from: classes3.dex */
public final class AccountHttpClient$checkDownloadAccountDataStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountHttpClient$checkDownloadAccountDataStatus$1(AccountHttpClient accountHttpClient, Continuation<? super AccountHttpClient$checkDownloadAccountDataStatus$1> continuation) {
        super(continuation);
        this.this$0 = accountHttpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkDownloadAccountDataStatus(null, this);
    }
}

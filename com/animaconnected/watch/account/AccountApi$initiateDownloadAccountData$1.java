package com.animaconnected.watch.account;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AccountApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.AccountApi", f = "AccountApi.kt", l = {41, 45}, m = "initiateDownloadAccountData")
/* loaded from: classes3.dex */
public final class AccountApi$initiateDownloadAccountData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountApi$initiateDownloadAccountData$1(AccountApi accountApi, Continuation<? super AccountApi$initiateDownloadAccountData$1> continuation) {
        super(continuation);
        this.this$0 = accountApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initiateDownloadAccountData(this);
    }
}

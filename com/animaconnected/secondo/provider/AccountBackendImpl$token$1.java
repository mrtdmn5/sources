package com.animaconnected.secondo.provider;

import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AccountBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.AccountBackendImpl", f = "AccountBackendImpl.kt", l = {35}, m = AWSCognitoLegacyCredentialStore.TOKEN_KEY)
/* loaded from: classes3.dex */
public final class AccountBackendImpl$token$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountBackendImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountBackendImpl$token$1(AccountBackendImpl accountBackendImpl, Continuation<? super AccountBackendImpl$token$1> continuation) {
        super(continuation);
        this.this$0 = accountBackendImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.token(this);
    }
}

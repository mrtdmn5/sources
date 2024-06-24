package com.amplifyframework.auth.cognito;

import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.CredentialType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: CredentialStoreClient.kt */
/* loaded from: classes.dex */
public interface StoreClientBehavior {
    Object clearCredentials(CredentialType credentialType, Continuation<? super Unit> continuation);

    Object loadCredentials(CredentialType credentialType, Continuation<? super AmplifyCredential> continuation);

    Object storeCredentials(CredentialType credentialType, AmplifyCredential amplifyCredential, Continuation<? super Unit> continuation);
}

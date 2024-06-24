package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.CredentialType;

/* compiled from: CredentialStoreActions.kt */
/* loaded from: classes.dex */
public interface CredentialStoreActions {
    Action clearCredentialStoreAction(CredentialType credentialType);

    Action loadCredentialStoreAction(CredentialType credentialType);

    Action migrateLegacyCredentialStoreAction();

    Action moveToIdleStateAction();

    Action storeCredentialsAction(CredentialType credentialType, AmplifyCredential amplifyCredential);
}

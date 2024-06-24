package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.cognito.data.AWSCognitoAuthCredentialStore;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Environment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreStateMachine.kt */
/* loaded from: classes.dex */
public final class CredentialStoreEnvironment implements Environment {
    private final AWSCognitoAuthCredentialStore credentialStore;
    private final AWSCognitoLegacyCredentialStore legacyCredentialStore;
    private final Logger logger;

    public CredentialStoreEnvironment(AWSCognitoAuthCredentialStore credentialStore, AWSCognitoLegacyCredentialStore legacyCredentialStore, Logger logger) {
        Intrinsics.checkNotNullParameter(credentialStore, "credentialStore");
        Intrinsics.checkNotNullParameter(legacyCredentialStore, "legacyCredentialStore");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.credentialStore = credentialStore;
        this.legacyCredentialStore = legacyCredentialStore;
        this.logger = logger;
    }

    public final AWSCognitoAuthCredentialStore getCredentialStore() {
        return this.credentialStore;
    }

    public final AWSCognitoLegacyCredentialStore getLegacyCredentialStore() {
        return this.legacyCredentialStore;
    }

    public final Logger getLogger() {
        return this.logger;
    }
}

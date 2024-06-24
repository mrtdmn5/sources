package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCredentials.kt */
/* loaded from: classes.dex */
public final class AWSTemporaryCredentials extends AWSCredentials {
    private final String accessKeyId;
    private final Instant expiration;
    private final String secretAccessKey;
    private final String sessionToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSTemporaryCredentials(String accessKeyId, String secretAccessKey, String sessionToken, Instant expiration) {
        super(accessKeyId, secretAccessKey);
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(expiration, "expiration");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = sessionToken;
        this.expiration = expiration;
    }

    @Override // com.amplifyframework.auth.AWSCredentials
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final Instant getExpiration() {
        return this.expiration;
    }

    @Override // com.amplifyframework.auth.AWSCredentials
    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}

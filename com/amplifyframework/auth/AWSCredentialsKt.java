package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCredentials.kt */
/* loaded from: classes.dex */
public final class AWSCredentialsKt {
    public static final Credentials toSdkCredentials(AWSCredentials aWSCredentials) {
        AWSTemporaryCredentials aWSTemporaryCredentials;
        String str;
        AWSTemporaryCredentials aWSTemporaryCredentials2;
        Intrinsics.checkNotNullParameter(aWSCredentials, "<this>");
        String accessKeyId = aWSCredentials.getAccessKeyId();
        String secretAccessKey = aWSCredentials.getSecretAccessKey();
        boolean z = aWSCredentials instanceof AWSTemporaryCredentials;
        Instant instant = null;
        if (z) {
            aWSTemporaryCredentials = (AWSTemporaryCredentials) aWSCredentials;
        } else {
            aWSTemporaryCredentials = null;
        }
        if (aWSTemporaryCredentials != null) {
            str = aWSTemporaryCredentials.getSessionToken();
        } else {
            str = null;
        }
        if (z) {
            aWSTemporaryCredentials2 = (AWSTemporaryCredentials) aWSCredentials;
        } else {
            aWSTemporaryCredentials2 = null;
        }
        if (aWSTemporaryCredentials2 != null) {
            instant = aWSTemporaryCredentials2.getExpiration();
        }
        return new Credentials(accessKeyId, secretAccessKey, str, instant);
    }
}

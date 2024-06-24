package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.time.Instant;
import j$.time.format.DateTimeFormatter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCredentials.kt */
/* loaded from: classes.dex */
public class AWSCredentials {
    public static final Factory Factory = new Factory(null);
    private final String accessKeyId;
    private final String secretAccessKey;

    /* compiled from: AWSCredentials.kt */
    /* loaded from: classes.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AWSCredentials createAWSCredentials(String str, String str2, String str3, Long l) {
            if (str != null && str2 != null) {
                if (str3 != null && l != null) {
                    DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
                    return new AWSTemporaryCredentials(str, str2, str3, Instant.Companion.fromEpochSeconds(0, l.longValue()));
                }
                return new AWSCredentials(str, str2);
            }
            return null;
        }

        private Factory() {
        }
    }

    public AWSCredentials(String accessKeyId, String secretAccessKey) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }
}

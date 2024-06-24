package com.animaconnected.cloud;

import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CloudEvent.kt */
/* loaded from: classes.dex */
public final class CloudEvent {
    public static final String CLOUD_FEATURE_LAMBDA = "lambda";
    public static final String CLOUD_TYPE_CALL = "call";
    public static final String CLOUD_TYPE_ERROR = "error";
    public static final Companion Companion = new Companion(null);
    private final String feature;
    private final String name;
    private Throwable throwable;
    private final String type;

    /* compiled from: CloudEvent.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CloudEvent(String str, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, AnalyticsConstants.KEY_FEATURE, str2, "type", str3, "name");
        this.feature = str;
        this.type = str2;
        this.name = str3;
    }

    public final String getFeature() {
        return this.feature;
    }

    public final String getName() {
        return this.name;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getType() {
        return this.type;
    }

    public CloudEvent(String str, String str2, String str3, Throwable th) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, AnalyticsConstants.KEY_FEATURE, str2, "type", str3, "name");
        this.feature = str;
        this.type = str2;
        this.name = str3;
        this.throwable = th;
    }
}

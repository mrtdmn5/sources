package com.amplifyframework.statemachine.codegen.data;

import com.amplifyframework.auth.AuthException;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UserPoolConfiguration.kt */
/* loaded from: classes.dex */
public final class UserPoolConfiguration {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_REGION = "us-east-1";
    private final String appClient;
    private final String appClientSecret;
    private final Builder builder;
    private final String endpoint;
    private final String pinpointAppId;
    private final String poolId;
    private final String region;

    /* compiled from: UserPoolConfiguration.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String appClientId;
        private String appClientSecret;
        private String endpoint;
        private String pinpointAppId;
        private String poolId;
        private String region;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        private final String validateEndpoint(String str) throws AuthException {
            if (str != null) {
                try {
                    Pattern compile = Pattern.compile("^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$");
                    Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
                    if (!compile.matcher(str).matches()) {
                        throw new Exception("Invalid endpoint");
                    }
                } catch (Exception unused) {
                    throw new Exception(zzav$$ExternalSyntheticOutline0.m("Invalid endpoint value ", str, ". Expected fully qualified hostname with no scheme, no path and no query"));
                }
            }
            if (str != null) {
                return "https://".concat(str);
            }
            return null;
        }

        public final Builder appClientId(String appClientId) {
            Intrinsics.checkNotNullParameter(appClientId, "appClientId");
            this.appClientId = appClientId;
            return this;
        }

        public final Builder appClientSecret(String appClientSecret) {
            Intrinsics.checkNotNullParameter(appClientSecret, "appClientSecret");
            this.appClientSecret = appClientSecret;
            return this;
        }

        public final UserPoolConfiguration build() {
            return new UserPoolConfiguration(this);
        }

        public final Builder endpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.endpoint = validateEndpoint(endpoint);
            return this;
        }

        public final String getAppClientId() {
            return this.appClientId;
        }

        public final String getAppClientSecret() {
            return this.appClientSecret;
        }

        public final String getEndpoint() {
            return this.endpoint;
        }

        public final String getPinpointAppId() {
            return this.pinpointAppId;
        }

        public final String getPoolId() {
            return this.poolId;
        }

        public final String getRegion() {
            return this.region;
        }

        public final Builder pinpointAppId(String pinpointAppId) {
            Intrinsics.checkNotNullParameter(pinpointAppId, "pinpointAppId");
            this.pinpointAppId = pinpointAppId;
            return this;
        }

        public final Builder poolId(String poolId) {
            Intrinsics.checkNotNullParameter(poolId, "poolId");
            this.poolId = poolId;
            return this;
        }

        public final Builder region(String region) {
            Intrinsics.checkNotNullParameter(region, "region");
            this.region = region;
            return this;
        }

        public final void setAppClientId(String str) {
            this.appClientId = str;
        }

        public final void setAppClientSecret(String str) {
            this.appClientSecret = str;
        }

        public final void setEndpoint(String str) {
            this.endpoint = str;
        }

        public final void setPinpointAppId(String str) {
            this.pinpointAppId = str;
        }

        public final void setPoolId(String str) {
            this.poolId = str;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public Builder(JSONObject jSONObject) {
            this.region = UserPoolConfiguration.DEFAULT_REGION;
            if (jSONObject != null) {
                String optString = jSONObject.optString(Config.REGION.getKey());
                this.region = Boolean.valueOf(optString == null || optString.length() == 0).booleanValue() ? null : optString;
                String optString2 = jSONObject.optString(Config.ENDPOINT.getKey());
                this.endpoint = validateEndpoint(optString2 == null || optString2.length() == 0 ? null : optString2);
                String optString3 = jSONObject.optString(Config.POOL_ID.getKey());
                this.poolId = Boolean.valueOf(optString3 == null || optString3.length() == 0).booleanValue() ? null : optString3;
                String optString4 = jSONObject.optString(Config.APP_CLIENT_ID.getKey());
                this.appClientId = Boolean.valueOf(optString4 == null || optString4.length() == 0).booleanValue() ? null : optString4;
                String optString5 = jSONObject.optString(Config.APP_CLIENT_SECRET.getKey());
                this.appClientSecret = Boolean.valueOf(optString5 == null || optString5.length() == 0).booleanValue() ? null : optString5;
                String optString6 = jSONObject.optString(Config.PINPOINT_APP_ID.getKey());
                this.pinpointAppId = Boolean.valueOf(optString6 == null || optString6.length() == 0).booleanValue() ? null : optString6;
            }
        }

        public /* synthetic */ Builder(JSONObject jSONObject, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? null : jSONObject);
        }
    }

    /* compiled from: UserPoolConfiguration.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder() {
            return new Builder(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder fromJson$aws_auth_cognito_release(JSONObject configJson) {
            Intrinsics.checkNotNullParameter(configJson, "configJson");
            return new Builder(configJson);
        }

        public final UserPoolConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(null, 1, 0 == true ? 1 : 0);
            block.invoke(builder);
            return builder.build();
        }

        private Companion() {
        }
    }

    /* compiled from: UserPoolConfiguration.kt */
    /* loaded from: classes.dex */
    public enum Config {
        REGION("Region"),
        ENDPOINT("Endpoint"),
        POOL_ID("PoolId"),
        APP_CLIENT_ID("AppClientId"),
        APP_CLIENT_SECRET("AppClientSecret"),
        PINPOINT_APP_ID("PinpointAppId");

        private final String key;

        Config(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public UserPoolConfiguration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.region = builder.getRegion();
        this.endpoint = builder.getEndpoint();
        this.poolId = builder.getPoolId();
        this.appClient = builder.getAppClientId();
        this.appClientSecret = builder.getAppClientSecret();
        this.pinpointAppId = builder.getPinpointAppId();
    }

    public static final Builder builder() {
        return Companion.builder();
    }

    public static /* synthetic */ UserPoolConfiguration copy$default(UserPoolConfiguration userPoolConfiguration, Builder builder, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            builder = userPoolConfiguration.builder;
        }
        return userPoolConfiguration.copy(builder);
    }

    public final Builder component1() {
        return this.builder;
    }

    public final UserPoolConfiguration copy(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new UserPoolConfiguration(builder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UserPoolConfiguration) && Intrinsics.areEqual(this.builder, ((UserPoolConfiguration) obj).builder)) {
            return true;
        }
        return false;
    }

    public final String getAppClient() {
        return this.appClient;
    }

    public final String getAppClientSecret() {
        return this.appClientSecret;
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getPinpointAppId() {
        return this.pinpointAppId;
    }

    public final String getPoolId() {
        return this.poolId;
    }

    public final String getRegion() {
        return this.region;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public String toString() {
        return "UserPoolConfiguration(builder=" + this.builder + ')';
    }
}

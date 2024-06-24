package com.amplifyframework.statemachine.codegen.data;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IdentityPoolConfiguration.kt */
/* loaded from: classes.dex */
public final class IdentityPoolConfiguration {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_REGION = "us-east-1";
    private final Builder builder;
    private final String poolId;
    private final String region;

    /* compiled from: IdentityPoolConfiguration.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String poolId;
        private String region;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final IdentityPoolConfiguration build() {
            return new IdentityPoolConfiguration(this);
        }

        public final String getPoolId() {
            return this.poolId;
        }

        public final String getRegion() {
            return this.region;
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

        public final void setPoolId(String str) {
            this.poolId = str;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public Builder(JSONObject jSONObject) {
            this.region = IdentityPoolConfiguration.DEFAULT_REGION;
            if (jSONObject != null) {
                String optString = jSONObject.optString(Config.REGION.getKey());
                this.region = Boolean.valueOf(optString == null || optString.length() == 0).booleanValue() ? null : optString;
                String optString2 = jSONObject.optString(Config.POOL_ID.getKey());
                this.poolId = Boolean.valueOf(optString2 == null || optString2.length() == 0).booleanValue() ? null : optString2;
            }
        }

        public /* synthetic */ Builder(JSONObject jSONObject, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? null : jSONObject);
        }
    }

    /* compiled from: IdentityPoolConfiguration.kt */
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

        public final IdentityPoolConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(null, 1, 0 == true ? 1 : 0);
            block.invoke(builder);
            return builder.build();
        }

        private Companion() {
        }
    }

    /* compiled from: IdentityPoolConfiguration.kt */
    /* loaded from: classes.dex */
    public enum Config {
        REGION("Region"),
        POOL_ID("PoolId");

        private final String key;

        Config(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public IdentityPoolConfiguration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.region = builder.getRegion();
        this.poolId = builder.getPoolId();
    }

    public static final Builder builder() {
        return Companion.builder();
    }

    public static /* synthetic */ IdentityPoolConfiguration copy$default(IdentityPoolConfiguration identityPoolConfiguration, Builder builder, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            builder = identityPoolConfiguration.builder;
        }
        return identityPoolConfiguration.copy(builder);
    }

    public final Builder component1() {
        return this.builder;
    }

    public final IdentityPoolConfiguration copy(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new IdentityPoolConfiguration(builder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof IdentityPoolConfiguration) && Intrinsics.areEqual(this.builder, ((IdentityPoolConfiguration) obj).builder)) {
            return true;
        }
        return false;
    }

    public final Builder getBuilder() {
        return this.builder;
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
        return "IdentityPoolConfiguration(builder=" + this.builder + ')';
    }
}

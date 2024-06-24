package com.amplifyframework.statemachine.codegen.data;

import com.amplifyframework.auth.cognito.options.AuthFlowType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AuthConfiguration.kt */
/* loaded from: classes.dex */
public final class AuthConfiguration {
    public static final Companion Companion = new Companion(null);
    private final AuthFlowType authFlowType;
    private final IdentityPoolConfiguration identityPool;
    private final OauthConfiguration oauth;
    private final UserPoolConfiguration userPool;

    /* compiled from: AuthConfiguration.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AuthConfiguration fromJson$aws_auth_cognito_release$default(Companion companion, JSONObject jSONObject, String str, int r3, Object obj) {
            if ((r3 & 2) != 0) {
                str = "Default";
            }
            return companion.fromJson$aws_auth_cognito_release(jSONObject, str);
        }

        private final AuthFlowType getAuthenticationFlowType(String str) {
            boolean z;
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AuthFlowType[] values = AuthFlowType.values();
                int length = values.length;
                int r4 = 0;
                while (true) {
                    if (r4 >= length) {
                        break;
                    }
                    if (Intrinsics.areEqual(values[r4].name(), str)) {
                        z2 = true;
                        break;
                    }
                    r4++;
                }
                if (z2) {
                    return AuthFlowType.valueOf(str);
                }
            }
            return AuthFlowType.USER_SRP_AUTH;
        }

        public final AuthConfiguration fromJson$aws_auth_cognito_release(JSONObject pluginJson, String configName) {
            UserPoolConfiguration userPoolConfiguration;
            IdentityPoolConfiguration identityPoolConfiguration;
            OauthConfiguration oauthConfiguration;
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            JSONObject optJSONObject3;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            Intrinsics.checkNotNullParameter(pluginJson, "pluginJson");
            Intrinsics.checkNotNullParameter(configName, "configName");
            JSONObject optJSONObject4 = pluginJson.optJSONObject("CognitoUserPool");
            String str = null;
            if (optJSONObject4 != null && (jSONObject3 = optJSONObject4.getJSONObject(configName)) != null) {
                userPoolConfiguration = UserPoolConfiguration.Companion.fromJson$aws_auth_cognito_release(jSONObject3).build();
            } else {
                userPoolConfiguration = null;
            }
            JSONObject optJSONObject5 = pluginJson.optJSONObject("CredentialsProvider");
            if (optJSONObject5 != null && (jSONObject = optJSONObject5.getJSONObject("CognitoIdentity")) != null && (jSONObject2 = jSONObject.getJSONObject(configName)) != null) {
                identityPoolConfiguration = IdentityPoolConfiguration.Companion.fromJson$aws_auth_cognito_release(jSONObject2).build();
            } else {
                identityPoolConfiguration = null;
            }
            JSONObject optJSONObject6 = pluginJson.optJSONObject("Auth");
            if (optJSONObject6 != null && (optJSONObject2 = optJSONObject6.optJSONObject(configName)) != null && (optJSONObject3 = optJSONObject2.optJSONObject("OAuth")) != null) {
                oauthConfiguration = OauthConfiguration.Companion.fromJson(optJSONObject3);
            } else {
                oauthConfiguration = null;
            }
            JSONObject optJSONObject7 = pluginJson.optJSONObject("Auth");
            if (optJSONObject7 != null && (optJSONObject = optJSONObject7.optJSONObject(configName)) != null) {
                str = optJSONObject.optString("authenticationFlowType");
            }
            return new AuthConfiguration(userPoolConfiguration, identityPoolConfiguration, oauthConfiguration, getAuthenticationFlowType(str));
        }

        private Companion() {
        }
    }

    public AuthConfiguration(UserPoolConfiguration userPoolConfiguration, IdentityPoolConfiguration identityPoolConfiguration, OauthConfiguration oauthConfiguration, AuthFlowType authFlowType) {
        Intrinsics.checkNotNullParameter(authFlowType, "authFlowType");
        this.userPool = userPoolConfiguration;
        this.identityPool = identityPoolConfiguration;
        this.oauth = oauthConfiguration;
        this.authFlowType = authFlowType;
    }

    public static /* synthetic */ AuthConfiguration copy$default(AuthConfiguration authConfiguration, UserPoolConfiguration userPoolConfiguration, IdentityPoolConfiguration identityPoolConfiguration, OauthConfiguration oauthConfiguration, AuthFlowType authFlowType, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            userPoolConfiguration = authConfiguration.userPool;
        }
        if ((r5 & 2) != 0) {
            identityPoolConfiguration = authConfiguration.identityPool;
        }
        if ((r5 & 4) != 0) {
            oauthConfiguration = authConfiguration.oauth;
        }
        if ((r5 & 8) != 0) {
            authFlowType = authConfiguration.authFlowType;
        }
        return authConfiguration.copy(userPoolConfiguration, identityPoolConfiguration, oauthConfiguration, authFlowType);
    }

    public final UserPoolConfiguration component1() {
        return this.userPool;
    }

    public final IdentityPoolConfiguration component2() {
        return this.identityPool;
    }

    public final OauthConfiguration component3() {
        return this.oauth;
    }

    public final AuthFlowType component4() {
        return this.authFlowType;
    }

    public final AuthConfiguration copy(UserPoolConfiguration userPoolConfiguration, IdentityPoolConfiguration identityPoolConfiguration, OauthConfiguration oauthConfiguration, AuthFlowType authFlowType) {
        Intrinsics.checkNotNullParameter(authFlowType, "authFlowType");
        return new AuthConfiguration(userPoolConfiguration, identityPoolConfiguration, oauthConfiguration, authFlowType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthConfiguration)) {
            return false;
        }
        AuthConfiguration authConfiguration = (AuthConfiguration) obj;
        if (Intrinsics.areEqual(this.userPool, authConfiguration.userPool) && Intrinsics.areEqual(this.identityPool, authConfiguration.identityPool) && Intrinsics.areEqual(this.oauth, authConfiguration.oauth) && this.authFlowType == authConfiguration.authFlowType) {
            return true;
        }
        return false;
    }

    public final AuthFlowType getAuthFlowType() {
        return this.authFlowType;
    }

    public final IdentityPoolConfiguration getIdentityPool() {
        return this.identityPool;
    }

    public final OauthConfiguration getOauth() {
        return this.oauth;
    }

    public final UserPoolConfiguration getUserPool() {
        return this.userPool;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        UserPoolConfiguration userPoolConfiguration = this.userPool;
        int r1 = 0;
        if (userPoolConfiguration == null) {
            hashCode = 0;
        } else {
            hashCode = userPoolConfiguration.hashCode();
        }
        int r0 = hashCode * 31;
        IdentityPoolConfiguration identityPoolConfiguration = this.identityPool;
        if (identityPoolConfiguration == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = identityPoolConfiguration.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        OauthConfiguration oauthConfiguration = this.oauth;
        if (oauthConfiguration != null) {
            r1 = oauthConfiguration.hashCode();
        }
        return this.authFlowType.hashCode() + ((r02 + r1) * 31);
    }

    public String toString() {
        return "AuthConfiguration(userPool=" + this.userPool + ", identityPool=" + this.identityPool + ", oauth=" + this.oauth + ", authFlowType=" + this.authFlowType + ')';
    }
}

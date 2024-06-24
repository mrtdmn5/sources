package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class Auth {
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;

    /* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
    @Deprecated
    /* loaded from: classes3.dex */
    public static class AuthCredentialsOptions implements Api.ApiOptions {
        public static final AuthCredentialsOptions zba = new AuthCredentialsOptions(new Builder());
        public final boolean zbc;
        public final String zbd;

        /* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
        @Deprecated
        /* loaded from: classes3.dex */
        public static class Builder {
            public final Boolean zba;
            public String zbb;

            public Builder() {
                this.zba = Boolean.FALSE;
            }

            public Builder(AuthCredentialsOptions authCredentialsOptions) {
                this.zba = Boolean.FALSE;
                AuthCredentialsOptions authCredentialsOptions2 = AuthCredentialsOptions.zba;
                authCredentialsOptions.getClass();
                this.zba = Boolean.valueOf(authCredentialsOptions.zbc);
                this.zbb = authCredentialsOptions.zbd;
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.zbc = builder.zba.booleanValue();
            this.zbd = builder.zbb;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            authCredentialsOptions.getClass();
            if (Objects.equal(null, null) && this.zbc == authCredentialsOptions.zbc && Objects.equal(this.zbd, authCredentialsOptions.zbd)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{null, Boolean.valueOf(this.zbc), this.zbd});
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        new zba();
        zbb zbbVar = new zbb();
        Api<AuthProxyOptions> api = AuthProxy.API;
        GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zbbVar, clientKey);
    }
}

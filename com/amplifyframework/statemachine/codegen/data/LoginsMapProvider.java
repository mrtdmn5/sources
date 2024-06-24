package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginsMapProvider.kt */
/* loaded from: classes.dex */
public abstract class LoginsMapProvider {

    /* compiled from: LoginsMapProvider.kt */
    /* loaded from: classes.dex */
    public static final class AuthProviderLogins extends LoginsMapProvider {
        private final FederatedToken federatedToken;
        private final Map<String, String> logins;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthProviderLogins(FederatedToken federatedToken) {
            super(null);
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            this.federatedToken = federatedToken;
            this.logins = Rgb$$ExternalSyntheticLambda2.m(federatedToken.getProviderName(), federatedToken.getToken());
        }

        private final FederatedToken component1() {
            return this.federatedToken;
        }

        public static /* synthetic */ AuthProviderLogins copy$default(AuthProviderLogins authProviderLogins, FederatedToken federatedToken, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                federatedToken = authProviderLogins.federatedToken;
            }
            return authProviderLogins.copy(federatedToken);
        }

        public final AuthProviderLogins copy(FederatedToken federatedToken) {
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            return new AuthProviderLogins(federatedToken);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof AuthProviderLogins) && Intrinsics.areEqual(this.federatedToken, ((AuthProviderLogins) obj).federatedToken)) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.LoginsMapProvider
        public Map<String, String> getLogins() {
            return this.logins;
        }

        public int hashCode() {
            return this.federatedToken.hashCode();
        }

        public String toString() {
            return "AuthProviderLogins(federatedToken=" + this.federatedToken + ')';
        }
    }

    /* compiled from: LoginsMapProvider.kt */
    /* loaded from: classes.dex */
    public static final class CognitoUserPoolLogins extends LoginsMapProvider {
        private final String idToken;
        private final Map<String, String> logins;
        private final String poolId;
        private final String providerName;
        private final String region;

        public /* synthetic */ CognitoUserPoolLogins(String str, String str2, String str3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this((r5 & 1) != 0 ? "" : str, (r5 & 2) != 0 ? "" : str2, str3);
        }

        private final String component1() {
            return this.region;
        }

        private final String component2() {
            return this.poolId;
        }

        private final String component3() {
            return this.idToken;
        }

        public static /* synthetic */ CognitoUserPoolLogins copy$default(CognitoUserPoolLogins cognitoUserPoolLogins, String str, String str2, String str3, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = cognitoUserPoolLogins.region;
            }
            if ((r4 & 2) != 0) {
                str2 = cognitoUserPoolLogins.poolId;
            }
            if ((r4 & 4) != 0) {
                str3 = cognitoUserPoolLogins.idToken;
            }
            return cognitoUserPoolLogins.copy(str, str2, str3);
        }

        public final CognitoUserPoolLogins copy(String str, String str2, String idToken) {
            Intrinsics.checkNotNullParameter(idToken, "idToken");
            return new CognitoUserPoolLogins(str, str2, idToken);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CognitoUserPoolLogins)) {
                return false;
            }
            CognitoUserPoolLogins cognitoUserPoolLogins = (CognitoUserPoolLogins) obj;
            if (Intrinsics.areEqual(this.region, cognitoUserPoolLogins.region) && Intrinsics.areEqual(this.poolId, cognitoUserPoolLogins.poolId) && Intrinsics.areEqual(this.idToken, cognitoUserPoolLogins.idToken)) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.LoginsMapProvider
        public Map<String, String> getLogins() {
            return this.logins;
        }

        public final String getProviderName() {
            return this.providerName;
        }

        public int hashCode() {
            int hashCode;
            String str = this.region;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.poolId;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return this.idToken.hashCode() + ((r0 + r1) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CognitoUserPoolLogins(region=");
            sb.append(this.region);
            sb.append(", poolId=");
            sb.append(this.poolId);
            sb.append(", idToken=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.idToken, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CognitoUserPoolLogins(String str, String str2, String idToken) {
            super(null);
            Intrinsics.checkNotNullParameter(idToken, "idToken");
            this.region = str;
            this.poolId = str2;
            this.idToken = idToken;
            String str3 = "cognito-idp." + str + ".amazonaws.com/" + str2;
            this.providerName = str3;
            this.logins = Rgb$$ExternalSyntheticLambda2.m(str3, idToken);
        }
    }

    /* compiled from: LoginsMapProvider.kt */
    /* loaded from: classes.dex */
    public static final class UnAuthLogins extends LoginsMapProvider {
        private final Map<String, String> logins;

        public UnAuthLogins() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnAuthLogins copy$default(UnAuthLogins unAuthLogins, Map map, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                map = unAuthLogins.getLogins();
            }
            return unAuthLogins.copy(map);
        }

        public final Map<String, String> component1() {
            return getLogins();
        }

        public final UnAuthLogins copy(Map<String, String> logins) {
            Intrinsics.checkNotNullParameter(logins, "logins");
            return new UnAuthLogins(logins);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof UnAuthLogins) && Intrinsics.areEqual(getLogins(), ((UnAuthLogins) obj).getLogins())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.LoginsMapProvider
        public Map<String, String> getLogins() {
            return this.logins;
        }

        public int hashCode() {
            return getLogins().hashCode();
        }

        public String toString() {
            return "UnAuthLogins(logins=" + getLogins() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnAuthLogins(Map<String, String> logins) {
            super(null);
            Intrinsics.checkNotNullParameter(logins, "logins");
            this.logins = logins;
        }

        public /* synthetic */ UnAuthLogins(Map map, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? EmptyMap.INSTANCE : map);
        }
    }

    public /* synthetic */ LoginsMapProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Map<String, String> getLogins();

    private LoginsMapProvider() {
    }
}

package aws.sdk.kotlin.services.cognitoidentityprovider.model;

/* compiled from: AuthFlowType.kt */
/* loaded from: classes.dex */
public abstract class AuthFlowType {

    /* compiled from: AuthFlowType.kt */
    /* loaded from: classes.dex */
    public static final class CustomAuth extends AuthFlowType {
        public static final CustomAuth INSTANCE = new CustomAuth();
        public static final String value = "CUSTOM_AUTH";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: AuthFlowType.kt */
    /* loaded from: classes.dex */
    public static final class RefreshToken extends AuthFlowType {
        public static final RefreshToken INSTANCE = new RefreshToken();
        public static final String value = "REFRESH_TOKEN";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: AuthFlowType.kt */
    /* loaded from: classes.dex */
    public static final class UserPasswordAuth extends AuthFlowType {
        public static final UserPasswordAuth INSTANCE = new UserPasswordAuth();
        public static final String value = "USER_PASSWORD_AUTH";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: AuthFlowType.kt */
    /* loaded from: classes.dex */
    public static final class UserSrpAuth extends AuthFlowType {
        public static final UserSrpAuth INSTANCE = new UserSrpAuth();
        public static final String value = "USER_SRP_AUTH";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    public abstract String getValue();
}

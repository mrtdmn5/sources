package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeNameType.kt */
/* loaded from: classes.dex */
public abstract class ChallengeNameType {

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class AdminNoSrpAuth extends ChallengeNameType {
        public static final AdminNoSrpAuth INSTANCE = new AdminNoSrpAuth();
        public static final String value = "ADMIN_NO_SRP_AUTH";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        public static ChallengeNameType fromValue(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            switch (str.hashCode()) {
                case -1737337862:
                    if (str.equals("PASSWORD_VERIFIER")) {
                        return PasswordVerifier.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case -1362602558:
                    if (str.equals("SMS_MFA")) {
                        return SmsMfa.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 161754570:
                    if (str.equals("SOFTWARE_TOKEN_MFA")) {
                        return SoftwareTokenMfa.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 325396255:
                    if (str.equals("DEVICE_SRP_AUTH")) {
                        return DeviceSrpAuth.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 338106308:
                    if (str.equals("NEW_PASSWORD_REQUIRED")) {
                        return NewPasswordRequired.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 359356710:
                    if (str.equals("MFA_SETUP")) {
                        return MfaSetup.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 645737717:
                    if (str.equals("CUSTOM_CHALLENGE")) {
                        return CustomChallenge.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 872896308:
                    if (str.equals("SELECT_MFA_TYPE")) {
                        return SelectMfaType.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 1330737924:
                    if (str.equals("ADMIN_NO_SRP_AUTH")) {
                        return AdminNoSrpAuth.INSTANCE;
                    }
                    return new SdkUnknown(str);
                case 1362077265:
                    if (str.equals("DEVICE_PASSWORD_VERIFIER")) {
                        return DevicePasswordVerifier.INSTANCE;
                    }
                    return new SdkUnknown(str);
                default:
                    return new SdkUnknown(str);
            }
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class CustomChallenge extends ChallengeNameType {
        public static final CustomChallenge INSTANCE = new CustomChallenge();
        public static final String value = "CUSTOM_CHALLENGE";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class DevicePasswordVerifier extends ChallengeNameType {
        public static final DevicePasswordVerifier INSTANCE = new DevicePasswordVerifier();
        public static final String value = "DEVICE_PASSWORD_VERIFIER";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class DeviceSrpAuth extends ChallengeNameType {
        public static final DeviceSrpAuth INSTANCE = new DeviceSrpAuth();
        public static final String value = "DEVICE_SRP_AUTH";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class MfaSetup extends ChallengeNameType {
        public static final MfaSetup INSTANCE = new MfaSetup();
        public static final String value = "MFA_SETUP";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class NewPasswordRequired extends ChallengeNameType {
        public static final NewPasswordRequired INSTANCE = new NewPasswordRequired();
        public static final String value = "NEW_PASSWORD_REQUIRED";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class PasswordVerifier extends ChallengeNameType {
        public static final PasswordVerifier INSTANCE = new PasswordVerifier();
        public static final String value = "PASSWORD_VERIFIER";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class SdkUnknown extends ChallengeNameType {
        public final String value;

        public SdkUnknown(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SdkUnknown)) {
                return false;
            }
            if (Intrinsics.areEqual(this.value, ((SdkUnknown) obj).value)) {
                return true;
            }
            return false;
        }

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return this.value;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }

        public final String toString() {
            return this.value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class SelectMfaType extends ChallengeNameType {
        public static final SelectMfaType INSTANCE = new SelectMfaType();
        public static final String value = "SELECT_MFA_TYPE";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class SmsMfa extends ChallengeNameType {
        public static final SmsMfa INSTANCE = new SmsMfa();
        public static final String value = "SMS_MFA";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: ChallengeNameType.kt */
    /* loaded from: classes.dex */
    public static final class SoftwareTokenMfa extends ChallengeNameType {
        public static final SoftwareTokenMfa INSTANCE = new SoftwareTokenMfa();
        public static final String value = "SOFTWARE_TOKEN_MFA";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    public abstract String getValue();
}

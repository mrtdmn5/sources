package aws.sdk.kotlin.services.cognitoidentityprovider.model;

/* compiled from: DeviceRememberedStatusType.kt */
/* loaded from: classes.dex */
public abstract class DeviceRememberedStatusType {

    /* compiled from: DeviceRememberedStatusType.kt */
    /* loaded from: classes.dex */
    public static final class NotRemembered extends DeviceRememberedStatusType {
        public static final NotRemembered INSTANCE = new NotRemembered();
        public static final String value = "not_remembered";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceRememberedStatusType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: DeviceRememberedStatusType.kt */
    /* loaded from: classes.dex */
    public static final class Remembered extends DeviceRememberedStatusType {
        public static final Remembered INSTANCE = new Remembered();
        public static final String value = "remembered";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceRememberedStatusType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    public abstract String getValue();
}

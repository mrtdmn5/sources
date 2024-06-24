package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeliveryMediumType.kt */
/* loaded from: classes.dex */
public abstract class DeliveryMediumType {

    /* compiled from: DeliveryMediumType.kt */
    /* loaded from: classes.dex */
    public static final class Email extends DeliveryMediumType {
        public static final Email INSTANCE = new Email();
        public static final String value = "EMAIL";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    /* compiled from: DeliveryMediumType.kt */
    /* loaded from: classes.dex */
    public static final class SdkUnknown extends DeliveryMediumType {
        public final String value;

        public SdkUnknown(String str) {
            this.value = str;
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

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType
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

    /* compiled from: DeliveryMediumType.kt */
    /* loaded from: classes.dex */
    public static final class Sms extends DeliveryMediumType {
        public static final Sms INSTANCE = new Sms();
        public static final String value = "SMS";

        @Override // aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType
        public final String getValue() {
            return value;
        }

        public final String toString() {
            return value;
        }
    }

    public abstract String getValue();
}

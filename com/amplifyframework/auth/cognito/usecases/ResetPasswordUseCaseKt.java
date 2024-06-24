package com.amplifyframework.auth.cognito.usecases;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;

/* compiled from: ResetPasswordUseCase.kt */
/* loaded from: classes.dex */
public final class ResetPasswordUseCaseKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final AuthCodeDeliveryDetails toAuthCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        if (codeDeliveryDetailsType == 0) {
            return (AuthCodeDeliveryDetails) codeDeliveryDetailsType;
        }
        String str = codeDeliveryDetailsType.destination;
        if (str != null) {
            return new AuthCodeDeliveryDetails(String.valueOf(str), AuthCodeDeliveryDetails.DeliveryMedium.fromString(String.valueOf(codeDeliveryDetailsType.deliveryMedium)), codeDeliveryDetailsType.attributeName);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

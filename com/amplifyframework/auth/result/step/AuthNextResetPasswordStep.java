package com.amplifyframework.auth.result.step;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthNextResetPasswordStep {
    private final Map<String, String> additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthResetPasswordStep resetPasswordStep;

    public AuthNextResetPasswordStep(AuthResetPasswordStep authResetPasswordStep, Map<String, String> map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authResetPasswordStep);
        this.resetPasswordStep = authResetPasswordStep;
        HashMap hashMap = new HashMap();
        this.additionalInfo = hashMap;
        Objects.requireNonNull(map);
        hashMap.putAll(map);
        this.codeDeliveryDetails = authCodeDeliveryDetails;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthNextResetPasswordStep.class != obj.getClass()) {
            return false;
        }
        AuthNextResetPasswordStep authNextResetPasswordStep = (AuthNextResetPasswordStep) obj;
        if (ObjectsCompat$Api19Impl.equals(getResetPasswordStep(), authNextResetPasswordStep.getResetPasswordStep()) && ObjectsCompat$Api19Impl.equals(getAdditionalInfo(), authNextResetPasswordStep.getAdditionalInfo()) && ObjectsCompat$Api19Impl.equals(getCodeDeliveryDetails(), authNextResetPasswordStep.getCodeDeliveryDetails())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public AuthCodeDeliveryDetails getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public AuthResetPasswordStep getResetPasswordStep() {
        return this.resetPasswordStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getResetPasswordStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextResetPasswordStep{resetPasswordStep=" + getResetPasswordStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}

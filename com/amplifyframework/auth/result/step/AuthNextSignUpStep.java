package com.amplifyframework.auth.result.step;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthNextSignUpStep {
    private final Map<String, String> additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthSignUpStep signUpStep;

    public AuthNextSignUpStep(AuthSignUpStep authSignUpStep, Map<String, String> map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authSignUpStep);
        this.signUpStep = authSignUpStep;
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
        if (obj == null || AuthNextSignUpStep.class != obj.getClass()) {
            return false;
        }
        AuthNextSignUpStep authNextSignUpStep = (AuthNextSignUpStep) obj;
        if (ObjectsCompat$Api19Impl.equals(getSignUpStep(), authNextSignUpStep.getSignUpStep()) && ObjectsCompat$Api19Impl.equals(getAdditionalInfo(), authNextSignUpStep.getAdditionalInfo()) && ObjectsCompat$Api19Impl.equals(getCodeDeliveryDetails(), authNextSignUpStep.getCodeDeliveryDetails())) {
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

    public AuthSignUpStep getSignUpStep() {
        return this.signUpStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getSignUpStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextSignUpStep{signUpStep=" + getSignUpStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}

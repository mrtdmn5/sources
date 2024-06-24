package com.amplifyframework.auth.result.step;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthNextSignInStep {
    private final Map<String, String> additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthSignInStep signInStep;

    public AuthNextSignInStep(AuthSignInStep authSignInStep, Map<String, String> map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authSignInStep);
        this.signInStep = authSignInStep;
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
        if (obj == null || AuthNextSignInStep.class != obj.getClass()) {
            return false;
        }
        AuthNextSignInStep authNextSignInStep = (AuthNextSignInStep) obj;
        if (ObjectsCompat$Api19Impl.equals(getSignInStep(), authNextSignInStep.getSignInStep()) && ObjectsCompat$Api19Impl.equals(getAdditionalInfo(), authNextSignInStep.getAdditionalInfo()) && ObjectsCompat$Api19Impl.equals(getCodeDeliveryDetails(), authNextSignInStep.getCodeDeliveryDetails())) {
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

    public AuthSignInStep getSignInStep() {
        return this.signInStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getSignInStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextSignInStep{signInStep=" + getSignInStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}

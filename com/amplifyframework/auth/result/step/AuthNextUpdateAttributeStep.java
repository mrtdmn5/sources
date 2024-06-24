package com.amplifyframework.auth.result.step;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthNextUpdateAttributeStep {
    private final Map<String, String> additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthUpdateAttributeStep updateAttributeStep;

    public AuthNextUpdateAttributeStep(AuthUpdateAttributeStep authUpdateAttributeStep, Map<String, String> map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authUpdateAttributeStep);
        this.updateAttributeStep = authUpdateAttributeStep;
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
        if (obj == null || AuthNextUpdateAttributeStep.class != obj.getClass()) {
            return false;
        }
        AuthNextUpdateAttributeStep authNextUpdateAttributeStep = (AuthNextUpdateAttributeStep) obj;
        if (ObjectsCompat$Api19Impl.equals(getUpdateAttributeStep(), authNextUpdateAttributeStep.getUpdateAttributeStep()) && ObjectsCompat$Api19Impl.equals(getAdditionalInfo(), authNextUpdateAttributeStep.getAdditionalInfo()) && ObjectsCompat$Api19Impl.equals(getCodeDeliveryDetails(), authNextUpdateAttributeStep.getCodeDeliveryDetails())) {
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

    public AuthUpdateAttributeStep getUpdateAttributeStep() {
        return this.updateAttributeStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getUpdateAttributeStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextUpdateAttributeStep{updateAttributeStep=" + getUpdateAttributeStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}

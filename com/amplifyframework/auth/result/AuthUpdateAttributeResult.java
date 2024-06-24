package com.amplifyframework.auth.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.result.step.AuthNextUpdateAttributeStep;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthUpdateAttributeResult {
    private final boolean isUpdated;
    private final AuthNextUpdateAttributeStep nextStep;

    public AuthUpdateAttributeResult(boolean z, AuthNextUpdateAttributeStep authNextUpdateAttributeStep) {
        this.isUpdated = z;
        Objects.requireNonNull(authNextUpdateAttributeStep);
        this.nextStep = authNextUpdateAttributeStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUpdateAttributeResult.class != obj.getClass()) {
            return false;
        }
        AuthUpdateAttributeResult authUpdateAttributeResult = (AuthUpdateAttributeResult) obj;
        if (ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isUpdated()), Boolean.valueOf(authUpdateAttributeResult.isUpdated())) && ObjectsCompat$Api19Impl.equals(getNextStep(), authUpdateAttributeResult.getNextStep())) {
            return true;
        }
        return false;
    }

    public AuthNextUpdateAttributeStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isUpdated()), getNextStep());
    }

    public boolean isUpdated() {
        return this.isUpdated;
    }

    public String toString() {
        return "AuthUpdateAttributeResult{isUpdated=" + isUpdated() + ", nextStep=" + getNextStep() + '}';
    }
}

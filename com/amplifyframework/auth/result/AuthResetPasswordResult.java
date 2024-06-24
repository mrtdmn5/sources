package com.amplifyframework.auth.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.result.step.AuthNextResetPasswordStep;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthResetPasswordResult {
    private final boolean isPasswordReset;
    private final AuthNextResetPasswordStep nextStep;

    public AuthResetPasswordResult(boolean z, AuthNextResetPasswordStep authNextResetPasswordStep) {
        this.isPasswordReset = z;
        Objects.requireNonNull(authNextResetPasswordStep);
        this.nextStep = authNextResetPasswordStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthResetPasswordResult.class != obj.getClass()) {
            return false;
        }
        AuthResetPasswordResult authResetPasswordResult = (AuthResetPasswordResult) obj;
        if (ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isPasswordReset()), Boolean.valueOf(authResetPasswordResult.isPasswordReset())) && ObjectsCompat$Api19Impl.equals(getNextStep(), authResetPasswordResult.getNextStep())) {
            return true;
        }
        return false;
    }

    public AuthNextResetPasswordStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isPasswordReset()), getNextStep());
    }

    public boolean isPasswordReset() {
        return this.isPasswordReset;
    }

    public String toString() {
        return "AuthResetPasswordResult{isPasswordReset=" + isPasswordReset() + ", nextStep=" + getNextStep() + '}';
    }
}

package com.amplifyframework.auth.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.result.step.AuthNextSignUpStep;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthSignUpResult {
    private final boolean isSignUpComplete;
    private final AuthNextSignUpStep nextStep;
    private final String userId;

    public AuthSignUpResult(boolean z, AuthNextSignUpStep authNextSignUpStep, String str) {
        this.isSignUpComplete = z;
        Objects.requireNonNull(authNextSignUpStep);
        this.nextStep = authNextSignUpStep;
        this.userId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthSignUpResult.class != obj.getClass()) {
            return false;
        }
        AuthSignUpResult authSignUpResult = (AuthSignUpResult) obj;
        if (ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isSignUpComplete()), Boolean.valueOf(authSignUpResult.isSignUpComplete())) && ObjectsCompat$Api19Impl.equals(getNextStep(), authSignUpResult.getNextStep()) && ObjectsCompat$Api19Impl.equals(getUserId(), authSignUpResult.getUserId())) {
            return true;
        }
        return false;
    }

    public AuthNextSignUpStep getNextStep() {
        return this.nextStep;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isSignUpComplete()), getNextStep(), getUserId());
    }

    public boolean isSignUpComplete() {
        return this.isSignUpComplete;
    }

    public String toString() {
        return "AuthSignUpResult{isSignUpComplete=" + isSignUpComplete() + ", nextStep=" + getNextStep() + ", userId=" + getUserId() + '}';
    }
}

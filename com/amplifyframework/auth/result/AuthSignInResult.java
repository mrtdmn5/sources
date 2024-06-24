package com.amplifyframework.auth.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.result.step.AuthNextSignInStep;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthSignInResult {
    private final boolean isSignedIn;
    private final AuthNextSignInStep nextStep;

    public AuthSignInResult(boolean z, AuthNextSignInStep authNextSignInStep) {
        this.isSignedIn = z;
        Objects.requireNonNull(authNextSignInStep);
        this.nextStep = authNextSignInStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthSignInResult.class != obj.getClass()) {
            return false;
        }
        AuthSignInResult authSignInResult = (AuthSignInResult) obj;
        if (ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isSignedIn()), Boolean.valueOf(authSignInResult.isSignedIn())) && ObjectsCompat$Api19Impl.equals(getNextStep(), authSignInResult.getNextStep())) {
            return true;
        }
        return false;
    }

    public AuthNextSignInStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isSignedIn()), getNextStep());
    }

    public boolean isSignedIn() {
        return this.isSignedIn;
    }

    public String toString() {
        return "AuthSignInResult{isSignedIn=" + isSignedIn() + ", nextStep=" + getNextStep() + '}';
    }
}

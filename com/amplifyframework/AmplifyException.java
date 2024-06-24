package com.amplifyframework;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public class AmplifyException extends Exception {
    public static final String REPORT_BUG_TO_AWS_SUGGESTION = "There is a possibility that there is a bug if this error persists. Please take a look at \nhttps://github.com/aws-amplify/amplify-android/issues to see if there are any existing issues that \nmatch your scenario, and file an issue with the details of the bug if there isn't.";
    public static final String TODO_RECOVERY_SUGGESTION = "Sorry, we don't have a suggested fix for this error yet.";
    private static final long serialVersionUID = 1;
    private final String recoverySuggestion;

    public AmplifyException(String str, Throwable th, String str2) {
        super(str, th);
        Objects.requireNonNull(str2);
        this.recoverySuggestion = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AmplifyException)) {
            return false;
        }
        AmplifyException amplifyException = (AmplifyException) obj;
        if (ObjectsCompat$Api19Impl.equals(getRecoverySuggestion(), amplifyException.getRecoverySuggestion()) && ObjectsCompat$Api19Impl.equals(getMessage(), amplifyException.getMessage()) && ObjectsCompat$Api19Impl.equals(getCause(), amplifyException.getCause())) {
            return true;
        }
        return false;
    }

    public final String getRecoverySuggestion() {
        return this.recoverySuggestion;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getRecoverySuggestion(), getMessage(), getCause());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getSimpleName() + "{message=" + getMessage() + ", cause=" + getCause() + ", recoverySuggestion=" + getRecoverySuggestion() + '}';
    }

    public AmplifyException(String str, String str2) {
        super(str);
        Objects.requireNonNull(str2);
        this.recoverySuggestion = str2;
    }
}

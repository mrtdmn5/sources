package com.amplifyframework.core;

import java.util.Objects;

/* loaded from: classes.dex */
public final class InitializationResult {
    private final Throwable failure;
    private final InitializationStatus initializationStatus;

    private InitializationResult(InitializationStatus initializationStatus, Throwable th) {
        this.initializationStatus = initializationStatus;
        this.failure = th;
    }

    public static InitializationResult failure(Throwable th) {
        Objects.requireNonNull(th);
        return new InitializationResult(InitializationStatus.FAILED, th);
    }

    public static InitializationResult success() {
        return new InitializationResult(InitializationStatus.SUCCEEDED, null);
    }

    public Throwable getFailure() {
        return this.failure;
    }

    public InitializationStatus getInitializationStatus() {
        return this.initializationStatus;
    }

    public boolean isFailure() {
        return InitializationStatus.FAILED.equals(this.initializationStatus);
    }

    public boolean isSuccess() {
        return InitializationStatus.SUCCEEDED.equals(this.initializationStatus);
    }
}

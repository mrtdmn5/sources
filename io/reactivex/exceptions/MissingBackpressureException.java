package io.reactivex.exceptions;

/* loaded from: classes3.dex */
public final class MissingBackpressureException extends RuntimeException {
    public MissingBackpressureException() {
    }

    public MissingBackpressureException(int r1) {
        super("Inner queue full?!");
    }
}

package app.cash.sqldelight;

/* compiled from: Transacter.kt */
/* loaded from: classes.dex */
public final class RollbackException extends Throwable {
    public final Object value;

    public RollbackException() {
        this(0);
    }

    public RollbackException(int r1) {
        this.value = null;
    }
}

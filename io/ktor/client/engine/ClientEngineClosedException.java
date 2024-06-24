package io.ktor.client.engine;

/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes3.dex */
public final class ClientEngineClosedException extends IllegalStateException {
    public final Throwable cause;

    public ClientEngineClosedException() {
        this(0);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }

    public ClientEngineClosedException(int r1) {
        super("Client already closed");
        this.cause = null;
    }
}

package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.ClientException;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes.dex */
public final class HttpClientEngineClosedException extends ClientException {
    public final Throwable cause;

    public HttpClientEngineClosedException() {
        this(0);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }

    public HttpClientEngineClosedException(int r1) {
        super("HttpClientEngine already closed");
        this.cause = null;
    }
}

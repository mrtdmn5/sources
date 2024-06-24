package io.ktor.client.network.sockets;

import java.net.ConnectException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeoutExceptions.kt */
/* loaded from: classes3.dex */
public final class ConnectTimeoutException extends ConnectException {
    public final Throwable cause;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectTimeoutException(String message, Throwable th) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }
}

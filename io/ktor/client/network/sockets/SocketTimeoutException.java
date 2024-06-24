package io.ktor.client.network.sockets;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeoutExceptions.kt */
/* loaded from: classes3.dex */
public final class SocketTimeoutException extends java.net.SocketTimeoutException {
    public final Throwable cause;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketTimeoutException(String message, Throwable th) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }
}

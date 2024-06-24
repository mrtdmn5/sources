package io.ktor.websocket;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: ProtocolViolationException.kt */
/* loaded from: classes3.dex */
public final class ProtocolViolationException extends Exception implements CopyableThrowable<ProtocolViolationException> {
    public final String violation;

    public ProtocolViolationException(String violation) {
        Intrinsics.checkNotNullParameter(violation, "violation");
        this.violation = violation;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final ProtocolViolationException createCopy() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException(this.violation);
        protocolViolationException.initCause(this);
        return protocolViolationException;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Received illegal frame: " + this.violation;
    }
}

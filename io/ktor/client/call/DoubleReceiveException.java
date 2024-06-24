package io.ktor.client.call;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes3.dex */
public final class DoubleReceiveException extends IllegalStateException {
    public final String message;

    public DoubleReceiveException(HttpClientCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.message = "Response already received: " + call;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}

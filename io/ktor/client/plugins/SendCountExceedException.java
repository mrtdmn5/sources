package io.ktor.client.plugins;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpSend.kt */
/* loaded from: classes3.dex */
public final class SendCountExceedException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendCountExceedException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}

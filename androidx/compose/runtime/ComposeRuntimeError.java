package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposeRuntimeError extends IllegalStateException {
    public final String message;

    public ComposeRuntimeError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}

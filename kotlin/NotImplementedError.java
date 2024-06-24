package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Standard.kt */
/* loaded from: classes.dex */
public final class NotImplementedError extends Error {
    public /* synthetic */ NotImplementedError() {
        this("An operation is not implemented.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}

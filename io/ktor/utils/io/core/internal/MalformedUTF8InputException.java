package io.ktor.utils.io.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UTF8.kt */
/* loaded from: classes3.dex */
public final class MalformedUTF8InputException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MalformedUTF8InputException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}

package io.ktor.utils.io.core.internal;

/* compiled from: Numbers.kt */
/* loaded from: classes3.dex */
public final class NumbersKt {
    public static final void failLongToIntConversion(long j, String str) {
        throw new IllegalArgumentException("Long value " + j + " of " + str + " doesn't fit into 32-bit integer");
    }
}

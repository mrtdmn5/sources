package io.ktor.client.plugins;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import org.slf4j.Logger;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes3.dex */
public final class HttpTimeoutKt {
    public static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpTimeout");

    public static final int convertLongTimeoutToIntWithInfiniteAsZero(long j) {
        if (j == Long.MAX_VALUE) {
            return 0;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }
}

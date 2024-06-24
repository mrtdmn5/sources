package io.ktor.client.plugins;

import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Unit;
import org.slf4j.Logger;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes3.dex */
public final class DefaultResponseValidationKt {
    public static final AttributeKey<Unit> ValidateMark = new AttributeKey<>("ValidateMark");
    public static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultResponseValidation");
}

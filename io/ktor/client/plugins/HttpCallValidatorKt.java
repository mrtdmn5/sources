package io.ktor.client.plugins;

import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import org.slf4j.Logger;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes3.dex */
public final class HttpCallValidatorKt {
    public static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCallValidator");
    public static final AttributeKey<Boolean> ExpectSuccessAttributeKey = new AttributeKey<>("ExpectSuccessAttributeKey");
}

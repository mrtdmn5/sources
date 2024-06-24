package io.ktor.client.plugins.logging;

import io.ktor.util.AttributeKey;
import kotlin.Unit;

/* compiled from: Logging.kt */
/* loaded from: classes3.dex */
public final class LoggingKt {
    public static final AttributeKey<HttpClientCallLogger> ClientCallLogger = new AttributeKey<>("CallLogger");
    public static final AttributeKey<Unit> DisableLogging = new AttributeKey<>("DisableLogging");
}

package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: ContentNegotiation.kt */
/* loaded from: classes3.dex */
public final class ContentNegotiationKt {
    public static final Set<KClass<?>> DefaultCommonIgnoredTypes;
    public static final Logger LOGGER;

    static {
        Logger logger = LoggerFactory.getLogger("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(name)");
        LOGGER = logger;
        DefaultCommonIgnoredTypes = SetsKt__SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class)});
    }
}

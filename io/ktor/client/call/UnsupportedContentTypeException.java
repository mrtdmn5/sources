package io.ktor.client.call;

import io.ktor.http.content.OutgoingContent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class UnsupportedContentTypeException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedContentTypeException(OutgoingContent content) {
        super("Failed to write body: " + Reflection.getOrCreateKotlinClass(content.getClass()));
        Intrinsics.checkNotNullParameter(content, "content");
    }
}

package io.ktor.client.utils;

import io.ktor.http.content.OutgoingContent;

/* compiled from: Content.kt */
/* loaded from: classes3.dex */
public final class EmptyContent extends OutgoingContent.NoContent {
    public static final EmptyContent INSTANCE = new EmptyContent();

    @Override // io.ktor.http.content.OutgoingContent
    public final Long getContentLength() {
        return 0L;
    }

    public final String toString() {
        return "EmptyContent";
    }
}

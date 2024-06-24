package io.ktor.client.plugins.logging;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggedContent.kt */
/* loaded from: classes3.dex */
public final class LoggedContent extends OutgoingContent.ReadChannelContent {
    public final ByteReadChannel channel;
    public final Long contentLength;
    public final ContentType contentType;
    public final Headers headers;
    public final HttpStatusCode status;

    public LoggedContent(OutgoingContent originalContent, ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(originalContent, "originalContent");
        this.channel = byteBufferChannel;
        this.contentType = originalContent.getContentType();
        this.contentLength = originalContent.getContentLength();
        this.status = originalContent.getStatus();
        this.headers = originalContent.getHeaders();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long getContentLength() {
        return this.contentLength;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Headers getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public final ByteReadChannel readFrom() {
        return this.channel;
    }
}

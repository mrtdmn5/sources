package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayContent.kt */
/* loaded from: classes3.dex */
public final class ByteArrayContent extends OutgoingContent.ByteArrayContent {
    public final byte[] bytes;
    public final ContentType contentType;
    public final HttpStatusCode status;

    public ByteArrayContent(byte[] bytes, ContentType contentType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.contentType = contentType;
        this.status = null;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public final byte[] bytes() {
        return this.bytes;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long getContentLength() {
        return Long.valueOf(this.bytes.length);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final HttpStatusCode getStatus() {
        return this.status;
    }
}

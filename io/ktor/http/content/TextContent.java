package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: TextContent.kt */
/* loaded from: classes3.dex */
public final class TextContent extends OutgoingContent.ByteArrayContent {
    public final byte[] bytes;
    public final ContentType contentType;
    public final HttpStatusCode status;
    public final String text;

    public TextContent(String text, ContentType contentType) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.text = text;
        this.contentType = contentType;
        this.status = null;
        Charset charset = ContentTypesKt.charset(contentType);
        charset = charset == null ? Charsets.UTF_8 : charset;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(text);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, text, text.length());
        }
        this.bytes = encodeToByteArray;
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

    public final String toString() {
        return "TextContent[" + this.contentType + "] \"" + StringsKt___StringsKt.take(30, this.text) + '\"';
    }
}

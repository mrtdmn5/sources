package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.EmptyHeaders;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: OutgoingContent.kt */
/* loaded from: classes3.dex */
public abstract class OutgoingContent {

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes3.dex */
    public static abstract class ByteArrayContent extends OutgoingContent {
        public abstract byte[] bytes();
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes3.dex */
    public static abstract class NoContent extends OutgoingContent {
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes3.dex */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public abstract ByteReadChannel readFrom();
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes3.dex */
    public static abstract class WriteChannelContent extends OutgoingContent {
        public abstract Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation);
    }

    public Long getContentLength() {
        return null;
    }

    public ContentType getContentType() {
        return null;
    }

    public Headers getHeaders() {
        Headers.Companion.getClass();
        return EmptyHeaders.INSTANCE;
    }

    public HttpStatusCode getStatus() {
        return null;
    }
}

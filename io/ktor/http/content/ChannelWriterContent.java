package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;

/* compiled from: ChannelWriterContent.kt */
/* loaded from: classes3.dex */
public final class ChannelWriterContent extends OutgoingContent.WriteChannelContent {
    public final Function2<ByteWriteChannel, Continuation<? super Unit>, Object> body;
    public final ContentType contentType;
    public final HttpStatusCode status = null;
    public final Long contentLength = null;

    public ChannelWriterContent(KotlinxSerializationJsonExtensions$serialize$2 kotlinxSerializationJsonExtensions$serialize$2, ContentType contentType) {
        this.body = kotlinxSerializationJsonExtensions$serialize$2;
        this.contentType = contentType;
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
    public final HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public final Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        Object invoke = this.body.invoke(byteWriteChannel, continuation);
        if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return invoke;
        }
        return Unit.INSTANCE;
    }
}

package io.ktor.client.content;

import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: ObservableContent.kt */
/* loaded from: classes3.dex */
public final class ObservableContent extends OutgoingContent.ReadChannelContent {
    public final CoroutineContext callContext;
    public final ByteReadChannel content;
    public final OutgoingContent delegate;
    public final Function3<Long, Long, Continuation<? super Unit>, Object> listener;

    public ObservableContent(OutgoingContent outgoingContent, Job callContext, Function3 function3) {
        ByteReadChannel byteReadChannel;
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.callContext = callContext;
        this.listener = function3;
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byteReadChannel = ByteChannelCtorKt.ByteReadChannel(((OutgoingContent.ByteArrayContent) outgoingContent).bytes());
        } else if (outgoingContent instanceof OutgoingContent.NoContent) {
            ByteReadChannel.Companion.getClass();
            byteReadChannel = (ByteReadChannel) ByteReadChannel.Companion.Empty$delegate.getValue();
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            byteReadChannel = ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
        } else if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            byteReadChannel = CoroutinesKt.writer(GlobalScope.INSTANCE, callContext, true, new ObservableContent$content$1(outgoingContent, null)).channel;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.content = byteReadChannel;
        this.delegate = outgoingContent;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType getContentType() {
        return this.delegate.getContentType();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Headers getHeaders() {
        return this.delegate.getHeaders();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final HttpStatusCode getStatus() {
        return this.delegate.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public final ByteReadChannel readFrom() {
        return ByteChannelUtilsKt.observable(this.content, this.callContext, getContentLength(), this.listener);
    }
}

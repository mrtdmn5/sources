package aws.smithy.kotlin.runtime.http.content;

import aws.smithy.kotlin.runtime.http.HttpBody;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayContent.kt */
/* loaded from: classes.dex */
public final class ByteArrayContent extends HttpBody.Bytes {
    public final byte[] bytes;
    public final long contentLength;

    public ByteArrayContent(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.contentLength = bytes.length;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody.Bytes
    public final byte[] bytes() {
        return this.bytes;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody
    public final Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }
}

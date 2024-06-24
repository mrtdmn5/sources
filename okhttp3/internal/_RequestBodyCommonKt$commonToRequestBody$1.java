package okhttp3.internal;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* compiled from: -RequestBodyCommon.kt */
/* loaded from: classes4.dex */
public final class _RequestBodyCommonKt$commonToRequestBody$1 extends RequestBody {
    public final /* synthetic */ int $byteCount;
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ int $offset;
    public final /* synthetic */ byte[] $this_commonToRequestBody;

    public _RequestBodyCommonKt$commonToRequestBody$1(MediaType mediaType, byte[] bArr, int r3, int r4) {
        this.$contentType = mediaType;
        this.$byteCount = r3;
        this.$this_commonToRequestBody = bArr;
        this.$offset = r4;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.$byteCount;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) {
        bufferedSink.write(this.$this_commonToRequestBody, this.$offset, this.$byteCount);
    }
}

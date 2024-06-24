package okhttp3.internal;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* compiled from: -ResponseBodyCommon.kt */
/* loaded from: classes4.dex */
public final class _ResponseBodyCommonKt$commonAsResponseBody$1 extends ResponseBody {
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ BufferedSource $this_commonAsResponseBody;

    public _ResponseBodyCommonKt$commonAsResponseBody$1(MediaType mediaType, long j, Buffer buffer) {
        this.$contentType = mediaType;
        this.$contentLength = j;
        this.$this_commonAsResponseBody = buffer;
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.$contentLength;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.$this_commonAsResponseBody;
    }
}

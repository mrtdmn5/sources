package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal._MediaTypeCommonKt;
import okio.BufferedSource;
import okio.RealBufferedSource;

/* compiled from: RealResponseBody.kt */
/* loaded from: classes4.dex */
public final class RealResponseBody extends ResponseBody {
    public final long contentLength;
    public final String contentTypeString;
    public final BufferedSource source;

    public RealResponseBody(String str, long j, RealBufferedSource realBufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = realBufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        String str = this.contentTypeString;
        if (str == null) {
            return null;
        }
        try {
            return _MediaTypeCommonKt.commonToMediaType(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.source;
    }
}

package okhttp3;

import java.io.Closeable;
import okhttp3.internal._UtilCommonKt;
import okio.BufferedSource;

/* compiled from: ResponseBody.kt */
/* loaded from: classes4.dex */
public abstract class ResponseBody implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        _UtilCommonKt.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();
}

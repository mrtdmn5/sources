package okhttp3;

import java.io.IOException;
import okio.BufferedSink;

/* compiled from: RequestBody.kt */
/* loaded from: classes4.dex */
public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public void isDuplex() {
    }
}

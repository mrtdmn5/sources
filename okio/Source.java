package okio;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.kt */
/* loaded from: classes4.dex */
public interface Source extends Closeable {
    long read(Buffer buffer, long j) throws IOException;

    Timeout timeout();
}

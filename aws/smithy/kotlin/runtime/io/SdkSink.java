package aws.smithy.kotlin.runtime.io;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: SdkSink.kt */
/* loaded from: classes.dex */
public interface SdkSink extends Closeable {
    void flush() throws IOException;

    void write(SdkBuffer sdkBuffer, long j) throws IOException;
}

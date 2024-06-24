package aws.smithy.kotlin.runtime.io;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: SdkSource.kt */
/* loaded from: classes.dex */
public interface SdkSource extends Closeable {
    long read(SdkBuffer sdkBuffer) throws IOException;
}

package aws.smithy.kotlin.runtime.io;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

/* compiled from: SdkBufferedSourceJVM.kt */
/* loaded from: classes.dex */
public interface SdkBufferedSource extends SdkSource, ReadableByteChannel {
    byte[] readByteArray() throws IOException;
}

package aws.smithy.kotlin.runtime.io;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: SdkBufferedSinkJVM.kt */
/* loaded from: classes.dex */
public interface SdkBufferedSink extends SdkSink, WritableByteChannel {

    /* compiled from: SdkBufferedSinkJVM.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
    }

    void emit() throws IOException;

    SdkBuffer getBuffer();
}

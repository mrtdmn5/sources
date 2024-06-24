package aws.smithy.kotlin.runtime.io;

/* compiled from: SdkByteReadChannel.kt */
/* loaded from: classes.dex */
public interface SdkByteReadChannel {
    boolean cancel();

    boolean isClosedForRead();

    Object read();
}

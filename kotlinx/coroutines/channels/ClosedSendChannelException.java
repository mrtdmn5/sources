package kotlinx.coroutines.channels;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ClosedSendChannelException extends IllegalStateException {
    public ClosedSendChannelException() {
        super("Channel was closed");
    }
}

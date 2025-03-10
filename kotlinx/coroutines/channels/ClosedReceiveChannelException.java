package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ClosedReceiveChannelException extends NoSuchElementException {
    public ClosedReceiveChannelException() {
        super("Channel was closed");
    }
}

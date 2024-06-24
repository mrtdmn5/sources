package kotlinx.coroutines.channels;

import kotlinx.coroutines.channels.Channel;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ChannelKt {
    public static BufferedChannel Channel$default(int r3, BufferOverflow bufferOverflow, int r5) {
        BufferedChannel conflatedBufferedChannel;
        boolean z = false;
        if ((r5 & 1) != 0) {
            r3 = 0;
        }
        if ((r5 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if (r3 != -2) {
            if (r3 != -1) {
                if (r3 != 0) {
                    if (r3 != Integer.MAX_VALUE) {
                        if (bufferOverflow == BufferOverflow.SUSPEND) {
                            return new BufferedChannel(r3, null);
                        }
                        return new ConflatedBufferedChannel(r3, bufferOverflow, null);
                    }
                    return new BufferedChannel(Integer.MAX_VALUE, null);
                }
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    conflatedBufferedChannel = new BufferedChannel(0, null);
                } else {
                    conflatedBufferedChannel = new ConflatedBufferedChannel(1, bufferOverflow, null);
                }
            } else {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    z = true;
                }
                if (z) {
                    return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            Channel.Factory.getClass();
            conflatedBufferedChannel = new BufferedChannel(Channel.Factory.CHANNEL_DEFAULT_CAPACITY, null);
        } else {
            conflatedBufferedChannel = new ConflatedBufferedChannel(1, bufferOverflow, null);
        }
        return conflatedBufferedChannel;
    }
}

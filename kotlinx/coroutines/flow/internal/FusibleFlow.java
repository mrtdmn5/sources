package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public interface FusibleFlow<T> extends Flow<T> {

    /* compiled from: ChannelFlow.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Flow fuse$default(FusibleFlow fusibleFlow, CoroutineDispatcher coroutineDispatcher, int r3, BufferOverflow bufferOverflow, int r5) {
            CoroutineContext coroutineContext = coroutineDispatcher;
            if ((r5 & 1) != 0) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            }
            if ((r5 & 2) != 0) {
                r3 = -3;
            }
            if ((r5 & 4) != 0) {
                bufferOverflow = BufferOverflow.SUSPEND;
            }
            return fusibleFlow.fuse(coroutineContext, r3, bufferOverflow);
        }
    }

    Flow<T> fuse(CoroutineContext coroutineContext, int r2, BufferOverflow bufferOverflow);
}

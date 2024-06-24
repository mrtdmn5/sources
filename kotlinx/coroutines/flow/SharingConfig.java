package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: Share.kt */
/* loaded from: classes4.dex */
public final class SharingConfig<T> {
    public final CoroutineContext context;
    public final int extraBufferCapacity;
    public final BufferOverflow onBufferOverflow;
    public final Flow<T> upstream;

    public SharingConfig(int r1, CoroutineContext coroutineContext, BufferOverflow bufferOverflow, Flow flow) {
        this.upstream = flow;
        this.extraBufferCapacity = r1;
        this.onBufferOverflow = bufferOverflow;
        this.context = coroutineContext;
    }
}

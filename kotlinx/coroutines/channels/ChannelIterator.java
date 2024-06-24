package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface ChannelIterator<E> {
    Object hasNext(ContinuationImpl continuationImpl);

    E next();
}

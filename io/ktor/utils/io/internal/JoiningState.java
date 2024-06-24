package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: ByteBufferChannelInternals.kt */
/* loaded from: classes3.dex */
public final class JoiningState {
    private volatile /* synthetic */ Object _closeWaitJob;
    private volatile /* synthetic */ int closed;

    static {
        AtomicReferenceFieldUpdater.newUpdater(JoiningState.class, Object.class, "_closeWaitJob");
    }
}

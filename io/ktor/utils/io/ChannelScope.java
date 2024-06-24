package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Coroutines.kt */
/* loaded from: classes3.dex */
public final class ChannelScope implements CoroutineScope, WriterScope {
    public final /* synthetic */ CoroutineScope $$delegate_0;
    public final ByteChannel channel;

    public ChannelScope(CoroutineScope delegate, ByteChannel channel) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.$$delegate_0 = delegate;
    }

    @Override // io.ktor.utils.io.WriterScope
    public final ByteChannel getChannel$1() {
        return this.channel;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }
}

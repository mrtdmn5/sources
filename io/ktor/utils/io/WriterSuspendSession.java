package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;

/* compiled from: WriterSession.kt */
/* loaded from: classes3.dex */
public interface WriterSuspendSession {
    ChunkBuffer request(int r1);

    Object tryAwait(int r1, WriterSessionKt$writeBufferSuspend$1 writerSessionKt$writeBufferSuspend$1);
}

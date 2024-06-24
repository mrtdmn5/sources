package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannelCtor.kt */
/* loaded from: classes3.dex */
public final class ByteChannelCtorKt {
    public static final ByteBufferChannel ByteReadChannel(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer wrap = ByteBuffer.wrap(content, 0, content.length);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(wrap);
    }
}

package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Output.kt */
/* loaded from: classes3.dex */
public final class OutputKt {
    public static final void writeFully(Buffer buffer, int r1) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }

    public static final void writeFully(Output output, byte[] src, int r6, int r7) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                int min = Math.min(r7, prepareWriteHead.limit - prepareWriteHead.writePosition);
                BufferPrimitivesKt.writeFully(prepareWriteHead, src, r6, min);
                r6 += min;
                r7 -= min;
                if (!(r7 > 0)) {
                    return;
                } else {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }
}

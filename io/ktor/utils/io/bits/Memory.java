package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
/* loaded from: classes3.dex */
public final class Memory {
    public static final ByteBuffer Empty;

    static {
        ByteBuffer order = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        Empty = order;
    }

    /* renamed from: copyTo-JT6ljtQ, reason: not valid java name */
    public static final void m1654copyToJT6ljtQ(ByteBuffer byteBuffer, ByteBuffer destination, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + r3, destination.array(), destination.arrayOffset() + r5, r4);
            return;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(r3);
        duplicate.limit(r3 + r4);
        ByteBuffer duplicate2 = destination.duplicate();
        duplicate2.position(r5);
        duplicate2.put(duplicate);
    }
}

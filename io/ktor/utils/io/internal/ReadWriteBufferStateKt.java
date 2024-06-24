package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadWriteBufferState.kt */
/* loaded from: classes3.dex */
public final class ReadWriteBufferStateKt {
    public static final ByteBuffer EmptyByteBuffer;
    public static final RingBufferCapacity EmptyCapacity;

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(0)");
        EmptyByteBuffer = allocate;
        EmptyCapacity = new RingBufferCapacity(0);
    }
}

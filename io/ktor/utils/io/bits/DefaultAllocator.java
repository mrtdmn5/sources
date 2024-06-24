package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryFactoryJvm.kt */
/* loaded from: classes3.dex */
public final class DefaultAllocator implements Allocator {
    public static final DefaultAllocator INSTANCE = new DefaultAllocator();

    @Override // io.ktor.utils.io.bits.Allocator
    /* renamed from: alloc-gFv-Zug */
    public final ByteBuffer mo1652allocgFvZug(int r2) {
        ByteBuffer allocate = ByteBuffer.allocate(r2);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(size)");
        ByteBuffer byteBuffer = Memory.Empty;
        return allocate;
    }

    @Override // io.ktor.utils.io.bits.Allocator
    /* renamed from: free-3GNKZMM */
    public final void mo1653free3GNKZMM(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }
}

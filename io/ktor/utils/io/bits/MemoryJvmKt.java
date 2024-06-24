package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
/* loaded from: classes3.dex */
public final class MemoryJvmKt {
    /* renamed from: copyTo-62zg_DM, reason: not valid java name */
    public static final void m1655copyTo62zg_DM(ByteBuffer copyTo, ByteBuffer byteBuffer, int r6) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        int remaining = byteBuffer.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
            int position = byteBuffer.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + r6, byteBuffer.array(), byteBuffer.arrayOffset() + position, remaining);
            byteBuffer.position(position + remaining);
        } else {
            ByteBuffer duplicate = copyTo.duplicate();
            duplicate.limit(remaining + r6);
            duplicate.position(r6);
            byteBuffer.put(duplicate);
        }
    }

    public static final ByteBuffer sliceSafe(ByteBuffer byteBuffer, int r2, int r3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        myDuplicate$lambda$1.position(r2);
        myDuplicate$lambda$1.limit(r2 + r3);
        ByteBuffer mySlice$lambda$2 = myDuplicate$lambda$1.slice();
        Intrinsics.checkNotNullExpressionValue(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }
}

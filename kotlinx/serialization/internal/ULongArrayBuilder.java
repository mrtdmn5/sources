package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {
    public long[] buffer;
    public int position;

    public ULongArrayBuilder(long[] jArr) {
        this.buffer = jArr;
        this.position = jArr.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final ULongArray build$kotlinx_serialization_core() {
        long[] copyOf = Arrays.copyOf(this.buffer, this.position);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new ULongArray(copyOf);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void ensureCapacity$kotlinx_serialization_core(int r3) {
        long[] jArr = this.buffer;
        if (jArr.length < r3) {
            int length = jArr.length * 2;
            if (r3 < length) {
                r3 = length;
            }
            long[] copyOf = Arrays.copyOf(jArr, r3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

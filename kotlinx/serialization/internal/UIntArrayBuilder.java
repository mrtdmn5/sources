package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class UIntArrayBuilder extends PrimitiveArrayBuilder<UIntArray> {
    public int[] buffer;
    public int position;

    public UIntArrayBuilder(int[] r1) {
        this.buffer = r1;
        this.position = r1.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final UIntArray build$kotlinx_serialization_core() {
        int[] copyOf = Arrays.copyOf(this.buffer, this.position);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new UIntArray(copyOf);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void ensureCapacity$kotlinx_serialization_core(int r3) {
        int[] r0 = this.buffer;
        if (r0.length < r3) {
            int length = r0.length * 2;
            if (r3 < length) {
                r3 = length;
            }
            int[] copyOf = Arrays.copyOf(r0, r3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

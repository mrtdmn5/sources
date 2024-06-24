package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {
    public short[] buffer;
    public int position;

    public UShortArrayBuilder(short[] sArr) {
        this.buffer = sArr;
        this.position = sArr.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final UShortArray build$kotlinx_serialization_core() {
        short[] copyOf = Arrays.copyOf(this.buffer, this.position);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new UShortArray(copyOf);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void ensureCapacity$kotlinx_serialization_core(int r3) {
        short[] sArr = this.buffer;
        if (sArr.length < r3) {
            int length = sArr.length * 2;
            if (r3 < length) {
                r3 = length;
            }
            short[] copyOf = Arrays.copyOf(sArr, r3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class BooleanArrayBuilder extends PrimitiveArrayBuilder<boolean[]> {
    public boolean[] buffer;
    public int position;

    public BooleanArrayBuilder(boolean[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = bufferWithData.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final boolean[] build$kotlinx_serialization_core() {
        boolean[] copyOf = Arrays.copyOf(this.buffer, this.position);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void ensureCapacity$kotlinx_serialization_core(int r3) {
        boolean[] zArr = this.buffer;
        if (zArr.length < r3) {
            int length = zArr.length * 2;
            if (r3 < length) {
                r3 = length;
            }
            boolean[] copyOf = Arrays.copyOf(zArr, r3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

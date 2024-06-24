package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class DoubleArraySerializer extends PrimitiveArraySerializer<Double, double[], DoubleArrayBuilder> {
    public static final DoubleArraySerializer INSTANCE = new DoubleArraySerializer();

    public DoubleArraySerializer() {
        super(DoubleSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        double[] dArr = (double[]) obj;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final double[] empty() {
        return new double[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r4, Object obj, boolean z) {
        DoubleArrayBuilder builder = (DoubleArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        double decodeDoubleElement = compositeDecoder.decodeDoubleElement(this.descriptor, r4);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        double[] dArr = builder.buffer;
        int r0 = builder.position;
        builder.position = r0 + 1;
        dArr[r0] = decodeDoubleElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        double[] dArr = (double[]) obj;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new DoubleArrayBuilder(dArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, double[] dArr, int r7) {
        double[] content = dArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r7; r0++) {
            encoder.encodeDoubleElement(this.descriptor, r0, content[r0]);
        }
    }
}

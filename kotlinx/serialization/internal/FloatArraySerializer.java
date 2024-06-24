package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class FloatArraySerializer extends PrimitiveArraySerializer<Float, float[], FloatArrayBuilder> {
    public static final FloatArraySerializer INSTANCE = new FloatArraySerializer();

    public FloatArraySerializer() {
        super(FloatSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        float[] fArr = (float[]) obj;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final float[] empty() {
        return new float[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        FloatArrayBuilder builder = (FloatArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        float decodeFloatElement = compositeDecoder.decodeFloatElement(this.descriptor, r3);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        float[] fArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        fArr[r5] = decodeFloatElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        float[] fArr = (float[]) obj;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new FloatArrayBuilder(fArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, float[] fArr, int r6) {
        float[] content = fArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeFloatElement(this.descriptor, r0, content[r0]);
        }
    }
}

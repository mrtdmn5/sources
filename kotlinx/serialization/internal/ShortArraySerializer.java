package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class ShortArraySerializer extends PrimitiveArraySerializer<Short, short[], ShortArrayBuilder> {
    public static final ShortArraySerializer INSTANCE = new ShortArraySerializer();

    public ShortArraySerializer() {
        super(ShortSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        short[] sArr = (short[]) obj;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final short[] empty() {
        return new short[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        ShortArrayBuilder builder = (ShortArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        short decodeShortElement = compositeDecoder.decodeShortElement(this.descriptor, r3);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        short[] sArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        sArr[r5] = decodeShortElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        short[] sArr = (short[]) obj;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new ShortArrayBuilder(sArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, short[] sArr, int r6) {
        short[] content = sArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeShortElement(this.descriptor, r0, content[r0]);
        }
    }
}

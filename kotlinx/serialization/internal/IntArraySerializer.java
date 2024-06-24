package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class IntArraySerializer extends PrimitiveArraySerializer<Integer, int[], IntArrayBuilder> {
    public static final IntArraySerializer INSTANCE = new IntArraySerializer();

    public IntArraySerializer() {
        super(IntSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        int[] r2 = (int[]) obj;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final int[] empty() {
        return new int[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        IntArrayBuilder builder = (IntArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        int decodeIntElement = compositeDecoder.decodeIntElement(this.descriptor, r3);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        int[] r32 = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        r32[r5] = decodeIntElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        int[] r2 = (int[]) obj;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new IntArrayBuilder(r2);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, int[] r5, int r6) {
        int[] content = r5;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeIntElement(r0, content[r0], this.descriptor);
        }
    }
}

package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class LongArraySerializer extends PrimitiveArraySerializer<Long, long[], LongArrayBuilder> {
    public static final LongArraySerializer INSTANCE = new LongArraySerializer();

    public LongArraySerializer() {
        super(LongSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        long[] jArr = (long[]) obj;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final long[] empty() {
        return new long[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r4, Object obj, boolean z) {
        LongArrayBuilder builder = (LongArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        long decodeLongElement = compositeDecoder.decodeLongElement(this.descriptor, r4);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        long[] jArr = builder.buffer;
        int r0 = builder.position;
        builder.position = r0 + 1;
        jArr[r0] = decodeLongElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        long[] jArr = (long[]) obj;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new LongArrayBuilder(jArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, long[] jArr, int r7) {
        long[] content = jArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r7; r0++) {
            encoder.encodeLongElement(this.descriptor, r0, content[r0]);
        }
    }
}

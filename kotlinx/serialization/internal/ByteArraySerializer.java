package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class ByteArraySerializer extends PrimitiveArraySerializer<Byte, byte[], ByteArrayBuilder> {
    public static final ByteArraySerializer INSTANCE = new ByteArraySerializer();

    public ByteArraySerializer() {
        super(ByteSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        byte[] bArr = (byte[]) obj;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final byte[] empty() {
        return new byte[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        ByteArrayBuilder builder = (ByteArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        byte decodeByteElement = compositeDecoder.decodeByteElement(this.descriptor, r3);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        byte[] bArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        bArr[r5] = decodeByteElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        byte[] bArr = (byte[]) obj;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new ByteArrayBuilder(bArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, byte[] bArr, int r6) {
        byte[] content = bArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeByteElement(this.descriptor, r0, content[r0]);
        }
    }
}

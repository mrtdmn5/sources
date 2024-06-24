package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class UByteArraySerializer extends PrimitiveArraySerializer<UByte, UByteArray, UByteArrayBuilder> {
    public static final UByteArraySerializer INSTANCE = new UByteArraySerializer();

    public UByteArraySerializer() {
        super(UByteSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        byte[] collectionSize = ((UByteArray) obj).storage;
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final UByteArray empty() {
        return new UByteArray(new byte[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        UByteArrayBuilder builder = (UByteArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        byte decodeByte = compositeDecoder.decodeInlineElement(this.descriptor, r3).decodeByte();
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        byte[] bArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        bArr[r5] = decodeByte;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        byte[] toBuilder = ((UByteArray) obj).storage;
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UByteArrayBuilder(toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, UByteArray uByteArray, int r6) {
        byte[] content = uByteArray.storage;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeInlineElement(this.descriptor, r0).encodeByte(content[r0]);
        }
    }
}

package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class ULongArraySerializer extends PrimitiveArraySerializer<ULong, ULongArray, ULongArrayBuilder> {
    public static final ULongArraySerializer INSTANCE = new ULongArraySerializer();

    public ULongArraySerializer() {
        super(ULongSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        long[] collectionSize = ((ULongArray) obj).storage;
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final ULongArray empty() {
        return new ULongArray(new long[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r4, Object obj, boolean z) {
        ULongArrayBuilder builder = (ULongArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        long decodeLong = compositeDecoder.decodeInlineElement(this.descriptor, r4).decodeLong();
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        long[] jArr = builder.buffer;
        int r0 = builder.position;
        builder.position = r0 + 1;
        jArr[r0] = decodeLong;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        long[] toBuilder = ((ULongArray) obj).storage;
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new ULongArrayBuilder(toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, ULongArray uLongArray, int r7) {
        long[] content = uLongArray.storage;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r7; r0++) {
            encoder.encodeInlineElement(this.descriptor, r0).encodeLong(content[r0]);
        }
    }
}

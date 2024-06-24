package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> {
    public static final UShortArraySerializer INSTANCE = new UShortArraySerializer();

    public UShortArraySerializer() {
        super(UShortSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        short[] collectionSize = ((UShortArray) obj).storage;
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final UShortArray empty() {
        return new UShortArray(new short[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        UShortArrayBuilder builder = (UShortArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        short decodeShort = compositeDecoder.decodeInlineElement(this.descriptor, r3).decodeShort();
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        short[] sArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        sArr[r5] = decodeShort;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        short[] toBuilder = ((UShortArray) obj).storage;
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UShortArrayBuilder(toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, UShortArray uShortArray, int r6) {
        short[] content = uShortArray.storage;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeInlineElement(this.descriptor, r0).encodeShort(content[r0]);
        }
    }
}

package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer<UInt, UIntArray, UIntArrayBuilder> {
    public static final UIntArraySerializer INSTANCE = new UIntArraySerializer();

    public UIntArraySerializer() {
        super(UIntSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        int[] collectionSize = ((UIntArray) obj).storage;
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final UIntArray empty() {
        return new UIntArray(new int[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        UIntArrayBuilder builder = (UIntArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        int decodeInt = compositeDecoder.decodeInlineElement(this.descriptor, r3).decodeInt();
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        int[] r32 = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        r32[r5] = decodeInt;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        int[] toBuilder = ((UIntArray) obj).storage;
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UIntArrayBuilder(toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, UIntArray uIntArray, int r6) {
        int[] content = uIntArray.storage;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeInlineElement(this.descriptor, r0).encodeInt(content[r0]);
        }
    }
}

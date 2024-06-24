package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes4.dex */
public final class CharArraySerializer extends PrimitiveArraySerializer<Character, char[], CharArrayBuilder> {
    public static final CharArraySerializer INSTANCE = new CharArraySerializer();

    public CharArraySerializer() {
        super(CharSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        char[] cArr = (char[]) obj;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final char[] empty() {
        return new char[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r3, Object obj, boolean z) {
        CharArrayBuilder builder = (CharArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(builder, "builder");
        char decodeCharElement = compositeDecoder.decodeCharElement(this.descriptor, r3);
        builder.ensureCapacity$kotlinx_serialization_core(builder.getPosition$kotlinx_serialization_core() + 1);
        char[] cArr = builder.buffer;
        int r5 = builder.position;
        builder.position = r5 + 1;
        cArr[r5] = decodeCharElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        char[] cArr = (char[]) obj;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new CharArrayBuilder(cArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder encoder, char[] cArr, int r6) {
        char[] content = cArr;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int r0 = 0; r0 < r6; r0++) {
            encoder.encodeCharElement(this.descriptor, r0, content[r0]);
        }
    }
}

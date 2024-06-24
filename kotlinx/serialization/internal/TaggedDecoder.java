package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: Tagged.kt */
/* loaded from: classes4.dex */
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {
    public boolean flag;
    public final ArrayList<Tag> tagStack = new ArrayList<>();

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedBoolean(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(PrimitiveArrayDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedByte(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(PrimitiveArrayDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedChar(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedDouble(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(popTag(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedFloat(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder decodeInlineElement(PrimitiveArrayDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(getTag$1(descriptor, r3), descriptor.getElementDescriptor(r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInt(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedLong(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract boolean decodeNotNullMark();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeNullableSerializableElement(SerialDescriptor descriptor, int r3, final KSerializer deserializer, final Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        String tag$1 = getTag$1(descriptor, r3);
        Function0<Object> function0 = new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TaggedDecoder<Object> taggedDecoder = TaggedDecoder.this;
                if (taggedDecoder.decodeNotNullMark()) {
                    DeserializationStrategy<? extends T> deserializer2 = deserializer;
                    Intrinsics.checkNotNullParameter(deserializer2, "deserializer");
                    return taggedDecoder.decodeSerializableValue$1(deserializer2);
                }
                return null;
            }
        };
        this.tagStack.add(tag$1);
        Object invoke = function0.invoke();
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return invoke;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int r3, final DeserializationStrategy<? extends T> deserializer, final T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        String tag$1 = getTag$1(descriptor, r3);
        Function0<T> function0 = new Function0<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            public final /* synthetic */ TaggedDecoder<Tag> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Decoder decoder = this.this$0;
                decoder.getClass();
                DeserializationStrategy<T> deserializer2 = deserializer;
                Intrinsics.checkNotNullParameter(deserializer2, "deserializer");
                return (T) decoder.decodeSerializableValue$1(deserializer2);
            }
        };
        this.tagStack.add(tag$1);
        T t2 = (T) function0.invoke();
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return t2;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract <T> T decodeSerializableValue$1(DeserializationStrategy<? extends T> deserializationStrategy);

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(PrimitiveArrayDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedShort(getTag$1(descriptor, r3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedString(getTag$1(descriptor, r3));
    }

    public abstract boolean decodeTaggedBoolean(Tag tag);

    public abstract byte decodeTaggedByte(Tag tag);

    public abstract char decodeTaggedChar(Tag tag);

    public abstract double decodeTaggedDouble(Tag tag);

    public abstract int decodeTaggedEnum(Tag tag, SerialDescriptor serialDescriptor);

    public abstract float decodeTaggedFloat(Tag tag);

    public abstract Decoder decodeTaggedInline(Tag tag, SerialDescriptor serialDescriptor);

    public abstract int decodeTaggedInt(Tag tag);

    public abstract long decodeTaggedLong(Tag tag);

    public abstract short decodeTaggedShort(Tag tag);

    public abstract String decodeTaggedString(Tag tag);

    public abstract String getTag$1(SerialDescriptor serialDescriptor, int r2);

    public final Tag popTag() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag remove = arrayList.remove(CollectionsKt__CollectionsKt.getLastIndex(arrayList));
        this.flag = true;
        return remove;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final void decodeNull() {
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final void decodeSequentially() {
    }
}

package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.ArrayListSerializer;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes4.dex */
public final class JsonArraySerializer implements KSerializer<JsonArray> {
    public static final JsonArraySerializer INSTANCE = new JsonArraySerializer();
    public static final JsonArrayDescriptor descriptor = JsonArrayDescriptor.INSTANCE;

    /* compiled from: JsonElementSerializers.kt */
    /* loaded from: classes4.dex */
    public static final class JsonArrayDescriptor implements SerialDescriptor {
        public static final JsonArrayDescriptor INSTANCE = new JsonArrayDescriptor();
        public static final String serialName = "kotlinx.serialization.json.JsonArray";
        public final /* synthetic */ ArrayListClassDesc $$delegate_0 = new ArrayListClassDesc(JsonElementSerializer.INSTANCE.getDescriptor());

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List<Annotation> getAnnotations() {
            this.$$delegate_0.getClass();
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List<Annotation> getElementAnnotations(int r2) {
            this.$$delegate_0.getElementAnnotations(r2);
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor getElementDescriptor(int r2) {
            return this.$$delegate_0.getElementDescriptor(r2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementIndex(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.$$delegate_0.getElementIndex(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getElementName(int r2) {
            this.$$delegate_0.getClass();
            return String.valueOf(r2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementsCount() {
            return this.$$delegate_0.elementsCount;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialKind getKind() {
            this.$$delegate_0.getClass();
            return StructureKind.LIST.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getSerialName() {
            return serialName;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isElementOptional(int r2) {
            this.$$delegate_0.isElementOptional(r2);
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            this.$$delegate_0.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isNullable() {
            this.$$delegate_0.getClass();
            return false;
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.asJsonDecoder(decoder);
        return new JsonArray((List) new ArrayListSerializer(JsonElementSerializer.INSTANCE).deserialize(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonArray value = (JsonArray) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.access$verify(encoder);
        new ArrayListSerializer(JsonElementSerializer.INSTANCE).serialize(encoder, value);
    }
}

package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes4.dex */
public final class JsonElementSerializer implements KSerializer<JsonElement> {
    public static final JsonElementSerializer INSTANCE = new JsonElementSerializer();
    public static final SerialDescriptorImpl descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            ClassSerialDescriptorBuilder buildSerialDescriptor = classSerialDescriptorBuilder;
            Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
            final AnonymousClass1 anonymousClass1 = new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.1
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonPrimitiveSerializer.descriptor;
                }
            };
            SerialDescriptor serialDescriptor = new SerialDescriptor(anonymousClass1) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                public final SynchronizedLazyImpl original$delegate;

                {
                    this.original$delegate = LazyKt__LazyJVMKt.lazy(anonymousClass1);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getAnnotations() {
                    return EmptyList.INSTANCE;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getElementAnnotations(int r2) {
                    return getOriginal().getElementAnnotations(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialDescriptor getElementDescriptor(int r2) {
                    return getOriginal().getElementDescriptor(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementIndex(String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    return getOriginal().getElementIndex(name);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getElementName(int r2) {
                    return getOriginal().getElementName(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementsCount() {
                    return getOriginal().getElementsCount();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialKind getKind() {
                    return getOriginal().getKind();
                }

                public final SerialDescriptor getOriginal() {
                    return (SerialDescriptor) this.original$delegate.getValue();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getSerialName() {
                    return getOriginal().getSerialName();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isElementOptional(int r2) {
                    return getOriginal().isElementOptional(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isInline() {
                    return false;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isNullable() {
                    return false;
                }
            };
            EmptyList emptyList = EmptyList.INSTANCE;
            buildSerialDescriptor.element("JsonPrimitive", serialDescriptor, emptyList, false);
            final AnonymousClass2 anonymousClass2 = new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.2
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonNullSerializer.descriptor;
                }
            };
            buildSerialDescriptor.element("JsonNull", new SerialDescriptor(anonymousClass2) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                public final SynchronizedLazyImpl original$delegate;

                {
                    this.original$delegate = LazyKt__LazyJVMKt.lazy(anonymousClass2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getAnnotations() {
                    return EmptyList.INSTANCE;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getElementAnnotations(int r2) {
                    return getOriginal().getElementAnnotations(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialDescriptor getElementDescriptor(int r2) {
                    return getOriginal().getElementDescriptor(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementIndex(String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    return getOriginal().getElementIndex(name);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getElementName(int r2) {
                    return getOriginal().getElementName(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementsCount() {
                    return getOriginal().getElementsCount();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialKind getKind() {
                    return getOriginal().getKind();
                }

                public final SerialDescriptor getOriginal() {
                    return (SerialDescriptor) this.original$delegate.getValue();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getSerialName() {
                    return getOriginal().getSerialName();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isElementOptional(int r2) {
                    return getOriginal().isElementOptional(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isInline() {
                    return false;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isNullable() {
                    return false;
                }
            }, emptyList, false);
            final AnonymousClass3 anonymousClass3 = new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.3
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonLiteralSerializer.descriptor;
                }
            };
            buildSerialDescriptor.element("JsonLiteral", new SerialDescriptor(anonymousClass3) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                public final SynchronizedLazyImpl original$delegate;

                {
                    this.original$delegate = LazyKt__LazyJVMKt.lazy(anonymousClass3);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getAnnotations() {
                    return EmptyList.INSTANCE;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getElementAnnotations(int r2) {
                    return getOriginal().getElementAnnotations(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialDescriptor getElementDescriptor(int r2) {
                    return getOriginal().getElementDescriptor(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementIndex(String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    return getOriginal().getElementIndex(name);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getElementName(int r2) {
                    return getOriginal().getElementName(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementsCount() {
                    return getOriginal().getElementsCount();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialKind getKind() {
                    return getOriginal().getKind();
                }

                public final SerialDescriptor getOriginal() {
                    return (SerialDescriptor) this.original$delegate.getValue();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getSerialName() {
                    return getOriginal().getSerialName();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isElementOptional(int r2) {
                    return getOriginal().isElementOptional(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isInline() {
                    return false;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isNullable() {
                    return false;
                }
            }, emptyList, false);
            final AnonymousClass4 anonymousClass4 = new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.4
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonObjectSerializer.descriptor;
                }
            };
            buildSerialDescriptor.element("JsonObject", new SerialDescriptor(anonymousClass4) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                public final SynchronizedLazyImpl original$delegate;

                {
                    this.original$delegate = LazyKt__LazyJVMKt.lazy(anonymousClass4);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getAnnotations() {
                    return EmptyList.INSTANCE;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getElementAnnotations(int r2) {
                    return getOriginal().getElementAnnotations(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialDescriptor getElementDescriptor(int r2) {
                    return getOriginal().getElementDescriptor(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementIndex(String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    return getOriginal().getElementIndex(name);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getElementName(int r2) {
                    return getOriginal().getElementName(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementsCount() {
                    return getOriginal().getElementsCount();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialKind getKind() {
                    return getOriginal().getKind();
                }

                public final SerialDescriptor getOriginal() {
                    return (SerialDescriptor) this.original$delegate.getValue();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getSerialName() {
                    return getOriginal().getSerialName();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isElementOptional(int r2) {
                    return getOriginal().isElementOptional(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isInline() {
                    return false;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isNullable() {
                    return false;
                }
            }, emptyList, false);
            final AnonymousClass5 anonymousClass5 = new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.5
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonArraySerializer.descriptor;
                }
            };
            buildSerialDescriptor.element("JsonArray", new SerialDescriptor(anonymousClass5) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                public final SynchronizedLazyImpl original$delegate;

                {
                    this.original$delegate = LazyKt__LazyJVMKt.lazy(anonymousClass5);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getAnnotations() {
                    return EmptyList.INSTANCE;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final List<Annotation> getElementAnnotations(int r2) {
                    return getOriginal().getElementAnnotations(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialDescriptor getElementDescriptor(int r2) {
                    return getOriginal().getElementDescriptor(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementIndex(String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    return getOriginal().getElementIndex(name);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getElementName(int r2) {
                    return getOriginal().getElementName(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final int getElementsCount() {
                    return getOriginal().getElementsCount();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final SerialKind getKind() {
                    return getOriginal().getKind();
                }

                public final SerialDescriptor getOriginal() {
                    return (SerialDescriptor) this.original$delegate.getValue();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final String getSerialName() {
                    return getOriginal().getSerialName();
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isElementOptional(int r2) {
                    return getOriginal().isElementOptional(r2);
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isInline() {
                    return false;
                }

                @Override // kotlinx.serialization.descriptors.SerialDescriptor
                public final boolean isNullable() {
                    return false;
                }
            }, emptyList, false);
            return Unit.INSTANCE;
        }
    });

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return JsonElementSerializersKt.asJsonDecoder(decoder).decodeJsonElement();
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonElement value = (JsonElement) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.access$verify(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.encodeSerializableValue(JsonPrimitiveSerializer.INSTANCE, value);
        } else if (value instanceof JsonObject) {
            encoder.encodeSerializableValue(JsonObjectSerializer.INSTANCE, value);
        } else if (value instanceof JsonArray) {
            encoder.encodeSerializableValue(JsonArraySerializer.INSTANCE, value);
        }
    }
}

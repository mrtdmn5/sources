package kotlinx.serialization.internal;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {
    public final KSerializer<A> aSerializer;
    public final KSerializer<B> bSerializer;
    public final KSerializer<C> cSerializer;
    public final SerialDescriptorImpl descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>(this) { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1
        public final /* synthetic */ TripleSerializer<A, B, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(1);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            ClassSerialDescriptorBuilder buildClassSerialDescriptor = classSerialDescriptorBuilder;
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            TripleSerializer<A, B, C> tripleSerializer = this.this$0;
            SerialDescriptor descriptor = tripleSerializer.aSerializer.getDescriptor();
            EmptyList emptyList = EmptyList.INSTANCE;
            buildClassSerialDescriptor.element("first", descriptor, emptyList, false);
            buildClassSerialDescriptor.element("second", tripleSerializer.bSerializer.getDescriptor(), emptyList, false);
            buildClassSerialDescriptor.element("third", tripleSerializer.cSerializer.getDescriptor(), emptyList, false);
            return Unit.INSTANCE;
        }
    });

    public TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        this.aSerializer = kSerializer;
        this.bSerializer = kSerializer2;
        this.cSerializer = kSerializer3;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = this.descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptorImpl);
        beginStructure.decodeSequentially();
        Object obj = TuplesKt.NULL;
        Object obj2 = obj;
        Object obj3 = obj2;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptorImpl);
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex != 1) {
                        if (decodeElementIndex == 2) {
                            obj3 = beginStructure.decodeSerializableElement(serialDescriptorImpl, 2, this.cSerializer, null);
                        } else {
                            throw new SerializationException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unexpected index ", decodeElementIndex));
                        }
                    } else {
                        obj2 = beginStructure.decodeSerializableElement(serialDescriptorImpl, 1, this.bSerializer, null);
                    }
                } else {
                    obj = beginStructure.decodeSerializableElement(serialDescriptorImpl, 0, this.aSerializer, null);
                }
            } else {
                beginStructure.endStructure(serialDescriptorImpl);
                Object obj4 = TuplesKt.NULL;
                if (obj != obj4) {
                    if (obj2 != obj4) {
                        if (obj3 != obj4) {
                            return new Triple(obj, obj2, obj3);
                        }
                        throw new SerializationException("Element 'third' is missing");
                    }
                    throw new SerializationException("Element 'second' is missing");
                }
                throw new SerializationException("Element 'first' is missing");
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Triple value = (Triple) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = this.descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptorImpl);
        beginStructure.encodeSerializableElement(serialDescriptorImpl, 0, this.aSerializer, value.first);
        beginStructure.encodeSerializableElement(serialDescriptorImpl, 1, this.bSerializer, value.second);
        beginStructure.encodeSerializableElement(serialDescriptorImpl, 2, this.cSerializer, value.third);
        beginStructure.endStructure(serialDescriptorImpl);
    }
}

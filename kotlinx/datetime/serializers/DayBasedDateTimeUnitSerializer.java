package kotlinx.datetime.serializers;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModuleKt;

/* compiled from: DateTimeUnitSerializers.kt */
/* loaded from: classes4.dex */
public final class DayBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.DayBased> {
    public static final DayBasedDateTimeUnitSerializer INSTANCE = new DayBasedDateTimeUnitSerializer();
    public static final SerialDescriptorImpl descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("DayBased", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            ClassSerialDescriptorBuilder buildClassSerialDescriptor = classSerialDescriptorBuilder;
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.element("days", ExceptionsKt.serializer(SerializersModuleKt.EmptySerializersModule, Reflection.typeOf(Integer.TYPE)).getDescriptor(), EmptyList.INSTANCE, false);
            return Unit.INSTANCE;
        }
    });

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptorImpl);
        beginStructure.decodeSequentially();
        boolean z = false;
        int r3 = 0;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptorImpl);
            if (decodeElementIndex != -1) {
                if (decodeElementIndex == 0) {
                    r3 = beginStructure.decodeIntElement(serialDescriptorImpl, 0);
                    z = true;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                beginStructure.endStructure(serialDescriptorImpl);
                if (z) {
                    return new DateTimeUnit.DayBased(r3);
                }
                throw new MissingFieldException("days");
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        DateTimeUnit.DayBased value = (DateTimeUnit.DayBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptorImpl);
        beginStructure.encodeIntElement(0, value.days, serialDescriptorImpl);
        beginStructure.endStructure(serialDescriptorImpl);
    }
}

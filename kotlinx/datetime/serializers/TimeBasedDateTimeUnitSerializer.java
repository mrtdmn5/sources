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
public final class TimeBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.TimeBased> {
    public static final TimeBasedDateTimeUnitSerializer INSTANCE = new TimeBasedDateTimeUnitSerializer();
    public static final SerialDescriptorImpl descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("TimeBased", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.TimeBasedDateTimeUnitSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            ClassSerialDescriptorBuilder buildClassSerialDescriptor = classSerialDescriptorBuilder;
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.element("nanoseconds", ExceptionsKt.serializer(SerializersModuleKt.EmptySerializersModule, Reflection.typeOf(Long.TYPE)).getDescriptor(), EmptyList.INSTANCE, false);
            return Unit.INSTANCE;
        }
    });

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptorImpl);
        beginStructure.decodeSequentially();
        long j = 0;
        boolean z = false;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptorImpl);
            if (decodeElementIndex != -1) {
                if (decodeElementIndex == 0) {
                    j = beginStructure.decodeLongElement(serialDescriptorImpl, 0);
                    z = true;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                beginStructure.endStructure(serialDescriptorImpl);
                if (z) {
                    return new DateTimeUnit.TimeBased(j);
                }
                throw new MissingFieldException("nanoseconds");
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        DateTimeUnit.TimeBased value = (DateTimeUnit.TimeBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptorImpl);
        beginStructure.encodeLongElement(serialDescriptorImpl, 0, value.nanoseconds);
        beginStructure.endStructure(serialDescriptorImpl);
    }
}

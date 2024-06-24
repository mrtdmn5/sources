package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: DateTimeUnitSerializers.kt */
/* loaded from: classes4.dex */
public final class DateTimeUnitSerializer extends AbstractPolymorphicSerializer<DateTimeUnit> {
    public static final DateTimeUnitSerializer INSTANCE = new DateTimeUnitSerializer();
    public static final SealedClassSerializer<DateTimeUnit> impl = new SealedClassSerializer<>("kotlinx.datetime.DateTimeUnit", Reflection.getOrCreateKotlinClass(DateTimeUnit.class), new KClass[]{Reflection.getOrCreateKotlinClass(DateTimeUnit.DayBased.class), Reflection.getOrCreateKotlinClass(DateTimeUnit.MonthBased.class), Reflection.getOrCreateKotlinClass(DateTimeUnit.TimeBased.class)}, new KSerializer[]{DayBasedDateTimeUnitSerializer.INSTANCE, MonthBasedDateTimeUnitSerializer.INSTANCE, TimeBasedDateTimeUnitSerializer.INSTANCE});

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy<DateTimeUnit> findPolymorphicSerializerOrNull(Encoder encoder, DateTimeUnit dateTimeUnit) {
        DateTimeUnit value = dateTimeUnit;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return impl.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass<DateTimeUnit> getBaseClass() {
        return Reflection.getOrCreateKotlinClass(DateTimeUnit.class);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return impl.getDescriptor();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy<DateTimeUnit> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return impl.findPolymorphicSerializerOrNull(decoder, str);
    }
}

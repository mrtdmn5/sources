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
public final class DateBasedDateTimeUnitSerializer extends AbstractPolymorphicSerializer<DateTimeUnit.DateBased> {
    public static final DateBasedDateTimeUnitSerializer INSTANCE = new DateBasedDateTimeUnitSerializer();
    public static final SealedClassSerializer<DateTimeUnit.DateBased> impl = new SealedClassSerializer<>("kotlinx.datetime.DateTimeUnit.DateBased", Reflection.getOrCreateKotlinClass(DateTimeUnit.DateBased.class), new KClass[]{Reflection.getOrCreateKotlinClass(DateTimeUnit.DayBased.class), Reflection.getOrCreateKotlinClass(DateTimeUnit.MonthBased.class)}, new KSerializer[]{DayBasedDateTimeUnitSerializer.INSTANCE, MonthBasedDateTimeUnitSerializer.INSTANCE});

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy<DateTimeUnit.DateBased> findPolymorphicSerializerOrNull(Encoder encoder, DateTimeUnit.DateBased dateBased) {
        DateTimeUnit.DateBased value = dateBased;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return impl.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass<DateTimeUnit.DateBased> getBaseClass() {
        return Reflection.getOrCreateKotlinClass(DateTimeUnit.DateBased.class);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return impl.getDescriptor();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy<DateTimeUnit.DateBased> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return impl.findPolymorphicSerializerOrNull(decoder, str);
    }
}

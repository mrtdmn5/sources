package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class FitnessConfig$$serializer implements GeneratedSerializer<FitnessConfig> {
    public static final FitnessConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        FitnessConfig$$serializer fitnessConfig$$serializer = new FitnessConfig$$serializer();
        INSTANCE = fitnessConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.FitnessConfig", fitnessConfig$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("weight", true);
        pluginGeneratedSerialDescriptor.addElement("dateOfBirthTs", true);
        pluginGeneratedSerialDescriptor.addElement("gender", true);
        pluginGeneratedSerialDescriptor.addElement("measurement", true);
        pluginGeneratedSerialDescriptor.addElement("temperature", true);
        pluginGeneratedSerialDescriptor.addElement("bedtime", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FitnessConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(longSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(longSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(Bedtime$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FitnessConfig deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r6 = 0;
        Long l = null;
        Integer num = null;
        Integer num2 = null;
        Long l2 = null;
        Integer num3 = null;
        Integer num4 = null;
        Integer num5 = null;
        Bedtime bedtime = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    l = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 0, LongSerializer.INSTANCE, l);
                    r6 |= 1;
                    break;
                case 1:
                    num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num);
                    r6 |= 2;
                    break;
                case 2:
                    num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num2);
                    r6 |= 4;
                    break;
                case 3:
                    l2 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 3, LongSerializer.INSTANCE, l2);
                    r6 |= 8;
                    break;
                case 4:
                    r6 |= 16;
                    num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num3);
                    break;
                case 5:
                    r6 |= 32;
                    num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num4);
                    break;
                case 6:
                    r6 |= 64;
                    num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num5);
                    break;
                case 7:
                    r6 |= 128;
                    bedtime = (Bedtime) beginStructure.decodeNullableSerializableElement(descriptor2, 7, Bedtime$$serializer.INSTANCE, bedtime);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new FitnessConfig(r6, l, num, num2, l2, num3, num4, num5, bedtime, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FitnessConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FitnessConfig.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

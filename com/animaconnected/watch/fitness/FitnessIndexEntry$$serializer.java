package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexEntry$$serializer implements GeneratedSerializer<FitnessIndexEntry> {
    public static final FitnessIndexEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        FitnessIndexEntry$$serializer fitnessIndexEntry$$serializer = new FitnessIndexEntry$$serializer();
        INSTANCE = fitnessIndexEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.FitnessIndexEntry", fitnessIndexEntry$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ActivityEntry$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FitnessIndexEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, LongSerializer.INSTANCE, FloatSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FitnessIndexEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r9 = 0;
        String str = null;
        long j = 0;
        float f = 0.0f;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                HistoryDeviceId historyDeviceId = (HistoryDeviceId) beginStructure.decodeSerializableElement(descriptor2, 0, HistoryDeviceId$$serializer.INSTANCE, str != null ? HistoryDeviceId.m1556boximpl(str) : null);
                str = historyDeviceId != null ? historyDeviceId.m1562unboximpl() : null;
                r9 |= 1;
            } else if (decodeElementIndex == 1) {
                j = beginStructure.decodeLongElement(descriptor2, 1);
                r9 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                f = beginStructure.decodeFloatElement(descriptor2, 2);
                r9 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new FitnessIndexEntry(r9, str, j, f, null, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FitnessIndexEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FitnessIndexEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

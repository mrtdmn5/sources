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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SpeedCalibrationEntry$$serializer implements GeneratedSerializer<SpeedCalibrationEntry> {
    public static final SpeedCalibrationEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SpeedCalibrationEntry$$serializer speedCalibrationEntry$$serializer = new SpeedCalibrationEntry$$serializer();
        INSTANCE = speedCalibrationEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.SpeedCalibrationEntry", speedCalibrationEntry$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ActivityEntry$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("coefficient", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SpeedCalibrationEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SpeedCalibrationEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r7 = 0;
        int r11 = 0;
        String str = null;
        long j = 0;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                HistoryDeviceId historyDeviceId = (HistoryDeviceId) beginStructure.decodeSerializableElement(descriptor2, 0, HistoryDeviceId$$serializer.INSTANCE, str != null ? HistoryDeviceId.m1556boximpl(str) : null);
                str = historyDeviceId != null ? historyDeviceId.m1562unboximpl() : null;
                r7 |= 1;
            } else if (decodeElementIndex == 1) {
                j = beginStructure.decodeLongElement(descriptor2, 1);
                r7 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                r11 = beginStructure.decodeIntElement(descriptor2, 2);
                r7 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new SpeedCalibrationEntry(r7, str, j, r11, null, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SpeedCalibrationEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SpeedCalibrationEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

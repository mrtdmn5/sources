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
public final class DebugEntry$$serializer implements GeneratedSerializer<DebugEntry> {
    public static final DebugEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DebugEntry$$serializer debugEntry$$serializer = new DebugEntry$$serializer();
        INSTANCE = debugEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.DebugEntry", debugEntry$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ActivityEntry$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DebugEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, LongSerializer.INSTANCE, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DebugEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r8 = 0;
        int r12 = 0;
        int r13 = 0;
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
                r8 |= 1;
            } else if (decodeElementIndex == 1) {
                j = beginStructure.decodeLongElement(descriptor2, 1);
                r8 |= 2;
            } else if (decodeElementIndex == 2) {
                r12 = beginStructure.decodeIntElement(descriptor2, 2);
                r8 |= 4;
            } else {
                if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                r13 = beginStructure.decodeIntElement(descriptor2, 3);
                r8 |= 8;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new DebugEntry(r8, str, j, r12, r13, null, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DebugEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DebugEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

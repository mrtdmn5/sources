package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class ActivityEntry$$serializer implements GeneratedSerializer<ActivityEntry> {
    public static final ActivityEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ActivityEntry$$serializer activityEntry$$serializer = new ActivityEntry$$serializer();
        INSTANCE = activityEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.ActivityEntry", activityEntry$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ActivityEntry$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("activityClass", false);
        pluginGeneratedSerialDescriptor.addElement("walkSteps", false);
        pluginGeneratedSerialDescriptor.addElement("runSteps", false);
        pluginGeneratedSerialDescriptor.addElement("otherSteps", false);
        pluginGeneratedSerialDescriptor.addElement("rhythmicStepsCadence", false);
        pluginGeneratedSerialDescriptor.addElement(TransferTable.COLUMN_SPEED, false);
        pluginGeneratedSerialDescriptor.addElement("distance", false);
        pluginGeneratedSerialDescriptor.addElement("calories", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ActivityEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0027. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public ActivityEntry deserialize(Decoder decoder) {
        int r3;
        int r2;
        int r22;
        HistoryDeviceId historyDeviceId;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        long j = 0;
        Integer num = null;
        Integer num2 = null;
        Float f = null;
        Integer num3 = null;
        int r8 = 0;
        String str = null;
        Integer num4 = null;
        Integer num5 = null;
        Integer num6 = null;
        Integer num7 = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    HistoryDeviceId$$serializer historyDeviceId$$serializer = HistoryDeviceId$$serializer.INSTANCE;
                    if (str != null) {
                        historyDeviceId = HistoryDeviceId.m1556boximpl(str);
                        r22 = 0;
                    } else {
                        r22 = 0;
                        historyDeviceId = null;
                    }
                    HistoryDeviceId historyDeviceId2 = (HistoryDeviceId) beginStructure.decodeSerializableElement(descriptor2, r22, historyDeviceId$$serializer, historyDeviceId);
                    r8 |= 1;
                    str = historyDeviceId2 != null ? historyDeviceId2.m1562unboximpl() : null;
                case 1:
                    j = beginStructure.decodeLongElement(descriptor2, 1);
                    r3 = r8 | 2;
                    r8 = r3;
                case 2:
                    num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num4);
                    r3 = r8 | 4;
                    r8 = r3;
                case 3:
                    num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, num5);
                    r2 = r8 | 8;
                    r8 = r2;
                case 4:
                    num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num6);
                    r2 = r8 | 16;
                    r8 = r2;
                case 5:
                    num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num7);
                    r8 |= 32;
                case 6:
                    num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num2);
                    r2 = r8 | 64;
                    r8 = r2;
                case 7:
                    f = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, f);
                    r2 = r8 | 128;
                    r8 = r2;
                case 8:
                    num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, num3);
                    r2 = r8 | 256;
                    r8 = r2;
                case 9:
                    num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, num);
                    r2 = r8 | DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
                    r8 = r2;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ActivityEntry(r8, str, j, num4, num5, num6, num7, num2, f, num3, num, null, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ActivityEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ActivityEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

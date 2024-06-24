package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.fitness.FitnessDatabaseParser;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: FitnessDatabaseParser.kt */
/* loaded from: classes3.dex */
public final class FitnessDatabaseParser$Session$$serializer implements GeneratedSerializer<FitnessDatabaseParser.Session> {
    public static final FitnessDatabaseParser$Session$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        FitnessDatabaseParser$Session$$serializer fitnessDatabaseParser$Session$$serializer = new FitnessDatabaseParser$Session$$serializer();
        INSTANCE = fitnessDatabaseParser$Session$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.FitnessDatabaseParser.Session", fitnessDatabaseParser$Session$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new FitnessDatabaseParser$Goals$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement("sessionId", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("gps", true);
        pluginGeneratedSerialDescriptor.addElement("startTs", false);
        pluginGeneratedSerialDescriptor.addElement("endTs", false);
        pluginGeneratedSerialDescriptor.addElement("totalTimeMs", false);
        pluginGeneratedSerialDescriptor.addElement("activeTimeMs", false);
        pluginGeneratedSerialDescriptor.addElement("totalDistanceMeter", false);
        pluginGeneratedSerialDescriptor.addElement("steps", false);
        pluginGeneratedSerialDescriptor.addElement("calories", false);
        pluginGeneratedSerialDescriptor.addElement("elevationGain", false);
        pluginGeneratedSerialDescriptor.addElement("fitnessIndex", true);
        pluginGeneratedSerialDescriptor.addElement("elevation", true);
        pluginGeneratedSerialDescriptor.addElement("intervals", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_STATUS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FitnessDatabaseParser$Session$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = FitnessDatabaseParser.Session.$childSerializers;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(longSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), longSerializer, longSerializer, longSerializer, longSerializer, DoubleSerializer.INSTANCE, intSerializer, intSerializer, intSerializer, BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), kSerializerArr[13], kSerializerArr[14], BuiltinSerializersKt.getNullable(intSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x003b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public FitnessDatabaseParser.Session deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int r4;
        boolean z;
        String m1562unboximpl;
        int r5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = FitnessDatabaseParser.Session.$childSerializers;
        beginStructure.decodeSequentially();
        boolean z2 = true;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        double d = 0.0d;
        Float f = null;
        List list = null;
        List list2 = null;
        Integer num = null;
        int r11 = 0;
        String str = null;
        Long l = null;
        Integer num2 = null;
        Boolean bool = null;
        int r26 = 0;
        int r27 = 0;
        int r28 = 0;
        while (z2) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z2 = false;
                case 0:
                    HistoryDeviceId$$serializer historyDeviceId$$serializer = HistoryDeviceId$$serializer.INSTANCE;
                    HistoryDeviceId m1556boximpl = str != null ? HistoryDeviceId.m1556boximpl(str) : null;
                    z = false;
                    HistoryDeviceId historyDeviceId = (HistoryDeviceId) beginStructure.decodeSerializableElement(descriptor2, 0, historyDeviceId$$serializer, m1556boximpl);
                    m1562unboximpl = historyDeviceId != null ? historyDeviceId.m1562unboximpl() : null;
                    r5 = r11 | 1;
                    r11 = r5;
                    str = m1562unboximpl;
                case 1:
                    r5 = r11 | 2;
                    l = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 1, LongSerializer.INSTANCE, l);
                    m1562unboximpl = str;
                    z = false;
                    r11 = r5;
                    str = m1562unboximpl;
                case 2:
                    num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num2);
                    r11 |= 4;
                case 3:
                    bool = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool);
                    r11 |= 8;
                case 4:
                    j = beginStructure.decodeLongElement(descriptor2, 4);
                    r4 = r11 | 16;
                    r11 = r4;
                case 5:
                    j2 = beginStructure.decodeLongElement(descriptor2, 5);
                    r4 = r11 | 32;
                    r11 = r4;
                case 6:
                    j3 = beginStructure.decodeLongElement(descriptor2, 6);
                    r4 = r11 | 64;
                    r11 = r4;
                case 7:
                    j4 = beginStructure.decodeLongElement(descriptor2, 7);
                    r4 = r11 | 128;
                    r11 = r4;
                case 8:
                    d = beginStructure.decodeDoubleElement(descriptor2, 8);
                    r4 = r11 | 256;
                    r11 = r4;
                case 9:
                    r26 = beginStructure.decodeIntElement(descriptor2, 9);
                    r4 = r11 | DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
                    r11 = r4;
                case 10:
                    r27 = beginStructure.decodeIntElement(descriptor2, 10);
                    r4 = r11 | 1024;
                    r11 = r4;
                case 11:
                    r28 = beginStructure.decodeIntElement(descriptor2, 11);
                    r4 = r11 | 2048;
                    r11 = r4;
                case 12:
                    f = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 12, FloatSerializer.INSTANCE, f);
                    r4 = r11 | 4096;
                    r11 = r4;
                case 13:
                    list = (List) beginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], list);
                    r4 = r11 | DfuBaseService.ERROR_REMOTE_MASK;
                    r11 = r4;
                case 14:
                    list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], list2);
                    r4 = r11 | DfuBaseService.ERROR_CONNECTION_MASK;
                    r11 = r4;
                case 15:
                    num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, num);
                    r4 = 32768 | r11;
                    r11 = r4;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new FitnessDatabaseParser.Session(r11, str, l, num2, bool, j, j2, j3, j4, d, r26, r27, r28, f, list, list2, num, null, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FitnessDatabaseParser.Session value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FitnessDatabaseParser.Session.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

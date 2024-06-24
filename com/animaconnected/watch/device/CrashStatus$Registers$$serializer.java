package com.animaconnected.watch.device;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.device.CrashStatus;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrashStatus.kt */
/* loaded from: classes3.dex */
public final class CrashStatus$Registers$$serializer implements GeneratedSerializer<CrashStatus.Registers> {
    public static final CrashStatus$Registers$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CrashStatus$Registers$$serializer crashStatus$Registers$$serializer = new CrashStatus$Registers$$serializer();
        INSTANCE = crashStatus$Registers$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.device.CrashStatus.Registers", crashStatus$Registers$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_R0, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_R1, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_R2, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_R3, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_R12, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_SP, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_LR, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_PC, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_PSR, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CrashStatus$Registers$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0025. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public CrashStatus.Registers deserialize(Decoder decoder) {
        int r5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        int r6 = 0;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str);
                    r6 |= 1;
                case 1:
                    str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str2);
                    r6 |= 2;
                case 2:
                    str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str3);
                    r6 |= 4;
                case 3:
                    str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str4);
                    r6 |= 8;
                case 4:
                    str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str5);
                    r6 |= 16;
                case 5:
                    str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str6);
                    r6 |= 32;
                case 6:
                    r5 = r6 | 64;
                    str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str7);
                    r6 = r5;
                case 7:
                    r5 = r6 | 128;
                    str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str8);
                    r6 = r5;
                case 8:
                    r5 = r6 | 256;
                    str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str9);
                    r6 = r5;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new CrashStatus.Registers(r6, str, str2, str3, str4, str5, str6, str7, str8, str9, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CrashStatus.Registers value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CrashStatus.Registers.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

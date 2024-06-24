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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrashStatus.kt */
/* loaded from: classes3.dex */
public final class CrashStatus$$serializer implements GeneratedSerializer<CrashStatus> {
    public static final CrashStatus$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CrashStatus$$serializer crashStatus$$serializer = new CrashStatus$$serializer();
        INSTANCE = crashStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.device.CrashStatus", crashStatus$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("registers", true);
        pluginGeneratedSerialDescriptor.addElement("appInfo", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_HW_REASON, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_REMOTE, true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CrashStatus$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CrashStatus$Registers$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CrashStatus$AppInfo$$serializer.INSTANCE), IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0021. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public CrashStatus deserialize(Decoder decoder) {
        int r4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r5 = 0;
        int r8 = 0;
        boolean z = false;
        CrashStatus.Registers registers = null;
        CrashStatus.AppInfo appInfo = null;
        String str = null;
        String str2 = null;
        boolean z2 = true;
        while (z2) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z2 = false;
                case 0:
                    r5 |= 1;
                    registers = (CrashStatus.Registers) beginStructure.decodeNullableSerializableElement(descriptor2, 0, CrashStatus$Registers$$serializer.INSTANCE, registers);
                case 1:
                    r5 |= 2;
                    appInfo = (CrashStatus.AppInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 1, CrashStatus$AppInfo$$serializer.INSTANCE, appInfo);
                case 2:
                    r8 = beginStructure.decodeIntElement(descriptor2, 2);
                    r4 = r5 | 4;
                    r5 = r4;
                case 3:
                    z = beginStructure.decodeBooleanElement(descriptor2, 3);
                    r4 = r5 | 8;
                    r5 = r4;
                case 4:
                    r5 |= 16;
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str);
                case 5:
                    r5 |= 32;
                    str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str2);
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new CrashStatus(r5, registers, appInfo, r8, z, str, str2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CrashStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CrashStatus.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

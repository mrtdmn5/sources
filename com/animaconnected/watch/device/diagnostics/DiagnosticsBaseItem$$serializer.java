package com.animaconnected.watch.device.diagnostics;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.device.CrashStatus;
import com.animaconnected.watch.device.CrashStatus$$serializer;
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

/* compiled from: DiagnosticsBaseItem.kt */
/* loaded from: classes3.dex */
public final class DiagnosticsBaseItem$$serializer implements GeneratedSerializer<DiagnosticsBaseItem> {
    public static final DiagnosticsBaseItem$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DiagnosticsBaseItem$$serializer diagnosticsBaseItem$$serializer = new DiagnosticsBaseItem$$serializer();
        INSTANCE = diagnosticsBaseItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.device.diagnostics.DiagnosticsBaseItem", diagnosticsBaseItem$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("device", false);
        pluginGeneratedSerialDescriptor.addElement("serialnumber", false);
        pluginGeneratedSerialDescriptor.addElement("watch", false);
        pluginGeneratedSerialDescriptor.addElement("sha1", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("watch_type", false);
        pluginGeneratedSerialDescriptor.addElement("app_version", false);
        pluginGeneratedSerialDescriptor.addElement("crash_status", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DiagnosticsBaseItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(CrashStatus$$serializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0025. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public DiagnosticsBaseItem deserialize(Decoder decoder) {
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
        CrashStatus crashStatus = null;
        int r6 = 0;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    str = beginStructure.decodeStringElement(descriptor2, 0);
                    r6 |= 1;
                case 1:
                    str2 = beginStructure.decodeStringElement(descriptor2, 1);
                    r6 |= 2;
                case 2:
                    str3 = beginStructure.decodeStringElement(descriptor2, 2);
                    r6 |= 4;
                case 3:
                    r6 |= 8;
                    str4 = beginStructure.decodeStringElement(descriptor2, 3);
                case 4:
                    r6 |= 16;
                    str5 = beginStructure.decodeStringElement(descriptor2, 4);
                case 5:
                    r6 |= 32;
                    str6 = beginStructure.decodeStringElement(descriptor2, 5);
                case 6:
                    r6 |= 64;
                    str7 = beginStructure.decodeStringElement(descriptor2, 6);
                case 7:
                    r6 |= 128;
                    str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str8);
                case 8:
                    r6 |= 256;
                    crashStatus = (CrashStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 8, CrashStatus$$serializer.INSTANCE, crashStatus);
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new DiagnosticsBaseItem(r6, str, str2, str3, str4, str5, str6, str7, str8, crashStatus, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DiagnosticsBaseItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DiagnosticsBaseItem.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

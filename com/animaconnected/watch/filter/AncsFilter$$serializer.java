package com.animaconnected.watch.filter;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.filter.Ancs;
import java.util.Set;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FilterSettingsExtension.kt */
/* loaded from: classes3.dex */
public final class AncsFilter$$serializer implements GeneratedSerializer<AncsFilter> {
    public static final AncsFilter$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        AncsFilter$$serializer ancsFilter$$serializer = new AncsFilter$$serializer();
        INSTANCE = ancsFilter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.filter.AncsFilter", ancsFilter$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_INDEX, false);
        pluginGeneratedSerialDescriptor.addElement("ancsCategory", false);
        pluginGeneratedSerialDescriptor.addElement("ancsAttribute", false);
        pluginGeneratedSerialDescriptor.addElement("searchString", false);
        pluginGeneratedSerialDescriptor.addElement("vibration", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AncsFilter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = AncsFilter.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(kSerializerArr[2]), StringSerializer.INSTANCE, kSerializerArr[4]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AncsFilter deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = AncsFilter.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        int r7 = 0;
        Set set = null;
        Ancs.Attribute attribute = null;
        String str = null;
        Ancs.VibrationPattern vibrationPattern = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                r7 = beginStructure.decodeIntElement(descriptor2, 0);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                r6 |= 2;
                set = (Set) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], set);
            } else if (decodeElementIndex == 2) {
                r6 |= 4;
                attribute = (Ancs.Attribute) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], attribute);
            } else if (decodeElementIndex == 3) {
                r6 |= 8;
                str = beginStructure.decodeStringElement(descriptor2, 3);
            } else {
                if (decodeElementIndex != 4) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                r6 |= 16;
                vibrationPattern = (Ancs.VibrationPattern) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], vibrationPattern);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AncsFilter(r6, r7, set, attribute, str, vibrationPattern, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AncsFilter value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AncsFilter.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

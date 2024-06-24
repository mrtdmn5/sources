package com.animaconnected.secondo.screens.workout.utils;

import androidx.core.util.Preconditions;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: GoogleMapsGenerator.kt */
/* loaded from: classes3.dex */
public final class GoogleMapBuilder$MapStyle$$serializer implements GeneratedSerializer<GoogleMapBuilder.MapStyle> {
    public static final int $stable = 0;
    public static final GoogleMapBuilder$MapStyle$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GoogleMapBuilder$MapStyle$$serializer googleMapBuilder$MapStyle$$serializer = new GoogleMapBuilder$MapStyle$$serializer();
        INSTANCE = googleMapBuilder$MapStyle$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder.MapStyle", googleMapBuilder$MapStyle$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("elementType", true);
        pluginGeneratedSerialDescriptor.addElement("featureType", true);
        pluginGeneratedSerialDescriptor.addElement("stylers", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GoogleMapBuilder$MapStyle$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GoogleMapBuilder.MapStyle.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GoogleMapBuilder.MapStyle deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GoogleMapBuilder.MapStyle.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str2);
                r6 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                list = (List) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], list);
                r6 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new GoogleMapBuilder.MapStyle(r6, str, str2, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GoogleMapBuilder.MapStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GoogleMapBuilder.MapStyle.write$Self$secondo_kronabyRelease(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

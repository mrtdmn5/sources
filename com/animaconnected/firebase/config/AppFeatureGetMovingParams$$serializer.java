package com.animaconnected.firebase.config;

import androidx.core.util.Preconditions;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AppFeatureGetMovingParams.kt */
/* loaded from: classes.dex */
public final class AppFeatureGetMovingParams$$serializer implements GeneratedSerializer<AppFeatureGetMovingParams> {
    public static final AppFeatureGetMovingParams$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        AppFeatureGetMovingParams$$serializer appFeatureGetMovingParams$$serializer = new AppFeatureGetMovingParams$$serializer();
        INSTANCE = appFeatureGetMovingParams$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.firebase.config.AppFeatureGetMovingParams", appFeatureGetMovingParams$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("timeout", true);
        pluginGeneratedSerialDescriptor.addElement("window", true);
        pluginGeneratedSerialDescriptor.addElement("start", true);
        pluginGeneratedSerialDescriptor.addElement("end", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AppFeatureGetMovingParams$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AppFeatureGetMovingParams deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                r6 = beginStructure.decodeIntElement(descriptor2, 0);
                r5 |= 1;
            } else if (decodeElementIndex == 1) {
                r7 = beginStructure.decodeIntElement(descriptor2, 1);
                r5 |= 2;
            } else if (decodeElementIndex == 2) {
                r8 = beginStructure.decodeIntElement(descriptor2, 2);
                r5 |= 4;
            } else {
                if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                r9 = beginStructure.decodeIntElement(descriptor2, 3);
                r5 |= 8;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AppFeatureGetMovingParams(r5, r6, r7, r8, r9, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AppFeatureGetMovingParams value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AppFeatureGetMovingParams.write$Self$firebase_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

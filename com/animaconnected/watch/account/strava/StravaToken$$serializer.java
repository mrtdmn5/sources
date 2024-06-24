package com.animaconnected.watch.account.strava;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: StravaToken.kt */
/* loaded from: classes3.dex */
public final class StravaToken$$serializer implements GeneratedSerializer<StravaToken> {
    public static final StravaToken$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StravaToken$$serializer stravaToken$$serializer = new StravaToken$$serializer();
        INSTANCE = stravaToken$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.account.strava.StravaToken", stravaToken$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("token_type", false);
        pluginGeneratedSerialDescriptor.addElement("expires_at", false);
        pluginGeneratedSerialDescriptor.addElement("expires_in", false);
        pluginGeneratedSerialDescriptor.addElement("refresh_token", false);
        pluginGeneratedSerialDescriptor.addElement("access_token", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StravaToken$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, LongSerializer.INSTANCE, IntSerializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StravaToken deserialize(Decoder decoder) {
        int r6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r8 = 0;
        int r12 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r8 |= 1;
            } else if (decodeElementIndex == 1) {
                j = beginStructure.decodeLongElement(descriptor2, 1);
                r8 |= 2;
            } else if (decodeElementIndex != 2) {
                if (decodeElementIndex == 3) {
                    r6 = r8 | 8;
                    str2 = beginStructure.decodeStringElement(descriptor2, 3);
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    r6 = r8 | 16;
                    str3 = beginStructure.decodeStringElement(descriptor2, 4);
                }
                r8 = r6;
            } else {
                r12 = beginStructure.decodeIntElement(descriptor2, 2);
                r8 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new StravaToken(r8, str, j, r12, str2, str3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StravaToken value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        StravaToken.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

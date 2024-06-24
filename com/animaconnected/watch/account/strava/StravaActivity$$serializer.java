package com.animaconnected.watch.account.strava;

import androidx.core.util.Preconditions;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: StravaActivity.kt */
/* loaded from: classes3.dex */
public final class StravaActivity$$serializer implements GeneratedSerializer<StravaActivity> {
    public static final StravaActivity$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StravaActivity$$serializer stravaActivity$$serializer = new StravaActivity$$serializer();
        INSTANCE = stravaActivity$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.account.strava.StravaActivity", stravaActivity$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("sport_type", false);
        pluginGeneratedSerialDescriptor.addElement("start_date_local", false);
        pluginGeneratedSerialDescriptor.addElement("elapsed_time", false);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement(DetailBottomDialog.keyDescription, true);
        pluginGeneratedSerialDescriptor.addElement("distance", true);
        pluginGeneratedSerialDescriptor.addElement("trainer", true);
        pluginGeneratedSerialDescriptor.addElement("commute", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StravaActivity$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, intSerializer, stringSerializer, stringSerializer, FloatSerializer.INSTANCE, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StravaActivity deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r7 = 0;
        int r11 = 0;
        int r15 = 0;
        int r16 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f = 0.0f;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = beginStructure.decodeStringElement(descriptor2, 0);
                    r7 |= 1;
                    break;
                case 1:
                    str2 = beginStructure.decodeStringElement(descriptor2, 1);
                    r7 |= 2;
                    break;
                case 2:
                    r7 |= 4;
                    str3 = beginStructure.decodeStringElement(descriptor2, 2);
                    break;
                case 3:
                    r11 = beginStructure.decodeIntElement(descriptor2, 3);
                    r7 |= 8;
                    break;
                case 4:
                    r7 |= 16;
                    str4 = beginStructure.decodeStringElement(descriptor2, 4);
                    break;
                case 5:
                    r7 |= 32;
                    str5 = beginStructure.decodeStringElement(descriptor2, 5);
                    break;
                case 6:
                    r7 |= 64;
                    f = beginStructure.decodeFloatElement(descriptor2, 6);
                    break;
                case 7:
                    r15 = beginStructure.decodeIntElement(descriptor2, 7);
                    r7 |= 128;
                    break;
                case 8:
                    r16 = beginStructure.decodeIntElement(descriptor2, 8);
                    r7 |= 256;
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new StravaActivity(r7, str, str2, str3, r11, str4, str5, f, r15, r16, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StravaActivity value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        StravaActivity.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

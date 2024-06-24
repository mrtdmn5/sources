package com.animaconnected.watch.account.strava;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Upload.kt */
/* loaded from: classes3.dex */
public final class Upload$$serializer implements GeneratedSerializer<Upload> {
    public static final Upload$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Upload$$serializer upload$$serializer = new Upload$$serializer();
        INSTANCE = upload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.account.strava.Upload", upload$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(ConfigurationItem.COLUMN_NAME_ID, false);
        pluginGeneratedSerialDescriptor.addElement("id_str", false);
        pluginGeneratedSerialDescriptor.addElement("external_id", false);
        pluginGeneratedSerialDescriptor.addElement("error", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_STATUS, false);
        pluginGeneratedSerialDescriptor.addElement("activity_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Upload$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(longSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(longSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Upload deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r5 = 0;
        Long l = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Long l2 = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    r5 |= 1;
                    l = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 0, LongSerializer.INSTANCE, l);
                    break;
                case 1:
                    r5 |= 2;
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str);
                    break;
                case 2:
                    r5 |= 4;
                    str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str2);
                    break;
                case 3:
                    r5 |= 8;
                    str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str3);
                    break;
                case 4:
                    r5 |= 16;
                    str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str4);
                    break;
                case 5:
                    r5 |= 32;
                    l2 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 5, LongSerializer.INSTANCE, l2);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Upload(r5, l, str, str2, str3, str4, l2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Upload value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Upload.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

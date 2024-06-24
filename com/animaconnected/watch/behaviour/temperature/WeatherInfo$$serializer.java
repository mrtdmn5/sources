package com.animaconnected.watch.behaviour.temperature;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.watch.assets.WatchAsset;
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

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class WeatherInfo$$serializer implements GeneratedSerializer<WeatherInfo> {
    public static final WeatherInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WeatherInfo$$serializer weatherInfo$$serializer = new WeatherInfo$$serializer();
        INSTANCE = weatherInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.WeatherInfo", weatherInfo$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(DetailBottomDialog.keyDescription, false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement(ConfigurationItem.COLUMN_NAME_ID, false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_MAIN, false);
        pluginGeneratedSerialDescriptor.addElement("asset", true);
        pluginGeneratedSerialDescriptor.addElement("smallAsset", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WeatherInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = WeatherInfo.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, IntSerializer.INSTANCE, stringSerializer, BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WeatherInfo deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = WeatherInfo.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        int r9 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        WatchAsset watchAsset = null;
        WatchAsset watchAsset2 = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = beginStructure.decodeStringElement(descriptor2, 0);
                    r6 |= 1;
                    break;
                case 1:
                    r6 |= 2;
                    str2 = beginStructure.decodeStringElement(descriptor2, 1);
                    break;
                case 2:
                    r9 = beginStructure.decodeIntElement(descriptor2, 2);
                    r6 |= 4;
                    break;
                case 3:
                    r6 |= 8;
                    str3 = beginStructure.decodeStringElement(descriptor2, 3);
                    break;
                case 4:
                    r6 |= 16;
                    watchAsset = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], watchAsset);
                    break;
                case 5:
                    r6 |= 32;
                    watchAsset2 = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], watchAsset2);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new WeatherInfo(r6, str, str2, r9, str3, watchAsset, watchAsset2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WeatherInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        WeatherInfo.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

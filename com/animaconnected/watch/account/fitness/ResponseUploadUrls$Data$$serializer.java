package com.animaconnected.watch.account.fitness;

import androidx.core.util.Preconditions;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.watch.account.fitness.ResponseUploadUrls;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FitnessHttpClient.kt */
/* loaded from: classes3.dex */
public final class ResponseUploadUrls$Data$$serializer implements GeneratedSerializer<ResponseUploadUrls.Data> {
    public static final ResponseUploadUrls$Data$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ResponseUploadUrls$Data$$serializer responseUploadUrls$Data$$serializer = new ResponseUploadUrls$Data$$serializer();
        INSTANCE = responseUploadUrls$Data$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.account.fitness.ResponseUploadUrls.Data", responseUploadUrls$Data$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.URL_ENCODING, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ResponseUploadUrls$Data$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ResponseUploadUrls.Data deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r6 = 0;
        String str = null;
        String str2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str2 = beginStructure.decodeStringElement(descriptor2, 0);
                r6 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ResponseUploadUrls.Data(r6, str2, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ResponseUploadUrls.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ResponseUploadUrls.Data.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

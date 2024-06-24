package com.animaconnected.watch.account;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.account.ResponseDownloadDataUrl;
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

/* compiled from: AccountHttpClient.kt */
/* loaded from: classes3.dex */
public final class ResponseDownloadDataUrl$$serializer implements GeneratedSerializer<ResponseDownloadDataUrl> {
    public static final ResponseDownloadDataUrl$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ResponseDownloadDataUrl$$serializer responseDownloadDataUrl$$serializer = new ResponseDownloadDataUrl$$serializer();
        INSTANCE = responseDownloadDataUrl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.account.ResponseDownloadDataUrl", responseDownloadDataUrl$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ResponseDownloadDataUrl$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ResponseDownloadDataUrl$Data$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ResponseDownloadDataUrl deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r4 = 0;
        ResponseDownloadDataUrl.Data data = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else {
                if (decodeElementIndex != 0) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                data = (ResponseDownloadDataUrl.Data) beginStructure.decodeSerializableElement(descriptor2, 0, ResponseDownloadDataUrl$Data$$serializer.INSTANCE, data);
                r4 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ResponseDownloadDataUrl(r4, data, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ResponseDownloadDataUrl value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        beginStructure.encodeSerializableElement(descriptor2, 0, ResponseDownloadDataUrl$Data$$serializer.INSTANCE, value.data);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

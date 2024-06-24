package com.google.firebase.messaging;

import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.encoders.proto.ProtobufEncoder$Builder$$ExternalSyntheticLambda0;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class ProtoEncoderDoNotUse {
    public static final ProtobufEncoder ENCODER;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ProtobufEncoder$Builder$$ExternalSyntheticLambda0 protobufEncoder$Builder$$ExternalSyntheticLambda0 = ProtobufEncoder.Builder.DEFAULT_FALLBACK_ENCODER;
        hashMap.put(ProtoEncoderDoNotUse.class, AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder.INSTANCE);
        hashMap2.remove(ProtoEncoderDoNotUse.class);
        hashMap.put(MessagingClientEventExtension.class, AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder.INSTANCE);
        hashMap2.remove(MessagingClientEventExtension.class);
        hashMap.put(MessagingClientEvent.class, AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder.INSTANCE);
        hashMap2.remove(MessagingClientEvent.class);
        ENCODER = new ProtobufEncoder(new HashMap(hashMap), new HashMap(hashMap2), protobufEncoder$Builder$$ExternalSyntheticLambda0);
    }

    public abstract MessagingClientEventExtension getMessagingClientEventExtension();
}

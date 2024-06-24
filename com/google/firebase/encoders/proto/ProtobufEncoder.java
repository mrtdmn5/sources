package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ProtobufEncoder {
    public final ObjectEncoder<Object> fallbackEncoder;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    /* loaded from: classes3.dex */
    public static final class Builder implements EncoderConfig<Builder> {
        public static final ProtobufEncoder$Builder$$ExternalSyntheticLambda0 DEFAULT_FALLBACK_ENCODER = new ProtobufEncoder$Builder$$ExternalSyntheticLambda0();
    }

    public ProtobufEncoder(HashMap hashMap, HashMap hashMap2, ProtobufEncoder$Builder$$ExternalSyntheticLambda0 protobufEncoder$Builder$$ExternalSyntheticLambda0) {
        this.objectEncoders = hashMap;
        this.valueEncoders = hashMap2;
        this.fallbackEncoder = protobufEncoder$Builder$$ExternalSyntheticLambda0;
    }

    public final void encode(Object obj, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        Map<Class<?>, ObjectEncoder<?>> map = this.objectEncoders;
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(byteArrayOutputStream, map, this.valueEncoders, this.fallbackEncoder);
        if (obj != null) {
            ObjectEncoder<?> objectEncoder = map.get(obj.getClass());
            if (objectEncoder != null) {
                objectEncoder.encode(obj, protobufDataEncoderContext);
            } else {
                throw new EncodingException("No encoder for " + obj.getClass());
            }
        }
    }
}

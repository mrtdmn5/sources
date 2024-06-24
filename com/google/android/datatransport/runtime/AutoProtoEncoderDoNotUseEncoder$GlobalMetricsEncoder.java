package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {
    public static final AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder();
    public static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR = new FieldDescriptor("storageMetrics", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(STORAGEMETRICS_DESCRIPTOR, ((GlobalMetrics) obj).storage_metrics_);
    }
}

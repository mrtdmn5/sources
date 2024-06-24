package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {
    public static final AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder();
    public static final FieldDescriptor WINDOW_DESCRIPTOR = new FieldDescriptor("window", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR = new FieldDescriptor("logSourceMetrics", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR = new FieldDescriptor("globalMetrics", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor APPNAMESPACE_DESCRIPTOR = new FieldDescriptor("appNamespace", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(4, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ClientMetrics clientMetrics = (ClientMetrics) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(WINDOW_DESCRIPTOR, clientMetrics.window_);
        objectEncoderContext2.add(LOGSOURCEMETRICS_DESCRIPTOR, clientMetrics.log_source_metrics_);
        objectEncoderContext2.add(GLOBALMETRICS_DESCRIPTOR, clientMetrics.global_metrics_);
        objectEncoderContext2.add(APPNAMESPACE_DESCRIPTOR, clientMetrics.app_namespace_);
    }
}

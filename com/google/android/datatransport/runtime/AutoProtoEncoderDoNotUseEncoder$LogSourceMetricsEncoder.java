package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {
    public static final AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder();
    public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = new FieldDescriptor("logSource", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR = new FieldDescriptor("logEventDropped", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(LOGSOURCE_DESCRIPTOR, logSourceMetrics.log_source_);
        objectEncoderContext2.add(LOGEVENTDROPPED_DESCRIPTOR, logSourceMetrics.log_event_dropped_);
    }
}

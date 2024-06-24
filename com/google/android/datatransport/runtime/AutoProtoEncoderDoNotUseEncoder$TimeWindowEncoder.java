package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder implements ObjectEncoder<TimeWindow> {
    public static final AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder();
    public static final FieldDescriptor STARTMS_DESCRIPTOR = new FieldDescriptor("startMs", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor ENDMS_DESCRIPTOR = new FieldDescriptor("endMs", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        TimeWindow timeWindow = (TimeWindow) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(STARTMS_DESCRIPTOR, timeWindow.start_ms_);
        objectEncoderContext2.add(ENDMS_DESCRIPTOR, timeWindow.end_ms_);
    }
}

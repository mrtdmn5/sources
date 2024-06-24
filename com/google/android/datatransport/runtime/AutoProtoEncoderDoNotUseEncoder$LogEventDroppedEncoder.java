package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {
    public static final AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder();
    public static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR = new FieldDescriptor("eventsDroppedCount", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor REASON_DESCRIPTOR = new FieldDescriptor("reason", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        LogEventDropped logEventDropped = (LogEventDropped) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.events_dropped_count_);
        objectEncoderContext2.add(REASON_DESCRIPTOR, logEventDropped.reason_);
    }
}

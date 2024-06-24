package com.google.firebase.messaging;

import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0;
import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {
    public static final AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder();
    public static final FieldDescriptor MESSAGINGCLIENTEVENT_DESCRIPTOR = new FieldDescriptor("messagingClientEvent", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(MESSAGINGCLIENTEVENT_DESCRIPTOR, ((MessagingClientEventExtension) obj).messaging_client_event_);
    }
}

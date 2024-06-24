package com.google.firebase.messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
    public static final AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder();
    public static final FieldDescriptor MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR = FieldDescriptor.of("messagingClientEventExtension");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR, ((ProtoEncoderDoNotUse) obj).getMessagingClientEventExtension());
    }
}

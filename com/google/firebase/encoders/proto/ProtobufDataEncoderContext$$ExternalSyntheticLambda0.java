package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ProtobufDataEncoderContext$$ExternalSyntheticLambda0 implements ObjectEncoder {
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        Map.Entry entry = (Map.Entry) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(ProtobufDataEncoderContext.MAP_KEY_DESC, entry.getKey());
        objectEncoderContext2.add(ProtobufDataEncoderContext.MAP_VALUE_DESC, entry.getValue());
    }
}

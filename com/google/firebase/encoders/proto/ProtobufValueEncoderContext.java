package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ProtobufValueEncoderContext implements ValueEncoderContext {
    public FieldDescriptor field;
    public final ProtobufDataEncoderContext objEncoderCtx;
    public boolean encoded = false;
    public boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        if (!this.encoded) {
            this.encoded = true;
            this.objEncoderCtx.add(this.field, str, this.skipDefault);
            return this;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) throws IOException {
        if (!this.encoded) {
            this.encoded = true;
            this.objEncoderCtx.add(this.field, z ? 1 : 0, this.skipDefault);
            return this;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }
}

package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class JsonDataEncoderBuilder$$ExternalSyntheticLambda2 implements ValueEncoder {
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ValueEncoderContext valueEncoderContext) {
        valueEncoderContext.add(((Boolean) obj).booleanValue());
    }
}

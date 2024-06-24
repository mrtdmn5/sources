package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class SendRequest {
    public abstract Encoding getEncoding();

    public abstract Event<?> getEvent();

    public abstract Transformer<?, byte[]> getTransformer();

    public abstract TransportContext getTransportContext();

    public abstract String getTransportName();
}

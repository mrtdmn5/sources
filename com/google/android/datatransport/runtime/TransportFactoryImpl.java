package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* loaded from: classes3.dex */
public final class TransportFactoryImpl implements TransportFactory {
    public final Set<Encoding> supportedPayloadEncodings;
    public final TransportContext transportContext;
    public final TransportInternal transportInternal;

    public TransportFactoryImpl(Set set, AutoValue_TransportContext autoValue_TransportContext, TransportInternal transportInternal) {
        this.supportedPayloadEncodings = set;
        this.transportContext = autoValue_TransportContext;
        this.transportInternal = transportInternal;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public final TransportImpl getTransport(String str, Encoding encoding, Transformer transformer) {
        Set<Encoding> set = this.supportedPayloadEncodings;
        if (set.contains(encoding)) {
            return new TransportImpl(this.transportContext, str, encoding, transformer, this.transportInternal);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
    }
}

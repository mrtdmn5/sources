package com.google.android.datatransport;

import com.google.android.datatransport.runtime.TransportImpl;

/* loaded from: classes3.dex */
public interface TransportFactory {
    TransportImpl getTransport(String str, Encoding encoding, Transformer transformer);
}

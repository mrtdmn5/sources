package com.google.android.datatransport.runtime;

import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class TransportImpl<T> implements Transport<T> {
    public final String name;
    public final Encoding payloadEncoding;
    public final Transformer<T, byte[]> transformer;
    public final TransportContext transportContext;
    public final TransportInternal transportInternal;

    public TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.transportContext = transportContext;
        this.name = str;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportInternal;
    }

    public final void schedule(AutoValue_Event autoValue_Event, TransportScheduleCallback transportScheduleCallback) {
        TransportContext transportContext = this.transportContext;
        if (transportContext != null) {
            String str = this.name;
            if (str != null) {
                Transformer<T, byte[]> transformer = this.transformer;
                if (transformer != null) {
                    Encoding encoding = this.payloadEncoding;
                    if (encoding != null) {
                        AutoValue_SendRequest autoValue_SendRequest = new AutoValue_SendRequest(transportContext, str, autoValue_Event, transformer, encoding);
                        TransportRuntime transportRuntime = (TransportRuntime) this.transportInternal;
                        transportRuntime.getClass();
                        Event<?> event = autoValue_SendRequest.event;
                        AutoValue_TransportContext withPriority = autoValue_SendRequest.transportContext.withPriority(event.getPriority());
                        AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
                        builder.autoMetadata = new HashMap();
                        builder.eventMillis = Long.valueOf(transportRuntime.eventClock.getTime());
                        builder.uptimeMillis = Long.valueOf(transportRuntime.uptimeClock.getTime());
                        builder.setTransportName(autoValue_SendRequest.transportName);
                        builder.setEncodedPayload(new EncodedPayload(autoValue_SendRequest.encoding, autoValue_SendRequest.transformer.apply(event.getPayload())));
                        builder.code = event.getCode();
                        transportRuntime.scheduler.schedule(transportScheduleCallback, builder.build(), withPriority);
                        return;
                    }
                    throw new NullPointerException("Null encoding");
                }
                throw new NullPointerException("Null transformer");
            }
            throw new NullPointerException("Null transportName");
        }
        throw new NullPointerException("Null transportContext");
    }
}

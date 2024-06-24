package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;

@AutoValue
/* loaded from: classes3.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    /* loaded from: classes3.dex */
    public static abstract class Builder {
        public final void addMetadata(String str, String str2) {
            Map<String, String> map = ((AutoValue_EventInternal.Builder) this).autoMetadata;
            if (map != null) {
                map.put(str, str2);
                return;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
    }

    public final String get(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public abstract Map<String, String> getAutoMetadata();

    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public final AutoValue_EventInternal.Builder toBuilder() {
        AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
        builder.setTransportName(getTransportName());
        builder.code = getCode();
        builder.setEncodedPayload(getEncodedPayload());
        builder.eventMillis = Long.valueOf(getEventMillis());
        builder.uptimeMillis = Long.valueOf(getUptimeMillis());
        builder.autoMetadata = new HashMap(getAutoMetadata());
        return builder;
    }
}

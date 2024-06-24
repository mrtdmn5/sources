package com.google.android.datatransport.runtime;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AutoValue_EventInternal extends EventInternal {
    public final Map<String, String> autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    /* loaded from: classes3.dex */
    public static final class Builder extends EventInternal.Builder {
        public Map<String, String> autoMetadata;
        public Integer code;
        public EncodedPayload encodedPayload;
        public Long eventMillis;
        public String transportName;
        public Long uptimeMillis;

        public final AutoValue_EventInternal build() {
            String str;
            if (this.transportName == null) {
                str = " transportName";
            } else {
                str = "";
            }
            if (this.encodedPayload == null) {
                str = str.concat(" encodedPayload");
            }
            if (this.eventMillis == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " eventMillis");
            }
            if (this.uptimeMillis == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " uptimeMillis");
            }
            if (this.autoMetadata == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.transportName, this.code, this.encodedPayload, this.eventMillis.longValue(), this.uptimeMillis.longValue(), this.autoMetadata);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public final Builder setEncodedPayload(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.encodedPayload = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public final Builder setTransportName(String str) {
            if (str != null) {
                this.transportName = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, Map map) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (this.transportName.equals(eventInternal.getTransportName()) && ((num = this.code) != null ? num.equals(eventInternal.getCode()) : eventInternal.getCode() == null) && this.encodedPayload.equals(eventInternal.getEncodedPayload()) && this.eventMillis == eventInternal.getEventMillis() && this.uptimeMillis == eventInternal.getUptimeMillis() && this.autoMetadata.equals(eventInternal.getAutoMetadata())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final Map<String, String> getAutoMetadata() {
        return this.autoMetadata;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final Integer getCode() {
        return this.code;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final EncodedPayload getEncodedPayload() {
        return this.encodedPayload;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final long getEventMillis() {
        return this.eventMillis;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final String getTransportName() {
        return this.transportName;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode3 = (((hashCode2 ^ hashCode) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003;
        long j = this.eventMillis;
        int r0 = (hashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.uptimeMillis;
        return ((r0 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.transportName + ", code=" + this.code + ", encodedPayload=" + this.encodedPayload + ", eventMillis=" + this.eventMillis + ", uptimeMillis=" + this.uptimeMillis + ", autoMetadata=" + this.autoMetadata + "}";
    }
}

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class AutoValue_TransportContext extends TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    /* loaded from: classes3.dex */
    public static final class Builder extends TransportContext.Builder {
        public String backendName;
        public byte[] extras;
        public Priority priority;

        public final AutoValue_TransportContext build() {
            String str;
            if (this.backendName == null) {
                str = " backendName";
            } else {
                str = "";
            }
            if (this.priority == null) {
                str = str.concat(" priority");
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.backendName, this.extras, this.priority);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public final Builder setBackendName(String str) {
            if (str != null) {
                this.backendName = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public final Builder setPriority(Priority priority) {
            if (priority != null) {
                this.priority = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority;
    }

    public final boolean equals(Object obj) {
        byte[] extras;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.backendName.equals(transportContext.getBackendName())) {
            if (transportContext instanceof AutoValue_TransportContext) {
                extras = ((AutoValue_TransportContext) transportContext).extras;
            } else {
                extras = transportContext.getExtras();
            }
            if (Arrays.equals(this.extras, extras) && this.priority.equals(transportContext.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final String getBackendName() {
        return this.backendName;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final byte[] getExtras() {
        return this.extras;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final Priority getPriority() {
        return this.priority;
    }

    public final int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }
}

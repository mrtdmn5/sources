package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class AutoValue_BackendRequest extends BackendRequest {
    public final Iterable<EventInternal> events;
    public final byte[] extras;

    public AutoValue_BackendRequest() {
        throw null;
    }

    public AutoValue_BackendRequest(Iterable iterable, byte[] bArr) {
        this.events = iterable;
        this.extras = bArr;
    }

    public final boolean equals(Object obj) {
        byte[] extras;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.events.equals(backendRequest.getEvents())) {
            if (backendRequest instanceof AutoValue_BackendRequest) {
                extras = ((AutoValue_BackendRequest) backendRequest).extras;
            } else {
                extras = backendRequest.getExtras();
            }
            if (Arrays.equals(this.extras, extras)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public final Iterable<EventInternal> getEvents() {
        return this.events;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public final byte[] getExtras() {
        return this.extras;
    }

    public final int hashCode() {
        return ((this.events.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras);
    }

    public final String toString() {
        return "BackendRequest{events=" + this.events + ", extras=" + Arrays.toString(this.extras) + "}";
    }
}

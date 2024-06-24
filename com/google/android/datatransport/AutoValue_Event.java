package com.google.android.datatransport;

/* loaded from: classes3.dex */
public final class AutoValue_Event<T> extends Event<T> {
    public final Integer code = null;
    public final T payload;
    public final Priority priority;

    /* JADX WARN: Multi-variable type inference failed */
    public AutoValue_Event(Object obj, Priority priority) {
        if (obj != 0) {
            this.payload = obj;
            if (priority != null) {
                this.priority = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.Event
    public final Integer getCode() {
        return this.code;
    }

    @Override // com.google.android.datatransport.Event
    public final T getPayload() {
        return this.payload;
    }

    @Override // com.google.android.datatransport.Event
    public final Priority getPriority() {
        return this.priority;
    }

    public final int hashCode() {
        int hashCode;
        Integer num = this.code;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return ((((hashCode ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public final String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + "}";
    }
}

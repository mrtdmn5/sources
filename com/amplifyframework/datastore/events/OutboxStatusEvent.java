package com.amplifyframework.datastore.events;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.logging.Logger;

/* loaded from: classes.dex */
public final class OutboxStatusEvent implements HubEvent.Data<OutboxStatusEvent> {
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:aws-datastore");
    private final boolean isEmpty;

    public OutboxStatusEvent(boolean z) {
        this.isEmpty = z;
    }

    public static OutboxStatusEvent from(HubEvent<?> hubEvent) throws AmplifyException {
        if (hubEvent.getData() instanceof OutboxStatusEvent) {
            return (OutboxStatusEvent) hubEvent.getData();
        }
        String name = OutboxStatusEvent.class.getName();
        throw new AmplifyException("Unable to cast event data from ".concat(name), "Ensure that the event payload is of type ".concat(name));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && OutboxStatusEvent.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(Boolean.valueOf(this.isEmpty), Boolean.valueOf(((OutboxStatusEvent) obj).isEmpty));
        }
        return false;
    }

    public int hashCode() {
        return Boolean.valueOf(this.isEmpty).hashCode();
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override // com.amplifyframework.hub.HubEvent.Data
    public HubEvent<OutboxStatusEvent> toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.OUTBOX_STATUS, this);
    }

    public String toString() {
        return "OutboxStatus{isEmpty=" + this.isEmpty + "}";
    }
}

package com.amplifyframework.datastore.events;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.events.ApiEndpointStatusChangeEvent;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.logging.Logger;

/* loaded from: classes.dex */
public final class NetworkStatusEvent implements HubEvent.Data<NetworkStatusEvent> {
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:aws-datastore");
    private final boolean active;

    public NetworkStatusEvent(boolean z) {
        this.active = z;
    }

    public static NetworkStatusEvent from(HubEvent<?> hubEvent) throws AmplifyException {
        if (hubEvent.getData() instanceof NetworkStatusEvent) {
            return (NetworkStatusEvent) hubEvent.getData();
        }
        String name = NetworkStatusEvent.class.getName();
        throw new AmplifyException("Unable to cast event data from ".concat(name), "Ensure that the event payload is of type ".concat(name));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NetworkStatusEvent.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(Boolean.valueOf(this.active), Boolean.valueOf(((NetworkStatusEvent) obj).active));
        }
        return false;
    }

    public boolean getActive() {
        return this.active;
    }

    public int hashCode() {
        return Boolean.valueOf(this.active).hashCode();
    }

    @Override // com.amplifyframework.hub.HubEvent.Data
    public HubEvent<NetworkStatusEvent> toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.NETWORK_STATUS, this);
    }

    public String toString() {
        return "NetworkStatus{active=" + this.active + "}";
    }

    public static NetworkStatusEvent from(ApiEndpointStatusChangeEvent apiEndpointStatusChangeEvent) {
        return new NetworkStatusEvent(ApiEndpointStatusChangeEvent.ApiEndpointStatus.REACHABLE.equals(apiEndpointStatusChangeEvent.getCurrentStatus()));
    }
}

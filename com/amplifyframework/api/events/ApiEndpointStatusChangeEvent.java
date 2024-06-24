package com.amplifyframework.api.events;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.hub.HubEvent;

/* loaded from: classes.dex */
public final class ApiEndpointStatusChangeEvent implements HubEvent.Data<ApiEndpointStatusChangeEvent> {
    private final ApiEndpointStatus currentStatus;
    private final ApiEndpointStatus previousStatus;

    /* loaded from: classes.dex */
    public enum ApiEndpointStatus {
        UNKOWN,
        REACHABLE,
        NOT_REACHABLE;

        public ApiEndpointStatusChangeEvent transitionTo(ApiEndpointStatus apiEndpointStatus) {
            return new ApiEndpointStatusChangeEvent(apiEndpointStatus, this);
        }
    }

    public ApiEndpointStatusChangeEvent(ApiEndpointStatus apiEndpointStatus, ApiEndpointStatus apiEndpointStatus2) {
        this.currentStatus = apiEndpointStatus;
        this.previousStatus = apiEndpointStatus2;
    }

    public static ApiEndpointStatusChangeEvent from(HubEvent<?> hubEvent) throws AmplifyException {
        if (hubEvent.getData() instanceof ApiEndpointStatusChangeEvent) {
            return (ApiEndpointStatusChangeEvent) hubEvent.getData();
        }
        throw new AmplifyException("Unable to cast event data from ApiEndpointStatusChangeEvent", "Ensure that the event payload is of type ApiEndpointStatusChangeEvent");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApiEndpointStatusChangeEvent.class != obj.getClass()) {
            return false;
        }
        ApiEndpointStatusChangeEvent apiEndpointStatusChangeEvent = (ApiEndpointStatusChangeEvent) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.currentStatus, apiEndpointStatusChangeEvent.currentStatus)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.previousStatus, apiEndpointStatusChangeEvent.previousStatus);
    }

    public ApiEndpointStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public ApiEndpointStatus getPreviousStatus() {
        return this.previousStatus;
    }

    public int hashCode() {
        int r0;
        ApiEndpointStatus apiEndpointStatus = this.currentStatus;
        int r1 = 0;
        if (apiEndpointStatus != null) {
            r0 = apiEndpointStatus.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        ApiEndpointStatus apiEndpointStatus2 = this.previousStatus;
        if (apiEndpointStatus2 != null) {
            r1 = apiEndpointStatus2.hashCode();
        }
        return r02 + r1;
    }

    @Override // com.amplifyframework.hub.HubEvent.Data
    public HubEvent<ApiEndpointStatusChangeEvent> toHubEvent() {
        return HubEvent.create(ApiChannelEventName.API_ENDPOINT_STATUS_CHANGED, this);
    }

    public String toString() {
        return "ApiEndpointStatusChangeEvent{currentStatus=" + this.currentStatus + ", previousStatus=" + this.previousStatus + "}";
    }
}

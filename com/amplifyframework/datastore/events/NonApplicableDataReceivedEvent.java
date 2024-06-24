package com.amplifyframework.datastore.events;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class NonApplicableDataReceivedEvent implements HubEvent.Data<NonApplicableDataReceivedEvent> {
    private final List<GraphQLResponse.Error> errors;
    private final String model;

    public NonApplicableDataReceivedEvent(List<GraphQLResponse.Error> list, String str) {
        this.errors = list;
        this.model = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NonApplicableDataReceivedEvent.class != obj.getClass()) {
            return false;
        }
        NonApplicableDataReceivedEvent nonApplicableDataReceivedEvent = (NonApplicableDataReceivedEvent) obj;
        if (!Objects.equals(this.errors, nonApplicableDataReceivedEvent.errors)) {
            return false;
        }
        return Objects.equals(this.model, nonApplicableDataReceivedEvent.model);
    }

    public List<GraphQLResponse.Error> getErrors() {
        return this.errors;
    }

    public String getModel() {
        return this.model;
    }

    public int hashCode() {
        int r0;
        List<GraphQLResponse.Error> list = this.errors;
        int r1 = 0;
        if (list != null) {
            r0 = list.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        String str = this.model;
        if (str != null) {
            r1 = str.hashCode();
        }
        return r02 + r1;
    }

    @Override // com.amplifyframework.hub.HubEvent.Data
    public HubEvent<NonApplicableDataReceivedEvent> toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.NON_APPLICABLE_DATA_RECEIVED, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NonApplicableDataReceivedEvent{errors=");
        sb.append(this.errors);
        sb.append(", model='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.model, "'}");
    }
}

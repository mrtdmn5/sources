package com.amplifyframework.datastore;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.util.Objects;

/* loaded from: classes.dex */
public enum DataStoreChannelEventName {
    READY("ready"),
    NETWORK_STATUS("networkStatus"),
    SUBSCRIPTIONS_ESTABLISHED("subscriptionsEstablished"),
    SUBSCRIPTION_DATA_PROCESSED("subscriptionDataProcessed"),
    OUTBOX_STATUS("outboxStatus"),
    OUTBOX_MUTATION_ENQUEUED("outboxMutationEnqueued"),
    OUTBOX_MUTATION_PROCESSED("outboxMutationProcessed"),
    OUTBOX_MUTATION_FAILED("outboxMutationFailed"),
    SYNC_QUERIES_STARTED("syncQueriesStarted"),
    SYNC_QUERIES_READY("syncQueriesReady"),
    MODEL_SYNCED("modelSynced"),
    NON_APPLICABLE_DATA_RECEIVED("nonApplicableDataReceived");

    private final String hubEventName;

    DataStoreChannelEventName(String str) {
        Objects.requireNonNull(str);
        this.hubEventName = str;
    }

    public static DataStoreChannelEventName fromString(String str) {
        for (DataStoreChannelEventName dataStoreChannelEventName : values()) {
            if (dataStoreChannelEventName.toString().equals(str)) {
                return dataStoreChannelEventName;
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("DataStore category does not publish any Hub event with name = ", str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.hubEventName;
    }
}

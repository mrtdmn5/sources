package com.amplifyframework.hub;

/* loaded from: classes.dex */
public interface HubCategoryBehavior {
    <T> void publish(HubChannel hubChannel, HubEvent<T> hubEvent) throws RuntimeException;

    SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber);

    SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber);

    void unsubscribe(SubscriptionToken subscriptionToken);
}

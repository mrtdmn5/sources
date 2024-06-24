package com.amplifyframework.hub;

import android.content.Context;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.hub.AWSHubPlugin;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AWSHubPlugin extends HubPlugin<Void> {
    private final Set<Subscription> subscriptions = new HashSet();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    /* loaded from: classes.dex */
    public static final class Subscription {
        private final HubChannel channel;
        private final HubEventFilter hubEventFilter;
        private final HubSubscriber hubSubscriber;
        private final SubscriptionToken subscriptionToken;

        public Subscription(SubscriptionToken subscriptionToken, HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
            Objects.requireNonNull(subscriptionToken);
            this.subscriptionToken = subscriptionToken;
            Objects.requireNonNull(hubChannel);
            this.channel = hubChannel;
            Objects.requireNonNull(hubEventFilter);
            this.hubEventFilter = hubEventFilter;
            Objects.requireNonNull(hubSubscriber);
            this.hubSubscriber = hubSubscriber;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Subscription.class != obj.getClass()) {
                return false;
            }
            Subscription subscription = (Subscription) obj;
            if (!ObjectsCompat$Api19Impl.equals(this.subscriptionToken, subscription.subscriptionToken) || this.channel != subscription.channel || !ObjectsCompat$Api19Impl.equals(this.hubEventFilter, subscription.hubEventFilter)) {
                return false;
            }
            return ObjectsCompat$Api19Impl.equals(this.hubSubscriber, subscription.hubSubscriber);
        }

        public HubChannel getHubChannel() {
            return this.channel;
        }

        public HubEventFilter getHubEventFilter() {
            return this.hubEventFilter;
        }

        public HubSubscriber getHubSubscriber() {
            return this.hubSubscriber;
        }

        public SubscriptionToken getSubscriptionToken() {
            return this.subscriptionToken;
        }

        public int hashCode() {
            return this.hubSubscriber.hashCode() + ((this.hubEventFilter.hashCode() + ((this.channel.hashCode() + (this.subscriptionToken.hashCode() * 31)) * 31)) * 31);
        }

        public String toString() {
            return "Subscription{subscriptionToken=" + this.subscriptionToken + ", channel=" + this.channel + ", hubEventFilter=" + this.hubEventFilter + ", hubSubscriber=" + this.hubSubscriber + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$publish$0(Subscription subscription, HubEvent hubEvent) {
        subscription.getHubSubscriber().onEvent(hubEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$publish$1(HubChannel hubChannel, final HubEvent hubEvent) {
        synchronized (this.subscriptions) {
            for (final Subscription subscription : this.subscriptions) {
                if (subscription.getHubChannel().equals(hubChannel) && subscription.getHubEventFilter().filter(hubEvent)) {
                    this.executorService.execute(new Runnable() { // from class: com.amplifyframework.hub.AWSHubPlugin$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AWSHubPlugin.lambda$publish$0(AWSHubPlugin.Subscription.this, hubEvent);
                        }
                    });
                }
            }
        }
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public Void getEscapeHatch() {
        return null;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getPluginKey() {
        return "awsHubPlugin";
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getVersion() {
        return "2.5.0";
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public <T> void publish(final HubChannel hubChannel, final HubEvent<T> hubEvent) {
        Objects.requireNonNull(hubChannel);
        Objects.requireNonNull(hubEvent);
        this.executorService.execute(new Runnable() { // from class: com.amplifyframework.hub.AWSHubPlugin$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AWSHubPlugin.this.lambda$publish$1(hubChannel, hubEvent);
            }
        });
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber) {
        return subscribe(hubChannel, HubEventFilters.always(), hubSubscriber);
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public void unsubscribe(SubscriptionToken subscriptionToken) {
        Objects.requireNonNull(subscriptionToken);
        synchronized (this.subscriptions) {
            Iterator<Subscription> it = this.subscriptions.iterator();
            while (it.hasNext()) {
                if (it.next().getSubscriptionToken().equals(subscriptionToken)) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
        Objects.requireNonNull(hubChannel);
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubSubscriber);
        SubscriptionToken create = SubscriptionToken.create();
        synchronized (this.subscriptions) {
            this.subscriptions.add(new Subscription(create, hubChannel, hubEventFilter, hubSubscriber));
        }
        return create;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void configure(JSONObject jSONObject, Context context) {
    }
}

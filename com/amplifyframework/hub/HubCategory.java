package com.amplifyframework.hub;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public final class HubCategory extends Category<HubPlugin<?>> implements HubCategoryBehavior {
    private final HubPlugin<?> defaultPlugin = new AWSHubPlugin();

    private HubPlugin<?> getHubPlugin() {
        if (super.isInitialized() && !super.getPlugins().isEmpty()) {
            return (HubPlugin) super.getSelectedPlugin();
        }
        return this.defaultPlugin;
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.HUB;
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public <T> void publish(HubChannel hubChannel, HubEvent<T> hubEvent) {
        getHubPlugin().publish(hubChannel, hubEvent);
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber) {
        return getHubPlugin().subscribe(hubChannel, hubSubscriber);
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public void unsubscribe(SubscriptionToken subscriptionToken) {
        getHubPlugin().unsubscribe(subscriptionToken);
    }

    @Override // com.amplifyframework.hub.HubCategoryBehavior
    public SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
        return getHubPlugin().subscribe(hubChannel, hubEventFilter, hubSubscriber);
    }
}

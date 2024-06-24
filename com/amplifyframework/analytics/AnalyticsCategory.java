package com.amplifyframework.analytics;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public final class AnalyticsCategory extends Category<AnalyticsPlugin<?>> implements AnalyticsCategoryBehavior {
    private boolean enabled = true;

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void disable() {
        this.enabled = false;
        getSelectedPlugin().disable();
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void enable() {
        this.enabled = true;
        getSelectedPlugin().enable();
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void flushEvents() {
        if (this.enabled) {
            getSelectedPlugin().flushEvents();
        }
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.ANALYTICS;
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void identifyUser(String str, UserProfile userProfile) {
        if (this.enabled) {
            getSelectedPlugin().identifyUser(str, userProfile);
        }
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void recordEvent(String str) {
        if (this.enabled) {
            getSelectedPlugin().recordEvent(str);
        }
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void registerGlobalProperties(AnalyticsProperties analyticsProperties) {
        getSelectedPlugin().registerGlobalProperties(analyticsProperties);
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void unregisterGlobalProperties(String... strArr) {
        getSelectedPlugin().unregisterGlobalProperties(strArr);
    }

    @Override // com.amplifyframework.analytics.AnalyticsCategoryBehavior
    public void recordEvent(AnalyticsEventBehavior analyticsEventBehavior) {
        if (this.enabled) {
            getSelectedPlugin().recordEvent(analyticsEventBehavior);
        }
    }
}

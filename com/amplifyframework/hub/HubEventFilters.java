package com.amplifyframework.hub;

import java.util.Objects;

/* loaded from: classes.dex */
public final class HubEventFilters {
    private HubEventFilters() {
        throw new UnsupportedOperationException("No instances of the HubEventFilters utility, please.");
    }

    public static HubEventFilter all(final HubEventFilter... hubEventFilterArr) {
        return new HubEventFilter() { // from class: com.amplifyframework.hub.HubEventFilters$$ExternalSyntheticLambda3
            @Override // com.amplifyframework.hub.HubEventFilter
            public final boolean filter(HubEvent hubEvent) {
                boolean lambda$all$1;
                lambda$all$1 = HubEventFilters.lambda$all$1(hubEventFilterArr, hubEvent);
                return lambda$all$1;
            }
        };
    }

    public static HubEventFilter always() {
        return new HubEventFilters$$ExternalSyntheticLambda2();
    }

    public static HubEventFilter and(final HubEventFilter hubEventFilter, final HubEventFilter hubEventFilter2) {
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubEventFilter2);
        return new HubEventFilter() { // from class: com.amplifyframework.hub.HubEventFilters$$ExternalSyntheticLambda1
            @Override // com.amplifyframework.hub.HubEventFilter
            public final boolean filter(HubEvent hubEvent) {
                boolean lambda$and$3;
                lambda$and$3 = HubEventFilters.lambda$and$3(HubEventFilter.this, hubEventFilter2, hubEvent);
                return lambda$and$3;
            }
        };
    }

    public static HubEventFilter any(final HubEventFilter... hubEventFilterArr) {
        return new HubEventFilter() { // from class: com.amplifyframework.hub.HubEventFilters$$ExternalSyntheticLambda4
            @Override // com.amplifyframework.hub.HubEventFilter
            public final boolean filter(HubEvent hubEvent) {
                boolean lambda$any$2;
                lambda$any$2 = HubEventFilters.lambda$any$2(hubEventFilterArr, hubEvent);
                return lambda$any$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$all$1(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        boolean z = true;
        for (HubEventFilter hubEventFilter : hubEventFilterArr) {
            if (hubEventFilter != null) {
                z &= hubEventFilter.filter(hubEvent);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$always$0(HubEvent hubEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$and$3(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        if (hubEventFilter.filter(hubEvent) && hubEventFilter2.filter(hubEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$any$2(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        boolean z = false;
        for (HubEventFilter hubEventFilter : hubEventFilterArr) {
            if (hubEventFilter != null) {
                z |= hubEventFilter.filter(hubEvent);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$or$4(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        if (!hubEventFilter.filter(hubEvent) && !hubEventFilter2.filter(hubEvent)) {
            return false;
        }
        return true;
    }

    public static HubEventFilter or(final HubEventFilter hubEventFilter, final HubEventFilter hubEventFilter2) {
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubEventFilter2);
        return new HubEventFilter() { // from class: com.amplifyframework.hub.HubEventFilters$$ExternalSyntheticLambda0
            @Override // com.amplifyframework.hub.HubEventFilter
            public final boolean filter(HubEvent hubEvent) {
                boolean lambda$or$4;
                lambda$or$4 = HubEventFilters.lambda$or$4(HubEventFilter.this, hubEventFilter2, hubEvent);
                return lambda$or$4;
            }
        };
    }
}

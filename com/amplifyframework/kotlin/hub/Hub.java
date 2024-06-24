package com.amplifyframework.kotlin.hub;

import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.hub.HubEventFilter;
import com.amplifyframework.hub.HubEventFilters;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Hub.kt */
/* loaded from: classes.dex */
public interface Hub {

    /* compiled from: Hub.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Flow subscribe$default(Hub hub, HubChannel hubChannel, HubEventFilter hubEventFilter, int r3, Object obj) {
            if (obj == null) {
                if ((r3 & 2) != 0) {
                    hubEventFilter = HubEventFilters.always();
                    Intrinsics.checkNotNullExpressionValue(hubEventFilter, "always()");
                }
                return hub.subscribe(hubChannel, hubEventFilter);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }
    }

    void publish(HubChannel hubChannel, HubEvent<?> hubEvent);

    Flow<HubEvent<?>> subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter);
}

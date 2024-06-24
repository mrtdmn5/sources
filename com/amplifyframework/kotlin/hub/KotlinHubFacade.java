package com.amplifyframework.kotlin.hub;

import com.amplifyframework.hub.HubCategoryBehavior;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.hub.HubEventFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KotlinHubFacade.kt */
/* loaded from: classes.dex */
public final class KotlinHubFacade implements Hub {
    private final HubCategoryBehavior delegate;

    public KotlinHubFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.amplifyframework.kotlin.hub.Hub
    public void publish(HubChannel channel, HubEvent<?> event) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(event, "event");
        this.delegate.publish(channel, event);
    }

    @Override // com.amplifyframework.kotlin.hub.Hub
    public Flow<HubEvent<?>> subscribe(HubChannel channel, HubEventFilter filter) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(filter, "filter");
        return FlowKt.callbackFlow(new KotlinHubFacade$subscribe$1(this, channel, filter, null));
    }

    public KotlinHubFacade(HubCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinHubFacade(com.amplifyframework.hub.HubCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.hub.HubCategory r1 = com.amplifyframework.core.Amplify.Hub
            java.lang.String r2 = "Hub"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.hub.KotlinHubFacade.<init>(com.amplifyframework.hub.HubCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

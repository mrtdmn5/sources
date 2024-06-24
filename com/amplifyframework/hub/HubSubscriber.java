package com.amplifyframework.hub;

import android.util.Log;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubEvent;

/* loaded from: classes.dex */
public interface HubSubscriber {
    static <T extends HubEvent.Data> HubSubscriber create(final Consumer<T> consumer) {
        return new HubSubscriber() { // from class: com.amplifyframework.hub.HubSubscriber$$ExternalSyntheticLambda0
            @Override // com.amplifyframework.hub.HubSubscriber
            public final void onEvent(HubEvent hubEvent) {
                HubSubscriber.lambda$create$0(Consumer.this, hubEvent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$create$0(Consumer consumer, HubEvent hubEvent) {
        try {
            consumer.accept((HubEvent.Data) hubEvent.getData());
        } catch (Exception e) {
            Log.w("amplify:aws-hub", "Unable to cast event data for event type " + hubEvent.getName(), e);
        }
    }

    void onEvent(HubEvent<?> hubEvent);
}

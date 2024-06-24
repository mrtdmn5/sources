package com.animaconnected.cloud;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class CloudEventDispatcher {
    private static final CloudEventDispatcher sInstance = new CloudEventDispatcher();
    private final Set<CloudEventListener> mEventListeners = new CopyOnWriteArraySet();

    private CloudEventDispatcher() {
    }

    public static CloudEventDispatcher getInstance() {
        return sInstance;
    }

    public void notify(CloudEvent cloudEvent) {
        Iterator<CloudEventListener> it = this.mEventListeners.iterator();
        while (it.hasNext()) {
            it.next().cloudEvent(cloudEvent);
        }
    }

    public void registerEventListener(CloudEventListener cloudEventListener) {
        this.mEventListeners.add(cloudEventListener);
    }

    public void unregisterEventListener(CloudEventListener cloudEventListener) {
        this.mEventListeners.remove(cloudEventListener);
    }
}

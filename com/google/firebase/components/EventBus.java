package com.google.firebase.components;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class EventBus implements Subscriber, Publisher {
    public final Executor defaultExecutor;
    public final HashMap handlerMap = new HashMap();
    public ArrayDeque pendingEvents = new ArrayDeque();

    public EventBus(Executor executor) {
        this.defaultExecutor = executor;
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void subscribe(Executor executor, EventHandler eventHandler) {
        executor.getClass();
        if (!this.handlerMap.containsKey(DataCollectionDefaultChange.class)) {
            this.handlerMap.put(DataCollectionDefaultChange.class, new ConcurrentHashMap());
        }
        ((ConcurrentHashMap) this.handlerMap.get(DataCollectionDefaultChange.class)).put(eventHandler, executor);
    }

    @Override // com.google.firebase.events.Subscriber
    public final void subscribe(FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0 firebaseMessaging$AutoInit$$ExternalSyntheticLambda0) {
        subscribe(this.defaultExecutor, firebaseMessaging$AutoInit$$ExternalSyntheticLambda0);
    }
}

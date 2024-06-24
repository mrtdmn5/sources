package com.google.firebase.events;

import com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface Subscriber {
    void subscribe(FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0 firebaseMessaging$AutoInit$$ExternalSyntheticLambda0);

    void subscribe(Executor executor, EventHandler eventHandler);
}

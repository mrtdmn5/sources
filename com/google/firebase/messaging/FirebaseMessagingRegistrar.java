package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), (TransportFactory) componentContainer.get(TransportFactory.class), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(FirebaseMessaging.class);
        builder.name = LIBRARY_NAME;
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(0, 0, FirebaseInstanceIdInternal.class));
        builder.add(new Dependency(0, 1, UserAgentPublisher.class));
        builder.add(new Dependency(0, 1, HeartBeatInfo.class));
        builder.add(new Dependency(0, 0, TransportFactory.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory = new FirebaseMessagingRegistrar$$ExternalSyntheticLambda0();
        builder.setInstantiation(1);
        return Arrays.asList(builder.build(), LibraryVersionComponent.create(LIBRARY_NAME, "23.1.2"));
    }
}

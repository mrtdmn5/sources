package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@Keep
/* loaded from: classes3.dex */
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    /* JADX INFO: Access modifiers changed from: private */
    public static RemoteConfigComponent lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        FirebaseABTesting firebaseABTesting;
        Context context = (Context) componentContainer.get(Context.class);
        Executor executor = (Executor) componentContainer.get(qualified);
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        AbtComponent abtComponent = (AbtComponent) componentContainer.get(AbtComponent.class);
        synchronized (abtComponent) {
            if (!abtComponent.abtOriginInstances.containsKey("frc")) {
                abtComponent.abtOriginInstances.put("frc", new FirebaseABTesting(abtComponent.analyticsConnector));
            }
            firebaseABTesting = (FirebaseABTesting) abtComponent.abtOriginInstances.get("frc");
        }
        return new RemoteConfigComponent(context, executor, firebaseApp, firebaseInstallationsApi, firebaseABTesting, componentContainer.getProvider(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualified = new Qualified(Blocking.class, Executor.class);
        Component.Builder builder = Component.builder(RemoteConfigComponent.class);
        builder.name = LIBRARY_NAME;
        builder.add(Dependency.required(Context.class));
        builder.add(new Dependency((Qualified<?>) qualified, 1, 0));
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(AbtComponent.class));
        builder.add(new Dependency(0, 1, AnalyticsConnector.class));
        builder.factory = new ComponentFactory() { // from class: com.google.firebase.remoteconfig.RemoteConfigRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
                RemoteConfigComponent lambda$getComponents$0;
                lambda$getComponents$0 = RemoteConfigRegistrar.lambda$getComponents$0(Qualified.this, restrictedComponentContainer);
                return lambda$getComponents$0;
            }
        };
        builder.setInstantiation(2);
        return Arrays.asList(builder.build(), LibraryVersionComponent.create(LIBRARY_NAME, "21.2.1"));
    }
}

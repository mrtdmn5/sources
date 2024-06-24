package com.google.firebase;

import android.content.Context;
import android.os.Build;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher$$ExternalSyntheticLambda0;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String safeValue(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        Component.Builder builder = Component.builder(UserAgentPublisher.class);
        builder.add(new Dependency(2, 0, LibraryVersion.class));
        builder.factory = new DefaultUserAgentPublisher$$ExternalSyntheticLambda0();
        arrayList.add(builder.build());
        final Qualified qualified = new Qualified(Background.class, Executor.class);
        Component.Builder builder2 = new Component.Builder(DefaultHeartBeatController.class, new Class[]{HeartBeatController.class, HeartBeatInfo.class});
        builder2.add(Dependency.required(Context.class));
        builder2.add(Dependency.required(FirebaseApp.class));
        builder2.add(new Dependency(2, 0, HeartBeatConsumer.class));
        builder2.add(new Dependency(1, 1, UserAgentPublisher.class));
        builder2.add(new Dependency((Qualified<?>) qualified, 1, 0));
        builder2.factory = new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda2
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
                return new DefaultHeartBeatController((Context) restrictedComponentContainer.get(Context.class), ((FirebaseApp) restrictedComponentContainer.get(FirebaseApp.class)).getPersistenceKey(), restrictedComponentContainer.setOf(Qualified.unqualified(HeartBeatConsumer.class)), restrictedComponentContainer.getProvider(UserAgentPublisher.class), (Executor) restrictedComponentContainer.get(Qualified.this));
            }
        };
        arrayList.add(builder2.build());
        arrayList.add(LibraryVersionComponent.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.create("fire-core", "20.3.1"));
        arrayList.add(LibraryVersionComponent.create("device-name", safeValue(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.create("device-model", safeValue(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.create("device-brand", safeValue(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.fromContext("android-target-sdk", new FirebaseCommonRegistrar$$ExternalSyntheticLambda0()));
        arrayList.add(LibraryVersionComponent.fromContext("android-min-sdk", new FirebaseCommonRegistrar$$ExternalSyntheticLambda1()));
        arrayList.add(LibraryVersionComponent.fromContext("android-platform", new FirebaseCommonRegistrar$$ExternalSyntheticLambda2()));
        arrayList.add(LibraryVersionComponent.fromContext("android-installer", new FirebaseCommonRegistrar$$ExternalSyntheticLambda3()));
        try {
            str = KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(LibraryVersionComponent.create("kotlin", str));
        }
        return arrayList;
    }
}

package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzef;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.analytics.connector.zza;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
@Keep
/* loaded from: classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static AnalyticsConnector lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        Context context = (Context) componentContainer.get(Context.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (AnalyticsConnectorImpl.zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (AnalyticsConnectorImpl.zzc == null) {
                    Bundle bundle = new Bundle(1);
                    firebaseApp.checkNotDeleted();
                    if ("[DEFAULT]".equals(firebaseApp.name)) {
                        subscriber.subscribe(zza.zza, com.google.firebase.analytics.connector.zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    AnalyticsConnectorImpl.zzc = new AnalyticsConnectorImpl(zzef.zzg(context, bundle).zze);
                }
            }
        }
        return AnalyticsConnectorImpl.zzc;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(AnalyticsConnector.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory = zzb.zza;
        builder.setInstantiation(2);
        return Arrays.asList(builder.build(), LibraryVersionComponent.create("fire-analytics", "21.2.0"));
    }
}

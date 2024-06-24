package com.google.firebase.analytics.connector.internal;

import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzb implements ComponentFactory {
    public static final /* synthetic */ zzb zza = new zzb();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(restrictedComponentContainer);
    }
}

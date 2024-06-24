package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideTargetSdkFactory implements Provider {
    public final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideTargetSdkFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        int r0;
        Context context = this.contextProvider.get();
        try {
            r0 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (Throwable unused) {
            r0 = Integer.MAX_VALUE;
        }
        return Integer.valueOf(r0);
    }
}

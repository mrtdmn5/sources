package com.google.firebase.crashlytics.internal;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {
    public static final MissingNativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider();
    public final AtomicReference<CrashlyticsNativeComponent> availableNativeComponent = new AtomicReference<>(null);
    public final Deferred<CrashlyticsNativeComponent> deferredNativeComponent;

    /* loaded from: classes3.dex */
    public static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred<CrashlyticsNativeComponent> deferred) {
        this.deferredNativeComponent = deferred;
        ((OptionalProvider) deferred).whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy$$ExternalSyntheticLambda0
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = CrashlyticsNativeComponentDeferredProxy.this;
                crashlyticsNativeComponentDeferredProxy.getClass();
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
                }
                crashlyticsNativeComponentDeferredProxy.availableNativeComponent.set((CrashlyticsNativeComponent) provider.get());
            }
        });
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final NativeSessionFileProvider getSessionFileProvider(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        if (crashlyticsNativeComponent == null) {
            return MISSING_NATIVE_SESSION_FILE_PROVIDER;
        }
        return crashlyticsNativeComponent.getSessionFileProvider(str);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean hasCrashDataForCurrentSession() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        if (crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForCurrentSession()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean hasCrashDataForSession(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        if (crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForSession(str)) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final void prepareNativeSession(final String str, final String str2, final long j, final StaticSessionData staticSessionData) {
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("Deferring native open session: ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", m, null);
        }
        ((OptionalProvider) this.deferredNativeComponent).whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy$$ExternalSyntheticLambda1
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(str, str2, j, staticSessionData);
            }
        });
    }
}

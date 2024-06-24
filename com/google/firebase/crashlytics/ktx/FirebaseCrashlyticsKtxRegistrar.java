package com.google.firebase.crashlytics.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: FirebaseCrashlytics.kt */
@Keep
/* loaded from: classes3.dex */
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return CollectionsKt__CollectionsKt.listOf(LibraryVersionComponent.create("fire-cls-ktx", "18.3.5"));
    }
}

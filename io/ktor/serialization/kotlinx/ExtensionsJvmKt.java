package io.ktor.serialization.kotlinx;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtensionsJvm.kt */
/* loaded from: classes3.dex */
public final class ExtensionsJvmKt {
    public static final List<KotlinxSerializationExtensionProvider> providers;

    static {
        ServiceLoader load = ServiceLoader.load(KotlinxSerializationExtensionProvider.class, KotlinxSerializationExtensionProvider.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(load, "load(it, it.classLoader)");
        providers = CollectionsKt___CollectionsKt.toList(load);
    }
}

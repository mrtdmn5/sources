package com.google.firebase.ktx;

import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: Firebase.kt */
/* loaded from: classes3.dex */
public final class FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> implements ComponentFactory {
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> INSTANCE = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<>();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
        Object obj = restrictedComponentContainer.get(new Qualified<>(Blocking.class, Executor.class));
        Intrinsics.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
        return ExecutorsKt.from((Executor) obj);
    }
}

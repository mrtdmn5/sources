package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisposableSaveableStateRegistry.android.kt */
/* loaded from: classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    public final /* synthetic */ SaveableStateRegistry $$delegate_0;
    public final Function0<Unit> onDispose;

    public DisposableSaveableStateRegistry(SaveableStateRegistryImpl saveableStateRegistryImpl, DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 disposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1) {
        this.onDispose = disposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1;
        this.$$delegate_0 = saveableStateRegistryImpl;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.$$delegate_0.canBeSaved(value);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.$$delegate_0.consumeRestored(key);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map<String, List<Object>> performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(String key, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.$$delegate_0.registerProvider(key, function0);
    }
}

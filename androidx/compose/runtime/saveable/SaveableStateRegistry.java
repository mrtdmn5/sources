package androidx.compose.runtime.saveable;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: SaveableStateRegistry.kt */
/* loaded from: classes.dex */
public interface SaveableStateRegistry {

    /* compiled from: SaveableStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface Entry {
        void unregister();
    }

    boolean canBeSaved(Object obj);

    Object consumeRestored(String str);

    Map<String, List<Object>> performSave();

    Entry registerProvider(String str, Function0<? extends Object> function0);
}

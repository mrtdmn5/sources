package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: SaveableStateRegistry.kt */
/* loaded from: classes.dex */
public final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    public final Function1<Object, Boolean> canBeSaved;
    public final LinkedHashMap restored;
    public final LinkedHashMap valueProviders;

    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> canBeSaved) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(canBeSaved, "canBeSaved");
        this.canBeSaved = canBeSaved;
        if (map != null) {
            linkedHashMap = MapsKt__MapsKt.toMutableMap(map);
        } else {
            linkedHashMap = new LinkedHashMap();
        }
        this.restored = linkedHashMap;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.canBeSaved.invoke(value).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = this.restored;
        List list = (List) linkedHashMap.remove(key);
        if (list != null && (!list.isEmpty())) {
            if (list.size() > 1) {
                linkedHashMap.put(key, list.subList(1, list.size()));
            }
            return list.get(0);
        }
        return null;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map<String, List<Object>> performSave() {
        LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(this.restored);
        for (Map.Entry entry : this.valueProviders.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() == 1) {
                Object invoke = ((Function0) list.get(0)).invoke();
                if (invoke == null) {
                    continue;
                } else if (canBeSaved(invoke)) {
                    mutableMap.put(str, CollectionsKt__CollectionsKt.arrayListOf(invoke));
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int r7 = 0; r7 < size; r7++) {
                    Object invoke2 = ((Function0) list.get(r7)).invoke();
                    if (invoke2 != null && !canBeSaved(invoke2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    arrayList.add(invoke2);
                }
                mutableMap.put(str, arrayList);
            }
        }
        return mutableMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(final String key, final Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!StringsKt__StringsJVMKt.isBlank(key)) {
            LinkedHashMap linkedHashMap = this.valueProviders;
            Object obj = linkedHashMap.get(key);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(key, obj);
            }
            ((List) obj).add(function0);
            return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
                @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
                public final void unregister() {
                    SaveableStateRegistryImpl saveableStateRegistryImpl = SaveableStateRegistryImpl.this;
                    LinkedHashMap linkedHashMap2 = saveableStateRegistryImpl.valueProviders;
                    String str = key;
                    List list = (List) linkedHashMap2.remove(str);
                    if (list != null) {
                        list.remove(function0);
                    }
                    if (list != null && (!list.isEmpty())) {
                        saveableStateRegistryImpl.valueProviders.put(str, list);
                    }
                }
            };
        }
        throw new IllegalArgumentException("Registered key is empty or blank".toString());
    }
}

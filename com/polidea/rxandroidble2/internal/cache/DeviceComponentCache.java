package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentWeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class DeviceComponentCache implements Map<String, DeviceComponent> {
    public final HashMap<String, DeviceComponentWeakReference> cache;
    public final DeviceComponentWeakReference.Provider deviceComponentReferenceProvider;

    /* renamed from: com.polidea.rxandroidble2.internal.cache.DeviceComponentCache$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements DeviceComponentWeakReference.Provider {
    }

    public DeviceComponentCache() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.cache = new HashMap<>();
        this.deviceComponentReferenceProvider = anonymousClass1;
    }

    @Override // java.util.Map
    public final void clear() {
        this.cache.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (this.cache.containsKey(obj) && get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        boolean z;
        Iterator<DeviceComponentWeakReference> it = this.cache.values().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            DeviceComponent deviceComponent = it.next().get();
            if ((obj instanceof DeviceComponent) && deviceComponent != null && deviceComponent.provideDevice() == ((DeviceComponent) obj).provideDevice()) {
                z = true;
            }
        } while (!z);
        return true;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, DeviceComponent>> entrySet() {
        boolean z;
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, DeviceComponentWeakReference> entry : this.cache.entrySet()) {
            DeviceComponentWeakReference value = entry.getValue();
            if (value.get() == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                String key = entry.getKey();
                DeviceComponent deviceComponent = value.get();
                ((AnonymousClass1) this.deviceComponentReferenceProvider).getClass();
                hashSet.add(new CacheEntry(key, new DeviceComponentWeakReference(deviceComponent)));
            }
        }
        return hashSet;
    }

    public final void evictEmptyReferences() {
        boolean z;
        Iterator<Map.Entry<String, DeviceComponentWeakReference>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().get() == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                it.remove();
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        evictEmptyReferences();
        return this.cache.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.cache.keySet();
    }

    @Override // java.util.Map
    public final DeviceComponent put(String str, DeviceComponent deviceComponent) {
        DeviceComponent deviceComponent2 = deviceComponent;
        HashMap<String, DeviceComponentWeakReference> hashMap = this.cache;
        ((AnonymousClass1) this.deviceComponentReferenceProvider).getClass();
        hashMap.put(str, new DeviceComponentWeakReference(deviceComponent2));
        evictEmptyReferences();
        return deviceComponent2;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends DeviceComponent> map) {
        for (Map.Entry<? extends String, ? extends DeviceComponent> entry : map.entrySet()) {
            String key = entry.getKey();
            DeviceComponent value = entry.getValue();
            HashMap<String, DeviceComponentWeakReference> hashMap = this.cache;
            ((AnonymousClass1) this.deviceComponentReferenceProvider).getClass();
            hashMap.put(key, new DeviceComponentWeakReference(value));
            evictEmptyReferences();
        }
    }

    @Override // java.util.Map
    public final DeviceComponent remove(Object obj) {
        DeviceComponentWeakReference remove = this.cache.remove(obj);
        evictEmptyReferences();
        if (remove != null) {
            return remove.get();
        }
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        evictEmptyReferences();
        return this.cache.size();
    }

    @Override // java.util.Map
    public final Collection<DeviceComponent> values() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (DeviceComponentWeakReference deviceComponentWeakReference : this.cache.values()) {
            if (deviceComponentWeakReference.get() == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                arrayList.add(deviceComponentWeakReference.get());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public final DeviceComponent get(Object obj) {
        DeviceComponentWeakReference deviceComponentWeakReference = this.cache.get(obj);
        if (deviceComponentWeakReference != null) {
            return deviceComponentWeakReference.get();
        }
        return null;
    }
}

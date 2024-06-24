package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class DeviceComponentWeakReference extends WeakReference<DeviceComponent> {

    /* loaded from: classes3.dex */
    public interface Provider {
    }

    public DeviceComponentWeakReference(DeviceComponent deviceComponent) {
        super(deviceComponent);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WeakReference)) {
            return false;
        }
        DeviceComponent deviceComponent = get();
        Object obj2 = ((WeakReference) obj).get();
        if (deviceComponent == null || !(obj2 instanceof DeviceComponent) || !deviceComponent.provideDevice().equals(((DeviceComponent) obj2).provideDevice())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (get() != null) {
            return get().hashCode();
        }
        return 0;
    }
}

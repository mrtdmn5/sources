package com.amplifyframework.hub;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public final class HubEvent<T> {
    private final T data;
    private final String name;
    private final UUID uuid = UUID.randomUUID();

    /* loaded from: classes.dex */
    public interface Data<T> {
        HubEvent<T> toHubEvent();
    }

    private HubEvent(String str, T t) {
        this.name = str;
        this.data = t;
    }

    public static HubEvent<?> create(String str) {
        return new HubEvent<>(str, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HubEvent.class != obj.getClass()) {
            return false;
        }
        HubEvent hubEvent = (HubEvent) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.name, hubEvent.name) || !ObjectsCompat$Api19Impl.equals(this.data, hubEvent.data)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.uuid, hubEvent.uuid);
    }

    public T getData() {
        return this.data;
    }

    public UUID getId() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int r0;
        int r2;
        String str = this.name;
        int r1 = 0;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        T t = this.data;
        if (t != null) {
            r2 = t.hashCode();
        } else {
            r2 = 0;
        }
        int r03 = (r02 + r2) * 31;
        UUID r22 = this.uuid;
        if (r22 != null) {
            r1 = r22.hashCode();
        }
        return r03 + r1;
    }

    public String toString() {
        return "HubEvent{name='" + this.name + "', data=" + this.data + ", uuid=" + this.uuid + '}';
    }

    public static <E extends Enum<E>> HubEvent<?> create(E e) {
        Objects.requireNonNull(e);
        return new HubEvent<>(e.toString(), null);
    }

    public static <T> HubEvent<T> create(String str, T t) {
        return new HubEvent<>(str, t);
    }

    public static <T, E extends Enum<E>> HubEvent<T> create(E e, T t) {
        Objects.requireNonNull(e);
        Objects.requireNonNull(t);
        return new HubEvent<>(e.toString(), t);
    }
}

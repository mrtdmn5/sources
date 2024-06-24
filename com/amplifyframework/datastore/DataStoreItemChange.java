package com.amplifyframework.datastore;

import android.annotation.SuppressLint;
import com.amplifyframework.core.model.Model;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public final class DataStoreItemChange<T extends Model> {
    private final Initiator initiator;
    private final T item;
    private final Class<T> itemClass;
    private final Type type;
    private final UUID uuid;

    /* loaded from: classes.dex */
    public static final class Builder<T extends Model> {
        private Initiator initiator;
        private T item;
        private Class<T> itemClass;
        private Type type;
        private UUID uuid;

        @SuppressLint({"SyntheticAccessor"})
        public DataStoreItemChange<T> build() {
            UUID r0 = this.uuid;
            if (r0 == null) {
                r0 = UUID.randomUUID();
            }
            UUID r2 = r0;
            randomUuid();
            Objects.requireNonNull(r2);
            Type type = this.type;
            Objects.requireNonNull(type);
            T t = this.item;
            Objects.requireNonNull(t);
            Class<T> cls = this.itemClass;
            Objects.requireNonNull(cls);
            Initiator initiator = this.initiator;
            Objects.requireNonNull(initiator);
            return new DataStoreItemChange<>(r2, type, t, cls, initiator);
        }

        public Builder<T> initiator(Initiator initiator) {
            Objects.requireNonNull(initiator);
            this.initiator = initiator;
            return this;
        }

        public Builder<T> item(T t) {
            Objects.requireNonNull(t);
            this.item = t;
            return this;
        }

        public Builder<T> itemClass(Class<T> cls) {
            Objects.requireNonNull(cls);
            this.itemClass = cls;
            return this;
        }

        public Builder<T> randomUuid() {
            this.uuid = null;
            return this;
        }

        public Builder<T> type(Type type) {
            Objects.requireNonNull(type);
            this.type = type;
            return this;
        }

        public Builder<T> uuid(String str) {
            Objects.requireNonNull(str);
            this.uuid = UUID.fromString(str);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum Initiator {
        LOCAL,
        REMOTE
    }

    /* loaded from: classes.dex */
    public enum Type {
        CREATE,
        UPDATE,
        DELETE
    }

    public static <T extends Model> Builder<T> builder() {
        return new Builder<>();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DataStoreItemChange.class != obj.getClass()) {
            return false;
        }
        DataStoreItemChange dataStoreItemChange = (DataStoreItemChange) obj;
        if (this.uuid.equals(dataStoreItemChange.uuid) && this.type == dataStoreItemChange.type && this.item.equals(dataStoreItemChange.item) && this.itemClass.equals(dataStoreItemChange.itemClass) && this.initiator == dataStoreItemChange.initiator) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.initiator.hashCode() + ((this.itemClass.hashCode() + ((this.item.hashCode() + ((this.type.hashCode() + (this.uuid.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public Initiator initiator() {
        return this.initiator;
    }

    public T item() {
        return this.item;
    }

    public Class<T> itemClass() {
        return this.itemClass;
    }

    public String toString() {
        return "DataStoreItemChange{uuid=" + this.uuid + ", type=" + this.type + ", item=" + this.item + ", itemClass=" + this.itemClass + ", initiator=" + this.initiator + '}';
    }

    public Type type() {
        return this.type;
    }

    public UUID uuid() {
        return this.uuid;
    }

    private DataStoreItemChange(UUID r1, Type type, T t, Class<T> cls, Initiator initiator) {
        this.uuid = r1;
        this.type = type;
        this.item = t;
        this.itemClass = cls;
        this.initiator = initiator;
    }
}

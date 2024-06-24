package kotlinx.serialization.internal;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {
    public final SerialDescriptorImpl descriptor;

    /* compiled from: Tuples.kt */
    /* loaded from: classes4.dex */
    public static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
        public final K key;
        public final V value;

        public MapEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) obj;
            if (Intrinsics.areEqual(this.key, mapEntry.key) && Intrinsics.areEqual(this.value, mapEntry.value)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            int r0 = 0;
            K k = this.key;
            if (k == null) {
                hashCode = 0;
            } else {
                hashCode = k.hashCode();
            }
            int r1 = hashCode * 31;
            V v = this.value;
            if (v != null) {
                r0 = v.hashCode();
            }
            return r1 + r0;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final String toString() {
            return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
        }
    }

    public MapEntrySerializer(final KSerializer<K> kSerializer, final KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2);
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlin.collections.Map.Entry", StructureKind.MAP.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.MapEntrySerializer$descriptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                ClassSerialDescriptorBuilder buildSerialDescriptor = classSerialDescriptorBuilder;
                Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                SerialDescriptor descriptor = kSerializer.getDescriptor();
                EmptyList emptyList = EmptyList.INSTANCE;
                buildSerialDescriptor.element(TransferTable.COLUMN_KEY, descriptor, emptyList, false);
                buildSerialDescriptor.element("value", kSerializer2.getDescriptor(), emptyList, false);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object getKey(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object getValue(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object toResult(Object obj, Object obj2) {
        return new MapEntry(obj, obj2);
    }
}

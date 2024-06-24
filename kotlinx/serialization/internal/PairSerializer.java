package kotlinx.serialization.internal;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {
    public final SerialDescriptorImpl descriptor;

    public PairSerializer(final KSerializer<K> kSerializer, final KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Pair", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.PairSerializer$descriptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                ClassSerialDescriptorBuilder buildClassSerialDescriptor = classSerialDescriptorBuilder;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                SerialDescriptor descriptor = kSerializer.getDescriptor();
                EmptyList emptyList = EmptyList.INSTANCE;
                buildClassSerialDescriptor.element("first", descriptor, emptyList, false);
                buildClassSerialDescriptor.element("second", kSerializer2.getDescriptor(), emptyList, false);
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
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.first;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object getValue(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.second;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object toResult(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }
}

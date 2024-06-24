package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SealedSerializer.kt */
/* loaded from: classes4.dex */
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    public final List<? extends Annotation> _annotations;
    public final KClass<T> baseClass;
    public final Map<KClass<? extends T>, KSerializer<? extends T>> class2Serializer;
    public final Lazy descriptor$delegate;
    public final LinkedHashMap serialName2Serializer;

    public SealedClassSerializer(final String str, ClassReference classReference, KClass[] kClassArr, KSerializer[] kSerializerArr) {
        this.baseClass = classReference;
        this._annotations = EmptyList.INSTANCE;
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                final SealedClassSerializer<Object> sealedClassSerializer = this;
                Function1<ClassSerialDescriptorBuilder, Unit> function1 = new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                        ClassSerialDescriptorBuilder buildSerialDescriptor = classSerialDescriptorBuilder;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        PrimitiveSerialDescriptor primitiveSerialDescriptor = StringSerializer.descriptor;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        buildSerialDescriptor.element("type", primitiveSerialDescriptor, emptyList, false);
                        StringBuilder sb = new StringBuilder("kotlinx.serialization.Sealed<");
                        final SealedClassSerializer<Object> sealedClassSerializer2 = sealedClassSerializer;
                        sb.append(sealedClassSerializer2.baseClass.getSimpleName());
                        sb.append('>');
                        buildSerialDescriptor.element("value", SerialDescriptorsKt.buildSerialDescriptor(sb.toString(), SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
                                ClassSerialDescriptorBuilder buildSerialDescriptor2 = classSerialDescriptorBuilder2;
                                Intrinsics.checkNotNullParameter(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                for (Map.Entry entry : sealedClassSerializer2.serialName2Serializer.entrySet()) {
                                    buildSerialDescriptor2.element((String) entry.getKey(), ((KSerializer) entry.getValue()).getDescriptor(), EmptyList.INSTANCE, false);
                                }
                                return Unit.INSTANCE;
                            }
                        }), emptyList, false);
                        List<? extends Annotation> list = sealedClassSerializer2._annotations;
                        Intrinsics.checkNotNullParameter(list, "<set-?>");
                        buildSerialDescriptor.annotations = list;
                        return Unit.INSTANCE;
                    }
                };
                return SerialDescriptorsKt.buildSerialDescriptor(str, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], function1);
            }
        });
        if (kClassArr.length == kSerializerArr.length) {
            int min = Math.min(kClassArr.length, kSerializerArr.length);
            ArrayList arrayList = new ArrayList(min);
            for (int r0 = 0; r0 < min; r0++) {
                arrayList.add(new Pair(kClassArr[r0], kSerializerArr[r0]));
            }
            Map<KClass<? extends T>, KSerializer<? extends T>> map = MapsKt__MapsKt.toMap(arrayList);
            this.class2Serializer = map;
            Set<Map.Entry<KClass<? extends T>, KSerializer<? extends T>>> entrySet = map.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String serialName = ((KSerializer) entry.getValue()).getDescriptor().getSerialName();
                Object obj = linkedHashMap.get(serialName);
                if (obj == null) {
                    linkedHashMap.containsKey(serialName);
                }
                Map.Entry entry2 = (Map.Entry) obj;
                if (entry2 != null) {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + this.baseClass + "' have the same serial name '" + serialName + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
                linkedHashMap.put(serialName, entry);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.serialName2Serializer = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + classReference.getSimpleName() + " should be marked @Serializable");
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer kSerializer = (KSerializer) this.serialName2Serializer.get(str);
        return kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(decoder, str);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer<? extends T> kSerializer = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(value.getClass()));
        if (kSerializer == null) {
            kSerializer = super.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        return null;
    }

    public SealedClassSerializer(String str, ClassReference classReference, KClass[] kClassArr, KSerializer[] kSerializerArr, Annotation[] annotationArr) {
        this(str, classReference, kClassArr, kSerializerArr);
        this._annotations = ArraysKt___ArraysJvmKt.asList(annotationArr);
    }
}

package kotlinx.serialization.internal;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ObjectSerializer.kt */
/* loaded from: classes4.dex */
public final class ObjectSerializer<T> implements KSerializer<T> {
    public final List<? extends Annotation> _annotations;
    public final Lazy descriptor$delegate;
    public final T objectInstance;

    public ObjectSerializer(final String str, T objectInstance) {
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        this.objectInstance = objectInstance;
        this._annotations = EmptyList.INSTANCE;
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                final ObjectSerializer<T> objectSerializer = this;
                Function1<ClassSerialDescriptorBuilder, Unit> function1 = new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                        ClassSerialDescriptorBuilder buildSerialDescriptor = classSerialDescriptorBuilder;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        List<? extends Annotation> list = objectSerializer._annotations;
                        Intrinsics.checkNotNullParameter(list, "<set-?>");
                        buildSerialDescriptor.annotations = list;
                        return Unit.INSTANCE;
                    }
                };
                return SerialDescriptorsKt.buildSerialDescriptor(str, StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], function1);
            }
        });
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
        if (decodeElementIndex == -1) {
            Unit unit = Unit.INSTANCE;
            beginStructure.endStructure(descriptor);
            return this.objectInstance;
        }
        throw new SerializationException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unexpected index ", decodeElementIndex));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectSerializer(String str, T objectInstance, Annotation[] annotationArr) {
        this(str, objectInstance);
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        this._annotations = ArraysKt___ArraysJvmKt.asList(annotationArr);
    }
}

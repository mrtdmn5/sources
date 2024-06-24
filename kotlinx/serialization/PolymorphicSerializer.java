package kotlinx.serialization;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PolymorphicSerializer.kt */
/* loaded from: classes4.dex */
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {
    public final KClass<T> baseClass;
    public final EmptyList _annotations = EmptyList.INSTANCE;
    public final Lazy descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>(this) { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2
        public final /* synthetic */ PolymorphicSerializer<Object> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        public final SerialDescriptor invoke() {
            final PolymorphicSerializer<Object> polymorphicSerializer = this.this$0;
            SerialDescriptorImpl buildSerialDescriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    ClassSerialDescriptorBuilder buildSerialDescriptor2 = classSerialDescriptorBuilder;
                    Intrinsics.checkNotNullParameter(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                    PrimitiveSerialDescriptor primitiveSerialDescriptor = StringSerializer.descriptor;
                    EmptyList emptyList = EmptyList.INSTANCE;
                    buildSerialDescriptor2.element("type", primitiveSerialDescriptor, emptyList, false);
                    StringBuilder sb = new StringBuilder("kotlinx.serialization.Polymorphic<");
                    PolymorphicSerializer<Object> polymorphicSerializer2 = polymorphicSerializer;
                    sb.append(polymorphicSerializer2.baseClass.getSimpleName());
                    sb.append('>');
                    buildSerialDescriptor2.element("value", SerialDescriptorsKt.buildSerialDescriptor(sb.toString(), SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE), emptyList, false);
                    EmptyList emptyList2 = polymorphicSerializer2._annotations;
                    Intrinsics.checkNotNullParameter(emptyList2, "<set-?>");
                    buildSerialDescriptor2.annotations = emptyList2;
                    return Unit.INSTANCE;
                }
            });
            KClass<Object> context = polymorphicSerializer.baseClass;
            Intrinsics.checkNotNullParameter(context, "context");
            return new ContextDescriptor(buildSerialDescriptor, context);
        }
    });

    public PolymorphicSerializer(ClassReference classReference) {
        this.baseClass = classReference;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.baseClass + ')';
    }
}

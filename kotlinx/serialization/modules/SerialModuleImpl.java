package kotlinx.serialization.modules;

import com.google.common.hash.AbstractHasher;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.ContextualProvider;

/* compiled from: SerializersModule.kt */
/* loaded from: classes4.dex */
public final class SerialModuleImpl extends AbstractHasher {
    public final Map<KClass<?>, ContextualProvider> class2ContextualFactory;
    public final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider;
    public final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider;
    public final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;

    public SerialModuleImpl() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        this.class2ContextualFactory = emptyMap;
        this.polyBase2Serializers = emptyMap;
        this.polyBase2DefaultSerializerProvider = emptyMap;
        this.polyBase2NamedSerializers = emptyMap;
        this.polyBase2DefaultDeserializerProvider = emptyMap;
    }

    @Override // com.google.common.hash.AbstractHasher
    public final void dumpTo(PolymorphismValidator polymorphismValidator) {
        for (Map.Entry<KClass<?>, ContextualProvider> entry : this.class2ContextualFactory.entrySet()) {
            KClass<?> key = entry.getKey();
            ContextualProvider value = entry.getValue();
            if (!(value instanceof ContextualProvider.Argless)) {
                if (value instanceof ContextualProvider.WithTypeArguments) {
                    ((ContextualProvider.WithTypeArguments) value).getClass();
                    polymorphismValidator.contextual(key, null);
                }
            } else {
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                ((ContextualProvider.Argless) value).getClass();
                Intrinsics.checkNotNull(null, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                throw null;
            }
        }
        for (Map.Entry<KClass<?>, Map<KClass<?>, KSerializer<?>>> entry2 : this.polyBase2Serializers.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                KClass<?> key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                polymorphismValidator.polymorphic(key2, key3, value2);
            }
        }
        for (Map.Entry<KClass<?>, Function1<?, SerializationStrategy<?>>> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            KClass<?> key4 = entry4.getKey();
            Function1<?, SerializationStrategy<?>> value3 = entry4.getValue();
            Intrinsics.checkNotNull(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, value3);
        }
        for (Map.Entry<KClass<?>, Function1<String, DeserializationStrategy<?>>> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            KClass<?> key5 = entry5.getKey();
            Function1<String, DeserializationStrategy<?>> value4 = entry5.getValue();
            Intrinsics.checkNotNull(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, value4);
        }
    }

    @Override // com.google.common.hash.AbstractHasher
    public final <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        KSerializer<?> kSerializer;
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        if (contextualProvider != null) {
            kSerializer = contextualProvider.invoke(typeArgumentsSerializers);
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof KSerializer)) {
            return null;
        }
        return (KSerializer<T>) kSerializer;
    }

    @Override // com.google.common.hash.AbstractHasher
    public final SerializationStrategy getPolymorphic(Object value, KClass baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!baseClass.isInstance(value)) {
            return null;
        }
        Map<KClass<?>, KSerializer<?>> map = this.polyBase2Serializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(Reflection.getOrCreateKotlinClass(value.getClass())) : null;
        if (!(kSerializer instanceof SerializationStrategy)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<?, SerializationStrategy<?>> function1 = this.polyBase2DefaultSerializerProvider.get(baseClass);
        Function1<?, SerializationStrategy<?>> function12 = TypeIntrinsics.isFunctionOfArity(1, function1) ? function1 : null;
        if (function12 != null) {
            return function12.invoke(value);
        }
        return null;
    }

    @Override // com.google.common.hash.AbstractHasher
    public final DeserializationStrategy getPolymorphic(String str, KClass baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.polyBase2NamedSerializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(str) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function1 = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        Function1<String, DeserializationStrategy<?>> function12 = TypeIntrinsics.isFunctionOfArity(1, function1) ? function1 : null;
        if (function12 != null) {
            return function12.invoke(str);
        }
        return null;
    }
}

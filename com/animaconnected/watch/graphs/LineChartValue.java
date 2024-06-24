package com.animaconnected.watch.graphs;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public abstract class LineChartValue {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.graphs.LineChartValue.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.animaconnected.watch.graphs.LineChartValue", Reflection.getOrCreateKotlinClass(LineChartValue.class), new KClass[]{Reflection.getOrCreateKotlinClass(Known.class), Reflection.getOrCreateKotlinClass(None.class), Reflection.getOrCreateKotlinClass(Unknown.class)}, new KSerializer[]{Known$$serializer.INSTANCE, new ObjectSerializer("com.animaconnected.watch.graphs.None", None.INSTANCE, new Annotation[0]), new ObjectSerializer("com.animaconnected.watch.graphs.Unknown", Unknown.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }
    });

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) LineChartValue.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LineChartValue> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    public /* synthetic */ LineChartValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LineChartValue() {
    }

    public /* synthetic */ LineChartValue(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ void write$Self(LineChartValue lineChartValue, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}

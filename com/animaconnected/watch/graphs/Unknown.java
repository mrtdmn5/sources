package com.animaconnected.watch.graphs;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Unknown extends LineChartValue {
    public static final Unknown INSTANCE = new Unknown();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.graphs.Unknown.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new ObjectSerializer("com.animaconnected.watch.graphs.Unknown", Unknown.INSTANCE, new Annotation[0]);
        }
    });

    private Unknown() {
        super(null);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return $cachedSerializer$delegate.getValue();
    }

    public final KSerializer<Unknown> serializer() {
        return get$cachedSerializer();
    }
}

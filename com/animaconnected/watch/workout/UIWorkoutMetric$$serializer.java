package com.animaconnected.watch.workout;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.provider.preferences.WorkoutMetrics;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ConfigureMetricViewModel.kt */
/* loaded from: classes3.dex */
public final class UIWorkoutMetric$$serializer implements GeneratedSerializer<UIWorkoutMetric> {
    public static final UIWorkoutMetric$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UIWorkoutMetric$$serializer uIWorkoutMetric$$serializer = new UIWorkoutMetric$$serializer();
        INSTANCE = uIWorkoutMetric$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.workout.UIWorkoutMetric", uIWorkoutMetric$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("metric", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UIWorkoutMetric$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = UIWorkoutMetric.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[1])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UIWorkoutMetric deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = UIWorkoutMetric.$childSerializers;
        beginStructure.decodeSequentially();
        boolean z = true;
        int r8 = 0;
        WorkoutMetrics workoutMetrics = null;
        String str = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r8 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                workoutMetrics = (WorkoutMetrics) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], workoutMetrics);
                r8 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new UIWorkoutMetric(r8, str, workoutMetrics, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UIWorkoutMetric value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        UIWorkoutMetric.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}

package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorConverters.kt */
/* loaded from: classes.dex */
public final class TwoWayConverterImpl<T, V extends AnimationVector> implements TwoWayConverter<T, V> {
    public final Function1<V, T> convertFromVector;
    public final Function1<T, V> convertToVector;

    /* JADX WARN: Multi-variable type inference failed */
    public TwoWayConverterImpl(Function1<? super T, ? extends V> convertToVector, Function1<? super V, ? extends T> convertFromVector) {
        Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
        Intrinsics.checkNotNullParameter(convertFromVector, "convertFromVector");
        this.convertToVector = convertToVector;
        this.convertFromVector = convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public final Function1<V, T> getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public final Function1<T, V> getConvertToVector() {
        return this.convertToVector;
    }
}

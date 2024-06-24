package androidx.compose.runtime;

/* compiled from: SnapshotFloatState.kt */
/* loaded from: classes.dex */
public interface MutableFloatState extends State, MutableState<Float> {
    float getFloatValue();

    void setFloatValue(float f);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Float f) {
        setValue(f.floatValue());
    }

    @Override // androidx.compose.runtime.State
    default Float getValue() {
        return Float.valueOf(getFloatValue());
    }

    default void setValue(float f) {
        setFloatValue(f);
    }
}

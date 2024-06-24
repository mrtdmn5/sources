package androidx.compose.runtime;

/* compiled from: SnapshotIntState.kt */
/* loaded from: classes.dex */
public interface MutableIntState extends State, MutableState<Integer> {
    int getIntValue();

    void setIntValue(int r1);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Integer num) {
        setValue(num.intValue());
    }

    @Override // androidx.compose.runtime.State
    default Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    default void setValue(int r1) {
        setIntValue(r1);
    }
}

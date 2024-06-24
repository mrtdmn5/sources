package androidx.compose.runtime;

/* compiled from: SnapshotLongState.kt */
/* loaded from: classes.dex */
public interface MutableLongState extends State, MutableState<Long> {
    long getLongValue();

    void setLongValue(long j);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Long l) {
        setValue(l.longValue());
    }

    @Override // androidx.compose.runtime.State
    default Long getValue() {
        return Long.valueOf(getLongValue());
    }

    default void setValue(long j) {
        setLongValue(j);
    }
}

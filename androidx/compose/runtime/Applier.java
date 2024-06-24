package androidx.compose.runtime;

/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public interface Applier<N> {
    void clear();

    void down(N n);

    N getCurrent();

    void insertBottomUp(int r1, N n);

    void insertTopDown(int r1, N n);

    void move(int r1, int r2, int r3);

    void remove(int r1, int r2);

    void up();

    default void onEndChanges() {
    }
}

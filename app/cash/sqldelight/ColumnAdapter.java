package app.cash.sqldelight;

/* compiled from: ColumnAdapter.kt */
/* loaded from: classes.dex */
public interface ColumnAdapter<T, S> {
    T decode(S s);

    S encode(T t);
}

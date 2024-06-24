package app.cash.sqldelight.adapter.primitive;

import app.cash.sqldelight.ColumnAdapter;

/* compiled from: FloatColumnAdapter.kt */
/* loaded from: classes.dex */
public final class FloatColumnAdapter implements ColumnAdapter<Float, Double> {
    public static final FloatColumnAdapter INSTANCE = new FloatColumnAdapter();

    @Override // app.cash.sqldelight.ColumnAdapter
    public final Float decode(Double d) {
        return Float.valueOf((float) d.doubleValue());
    }

    @Override // app.cash.sqldelight.ColumnAdapter
    public final Double encode(Float f) {
        return Double.valueOf(f.floatValue());
    }
}

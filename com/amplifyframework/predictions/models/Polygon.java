package com.amplifyframework.predictions.models;

import android.graphics.PointF;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Polygon {
    private static final int MINIMUM_POINTS_REQUIRED = 3;
    private final List<PointF> points;

    private Polygon(List<PointF> list) {
        this.points = list;
    }

    public static Polygon fromPoints(List<PointF> list) {
        Objects.requireNonNull(list);
        if (list.size() >= 3) {
            return new Polygon(list);
        }
        throw new IllegalArgumentException("A polygon must contain at least three points.");
    }

    public List<PointF> getPoints() {
        return Immutable.of(this.points);
    }
}

package com.amplifyframework.predictions.models;

import android.graphics.PointF;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Landmark {
    private final List<PointF> points;
    private final LandmarkType type;

    public Landmark(LandmarkType landmarkType, List<PointF> list) {
        Objects.requireNonNull(landmarkType);
        this.type = landmarkType;
        Objects.requireNonNull(list);
        this.points = list;
    }

    public List<PointF> getPoints() {
        return Immutable.of(this.points);
    }

    public LandmarkType getType() {
        return this.type;
    }
}

package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public abstract class ImageFeature<T> extends Feature<T> {
    private final RectF box;
    private final Polygon polygon;

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder<B, R, T>, R extends ImageFeature<T>, T> extends Feature.Builder<B, R, T> {
        private RectF box;
        private Polygon polygon;

        public B box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public RectF getBox() {
            return this.box;
        }

        public Polygon getPolygon() {
            return this.polygon;
        }

        public B polygon(Polygon polygon) {
            this.polygon = polygon;
            return this;
        }
    }

    public ImageFeature(Builder<?, ? extends ImageFeature<T>, T> builder) {
        super(builder);
        this.box = builder.getBox();
        this.polygon = builder.getPolygon();
    }

    public RectF getBox() {
        return this.box;
    }

    public Polygon getPolygon() {
        return this.polygon;
    }
}

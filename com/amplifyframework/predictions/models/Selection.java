package com.amplifyframework.predictions.models;

import android.graphics.RectF;

/* loaded from: classes.dex */
public final class Selection {
    private final RectF box;
    private final Polygon polygon;
    private final boolean selected;

    /* loaded from: classes.dex */
    public static final class Builder {
        private RectF box;
        private Polygon polygon;
        private boolean selected;

        public Builder box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public Selection build() {
            return new Selection(this.box, this.polygon, this.selected);
        }

        public RectF getBox() {
            return this.box;
        }

        public Polygon getPolygon() {
            return this.polygon;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public Builder polygon(Polygon polygon) {
            this.polygon = polygon;
            return this;
        }

        public Builder selected(boolean z) {
            this.selected = z;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public RectF getBox() {
        return this.box;
    }

    public Polygon getPolygon() {
        return this.polygon;
    }

    public boolean isSelected() {
        return this.selected;
    }

    private Selection(RectF rectF, Polygon polygon, boolean z) {
        this.box = rectF;
        this.polygon = polygon;
        this.selected = z;
    }
}

package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.ImageFeature;

/* loaded from: classes.dex */
public final class Cell extends ImageFeature<String> {
    private final int column;
    private final int row;
    private final boolean selected;

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, Cell, String> {
        private int column;
        private int row;
        private boolean selected;

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Cell$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        public Builder column(int r1) {
            this.column = r1;
            return this;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }

        public boolean getSelected() {
            return this.selected;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Cell$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        public Builder row(int r1) {
            this.row = r1;
            return this;
        }

        public Builder selected(boolean z) {
            this.selected = z;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder text(String str) {
            return (Builder) value(str);
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Cell build() {
            return new Cell(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public String getText() {
        return getValue();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.CELL.getAlias();
    }

    public boolean isSelected() {
        return this.selected;
    }

    private Cell(Builder builder) {
        super(builder);
        this.selected = builder.getSelected();
        this.row = builder.getRow();
        this.column = builder.getColumn();
    }
}

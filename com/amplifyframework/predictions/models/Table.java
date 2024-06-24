package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.ImageFeature;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Table extends ImageFeature<List<Cell>> {
    private final int columnSize;
    private final int rowSize;

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, Table, List<Cell>> {
        private List<Cell> cells;
        private int columnSize;
        private int rowSize;

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Table$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder cells(List<Cell> list) {
            return (Builder) value(list);
        }

        public Builder columnSize(int r1) {
            this.columnSize = r1;
            return this;
        }

        public List<Cell> getCells() {
            List<Cell> list = this.cells;
            Objects.requireNonNull(list);
            return list;
        }

        public int getColumnSize() {
            return this.columnSize;
        }

        public int getRowSize() {
            return this.rowSize;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Table$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        public Builder rowSize(int r1) {
            this.rowSize = r1;
            return this;
        }

        private Builder() {
            this.cells = Collections.emptyList();
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Table build() {
            return new Table(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Cell> getCells() {
        return getValue();
    }

    public int getColumnSize() {
        return this.columnSize;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.TABLE.getAlias();
    }

    private Table(Builder builder) {
        super(builder);
        this.rowSize = builder.getRowSize();
        this.columnSize = builder.getColumnSize();
    }
}

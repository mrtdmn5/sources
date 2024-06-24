package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.ImageFeature;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Label extends ImageFeature<String> {
    public static final String FEATURE_TYPE = "Label";
    private final List<RectF> boxes;
    private final List<String> parentLabels;

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, Label, String> {
        private List<RectF> boxes;
        private List<String> parentLabels;

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Label$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        public Builder boxes(List<RectF> list) {
            Objects.requireNonNull(list);
            this.boxes = list;
            return this;
        }

        public List<RectF> getBoxes() {
            List<RectF> of = Immutable.of(this.boxes);
            Objects.requireNonNull(of);
            return of;
        }

        public List<String> getParentLabels() {
            List<String> of = Immutable.of(this.parentLabels);
            Objects.requireNonNull(of);
            return of;
        }

        public Builder name(String str) {
            return (Builder) super.value(str);
        }

        public Builder parentLabels(List<String> list) {
            Objects.requireNonNull(list);
            this.parentLabels = list;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.Label$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        private Builder() {
            this.parentLabels = new ArrayList();
            this.boxes = new ArrayList();
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Label build() {
            return new Label(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<RectF> getBoxes() {
        return this.boxes;
    }

    public String getName() {
        return getValue();
    }

    public List<String> getParentLabels() {
        return this.parentLabels;
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FEATURE_TYPE;
    }

    private Label(Builder builder) {
        super(builder);
        this.parentLabels = builder.getParentLabels();
        this.boxes = builder.getBoxes();
    }
}

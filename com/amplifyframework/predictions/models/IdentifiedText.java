package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.ImageFeature;
import java.util.Objects;

/* loaded from: classes.dex */
public final class IdentifiedText extends ImageFeature<String> {
    private final int page;

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, IdentifiedText, String> {
        private int page;

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.IdentifiedText$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        public int getPage() {
            return this.page;
        }

        public Builder page(int r1) {
            this.page = r1;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.IdentifiedText$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        public Builder text(String str) {
            Objects.requireNonNull(str);
            return (Builder) super.value(str);
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public IdentifiedText build() {
            return new IdentifiedText(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getPage() {
        return this.page;
    }

    public String getText() {
        return getValue();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.IDENTIFIED_TEXT.getAlias();
    }

    private IdentifiedText(Builder builder) {
        super(builder);
        this.page = builder.getPage();
    }
}

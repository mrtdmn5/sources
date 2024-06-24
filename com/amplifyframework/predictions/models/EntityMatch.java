package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.ImageFeature;
import java.util.Objects;

/* loaded from: classes.dex */
public final class EntityMatch extends ImageFeature<String> {

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, EntityMatch, String> {
        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.EntityMatch$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder externalImageId(String str) {
            Objects.requireNonNull(str);
            return (Builder) value(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.EntityMatch$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public EntityMatch build() {
            return new EntityMatch(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getExternalImageId() {
        return getValue();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.ENTITY_MATCH.getAlias();
    }

    private EntityMatch(Builder builder) {
        super(builder);
    }
}

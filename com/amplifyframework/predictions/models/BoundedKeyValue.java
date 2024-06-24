package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import androidx.core.util.Pair;
import com.amplifyframework.predictions.models.ImageFeature;
import java.util.Objects;

/* loaded from: classes.dex */
public final class BoundedKeyValue extends ImageFeature<Pair<String, String>> {

    /* loaded from: classes.dex */
    public static final class Builder extends ImageFeature.Builder<Builder, BoundedKeyValue, Pair<String, String>> {
        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.BoundedKeyValue$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder box(RectF rectF) {
            return super.box(rectF);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder keyValuePair(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            return (Builder) value(new Pair(str, str2));
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.amplifyframework.predictions.models.BoundedKeyValue$Builder, com.amplifyframework.predictions.models.ImageFeature$Builder] */
        @Override // com.amplifyframework.predictions.models.ImageFeature.Builder
        public /* bridge */ /* synthetic */ Builder polygon(Polygon polygon) {
            return super.polygon(polygon);
        }

        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public BoundedKeyValue build() {
            Objects.requireNonNull(getValue());
            Objects.requireNonNull(getValue().first);
            Objects.requireNonNull(getValue().second);
            return new BoundedKeyValue(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getKey() {
        return getValue().first;
    }

    public String getKeyValue() {
        return getValue().second;
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.BOUNDED_KEY_VALUE.getAlias();
    }

    private BoundedKeyValue(Builder builder) {
        super(builder);
    }
}

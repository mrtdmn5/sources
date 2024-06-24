package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public final class Celebrity extends Feature<String> {

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, Celebrity, String> {
        public Builder name(String str) {
            return (Builder) super.value(str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Celebrity build() {
            return new Celebrity(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return getValue();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.CELEBRITY.getAlias();
    }

    private Celebrity(Builder builder) {
        super(builder);
    }
}

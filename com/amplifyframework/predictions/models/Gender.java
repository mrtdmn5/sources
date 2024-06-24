package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public final class Gender extends Feature<GenderBinaryType> {

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, Gender, GenderBinaryType> {
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Gender build() {
            return new Gender(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.GENDER.getAlias();
    }

    private Gender(Builder builder) {
        super(builder);
    }
}

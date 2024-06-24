package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public final class Language extends Feature<LanguageType> {

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, Language, LanguageType> {
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Language build() {
            return new Language(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.LANGUAGE.getAlias();
    }

    private Language(Builder builder) {
        super(builder);
    }
}

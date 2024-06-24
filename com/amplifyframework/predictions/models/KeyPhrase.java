package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.TextFeature;

/* loaded from: classes.dex */
public final class KeyPhrase extends TextFeature<String> {

    /* loaded from: classes.dex */
    public static final class Builder extends TextFeature.Builder<Builder, KeyPhrase, String> {
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public KeyPhrase build() {
            return new KeyPhrase(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.KEY_PHRASE.getAlias();
    }

    private KeyPhrase(Builder builder) {
        super(builder);
    }
}

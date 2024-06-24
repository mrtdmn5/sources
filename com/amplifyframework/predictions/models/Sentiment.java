package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public final class Sentiment extends Feature<SentimentType> {

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, Sentiment, SentimentType> {
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Sentiment build() {
            return new Sentiment(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.SENTIMENT.getAlias();
    }

    private Sentiment(Builder builder) {
        super(builder);
    }
}

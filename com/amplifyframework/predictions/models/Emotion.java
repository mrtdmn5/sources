package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: classes.dex */
public final class Emotion extends Feature<EmotionType> {

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, Emotion, EmotionType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Emotion build() {
            return new Emotion(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.EMOTION.getAlias();
    }

    private Emotion(Builder builder) {
        super(builder);
    }
}

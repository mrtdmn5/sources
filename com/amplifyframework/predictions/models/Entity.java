package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.TextFeature;

/* loaded from: classes.dex */
public final class Entity extends TextFeature<EntityType> {

    /* loaded from: classes.dex */
    public static final class Builder extends TextFeature.Builder<Builder, Entity, EntityType> {
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public Entity build() {
            return new Entity(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return FeatureType.ENTITY.getAlias();
    }

    private Entity(Builder builder) {
        super(builder);
    }
}

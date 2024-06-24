package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;
import java.util.Objects;

/* loaded from: classes.dex */
public final class BinaryFeature extends Feature<Boolean> {
    private final String type;

    /* loaded from: classes.dex */
    public static final class Builder extends Feature.Builder<Builder, BinaryFeature, Boolean> {
        private String type;

        public String getType() {
            String str = this.type;
            Objects.requireNonNull(str);
            return str;
        }

        public Builder type(String str) {
            Objects.requireNonNull(str);
            this.type = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.predictions.models.Feature.Builder
        public BinaryFeature build() {
            return new BinaryFeature(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.amplifyframework.predictions.models.Feature
    public String getTypeAlias() {
        return this.type;
    }

    private BinaryFeature(Builder builder) {
        super(builder);
        this.type = builder.getType();
    }
}

package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.Entity;
import com.amplifyframework.predictions.models.Feature;
import com.amplifyframework.predictions.models.KeyPhrase;
import com.amplifyframework.predictions.models.Language;
import com.amplifyframework.predictions.models.Sentiment;
import com.amplifyframework.predictions.models.Syntax;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class InterpretResult {
    private final List<Entity> entities;
    private final List<Feature<?>> features;
    private final List<KeyPhrase> keyPhrases;
    private final Language language;
    private final Sentiment sentiment;
    private final List<Syntax> syntax;

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<Entity> entities;
        private List<Feature<?>> features;
        private List<KeyPhrase> keyPhrases;
        private Language language;
        private Sentiment sentiment;
        private List<Syntax> syntax;

        public InterpretResult build() {
            return new InterpretResult(this);
        }

        public Builder entities(List<Entity> list) {
            this.entities = list;
            return this;
        }

        public Builder feature(Feature<?> feature) {
            List<Feature<?>> list = this.features;
            Objects.requireNonNull(feature);
            list.add(feature);
            return this;
        }

        public Builder features(List<Feature<?>> list) {
            Objects.requireNonNull(list);
            this.features = list;
            return this;
        }

        public List<Entity> getEntities() {
            return this.entities;
        }

        public List<Feature<?>> getFeatures() {
            return this.features;
        }

        public List<KeyPhrase> getKeyPhrases() {
            return this.keyPhrases;
        }

        public Language getLanguage() {
            return this.language;
        }

        public Sentiment getSentiment() {
            return this.sentiment;
        }

        public List<Syntax> getSyntax() {
            return this.syntax;
        }

        public Builder keyPhrases(List<KeyPhrase> list) {
            this.keyPhrases = list;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder sentiment(Sentiment sentiment) {
            this.sentiment = sentiment;
            return this;
        }

        public Builder syntax(List<Syntax> list) {
            this.syntax = list;
            return this;
        }

        private Builder() {
            this.features = new ArrayList();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Entity> getEntities() {
        return Immutable.of(this.entities);
    }

    public List<Feature<?>> getFeatures() {
        return Immutable.of(this.features);
    }

    public List<KeyPhrase> getKeyPhrases() {
        return Immutable.of(this.keyPhrases);
    }

    public Language getLanguage() {
        return this.language;
    }

    public Sentiment getSentiment() {
        return this.sentiment;
    }

    public List<Syntax> getSyntax() {
        return Immutable.of(this.syntax);
    }

    private InterpretResult(Builder builder) {
        this.language = builder.getLanguage();
        this.sentiment = builder.getSentiment();
        this.keyPhrases = builder.getKeyPhrases();
        this.entities = builder.getEntities();
        this.syntax = builder.getSyntax();
        this.features = builder.getFeatures();
    }
}

package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class TextFeature<T> extends Feature<T> {
    private final int length;
    private final int startIndex;
    private final String targetText;

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder<B, R, T>, R extends TextFeature<T>, T> extends Feature.Builder<B, R, T> {
        private int startIndex;
        private String targetText;

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getTargetText() {
            String str = this.targetText;
            Objects.requireNonNull(str);
            return str;
        }

        public final B startIndex(int r1) {
            this.startIndex = r1;
            return this;
        }

        public final B targetText(String str) {
            Objects.requireNonNull(str);
            this.targetText = str;
            return this;
        }
    }

    public TextFeature(Builder<?, ? extends TextFeature<T>, T> builder) {
        super(builder);
        String targetText = builder.getTargetText();
        this.targetText = targetText;
        this.startIndex = builder.getStartIndex();
        this.length = targetText.length();
    }

    public int getLength() {
        return this.length;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public final String getTargetText() {
        return this.targetText;
    }
}

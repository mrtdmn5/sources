package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.IdentifiedText;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class IdentifyTextResult implements IdentifyResult {
    private final String fullText;
    private final List<IdentifiedText> lines;
    private final List<String> rawLineText;
    private final List<IdentifiedText> words;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String fullText;
        private List<IdentifiedText> lines;
        private List<String> rawLineText;
        private List<IdentifiedText> words;

        public IdentifyTextResult build() {
            return new IdentifyTextResult(this);
        }

        public Builder fullText(String str) {
            Objects.requireNonNull(str);
            this.fullText = str;
            return this;
        }

        public String getFullText() {
            String str = this.fullText;
            Objects.requireNonNull(str);
            return str;
        }

        public List<IdentifiedText> getLines() {
            List<IdentifiedText> list = this.lines;
            Objects.requireNonNull(list);
            return list;
        }

        public List<String> getRawLineText() {
            List<String> list = this.rawLineText;
            Objects.requireNonNull(list);
            return list;
        }

        public List<IdentifiedText> getWords() {
            List<IdentifiedText> list = this.words;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder lines(List<IdentifiedText> list) {
            Objects.requireNonNull(list);
            this.lines = list;
            return this;
        }

        public Builder rawLineText(List<String> list) {
            Objects.requireNonNull(list);
            this.rawLineText = list;
            return this;
        }

        public Builder words(List<IdentifiedText> list) {
            Objects.requireNonNull(list);
            this.words = list;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFullText() {
        return this.fullText;
    }

    public List<IdentifiedText> getLines() {
        return Immutable.of(this.lines);
    }

    public List<String> getRawLineText() {
        return Immutable.of(this.rawLineText);
    }

    public List<IdentifiedText> getWords() {
        return Immutable.of(this.words);
    }

    private IdentifyTextResult(Builder builder) {
        this.fullText = builder.getFullText();
        this.rawLineText = builder.getRawLineText();
        this.words = builder.getWords();
        this.lines = builder.getLines();
    }
}

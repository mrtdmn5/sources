package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.BoundedKeyValue;
import com.amplifyframework.predictions.models.IdentifiedText;
import com.amplifyframework.predictions.models.Selection;
import com.amplifyframework.predictions.models.Table;
import com.amplifyframework.util.Immutable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class IdentifyDocumentTextResult implements IdentifyResult {
    private final String fullText;
    private final List<BoundedKeyValue> keyValues;
    private final List<IdentifiedText> lines;
    private final List<String> rawLineText;
    private final List<Selection> selections;
    private final List<Table> tables;
    private final List<IdentifiedText> words;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String fullText;
        private List<BoundedKeyValue> keyValues;
        private List<IdentifiedText> lines;
        private List<String> rawLineText;
        private List<Selection> selections;
        private List<Table> tables;
        private List<IdentifiedText> words;

        public IdentifyDocumentTextResult build() {
            return new IdentifyDocumentTextResult(this);
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

        public List<BoundedKeyValue> getKeyValues() {
            List<BoundedKeyValue> list = this.keyValues;
            Objects.requireNonNull(list);
            return list;
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

        public List<Selection> getSelections() {
            List<Selection> list = this.selections;
            Objects.requireNonNull(list);
            return list;
        }

        public List<Table> getTables() {
            List<Table> list = this.tables;
            Objects.requireNonNull(list);
            return list;
        }

        public List<IdentifiedText> getWords() {
            List<IdentifiedText> list = this.words;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder keyValues(List<BoundedKeyValue> list) {
            Objects.requireNonNull(list);
            this.keyValues = list;
            return this;
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

        public Builder selections(List<Selection> list) {
            Objects.requireNonNull(list);
            this.selections = list;
            return this;
        }

        public Builder tables(List<Table> list) {
            Objects.requireNonNull(list);
            this.tables = list;
            return this;
        }

        public Builder words(List<IdentifiedText> list) {
            Objects.requireNonNull(list);
            this.words = list;
            return this;
        }

        private Builder() {
            this.rawLineText = Collections.emptyList();
            this.words = Collections.emptyList();
            this.lines = Collections.emptyList();
            this.selections = Collections.emptyList();
            this.tables = Collections.emptyList();
            this.keyValues = Collections.emptyList();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFullText() {
        return this.fullText;
    }

    public List<BoundedKeyValue> getKeyValues() {
        return Immutable.of(this.keyValues);
    }

    public List<IdentifiedText> getLines() {
        return Immutable.of(this.lines);
    }

    public List<String> getRawLineText() {
        return Immutable.of(this.rawLineText);
    }

    public List<Selection> getSelections() {
        return Immutable.of(this.selections);
    }

    public List<Table> getTables() {
        return Immutable.of(this.tables);
    }

    public List<IdentifiedText> getWords() {
        return Immutable.of(this.words);
    }

    private IdentifyDocumentTextResult(Builder builder) {
        this.fullText = builder.getFullText();
        this.rawLineText = builder.getRawLineText();
        this.words = builder.getWords();
        this.lines = builder.getLines();
        this.selections = builder.getSelections();
        this.tables = builder.getTables();
        this.keyValues = builder.getKeyValues();
    }
}

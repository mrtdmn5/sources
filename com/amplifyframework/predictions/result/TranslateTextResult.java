package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.LanguageType;
import java.util.Objects;

/* loaded from: classes.dex */
public final class TranslateTextResult {
    private final LanguageType targetLanguage;
    private final String translatedText;

    /* loaded from: classes.dex */
    public static final class Builder {
        private LanguageType targetLanguage;
        private String translatedText;

        public TranslateTextResult build() {
            return new TranslateTextResult(this);
        }

        public LanguageType getTargetLanguage() {
            LanguageType languageType = this.targetLanguage;
            Objects.requireNonNull(languageType);
            return languageType;
        }

        public String getTranslatedText() {
            String str = this.translatedText;
            Objects.requireNonNull(str);
            return str;
        }

        public Builder targetLanguage(LanguageType languageType) {
            Objects.requireNonNull(languageType);
            this.targetLanguage = languageType;
            return this;
        }

        public Builder translatedText(String str) {
            Objects.requireNonNull(str);
            this.translatedText = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public LanguageType getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getTranslatedText() {
        return this.translatedText;
    }

    private TranslateTextResult(Builder builder) {
        this.translatedText = builder.getTranslatedText();
        this.targetLanguage = builder.getTargetLanguage();
    }
}

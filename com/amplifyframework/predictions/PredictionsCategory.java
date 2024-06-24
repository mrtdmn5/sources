package com.amplifyframework.predictions;

import android.graphics.Bitmap;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.predictions.models.IdentifyAction;
import com.amplifyframework.predictions.models.LanguageType;
import com.amplifyframework.predictions.operation.IdentifyOperation;
import com.amplifyframework.predictions.operation.InterpretOperation;
import com.amplifyframework.predictions.operation.TextToSpeechOperation;
import com.amplifyframework.predictions.operation.TranslateTextOperation;
import com.amplifyframework.predictions.options.IdentifyOptions;
import com.amplifyframework.predictions.options.InterpretOptions;
import com.amplifyframework.predictions.options.TextToSpeechOptions;
import com.amplifyframework.predictions.options.TranslateTextOptions;
import com.amplifyframework.predictions.result.IdentifyResult;
import com.amplifyframework.predictions.result.InterpretResult;
import com.amplifyframework.predictions.result.TextToSpeechResult;
import com.amplifyframework.predictions.result.TranslateTextResult;

/* loaded from: classes.dex */
public final class PredictionsCategory extends Category<PredictionsPlugin<?>> implements PredictionsCategoryBehavior {
    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TextToSpeechOperation<?> convertTextToSpeech(String str, Consumer<TextToSpeechResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().convertTextToSpeech(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.PREDICTIONS;
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public IdentifyOperation<?> identify(IdentifyAction identifyAction, Bitmap bitmap, Consumer<IdentifyResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().identify(identifyAction, bitmap, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public InterpretOperation<?> interpret(String str, Consumer<InterpretResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().interpret(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TranslateTextOperation<?> translateText(String str, Consumer<TranslateTextResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().translateText(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TextToSpeechOperation<?> convertTextToSpeech(String str, TextToSpeechOptions textToSpeechOptions, Consumer<TextToSpeechResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().convertTextToSpeech(str, textToSpeechOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public IdentifyOperation<?> identify(IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Consumer<IdentifyResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().identify(identifyAction, bitmap, identifyOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public InterpretOperation<?> interpret(String str, InterpretOptions interpretOptions, Consumer<InterpretResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().interpret(str, interpretOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TranslateTextOperation<?> translateText(String str, TranslateTextOptions translateTextOptions, Consumer<TranslateTextResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().translateText(str, translateTextOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TranslateTextOperation<?> translateText(String str, LanguageType languageType, LanguageType languageType2, Consumer<TranslateTextResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().translateText(str, languageType, languageType2, consumer, consumer2);
    }

    @Override // com.amplifyframework.predictions.PredictionsCategoryBehavior
    public TranslateTextOperation<?> translateText(String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Consumer<TranslateTextResult> consumer, Consumer<PredictionsException> consumer2) {
        return getSelectedPlugin().translateText(str, languageType, languageType2, translateTextOptions, consumer, consumer2);
    }
}

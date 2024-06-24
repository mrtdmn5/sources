package com.amplifyframework.kotlin.predictions;

import android.graphics.Bitmap;
import com.amplifyframework.predictions.PredictionsException;
import com.amplifyframework.predictions.models.IdentifyAction;
import com.amplifyframework.predictions.models.LanguageType;
import com.amplifyframework.predictions.options.IdentifyOptions;
import com.amplifyframework.predictions.options.InterpretOptions;
import com.amplifyframework.predictions.options.TextToSpeechOptions;
import com.amplifyframework.predictions.options.TranslateTextOptions;
import com.amplifyframework.predictions.result.IdentifyResult;
import com.amplifyframework.predictions.result.InterpretResult;
import com.amplifyframework.predictions.result.TextToSpeechResult;
import com.amplifyframework.predictions.result.TranslateTextResult;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Predictions.kt */
/* loaded from: classes.dex */
public interface Predictions {
    Object convertTextToSpeech(String str, TextToSpeechOptions textToSpeechOptions, Continuation<? super TextToSpeechResult> continuation) throws PredictionsException;

    Object identify(IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Continuation<? super IdentifyResult> continuation) throws PredictionsException;

    Object interpret(String str, InterpretOptions interpretOptions, Continuation<? super InterpretResult> continuation) throws PredictionsException;

    Object translateText(String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Continuation<? super TranslateTextResult> continuation) throws PredictionsException;

    Object translateText(String str, TranslateTextOptions translateTextOptions, Continuation<? super TranslateTextResult> continuation) throws PredictionsException;

    /* compiled from: Predictions.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object convertTextToSpeech$default(Predictions predictions, String str, TextToSpeechOptions textToSpeechOptions, Continuation continuation, int r4, Object obj) throws PredictionsException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    textToSpeechOptions = TextToSpeechOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(textToSpeechOptions, "defaults()");
                }
                return predictions.convertTextToSpeech(str, textToSpeechOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertTextToSpeech");
        }

        public static /* synthetic */ Object identify$default(Predictions predictions, IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Continuation continuation, int r5, Object obj) throws PredictionsException {
            if (obj == null) {
                if ((r5 & 4) != 0) {
                    identifyOptions = IdentifyOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(identifyOptions, "defaults()");
                }
                return predictions.identify(identifyAction, bitmap, identifyOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }

        public static /* synthetic */ Object interpret$default(Predictions predictions, String str, InterpretOptions interpretOptions, Continuation continuation, int r4, Object obj) throws PredictionsException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    interpretOptions = InterpretOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(interpretOptions, "defaults()");
                }
                return predictions.interpret(str, interpretOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: interpret");
        }

        public static /* synthetic */ Object translateText$default(Predictions predictions, String str, TranslateTextOptions translateTextOptions, Continuation continuation, int r4, Object obj) throws PredictionsException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translateText");
            }
            if ((r4 & 2) != 0) {
                translateTextOptions = TranslateTextOptions.defaults();
                Intrinsics.checkNotNullExpressionValue(translateTextOptions, "defaults()");
            }
            return predictions.translateText(str, translateTextOptions, continuation);
        }

        public static /* synthetic */ Object translateText$default(Predictions predictions, String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Continuation continuation, int r12, Object obj) throws PredictionsException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translateText");
            }
            if ((r12 & 8) != 0) {
                translateTextOptions = TranslateTextOptions.defaults();
                Intrinsics.checkNotNullExpressionValue(translateTextOptions, "defaults()");
            }
            return predictions.translateText(str, languageType, languageType2, translateTextOptions, continuation);
        }
    }
}

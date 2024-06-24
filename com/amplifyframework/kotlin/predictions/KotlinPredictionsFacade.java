package com.amplifyframework.kotlin.predictions;

import android.graphics.Bitmap;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.predictions.PredictionsCategoryBehavior;
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
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinPredictionsFacade.kt */
/* loaded from: classes.dex */
public final class KotlinPredictionsFacade implements Predictions {
    private final PredictionsCategoryBehavior delegate;

    public KotlinPredictionsFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.amplifyframework.kotlin.predictions.Predictions
    public Object convertTextToSpeech(String str, TextToSpeechOptions textToSpeechOptions, Continuation<? super TextToSpeechResult> continuation) throws PredictionsException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.convertTextToSpeech(str, textToSpeechOptions, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$convertTextToSpeech$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(TextToSpeechResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$convertTextToSpeech$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PredictionsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.predictions.Predictions
    public Object identify(IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Continuation<? super IdentifyResult> continuation) throws PredictionsException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.identify(identifyAction, bitmap, identifyOptions, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$identify$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(IdentifyResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$identify$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PredictionsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.predictions.Predictions
    public Object interpret(String str, InterpretOptions interpretOptions, Continuation<? super InterpretResult> continuation) throws PredictionsException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.interpret(str, interpretOptions, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$interpret$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(InterpretResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$interpret$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PredictionsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.predictions.Predictions
    public Object translateText(String str, TranslateTextOptions translateTextOptions, Continuation<? super TranslateTextResult> continuation) throws PredictionsException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.translateText(str, translateTextOptions, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$translateText$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(TranslateTextResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$translateText$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PredictionsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public KotlinPredictionsFacade(PredictionsCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinPredictionsFacade(com.amplifyframework.predictions.PredictionsCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.predictions.PredictionsCategory r1 = com.amplifyframework.core.Amplify.Predictions
            java.lang.String r2 = "Predictions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade.<init>(com.amplifyframework.predictions.PredictionsCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.amplifyframework.kotlin.predictions.Predictions
    public Object translateText(String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Continuation<? super TranslateTextResult> continuation) throws PredictionsException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.translateText(str, languageType, languageType2, translateTextOptions, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$translateText$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(TranslateTextResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade$translateText$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PredictionsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }
}

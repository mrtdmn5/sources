package com.amplifyframework.predictions.result;

import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class TextToSpeechResult {
    private final InputStream audioData;

    private TextToSpeechResult(InputStream inputStream) {
        this.audioData = inputStream;
    }

    public static TextToSpeechResult fromAudioData(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        return new TextToSpeechResult(inputStream);
    }

    public InputStream getAudioData() {
        return this.audioData;
    }
}

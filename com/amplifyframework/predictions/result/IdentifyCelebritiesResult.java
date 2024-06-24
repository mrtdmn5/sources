package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.CelebrityDetails;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class IdentifyCelebritiesResult implements IdentifyResult {
    private final List<CelebrityDetails> celebrities;

    private IdentifyCelebritiesResult(List<CelebrityDetails> list) {
        this.celebrities = list;
    }

    public static IdentifyCelebritiesResult fromCelebrities(List<CelebrityDetails> list) {
        Objects.requireNonNull(list);
        return new IdentifyCelebritiesResult(list);
    }

    public List<CelebrityDetails> getCelebrities() {
        return Immutable.of(this.celebrities);
    }
}

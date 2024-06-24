package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* loaded from: classes.dex */
public abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> {
    public final MaybeSource<T> source;

    public AbstractMaybeWithUpstream(Maybe maybe) {
        this.source = maybe;
    }
}

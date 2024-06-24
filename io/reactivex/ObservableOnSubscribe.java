package io.reactivex;

import io.reactivex.internal.operators.observable.ObservableCreate;

/* loaded from: classes3.dex */
public interface ObservableOnSubscribe<T> {
    void subscribe(ObservableCreate.CreateEmitter createEmitter) throws Exception;
}

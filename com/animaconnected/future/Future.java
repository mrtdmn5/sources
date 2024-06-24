package com.animaconnected.future;

/* loaded from: classes.dex */
public interface Future<T> {
    Future<T> always(AlwaysCallback alwaysCallback);

    Future<T> catchError(MapCallback<Throwable, T> mapCallback);

    <E> Future<T> catchError(Class<E> cls, MapCallback<E, T> mapCallback);

    Future<T> delay(long j);

    Future<T> fail(FailCallback failCallback);

    <D> Future<D> flatMap(FlatMapCallback<T, D> flatMapCallback);

    T get();

    <D> Future<D> map(MapCallback<T, D> mapCallback);

    Future<T> success(SuccessCallback<T> successCallback);

    Future<T> timeout(long j);
}

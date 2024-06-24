package com.animaconnected.future;

/* loaded from: classes.dex */
public interface FlatMapCallback<T, D> {
    Future<D> onResult(T t) throws Exception;
}

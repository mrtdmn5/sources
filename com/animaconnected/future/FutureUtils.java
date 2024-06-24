package com.animaconnected.future;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FutureUtils {
    public static <T> Future<T> error(Throwable th) {
        Promise promise = new Promise();
        promise.reject(th);
        return promise.getFuture();
    }

    public static <T> Future<T> just(T t) {
        Promise promise = new Promise();
        promise.resolve(t);
        return promise.getFuture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$unwrap$0(List list) throws IOException {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map.Entry lambda$unwrap$1(Map.Entry entry, Object obj) throws IOException {
        return new AbstractMap.SimpleImmutableEntry(entry.getKey(), obj);
    }

    public static <T> Future<List<T>> merge(List<Future<T>> list) {
        return new MergePromise(list).getFuture();
    }

    public static <K, V> Future<Map<K, V>> unwrap(Map<K, Future<V>> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<K, Future<V>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(unwrap(it.next()));
        }
        return merge(arrayList).map(new FutureUtils$$ExternalSyntheticLambda1());
    }

    public static <K, V> Future<Map.Entry<K, V>> unwrap(final Map.Entry<K, Future<V>> entry) {
        return (Future<Map.Entry<K, V>>) entry.getValue().map(new MapCallback() { // from class: com.animaconnected.future.FutureUtils$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.MapCallback
            public final Object onResult(Object obj) {
                Map.Entry lambda$unwrap$1;
                lambda$unwrap$1 = FutureUtils.lambda$unwrap$1(entry, obj);
                return lambda$unwrap$1;
            }
        });
    }
}

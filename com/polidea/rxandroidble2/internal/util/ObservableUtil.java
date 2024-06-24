package com.polidea.rxandroidble2.internal.util;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/* loaded from: classes3.dex */
public final class ObservableUtil {
    public static final AnonymousClass1 IDENTITY_TRANSFORMER = new AnonymousClass1();

    /* renamed from: com.polidea.rxandroidble2.internal.util.ObservableUtil$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements ObservableTransformer<Object, Object> {
        @Override // io.reactivex.ObservableTransformer
        public final Observable apply(Observable observable) {
            return observable;
        }
    }
}

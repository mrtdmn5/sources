package com.google.android.gms.common.internal;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzah {
    public static void setOnce(AtomicReference atomicReference, Disposable disposable, Class cls) {
        boolean z;
        if (disposable == null) {
            throw new NullPointerException("next is null");
        }
        while (true) {
            if (atomicReference.compareAndSet(null, disposable)) {
                z = true;
                break;
            } else if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        if (!z) {
            disposable.dispose();
            if (atomicReference.get() != DisposableHelper.DISPOSED) {
                String name = cls.getName();
                RxJavaPlugins.onError(new ProtocolViolationException("It is not allowed to subscribe with a(n) " + name + " multiple times. Please create a fresh instance of " + name + " and subscribe that to the target source instead."));
            }
        }
    }
}

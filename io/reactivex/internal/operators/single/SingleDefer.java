package io.reactivex.internal.operators.single;

import com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda1;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SingleDefer<T> extends Single<T> {
    public final Callable<? extends SingleSource<? extends T>> singleSupplier;

    public SingleDefer(ServiceDiscoveryOperation$$ExternalSyntheticLambda1 serviceDiscoveryOperation$$ExternalSyntheticLambda1) {
        this.singleSupplier = serviceDiscoveryOperation$$ExternalSyntheticLambda1;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            SingleSource<? extends T> call = this.singleSupplier.call();
            ObjectHelper.requireNonNull(call, "The singleSupplier returned a null SingleSource");
            call.subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}

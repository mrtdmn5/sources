package io.reactivex.observers;

import com.google.android.gms.common.internal.zzah;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {
    public final AtomicReference<Disposable> upstream = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.upstream.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        zzah.setOnce(this.upstream, disposable, getClass());
    }
}

package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean replace(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        boolean z;
        do {
            Disposable disposable2 = atomicReference.get();
            z = false;
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(disposable2, disposable)) {
                    z = true;
                    break;
                }
                if (atomicReference.get() != disposable2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        boolean z;
        do {
            disposable2 = atomicReference.get();
            z = false;
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(disposable2, disposable)) {
                    z = true;
                    break;
                }
                if (atomicReference.get() != disposable2) {
                    break;
                }
            }
        } while (!z);
        if (disposable2 != null) {
            disposable2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        boolean z;
        if (disposable == null) {
            throw new NullPointerException("d is null");
        }
        while (true) {
            if (atomicReference.compareAndSet(null, disposable)) {
                z = true;
                break;
            }
            if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean trySet(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        boolean z;
        while (true) {
            if (atomicReference.compareAndSet(null, disposable)) {
                z = true;
                break;
            }
            if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            disposable.dispose();
        }
        return false;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (disposable != null) {
            disposable2.dispose();
            reportDisposableSet();
            return false;
        }
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(Disposable disposable) {
        return disposable == DISPOSED;
    }
}

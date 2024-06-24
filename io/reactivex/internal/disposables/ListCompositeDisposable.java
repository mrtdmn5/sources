package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    public volatile boolean disposed;
    public LinkedList resources;

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean add(Disposable disposable) {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    LinkedList linkedList = this.resources;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.resources = linkedList;
                    }
                    linkedList.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean delete(Disposable disposable) {
        if (disposable != null) {
            if (this.disposed) {
                return false;
            }
            synchronized (this) {
                if (this.disposed) {
                    return false;
                }
                LinkedList linkedList = this.resources;
                if (linkedList != null && linkedList.remove(disposable)) {
                    return true;
                }
                return false;
            }
        }
        throw new NullPointerException("Disposable item is null");
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            LinkedList linkedList = this.resources;
            ArrayList arrayList = null;
            this.resources = null;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    try {
                        ((Disposable) it.next()).dispose();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() == 1) {
                        throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
                    }
                    throw new CompositeException(arrayList);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean remove(Disposable disposable) {
        if (delete(disposable)) {
            ((ScheduledRunnable) disposable).dispose();
            return true;
        }
        return false;
    }
}

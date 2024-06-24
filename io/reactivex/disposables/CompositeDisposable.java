package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    public volatile boolean disposed;
    public OpenHashSet<Disposable> resources;

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean add(Disposable disposable) {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> openHashSet = this.resources;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.resources = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x004e, DONT_GENERATE, TryCatch #0 {, blocks: (B:9:0x000b, B:11:0x000f, B:13:0x0011, B:15:0x0015, B:21:0x004a, B:23:0x002b, B:25:0x0031, B:27:0x0035, B:29:0x003d, B:32:0x0043, B:35:0x004c), top: B:8:0x000b }] */
    @Override // io.reactivex.internal.disposables.DisposableContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean delete(io.reactivex.disposables.Disposable r8) {
        /*
            r7 = this;
            java.lang.String r0 = "disposables is null"
            if (r8 == 0) goto L51
            boolean r0 = r7.disposed
            r1 = 0
            if (r0 == 0) goto La
            return r1
        La:
            monitor-enter(r7)
            boolean r0 = r7.disposed     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L11
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4e
            return r1
        L11:
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> r0 = r7.resources     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L4c
            T[] r2 = r0.keys     // Catch: java.lang.Throwable -> L4e
            int r3 = r0.mask     // Catch: java.lang.Throwable -> L4e
            int r4 = r8.hashCode()     // Catch: java.lang.Throwable -> L4e
            r5 = -1640531527(0xffffffff9e3779b9, float:-9.713111E-21)
            int r4 = r4 * r5
            int r5 = r4 >>> 16
            r4 = r4 ^ r5
            r4 = r4 & r3
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L4e
            r6 = 1
            if (r5 != 0) goto L2b
            goto L3b
        L2b:
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L35
            r0.removeEntry(r4, r3, r2)     // Catch: java.lang.Throwable -> L4e
            goto L46
        L35:
            int r4 = r4 + r6
            r4 = r4 & r3
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L4e
            if (r5 != 0) goto L3d
        L3b:
            r8 = r1
            goto L47
        L3d:
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L35
            r0.removeEntry(r4, r3, r2)     // Catch: java.lang.Throwable -> L4e
        L46:
            r8 = r6
        L47:
            if (r8 != 0) goto L4a
            goto L4c
        L4a:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4e
            return r6
        L4c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4e
            return r1
        L4e:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4e
            throw r8
        L51:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.delete(io.reactivex.disposables.Disposable):boolean");
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
            OpenHashSet<Disposable> openHashSet = this.resources;
            ArrayList arrayList = null;
            this.resources = null;
            if (openHashSet != null) {
                for (Disposable disposable : openHashSet.keys) {
                    if (disposable instanceof Disposable) {
                        try {
                            disposable.dispose();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th);
                        }
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
            disposable.dispose();
            return true;
        }
        return false;
    }
}

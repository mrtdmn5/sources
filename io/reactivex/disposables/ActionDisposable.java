package io.reactivex.disposables;

import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: classes3.dex */
public final class ActionDisposable extends ReferenceDisposable<Action> {
    public ActionDisposable(ClientOperationQueueImpl.AnonymousClass2.AnonymousClass1 anonymousClass1) {
        super(anonymousClass1);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public final void onDisposed(Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}

package androidx.work.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

/* loaded from: classes.dex */
public final class OperationImpl implements Operation {
    public final MutableLiveData<Operation.State> mOperationState = new MutableLiveData<>();
    public final SettableFuture<Operation.State.SUCCESS> mOperationFuture = new SettableFuture<>();

    public OperationImpl() {
        setState(Operation.IN_PROGRESS);
    }

    public final void setState(Operation.State state) {
        this.mOperationState.postValue(state);
        boolean z = state instanceof Operation.State.SUCCESS;
        SettableFuture<Operation.State.SUCCESS> settableFuture = this.mOperationFuture;
        if (z) {
            settableFuture.set((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            settableFuture.setException(((Operation.State.FAILURE) state).mThrowable);
        }
    }
}

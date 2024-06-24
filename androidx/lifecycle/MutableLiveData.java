package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;

/* loaded from: classes.dex */
public class MutableLiveData<T> extends LiveData<T> {
    public final void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            if (this.mPendingData == LiveData.NOT_SET) {
                z = true;
            } else {
                z = false;
            }
            this.mPendingData = t;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T t) {
        super.setValue(t);
    }
}

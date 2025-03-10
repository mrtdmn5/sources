package androidx.core.os;

/* loaded from: classes.dex */
public final class CancellationSignal {
    public boolean mCancelInProgress;
    public boolean mIsCanceled;
    public OnCancelListener mOnCancelListener;

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    public final void cancel() {
        synchronized (this) {
            if (this.mIsCanceled) {
                return;
            }
            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            OnCancelListener onCancelListener = this.mOnCancelListener;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.mCancelInProgress = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.mCancelInProgress = false;
                notifyAll();
            }
        }
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            while (this.mCancelInProgress) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (this.mIsCanceled) {
                onCancelListener.onCancel();
            }
        }
    }
}

package androidx.loader.content;

import android.content.Context;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import androidx.core.util.DebugUtils;

/* loaded from: classes.dex */
public class Loader<D> {
    public int mId;
    public OnLoadCompleteListener<D> mListener;
    public boolean mStarted = false;
    public boolean mAbandoned = false;
    public boolean mReset = true;
    public boolean mContentChanged = false;

    /* loaded from: classes.dex */
    public interface OnLoadCompleteListener<D> {
    }

    public Loader(Context context) {
        context.getApplicationContext();
    }

    public final void cancelLoad() {
        AsyncTaskLoader asyncTaskLoader = (AsyncTaskLoader) this;
        if (asyncTaskLoader.mTask != null) {
            if (!asyncTaskLoader.mStarted) {
                asyncTaskLoader.mContentChanged = true;
            }
            if (asyncTaskLoader.mCancellingTask != null) {
                asyncTaskLoader.mTask.getClass();
                asyncTaskLoader.mTask = null;
                return;
            }
            asyncTaskLoader.mTask.getClass();
            AsyncTaskLoader<D>.LoadTask loadTask = asyncTaskLoader.mTask;
            loadTask.mCancelled.set(true);
            if (loadTask.mFuture.cancel(false)) {
                asyncTaskLoader.mCancellingTask = asyncTaskLoader.mTask;
            }
            asyncTaskLoader.mTask = null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.mId, "}");
    }
}

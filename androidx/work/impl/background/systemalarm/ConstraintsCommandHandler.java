package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsTracker;

/* loaded from: classes.dex */
public final class ConstraintsCommandHandler {
    public static final String TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    public final Context mContext;
    public final int mStartId;
    public final WorkConstraintsTracker mWorkConstraintsTracker;

    public ConstraintsCommandHandler(Context context, int startId, SystemAlarmDispatcher dispatcher) {
        this.mContext = context;
        this.mStartId = startId;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, dispatcher.mTaskExecutor, null);
    }
}

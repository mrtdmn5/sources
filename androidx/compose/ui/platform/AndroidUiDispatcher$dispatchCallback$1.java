package androidx.compose.ui.platform;

import android.view.Choreographer;
import java.util.List;
import kotlin.Unit;

/* compiled from: AndroidUiDispatcher.android.kt */
/* loaded from: classes.dex */
public final class AndroidUiDispatcher$dispatchCallback$1 implements Choreographer.FrameCallback, Runnable {
    public final /* synthetic */ AndroidUiDispatcher this$0;

    public AndroidUiDispatcher$dispatchCallback$1(AndroidUiDispatcher androidUiDispatcher) {
        this.this$0 = androidUiDispatcher;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.this$0.handler.removeCallbacks(this);
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        AndroidUiDispatcher androidUiDispatcher = this.this$0;
        synchronized (androidUiDispatcher.lock) {
            if (androidUiDispatcher.scheduledFrameDispatch) {
                androidUiDispatcher.scheduledFrameDispatch = false;
                List<Choreographer.FrameCallback> list = androidUiDispatcher.toRunOnFrame;
                androidUiDispatcher.toRunOnFrame = androidUiDispatcher.spareToRunOnFrame;
                androidUiDispatcher.spareToRunOnFrame = list;
                int size = list.size();
                for (int r2 = 0; r2 < size; r2++) {
                    list.get(r2).doFrame(j);
                }
                list.clear();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        AndroidUiDispatcher androidUiDispatcher = this.this$0;
        synchronized (androidUiDispatcher.lock) {
            if (androidUiDispatcher.toRunOnFrame.isEmpty()) {
                androidUiDispatcher.choreographer.removeFrameCallback(this);
                androidUiDispatcher.scheduledFrameDispatch = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}

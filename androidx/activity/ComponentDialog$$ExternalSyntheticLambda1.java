package androidx.activity;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KeyEvent.Callback f$0;

    public /* synthetic */ ComponentDialog$$ExternalSyntheticLambda1(KeyEvent.Callback callback, int r2) {
        this.$r8$classId = r2;
        this.f$0 = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.$r8$classId;
        KeyEvent.Callback callback = this.f$0;
        switch (r0) {
            case 0:
                ComponentDialog.m1$r8$lambda$KrBLxNpMJdSxVU3Lsj65hn0UyA((ComponentDialog) callback);
                return;
            default:
                AndroidComposeView this$0 = (AndroidComposeView) callback;
                Class<?> cls = AndroidComposeView.systemPropertiesClass;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                boolean z = false;
                this$0.hoverExitReceived = false;
                MotionEvent motionEvent = this$0.previousMotionEvent;
                Intrinsics.checkNotNull(motionEvent);
                if (motionEvent.getActionMasked() == 10) {
                    z = true;
                }
                if (z) {
                    this$0.m488sendMotionEvent8iAsVTc(motionEvent);
                    return;
                }
                throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
    }
}

package androidx.compose.ui.platform;

import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeView$resendMotionEventOnLayout$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$resendMotionEventOnLayout$1(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int actionMasked;
        AndroidComposeView androidComposeView = this.this$0;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        if (motionEvent != null && ((actionMasked = motionEvent.getActionMasked()) == 7 || actionMasked == 9)) {
            androidComposeView.relayoutTime = SystemClock.uptimeMillis();
            androidComposeView.post(androidComposeView.resendMotionEventRunnable);
        }
        return Unit.INSTANCE;
    }
}

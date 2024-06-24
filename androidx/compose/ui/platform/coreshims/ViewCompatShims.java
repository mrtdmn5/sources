package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* loaded from: classes.dex */
public final class ViewCompatShims {

    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static void setImportantForContentCapture(View view, int r1) {
            view.setImportantForContentCapture(r1);
        }
    }

    public static AutofillIdCompat getAutofillId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new AutofillIdCompat(Api26Impl.getAutofillId(view));
        }
        return null;
    }
}

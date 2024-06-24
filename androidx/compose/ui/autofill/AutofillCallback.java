package androidx.compose.ui.autofill;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager$AutofillCallback;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutofillCallback.android.kt */
/* loaded from: classes.dex */
public final class AutofillCallback extends AutofillManager$AutofillCallback {
    public static final AutofillCallback INSTANCE = new AutofillCallback();

    public final void onAutofillEvent(View view, int r3, int r4) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAutofillEvent(view, r3, r4);
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 != 3) {
                    str = "Unknown status event.";
                } else {
                    str = "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account";
                }
            } else {
                str = "Autofill popup was hidden.";
            }
        } else {
            str = "Autofill popup was shown.";
        }
        Log.d("Autofill Status", str);
    }

    public final void register(AndroidAutofill autofill) {
        Intrinsics.checkNotNullParameter(autofill, "autofill");
        autofill.autofillManager.registerCallback(AutofillCallback$$ExternalSyntheticApiModelOutline0.m(this));
    }

    public final void unregister(AndroidAutofill autofill) {
        Intrinsics.checkNotNullParameter(autofill, "autofill");
        autofill.autofillManager.unregisterCallback(AutofillCallback$$ExternalSyntheticApiModelOutline0.m(this));
    }
}

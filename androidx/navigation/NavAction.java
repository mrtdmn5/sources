package androidx.navigation;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class NavAction {
    public final int mDestinationId;
    public NavOptions mNavOptions = null;
    public Bundle mDefaultArguments = null;

    public NavAction(int r1) {
        this.mDestinationId = r1;
    }
}

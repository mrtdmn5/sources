package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsClient;

/* loaded from: classes.dex */
public final class CustomTabsSession {
    public final ICustomTabsCallback mCallback;
    public final ComponentName mComponentName;
    public final PendingIntent mId = null;
    public final ICustomTabsService mService;

    public CustomTabsSession(ICustomTabsService iCustomTabsService, CustomTabsClient.AnonymousClass2 anonymousClass2, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mCallback = anonymousClass2;
        this.mComponentName = componentName;
    }
}

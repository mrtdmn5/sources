package androidx.browser.customtabs;

import android.content.ComponentName;
import android.support.customtabs.ICustomTabsService;

/* loaded from: classes.dex */
public class CustomTabsClient {
    public final ICustomTabsService mService;
    public final ComponentName mServiceComponentName;

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
    }
}

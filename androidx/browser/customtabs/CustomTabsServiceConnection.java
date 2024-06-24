package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.support.customtabs.ICustomTabsService;

/* loaded from: classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {
    private Context mApplicationContext;

    /* renamed from: androidx.browser.customtabs.CustomTabsServiceConnection$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends CustomTabsClient {
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ICustomTabsService proxy;
        if (this.mApplicationContext != null) {
            int r1 = ICustomTabsService.Stub.$r8$clinit;
            if (iBinder == null) {
                proxy = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
                if (queryLocalInterface != null && (queryLocalInterface instanceof ICustomTabsService)) {
                    proxy = (ICustomTabsService) queryLocalInterface;
                } else {
                    proxy = new ICustomTabsService.Stub.Proxy(iBinder);
                }
            }
            onCustomTabsServiceConnected(componentName, new AnonymousClass1(proxy, componentName));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}

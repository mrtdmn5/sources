package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleService.kt */
/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    public final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.dispatcher.registry;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.dispatcher;
        serviceLifecycleDispatcher.getClass();
        serviceLifecycleDispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.dispatcher;
        serviceLifecycleDispatcher.getClass();
        serviceLifecycleDispatcher.postDispatchRunnable(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.dispatcher;
        serviceLifecycleDispatcher.getClass();
        serviceLifecycleDispatcher.postDispatchRunnable(Lifecycle.Event.ON_STOP);
        serviceLifecycleDispatcher.postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int r4) {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.dispatcher;
        serviceLifecycleDispatcher.getClass();
        serviceLifecycleDispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        super.onStart(intent, r4);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int r2, int r3) {
        return super.onStartCommand(intent, r2, r3);
    }
}

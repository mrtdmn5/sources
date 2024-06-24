package com.animaconnected.secondo.screens.watch.item;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.watch.behaviour.Behaviour;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchItem.kt */
/* loaded from: classes3.dex */
public final class WatchItem {
    private static final long REFRESH_INTERVAL = 1000;
    private Behaviour subComplicationBehaviour1;
    private Behaviour subComplicationBehaviour2;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Set<WatchItemChangeListener> listeners = new HashSet();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable refreshRunnable = new Runnable() { // from class: com.animaconnected.secondo.screens.watch.item.WatchItem$refreshRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            WatchItem.this.refresh();
            handler = WatchItem.this.handler;
            handler.postDelayed(this, 1000L);
        }
    };

    /* compiled from: WatchItem.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Behaviour getSubComplicationBehaviour1() {
        return this.subComplicationBehaviour1;
    }

    public final Behaviour getSubComplicationBehaviour2() {
        return this.subComplicationBehaviour2;
    }

    public final void refresh() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchItemChangeListener) it.next()).onWatchItemChanged(this);
        }
    }

    public final void registerWatchItemChangedListener(WatchItemChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void setSubComplicationBehaviour1(Behaviour behaviour) {
        this.subComplicationBehaviour1 = behaviour;
    }

    public final void setSubComplicationBehaviour2(Behaviour behaviour) {
        this.subComplicationBehaviour2 = behaviour;
    }

    public final void startRefreshing() {
        this.handler.post(this.refreshRunnable);
    }

    public final void stopRefreshing() {
        this.handler.removeCallbacks(this.refreshRunnable);
    }

    public final void unregisterWatchItemChangedListener(WatchItemChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}

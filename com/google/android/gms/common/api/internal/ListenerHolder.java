package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class ListenerHolder<L> {
    public final HandlerExecutor zaa;
    public volatile Object zab;
    public volatile ListenerKey zac;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class ListenerKey<L> {
        public final Object zaa;
        public final String zab = "LocationCallback";

        public ListenerKey(Object obj) {
            this.zaa = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.zab.hashCode() + (System.identityHashCode(this.zaa) * 31);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    public ListenerHolder(Looper looper, Object obj) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = obj;
        Preconditions.checkNotEmpty("LocationCallback");
        this.zac = new ListenerKey(obj);
    }

    public final void notifyListener(final Notifier<? super L> notifier) {
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder listenerHolder = ListenerHolder.this;
                ListenerHolder.Notifier notifier2 = notifier;
                Object obj = listenerHolder.zab;
                if (obj == null) {
                    notifier2.onNotifyListenerFailed();
                    return;
                }
                try {
                    notifier2.notifyListener(obj);
                } catch (RuntimeException e) {
                    notifier2.onNotifyListenerFailed();
                    throw e;
                }
            }
        });
    }
}

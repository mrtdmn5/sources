package com.animaconnected.secondo.app;

import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;

/* loaded from: classes.dex */
class DeviceNotificationModel extends BaseWatchProviderListener {
    private ChangeListener mListener;

    /* loaded from: classes.dex */
    public interface ChangeListener {
        void onChange();
    }

    public DeviceNotificationModel(WatchProvider watchProvider) {
        watchProvider.registerListener(this);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBehaviourSet(Slot slot, Behaviour behaviour) {
        ChangeListener changeListener = this.mListener;
        if (changeListener != null) {
            changeListener.onChange();
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onConnectionChanged(boolean z) {
        ChangeListener changeListener = this.mListener;
        if (changeListener != null) {
            changeListener.onChange();
        }
    }

    public void setListener(ChangeListener changeListener) {
        this.mListener = changeListener;
    }
}

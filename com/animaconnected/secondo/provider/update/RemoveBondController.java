package com.animaconnected.secondo.provider.update;

import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.DeviceConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public class RemoveBondController implements DeviceConnectionListener {
    private final Set<ProgressListener> mListeners = new CopyOnWriteArraySet();
    private RemoveBondState mState = RemoveBondState.NOT_STARTED;

    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void onRemoveBondAutoFlowStarted();

        void onRemoveBondFinished();

        void onRemoveBondStarted(boolean z);
    }

    /* loaded from: classes3.dex */
    public enum RemoveBondState {
        NOT_STARTED,
        TURN_OFF_BT,
        TURN_ON_BT,
        CONNECT,
        FLOW_COMPLETED,
        RESTART_PHONE
    }

    private void close() {
        ProviderFactory.getWatch().unregisterDeviceConnectionListener(this);
    }

    private void finishFlow() {
        if (this.mState == RemoveBondState.CONNECT) {
            this.mState = RemoveBondState.FLOW_COMPLETED;
            notifyRemoveBondFinished();
            close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$startRemoveBondFlow$0() {
        this.mState = RemoveBondState.CONNECT;
        return null;
    }

    private void notifyRemoveBondAutoFlowStarted() {
        Iterator<ProgressListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onRemoveBondAutoFlowStarted();
        }
    }

    private void notifyRemoveBondFinished() {
        Iterator<ProgressListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onRemoveBondFinished();
        }
    }

    private void notifyRemoveBondStarted(boolean z) {
        Iterator<ProgressListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onRemoveBondStarted(z);
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        finishFlow();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        finishFlow();
    }

    public void registerListener(ProgressListener progressListener) {
        this.mListeners.add(progressListener);
    }

    public boolean shouldShowStatus() {
        RemoveBondState removeBondState = this.mState;
        if (removeBondState != RemoveBondState.TURN_ON_BT && removeBondState != RemoveBondState.TURN_OFF_BT && removeBondState != RemoveBondState.CONNECT && removeBondState != RemoveBondState.RESTART_PHONE) {
            return false;
        }
        return true;
    }

    public void startAutoFlow() {
        notifyRemoveBondAutoFlowStarted();
        ConnectionFactory.getConnection().toggle();
    }

    public void startRemoveBondFlow() {
        if (this.mState == RemoveBondState.NOT_STARTED) {
            this.mState = RemoveBondState.TURN_OFF_BT;
            ConnectionFactory.getConnection().waitForToggle(new Function0() { // from class: com.animaconnected.secondo.provider.update.RemoveBondController$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit lambda$startRemoveBondFlow$0;
                    lambda$startRemoveBondFlow$0 = RemoveBondController.this.lambda$startRemoveBondFlow$0();
                    return lambda$startRemoveBondFlow$0;
                }
            });
            ProviderFactory.getWatch().registerDeviceConnectionListener(this);
            notifyRemoveBondStarted(false);
            return;
        }
        this.mState = RemoveBondState.RESTART_PHONE;
        notifyRemoveBondStarted(true);
    }

    public void unregisterListener(ProgressListener progressListener) {
        this.mListeners.remove(progressListener);
    }
}

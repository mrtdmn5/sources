package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat$Api16Impl;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public final class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    public static final String TAG = Logger.tagWithPrefix("NetworkStateTracker");
    public final ConnectivityManager mConnectivityManager;
    public final NetworkStateCallback mNetworkCallback;

    /* loaded from: classes.dex */
    public class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        public NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
            Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", capabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.mConnectivityManager = (ConnectivityManager) this.mAppContext.getSystemService("connectivity");
        this.mNetworkCallback = new NetworkStateCallback();
    }

    public final NetworkState getActiveNetworkState() {
        boolean z;
        boolean z2;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z3 = true;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z = true;
        } else {
            z = false;
        }
        try {
            networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (SecurityException e) {
            Logger.get().error(TAG, "Unable to validate active network", e);
        }
        if (networkCapabilities != null) {
            if (networkCapabilities.hasCapability(16)) {
                z2 = true;
                boolean isActiveNetworkMetered = ConnectivityManagerCompat$Api16Impl.isActiveNetworkMetered(connectivityManager);
                if (activeNetworkInfo != null || activeNetworkInfo.isRoaming()) {
                    z3 = false;
                }
                return new NetworkState(z, z2, isActiveNetworkMetered, z3);
            }
        }
        z2 = false;
        boolean isActiveNetworkMetered2 = ConnectivityManagerCompat$Api16Impl.isActiveNetworkMetered(connectivityManager);
        if (activeNetworkInfo != null) {
        }
        z3 = false;
        return new NetworkState(z, z2, isActiveNetworkMetered2, z3);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final NetworkState getInitialState() {
        return getActiveNetworkState();
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void startTracking() {
        String str = TAG;
        try {
            Logger.get().debug(str, "Registering network callback", new Throwable[0]);
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException e) {
            Logger.get().error(str, "Received exception while registering network callback", e);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void stopTracking() {
        String str = TAG;
        try {
            Logger.get().debug(str, "Unregistering network callback", new Throwable[0]);
            this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException e) {
            Logger.get().error(str, "Received exception while unregistering network callback", e);
        }
    }
}

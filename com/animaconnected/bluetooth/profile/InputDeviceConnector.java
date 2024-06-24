package com.animaconnected.bluetooth.profile;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class InputDeviceConnector implements BluetoothProfile.ServiceListener {
    private static final int PROFILE_INPUT_DEVICE = 4;
    private static final String TAG = "InputDeviceConnector";
    private static InputDeviceConnector sInstance;
    private BluetoothDevice mDevice;
    private boolean mIsTryingToConnect;
    private BluetoothProfile mProxy;

    private InputDeviceConnector() {
    }

    private String bluetoothProfileStateToString(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 2) {
                    return "unknown";
                }
                return "connected";
            }
            return "connecting";
        }
        return "disconnected";
    }

    public static InputDeviceConnector getInstance() {
        if (sInstance == null) {
            sInstance = new InputDeviceConnector();
        }
        return sInstance;
    }

    private boolean isConnected() {
        BluetoothProfile bluetoothProfile = this.mProxy;
        if (bluetoothProfile != null && Build.VERSION.SDK_INT <= 29) {
            Iterator<BluetoothDevice> it = bluetoothProfile.getConnectedDevices().iterator();
            while (it.hasNext()) {
                if (this.mDevice.getAddress().equals(it.next().getAddress())) {
                    Log.d(TAG, "Input device is connected");
                    return true;
                }
            }
        }
        Log.d(TAG, "Input device is disconnected");
        return false;
    }

    private void tryConnect() {
        try {
            String str = TAG;
            Log.d(str, "Trying to connect input device...");
            this.mIsTryingToConnect = true;
            Log.d(str, "Input device invoked connect success = " + ((Boolean) this.mProxy.getClass().getMethod("connect", BluetoothDevice.class).invoke(this.mProxy, this.mDevice)));
        } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.d(TAG, "Failed to connect to HID profile", e);
        }
        this.mIsTryingToConnect = false;
    }

    @SuppressLint({"MissingPermission"})
    public void doConnectIfNeeded(BluetoothDevice bluetoothDevice, Context context) {
        BluetoothAdapter adapter;
        boolean z;
        String str = TAG;
        Log.d(str, "Do connect if needed...");
        if (Build.VERSION.SDK_INT > 29) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            int connectionState = bluetoothManager.getConnectionState(bluetoothDevice, 8);
            BluetoothAdapter adapter2 = bluetoothManager.getAdapter();
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("HID connect for android 10+. State is ", connectionState, " connected");
            if (connectionState == 2) {
                z = true;
            } else {
                z = false;
            }
            m.append(z);
            Log.d(str, m.toString());
            BluetoothProfile bluetoothProfile = this.mProxy;
            if (bluetoothProfile != null) {
                adapter2.closeProfileProxy(4, bluetoothProfile);
            }
            Log.d(str, "getProfileProxy returned: " + adapter2.getProfileProxy(context, this, 4));
            return;
        }
        this.mDevice = bluetoothDevice;
        if (isConnected() || (adapter = ((BluetoothManager) context.getSystemService(BluetoothManager.class)).getAdapter()) == null) {
            return;
        }
        BluetoothProfile bluetoothProfile2 = this.mProxy;
        if (bluetoothProfile2 != null) {
            adapter.closeProfileProxy(4, bluetoothProfile2);
        }
        Log.d(str, "getProfileProxy returned: " + adapter.getProfileProxy(context, this, 4));
    }

    public boolean isHIDConnected(BluetoothDevice bluetoothDevice) {
        BluetoothProfile bluetoothProfile = this.mProxy;
        if (bluetoothProfile == null || Build.VERSION.SDK_INT > 29) {
            return false;
        }
        int connectionState = bluetoothProfile.getConnectionState(bluetoothDevice);
        Log.d(TAG, "BluetoothProfileState: " + bluetoothProfileStateToString(connectionState));
        if (connectionState == 0) {
            return false;
        }
        return true;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int r4, BluetoothProfile bluetoothProfile) {
        String str = TAG;
        Log.d(str, "onServiceConnected profile: " + r4);
        if (r4 == 4) {
            this.mProxy = bluetoothProfile;
            if (!this.mIsTryingToConnect && !isConnected()) {
                tryConnect();
                return;
            }
            return;
        }
        Log.d(str, "This should not happen, the profile should be: 4");
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int r4) {
        Log.d(TAG, "onServiceDisconnected profile: " + r4);
    }
}

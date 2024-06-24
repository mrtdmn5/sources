package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.animaconnected.bluetooth.gatt.rxtwo.BondHelper;
import com.animaconnected.logger.LogKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: BondHelper.kt */
/* loaded from: classes.dex */
public final class BondHelper$setState$2$1$1 extends BroadcastReceiver {
    final /* synthetic */ int $bondState;
    final /* synthetic */ CancellableContinuation<BondHelper.Result> $continuation;
    final /* synthetic */ BondHelper this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BondHelper$setState$2$1$1(BondHelper bondHelper, int r2, CancellableContinuation<? super BondHelper.Result> cancellableContinuation) {
        this.this$0 = bondHelper;
        this.$bondState = r2;
        this.$continuation = cancellableContinuation;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context1, Intent intent) {
        BondHelper.Result result;
        Intrinsics.checkNotNullParameter(context1, "context1");
        Intrinsics.checkNotNullParameter(intent, "intent");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null || !Intrinsics.areEqual(bluetoothDevice, this.this$0.getBluetoothDevice())) {
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (intExtra == 10 || intExtra == 12) {
            if (intExtra == this.$bondState) {
                result = BondHelper.Result.Success;
            } else {
                result = BondHelper.Result.Failed;
            }
            LogKt.debug$default((Object) this, "Reached state: " + result, this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
            this.$continuation.resumeWith(result);
        }
    }
}

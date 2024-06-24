package com.animaconnected.secondo.provider.status;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.status.connection.BluetoothDisabledStatusFragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class BluetoothDisabledStatus extends StatusModel {
    public static final int $stable = 8;
    private final List<String> missingPermissions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothDisabledStatus(List<String> missingPermissions) {
        super(2000, BluetoothDisabledStatusFragment.class, null);
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        this.missingPermissions = missingPermissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BluetoothDisabledStatus copy$default(BluetoothDisabledStatus bluetoothDisabledStatus, List list, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            list = bluetoothDisabledStatus.missingPermissions;
        }
        return bluetoothDisabledStatus.copy(list);
    }

    public final List<String> component1() {
        return this.missingPermissions;
    }

    public final BluetoothDisabledStatus copy(List<String> missingPermissions) {
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        return new BluetoothDisabledStatus(missingPermissions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BluetoothDisabledStatus) && Intrinsics.areEqual(this.missingPermissions, ((BluetoothDisabledStatus) obj).missingPermissions)) {
            return true;
        }
        return false;
    }

    public final List<String> getMissingPermissions() {
        return this.missingPermissions;
    }

    public int hashCode() {
        return this.missingPermissions.hashCode();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusModel
    public String toString() {
        return LocaleList$$ExternalSyntheticOutline0.m(new StringBuilder("BluetoothDisabledStatus(missingPermissions="), this.missingPermissions, ')');
    }
}

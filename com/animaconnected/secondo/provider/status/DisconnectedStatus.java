package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.screens.status.connection.DisconnectedStatusFragment;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class DisconnectedStatus extends StatusModel {
    public static final int $stable = 0;
    public static final DisconnectedStatus INSTANCE = new DisconnectedStatus();

    private DisconnectedStatus() {
        super(100, DisconnectedStatusFragment.class, null);
    }
}

package com.animaconnected.secondo.behaviour.mutephone;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutePhone.kt */
/* loaded from: classes3.dex */
public final class MutePhone implements Pusher {
    public static final int UNMUTE_VOLUME_INDEX = -1;
    private final String analyticsName;
    private final Context context;
    private final String type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = TipsAndTricksConstants.MUTE_PHONE_NAME;
    public static final String TYPE = TipsAndTricksConstants.MUTE_PHONE_NAME;

    /* compiled from: MutePhone.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MutePhone(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.type = TYPE;
        this.analyticsName = "mute_phone";
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Object systemService = this.context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (notificationManager.isNotificationPolicyAccessGranted()) {
            if (action == ButtonAction.Press) {
                notificationManager.setInterruptionFilter(4);
            } else if (action == ButtonAction.DoublePress) {
                notificationManager.setInterruptionFilter(1);
            }
        } else {
            Log.d(TAG, "Triggered without access");
        }
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}

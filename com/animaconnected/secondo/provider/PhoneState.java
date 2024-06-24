package com.animaconnected.secondo.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.animaconnected.logger.LogKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallStateBroadcastReciever.kt */
/* loaded from: classes3.dex */
public final class PhoneState extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        Object obj;
        int r9;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.PHONE_STATE") && intent.hasExtra("incoming_number")) {
            String stringExtra = intent.getStringExtra("incoming_number");
            LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.PhoneState$onReceive$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Phone state intent: " + intent.getExtras();
                }
            }, 7, (Object) null);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                obj = extras.get("state");
            } else {
                obj = null;
            }
            if (Intrinsics.areEqual(obj, TelephonyManager.EXTRA_STATE_IDLE)) {
                r9 = 0;
            } else if (Intrinsics.areEqual(obj, TelephonyManager.EXTRA_STATE_RINGING)) {
                r9 = 1;
            } else if (Intrinsics.areEqual(obj, TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                r9 = 2;
            } else {
                return;
            }
            ProviderFactory.INSTANCE.getCallStateReceiver().onCallStateChanged(r9, stringExtra);
        }
    }
}

package com.animaconnected.secondo.notification.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.HybridWatch;
import com.animaconnected.watch.device.Command;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingSmsReceiver.kt */
/* loaded from: classes3.dex */
public final class IncomingSmsReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "IncomingSmsReceiver";

    /* compiled from: IncomingSmsReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!(ProviderFactory.getWatch().getWatch() instanceof HybridWatch)) {
            return;
        }
        Bundle extras = intent.getExtras();
        Object[] objArr = null;
        if (extras != null) {
            obj = extras.get("pdus");
        } else {
            obj = null;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        }
        if (objArr == null) {
            return;
        }
        try {
            for (Object obj2 : objArr) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
                SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) obj2, extras.getString(Command.FORMAT));
                String originatingAddress = createFromPdu.getOriginatingAddress();
                String displayMessageBody = createFromPdu.getDisplayMessageBody();
                if (originatingAddress != null) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    str = originatingAddress.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                } else {
                    str = "";
                }
                Intrinsics.checkNotNull(displayMessageBody);
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String lowerCase = displayMessageBody.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                List<String> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{str, lowerCase});
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                providerFactory.getNotificationCenter().handleNotification("msg", originatingAddress, displayMessageBody, DeviceNotification.SMS_RECEIVER_PACKAGE_NAME, providerFactory.getNotificationCenter().getNotificationGenerationId(), listOf);
            }
        } catch (Exception e) {
            Log.w(TAG, "Exception smsReceiver", e);
        }
    }
}

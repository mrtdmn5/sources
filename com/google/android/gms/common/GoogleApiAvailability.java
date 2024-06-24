package com.google.android.gms.common;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaf;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.internal.base.zae;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes3.dex */
public final class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new GoogleApiAvailability();

    public static AlertDialog zaa(Context context, int r6, zag zagVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (r6 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.zac.zad(context, r6));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zac = com.google.android.gms.common.internal.zac.zac(context, r6);
        if (zac != null) {
            builder.setPositiveButton(zac, zagVar);
        }
        String zag = com.google.android.gms.common.internal.zac.zag(context, r6);
        if (zag != null) {
            builder.setTitle(zag);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(r6)), new IllegalArgumentException());
        return builder.create();
    }

    public static void zad(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                if (alertDialog != null) {
                    alertDialog.setOnCancelListener(null);
                    alertDialog.setOnDismissListener(null);
                    supportErrorDialogFragment.zaa = alertDialog;
                    if (onCancelListener != null) {
                        supportErrorDialogFragment.zab = onCancelListener;
                    }
                    supportErrorDialogFragment.show(supportFragmentManager, str);
                    return;
                }
                throw new NullPointerException("Cannot display null dialog");
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            errorDialogFragment.zaa = alertDialog;
            if (onCancelListener != null) {
                errorDialogFragment.zab = onCancelListener;
            }
            errorDialogFragment.show(fragmentManager, str);
            return;
        }
        throw new NullPointerException("Cannot display null dialog");
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final Intent getErrorResolutionIntent(int r1, Context context, String str) {
        return super.getErrorResolutionIntent(r1, context, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final int isGooglePlayServicesAvailable(Context context, int r2) {
        return super.isGooglePlayServicesAvailable(context, r2);
    }

    public final void showErrorDialogFragment(Activity activity, int r4, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog zaa2 = zaa(activity, r4, new com.google.android.gms.common.internal.zad(activity, super.getErrorResolutionIntent(r4, activity, DateTimeFormattersKt.dayInMonthFormat)), onCancelListener);
        if (zaa2 == null) {
            return;
        }
        zad(activity, zaa2, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    @TargetApi(20)
    public final void zae(Context context, int r11, PendingIntent pendingIntent) {
        String zag;
        String zah;
        int r112;
        NotificationChannel notificationChannel;
        CharSequence name;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(r11), null), new IllegalArgumentException());
        if (r11 == 18) {
            new zac(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (r11 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        if (r11 == 6) {
            zag = com.google.android.gms.common.internal.zac.zai(context, "common_google_play_services_resolution_required_title");
        } else {
            zag = com.google.android.gms.common.internal.zac.zag(context, r11);
        }
        if (zag == null) {
            zag = context.getResources().getString(com.kronaby.watch.app.R.string.common_google_play_services_notification_ticker);
        }
        if (r11 != 6 && r11 != 19) {
            zah = com.google.android.gms.common.internal.zac.zad(context, r11);
        } else {
            zah = com.google.android.gms.common.internal.zac.zah(context, "common_google_play_services_resolution_required_text", com.google.android.gms.common.internal.zac.zaa(context));
        }
        Resources resources = context.getResources();
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Preconditions.checkNotNull(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
        notificationCompat$Builder.mLocalOnly = true;
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.setContentTitle(zag);
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.bigText(zah);
        notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
        if (DeviceProperties.isWearable(context)) {
            notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
            notificationCompat$Builder.mPriority = 2;
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                notificationCompat$Builder.addAction(com.kronaby.watch.app.R.drawable.common_full_open_on_phone, resources.getString(com.kronaby.watch.app.R.string.common_open_on_phone), pendingIntent);
            } else {
                notificationCompat$Builder.mContentIntent = pendingIntent;
            }
        } else {
            notificationCompat$Builder.mNotification.icon = R.drawable.stat_sys_warning;
            String string = resources.getString(com.kronaby.watch.app.R.string.common_google_play_services_notification_ticker);
            notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(string);
            notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
            notificationCompat$Builder.mContentIntent = pendingIntent;
            notificationCompat$Builder.setContentText(zah);
        }
        if (PlatformVersion.isAtLeastO()) {
            if (PlatformVersion.isAtLeastO()) {
                synchronized (zaa) {
                }
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string2 = context.getResources().getString(com.kronaby.watch.app.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(GoogleApiAvailability$$ExternalSyntheticApiModelOutline3.m(string2));
                } else {
                    name = notificationChannel.getName();
                    if (!string2.contentEquals(name)) {
                        notificationChannel.setName(string2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                notificationCompat$Builder.mChannelId = "com.google.android.gms.availability";
            } else {
                throw new IllegalStateException();
            }
        }
        Notification build = notificationCompat$Builder.build();
        if (r11 != 1 && r11 != 2 && r11 != 3) {
            r112 = 39789;
        } else {
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            r112 = 10436;
        }
        notificationManager.notify(r112, build);
    }

    public final void zag(Activity activity, LifecycleFragment lifecycleFragment, int r5, zap zapVar) {
        AlertDialog zaa2 = zaa(activity, r5, new zaf(super.getErrorResolutionIntent(r5, activity, DateTimeFormattersKt.dayInMonthFormat), lifecycleFragment), zapVar);
        if (zaa2 == null) {
            return;
        }
        zad(activity, zaa2, "GooglePlayServicesErrorDialog", zapVar);
    }
}

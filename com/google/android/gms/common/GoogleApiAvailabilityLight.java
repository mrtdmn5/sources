package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public class GoogleApiAvailabilityLight {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final GoogleApiAvailabilityLight zza;

    static {
        AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
        GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
        zza = new GoogleApiAvailabilityLight();
    }

    public Intent getErrorResolutionIntent(int r4, Context context, String str) {
        if (r4 != 1 && r4 != 2) {
            if (r4 != 3) {
                return null;
            }
            int r42 = com.google.android.gms.common.internal.zzt.$r8$clinit;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && DeviceProperties.isWearableWithoutPlayStore(context)) {
            int r43 = com.google.android.gms.common.internal.zzt.$r8$clinit;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.packageManager(context).getPackageInfo(0, context.getPackageName()).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb2 = sb.toString();
        int r5 = com.google.android.gms.common.internal.zzt.$r8$clinit;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(ConfigurationItem.COLUMN_NAME_ID, "com.google.android.gms");
        if (!TextUtils.isEmpty(sb2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public int isGooglePlayServicesAvailable(Context context, int r4) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, r4);
        boolean z = true;
        if (isGooglePlayServicesAvailable != 18) {
            if (isGooglePlayServicesAvailable == 1) {
                z = GooglePlayServicesUtilLight.zza(context);
            } else {
                z = false;
            }
        }
        if (z) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}

package com.amplifyframework.auth.cognito.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrowserHelper.kt */
/* loaded from: classes.dex */
public final class BrowserHelper {
    public static final BrowserHelper INSTANCE = new BrowserHelper();

    private BrowserHelper() {
    }

    private final List<String> getSupportedCustomTabsPackages(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        Intent action = new Intent().setAction("android.support.customtabs.action.CustomTabsService");
        Intrinsics.checkNotNullExpressionValue(action, "Intent().setAction(Custo…N_CUSTOM_TABS_CONNECTION)");
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(action, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentServices, "packageManager.queryInte…ervices(serviceIntent, 0)");
        List<ResolveInfo> list = queryIntentServices;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).serviceInfo.packageName);
        }
        return arrayList;
    }

    public final String getDefaultCustomTabPackage(Context context) {
        List<String> list;
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> supportedCustomTabsPackages = getSupportedCustomTabsPackages(context);
        if (!(!supportedCustomTabsPackages.isEmpty())) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (supportedCustomTabsPackages == null) {
            list = new ArrayList<>();
        } else {
            list = supportedCustomTabsPackages;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 0);
        if (resolveActivity != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList = new ArrayList(list.size() + 1);
            arrayList.add(str);
            if (supportedCustomTabsPackages != null) {
                arrayList.addAll(supportedCustomTabsPackages);
            }
            list = arrayList;
        }
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : list) {
            intent.setPackage(str2);
            if (packageManager.resolveService(intent, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    public final boolean isBrowserInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (new Intent("android.intent.action.VIEW", Uri.parse("https://docs.amplify.aws/")).resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }
}

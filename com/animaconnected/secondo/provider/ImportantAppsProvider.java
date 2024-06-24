package com.animaconnected.secondo.provider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.future.Future;
import com.animaconnected.future.runner.BackgroundRunner;
import com.animaconnected.future.runner.ParallelBackgroundRunner;
import com.animaconnected.secondo.BuildConfig;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImportantAppsProvider.kt */
/* loaded from: classes3.dex */
public final class ImportantAppsProvider {
    private static final float ICON_SIZE_FACTOR = 3.0f;
    private final Map<String, AppInfo> appInfoMap;
    private final Set<String> blockedPackageNames;
    private ArrayList<AppInfo> cachedAllAppItems;
    private final Object cachedAllAppItemsLock;
    private ArrayList<AppInfo> cachedFeaturedAppItems;
    private final Object cachedFeaturedAppItemsLock;
    private final Context context;
    private final Set<String> featuredPackageNames;
    private final PackageManager pm;
    private final Map<String, ResolveInfo> resolveInfoMapFeaturedApps;
    private final BackgroundRunner runner;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ImportantAppsProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$Apsa2AikKoaphx5wIq7RH9mbAew(ImportantAppsProvider importantAppsProvider) {
        buildUpCache$lambda$0(importantAppsProvider);
    }

    public ImportantAppsProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.featuredPackageNames = SetsKt__SetsKt.mutableSetOf("com.facebook.katana", "com.google.android.gm", "com.google.android.apps.inbox", "com.instagram.android", "com.skype.raider", "com.snapchat.android", "com.whatsapp", "com.linkedin.android", "com.facebook.orca", "com.Slack", "com.ebay.mobile", "com.twitter.android", "com.google.android.apps.fireball", "com.google.android.talk", "org.telegram.messenger", "com.microsoft.office.outlook", "se.parkster.client.android", "net.easypark.android", "com.parkme.consumer", "co.uk.ringgo.android", "se.appcorn.Blocket", "com.tradera", "se.footballaddicts.livescore", "com.tencent.mobileqq", "com.tencent.mm", "com.sina.weibo");
        this.blockedPackageNames = SetsKt__SetsKt.setOf(BuildConfig.APPLICATION_ID);
        this.context = context.getApplicationContext();
        this.runner = new ParallelBackgroundRunner();
        this.cachedFeaturedAppItemsLock = new Object();
        this.cachedAllAppItemsLock = new Object();
        this.appInfoMap = new HashMap();
        this.resolveInfoMapFeaturedApps = new HashMap();
        this.pm = context.getPackageManager();
    }

    public static final void buildUpCache$lambda$0(ImportantAppsProvider this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fetchFeaturedInstalledApps$default(this$0, false, null, 2, null);
        fetchAllInstalledApps$default(this$0, false, null, 2, null);
    }

    private final Drawable createScaledIconDrawable(Drawable drawable) {
        Bitmap bitmap;
        int r0 = (int) (this.context.getResources().getDisplayMetrics().densityDpi / ICON_SIZE_FACTOR);
        if (drawable instanceof BitmapDrawable) {
            bitmap = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), r0, r0, false);
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            drawable.setBounds(0, 0, r0, r0);
            drawable.draw(new Canvas(createBitmap));
            bitmap = createBitmap;
        }
        Intrinsics.checkNotNull(bitmap);
        return new BitmapDrawable(this.context.getResources(), bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Future fetchAllInstalledApps$default(ImportantAppsProvider importantAppsProvider, Set set, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            set = EmptySet.INSTANCE;
        }
        return importantAppsProvider.fetchAllInstalledApps(set);
    }

    public static final List fetchAllInstalledApps$lambda$13(ImportantAppsProvider this$0, boolean z, Set ignoredPackages) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ignoredPackages, "$ignoredPackages");
        synchronized (this$0.cachedAllAppItemsLock) {
            if (this$0.cachedAllAppItems == null || !z) {
                List<ResolveInfo> allResolveInfo = this$0.getAllResolveInfo();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = allResolveInfo.iterator();
                while (it.hasNext()) {
                    AppInfo appInfo = this$0.toAppInfo((ResolveInfo) it.next());
                    if (appInfo != null) {
                        arrayList.add(appInfo);
                    }
                }
                ArrayList<AppInfo> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!this$0.blockedPackageNames.contains(((AppInfo) obj).getPackageName())) {
                        arrayList2.add(obj);
                    }
                }
                for (AppInfo appInfo2 : arrayList2) {
                    this$0.appInfoMap.put(appInfo2.getPackageName(), appInfo2);
                }
                this$0.cachedAllAppItems = new ArrayList<>(arrayList2);
            }
            Unit unit = Unit.INSTANCE;
        }
        ArrayList<AppInfo> arrayList3 = this$0.cachedAllAppItems;
        if (arrayList3 != null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (!ignoredPackages.contains(((AppInfo) obj2).getPackageName())) {
                    arrayList4.add(obj2);
                }
            }
            return arrayList4;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Future fetchFeaturedInstalledApps$default(ImportantAppsProvider importantAppsProvider, Set set, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            set = EmptySet.INSTANCE;
        }
        return importantAppsProvider.fetchFeaturedInstalledApps(set);
    }

    public static final List fetchFeaturedInstalledApps$lambda$7(ImportantAppsProvider this$0, boolean z, Set ignoredPackages) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ignoredPackages, "$ignoredPackages");
        synchronized (this$0.cachedFeaturedAppItemsLock) {
            if (this$0.cachedFeaturedAppItems == null || !z) {
                List<ResolveInfo> allResolveInfo = this$0.getAllResolveInfo();
                ArrayList<ResolveInfo> arrayList = new ArrayList();
                for (Object obj : allResolveInfo) {
                    if (this$0.featuredPackageNames.contains(((ResolveInfo) obj).activityInfo.packageName)) {
                        arrayList.add(obj);
                    }
                }
                for (ResolveInfo resolveInfo : arrayList) {
                    Map<String, ResolveInfo> map = this$0.resolveInfoMapFeaturedApps;
                    String packageName = resolveInfo.activityInfo.packageName;
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    map.put(packageName, resolveInfo);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AppInfo appInfo = this$0.toAppInfo((ResolveInfo) it.next());
                    if (appInfo != null) {
                        arrayList2.add(appInfo);
                    }
                }
                this$0.cachedFeaturedAppItems = new ArrayList<>(arrayList2);
            }
            Unit unit = Unit.INSTANCE;
        }
        ArrayList<AppInfo> arrayList3 = this$0.cachedFeaturedAppItems;
        if (arrayList3 != null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (!ignoredPackages.contains(((AppInfo) obj2).getPackageName())) {
                    arrayList4.add(obj2);
                }
            }
            return arrayList4;
        }
        return null;
    }

    private final void fetchMorePackageNames() {
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String[] extraApps = companion.getInstance(context).getImportantAppConfig().getExtraApps();
        if (extraApps == null) {
            return;
        }
        Collections.addAll(this.featuredPackageNames, Arrays.copyOf(extraApps, extraApps.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getAllInstalledAppsCache$default(ImportantAppsProvider importantAppsProvider, Set set, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            set = EmptySet.INSTANCE;
        }
        return importantAppsProvider.getAllInstalledAppsCache(set);
    }

    private final List<ResolveInfo> getAllResolveInfo() {
        PackageManager packageManager = this.context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "queryIntentActivities(...)");
        return CollectionsKt___CollectionsKt.sortedWith(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
    }

    private final AppInfo toAppInfo(ResolveInfo resolveInfo) {
        ApplicationInfo applicationInfo;
        Drawable applicationIcon;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (activityInfo == null || (applicationInfo = activityInfo.applicationInfo) == null) {
            return null;
        }
        try {
            Resources resourcesForApplication = this.pm.getResourcesForApplication(applicationInfo);
            Intrinsics.checkNotNull(resourcesForApplication);
            try {
                applicationIcon = resourcesForApplication.getDrawableForDensity(applicationInfo.icon, this.context.getResources().getDisplayMetrics().densityDpi, null);
                Intrinsics.checkNotNull(applicationIcon);
            } catch (Exception unused) {
                applicationIcon = this.pm.getApplicationIcon(applicationInfo);
            }
            Intrinsics.checkNotNull(applicationIcon);
            Drawable createScaledIconDrawable = createScaledIconDrawable(applicationIcon);
            String str = "" + ((Object) resolveInfo.loadLabel(this.pm));
            String packageName = applicationInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            return new AppInfo(str, packageName, createScaledIconDrawable, true);
        } catch (PackageManager.NameNotFoundException unused2) {
            return null;
        }
    }

    public final void buildUpCache(long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new ImportantAppsProvider$$ExternalSyntheticLambda2(0, this), j);
    }

    public final Future<List<AppInfo>> fetchAllInstalledApps(Set<String> ignoredPackages) {
        Intrinsics.checkNotNullParameter(ignoredPackages, "ignoredPackages");
        return fetchAllInstalledApps(true, ignoredPackages);
    }

    public final Future<List<AppInfo>> fetchFeaturedInstalledApps(Set<String> ignoredPackages) {
        Intrinsics.checkNotNullParameter(ignoredPackages, "ignoredPackages");
        return fetchFeaturedInstalledApps(true, ignoredPackages);
    }

    public final List<AppInfo> getAllInstalledAppsCache(Set<String> ignoredPackages) {
        Intrinsics.checkNotNullParameter(ignoredPackages, "ignoredPackages");
        ArrayList<AppInfo> arrayList = this.cachedAllAppItems;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!ignoredPackages.contains(((AppInfo) obj).getPackageName())) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public final AppInfo getAppInfo(String packageName) {
        ResolveInfo resolveInfo;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        AppInfo appInfo = this.appInfoMap.get(packageName);
        if (appInfo != null) {
            return appInfo;
        }
        ResolveInfo resolveInfo2 = this.resolveInfoMapFeaturedApps.get(packageName);
        if (resolveInfo2 == null) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "queryIntentActivities(...)");
            Iterator it = queryIntentActivities.iterator();
            while (true) {
                if (it.hasNext()) {
                    resolveInfo = it.next();
                    if (Intrinsics.areEqual(((ResolveInfo) resolveInfo).activityInfo.packageName, packageName)) {
                        break;
                    }
                } else {
                    resolveInfo = 0;
                    break;
                }
            }
            resolveInfo2 = resolveInfo;
            if (resolveInfo2 == null) {
                return null;
            }
            Map<String, ResolveInfo> map = this.resolveInfoMapFeaturedApps;
            String packageName2 = resolveInfo2.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName2, "packageName");
            map.put(packageName2, resolveInfo2);
        }
        AppInfo appInfo2 = toAppInfo(resolveInfo2);
        if (appInfo2 == null) {
            return null;
        }
        this.appInfoMap.put(packageName, appInfo2);
        return appInfo2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Future fetchAllInstalledApps$default(ImportantAppsProvider importantAppsProvider, boolean z, Set set, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            z = true;
        }
        if ((r3 & 2) != 0) {
            set = EmptySet.INSTANCE;
        }
        return importantAppsProvider.fetchAllInstalledApps(z, set);
    }

    private final Future<List<AppInfo>> fetchFeaturedInstalledApps(final boolean z, final Set<String> set) {
        int size = this.featuredPackageNames.size();
        fetchMorePackageNames();
        if (size != this.featuredPackageNames.size()) {
            z = false;
        }
        Future<List<AppInfo>> submit = this.runner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.ImportantAppsProvider$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List fetchFeaturedInstalledApps$lambda$7;
                fetchFeaturedInstalledApps$lambda$7 = ImportantAppsProvider.fetchFeaturedInstalledApps$lambda$7(ImportantAppsProvider.this, z, set);
                return fetchFeaturedInstalledApps$lambda$7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        return submit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Future fetchFeaturedInstalledApps$default(ImportantAppsProvider importantAppsProvider, boolean z, Set set, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            set = EmptySet.INSTANCE;
        }
        return importantAppsProvider.fetchFeaturedInstalledApps(z, set);
    }

    public final Future<List<AppInfo>> fetchAllInstalledApps(final boolean z, final Set<String> ignoredPackages) {
        Intrinsics.checkNotNullParameter(ignoredPackages, "ignoredPackages");
        Future<List<AppInfo>> submit = this.runner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.ImportantAppsProvider$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List fetchAllInstalledApps$lambda$13;
                fetchAllInstalledApps$lambda$13 = ImportantAppsProvider.fetchAllInstalledApps$lambda$13(ImportantAppsProvider.this, z, ignoredPackages);
                return fetchAllInstalledApps$lambda$13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        return submit;
    }
}

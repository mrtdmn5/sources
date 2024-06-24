package com.animaconnected.secondo.provider.analytics;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.DeviceInformation;
import com.animaconnected.watch.SharedPreferencesCache;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.storage.models.DBWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchProviderAnalytics.kt */
/* loaded from: classes3.dex */
public final class WatchProviderAnalytics {
    public static final void sendDevicesAnalytics(WatchProvider watchProvider, Context context) {
        String device_address;
        Map<DeviceInfo, String> legacyInformation;
        Intrinsics.checkNotNullParameter(watchProvider, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        DBWatch currentWatch = watchProvider.getDb().getCurrentWatch();
        if (currentWatch == null) {
            ProviderFactory.getAppAnalytics().sendDevices(EmptyList.INSTANCE);
            return;
        }
        List<DBWatch> allWatches = watchProvider.getDb().getAllWatches();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(allWatches, 10));
        for (DBWatch dBWatch : allWatches) {
            DeviceInformation readFromCache = DeviceInformation.Companion.readFromCache(new SharedPreferencesCache(context, dBWatch.getDevice_address()));
            if (readFromCache == null || (legacyInformation = readFromCache.getLegacyInformation(dBWatch.getDevice_address())) == null || (device_address = legacyInformation.get(DeviceInfo.SerialNumber)) == null) {
                device_address = dBWatch.getDevice_address();
            }
            arrayList.add(new AppEvents.Device(ConstraintSet$$ExternalSyntheticOutline0.m("sn_", device_address), Intrinsics.areEqual(currentWatch.getDevice_address(), dBWatch.getDevice_address())));
        }
        ProviderFactory.getAppAnalytics().sendDevices(arrayList);
    }
}

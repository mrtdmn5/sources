package com.animaconnected.secondo.screens.onboarding;

import android.content.SharedPreferences;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WhatsNewStorage.kt */
/* loaded from: classes3.dex */
public final class WhatsNewStorage {
    private static final String key = "shownForVersion:0";
    public static final WhatsNewStorage INSTANCE = new WhatsNewStorage();
    private static final SharedPreferences preferences = KronabyApplication.Companion.getContext().getSharedPreferences("whats_new_pref_file", 0);
    public static final int $stable = 8;

    private WhatsNewStorage() {
    }

    private final List<WhatsNewUiItem> filterForCurrentWatch(List<WhatsNewInfo> list) {
        ArrayList<WhatsNewInfo> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((WhatsNewInfo) obj).getCanShowUpdate().invoke().booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        for (WhatsNewInfo whatsNewInfo : arrayList) {
            arrayList2.add(new WhatsNewUiItem(whatsNewInfo.getTitle(), whatsNewInfo.getDescription()));
        }
        return arrayList2;
    }

    public final List<WhatsNewUiItem> getFeatures() {
        return filterForCurrentWatch(WhatsNewFeatures.INSTANCE.getLatestFeatures());
    }

    public final boolean isSeenBefore() {
        return preferences.getBoolean(key, false);
    }

    public final void setSeenBefore(boolean z) {
        SharedPreferences preferences2 = preferences;
        Intrinsics.checkNotNullExpressionValue(preferences2, "preferences");
        SharedPreferences.Editor edit = preferences2.edit();
        edit.putBoolean(key, z);
        edit.apply();
    }

    public final boolean showWhatsNew() {
        if (ProviderFactory.getWatch().isOnboardingFinished() && !isSeenBefore() && (!getFeatures().isEmpty())) {
            return true;
        }
        return false;
    }
}

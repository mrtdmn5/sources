package com.animaconnected.secondo.provider;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModelFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksProvider.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksProvider {
    public static final TipsAndTricksProvider INSTANCE = new TipsAndTricksProvider();
    private static final Lazy tipsAndTricksModels$delegate = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends TipsAndTricksModel>>() { // from class: com.animaconnected.secondo.provider.TipsAndTricksProvider$tipsAndTricksModels$2
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends TipsAndTricksModel> invoke() {
            List<? extends TipsAndTricksModel> initTipsAndTricksModel;
            initTipsAndTricksModel = TipsAndTricksProvider.INSTANCE.initTipsAndTricksModel();
            return initTipsAndTricksModel;
        }
    });
    private static final Lazy tipsAndTricksModelsPascal$delegate = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends TipsAndTricksModel>>() { // from class: com.animaconnected.secondo.provider.TipsAndTricksProvider$tipsAndTricksModelsPascal$2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends TipsAndTricksModel> invoke() {
            List<Pair> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(TipsAndTricksConstants.SHORTCUT_PASCAL_NAME, LottieFile.TrixShortcutPascal), new Pair(TipsAndTricksConstants.NOTIFICATIONS_PASCAL_NAME, LottieFile.TrixNotificationsPascal), new Pair(TipsAndTricksConstants.WEAR_WATCH_PASCAL_NAME, LottieFile.TrixWearWatchPascal), new Pair(TipsAndTricksConstants.LOST_WATCH_PASCAL_NAME, LottieFile.TrixLostWatchPascal), new Pair(TipsAndTricksConstants.FAQ_PASCAL_NAME, LottieFile.TrixFaqPascal), new Pair(TipsAndTricksConstants.NEW_PHONE_PASCAL_NAME, LottieFile.TrixNewPhonePascal)});
            ArrayList arrayList = new ArrayList();
            for (Pair pair : listOf) {
                TipsAndTricksModel create = TipsAndTricksModelFactory.INSTANCE.create((String) pair.first, KronabyApplication.Companion.getContext(), (LottieFile) pair.second);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return arrayList;
        }
    });
    public static final int $stable = 8;

    private TipsAndTricksProvider() {
    }

    public static final List<TipsAndTricksModel> getTipsAndTricksModels() {
        return (List) tipsAndTricksModels$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<TipsAndTricksModel> initTipsAndTricksModel() {
        Pair[] pairArr = {new Pair(TipsAndTricksConstants.REJECT_CALL_NAME, LottieFile.TrixRejectCall), new Pair(TipsAndTricksConstants.MUTE_PHONE_NAME, LottieFile.TrixMuteUnmute), new Pair(TipsAndTricksConstants.MUSIC_NEXT_NAME, LottieFile.TrixMusicSkipTracks), new Pair(TipsAndTricksConstants.LINK_NAME, LottieFile.TrixHowto), new Pair(TipsAndTricksConstants.LOST_WATCH_NAME, LottieFile.TrixLostwatch), new Pair(TipsAndTricksConstants.FIND_PHONE_NAME, LottieFile.TrixFindPhone), new Pair(TipsAndTricksConstants.MUSIC_VOLUME_NAME, LottieFile.TrixMusicVolume), new Pair(TipsAndTricksConstants.FORGET_WATCH_NAME, LottieFile.TrixForgetWatch)};
        HashMap hashMap = new HashMap(MapsKt__MapsJVMKt.mapCapacity(8));
        MapsKt__MapsKt.putAll(hashMap, pairArr);
        Context context = KronabyApplication.Companion.getContext();
        Collection values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        LottieFile[] lottieFileArr = (LottieFile[]) values.toArray(new LottieFile[0]);
        Lottie.loadAnimation(context, (LottieFile[]) Arrays.copyOf(lottieFileArr, lottieFileArr.length));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            TipsAndTricksModel create = TipsAndTricksModelFactory.INSTANCE.create((String) entry.getKey(), KronabyApplication.Companion.getContext(), (LottieFile) entry.getValue());
            if (create != null) {
                arrayList.add(create);
            }
        }
        final TipsAndTricksProvider$initTipsAndTricksModel$2 tipsAndTricksProvider$initTipsAndTricksModel$2 = new Function2<TipsAndTricksModel, TipsAndTricksModel, Integer>() { // from class: com.animaconnected.secondo.provider.TipsAndTricksProvider$initTipsAndTricksModel$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(TipsAndTricksModel lhs, TipsAndTricksModel rhs) {
                Intrinsics.checkNotNullParameter(lhs, "lhs");
                Intrinsics.checkNotNullParameter(rhs, "rhs");
                return Integer.valueOf(Intrinsics.compare(rhs.getPriority(), lhs.getPriority()));
            }
        };
        return CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.secondo.provider.TipsAndTricksProvider$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int initTipsAndTricksModel$lambda$1;
                initTipsAndTricksModel$lambda$1 = TipsAndTricksProvider.initTipsAndTricksModel$lambda$1(Function2.this, obj, obj2);
                return initTipsAndTricksModel$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int initTipsAndTricksModel$lambda$1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public final List<TipsAndTricksModel> getTipsAndTricksModelsPascal() {
        return (List) tipsAndTricksModelsPascal$delegate.getValue();
    }

    public static /* synthetic */ void getTipsAndTricksModels$annotations() {
    }
}

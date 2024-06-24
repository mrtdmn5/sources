package com.animaconnected.secondo.screens.tipsandtricks;

import android.content.Context;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.watch.CallHelper;
import com.animaconnected.watch.HybridWatch;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksModelFactory.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksModelFactory {
    public static final int $stable = 0;
    public static final TipsAndTricksModelFactory INSTANCE = new TipsAndTricksModelFactory();

    private TipsAndTricksModelFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001d. Please report as an issue. */
    public final TipsAndTricksModel create(final String tipsAndTricksName, Context context, final LottieFile lottieFile) {
        TipsAndTricksModel tipsAndTricksModel;
        int r13;
        int r0;
        int r1;
        Intrinsics.checkNotNullParameter(tipsAndTricksName, "tipsAndTricksName");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        int hashCode = tipsAndTricksName.hashCode();
        Integer valueOf = Integer.valueOf(R.string.tips_and_tricks_forget_watch_description_short);
        switch (hashCode) {
            case -1901038952:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.MUSIC_NEXT_NAME)) {
                    return new TipsAndTricksTextAnimationModel(tipsAndTricksName, 200, R.string.tips_and_tricks_music_next_title, R.string.tips_and_tricks_music_next_description_long, null, lottieFile, 0.5f, R.string.tips_and_tricks_music_next_description_short_1, R.string.tips_and_tricks_music_next_description_short_2);
                }
                return null;
            case -1875107051:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.FIND_PHONE_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, TipsAndTricksConstants.FIND_PHONE_PRIORITY, R.string.tips_and_tricks_find_phone_title, R.string.tips_and_tricks_find_phone_description_long, Integer.valueOf(R.string.tips_and_tricks_find_phone_description_short), null, lottieFile);
                }
                return null;
            case -1656093717:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.LOST_WATCH_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, lottieFile) { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModelFactory$create$1
                        {
                            Integer valueOf2 = Integer.valueOf(R.string.tips_and_tricks_lost_watch_description_short);
                        }

                        @Override // com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel
                        public boolean isCompatibleToBeShown() {
                            return ProviderFactory.getLostWatchProvider().isEnabled();
                        }
                    };
                }
                return null;
            case -1652958886:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.NEW_PHONE_PASCAL_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_forget_watch_title, R.string.tips_and_tricks_forget_watch_description_long, valueOf, null, lottieFile);
                }
                return null;
            case -1299416705:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.MUSIC_VOLUME_NAME)) {
                    return new TipsAndTricksTextAnimationModel(tipsAndTricksName, 400, R.string.tips_and_tricks_music_volume_title, R.string.tips_and_tricks_music_volume_description_long, null, lottieFile, 0.5f, R.string.tips_and_tricks_music_volume_description_short_1, R.string.tips_and_tricks_music_volume_description_short_2);
                }
                return null;
            case -1144814923:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.MUTE_PHONE_NAME)) {
                    return new TipsAndTricksTextAnimationModel(tipsAndTricksName, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, R.string.tips_and_tricks_mute_phone_title, R.string.tips_and_tricks_mute_phone_description_long, null, lottieFile, 0.5f, R.string.tips_and_tricks_mute_phone_description_short_1, R.string.tips_and_tricks_mute_phone_description_short_2);
                }
                return null;
            case -871613454:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.SHORTCUT_PASCAL_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_pascal_access_the_actions_title, R.string.tips_and_tricks_pascal_access_the_actions_body, null, null, lottieFile);
                }
                return null;
            case -840661065:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.LOST_WATCH_PASCAL_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_lost_watch_title, R.string.tips_and_tricks_lost_watch_description_long, Integer.valueOf(R.string.tips_and_tricks_lost_watch_description_short), null, lottieFile);
                }
                return null;
            case 2368538:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.LINK_NAME)) {
                    final String string = context.getString(R.string.faq_uri);
                    tipsAndTricksModel = new TipsAndTricksModel(tipsAndTricksName, lottieFile, string) { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModelFactory$create$2
                        {
                            Integer valueOf2 = Integer.valueOf(R.string.tips_and_tricks_link_description_short);
                        }

                        @Override // com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel
                        public boolean isCompatibleToBeShown() {
                            return ProviderFactory.getWatch().getWatch() instanceof HybridWatch;
                        }
                    };
                    return tipsAndTricksModel;
                }
                return null;
            case 51279996:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.WEAR_WATCH_PASCAL_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_pascal_wearing_the_watch_title, R.string.tips_and_tricks_pascal_wearing_the_watch_body, null, null, lottieFile);
                }
                return null;
            case 506644162:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.FORGET_WATCH_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 100, R.string.tips_and_tricks_forget_watch_title, R.string.tips_and_tricks_forget_watch_description_long, valueOf, null, lottieFile);
                }
                return null;
            case 902553218:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.FAQ_PASCAL_NAME)) {
                    tipsAndTricksModel = new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_link_title, R.string.tips_and_tricks_link_description_long, Integer.valueOf(R.string.tips_and_tricks_link_description_short), context.getString(R.string.faq_uri), lottieFile);
                    return tipsAndTricksModel;
                }
                return null;
            case 1342854845:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.REJECT_CALL_NAME)) {
                    if (CallHelper.shouldMuteCalls()) {
                        r13 = R.string.tips_and_tricks_mute_call_title;
                        r0 = R.string.tips_and_tricks_mute_call_description_long;
                        r1 = R.string.tips_and_tricks_mute_call_description_short;
                    } else {
                        r13 = R.string.tips_and_tricks_reject_call_title;
                        r0 = R.string.tips_and_tricks_reject_call_description_long;
                        r1 = R.string.tips_and_tricks_reject_call_description_short;
                    }
                    return new TipsAndTricksModel(tipsAndTricksName, TipsAndTricksConstants.REJECT_CALL_PRIORITY, r13, r0, Integer.valueOf(r1), null, lottieFile);
                }
                return null;
            case 1996582612:
                if (tipsAndTricksName.equals(TipsAndTricksConstants.NOTIFICATIONS_PASCAL_NAME)) {
                    return new TipsAndTricksModel(tipsAndTricksName, 0, R.string.tips_and_tricks_pascal_filter_notifications_title, R.string.tips_and_tricks_pascal_filter_notifications_body, null, null, lottieFile);
                }
                return null;
            default:
                return null;
        }
    }
}

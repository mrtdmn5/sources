package com.animaconnected.secondo.provider.labs;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabsStorage.kt */
/* loaded from: classes3.dex */
public final class LabsStorage {
    private static final String INITIAL_LABS_STORAGE = "initialLabsStorage";
    private static final String KEY_ENABLED_MORE_NUMBERS = "filterNotificationsMoreNumbers";
    private static final String KEY_JOINED_LABS = "joinedLabs";
    private static final String KEY_RATING_LAST_SENT_PREFIX = "rating-last-sent-";
    private static final String KEY_RATING_PREFIX = "rating-";
    private final SharedPreferences prefs;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LabsStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LabsStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(INITIAL_LABS_STORAGE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
    }

    public final int getBehaviourRating(String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        return this.prefs.getInt(KEY_RATING_PREFIX.concat(behaviourType), 0);
    }

    public final int getBehaviourRatingLastSent(String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        return this.prefs.getInt(KEY_RATING_LAST_SENT_PREFIX.concat(behaviourType), 0);
    }

    public final boolean getJoinedLabs() {
        return this.prefs.getBoolean(KEY_JOINED_LABS, false);
    }

    public final boolean hasBehaviourRating(String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        return this.prefs.contains(KEY_RATING_PREFIX.concat(behaviourType));
    }

    public final boolean isMoreNumbersEnabled() {
        return this.prefs.getBoolean(KEY_ENABLED_MORE_NUMBERS, false);
    }

    public final void setBehaviourRating(String behaviourType, int r4) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        this.prefs.edit().putInt(KEY_RATING_PREFIX.concat(behaviourType), r4).apply();
    }

    public final void setBehaviourRatingLastSent(String behaviourType, int r4) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        this.prefs.edit().putInt(KEY_RATING_LAST_SENT_PREFIX.concat(behaviourType), r4).apply();
    }

    public final void setJoinedLabs(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.prefs, KEY_JOINED_LABS, z);
    }

    public final void setMoreNumbersEnabled(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.prefs, KEY_ENABLED_MORE_NUMBERS, z);
    }
}

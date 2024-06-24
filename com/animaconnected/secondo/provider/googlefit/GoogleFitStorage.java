package com.animaconnected.secondo.provider.googlefit;

import android.content.SharedPreferences;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.fitness.TimePeriod;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: GoogleFitStorage.kt */
/* loaded from: classes3.dex */
public final class GoogleFitStorage {
    public static final int $stable = 8;
    private final SharedPreferences persistence = KronabyApplication.Companion.getContext().getSharedPreferences("GoogleFitStorage", 0);

    private final Instant getInstant(SharedPreferences sharedPreferences, String str) {
        long j = sharedPreferences.getLong(str, 0L);
        if (j == 0) {
            return TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null).getStart();
        }
        Instant.Companion.getClass();
        return Instant.Companion.fromEpochMilliseconds(j);
    }

    private final void putInstant(SharedPreferences sharedPreferences, String str, Instant instant) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, instant.toEpochMilliseconds());
        edit.apply();
    }

    public final Instant getLastCalorieUpload() {
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        return getInstant(persistence, "lastCaloriesUpload");
    }

    public final Instant getLastHeartRateUpload() {
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        return getInstant(persistence, "lastHeartRateUpload");
    }

    public final Instant getLastStepsUpload() {
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        return getInstant(persistence, "lastStepsUpload");
    }

    public final void setLastCalorieUpload(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        putInstant(persistence, "lastCaloriesUpload", instant);
    }

    public final void setLastHeartRateUpload(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        putInstant(persistence, "lastHeartRateUpload", instant);
    }

    public final void setLastStepsUpload(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        SharedPreferences persistence = this.persistence;
        Intrinsics.checkNotNullExpressionValue(persistence, "persistence");
        putInstant(persistence, "lastStepsUpload", instant);
    }
}

package com.animaconnected.watch.account.fitness;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: FitnessCloudSyncApi.kt */
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApiKt {
    public static final String toDateString(FitnessFile fitnessFile) {
        Intrinsics.checkNotNullParameter(fitnessFile, "<this>");
        return toDateString(fitnessFile.getTimestamp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDateString(long j) {
        Instant.Companion.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(j);
        TimeZone.Companion.getClass();
        return StringsKt__StringsKt.substringBefore$default(TimeZoneKt.toLocalDateTime(fromEpochMilliseconds, TimeZone.UTC).toString(), "T");
    }
}

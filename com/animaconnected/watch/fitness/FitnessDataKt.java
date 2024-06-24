package com.animaconnected.watch.fitness;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.watch.fitness.HealthGoals;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class FitnessDataKt {
    public static final long legacySessionEntrySessionId = -1;
    public static final String oldJsonNameForHistoryDeviceId = "identifier";

    /* renamed from: default, reason: not valid java name */
    public static final HealthGoals m1223default(HealthGoals.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new HealthGoals(Constants.MAXIMUM_UPLOAD_PARTS, 8, 30);
    }
}

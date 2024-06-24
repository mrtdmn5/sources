package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.behaviour.workout.Workout;
import com.animaconnected.watch.fitness.SessionType;
import io.ktor.http.HttpStatusCode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StravaClient.kt */
/* loaded from: classes3.dex */
public final class StravaClientKt {

    /* compiled from: StravaClient.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Bike.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Running.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isServerError(HttpStatusCode httpStatusCode) {
        int r2 = httpStatusCode.value;
        if (500 > r2 || r2 >= 600) {
            return false;
        }
        return true;
    }

    public static final String toStravaType(SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "<this>");
        int r1 = WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    if (r1 == 4) {
                        return Workout.TYPE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "Walk";
            }
            return "Run";
        }
        return "Ride";
    }
}

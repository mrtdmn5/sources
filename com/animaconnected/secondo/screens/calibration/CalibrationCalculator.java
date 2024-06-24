package com.animaconnected.secondo.screens.calibration;

import android.util.Log;
import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.WatchFace;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalibrationCalculator.kt */
/* loaded from: classes3.dex */
public final class CalibrationCalculator {
    private static final double WHEEL_TO_CLOCK_TURNS = 3.0d;
    private double angleDiff;
    private CalibrationState calibrationState;
    private boolean hasSent;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "CalibrationCalculator";

    /* compiled from: CalibrationCalculator.kt */
    /* loaded from: classes3.dex */
    public static final class CalibrationState {
        public static final int $stable = 0;
        private final int hand;
        private final float speedMultiplier;
        private final WatchFace watchFace;

        public CalibrationState(WatchFace watchFace, int r3, float f) {
            Intrinsics.checkNotNullParameter(watchFace, "watchFace");
            this.watchFace = watchFace;
            this.hand = r3;
            this.speedMultiplier = f;
        }

        public static /* synthetic */ CalibrationState copy$default(CalibrationState calibrationState, WatchFace watchFace, int r2, float f, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                watchFace = calibrationState.watchFace;
            }
            if ((r4 & 2) != 0) {
                r2 = calibrationState.hand;
            }
            if ((r4 & 4) != 0) {
                f = calibrationState.speedMultiplier;
            }
            return calibrationState.copy(watchFace, r2, f);
        }

        public final WatchFace component1() {
            return this.watchFace;
        }

        public final int component2() {
            return this.hand;
        }

        public final float component3() {
            return this.speedMultiplier;
        }

        public final CalibrationState copy(WatchFace watchFace, int r3, float f) {
            Intrinsics.checkNotNullParameter(watchFace, "watchFace");
            return new CalibrationState(watchFace, r3, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalibrationState)) {
                return false;
            }
            CalibrationState calibrationState = (CalibrationState) obj;
            if (this.watchFace == calibrationState.watchFace && this.hand == calibrationState.hand && Float.compare(this.speedMultiplier, calibrationState.speedMultiplier) == 0) {
                return true;
            }
            return false;
        }

        public final int getHand() {
            return this.hand;
        }

        public final float getSpeedMultiplier() {
            return this.speedMultiplier;
        }

        public final WatchFace getWatchFace() {
            return this.watchFace;
        }

        public int hashCode() {
            return Float.hashCode(this.speedMultiplier) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.hand, this.watchFace.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CalibrationState(watchFace=");
            sb.append(this.watchFace);
            sb.append(", hand=");
            sb.append(this.hand);
            sb.append(", speedMultiplier=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.speedMultiplier, ')');
        }
    }

    /* compiled from: CalibrationCalculator.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final double getNewCalibrationFromAngle(double d) {
        float f;
        double d2 = (d * 28.64788975654116d) / WHEEL_TO_CLOCK_TURNS;
        CalibrationState calibrationState = this.calibrationState;
        if (calibrationState != null) {
            f = calibrationState.getSpeedMultiplier();
        } else {
            f = 0.0f;
        }
        return d2 * f;
    }

    private final void sendCalibrationIfReady() {
        double d;
        int r2;
        CalibrationState calibrationState;
        if (this.hasSent || (r2 = (int) (d = this.angleDiff)) == 0 || (calibrationState = this.calibrationState) == null) {
            return;
        }
        this.angleDiff = d - r2;
        this.hasSent = true;
        ProviderFactory.getWatch().makeNewCalibration(calibrationState.getWatchFace(), calibrationState.getHand(), r2).fail(new CalibrationCalculator$$ExternalSyntheticLambda0()).always(new AlwaysCallback() { // from class: com.animaconnected.secondo.screens.calibration.CalibrationCalculator$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                CalibrationCalculator.sendCalibrationIfReady$lambda$1(CalibrationCalculator.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendCalibrationIfReady$lambda$0(Throwable th) {
        Log.d(TAG, "Unsuccessfully sent new angle to new calibration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendCalibrationIfReady$lambda$1(CalibrationCalculator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasSent = false;
        this$0.sendCalibrationIfReady();
    }

    public final void onNewAngle(double d) {
        this.angleDiff += getNewCalibrationFromAngle(d);
        sendCalibrationIfReady();
    }

    public final void setNewCalibrationState(WatchFace watchFace, int r3, float f) {
        Intrinsics.checkNotNullParameter(watchFace, "watchFace");
        this.calibrationState = new CalibrationState(watchFace, r3, f);
    }
}

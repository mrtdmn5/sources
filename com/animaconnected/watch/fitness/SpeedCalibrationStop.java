package com.animaconnected.watch.fitness;

import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SpeedCalibrationStop extends SpeedCalibration {
    private final int distance;
    private final double gpsMeanError;
    private final double gpsStdError;

    public SpeedCalibrationStop(int r3, double d, double d2) {
        super(1, null);
        this.distance = r3;
        this.gpsMeanError = d;
        this.gpsStdError = d2;
    }

    public static /* synthetic */ SpeedCalibrationStop copy$default(SpeedCalibrationStop speedCalibrationStop, int r3, double d, double d2, int r8, Object obj) {
        if ((r8 & 1) != 0) {
            r3 = speedCalibrationStop.distance;
        }
        if ((r8 & 2) != 0) {
            d = speedCalibrationStop.gpsMeanError;
        }
        double d3 = d;
        if ((r8 & 4) != 0) {
            d2 = speedCalibrationStop.gpsStdError;
        }
        return speedCalibrationStop.copy(r3, d3, d2);
    }

    public final int component1() {
        return this.distance;
    }

    public final double component2() {
        return this.gpsMeanError;
    }

    public final double component3() {
        return this.gpsStdError;
    }

    public final SpeedCalibrationStop copy(int r8, double d, double d2) {
        return new SpeedCalibrationStop(r8, d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedCalibrationStop)) {
            return false;
        }
        SpeedCalibrationStop speedCalibrationStop = (SpeedCalibrationStop) obj;
        if (this.distance == speedCalibrationStop.distance && Double.compare(this.gpsMeanError, speedCalibrationStop.gpsMeanError) == 0 && Double.compare(this.gpsStdError, speedCalibrationStop.gpsStdError) == 0) {
            return true;
        }
        return false;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final double getGpsMeanError() {
        return this.gpsMeanError;
    }

    public final double getGpsStdError() {
        return this.gpsStdError;
    }

    public int hashCode() {
        return Double.hashCode(this.gpsStdError) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.gpsMeanError, Integer.hashCode(this.distance) * 31, 31);
    }

    public String toString() {
        return "SpeedCalibrationStop(distance=" + this.distance + ", gpsMeanError=" + this.gpsMeanError + ", gpsStdError=" + this.gpsStdError + ')';
    }
}

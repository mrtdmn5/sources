package com.animaconnected.watch.fitness;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SpeedCalibrationStart extends SpeedCalibration {
    public static final SpeedCalibrationStart INSTANCE = new SpeedCalibrationStart();

    private SpeedCalibrationStart() {
        super(0, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedCalibrationStart)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return -785558222;
    }

    public String toString() {
        return "SpeedCalibrationStart";
    }
}

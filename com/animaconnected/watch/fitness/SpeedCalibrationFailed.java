package com.animaconnected.watch.fitness;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SpeedCalibrationFailed extends SpeedCalibration {
    public static final SpeedCalibrationFailed INSTANCE = new SpeedCalibrationFailed();

    private SpeedCalibrationFailed() {
        super(2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedCalibrationFailed)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1028005229;
    }

    public String toString() {
        return "SpeedCalibrationFailed";
    }
}

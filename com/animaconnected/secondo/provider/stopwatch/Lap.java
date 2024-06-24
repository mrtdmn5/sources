package com.animaconnected.secondo.provider.stopwatch;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class Lap {

    @SerializedName("best")
    public boolean mBest;

    @SerializedName("lap")
    public int mLap;

    @SerializedName("lapTime")
    public int mLapTimeInMilliseconds;

    @SerializedName("worst")
    public boolean mWorst;

    public static Lap createLap(int r1, int r2) {
        Lap lap = new Lap();
        lap.mLap = r1;
        lap.mLapTimeInMilliseconds = r2 - (r2 % 10);
        return lap;
    }
}

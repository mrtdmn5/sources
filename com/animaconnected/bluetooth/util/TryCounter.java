package com.animaconnected.bluetooth.util;

/* loaded from: classes.dex */
public class TryCounter {
    private int currentTries = 0;
    private final int mRepeatAmount;

    public TryCounter(int r2) {
        this.mRepeatAmount = r2;
    }

    public void resetTries() {
        this.currentTries = 0;
    }

    public boolean shouldTryAgain() {
        int r0 = this.currentTries + 1;
        this.currentTries = r0;
        if (r0 <= this.mRepeatAmount) {
            return true;
        }
        this.currentTries = 0;
        return false;
    }
}

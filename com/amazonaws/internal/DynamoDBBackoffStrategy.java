package com.amazonaws.internal;

/* loaded from: classes.dex */
public class DynamoDBBackoffStrategy extends CustomBackoffStrategy {
    public static final CustomBackoffStrategy DEFAULT = new DynamoDBBackoffStrategy();

    @Override // com.amazonaws.internal.CustomBackoffStrategy
    public int getBackoffPeriod(int r5) {
        if (r5 <= 0) {
            return 0;
        }
        int pow = ((int) Math.pow(2.0d, r5 - 1)) * 50;
        if (pow < 0) {
            return Integer.MAX_VALUE;
        }
        return pow;
    }
}

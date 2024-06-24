package com.animaconnected.watch.device;

/* compiled from: HybridAlarm.kt */
/* loaded from: classes3.dex */
public final class HybridAlarm {
    private byte configurationBitsAsInt;
    private final int hours;
    private final int minutes;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:            if (java.lang.Integer.compare((r7 & 255) ^ Integer.MIN_VALUE, -2147483646) >= 0) goto L19;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HybridAlarm(int r5, int r6, byte r7) {
        /*
            r4 = this;
            r4.<init>()
            r4.hours = r5
            r4.minutes = r6
            r0 = 1
            r1 = 0
            if (r5 < 0) goto L11
            r2 = 24
            if (r5 >= r2) goto L11
            r2 = r0
            goto L12
        L11:
            r2 = r1
        L12:
            if (r2 == 0) goto L2e
            if (r6 < 0) goto L1c
            r2 = 60
            if (r6 >= r2) goto L1c
            r2 = r0
            goto L1d
        L1c:
            r2 = r1
        L1d:
            if (r2 == 0) goto L2e
            r2 = r7 & 255(0xff, float:3.57E-43)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 ^ r3
            r3 = -2147483646(0xffffffff80000002, float:-2.8E-45)
            int r2 = java.lang.Integer.compare(r2, r3)
            if (r2 < 0) goto L2e
            goto L2f
        L2e:
            r0 = r1
        L2f:
            if (r0 == 0) goto L34
            r4.configurationBitsAsInt = r7
            return
        L34:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Fail: "
            r0.<init>(r1)
            r0.append(r5)
            r5 = 58
            r0.append(r5)
            r0.append(r6)
            r5 = 32
            r0.append(r5)
            r0.append(r7)
            java.lang.String r5 = r0.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.HybridAlarm.<init>(int, int, byte):void");
    }

    /* renamed from: getConfigurationBitsAsInt-w2LRezQ, reason: not valid java name */
    public final byte m1066getConfigurationBitsAsIntw2LRezQ() {
        return this.configurationBitsAsInt;
    }

    public final int getHours() {
        return this.hours;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    /* renamed from: setConfigurationBitsAsInt-7apg3OU, reason: not valid java name */
    public final void m1067setConfigurationBitsAsInt7apg3OU(byte b) {
        this.configurationBitsAsInt = b;
    }
}

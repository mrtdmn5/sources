package okhttp3.internal.http2;

/* compiled from: Settings.kt */
/* loaded from: classes4.dex */
public final class Settings {
    public int set;
    public final int[] values = new int[10];

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final void set(int r4, int r5) {
        if (r4 >= 0) {
            int[] r0 = this.values;
            if (r4 < r0.length) {
                this.set = (1 << r4) | this.set;
                r0[r4] = r5;
            }
        }
    }
}

package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class RtlSpacingHelper {
    public int mLeft = 0;
    public int mRight = 0;
    public int mStart = Integer.MIN_VALUE;
    public int mEnd = Integer.MIN_VALUE;
    public int mExplicitLeft = 0;
    public int mExplicitRight = 0;
    public boolean mIsRtl = false;
    public boolean mIsRelative = false;

    public final void setRelative(int r3, int r4) {
        this.mStart = r3;
        this.mEnd = r4;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (r4 != Integer.MIN_VALUE) {
                this.mLeft = r4;
            }
            if (r3 != Integer.MIN_VALUE) {
                this.mRight = r3;
                return;
            }
            return;
        }
        if (r3 != Integer.MIN_VALUE) {
            this.mLeft = r3;
        }
        if (r4 != Integer.MIN_VALUE) {
            this.mRight = r4;
        }
    }
}

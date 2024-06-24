package androidx.navigation;

/* loaded from: classes.dex */
public final class NavOptions {
    public final int mEnterAnim;
    public final int mExitAnim;
    public final int mPopEnterAnim;
    public final int mPopExitAnim;
    public final int mPopUpTo;
    public final boolean mPopUpToInclusive;
    public final boolean mSingleTop;

    public NavOptions(boolean z, int r2, boolean z2, int r4, int r5, int r6, int r7) {
        this.mSingleTop = z;
        this.mPopUpTo = r2;
        this.mPopUpToInclusive = z2;
        this.mEnterAnim = r4;
        this.mExitAnim = r5;
        this.mPopEnterAnim = r6;
        this.mPopExitAnim = r7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavOptions.class != obj.getClass()) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        if (this.mSingleTop == navOptions.mSingleTop && this.mPopUpTo == navOptions.mPopUpTo && this.mPopUpToInclusive == navOptions.mPopUpToInclusive && this.mEnterAnim == navOptions.mEnterAnim && this.mExitAnim == navOptions.mExitAnim && this.mPopEnterAnim == navOptions.mPopEnterAnim && this.mPopExitAnim == navOptions.mPopExitAnim) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.mSingleTop ? 1 : 0) * 31) + this.mPopUpTo) * 31) + (this.mPopUpToInclusive ? 1 : 0)) * 31) + this.mEnterAnim) * 31) + this.mExitAnim) * 31) + this.mPopEnterAnim) * 31) + this.mPopExitAnim;
    }
}

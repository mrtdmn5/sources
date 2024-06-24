package androidx.navigation;

/* loaded from: classes.dex */
public final class NavArgument {
    public final Object mDefaultValue;
    public final boolean mDefaultValuePresent;
    public final boolean mIsNullable;
    public final NavType mType;

    public NavArgument(NavType<?> navType, boolean z, Object obj, boolean z2) {
        if (!navType.mNullableAllowed && z) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        }
        if (!z && z2 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + navType.getName() + " has null value but is not nullable.");
        }
        this.mType = navType;
        this.mIsNullable = z;
        this.mDefaultValue = obj;
        this.mDefaultValuePresent = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.mIsNullable != navArgument.mIsNullable || this.mDefaultValuePresent != navArgument.mDefaultValuePresent || !this.mType.equals(navArgument.mType)) {
            return false;
        }
        Object obj2 = navArgument.mDefaultValue;
        Object obj3 = this.mDefaultValue;
        if (obj3 != null) {
            return obj3.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = ((((this.mType.hashCode() * 31) + (this.mIsNullable ? 1 : 0)) * 31) + (this.mDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.mDefaultValue;
        if (obj != null) {
            r1 = obj.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }
}

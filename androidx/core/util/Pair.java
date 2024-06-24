package androidx.core.util;

/* loaded from: classes.dex */
public final class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat$Api19Impl.equals(pair.first, this.first) || !ObjectsCompat$Api19Impl.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        F f = this.first;
        if (f == null) {
            hashCode = 0;
        } else {
            hashCode = f.hashCode();
        }
        S s = this.second;
        if (s != null) {
            r0 = s.hashCode();
        }
        return r0 ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

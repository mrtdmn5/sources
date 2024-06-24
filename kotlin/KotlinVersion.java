package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final KotlinVersion CURRENT = new KotlinVersion();
    public final int major = 1;
    public final int minor = 9;
    public final int patch = 21;
    public final int version;

    public KotlinVersion() {
        if (new IntRange(0, 255).contains(1) && new IntRange(0, 255).contains(9) && new IntRange(0, 255).contains(21)) {
            this.version = 67861;
            return;
        }
        throw new IllegalArgumentException("Version components are out of range: 1.9.21".toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(KotlinVersion kotlinVersion) {
        KotlinVersion other = kotlinVersion;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public final boolean equals(Object obj) {
        KotlinVersion kotlinVersion;
        if (this == obj) {
            return true;
        }
        if (obj instanceof KotlinVersion) {
            kotlinVersion = (KotlinVersion) obj;
        } else {
            kotlinVersion = null;
        }
        if (kotlinVersion != null && this.version == kotlinVersion.version) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.version;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }
}

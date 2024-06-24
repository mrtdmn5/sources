package androidx.work.impl.model;

/* loaded from: classes.dex */
public final class Preference {
    public final String mKey;
    public final Long mValue;

    public Preference(String key, long value) {
        this.mKey = key;
        this.mValue = Long.valueOf(value);
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) o;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l = preference.mValue;
        Long l2 = this.mValue;
        if (l2 != null) {
            return l2.equals(l);
        }
        if (l == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = this.mKey.hashCode() * 31;
        Long l = this.mValue;
        if (l != null) {
            r1 = l.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }
}

package androidx.work;

import android.net.Uri;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class ContentUriTriggers {
    public final HashSet mTriggers = new HashSet();

    /* loaded from: classes.dex */
    public static final class Trigger {
        public final boolean mTriggerForDescendants;
        public final Uri mUri;

        public Trigger(boolean uri, Uri triggerForDescendants) {
            this.mUri = triggerForDescendants;
            this.mTriggerForDescendants = uri;
        }

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || Trigger.class != o.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) o;
            if (this.mTriggerForDescendants == trigger.mTriggerForDescendants && this.mUri.equals(trigger.mUri)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && ContentUriTriggers.class == o.getClass()) {
            return this.mTriggers.equals(((ContentUriTriggers) o).mTriggers);
        }
        return false;
    }

    public final int hashCode() {
        return this.mTriggers.hashCode();
    }
}

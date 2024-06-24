package aws.smithy.kotlin.runtime.time;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public abstract class Needed {

    /* compiled from: ParserCombinators.kt */
    /* loaded from: classes.dex */
    public static final class Size extends Needed {
        public final int size;

        public Size(int r1) {
            this.size = r1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Size) && this.size == ((Size) obj).size) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.size);
        }

        public final String toString() {
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("incomplete input needed ("), this.size, ')');
        }
    }

    /* compiled from: ParserCombinators.kt */
    /* loaded from: classes.dex */
    public static final class Unknown extends Needed {
        public static final Unknown INSTANCE = new Unknown();

        public final String toString() {
            return "incomplete input";
        }
    }
}

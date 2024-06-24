package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorResources.android.kt */
/* loaded from: classes.dex */
public final class ImageVectorCache {
    public final HashMap<Key, WeakReference<ImageVectorEntry>> map = new HashMap<>();

    /* compiled from: VectorResources.android.kt */
    /* loaded from: classes.dex */
    public static final class ImageVectorEntry {
        public final int configFlags;
        public final ImageVector imageVector;

        public ImageVectorEntry(ImageVector imageVector, int r2) {
            this.imageVector = imageVector;
            this.configFlags = r2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageVectorEntry)) {
                return false;
            }
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) obj;
            if (Intrinsics.areEqual(this.imageVector, imageVectorEntry.imageVector) && this.configFlags == imageVectorEntry.configFlags) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.configFlags) + (this.imageVector.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ImageVectorEntry(imageVector=");
            sb.append(this.imageVector);
            sb.append(", configFlags=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.configFlags, ')');
        }
    }

    /* compiled from: VectorResources.android.kt */
    /* loaded from: classes.dex */
    public static final class Key {
        public final int id;
        public final Resources.Theme theme;

        public Key(int r1, Resources.Theme theme) {
            this.theme = theme;
            this.id = r1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (Intrinsics.areEqual(this.theme, key.theme) && this.id == key.id) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.id) + (this.theme.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Key(theme=");
            sb.append(this.theme);
            sb.append(", id=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.id, ')');
        }
    }
}

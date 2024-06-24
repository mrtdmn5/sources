package androidx.compose.ui.platform.coreshims;

import android.view.ViewStructure;

/* loaded from: classes.dex */
public final class ViewStructureCompat {
    public final ViewStructure mWrappedObj;

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        public static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        public static void setDimens(ViewStructure viewStructure, int r1, int r2, int r3, int r4, int r5, int r6) {
            viewStructure.setDimens(r1, r2, r3, r4, r5, r6);
        }

        public static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    public ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }
}

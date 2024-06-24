package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;

/* loaded from: classes.dex */
public final class BlendModeColorFilterCompat {

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static ColorFilter createBlendModeColorFilter(int r1, Object obj) {
            return new BlendModeColorFilter(r1, (BlendMode) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.ColorFilter createBlendModeColorFilterCompat(int r3, androidx.core.graphics.BlendModeCompat r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            r2 = 0
            if (r0 < r1) goto L12
            java.lang.Object r4 = androidx.core.graphics.BlendModeUtils$Api29Impl.obtainBlendModeFromCompat(r4)
            if (r4 == 0) goto L11
            android.graphics.ColorFilter r2 = androidx.core.graphics.BlendModeColorFilterCompat.Api29Impl.createBlendModeColorFilter(r3, r4)
        L11:
            return r2
        L12:
            if (r4 != 0) goto L16
        L14:
            r4 = r2
            goto L57
        L16:
            int[] r0 = androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L55;
                case 2: goto L52;
                case 3: goto L4f;
                case 4: goto L4c;
                case 5: goto L49;
                case 6: goto L46;
                case 7: goto L43;
                case 8: goto L40;
                case 9: goto L3d;
                case 10: goto L3a;
                case 11: goto L37;
                case 12: goto L34;
                case 13: goto L31;
                case 14: goto L2e;
                case 15: goto L2b;
                case 16: goto L28;
                case 17: goto L25;
                case 18: goto L22;
                default: goto L21;
            }
        L21:
            goto L14
        L22:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.LIGHTEN
            goto L57
        L25:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DARKEN
            goto L57
        L28:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.OVERLAY
            goto L57
        L2b:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SCREEN
            goto L57
        L2e:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L57
        L31:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.ADD
            goto L57
        L34:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.XOR
            goto L57
        L37:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST_ATOP
            goto L57
        L3a:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            goto L57
        L3d:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST_OUT
            goto L57
        L40:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_OUT
            goto L57
        L43:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST_IN
            goto L57
        L46:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            goto L57
        L49:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST_OVER
            goto L57
        L4c:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_OVER
            goto L57
        L4f:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST
            goto L57
        L52:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC
            goto L57
        L55:
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.CLEAR
        L57:
            if (r4 == 0) goto L5e
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            r2.<init>(r3, r4)
        L5e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(int, androidx.core.graphics.BlendModeCompat):android.graphics.ColorFilter");
    }
}

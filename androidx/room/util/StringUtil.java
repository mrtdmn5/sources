package androidx.room.util;

/* loaded from: classes.dex */
public final class StringUtil {
    public static void appendPlaceholders(int r2, StringBuilder sb) {
        for (int r0 = 0; r0 < r2; r0++) {
            sb.append("?");
            if (r0 < r2 - 1) {
                sb.append(",");
            }
        }
    }
}

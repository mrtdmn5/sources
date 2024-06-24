package com.squareup.moshi;

/* loaded from: classes3.dex */
public final class JsonScope {
    public static String getPath(int r4, int[] r5, String[] strArr, int[] r7) {
        StringBuilder sb = new StringBuilder("$");
        for (int r1 = 0; r1 < r4; r1++) {
            int r2 = r5[r1];
            if (r2 != 1 && r2 != 2) {
                if (r2 == 3 || r2 == 4 || r2 == 5) {
                    sb.append('.');
                    String str = strArr[r1];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(r7[r1]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}

package com.google.gson.internal;

/* loaded from: classes3.dex */
public final class JavaVersion {
    public static final int majorJavaVersion;

    static {
        int r4;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]");
            r4 = Integer.parseInt(split[0]);
            if (r4 == 1 && split.length > 1) {
                r4 = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            r4 = -1;
        }
        if (r4 == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int r1 = 0; r1 < property.length(); r1++) {
                    char charAt = property.charAt(r1);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                r4 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                r4 = -1;
            }
        }
        if (r4 == -1) {
            r4 = 6;
        }
        majorJavaVersion = r4;
    }
}

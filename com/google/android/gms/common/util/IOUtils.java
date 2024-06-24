package com.google.android.gms.common.util;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}

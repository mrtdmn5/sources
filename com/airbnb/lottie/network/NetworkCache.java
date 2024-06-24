package com.airbnb.lottie.network;

import com.airbnb.lottie.L;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class NetworkCache {
    public final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(L.AnonymousClass1 anonymousClass1) {
        this.cacheProvider = anonymousClass1;
    }

    public static String filenameForUrl(String str, FileExtension fileExtension, boolean z) {
        String str2;
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        if (z) {
            str2 = fileExtension.tempExtension();
        } else {
            str2 = fileExtension.extension;
        }
        sb.append(str2);
        return sb.toString();
    }

    public final File parentDir() {
        L.AnonymousClass1 anonymousClass1 = (L.AnonymousClass1) this.cacheProvider;
        anonymousClass1.getClass();
        File file = new File(anonymousClass1.val$appContext.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File writeTempCacheFile(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}

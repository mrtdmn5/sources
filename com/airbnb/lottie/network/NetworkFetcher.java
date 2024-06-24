package com.airbnb.lottie.network;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public final class NetworkFetcher {
    public final DefaultLottieNetworkFetcher fetcher;
    public final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache, DefaultLottieNetworkFetcher defaultLottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = defaultLottieNetworkFetcher;
    }

    public final LottieResult<LottieComposition> fromInputStream(String str, InputStream inputStream, String str2, String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> fromZipStreamSync;
        if (str2 == null) {
            str2 = "application/json";
        }
        boolean contains = str2.contains(DfuBaseService.MIME_TYPE_ZIP);
        NetworkCache networkCache = this.networkCache;
        if (!contains && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug();
            fileExtension = FileExtension.JSON;
            if (str3 == null) {
                fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(null, inputStream);
            } else {
                fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(str, new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, fileExtension).getAbsolutePath()));
            }
        } else {
            Logger.debug();
            fileExtension = FileExtension.ZIP;
            if (str3 == null) {
                fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), null);
            } else {
                fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, fileExtension))), str);
            }
        }
        if (str3 != null && fromZipStreamSync.value != null) {
            networkCache.getClass();
            File file = new File(networkCache.parentDir(), NetworkCache.filenameForUrl(str, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean renameTo = file.renameTo(file2);
            file2.toString();
            Logger.debug();
            if (!renameTo) {
                Logger.warning("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + InstructionFileId.DOT);
            }
        }
        return fromZipStreamSync;
    }
}

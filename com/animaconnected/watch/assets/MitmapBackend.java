package com.animaconnected.watch.assets;

import com.animaconnected.watch.display.MitmapCompressionSettings;
import com.animaconnected.watch.image.Mitmap;

/* compiled from: MitmapBackend.kt */
/* loaded from: classes3.dex */
public interface MitmapBackend {
    static /* synthetic */ Mitmap getMitmap$default(MitmapBackend mitmapBackend, WatchAsset watchAsset, MitmapCompressionSettings mitmapCompressionSettings, int r3, Object obj) {
        if (obj == null) {
            if ((r3 & 2) != 0) {
                mitmapCompressionSettings = MitmapCompressionSettings.Companion.getWatchIconSettings();
            }
            return mitmapBackend.getMitmap(watchAsset, mitmapCompressionSettings);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMitmap");
    }

    Mitmap getMitmap(WatchAsset watchAsset, MitmapCompressionSettings mitmapCompressionSettings);
}

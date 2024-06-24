package com.animaconnected.watch;

import android.content.Context;
import android.graphics.Bitmap;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.display.MitmapCompressionSettings;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MitmapBackendImpl.kt */
/* loaded from: classes3.dex */
public final class MitmapBackendImpl implements MitmapBackend {
    private final Context context;

    public MitmapBackendImpl(Context context) {
        this.context = context;
    }

    @Override // com.animaconnected.watch.assets.MitmapBackend
    public Mitmap getMitmap(final WatchAsset watchAsset, MitmapCompressionSettings compressionSettings) {
        Mitmap mitmap;
        Intrinsics.checkNotNullParameter(compressionSettings, "compressionSettings");
        if (watchAsset == null) {
            LogKt.err$default((Object) this, "WatchAsset is null, return", (String) null, (Throwable) null, false, 14, (Object) null);
            return GraphicsKt.emptyMitmap();
        }
        try {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.MitmapBackendImpl$getMitmap$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Loading mitmap asset for: " + WatchAsset.this;
                }
            }, 7, (Object) null);
            Context context = this.context;
            if (context != null) {
                Bitmap readBitmap = AndroidGraphicsKt.readBitmap(context, "watch/" + watchAsset.getFileName());
                if (readBitmap != null && (mitmap = AndroidGraphicsKt.toMitmap(readBitmap, compressionSettings)) != null) {
                    return mitmap;
                }
            }
            return GraphicsKt.emptyMitmap();
        } catch (Exception e) {
            LogKt.err$default((Object) this, "Failed to load mitmap asset for: " + watchAsset, (String) null, (Throwable) e, false, 10, (Object) null);
            return GraphicsKt.emptyMitmap();
        }
    }
}

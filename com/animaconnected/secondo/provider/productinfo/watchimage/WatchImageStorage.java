package com.animaconnected.secondo.provider.productinfo.watchimage;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WatchImageStorage.kt */
/* loaded from: classes3.dex */
public final class WatchImageStorage {
    public static final int $stable = 8;
    private final Context mContext;

    public WatchImageStorage(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFile(String str, WatchImageType watchImageType) {
        return new File(this.mContext.getDir(null, 0), str + watchImageType);
    }

    public final Bitmap getImage(WatchImageType type, String sku) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sku, "sku");
        File file = getFile(sku, type);
        if (file.exists()) {
            return WatchImageHelper.INSTANCE.getBitmapFromFile(this.mContext, file);
        }
        return null;
    }

    public final Object setImage(String str, WatchImageType watchImageType, Bitmap bitmap, Continuation<Object> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new WatchImageStorage$setImage$2(this, str, watchImageType, bitmap, null), continuation);
    }
}

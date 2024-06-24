package com.animaconnected.secondo.screens.workout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.KronabyApplication;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BitmapCache.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class BitmapCache {
    private static final String DISK_CACHE_SUBDIR = "map_view_bitmaps";
    public static final BitmapCache INSTANCE = new BitmapCache();
    private static final Context context = KronabyApplication.Companion.getContext();
    private static final Lazy cacheDir$delegate = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.animaconnected.secondo.screens.workout.BitmapCache$cacheDir$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            File diskCacheDir;
            diskCacheDir = BitmapCache.INSTANCE.getDiskCacheDir();
            return diskCacheDir;
        }
    });
    public static final int $stable = 8;

    private BitmapCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDir() {
        return (File) cacheDir$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getDiskCacheDir() {
        String str;
        if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            str = context.getCacheDir().getPath();
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                str = externalCacheDir.getPath();
            } else {
                str = null;
            }
        }
        File file = new File(ComponentActivity$2$$ExternalSyntheticOutline0.m(FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str), File.separator, DISK_CACHE_SUBDIR));
        file.mkdirs();
        return file;
    }

    public final Object load(String str, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new BitmapCache$load$2(str, null), continuation);
    }

    public final Object save(Bitmap bitmap, String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new BitmapCache$save$2(str, bitmap, null), continuation);
    }
}

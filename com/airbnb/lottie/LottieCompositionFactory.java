package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.RealBufferedSource;

/* loaded from: classes.dex */
public final class LottieCompositionFactory {
    public static final HashMap taskCache = new HashMap();
    public static final byte[] MAGIC = {80, 75, 3, 4};

    public static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            lottieComposition = LottieCompositionCache.INSTANCE.cache.get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new LottieResult(LottieComposition.this);
                }
            }, false);
        }
        HashMap hashMap = taskCache;
        if (str != null && hashMap.containsKey(str)) {
            return (LottieTask) hashMap.get(str);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable, false);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.addListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda6
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.taskCache.remove(str);
                    atomicBoolean.set(true);
                }
            });
            lottieTask.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda7
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.taskCache.remove(str);
                    atomicBoolean.set(true);
                }
            });
            if (!atomicBoolean.get()) {
                hashMap.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("asset_", str);
        return cache(m, new LottieCompositionFactory$$ExternalSyntheticLambda3(context.getApplicationContext(), str, m));
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return fromJsonInputStreamSync(str2, context.getAssets().open(str));
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new LottieResult<>(e);
        }
    }

    public static LottieResult fromJsonInputStreamSync(String str, InputStream inputStream) {
        try {
            RealBufferedSource buffer = Okio.buffer(Okio.source(inputStream));
            String[] strArr = JsonReader.REPLACEMENT_CHARS;
            return fromJsonReaderSyncInternal(new JsonUtf8Reader(buffer), str, true);
        } finally {
            Utils.closeQuietly(inputStream);
        }
    }

    public static LottieResult fromJsonReaderSyncInternal(JsonUtf8Reader jsonUtf8Reader, String str, boolean z) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonUtf8Reader);
                if (str != null) {
                    LottieCompositionCache.INSTANCE.cache.put(str, parse);
                }
                LottieResult lottieResult = new LottieResult(parse);
                if (z) {
                    Utils.closeQuietly(jsonUtf8Reader);
                }
                return lottieResult;
            } catch (Exception e) {
                LottieResult lottieResult2 = new LottieResult(e);
                if (z) {
                    Utils.closeQuietly(jsonUtf8Reader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonUtf8Reader);
            }
            throw th;
        }
    }

    public static LottieTask fromRawRes(final int r2, Context context, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return LottieCompositionFactory.fromRawResSync(r2, context2, str);
            }
        });
    }

    public static LottieResult fromRawResSync(int r5, Context context, String str) {
        Boolean bool;
        try {
            final RealBufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(r5)));
            try {
                RealBufferedSource peek = buffer.peek();
                byte[] bArr = MAGIC;
                int length = bArr.length;
                int r2 = 0;
                while (true) {
                    if (r2 < length) {
                        if (peek.readByte() != bArr[r2]) {
                            bool = Boolean.FALSE;
                            break;
                        }
                        r2++;
                    } else {
                        peek.close();
                        bool = Boolean.TRUE;
                        break;
                    }
                }
            } catch (Exception unused) {
                Logger.INSTANCE.getClass();
                bool = Boolean.FALSE;
            } catch (NoSuchMethodError unused2) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                return fromZipStreamSync(new ZipInputStream(new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
                    @Override // java.io.InputStream
                    public final int available() {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (!realBufferedSource.closed) {
                            return (int) Math.min(realBufferedSource.bufferField.size, Integer.MAX_VALUE);
                        }
                        throw new IOException("closed");
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        RealBufferedSource.this.close();
                    }

                    @Override // java.io.InputStream
                    public final int read() {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (!realBufferedSource.closed) {
                            Buffer buffer2 = realBufferedSource.bufferField;
                            if (buffer2.size == 0 && realBufferedSource.source.read(buffer2, 8192L) == -1) {
                                return -1;
                            }
                            return realBufferedSource.bufferField.readByte() & 255;
                        }
                        throw new IOException("closed");
                    }

                    public final String toString() {
                        return RealBufferedSource.this + ".inputStream()";
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] data, int r10, int r11) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (!realBufferedSource.closed) {
                            _UtilKt.checkOffsetAndCount(data.length, r10, r11);
                            Buffer buffer2 = realBufferedSource.bufferField;
                            if (buffer2.size == 0 && realBufferedSource.source.read(buffer2, 8192L) == -1) {
                                return -1;
                            }
                            return realBufferedSource.bufferField.read(data, r10, r11);
                        }
                        throw new IOException("closed");
                    }
                }), str);
            }
            return fromJsonInputStreamSync(str, new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
                @Override // java.io.InputStream
                public final int available() {
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    if (!realBufferedSource.closed) {
                        return (int) Math.min(realBufferedSource.bufferField.size, Integer.MAX_VALUE);
                    }
                    throw new IOException("closed");
                }

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    RealBufferedSource.this.close();
                }

                @Override // java.io.InputStream
                public final int read() {
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    if (!realBufferedSource.closed) {
                        Buffer buffer2 = realBufferedSource.bufferField;
                        if (buffer2.size == 0 && realBufferedSource.source.read(buffer2, 8192L) == -1) {
                            return -1;
                        }
                        return realBufferedSource.bufferField.readByte() & 255;
                    }
                    throw new IOException("closed");
                }

                public final String toString() {
                    return RealBufferedSource.this + ".inputStream()";
                }

                @Override // java.io.InputStream
                public final int read(byte[] data, int r10, int r11) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    if (!realBufferedSource.closed) {
                        _UtilKt.checkOffsetAndCount(data.length, r10, r11);
                        Buffer buffer2 = realBufferedSource.bufferField;
                        if (buffer2.size == 0 && realBufferedSource.source.read(buffer2, 8192L) == -1) {
                            return -1;
                        }
                        return realBufferedSource.bufferField.read(data, r10, r11);
                    }
                    throw new IOException("closed");
                }
            });
        } catch (Resources.NotFoundException e) {
            return new LottieResult(e);
        }
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        LottieImageAsset lottieImageAsset;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    RealBufferedSource buffer = Okio.buffer(Okio.source(zipInputStream));
                    String[] strArr = JsonReader.REPLACEMENT_CHARS;
                    lottieComposition = (LottieComposition) fromJsonReaderSyncInternal(new JsonUtf8Reader(buffer), null, false).value;
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<LottieImageAsset> it = lottieComposition.images.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        lottieImageAsset = it.next();
                        if (lottieImageAsset.fileName.equals(str2)) {
                            break;
                        }
                    } else {
                        lottieImageAsset = null;
                        break;
                    }
                }
                if (lottieImageAsset != null) {
                    lottieImageAsset.bitmap = Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), lottieImageAsset.width, lottieImageAsset.height);
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.images.entrySet()) {
                if (entry2.getValue().bitmap == null) {
                    return new LottieResult<>(new IllegalStateException("There is no image for " + entry2.getValue().fileName));
                }
            }
            if (str != null) {
                LottieCompositionCache.INSTANCE.cache.put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>(e);
        }
    }

    public static String rawResCacheKey(Context context, int r3) {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder("rawRes");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(r3);
        return sb.toString();
    }
}

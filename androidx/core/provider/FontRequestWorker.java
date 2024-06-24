package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Process;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import com.amazonaws.services.s3.internal.Constants;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class FontRequestWorker {
    public static final ThreadPoolExecutor DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    public static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES;
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, Constants.MAXIMUM_UPLOAD_PARTS, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: androidx.core.provider.RequestExecutor$DefaultThreadFactory
            public final String mThreadName = "fonts-androidx";
            public final int mPriority = 10;

            /* loaded from: classes.dex */
            public static class ProcessPriorityThread extends Thread {
                public final int mPriority;

                public ProcessPriorityThread(Runnable runnable, String str, int r3) {
                    super(runnable, str);
                    this.mPriority = r3;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    Process.setThreadPriority(this.mPriority);
                    super.run();
                }
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap<>();
    }

    public static TypefaceResult getFontSync(String str, Context context, FontRequest fontRequest, int r9) {
        int r8;
        LruCache<String, Typeface> lruCache = sTypefaceCache;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat$FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest);
            int r1 = 1;
            FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = fontFamilyResult.mFonts;
            int r82 = fontFamilyResult.mStatusCode;
            if (r82 != 0) {
                if (r82 == 1) {
                    r8 = -2;
                }
                r8 = -3;
            } else {
                if (fontsContractCompat$FontInfoArr != null && fontsContractCompat$FontInfoArr.length != 0) {
                    r1 = 0;
                    for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                        int r5 = fontsContractCompat$FontInfo.mResultCode;
                        if (r5 != 0) {
                            if (r5 >= 0) {
                                r8 = r5;
                            }
                            r8 = -3;
                        }
                    }
                }
                r8 = r1;
            }
            if (r8 != 0) {
                return new TypefaceResult(r8);
            }
            Typeface createFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, r9);
            if (createFromFontInfo != null) {
                lruCache.put(str, createFromFontInfo);
                return new TypefaceResult(createFromFontInfo);
            }
            return new TypefaceResult(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* loaded from: classes.dex */
    public static final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int r2) {
            this.mTypeface = null;
            this.mResult = r2;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}

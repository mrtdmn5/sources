package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontFamilyResult;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    public static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    /* loaded from: classes.dex */
    public static class FontProviderHelper {
    }

    /* loaded from: classes.dex */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        public EmojiCompat.MetadataRepoLoaderCallback mCallback;
        public final Context mContext;
        public Executor mExecutor;
        public final FontProviderHelper mFontProviderHelper;
        public final Object mLock;
        public Handler mMainHandler;
        public ThreadPoolExecutor mMyThreadPoolExecutor;
        public final FontRequest mRequest;

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest) {
            FontProviderHelper fontProviderHelper = FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT;
            this.mLock = new Object();
            if (context != null) {
                this.mContext = context.getApplicationContext();
                this.mRequest = fontRequest;
                this.mFontProviderHelper = fontProviderHelper;
                return;
            }
            throw new NullPointerException("Context cannot be null");
        }

        public final void cleanUp() {
            synchronized (this.mLock) {
                this.mCallback = null;
                Handler handler = this.mMainHandler;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.mMainHandler = null;
                ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.mExecutor = null;
                this.mMyThreadPoolExecutor = null;
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        public final void loadInternal() {
            synchronized (this.mLock) {
                if (this.mCallback == null) {
                    return;
                }
                if (this.mExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.mMyThreadPoolExecutor = threadPoolExecutor;
                    this.mExecutor = threadPoolExecutor;
                }
                this.mExecutor.execute(new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(0, this));
            }
        }

        public final FontsContractCompat$FontInfo retrieveFontInfo() {
            try {
                FontProviderHelper fontProviderHelper = this.mFontProviderHelper;
                Context context = this.mContext;
                FontRequest fontRequest = this.mRequest;
                fontProviderHelper.getClass();
                FontsContractCompat$FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest);
                int r1 = fontFamilyResult.mStatusCode;
                if (r1 == 0) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = fontFamilyResult.mFonts;
                    if (fontsContractCompat$FontInfoArr != null && fontsContractCompat$FontInfoArr.length != 0) {
                        return fontsContractCompat$FontInfoArr[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("fetchFonts failed (", r1, ")"));
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest));
    }
}

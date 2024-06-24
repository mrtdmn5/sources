package androidx.emoji2.text;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import java.nio.MappedByteBuffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    if (fontRequestMetadataLoader.mCallback != null) {
                        try {
                            FontsContractCompat$FontInfo retrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                            int r3 = retrieveFontInfo.mResultCode;
                            if (r3 == 2) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                }
                            }
                            if (r3 == 0) {
                                try {
                                    int r32 = TraceCompat.$r8$clinit;
                                    TraceCompat.Api18Impl.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                    FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper = fontRequestMetadataLoader.mFontProviderHelper;
                                    Context context = fontRequestMetadataLoader.mContext;
                                    fontProviderHelper.getClass();
                                    Typeface createFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, new FontsContractCompat$FontInfo[]{retrieveFontInfo}, 0);
                                    MappedByteBuffer mmap = TypefaceCompatUtil.mmap(fontRequestMetadataLoader.mContext, retrieveFontInfo.mUri);
                                    if (mmap != null && createFromFontInfo != null) {
                                        try {
                                            TraceCompat.Api18Impl.beginSection("EmojiCompat.MetadataRepo.create");
                                            MetadataRepo metadataRepo = new MetadataRepo(createFromFontInfo, MetadataListReader.read(mmap));
                                            TraceCompat.Api18Impl.endSection();
                                            TraceCompat.Api18Impl.endSection();
                                            synchronized (fontRequestMetadataLoader.mLock) {
                                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = fontRequestMetadataLoader.mCallback;
                                                if (metadataRepoLoaderCallback != null) {
                                                    metadataRepoLoaderCallback.onLoaded(metadataRepo);
                                                }
                                            }
                                            fontRequestMetadataLoader.cleanUp();
                                            return;
                                        } finally {
                                            int r2 = TraceCompat.$r8$clinit;
                                            TraceCompat.Api18Impl.endSection();
                                        }
                                    }
                                    throw new RuntimeException("Unable to open file.");
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            throw new RuntimeException("fetchFonts result is not OK. (" + r3 + ")");
                        } catch (Throwable th2) {
                            synchronized (fontRequestMetadataLoader.mLock) {
                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = fontRequestMetadataLoader.mCallback;
                                if (metadataRepoLoaderCallback2 != null) {
                                    metadataRepoLoaderCallback2.onFailed(th2);
                                }
                                fontRequestMetadataLoader.cleanUp();
                                return;
                            }
                        }
                    }
                    return;
                }
            default:
                WorkInitializer workInitializer = (WorkInitializer) this.f$0;
                workInitializer.getClass();
                workInitializer.guard.runCriticalSection(new _UtilJvmKt$$ExternalSyntheticLambda1(workInitializer));
                return;
        }
    }
}

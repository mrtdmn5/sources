package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.EditorInfo;
import androidx.collection.ArraySet;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class EmojiCompat {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiCompat sInstance;
    public final DefaultGlyphChecker mGlyphChecker;
    public final CompatInternal19 mHelper;
    public final ArraySet mInitCallbacks;
    public final ReentrantReadWriteLock mInitLock;
    public volatile int mLoadState;
    public final Handler mMainHandler;
    public final int mMetadataLoadStrategy;
    public final MetadataRepoLoader mMetadataLoader;
    public final DefaultSpanFactory mSpanFactory;

    /* loaded from: classes.dex */
    public static class CompatInternal {
        public final EmojiCompat mEmojiCompat;

        public CompatInternal(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }
    }

    /* loaded from: classes.dex */
    public static final class CompatInternal19 extends CompatInternal {
        public volatile MetadataRepo mMetadataRepo;
        public volatile EmojiProcessor mProcessor;

        /* renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public final class AnonymousClass1 extends MetadataRepoLoaderCallback {
            public AnonymousClass1() {
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void onFailed(Throwable th) {
                CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void onLoaded(MetadataRepo metadataRepo) {
                Set<int[]> exclusions;
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.mMetadataRepo = metadataRepo;
                MetadataRepo metadataRepo2 = compatInternal19.mMetadataRepo;
                EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
                DefaultSpanFactory defaultSpanFactory = emojiCompat.mSpanFactory;
                DefaultGlyphChecker defaultGlyphChecker = emojiCompat.mGlyphChecker;
                if (Build.VERSION.SDK_INT >= 34) {
                    exclusions = EmojiExclusions$EmojiExclusions_Api34.getExclusions();
                } else {
                    exclusions = EmojiExclusions$EmojiExclusions_Reflections.getExclusions();
                }
                compatInternal19.mProcessor = new EmojiProcessor(metadataRepo2, defaultSpanFactory, defaultGlyphChecker, exclusions);
                compatInternal19.mEmojiCompat.onMetadataLoadSuccess();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Config {
        public final MetadataRepoLoader mMetadataLoader;
        public int mMetadataLoadStrategy = 0;
        public final DefaultGlyphChecker mGlyphChecker = new DefaultGlyphChecker();

        public Config(MetadataRepoLoader metadataRepoLoader) {
            this.mMetadataLoader = metadataRepoLoader;
        }
    }

    /* loaded from: classes.dex */
    public static class DefaultSpanFactory implements SpanFactory {
    }

    /* loaded from: classes.dex */
    public interface GlyphChecker {
    }

    /* loaded from: classes.dex */
    public static class ListenerDispatcher implements Runnable {
        public final ArrayList mInitCallbacks;
        public final int mLoadState;

        public ListenerDispatcher(List list, int r2, Throwable th) {
            if (list != null) {
                this.mInitCallbacks = new ArrayList(list);
                this.mLoadState = r2;
                return;
            }
            throw new NullPointerException("initCallbacks cannot be null");
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = this.mInitCallbacks;
            int size = arrayList.size();
            int r4 = 0;
            if (this.mLoadState != 1) {
                while (r4 < size) {
                    ((InitCallback) arrayList.get(r4)).onFailed();
                    r4++;
                }
            } else {
                while (r4 < size) {
                    ((InitCallback) arrayList.get(r4)).onInitialized();
                    r4++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: classes.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable th);

        public abstract void onLoaded(MetadataRepo metadataRepo);
    }

    /* loaded from: classes.dex */
    public interface SpanFactory {
    }

    public EmojiCompat(EmojiCompatInitializer.BackgroundDefaultConfig backgroundDefaultConfig) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        this.mLoadState = 3;
        MetadataRepoLoader metadataRepoLoader = backgroundDefaultConfig.mMetadataLoader;
        this.mMetadataLoader = metadataRepoLoader;
        int r2 = backgroundDefaultConfig.mMetadataLoadStrategy;
        this.mMetadataLoadStrategy = r2;
        this.mGlyphChecker = backgroundDefaultConfig.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitCallbacks = new ArraySet();
        this.mSpanFactory = new DefaultSpanFactory();
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.mHelper = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (r2 == 0) {
            try {
                this.mLoadState = 0;
            } catch (Throwable th) {
                this.mInitLock.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(new CompatInternal19.AnonymousClass1());
            } catch (Throwable th2) {
                onMetadataLoadFailed(th2);
            }
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        boolean z;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            if (emojiCompat != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            }
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        if (sInstance != null) {
            return true;
        }
        return false;
    }

    public final int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    public final void load() {
        boolean z;
        boolean z2 = true;
        if (this.mMetadataLoadStrategy == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (getLoadState() != 1) {
                z2 = false;
            }
            if (z2) {
                return;
            }
            this.mInitLock.writeLock().lock();
            try {
                if (this.mLoadState == 0) {
                    return;
                }
                this.mLoadState = 0;
                this.mInitLock.writeLock().unlock();
                CompatInternal19 compatInternal19 = this.mHelper;
                EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
                try {
                    emojiCompat.mMetadataLoader.load(new CompatInternal19.AnonymousClass1());
                    return;
                } catch (Throwable th) {
                    emojiCompat.onMetadataLoadFailed(th);
                    return;
                }
            } finally {
                this.mInitLock.writeLock().unlock();
            }
        }
        throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    }

    public final void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public final void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, null));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0090 A[Catch: all -> 0x00df, TryCatch #0 {all -> 0x00df, blocks: (B:66:0x005c, B:69:0x0061, B:71:0x0065, B:73:0x0072, B:29:0x0082, B:31:0x008a, B:33:0x008d, B:35:0x0090, B:37:0x009c, B:39:0x009f, B:44:0x00ae, B:47:0x00b5, B:49:0x00c8, B:27:0x0078), top: B:65:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8 A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #0 {all -> 0x00df, blocks: (B:66:0x005c, B:69:0x0061, B:71:0x0065, B:73:0x0072, B:29:0x0082, B:31:0x008a, B:33:0x008d, B:35:0x0090, B:37:0x009c, B:39:0x009f, B:44:0x00ae, B:47:0x00b5, B:49:0x00c8, B:27:0x0078), top: B:65:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence process(int r11, int r12, java.lang.CharSequence r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiCompat.process(int, int, java.lang.CharSequence):java.lang.CharSequence");
    }

    public final void registerInitCallback(InitCallback initCallback) {
        if (initCallback != null) {
            this.mInitLock.writeLock().lock();
            try {
                if (this.mLoadState != 1 && this.mLoadState != 2) {
                    this.mInitCallbacks.add(initCallback);
                    return;
                }
                this.mMainHandler.post(new ListenerDispatcher(Arrays.asList(initCallback), this.mLoadState, null));
                return;
            } finally {
                this.mInitLock.writeLock().unlock();
            }
        }
        throw new NullPointerException("initCallback cannot be null");
    }

    public final void updateEditorInfo(EditorInfo editorInfo) {
        int r3;
        boolean z = true;
        if (getLoadState() != 1) {
            z = false;
        }
        if (z && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            CompatInternal19 compatInternal19 = this.mHelper;
            compatInternal19.getClass();
            Bundle bundle = editorInfo.extras;
            MetadataList metadataList = compatInternal19.mMetadataRepo.mMetadataList;
            int __offset = metadataList.__offset(4);
            if (__offset != 0) {
                r3 = metadataList.bb.getInt(__offset + metadataList.bb_pos);
            } else {
                r3 = 0;
            }
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", r3);
            Bundle bundle2 = editorInfo.extras;
            compatInternal19.mEmojiCompat.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class InitCallback {
        public void onFailed() {
        }

        public void onInitialized() {
        }
    }

    public final CharSequence process(CharSequence charSequence) {
        return process(0, charSequence == null ? 0 : charSequence.length(), charSequence);
    }
}

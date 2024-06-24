package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda1;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements DefaultLifecycleObserver {
        public final /* synthetic */ Lifecycle val$lifecycle;

        public AnonymousClass1(Lifecycle lifecycle) {
            r2 = lifecycle;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onResume(LifecycleOwner lifecycleOwner) {
            Handler handler;
            EmojiCompatInitializer.this.getClass();
            if (Build.VERSION.SDK_INT >= 28) {
                handler = ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper());
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.postDelayed(new LoadEmojiCompatRunnable(), 500L);
            r2.removeObserver(this);
        }
    }

    /* loaded from: classes.dex */
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            this.mMetadataLoadStrategy = 1;
        }
    }

    /* loaded from: classes.dex */
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        public final Context mContext;

        /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1 */
        /* loaded from: classes.dex */
        public final class AnonymousClass1 extends EmojiCompat.MetadataRepoLoaderCallback {
            public final /* synthetic */ ThreadPoolExecutor val$executor;

            public AnonymousClass1(ThreadPoolExecutor threadPoolExecutor) {
                r2 = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void onFailed(Throwable th) {
                ThreadPoolExecutor threadPoolExecutor = r2;
                try {
                    EmojiCompat.MetadataRepoLoaderCallback.this.onFailed(th);
                } finally {
                    threadPoolExecutor.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void onLoaded(MetadataRepo metadataRepo) {
                ThreadPoolExecutor threadPoolExecutor = r2;
                try {
                    EmojiCompat.MetadataRepoLoaderCallback.this.onLoaded(metadataRepo);
                } finally {
                    threadPoolExecutor.shutdown();
                }
            }
        }

        public BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new MainActivity$$ExternalSyntheticLambda1(1, this, metadataRepoLoaderCallback, threadPoolExecutor));
        }
    }

    /* loaded from: classes.dex */
    public static class LoadEmojiCompatRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                int r1 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
                TraceCompat.Api18Impl.endSection();
            } catch (Throwable th) {
                int r12 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.endSection();
                throw th;
            }
        }
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // androidx.startup.Initializer
    public final Boolean create(Context context) {
        Object obj;
        BackgroundDefaultConfig backgroundDefaultConfig = new BackgroundDefaultConfig(context);
        if (EmojiCompat.sInstance == null) {
            synchronized (EmojiCompat.INSTANCE_LOCK) {
                if (EmojiCompat.sInstance == null) {
                    EmojiCompat.sInstance = new EmojiCompat(backgroundDefaultConfig);
                }
            }
        }
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        synchronized (AppInitializer.sLock) {
            try {
                obj = appInitializer.mInitialized.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = appInitializer.doInitialize(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Lifecycle lifecycle = ((LifecycleOwner) obj).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            public final /* synthetic */ Lifecycle val$lifecycle;

            public AnonymousClass1(Lifecycle lifecycle2) {
                r2 = lifecycle2;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onResume(LifecycleOwner lifecycleOwner) {
                Handler handler;
                EmojiCompatInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new LoadEmojiCompatRunnable(), 500L);
                r2.removeObserver(this);
            }
        });
        return Boolean.TRUE;
    }
}

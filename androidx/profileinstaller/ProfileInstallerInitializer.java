package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {

    /* loaded from: classes.dex */
    public static class Choreographer16Impl {
        public static void postFrameCallback(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            Handler createAsync;
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
    }

    /* loaded from: classes.dex */
    public static class Result {
    }

    @Override // androidx.startup.Initializer
    public final Result create(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer16Impl.postFrameCallback(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                ProfileInstallerInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                int nextInt = new Random().nextInt(Math.max(1000, 1));
                final Context context2 = applicationContext;
                handler.postDelayed(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
                        final Context context3 = context2;
                        threadPoolExecutor.execute(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProfileInstaller.writeProfile(context3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), ProfileInstaller.EMPTY_DIAGNOSTICS, false);
                            }
                        });
                    }
                }, nextInt + 5000);
            }
        });
        return new Result();
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}

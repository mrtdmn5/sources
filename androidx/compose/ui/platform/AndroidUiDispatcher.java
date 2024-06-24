package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: AndroidUiDispatcher.android.kt */
/* loaded from: classes.dex */
public final class AndroidUiDispatcher extends CoroutineDispatcher {
    public static final SynchronizedLazyImpl Main$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineContext>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2
        @Override // kotlin.jvm.functions.Function0
        public final CoroutineContext invoke() {
            boolean z;
            Choreographer choreographer;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                choreographer = Choreographer.getInstance();
            } else {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                choreographer = (Choreographer) BuildersKt.runBlocking(MainDispatcherLoader.dispatcher, new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null));
            }
            Intrinsics.checkNotNullExpressionValue(choreographer, "if (isMainThread()) Chor…eographer.getInstance() }");
            Handler createAsync = HandlerCompat.createAsync(Looper.getMainLooper());
            Intrinsics.checkNotNullExpressionValue(createAsync, "createAsync(Looper.getMainLooper())");
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, createAsync);
            return androidUiDispatcher.plus(androidUiDispatcher.frameClock);
        }
    });
    public static final AndroidUiDispatcher$Companion$currentThread$1 currentThread = new AndroidUiDispatcher$Companion$currentThread$1();
    public final Choreographer choreographer;
    public final AndroidUiFrameClock frameClock;
    public final Handler handler;
    public boolean scheduledFrameDispatch;
    public boolean scheduledTrampolineDispatch;
    public final Object lock = new Object();
    public final ArrayDeque<Runnable> toRunTrampolined = new ArrayDeque<>();
    public List<Choreographer.FrameCallback> toRunOnFrame = new ArrayList();
    public List<Choreographer.FrameCallback> spareToRunOnFrame = new ArrayList();
    public final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);

    public AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.choreographer = choreographer;
        this.handler = handler;
        this.frameClock = new AndroidUiFrameClock(choreographer, this);
    }

    public static final void access$performTrampolineDispatch(AndroidUiDispatcher androidUiDispatcher) {
        Runnable removeFirst;
        Runnable runnable;
        boolean z;
        Runnable removeFirst2;
        do {
            synchronized (androidUiDispatcher.lock) {
                ArrayDeque<Runnable> arrayDeque = androidUiDispatcher.toRunTrampolined;
                if (arrayDeque.isEmpty()) {
                    removeFirst = null;
                } else {
                    removeFirst = arrayDeque.removeFirst();
                }
                runnable = removeFirst;
            }
            while (runnable != null) {
                runnable.run();
                synchronized (androidUiDispatcher.lock) {
                    ArrayDeque<Runnable> arrayDeque2 = androidUiDispatcher.toRunTrampolined;
                    if (arrayDeque2.isEmpty()) {
                        removeFirst2 = null;
                    } else {
                        removeFirst2 = arrayDeque2.removeFirst();
                    }
                    runnable = removeFirst2;
                }
            }
            synchronized (androidUiDispatcher.lock) {
                if (androidUiDispatcher.toRunTrampolined.isEmpty()) {
                    z = false;
                    androidUiDispatcher.scheduledTrampolineDispatch = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.lock) {
            this.toRunTrampolined.addLast(block);
            if (!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if (!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}

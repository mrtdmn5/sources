package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: classes3.dex */
public final class AndroidSchedulers {
    public static final HandlerScheduler MAIN_THREAD;

    /* loaded from: classes3.dex */
    public static final class MainHolder {
        public static final HandlerScheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    static {
        try {
            HandlerScheduler handlerScheduler = MainHolder.DEFAULT;
            if (handlerScheduler != null) {
                MAIN_THREAD = handlerScheduler;
                return;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static HandlerScheduler mainThread() {
        HandlerScheduler handlerScheduler = MAIN_THREAD;
        if (handlerScheduler != null) {
            return handlerScheduler;
        }
        throw new NullPointerException("scheduler == null");
    }
}

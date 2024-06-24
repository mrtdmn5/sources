package androidx.compose.ui.platform;

import android.os.Looper;
import android.view.View;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public final class WindowRecomposerFactory$Companion$LifecycleAware$1 implements WindowRecomposerFactory {
    public static final WindowRecomposerFactory$Companion$LifecycleAware$1 INSTANCE = new WindowRecomposerFactory$Companion$LifecycleAware$1();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [T, androidx.compose.ui.platform.MotionDurationScaleImpl] */
    @Override // androidx.compose.ui.platform.WindowRecomposerFactory
    public final Recomposer createRecomposer(final View view) {
        boolean z;
        CoroutineContext coroutineContext;
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        LinkedHashMap linkedHashMap = WindowRecomposer_androidKt.animationScale;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        SynchronizedLazyImpl synchronizedLazyImpl = AndroidUiDispatcher.Main$delegate;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coroutineContext = (CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue();
        } else {
            coroutineContext = AndroidUiDispatcher.currentThread.get();
            if (coroutineContext == null) {
                throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
            }
        }
        CoroutineContext plus = coroutineContext.plus(emptyCoroutineContext);
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) plus.get(MonotonicFrameClock.Key.$$INSTANCE);
        Lifecycle lifecycle = null;
        if (monotonicFrameClock != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            Latch latch = pausableMonotonicFrameClock2.latch;
            synchronized (latch.lock) {
                latch._isOpen = false;
                Unit unit = Unit.INSTANCE;
            }
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = 0;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        MotionDurationScale motionDurationScale = (MotionDurationScale) plus.get(MotionDurationScale.Key.$$INSTANCE);
        MotionDurationScale motionDurationScale2 = motionDurationScale;
        if (motionDurationScale == null) {
            ?? motionDurationScaleImpl = new MotionDurationScaleImpl();
            ref$ObjectRef.element = motionDurationScaleImpl;
            motionDurationScale2 = motionDurationScaleImpl;
        }
        if (pausableMonotonicFrameClock != 0) {
            emptyCoroutineContext = pausableMonotonicFrameClock;
        }
        CoroutineContext plus2 = plus.plus(emptyCoroutineContext).plus(motionDurationScale2);
        final Recomposer recomposer = new Recomposer(plus2);
        synchronized (recomposer.stateLock) {
            recomposer.frameClockPaused = true;
            Unit unit2 = Unit.INSTANCE;
        }
        final ContextScope CoroutineScope = CoroutineScopeKt.CoroutineScope(plus2);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
        if (lifecycleOwner != null) {
            lifecycle = lifecycleOwner.getLifecycle();
        }
        Lifecycle lifecycle2 = lifecycle;
        if (lifecycle2 != null) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    view.removeOnAttachStateChangeListener(this);
                    recomposer.cancel();
                }
            });
            lifecycle2.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                /* compiled from: WindowRecomposer.android.kt */
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] r0 = new int[Lifecycle.Event.values().length];
                        try {
                            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_START.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            r0[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        $EnumSwitchMapping$0 = r0;
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    boolean z2;
                    int r13 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                    CancellableContinuation<Unit> cancellableContinuation = null;
                    if (r13 != 1) {
                        if (r13 != 2) {
                            if (r13 != 3) {
                                if (r13 == 4) {
                                    recomposer.cancel();
                                    return;
                                }
                                return;
                            } else {
                                Recomposer recomposer2 = recomposer;
                                synchronized (recomposer2.stateLock) {
                                    recomposer2.frameClockPaused = true;
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                return;
                            }
                        }
                        PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock3 != null) {
                            Latch latch2 = pausableMonotonicFrameClock3.latch;
                            synchronized (latch2.lock) {
                                synchronized (latch2.lock) {
                                    z2 = latch2._isOpen;
                                }
                                if (!z2) {
                                    List<Continuation<Unit>> list = latch2.awaiters;
                                    latch2.awaiters = latch2.spareList;
                                    latch2.spareList = list;
                                    latch2._isOpen = true;
                                    int size = list.size();
                                    for (int r1 = 0; r1 < size; r1++) {
                                        list.get(r1).resumeWith(Unit.INSTANCE);
                                    }
                                    list.clear();
                                    Unit unit4 = Unit.INSTANCE;
                                }
                            }
                        }
                        Recomposer recomposer3 = recomposer;
                        synchronized (recomposer3.stateLock) {
                            if (recomposer3.frameClockPaused) {
                                recomposer3.frameClockPaused = false;
                                cancellableContinuation = recomposer3.deriveStateLocked();
                            }
                        }
                        if (cancellableContinuation != null) {
                            cancellableContinuation.resumeWith(Unit.INSTANCE);
                            return;
                        }
                        return;
                    }
                    BuildersKt.launch$default(CoroutineScope, null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(ref$ObjectRef, recomposer, lifecycleOwner2, this, view, null), 1);
                }
            });
            return recomposer;
        }
        throw new IllegalStateException(("ViewTreeLifecycleOwner not found from " + view).toString());
    }
}

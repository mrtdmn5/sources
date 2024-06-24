package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public boolean backInvokedCallbackRegistered;
    public final AnonymousClass1 enabledChangedCallback;
    public final Runnable fallbackOnBackPressed;
    public OnBackInvokedDispatcher invokedDispatcher;
    public final OnBackInvokedCallback onBackInvokedCallback;
    public final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks = new ArrayDeque<>();

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0<Unit> onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    Function0 onBackInvoked2 = Function0.this;
                    Intrinsics.checkNotNullParameter(onBackInvoked2, "$onBackInvoked");
                    onBackInvoked2.invoke();
                }
            };
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int r3, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(r3, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        public OnBackPressedCancellable currentCancellable;
        public final Lifecycle lifecycle;
        public final OnBackPressedCallback onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            this.lifecycle.removeObserver(this);
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            onBackPressedCallback.getClass();
            onBackPressedCallback.cancellables.remove(this);
            OnBackPressedCancellable onBackPressedCancellable = this.currentCancellable;
            if (onBackPressedCancellable != null) {
                onBackPressedCancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
                onBackPressedDispatcher.getClass();
                OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
                onBackPressedDispatcher.onBackPressedCallbacks.addLast(onBackPressedCallback);
                OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedDispatcher, onBackPressedCallback);
                onBackPressedCallback.cancellables.add(onBackPressedCancellable);
                if (Build.VERSION.SDK_INT >= 33) {
                    onBackPressedDispatcher.updateBackInvokedCallbackState$activity_release();
                    onBackPressedCallback.enabledChangedCallback = onBackPressedDispatcher.enabledChangedCallback;
                }
                this.currentCancellable = onBackPressedCancellable;
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                OnBackPressedCancellable onBackPressedCancellable2 = this.currentCancellable;
                if (onBackPressedCancellable2 != null) {
                    onBackPressedCancellable2.cancel();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public final class OnBackPressedCancellable implements Cancellable {
        public final OnBackPressedCallback onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
            ArrayDeque<OnBackPressedCallback> arrayDeque = onBackPressedDispatcher.onBackPressedCallbacks;
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            arrayDeque.remove(onBackPressedCallback);
            onBackPressedCallback.getClass();
            onBackPressedCallback.cancellables.remove(this);
            if (Build.VERSION.SDK_INT >= 33) {
                onBackPressedCallback.enabledChangedCallback = null;
                onBackPressedDispatcher.updateBackInvokedCallbackState$activity_release();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.activity.OnBackPressedDispatcher$1] */
    public OnBackPressedDispatcher(Runnable runnable) {
        this.fallbackOnBackPressed = runnable;
        if (Build.VERSION.SDK_INT >= 33) {
            this.enabledChangedCallback = new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    OnBackPressedDispatcher.this.updateBackInvokedCallbackState$activity_release();
                    return Unit.INSTANCE;
                }
            };
            this.onBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    OnBackPressedDispatcher.this.onBackPressed();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void addCallback(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.cancellables.add(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        if (Build.VERSION.SDK_INT >= 33) {
            updateBackInvokedCallbackState$activity_release();
            onBackPressedCallback.enabledChangedCallback = this.enabledChangedCallback;
        }
    }

    public final void onBackPressed() {
        OnBackPressedCallback onBackPressedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled) {
                    break;
                }
            } else {
                onBackPressedCallback = null;
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void updateBackInvokedCallbackState$activity_release() {
        boolean z;
        OnBackInvokedCallback onBackInvokedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<OnBackPressedCallback> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (it.next().isEnabled) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.onBackInvokedCallback) != null) {
            Api33Impl api33Impl = Api33Impl.INSTANCE;
            if (z && !this.backInvokedCallbackRegistered) {
                api33Impl.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = true;
            } else if (!z && this.backInvokedCallbackRegistered) {
                api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }
}

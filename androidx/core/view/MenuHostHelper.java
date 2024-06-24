package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class MenuHostHelper {
    public final Runnable mOnInvalidateMenuCallback;
    public final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList<>();
    public final HashMap mProviderToLifecycleContainers = new HashMap();

    /* loaded from: classes.dex */
    public static class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public LifecycleEventObserver mObserver;

        public LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mObserver = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    public final void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.mProviderToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        hashMap.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = MenuHostHelper.this;
                menuHostHelper.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider);
                }
            }
        }));
    }

    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.mProviderToLifecycleContainers.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        this.mOnInvalidateMenuCallback.run();
    }

    @SuppressLint({"LambdaLast"})
    public final void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.mProviderToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        hashMap.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = MenuHostHelper.this;
                menuHostHelper.getClass();
                Lifecycle.State state2 = state;
                Lifecycle.Event upTo = Lifecycle.Event.upTo(state2);
                Runnable runnable = menuHostHelper.mOnInvalidateMenuCallback;
                CopyOnWriteArrayList<MenuProvider> copyOnWriteArrayList = menuHostHelper.mMenuProviders;
                MenuProvider menuProvider2 = menuProvider;
                if (event == upTo) {
                    copyOnWriteArrayList.add(menuProvider2);
                    runnable.run();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider2);
                } else if (event == Lifecycle.Event.downFrom(state2)) {
                    copyOnWriteArrayList.remove(menuProvider2);
                    runnable.run();
                }
            }
        }));
    }
}

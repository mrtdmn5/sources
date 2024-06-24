package com.animaconnected.secondo.screens;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: MainController.kt */
/* loaded from: classes3.dex */
public interface MainController {
    int getWatchLayoutWidth();

    WatchViewController getWatchViewController();

    void goBack();

    void gotoNextFragment(BaseFragment baseFragment);

    void gotoNextFragment(BaseFragment baseFragment, boolean z);

    void gotoNextFragmentWithAnimations(BaseFragment baseFragment, int r2, int r3, int r4, int r5);

    void gotoNextRevealedFragmentWithAnimations(BaseFragment baseFragment, int r2, int r3, int r4, int r5);

    void gotoOnboarding();

    void gotoRevealedFragment(BaseFragment baseFragment);

    void popUntilFragment(String str);

    void setWatchLayerAboveContent(boolean z);

    Object updateWatchAreaViews(int r1, Continuation<? super Unit> continuation);
}

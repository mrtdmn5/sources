package com.animaconnected.watch.behaviour.interfaces;

import kotlin.coroutines.Continuation;

/* compiled from: FindPhoneMusicPlayer.kt */
/* loaded from: classes3.dex */
public interface FindPhoneMusicPlayer {
    Object play(Music music, float f, Continuation<? super PlayResult> continuation);

    void stop();
}

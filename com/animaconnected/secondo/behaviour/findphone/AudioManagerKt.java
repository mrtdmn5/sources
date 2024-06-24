package com.animaconnected.secondo.behaviour.findphone;

import android.media.AudioManager;
import android.os.Build;
import com.animaconnected.secondo.KronabyApplication;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioManager.kt */
/* loaded from: classes3.dex */
public final class AudioManagerKt {
    public static final AudioManagerWrapper getAudioManagerWrapper(final Function0<Unit> lostFocus) {
        Intrinsics.checkNotNullParameter(lostFocus, "lostFocus");
        Object systemService = KronabyApplication.Companion.getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.animaconnected.secondo.behaviour.findphone.AudioManagerKt$$ExternalSyntheticLambda0
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int r2) {
                AudioManagerKt.getAudioManagerWrapper$lambda$0(Function0.this, r2);
            }
        };
        if (Build.VERSION.SDK_INT >= 26) {
            return new AndroidOAudioManager(audioManager, onAudioFocusChangeListener, null, 4, null);
        }
        return new OldAudioManager(audioManager, onAudioFocusChangeListener, null, 4, null);
    }

    public static final void getAudioManagerWrapper$lambda$0(Function0 lostFocus, int r2) {
        Intrinsics.checkNotNullParameter(lostFocus, "$lostFocus");
        if (r2 == -3 || r2 == -2 || r2 == -1) {
            lostFocus.invoke();
        }
    }
}

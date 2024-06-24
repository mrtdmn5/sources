package com.animaconnected.secondo.behaviour.findphone;

import android.media.AudioManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioManager.kt */
/* loaded from: classes3.dex */
public final class OldAudioManager implements AudioManagerWrapper {
    public static final int $stable = 8;
    private final AudioManager.OnAudioFocusChangeListener focusChangeListener;
    private final AudioManager manager;
    private Settings userSettings;

    public OldAudioManager(AudioManager manager, AudioManager.OnAudioFocusChangeListener focusChangeListener, Settings settings) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(focusChangeListener, "focusChangeListener");
        this.manager = manager;
        this.focusChangeListener = focusChangeListener;
        this.userSettings = settings;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public int abandonFocus() {
        return getManager().abandonAudioFocus(this.focusChangeListener);
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public AudioManager getManager() {
        return this.manager;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public Settings getUserSettings() {
        return this.userSettings;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public boolean requestFocus() {
        if (getManager().requestAudioFocus(this.focusChangeListener, getStream(), 2) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public void setUserSettings(Settings settings) {
        this.userSettings = settings;
    }

    public /* synthetic */ OldAudioManager(AudioManager audioManager, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Settings settings, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(audioManager, onAudioFocusChangeListener, (r4 & 4) != 0 ? null : settings);
    }
}

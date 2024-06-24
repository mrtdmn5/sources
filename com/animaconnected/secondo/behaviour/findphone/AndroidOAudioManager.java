package com.animaconnected.secondo.behaviour.findphone;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioManager.kt */
/* loaded from: classes3.dex */
public final class AndroidOAudioManager implements AudioManagerWrapper {
    public static final int $stable = 8;
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager manager;
    private Settings userSettings;

    public AndroidOAudioManager(AudioManager manager, AudioManager.OnAudioFocusChangeListener focusChangeListener, Settings settings) {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(focusChangeListener, "focusChangeListener");
        this.manager = manager;
        this.userSettings = settings;
        AudioAttributes build2 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AndroidOAudioManager$$ExternalSyntheticApiModelOutline6.m();
        audioAttributes = AndroidOAudioManager$$ExternalSyntheticApiModelOutline5.m().setAudioAttributes(build2);
        onAudioFocusChangeListener = audioAttributes.setOnAudioFocusChangeListener(focusChangeListener);
        build = onAudioFocusChangeListener.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.audioFocusRequest = build;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public int abandonFocus() {
        int abandonAudioFocusRequest;
        abandonAudioFocusRequest = getManager().abandonAudioFocusRequest(this.audioFocusRequest);
        return abandonAudioFocusRequest;
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
        int requestAudioFocus;
        requestAudioFocus = getManager().requestAudioFocus(this.audioFocusRequest);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper
    public void setUserSettings(Settings settings) {
        this.userSettings = settings;
    }

    public /* synthetic */ AndroidOAudioManager(AudioManager audioManager, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Settings settings, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(audioManager, onAudioFocusChangeListener, (r4 & 4) != 0 ? null : settings);
    }
}

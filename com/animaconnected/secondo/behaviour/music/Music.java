package com.animaconnected.secondo.behaviour.music;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Music.kt */
/* loaded from: classes3.dex */
public final class Music implements Pusher {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "music";
    public static final String TYPE = "Music";
    private final String analyticsName;
    private final MusicProvider musicProvider;
    private final String type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: Music.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Music(MusicProvider musicProvider) {
        Intrinsics.checkNotNullParameter(musicProvider, "musicProvider");
        this.musicProvider = musicProvider;
        this.type = TYPE;
        this.analyticsName = BEHAVIOUR_ANALYTICS_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.deactivated(slot);
        this.musicProvider.stopVolumeControl();
        this.musicProvider.revertSettings();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!this.musicProvider.hasButtonActionLongPressReleaseNotify()) {
            this.musicProvider.checkIfHIDSolutionWorks();
        }
        if (this.musicProvider.isNonHIDMusicControllerActive()) {
            this.musicProvider.nonHIDMusicController(action);
            return true;
        }
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}

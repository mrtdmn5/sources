package com.animaconnected.secondo.behaviour.findphone;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: AudioManager.kt */
/* loaded from: classes3.dex */
public final class Settings {
    public static final int $stable = 0;
    private final int mode;
    private final boolean speakerOn;
    private final int volume;

    public Settings(boolean z, int r2, int r3) {
        this.speakerOn = z;
        this.mode = r2;
        this.volume = r3;
    }

    public static /* synthetic */ Settings copy$default(Settings settings, boolean z, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = settings.speakerOn;
        }
        if ((r4 & 2) != 0) {
            r2 = settings.mode;
        }
        if ((r4 & 4) != 0) {
            r3 = settings.volume;
        }
        return settings.copy(z, r2, r3);
    }

    public final boolean component1() {
        return this.speakerOn;
    }

    public final int component2() {
        return this.mode;
    }

    public final int component3() {
        return this.volume;
    }

    public final Settings copy(boolean z, int r3, int r4) {
        return new Settings(z, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) obj;
        if (this.speakerOn == settings.speakerOn && this.mode == settings.mode && this.volume == settings.volume) {
            return true;
        }
        return false;
    }

    public final int getMode() {
        return this.mode;
    }

    public final boolean getSpeakerOn() {
        return this.speakerOn;
    }

    public final int getVolume() {
        return this.volume;
    }

    public int hashCode() {
        return Integer.hashCode(this.volume) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.mode, Boolean.hashCode(this.speakerOn) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Settings(speakerOn=");
        sb.append(this.speakerOn);
        sb.append(", mode=");
        sb.append(this.mode);
        sb.append(", volume=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.volume, ')');
    }
}

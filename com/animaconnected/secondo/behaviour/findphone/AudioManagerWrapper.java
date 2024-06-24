package com.animaconnected.secondo.behaviour.findphone;

import android.media.AudioManager;
import android.os.Build;
import com.animaconnected.logger.LogKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: AudioManager.kt */
/* loaded from: classes3.dex */
public interface AudioManagerWrapper {
    int abandonFocus();

    default void adjustVolume(float f) {
        final int streamMaxVolume = (int) (getManager().getStreamMaxVolume(getStream()) * f);
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper$adjustVolume$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Adjusting volume to: " + streamMaxVolume;
            }
        }, 7, (Object) null);
        getManager().setStreamVolume(getStream(), streamMaxVolume, 0);
    }

    default boolean currentlyInCall() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.findphone.AudioManagerWrapper$currentlyInCall$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder("currentlyInCall mode: ");
                sb.append(AudioManagerWrapper.this.getManager().getMode());
                sb.append(" in call: ");
                sb.append(AudioManagerWrapper.this.getManager().getMode() == 2);
                return sb.toString();
            }
        }, 7, (Object) null);
        if (getManager().getMode() == 2 || getManager().getMode() == 1) {
            return true;
        }
        return false;
    }

    AudioManager getManager();

    default int getStream() {
        return 3;
    }

    Settings getUserSettings();

    default void prepareForBlast() {
        AudioManager manager = getManager();
        setUserSettings(new Settings(manager.isSpeakerphoneOn(), manager.getMode(), manager.getStreamVolume(getStream())));
        AudioManager manager2 = getManager();
        int r1 = 1;
        manager2.setSpeakerphoneOn(true);
        if (!StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, "Sony")) {
            r1 = 3;
        }
        manager2.setMode(r1);
    }

    boolean requestFocus();

    default void returnToUserSettings() {
        Settings userSettings = getUserSettings();
        if (userSettings != null) {
            AudioManager manager = getManager();
            manager.setSpeakerphoneOn(userSettings.getSpeakerOn());
            manager.setMode(userSettings.getMode());
            manager.setStreamVolume(getStream(), userSettings.getVolume(), 0);
        }
    }

    void setUserSettings(Settings settings);
}

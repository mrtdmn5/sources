package com.animaconnected.secondo.behaviour.music;

import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.view.KeyEvent;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: MusicDataProvider.kt */
/* loaded from: classes3.dex */
public final class MusicDataProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int getVolumePercentage(MediaController.PlaybackInfo playbackInfo) {
        float currentVolume = playbackInfo.getCurrentVolume() / playbackInfo.getMaxVolume();
        if (currentVolume > 1.0f) {
            currentVolume = 1.0f;
        }
        return (int) (currentVolume * 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isWorking(PlaybackState playbackState) {
        Integer num;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{6, 8, 4, 3, 5, 10, 9, 11});
        if (playbackState != null) {
            num = Integer.valueOf(playbackState.getState());
        } else {
            num = null;
        }
        return CollectionsKt___CollectionsKt.contains(listOf, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendAction(MediaController mediaController, int r3) {
        mediaController.dispatchMediaButtonEvent(new KeyEvent(0, r3));
        mediaController.dispatchMediaButtonEvent(new KeyEvent(1, r3));
    }
}

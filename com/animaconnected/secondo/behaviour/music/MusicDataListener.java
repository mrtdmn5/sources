package com.animaconnected.secondo.behaviour.music;

import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;

/* compiled from: MusicDataProvider.kt */
/* loaded from: classes3.dex */
public interface MusicDataListener {
    void onInfo(MusicInfo musicInfo);

    void onPlaybackChange(MusicPlayback musicPlayback);

    void onSessionFinished();

    void onVolumeChange(int r1);
}

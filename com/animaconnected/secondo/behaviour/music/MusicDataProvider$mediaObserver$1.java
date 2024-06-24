package com.animaconnected.secondo.behaviour.music;

import android.content.ContentResolver;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MusicDataProvider.kt */
/* loaded from: classes3.dex */
public final class MusicDataProvider$mediaObserver$1 extends MediaController.Callback {
    final /* synthetic */ MusicDataProvider this$0;

    public MusicDataProvider$mediaObserver$1(MusicDataProvider musicDataProvider) {
        this.this$0 = musicDataProvider;
    }

    @Override // android.media.session.MediaController.Callback
    public void onMetadataChanged(MediaMetadata mediaMetadata) {
        MusicInfo musicInfo;
        String str;
        MusicInfo musicInfo2;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (mediaMetadata != null) {
            musicInfo = this.this$0.getMusicInfo(mediaMetadata);
        } else {
            musicInfo = null;
        }
        str = this.this$0.tag;
        LogKt.verbose$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$mediaObserver$1$onMetadataChanged$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onMetadataChanged";
            }
        }, 6, (Object) null);
        if (musicInfo != null) {
            musicInfo2 = this.this$0.musicInfo;
            if (!Intrinsics.areEqual(musicInfo2, musicInfo)) {
                this.this$0.playback = null;
                copyOnWriteArrayList = this.this$0.listeners;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((MusicDataListener) it.next()).onInfo(musicInfo);
                }
                this.this$0.musicInfo = musicInfo;
            }
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onPlaybackStateChanged(PlaybackState playbackState) {
        String str;
        MusicPlayback musicPlayback;
        String str2;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (playbackState == null) {
            return;
        }
        final MusicPlayback musicPlayback2 = new MusicPlayback(playbackState.getPosition(), playbackState.getState());
        str = this.this$0.tag;
        final MusicDataProvider musicDataProvider = this.this$0;
        LogKt.verbose$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$mediaObserver$1$onPlaybackStateChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                MusicPlayback musicPlayback3;
                StringBuilder sb = new StringBuilder("onPlaybackStateChanged. new: ");
                sb.append(MusicPlayback.this);
                sb.append(" old: ");
                musicPlayback3 = musicDataProvider.playback;
                sb.append(musicPlayback3);
                return sb.toString();
            }
        }, 6, (Object) null);
        musicPlayback = this.this$0.playback;
        if (!Intrinsics.areEqual(musicPlayback2, musicPlayback)) {
            copyOnWriteArrayList = this.this$0.listeners;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((MusicDataListener) it.next()).onPlaybackChange(musicPlayback2);
            }
            this.this$0.playback = musicPlayback2;
            return;
        }
        str2 = this.this$0.tag;
        LogKt.verbose$default((Object) this, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$mediaObserver$1$onPlaybackStateChanged$3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onPlaybackStateChanged throttled. Duplicate or similar data";
            }
        }, 6, (Object) null);
    }

    @Override // android.media.session.MediaController.Callback
    public void onSessionDestroyed() {
        String str;
        MediaController mediaController;
        CopyOnWriteArrayList copyOnWriteArrayList;
        ContentResolver contentResolver;
        MusicDataProvider$volumeObserver$1 musicDataProvider$volumeObserver$1;
        str = this.this$0.tag;
        LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$mediaObserver$1$onSessionDestroyed$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onSessionDestroyed";
            }
        }, 6, (Object) null);
        this.this$0.musicInfo = null;
        this.this$0.playback = null;
        mediaController = this.this$0.controller;
        if (mediaController != null) {
            mediaController.unregisterCallback(this);
        }
        this.this$0.controller = null;
        copyOnWriteArrayList = this.this$0.listeners;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ((MusicDataListener) it.next()).onSessionFinished();
        }
        contentResolver = this.this$0.cr;
        musicDataProvider$volumeObserver$1 = this.this$0.volumeObserver;
        contentResolver.unregisterContentObserver(musicDataProvider$volumeObserver$1);
    }
}

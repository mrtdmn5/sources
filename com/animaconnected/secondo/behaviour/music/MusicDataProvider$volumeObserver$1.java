package com.animaconnected.secondo.behaviour.music;

import android.database.ContentObserver;
import android.media.session.MediaController;
import com.animaconnected.logger.LogKt;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

/* compiled from: MusicDataProvider.kt */
/* loaded from: classes3.dex */
public final class MusicDataProvider$volumeObserver$1 extends ContentObserver {
    private int currentVolumePercentage;
    final /* synthetic */ MusicDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicDataProvider$volumeObserver$1(MusicDataProvider musicDataProvider) {
        super(null);
        MediaController mediaController;
        int r2;
        MediaController.PlaybackInfo playbackInfo;
        this.this$0 = musicDataProvider;
        mediaController = musicDataProvider.controller;
        if (mediaController != null && (playbackInfo = mediaController.getPlaybackInfo()) != null) {
            r2 = MusicDataProviderKt.getVolumePercentage(playbackInfo);
        } else {
            r2 = 0;
        }
        this.currentVolumePercentage = r2;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        MediaController mediaController;
        final int r9;
        String str;
        CopyOnWriteArrayList copyOnWriteArrayList;
        MediaController.PlaybackInfo playbackInfo;
        mediaController = this.this$0.controller;
        if (mediaController != null && (playbackInfo = mediaController.getPlaybackInfo()) != null) {
            r9 = MusicDataProviderKt.getVolumePercentage(playbackInfo);
        } else {
            r9 = 0;
        }
        if (this.currentVolumePercentage != r9) {
            str = this.this$0.tag;
            LogKt.verbose$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$volumeObserver$1$onChange$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onVolumeChange: " + r9;
                }
            }, 6, (Object) null);
            copyOnWriteArrayList = this.this$0.listeners;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((MusicDataListener) it.next()).onVolumeChange(r9);
            }
            this.currentVolumePercentage = r9;
        }
    }
}

package com.animaconnected.secondo.behaviour.music;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.service.notification.StatusBarNotification;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.notification.handler.NotificationHandler;
import com.animaconnected.secondo.notification.receiver.NotificationReceiver;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: MusicDataProvider.kt */
/* loaded from: classes3.dex */
public final class MusicDataProvider implements NotificationHandler {
    public static final int $stable = 8;
    private final ComponentName componentName;
    private MediaController controller;
    private final ContentResolver cr;
    private final CopyOnWriteArrayList<MusicDataListener> listeners = new CopyOnWriteArrayList<>();
    private final MusicDataProvider$mediaObserver$1 mediaObserver;
    private final MediaSessionManager mediaSessionManager;
    private MusicInfo musicInfo;
    private MusicPlayback playback;
    private final String tag;
    private final MusicDataProvider$volumeObserver$1 volumeObserver;

    public MusicDataProvider() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        this.componentName = new ComponentName(companion.getContext(), (Class<?>) NotificationReceiver.class);
        Object systemService = companion.getContext().getSystemService("media_session");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        this.mediaSessionManager = (MediaSessionManager) systemService;
        this.cr = companion.getContext().getContentResolver();
        this.tag = "MusicDataProvider";
        this.volumeObserver = new MusicDataProvider$volumeObserver$1(this);
        this.mediaObserver = new MusicDataProvider$mediaObserver$1(this);
    }

    private final Job connectController(MediaController mediaController) {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new MusicDataProvider$connectController$1(this, mediaController, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicInfo getMusicInfo(MediaMetadata mediaMetadata) {
        String string = mediaMetadata.getString("android.media.metadata.ARTIST");
        if (string == null) {
            string = StringsExtensionsKt.getFirmwareString(Key.not_available);
        }
        String string2 = mediaMetadata.getString("android.media.metadata.TITLE");
        if (string2 == null) {
            string2 = StringsExtensionsKt.getFirmwareString(Key.not_available);
        }
        String string3 = mediaMetadata.getString("android.media.metadata.ALBUM");
        if (string3 == null) {
            string3 = StringsExtensionsKt.getFirmwareString(Key.not_available);
        }
        int r3 = Duration.$r8$clinit;
        return new MusicInfo(string, string2, string3, (int) Duration.m1679getInWholeSecondsimpl(DurationKt.toDuration(mediaMetadata.getLong("android.media.metadata.DURATION"), DurationUnit.MILLISECONDS)));
    }

    private final void updateController() {
        PlaybackState playbackState;
        boolean isWorking;
        Object obj;
        boolean isWorking2;
        final MediaController mediaController = this.controller;
        MediaSession.Token token = null;
        if (mediaController != null) {
            playbackState = mediaController.getPlaybackState();
        } else {
            playbackState = null;
        }
        isWorking = MusicDataProviderKt.isWorking(playbackState);
        if (isWorking) {
            LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$updateController$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Current controller is already in state ");
                    MediaController mediaController2 = mediaController;
                    sb.append(mediaController2 != null ? mediaController2.getPlaybackState() : null);
                    sb.append(", no need to swap");
                    return sb.toString();
                }
            }, 6, (Object) null);
            return;
        }
        if (!NotificationUtil.isEnabled(KronabyApplication.Companion.getContext())) {
            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$updateController$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Notification access not granted, not checking media controls";
                }
            }, 6, (Object) null);
            return;
        }
        List<MediaController> activeSessions = this.mediaSessionManager.getActiveSessions(this.componentName);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                isWorking2 = MusicDataProviderKt.isWorking(((MediaController) obj).getPlaybackState());
                if (isWorking2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaController mediaController2 = (MediaController) obj;
        if (mediaController2 == null && mediaController == null) {
            mediaController2 = (MediaController) CollectionsKt___CollectionsKt.firstOrNull((List) activeSessions);
        }
        MediaController mediaController3 = mediaController2;
        if (mediaController3 == null) {
            return;
        }
        if (mediaController != null) {
            token = mediaController.getSessionToken();
        }
        if (Intrinsics.areEqual(token, mediaController3.getSessionToken())) {
            LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$updateController$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "New controller is same as the current one";
                }
            }, 6, (Object) null);
        } else {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$updateController$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "New controller";
                }
            }, 6, (Object) null);
            connectController(mediaController3);
        }
    }

    public final void addListener(final MusicDataListener listener) {
        int r0;
        MediaController.PlaybackInfo playbackInfo;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$addListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Adding MusicDataListener " + MusicDataListener.this;
            }
        }, 6, (Object) null);
        updateController();
        this.listeners.add(listener);
        MusicInfo musicInfo = this.musicInfo;
        if (musicInfo != null) {
            listener.onInfo(musicInfo);
        }
        MusicPlayback musicPlayback = this.playback;
        if (musicPlayback != null) {
            listener.onPlaybackChange(musicPlayback);
        }
        MediaController mediaController = this.controller;
        if (mediaController != null && (playbackInfo = mediaController.getPlaybackInfo()) != null) {
            r0 = MusicDataProviderKt.getVolumePercentage(playbackInfo);
        } else {
            r0 = 0;
        }
        listener.onVolumeChange(r0);
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public boolean canHandle(String str, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Intrinsics.areEqual(str, "transport") && (!this.listeners.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handle(StatusBarNotification sbn, long j) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        updateController();
    }

    public final void next() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            MusicDataProviderKt.sendAction(mediaController, 87);
        }
    }

    public final void previous() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            MusicDataProviderKt.sendAction(mediaController, 88);
        }
    }

    public final void removeListener(final MusicDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicDataProvider$removeListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Removing MusicDataListener " + MusicDataListener.this;
            }
        }, 6, (Object) null);
        this.listeners.remove(listener);
    }

    public final void togglePlayPause() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            MusicDataProviderKt.sendAction(mediaController, 85);
        }
    }

    public final void volumeDown() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            mediaController.adjustVolume(-1, 0);
        }
    }

    public final void volumeUp() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            mediaController.adjustVolume(1, 0);
        }
    }
}

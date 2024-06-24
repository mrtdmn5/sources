package com.animaconnected.secondo.behaviour.music;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.behaviour.types.MusicWatchApp;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.VisibilityState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;

/* compiled from: MusicWatchAppAndroid.kt */
/* loaded from: classes3.dex */
public final class MusicWatchAppAndroid extends MusicWatchApp implements MusicDataListener, Pusher {
    public static final String TYPE = "MusicDisplay";
    private Function0<Boolean> checkPermissions;
    private final AppId id;
    private MusicInfo info;
    private MusicDataProvider musicProvider;
    private MusicPlayback playback;
    private Job volumeJob;
    private DisplayWatch watch;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MusicWatchAppAndroid.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: MusicWatchAppAndroid.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] r0 = new int[ButtonAction.values().length];
            try {
                r0[ButtonAction.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ButtonAction.DoublePress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ButtonAction.TriplePress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[ButtonAction.DoubleLongPress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[ButtonAction.TripleLongPress.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[ButtonAction.LongPressRelease.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[MusicPlayback.State.values().length];
            try {
                r02[MusicPlayback.State.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r02[MusicPlayback.State.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r02[MusicPlayback.State.FAST_FORWARDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r02[MusicPlayback.State.STOPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = r02;
            int[] r03 = new int[AppAction.values().length];
            try {
                r03[AppAction.MusicStartPause.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                r03[AppAction.MusicNext.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                r03[AppAction.MusicPrev.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                r03[AppAction.MusicVolumeUp.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                r03[AppAction.MusicVolumeDown.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = r03;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicWatchAppAndroid(Function0<Boolean> checkPermissions) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(checkPermissions, "checkPermissions");
        this.checkPermissions = checkPermissions;
        this.musicProvider = ProviderFactory.getMusicDataProvider();
        this.info = new MusicInfo("", "", "", 0);
        this.id = AppId.Music;
    }

    private final void adjustVolume(Function0<Unit> function0) {
        CoroutineScope scope;
        Job job = this.volumeJob;
        StandaloneCoroutine standaloneCoroutine = null;
        if (job != null) {
            job.cancel(null);
        }
        DisplayWatch displayWatch = this.watch;
        if (displayWatch != null && (scope = displayWatch.getScope()) != null) {
            standaloneCoroutine = BuildersKt.launch$default(scope, null, null, new MusicWatchAppAndroid$adjustVolume$1(function0, null), 3);
        }
        this.volumeJob = standaloneCoroutine;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(watch, "watch");
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        this.watch = displayWatch;
        this.musicProvider.addListener(this);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = null;
        this.musicProvider.removeListener(this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        switch (WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
            case 1:
                this.musicProvider.togglePlayPause();
                return true;
            case 2:
                this.musicProvider.next();
                return true;
            case 3:
                this.musicProvider.previous();
                return true;
            case 4:
                adjustVolume(new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$execute$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MusicDataProvider musicDataProvider;
                        musicDataProvider = MusicWatchAppAndroid.this.musicProvider;
                        musicDataProvider.volumeUp();
                    }
                });
                return true;
            case 5:
                adjustVolume(new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$execute$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MusicDataProvider musicDataProvider;
                        musicDataProvider = MusicWatchAppAndroid.this.musicProvider;
                        musicDataProvider.volumeDown();
                    }
                });
                return true;
            case 6:
                Job job = this.volumeJob;
                if (job != null) {
                    job.cancel(null);
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.animaconnected.watch.behaviour.types.MusicWatchApp, com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.behaviour.types.MusicWatchApp, com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    public final MusicInfo getInfo() {
        return this.info;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp, com.animaconnected.watch.display.WatchApp
    public void onAppAction(int r1, AppAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int r12 = WhenMappings.$EnumSwitchMapping$2[action.ordinal()];
        if (r12 != 1) {
            if (r12 != 2) {
                if (r12 != 3) {
                    if (r12 != 4) {
                        if (r12 == 5) {
                            this.musicProvider.volumeDown();
                            return;
                        }
                        return;
                    }
                    this.musicProvider.volumeUp();
                    return;
                }
                this.musicProvider.previous();
                return;
            }
            this.musicProvider.next();
            return;
        }
        this.musicProvider.togglePlayPause();
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onInfo(final MusicInfo info) {
        MusicPlayback musicPlayback;
        Intrinsics.checkNotNullParameter(info, "info");
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onInfo$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "New info " + MusicInfo.this;
            }
        }, 7, (Object) null);
        this.info = info;
        DisplayWatch displayWatch = this.watch;
        if (displayWatch == null || (musicPlayback = this.playback) == null) {
            return;
        }
        BuildersKt.launch$default(displayWatch.getScope(), null, null, new MusicWatchAppAndroid$onInfo$2(displayWatch, info, musicPlayback, null), 3);
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onPlaybackChange(final MusicPlayback playback) {
        Intrinsics.checkNotNullParameter(playback, "playback");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onPlaybackChange$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onPlaybackChange " + MusicPlayback.this;
            }
        }, 7, (Object) null);
        this.playback = playback;
        DisplayWatch displayWatch = this.watch;
        if (displayWatch == null) {
            return;
        }
        int r1 = WhenMappings.$EnumSwitchMapping$1[playback.getState().ordinal()];
        if (r1 != 1 && r1 != 2 && r1 != 3 && r1 != 4) {
            LogKt.verbose$default((Object) this, "MusicWatchApp", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onPlaybackChange$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Not handling media state " + MusicPlayback.this.getState();
                }
            }, 6, (Object) null);
        } else {
            BuildersKt.launch$default(displayWatch.getScope(), null, null, new MusicWatchAppAndroid$onPlaybackChange$2(displayWatch, this, playback, null), 3);
        }
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onSessionFinished() {
        DisplayWatch displayWatch = this.watch;
        if (displayWatch == null) {
            return;
        }
        LogKt.verbose$default((Object) this, "MusicWatchApp", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onSessionFinished$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onSessionFinished. Notifying watch with: Stopped";
            }
        }, 6, (Object) null);
        BuildersKt.launch$default(displayWatch.getScope(), null, null, new MusicWatchAppAndroid$onSessionFinished$2(displayWatch, this, null), 3);
    }

    @Override // com.animaconnected.watch.display.FirmwareApp, com.animaconnected.watch.display.WatchApp
    public void onStateChanged(VisibilityState state) {
        DisplayWatch displayWatch;
        CoroutineScope scope;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == VisibilityState.Glanceable && !getCheckPermissions().invoke().booleanValue() && (displayWatch = this.watch) != null && (scope = displayWatch.getScope()) != null) {
            BuildersKt.launch$default(scope, null, null, new MusicWatchAppAndroid$onStateChanged$1(this, null), 3);
        }
        LogKt.debug$default((Object) this, "onStateChanged " + state, (String) null, (Throwable) null, false, 14, (Object) null);
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onVolumeChange(int r5) {
        DisplayWatch displayWatch = this.watch;
        if (displayWatch == null) {
            return;
        }
        BuildersKt.launch$default(displayWatch.getScope(), null, null, new MusicWatchAppAndroid$onVolumeChange$1(displayWatch, r5, null), 3);
    }

    @Override // com.animaconnected.watch.behaviour.types.MusicWatchApp
    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    public final void setInfo(MusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "<set-?>");
        this.info = musicInfo;
    }
}

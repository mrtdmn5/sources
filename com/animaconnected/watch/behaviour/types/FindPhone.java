package com.animaconnected.watch.behaviour.types;

import com.animaconnected.firebase.AppEvents;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.behaviour.interfaces.FindPhoneListener;
import com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.interfaces.PlayResult;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.WatchAppAnimation;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.BasicView;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.RemoteAppViewsKt;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import j$.time.Month;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.datetime.LocalDateTime;

/* compiled from: FindPhone.kt */
/* loaded from: classes3.dex */
public final class FindPhone extends RemoteAppImpl implements Pusher {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    public static final String TYPE;
    private final String analyticsName;
    private final AppEvents appAnalytics;
    private final Set<FindPhoneListener> findPhoneListeners;
    private final Mitmap icon;
    private final AppId id;
    private boolean isPlaying;
    private long lastTimestampMusicEnded;
    private final FindPhoneMusicPlayer musicPlayer;
    private final QuickActionType quickActionType;
    private final String settingsSoundId;
    private final String settingsSoundIdBeforeChristmas;
    private final KeyString startDisplayTitle;
    private final KeyString stopDisplayTitle;
    private final BasicStorage storage;
    private final int timeoutBeforeVolumeResetMS;
    private final String type;
    private final Float[] volumeModel;

    /* compiled from: FindPhone.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(FindPhone.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TYPE = simpleName;
        String simpleName2 = Reflection.getOrCreateKotlinClass(FindPhone.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName2);
        TAG = simpleName2;
    }

    public /* synthetic */ FindPhone(FindPhoneMusicPlayer findPhoneMusicPlayer, Set set, QuickActionType quickActionType, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(findPhoneMusicPlayer, set, (r4 & 4) != 0 ? QuickActionType.Button : quickActionType);
    }

    private final void changeMusicIfChristmas() {
        Music musicBeforeChristmas;
        if (isChristmasPeriod()) {
            if (getMusicBeforeChristmas() == Music.NotSet) {
                setMusicBeforeChristmas(getCurrentMusic());
                setCurrentMusic(Music.Christmas);
                LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$changeMusicIfChristmas$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Christmas is here!";
                    }
                }, 6, (Object) null);
                return;
            }
            return;
        }
        if (getCurrentMusic() == Music.Christmas) {
            Music musicBeforeChristmas2 = getMusicBeforeChristmas();
            Music music = Music.NotSet;
            if (musicBeforeChristmas2 == music) {
                musicBeforeChristmas = Music.Normal;
            } else {
                musicBeforeChristmas = getMusicBeforeChristmas();
            }
            setCurrentMusic(musicBeforeChristmas);
            setMusicBeforeChristmas(music);
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$changeMusicIfChristmas$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Christmas is over!";
                }
            }, 6, (Object) null);
        }
    }

    private final Music getCurrentMusic() {
        int r1;
        Music.Companion companion = Music.Companion;
        Integer num = this.storage.getInt(this.settingsSoundId);
        if (num != null) {
            r1 = num.intValue();
        } else {
            r1 = 0;
        }
        return companion.fromId(r1);
    }

    private final Music getMusicBeforeChristmas() {
        int r1;
        Music.Companion companion = Music.Companion;
        Integer num = this.storage.getInt(this.settingsSoundIdBeforeChristmas);
        if (num != null) {
            r1 = num.intValue();
        } else {
            r1 = -1;
        }
        return companion.fromId(r1);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.animaconnected.watch.behaviour.interfaces.PlayResult] */
    public final void playMusic(String str, CoroutineScope coroutineScope) {
        if (this.isPlaying) {
            return;
        }
        int r0 = 1;
        this.isPlaying = true;
        changeMusicIfChristmas();
        Music currentMusic = getCurrentMusic();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        if (DateTimeUtilsKt.currentTimeMillis() - this.lastTimestampMusicEnded > this.timeoutBeforeVolumeResetMS) {
            r0 = 0;
        }
        ref$IntRef.element = r0;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = PlayResult.Finished;
        this.appAnalytics.sendFindPhoneSoundPlayed(currentMusic.name(), str);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new FindPhone$playMusic$1(this, ref$IntRef, ref$ObjectRef, currentMusic, null), 2);
    }

    private final void setCurrentMusic(Music music) {
        this.storage.put(this.settingsSoundId, music.getId());
    }

    private final void setMusicBeforeChristmas(Music music) {
        this.storage.put(this.settingsSoundIdBeforeChristmas, music.getId());
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return (Slot[]) ArraysKt___ArraysJvmKt.plus(Slot.Companion.getPushers(), Slot.Display);
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        String str;
        Intrinsics.checkNotNullParameter(action, "action");
        if (action != ButtonAction.Press && action != ButtonAction.LongPress && action != ButtonAction.UltraLongPress) {
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$execute$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Wrong button combination to activate Find phone";
                }
            }, 6, (Object) null);
            return false;
        }
        if (this.isPlaying) {
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$execute$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Currently playing, stop playing.";
                }
            }, 6, (Object) null);
            stopMusic();
            return false;
        }
        if (action == ButtonAction.UltraLongPress) {
            str = "crown";
        } else {
            str = "pusher";
        }
        playMusic(str, ServiceLocator.INSTANCE.getScope());
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Display[]{RemoteAppViewsKt.basicView(this, this.startDisplayTitle, new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                final FindPhone findPhone = FindPhone.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                        invoke2(display);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Display display) {
                        Intrinsics.checkNotNullParameter(display, "$this$null");
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.findphone_start);
                        final FindPhone findPhone2 = FindPhone.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone.getDisplays.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(1);
                                button.setAnimation(Integer.valueOf(WatchAppAnimation.None.getId()));
                                final FindPhone findPhone3 = FindPhone.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone.getDisplays.1.1.1.1

                                    /* compiled from: FindPhone.kt */
                                    @DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$1$1$1$1$1", f = "FindPhone.kt", l = {}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes3.dex */
                                    public static final class C00981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        private /* synthetic */ Object L$0;
                                        int label;
                                        final /* synthetic */ FindPhone this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public C00981(FindPhone findPhone, Continuation<? super C00981> continuation) {
                                            super(2, continuation);
                                            this.this$0 = findPhone;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            C00981 c00981 = new C00981(this.this$0, continuation);
                                            c00981.L$0 = obj;
                                            return c00981;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                            if (this.label == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.this$0.playMusic("watchapp", (CoroutineScope) this.L$0);
                                                return Unit.INSTANCE;
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

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
                                        CoroutineScope scope;
                                        DisplayWatch displayWatch$watch_release = FindPhone.this.getDisplayWatch$watch_release();
                                        if (displayWatch$watch_release == null || (scope = displayWatch$watch_release.getScope()) == null) {
                                            return;
                                        }
                                        BuildersKt.launch$default(scope, null, null, new C00981(FindPhone.this, null), 3);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, this.stopDisplayTitle, new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                final FindPhone findPhone = FindPhone.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                        invoke2(display);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Display display) {
                        Intrinsics.checkNotNullParameter(display, "$this$null");
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.findphone_stop);
                        final FindPhone findPhone2 = FindPhone.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone.getDisplays.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(0);
                                button.setAnimation(Integer.valueOf(WatchAppAnimation.None.getId()));
                                final FindPhone findPhone3 = FindPhone.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone.getDisplays.2.1.1.1

                                    /* compiled from: FindPhone.kt */
                                    @DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$2$1$1$1$1", f = "FindPhone.kt", l = {}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$2$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes3.dex */
                                    public static final class C01011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        int label;
                                        final /* synthetic */ FindPhone this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public C01011(FindPhone findPhone, Continuation<? super C01011> continuation) {
                                            super(2, continuation);
                                            this.this$0 = findPhone;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C01011(this.this$0, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                            if (this.label == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.this$0.stopMusic();
                                                return Unit.INSTANCE;
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C01011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

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
                                        CoroutineScope scope;
                                        DisplayWatch displayWatch$watch_release = FindPhone.this.getDisplayWatch$watch_release();
                                        if (displayWatch$watch_release == null || (scope = displayWatch$watch_release.getScope()) == null) {
                                            return;
                                        }
                                        BuildersKt.launch$default(scope, null, null, new C01011(FindPhone.this, null), 3);
                                    }
                                });
                            }
                        });
                    }
                });
                basicView.setBottomPusher(new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.types.FindPhone$getDisplays$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
                        bottomPusher.setNavCommand(-1);
                        bottomPusher.setAnimation(Integer.valueOf(WatchAppAnimation.None.getId()));
                    }
                });
            }
        })});
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public QuickActionType getQuickActionType() {
        return this.quickActionType;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_find_phone);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    public final Music getUserPreferredMusic() {
        changeMusicIfChristmas();
        return getCurrentMusic();
    }

    public final boolean isChristmasPeriod() {
        LocalDateTime localDateTime$default = DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null);
        if (localDateTime$default.getMonth() == Month.DECEMBER) {
            return true;
        }
        if (localDateTime$default.getMonth() == Month.JANUARY && localDateTime$default.getDayOfMonth() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean isExecuting() {
        return this.isPlaying;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.display.WatchApp
    public void onStateChanged(VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == VisibilityState.Stopped) {
            stopMusic();
        }
        super.onStateChanged(state);
    }

    public final boolean registerFindPhoneListener(FindPhoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.findPhoneListeners.add(listener);
    }

    public final void setUserPreferredMusic(Music music) {
        Intrinsics.checkNotNullParameter(music, "music");
        Music currentMusic = getCurrentMusic();
        if (currentMusic == music) {
            return;
        }
        if (music == Music.Christmas) {
            setMusicBeforeChristmas(currentMusic);
        }
        this.appAnalytics.sendFindPhoneSoundChanged(currentMusic.name(), music.name());
        setCurrentMusic(music);
    }

    public final void stopMusic() {
        if (!this.isPlaying) {
            return;
        }
        this.isPlaying = false;
        CoroutineScope scope = ServiceLocator.INSTANCE.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new FindPhone$stopMusic$1(this, null), 2);
    }

    public final boolean unregisterFindPhoneListener(FindPhoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.findPhoneListeners.remove(listener);
    }

    public FindPhone(FindPhoneMusicPlayer musicPlayer, Set<FindPhoneListener> findPhoneListeners, QuickActionType quickActionType) {
        Intrinsics.checkNotNullParameter(musicPlayer, "musicPlayer");
        Intrinsics.checkNotNullParameter(findPhoneListeners, "findPhoneListeners");
        Intrinsics.checkNotNullParameter(quickActionType, "quickActionType");
        this.musicPlayer = musicPlayer;
        this.findPhoneListeners = findPhoneListeners;
        this.quickActionType = quickActionType;
        this.timeoutBeforeVolumeResetMS = 15000;
        Float valueOf = Float.valueOf(0.9f);
        this.volumeModel = new Float[]{Float.valueOf(0.6f), valueOf, valueOf};
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.icon = MitmapBackend.getMitmap$default(serviceLocator.getMitmapBackend(), WatchAsset.Find_Phone_App_Icon, null, 2, null);
        this.type = TYPE;
        this.analyticsName = "find_phone";
        this.id = AppId.FindPhone;
        this.startDisplayTitle = StringsExtensionsKt.getKeyString(Key.findphone_start_title);
        this.stopDisplayTitle = StringsExtensionsKt.getKeyString(Key.findphone_stop_title);
        this.settingsSoundId = "soundId";
        this.settingsSoundIdBeforeChristmas = "soundIdBeforeChristmas";
        this.storage = serviceLocator.getStorageFactory().createStorage(getType());
        this.appAnalytics = serviceLocator.getAnalytics().getAppEvents();
    }
}

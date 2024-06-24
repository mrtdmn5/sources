package com.animaconnected.watch.behaviour.distress;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
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
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Distress.kt */
/* loaded from: classes3.dex */
public final class Distress extends RemoteAppImpl implements Pusher {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "distress";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE;
    private final String analyticsName;
    private Function0<Boolean> checkPermissions;
    private Function0<Boolean> checkSetupNeeded;
    private final DistressInterface distressInterface;
    private final Mitmap icon;
    private final AppId id;
    private final QuickActionType quickActionType;
    private final CoroutineScope scope;
    private final String type;

    /* compiled from: Distress.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Distress.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WalkMeHomeState.values().length];
            try {
                r0[WalkMeHomeState.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WalkMeHomeState.Distress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(Distress.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TYPE = simpleName;
    }

    public /* synthetic */ Distress(DistressInterface distressInterface, QuickActionType quickActionType, Function0 function0, Function0 function02, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(distressInterface, (r5 & 2) != 0 ? QuickActionType.Button : quickActionType, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNotShowingDisplay(int... r7) {
        Integer currentDisplay;
        int length = r7.length;
        int r2 = 0;
        while (true) {
            boolean z = true;
            if (r2 >= length) {
                return true;
            }
            int r4 = r7[r2];
            Integer currentDisplay2 = getCurrentDisplay();
            if (currentDisplay2 != null && currentDisplay2.intValue() == r4 && ((currentDisplay = getCurrentDisplay()) == null || currentDisplay.intValue() != r4 || getNavigatingToDisplayId() == null)) {
                z = false;
            }
            if (!z) {
                return false;
            }
            r2++;
        }
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action == ButtonAction.Press) {
            this.distressInterface.startSharingLocation();
            return true;
        }
        if (action == ButtonAction.LongPress && getHybridWatch() != null) {
            this.distressInterface.startEmergency();
            return true;
        }
        if (action == ButtonAction.DoublePress && getDisplayWatch$watch_release() != null) {
            this.distressInterface.startEmergency();
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckSetupNeeded() {
        return this.checkSetupNeeded;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Display[]{RemoteAppViewsKt.basicView(this, getTitle(), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$1
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
                final Distress distress = Distress.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$1.1
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
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.walk_me_home_start_sharing);
                        final Distress distress2 = Distress.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.1.1.1
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
                                final Distress distress3 = Distress.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.1.1.1.1
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
                                        DistressInterface distressInterface;
                                        distressInterface = Distress.this.distressInterface;
                                        distressInterface.startSharingLocation();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.walk_me_home_sharing_location), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$2
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
                final Distress distress = Distress.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$2.1
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
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.walk_me_home_emergency_title);
                        final Distress distress2 = Distress.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.2.1.1
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
                                button.setNavCommand(3);
                                final Distress distress3 = Distress.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.2.1.1.1
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
                                        DistressInterface distressInterface;
                                        distressInterface = Distress.this.distressInterface;
                                        distressInterface.startEmergency();
                                    }
                                });
                            }
                        });
                        DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.walk_me_home_stop_sharing), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.2.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(2);
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.walk_me_home_stop_sharing_question), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$3
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
                final Distress distress = Distress.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$3.1
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
                        DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.generic_no), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.3.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(1);
                            }
                        });
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.generic_yes);
                        final Distress distress2 = Distress.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.3.1.2
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
                                button.setNavCommand(5);
                                final Distress distress3 = Distress.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.3.1.2.1
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
                                        DistressInterface distressInterface;
                                        distressInterface = Distress.this.distressInterface;
                                        distressInterface.stopSharingLocation();
                                    }
                                });
                            }
                        });
                    }
                });
                basicView.setBottomPusher(new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$3.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
                        bottomPusher.setNavCommand(1);
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.walk_me_home_emergency), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                        invoke2(display);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Display display) {
                        Intrinsics.checkNotNullParameter(display, "$this$null");
                        DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.walk_me_home_turn_off), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.4.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(4);
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.walk_me_home_turn_off_emergency), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$5
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
                final Distress distress = Distress.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$5.1
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
                        DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.generic_no), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.5.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(3);
                            }
                        });
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.generic_yes);
                        final Distress distress2 = Distress.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.5.1.2
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
                                final Distress distress3 = Distress.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.getDisplays.5.1.2.1
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
                                        DistressInterface distressInterface;
                                        distressInterface = Distress.this.distressInterface;
                                        distressInterface.stopEmergency();
                                    }
                                });
                            }
                        });
                    }
                });
                basicView.setBottomPusher(new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$5.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
                        bottomPusher.setNavCommand(3);
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.walk_me_home_ended), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$getDisplays$6
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                basicView.setDescription(StringsExtensionsKt.getKeyString(Key.walk_me_home_ended_message));
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
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_walk_me_home);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.display.WatchApp
    public void onStateChanged(VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.onStateChanged(state);
        if (state == VisibilityState.Glanceable) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress$onStateChanged$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    DistressInterface distressInterface;
                    StringBuilder sb = new StringBuilder("WMH becoming visible. State ");
                    distressInterface = Distress.this.distressInterface;
                    sb.append(distressInterface.getCurrentState());
                    return sb.toString();
                }
            }, 7, (Object) null);
            int r9 = WhenMappings.$EnumSwitchMapping$0[this.distressInterface.getCurrentState().ordinal()];
            if (r9 != 1) {
                if (r9 == 2) {
                    BuildersKt.launch$default(this.scope, null, null, new Distress$onStateChanged$3(this, null), 3);
                    return;
                }
                return;
            }
            BuildersKt.launch$default(this.scope, null, null, new Distress$onStateChanged$2(this, null), 3);
        }
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl
    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl
    public void setCheckSetupNeeded(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkSetupNeeded = function0;
    }

    public Distress(DistressInterface distressInterface, QuickActionType quickActionType, Function0<Boolean> checkPermissions, Function0<Boolean> checkSetupNeeded) {
        Intrinsics.checkNotNullParameter(distressInterface, "distressInterface");
        Intrinsics.checkNotNullParameter(quickActionType, "quickActionType");
        Intrinsics.checkNotNullParameter(checkPermissions, "checkPermissions");
        Intrinsics.checkNotNullParameter(checkSetupNeeded, "checkSetupNeeded");
        this.distressInterface = distressInterface;
        this.quickActionType = quickActionType;
        this.checkPermissions = checkPermissions;
        this.checkSetupNeeded = checkSetupNeeded;
        this.id = AppId.WalkMeHome;
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.icon = MitmapBackend.getMitmap$default(serviceLocator.getMitmapBackend(), WatchAsset.Walk_me_home_App_Icon, null, 2, null);
        this.type = TYPE;
        this.analyticsName = BEHAVIOUR_ANALYTICS_NAME;
        distressInterface.doOnStateChange(new Function1<WalkMeHomeState, Unit>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1

            /* compiled from: Distress.kt */
            @DebugMetadata(c = "com.animaconnected.watch.behaviour.distress.Distress$1$2", f = "Distress.kt", l = {39}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.behaviour.distress.Distress$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ WalkMeHomeState $state;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ Distress this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Distress distress, WalkMeHomeState walkMeHomeState, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = distress;
                    this.$state = walkMeHomeState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$state, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Integer navigatingToDisplayId;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r0 = this.label;
                    if (r0 != 0) {
                        if (r0 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        if (this.this$0.isNotShowingDisplay(0, 5) && ((navigatingToDisplayId = this.this$0.getNavigatingToDisplayId()) == null || navigatingToDisplayId.intValue() != 5)) {
                            final Distress distress = this.this$0;
                            final WalkMeHomeState walkMeHomeState = this.$state;
                            LogKt.debug$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "WMH done. probably due to change from Phone. Change view " + Distress.this.getCurrentDisplay() + ", state: " + walkMeHomeState;
                                }
                            }, 7, (Object) null);
                            Distress distress2 = this.this$0;
                            this.label = 1;
                            if (RemoteAppImpl.changeView$default(distress2, 0, null, this, 2, null) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: Distress.kt */
            @DebugMetadata(c = "com.animaconnected.watch.behaviour.distress.Distress$1$3", f = "Distress.kt", l = {46}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.behaviour.distress.Distress$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ Distress this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Distress distress, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = distress;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r0 = this.label;
                    if (r0 != 0) {
                        if (r0 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        if (this.this$0.isNotShowingDisplay(1, 2)) {
                            LogKt.debug$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1.3.1
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "WMH state Walking. probably due to change from phone. Change view";
                                }
                            }, 7, (Object) null);
                            Distress distress = this.this$0;
                            this.label = 1;
                            if (RemoteAppImpl.changeView$default(distress, 1, null, this, 2, null) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: Distress.kt */
            @DebugMetadata(c = "com.animaconnected.watch.behaviour.distress.Distress$1$4", f = "Distress.kt", l = {53}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.behaviour.distress.Distress$1$4, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ Distress this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(Distress distress, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.this$0 = distress;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, continuation);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r0 = this.label;
                    if (r0 != 0) {
                        if (r0 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        if (this.this$0.isNotShowingDisplay(3, 4)) {
                            LogKt.debug$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1.4.1
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "WMH state EMERGENCY. probably due to change from phone. Change view";
                                }
                            }, 7, (Object) null);
                            Distress distress = this.this$0;
                            this.label = 1;
                            if (RemoteAppImpl.changeView$default(distress, 3, null, this, 2, null) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WalkMeHomeState walkMeHomeState) {
                invoke2(walkMeHomeState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final WalkMeHomeState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (Distress.this.getCurrentDisplay() == null) {
                    LogKt.debug$default((Object) Distress.this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "WMH is not visible, do nothing";
                        }
                    }, 7, (Object) null);
                    return;
                }
                if (state == WalkMeHomeState.Idle || state == WalkMeHomeState.NotStarted) {
                    BuildersKt.launch$default(Distress.this.scope, null, null, new AnonymousClass2(Distress.this, state, null), 3);
                    return;
                }
                if (state == WalkMeHomeState.Active || state == WalkMeHomeState.Pending) {
                    BuildersKt.launch$default(Distress.this.scope, null, null, new AnonymousClass3(Distress.this, null), 3);
                } else if (state == WalkMeHomeState.Distress) {
                    BuildersKt.launch$default(Distress.this.scope, null, null, new AnonymousClass4(Distress.this, null), 3);
                } else {
                    LogKt.debug$default((Object) Distress.this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.distress.Distress.1.5
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "WMH still running, do nothing. State " + WalkMeHomeState.this;
                        }
                    }, 7, (Object) null);
                }
            }
        });
        this.scope = serviceLocator.getScope();
    }
}

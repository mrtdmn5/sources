package com.animaconnected.watch.behaviour.types;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.Alert;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.BasicView;
import com.animaconnected.watch.display.HidCommand;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.RemoteAppViewsKt;
import com.animaconnected.watch.display.VisibilityState;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Camera.kt */
/* loaded from: classes3.dex */
public final class Camera extends RemoteAppImpl implements Pusher {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "camera";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE;
    private final String analyticsName;
    private Function0<Boolean> checkPermissions;
    private final Mitmap icon;
    private final AppId id;
    private final VisibilityState onStartState;
    private final QuickActionType quickActionType;
    private final CoroutineScope scope;
    private final String type;

    /* compiled from: Camera.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(Camera.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TYPE = simpleName;
    }

    public Camera() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return (Slot[]) ArraysKt___ArraysJvmKt.plus(Slot.Companion.getPushers(), Slot.Display);
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf(RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.camera_title), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Camera$getDisplays$1
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
                final Camera camera = Camera.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Camera$getDisplays$1.1
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
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.camera_press_take_photo);
                        final Camera camera2 = Camera.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Camera.getDisplays.1.1.1
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
                                button.setHidCommands(CollectionsKt__CollectionsKt.listOf((Object[]) new HidCommand[]{HidCommand.VOLUME_UP, HidCommand.BTN_RELEASE}));
                                final Camera camera3 = Camera.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.Camera.getDisplays.1.1.1.1

                                    /* compiled from: Camera.kt */
                                    @DebugMetadata(c = "com.animaconnected.watch.behaviour.types.Camera$getDisplays$1$1$1$1$1", f = "Camera.kt", l = {42}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.watch.behaviour.types.Camera$getDisplays$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes3.dex */
                                    public static final class C00951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        int label;
                                        final /* synthetic */ Camera this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public C00951(Camera camera, Continuation<? super C00951> continuation) {
                                            super(2, continuation);
                                            this.this$0 = camera;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00951(this.this$0, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                            int r1 = this.label;
                                            if (r1 != 0) {
                                                if (r1 == 1) {
                                                    ResultKt.throwOnFailure(obj);
                                                } else {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                            } else {
                                                ResultKt.throwOnFailure(obj);
                                                DisplayWatch displayWatch$watch_release = this.this$0.getDisplayWatch$watch_release();
                                                if (displayWatch$watch_release != null) {
                                                    int id = Alert.Confirm.getId();
                                                    this.label = 1;
                                                    if (displayWatch$watch_release.alert(id, this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                        CoroutineScope coroutineScope;
                                        coroutineScope = Camera.this.scope;
                                        BuildersKt.launch$default(coroutineScope, null, null, new C00951(Camera.this, null), 3);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.display.RemoteApp
    public VisibilityState getOnStartState() {
        return this.onStartState;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public QuickActionType getQuickActionType() {
        return this.quickActionType;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_camera);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.display.RemoteApp
    public void requestState(VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        LogKt.warn$default((Object) this, "requestState Not implemented for Camera", (String) null, (Throwable) null, false, 14, (Object) null);
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl
    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    public /* synthetic */ Camera(QuickActionType quickActionType, Function0 function0, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? QuickActionType.Camera : quickActionType, (r3 & 2) != 0 ? new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.types.Camera.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        } : function0);
    }

    public Camera(QuickActionType quickActionType, Function0<Boolean> checkPermissions) {
        Intrinsics.checkNotNullParameter(quickActionType, "quickActionType");
        Intrinsics.checkNotNullParameter(checkPermissions, "checkPermissions");
        this.quickActionType = quickActionType;
        this.checkPermissions = checkPermissions;
        this.onStartState = VisibilityState.Glanceable;
        this.type = TYPE;
        this.analyticsName = BEHAVIOUR_ANALYTICS_NAME;
        this.id = AppId.Camera;
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.icon = MitmapBackend.getMitmap$default(serviceLocator.getMitmapBackend(), WatchAsset.Camera_App_Icon, null, 2, null);
        this.scope = serviceLocator.getScope();
    }
}

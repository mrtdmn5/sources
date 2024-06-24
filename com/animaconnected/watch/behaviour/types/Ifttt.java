package com.animaconnected.watch.behaviour.types;

import com.animaconnected.firebase.WatchEvents;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.BasicView;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.RemoteAppViewsKt;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Ifttt.kt */
/* loaded from: classes3.dex */
public final class Ifttt extends RemoteAppImpl implements Pusher {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "Ifttt2";
    private final MutableStateFlow<Boolean> _isLoading;
    private final String analyticsName;
    private final IftttApi api;
    private final Mitmap icon;
    private final AppId id;
    private final CommonFlow<Boolean> isLoading;
    private final Lazy mitmapBackend$delegate;
    private final QuickActionType quickActionType;
    private final CoroutineScope scope;
    private final BasicStorage storage;
    private final KeyString title;
    private final String type;
    private final WatchEvents watchEvents;

    /* compiled from: Ifttt.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Ifttt(IftttApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.storage = serviceLocator.getStorageFactory().createStorage(TYPE);
        this.mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$mitmapBackend$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MitmapBackend invoke() {
                return ServiceLocator.INSTANCE.getMitmapBackend();
            }
        });
        this.scope = serviceLocator.getScope();
        this.id = AppId.Ifttt;
        this.title = StringsExtensionsKt.getKeyString(Key.behaviour_name_ifttt);
        this.icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Ifttt_App_Icon, null, 2, null);
        this.type = TYPE;
        this.analyticsName = "ifttt";
        this.quickActionType = QuickActionType.Button;
        this.watchEvents = serviceLocator.getAnalytics().getWatchEvents();
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isLoading = MutableStateFlow;
        this.isLoading = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendTrigger(ButtonAction buttonAction) {
        BuildersKt.launch$default(this.scope, null, null, new Ifttt$sendTrigger$1(this, buttonAction, null), 3);
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return (Slot[]) ArraysKt___ArraysJvmKt.plus((Object[]) new Slot[]{Slot.Display}, (Object[]) Slot.Companion.getPushers());
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action == ButtonAction.LongPressRelease) {
            return false;
        }
        sendTrigger(action);
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Display[]{RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.ifttt_send), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$1
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
                final Ifttt ifttt = Ifttt.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$1.1
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
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.ifttt_trigger_1);
                        final Ifttt ifttt2 = Ifttt.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.1
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
                                final Ifttt ifttt3 = Ifttt.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.1.1
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
                                        Ifttt.this.sendTrigger(ButtonAction.Press);
                                    }
                                });
                            }
                        });
                        KeyString keyString2 = StringsExtensionsKt.getKeyString(Key.ifttt_trigger_2);
                        final Ifttt ifttt3 = Ifttt.this;
                        DisplayDefinitionKt.button(display, keyString2, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.2
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
                                final Ifttt ifttt4 = Ifttt.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.2.1
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
                                        Ifttt.this.sendTrigger(ButtonAction.DoublePress);
                                    }
                                });
                            }
                        });
                        KeyString keyString3 = StringsExtensionsKt.getKeyString(Key.ifttt_trigger_3);
                        final Ifttt ifttt4 = Ifttt.this;
                        DisplayDefinitionKt.button(display, keyString3, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.3
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
                                final Ifttt ifttt5 = Ifttt.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.1.1.3.1
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
                                        Ifttt.this.sendTrigger(ButtonAction.TriplePress);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.ifttt_sending), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                basicView.setProgressBar(true);
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.error_generic_title), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                basicView.setDescription(StringsExtensionsKt.getKeyString(Key.error_generic_description_and_resolution_retry));
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                        invoke2(display);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Display display) {
                        Intrinsics.checkNotNullParameter(display, "$this$null");
                        DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.general_back), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt.getDisplays.3.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                                invoke2(button);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Button button) {
                                Intrinsics.checkNotNullParameter(button, "$this$button");
                                button.setNavCommand(0);
                            }
                        });
                    }
                });
                basicView.setBottomPusher(new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$getDisplays$3.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
                        bottomPusher.setNavCommand(0);
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

    public final boolean getLocationEnabled() {
        Boolean bool = this.storage.getBoolean("sendLocation");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public QuickActionType getQuickActionType() {
        return this.quickActionType;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return this.title;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    public final CommonFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final void setLocationEnabled(boolean z) {
        this.storage.put("sendLocation", z);
    }

    public final void setup(final Function1<? super String, Unit> setupUrl) {
        Boolean value;
        Intrinsics.checkNotNullParameter(setupUrl, "setupUrl");
        MutableStateFlow<Boolean> mutableStateFlow = this._isLoading;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
        this.api.setup(new Function1<String, Unit>() { // from class: com.animaconnected.watch.behaviour.types.Ifttt$setup$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MutableStateFlow mutableStateFlow2;
                Object value2;
                setupUrl.invoke(str);
                mutableStateFlow2 = this._isLoading;
                do {
                    value2 = mutableStateFlow2.getValue();
                    ((Boolean) value2).booleanValue();
                } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
            }
        });
    }
}

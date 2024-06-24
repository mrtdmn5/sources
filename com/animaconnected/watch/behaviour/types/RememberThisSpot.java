package com.animaconnected.watch.behaviour.types;

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
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.provider.SpotsProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RememberThisSpot.kt */
/* loaded from: classes3.dex */
public final class RememberThisSpot extends RemoteAppImpl implements Pusher {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "remember_this_spot";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE;
    private final String analyticsName;
    private Function0<Boolean> checkPermissions;
    private KeyString errorMsg;
    private final Mitmap icon;
    private final AppId id;
    private final RememberThisSpotListener listener;
    private final LocationProvider locationProvider;
    private final QuickActionType quickActionType;
    private final CoroutineScope scope;
    private final SpotsProvider spotsProvider;
    private final KeyString startDisplayTitle;
    private final String type;

    /* compiled from: RememberThisSpot.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(RememberThisSpot.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TYPE = simpleName;
    }

    public /* synthetic */ RememberThisSpot(RememberThisSpotListener rememberThisSpotListener, QuickActionType quickActionType, Function0 function0, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? null : rememberThisSpotListener, (r4 & 2) != 0 ? QuickActionType.Button : quickActionType, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchLocation() {
        BuildersKt.launch$default(this.scope, null, null, new RememberThisSpot$fetchLocation$1(this, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLocationResult(kotlin.coroutines.Continuation<? super com.animaconnected.watch.location.LocationResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$1 r0 = (com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$1 r0 = new com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5e
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = kotlin.time.Duration.$r8$clinit
            r8 = 20
            kotlin.time.DurationUnit r2 = kotlin.time.DurationUnit.SECONDS
            long r4 = kotlin.time.DurationKt.toDuration(r8, r2)
            com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$2 r8 = new com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$2
            r2 = 0
            r8.<init>(r7, r2)
            r0.label = r3
            r2 = 0
            int r6 = kotlin.time.Duration.m1672compareToLRDsOJo(r4, r2)
            if (r6 <= 0) goto L57
            long r2 = kotlin.time.Duration.m1677getInWholeMillisecondsimpl(r4)
            r4 = 1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L57
            r2 = r4
        L57:
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r8, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            com.animaconnected.watch.location.LocationResult r8 = (com.animaconnected.watch.location.LocationResult) r8
            if (r8 != 0) goto L64
            com.animaconnected.watch.location.ErrorNoLocation r8 = com.animaconnected.watch.location.ErrorNoLocation.INSTANCE
        L64:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.RememberThisSpot.getLocationResult(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object saveSpot(com.animaconnected.watch.location.Spot r23, kotlin.coroutines.Continuation<? super com.animaconnected.watch.location.Spot> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            boolean r3 = r2 instanceof com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$1
            if (r3 == 0) goto L19
            r3 = r2
            com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$1 r3 = (com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$1 r3 = new com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L49
            if (r5 == r7) goto L3d
            if (r5 != r6) goto L35
            java.lang.Object r1 = r3.L$0
            com.animaconnected.watch.location.Spot r1 = (com.animaconnected.watch.location.Spot) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto Lbc
        L35:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3d:
            java.lang.Object r1 = r3.L$1
            com.animaconnected.watch.location.Spot r1 = (com.animaconnected.watch.location.Spot) r1
            java.lang.Object r5 = r3.L$0
            com.animaconnected.watch.behaviour.types.RememberThisSpot r5 = (com.animaconnected.watch.behaviour.types.RememberThisSpot) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L5c
        L49:
            kotlin.ResultKt.throwOnFailure(r2)
            com.animaconnected.watch.location.LocationProvider r2 = r0.locationProvider
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r7
            java.lang.Object r2 = r2.getGeoCodedAddress(r1, r3)
            if (r2 != r4) goto L5b
            return r4
        L5b:
            r5 = r0
        L5c:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L62
            java.lang.String r2 = r1.addressLine
        L62:
            r14 = r2
            long r8 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            r10 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 246(0xf6, float:3.45E-43)
            r21 = 0
            r7 = r1
            com.animaconnected.watch.location.Spot r2 = com.animaconnected.watch.location.Spot.copy$default(r7, r8, r10, r12, r14, r15, r16, r17, r19, r20, r21)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Saving spot with coordinate lat: "
            r7.<init>(r8)
            double r8 = r1.latitude
            r7.append(r8)
            java.lang.String r8 = ", long: "
            r7.append(r8)
            double r8 = r1.longitude
            r7.append(r8)
            java.lang.String r1 = " to spot provider..."
            r7.append(r1)
            java.lang.String r8 = r7.toString()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r5
            com.animaconnected.logger.LogKt.debug$default(r7, r8, r9, r10, r11, r12, r13)
            kotlinx.coroutines.CoroutineDispatcher r1 = com.animaconnected.watch.DispatchersKt.mainDispatcher()
            com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$2 r7 = new com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$2
            r8 = 0
            r7.<init>(r5, r2, r8)
            r3.L$0 = r2
            r3.L$1 = r8
            r3.label = r6
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r7, r3)
            if (r1 != r4) goto Lbb
            return r4
        Lbb:
            r1 = r2
        Lbc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.RememberThisSpot.saveSpot(com.animaconnected.watch.location.Spot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return (Slot[]) ArraysKt___ArraysJvmKt.plus(Slot.Companion.getPushers(), Slot.Display);
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action == ButtonAction.LongPressRelease) {
            return false;
        }
        BuildersKt.launch$default(this.scope, null, null, new RememberThisSpot$execute$1(this, null), 3);
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
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Display[]{RemoteAppViewsKt.basicView(this, this.startDisplayTitle, new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot$getDisplays$1
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
                final RememberThisSpot rememberThisSpot = RememberThisSpot.this;
                basicView.setActions(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot$getDisplays$1.1
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
                        KeyString keyString = StringsExtensionsKt.getKeyString(Key.rts_save_spot);
                        final RememberThisSpot rememberThisSpot2 = RememberThisSpot.this;
                        DisplayDefinitionKt.button(display, keyString, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot.getDisplays.1.1.1
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
                                final RememberThisSpot rememberThisSpot3 = RememberThisSpot.this;
                                button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot.getDisplays.1.1.1.1
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
                                        RememberThisSpot.this.fetchLocation();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.rts_saving), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot$getDisplays$2
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
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.rts_saved), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot$getDisplays$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BasicView basicView) {
                invoke2(basicView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BasicView basicView) {
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                basicView.setDescription(StringsExtensionsKt.getKeyString(Key.rts_success));
            }
        }), RemoteAppViewsKt.basicView(this, StringsExtensionsKt.getKeyString(Key.rts_error_title), new Function1<BasicView, Unit>() { // from class: com.animaconnected.watch.behaviour.types.RememberThisSpot$getDisplays$4
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
                KeyString keyString;
                Intrinsics.checkNotNullParameter(basicView, "$this$basicView");
                keyString = RememberThisSpot.this.errorMsg;
                basicView.setDescription(keyString);
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
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_remember_this_spot);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.RemoteAppImpl
    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    public RememberThisSpot(RememberThisSpotListener rememberThisSpotListener, QuickActionType quickActionType, Function0<Boolean> checkPermissions) {
        Intrinsics.checkNotNullParameter(quickActionType, "quickActionType");
        Intrinsics.checkNotNullParameter(checkPermissions, "checkPermissions");
        this.listener = rememberThisSpotListener;
        this.quickActionType = quickActionType;
        this.checkPermissions = checkPermissions;
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.spotsProvider = serviceLocator.getSpotsProvider();
        this.locationProvider = serviceLocator.getLocationProvider();
        this.icon = MitmapBackend.getMitmap$default(serviceLocator.getMitmapBackend(), WatchAsset.Remember_This_Spot_Icon, null, 2, null);
        this.scope = serviceLocator.getScope();
        this.analyticsName = BEHAVIOUR_ANALYTICS_NAME;
        this.type = TYPE;
        this.id = AppId.RememberThisSpot;
        this.errorMsg = StringsExtensionsKt.getKeyString(Key.rts_error_no_loc);
        this.startDisplayTitle = StringsExtensionsKt.getKeyString(Key.rts_title);
    }
}

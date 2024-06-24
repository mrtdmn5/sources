package com.animaconnected.secondo.behaviour.distress;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.secondo.behaviour.distress.detail.DistressFragment;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.service.DistressFirebaseMessagingService;
import com.animaconnected.secondo.behaviour.distress.service.DistressService;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.behaviour.distress.Distress;
import com.animaconnected.watch.behaviour.distress.DistressInterface;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DistressPlugin.kt */
/* loaded from: classes3.dex */
public final class DistressPlugin implements BehaviourPlugin<Distress> {
    private final Lazy behaviour$delegate;
    private final int configurationDescription;
    private final Context context;
    private Distress distressApp;
    private final DistressInterface distressInterface;
    private DistressModel distressModel;
    private final int iconResourceId;
    private final int nameId;
    private final String[] requiredPermissions;
    private final CoroutineScope scope;
    private final String type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DistressPlugin";

    /* compiled from: DistressPlugin.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DistressPlugin() {
        String[] strArr;
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        this.context = companion.getContext();
        this.scope = companion.getScope();
        this.behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Distress>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$behaviour$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Distress invoke() {
                Distress distress;
                distress = DistressPlugin.this.distressApp;
                if (distress != null) {
                    return distress;
                }
                Intrinsics.throwUninitializedPropertyAccessException("distressApp");
                throw null;
            }
        });
        this.type = Distress.TYPE;
        this.nameId = R.string.behaviour_name_distress;
        this.iconResourceId = R.drawable.ic_walk_me_home;
        if (Build.VERSION.SDK_INT >= 29) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        } else {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        }
        this.requiredPermissions = strArr;
        this.configurationDescription = R.layout.dialog_follow_me_home;
        this.distressInterface = new DistressPlugin$distressInterface$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startDistress(Continuation<? super Unit> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object withContext = BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DistressPlugin$startDistress$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startWalk(Context context, Continuation<? super Unit> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object withContext = BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DistressPlugin$startWalk$2(context, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startWalkIfPossible(Continuation<? super Unit> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object withContext = BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DistressPlugin$startWalkIfPossible$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object stopDistress(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$1 r0 = (com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$1 r0 = new com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.DistressPlugin r0 = (com.animaconnected.secondo.behaviour.distress.DistressPlugin) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2b
            goto L7b
        L2b:
            r8 = move-exception
            r2 = r8
            r8 = r0
            goto L50
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$Companion r8 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.Companion     // Catch: java.lang.Exception -> L4d
            android.content.Context r2 = r7.context     // Catch: java.lang.Exception -> L4d
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r8 = r8.getInstance(r2)     // Catch: java.lang.Exception -> L4d
            r0.L$0 = r7     // Catch: java.lang.Exception -> L4d
            r0.label = r3     // Catch: java.lang.Exception -> L4d
            java.lang.Object r8 = r8.safe(r0)     // Catch: java.lang.Exception -> L4d
            if (r8 != r1) goto L7b
            return r1
        L4d:
            r8 = move-exception
            r2 = r8
            r8 = r7
        L50:
            java.lang.String r1 = com.animaconnected.secondo.behaviour.distress.DistressPlugin.TAG
            java.lang.String r0 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r3 = 0
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2
                static {
                    /*
                        com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2 r0 = new com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2) com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2.INSTANCE com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to stop emergency walk."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopDistress$2.invoke():java.lang.Object");
                }
            }
            r5 = 4
            r6 = 0
            r0 = r8
            com.animaconnected.logger.LogKt.err$default(r0, r1, r2, r3, r4, r5, r6)
            android.content.Context r0 = r8.context
            r1 = 2132017998(0x7f14034e, float:1.967429E38)
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 0
            r3 = 2
            r4 = 0
            com.animaconnected.secondo.utils.ViewKt.toast$default(r0, r1, r2, r3, r4)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r8 = r8.distressModel
            if (r8 == 0) goto L7e
            r8.notifyChanged()
        L7b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7e:
            java.lang.String r8 = "distressModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin.stopDistress(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object stopWalk(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$1 r0 = (com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$1 r0 = new com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.DistressPlugin r0 = (com.animaconnected.secondo.behaviour.distress.DistressPlugin) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2b
            goto L4e
        L2b:
            r8 = move-exception
            r2 = r8
            r8 = r0
            goto L59
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$Companion r8 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.Companion     // Catch: java.lang.Exception -> L56
            android.content.Context r2 = r7.context     // Catch: java.lang.Exception -> L56
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r8 = r8.getInstance(r2)     // Catch: java.lang.Exception -> L56
            r0.L$0 = r7     // Catch: java.lang.Exception -> L56
            r0.label = r3     // Catch: java.lang.Exception -> L56
            java.lang.Object r8 = r8.home(r0)     // Catch: java.lang.Exception -> L56
            if (r8 != r1) goto L4d
            return r1
        L4d:
            r0 = r7
        L4e:
            com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion r8 = com.animaconnected.secondo.behaviour.distress.service.DistressService.Companion     // Catch: java.lang.Exception -> L2b
            android.content.Context r1 = r0.context     // Catch: java.lang.Exception -> L2b
            r8.stop(r1)     // Catch: java.lang.Exception -> L2b
            goto L84
        L56:
            r8 = move-exception
            r2 = r8
            r8 = r7
        L59:
            java.lang.String r1 = com.animaconnected.secondo.behaviour.distress.DistressPlugin.TAG
            java.lang.String r0 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r3 = 0
            com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2
                static {
                    /*
                        com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2 r0 = new com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2) com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2.INSTANCE com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to stop walk."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$stopWalk$2.invoke():java.lang.Object");
                }
            }
            r5 = 4
            r6 = 0
            r0 = r8
            com.animaconnected.logger.LogKt.err$default(r0, r1, r2, r3, r4, r5, r6)
            android.content.Context r0 = r8.context
            r1 = 2132017998(0x7f14034e, float:1.967429E38)
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 0
            r3 = 2
            r4 = 0
            com.animaconnected.secondo.utils.ViewKt.toast$default(r0, r1, r2, r3, r4)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r8 = r8.distressModel
            if (r8 == 0) goto L87
            r8.notifyChanged()
        L84:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L87:
            java.lang.String r8 = "distressModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin.stopWalk(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return DistressFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getConfigurationDescription() {
        return this.configurationDescription;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public RemoteMessageReceiver getRemoteMessageReceiver() {
        DistressFirebaseMessagingService distressFirebaseMessagingService = DistressFirebaseMessagingService.getInstance(KronabyApplication.Companion.getContext());
        Intrinsics.checkNotNullExpressionValue(distressFirebaseMessagingService, "getInstance(...)");
        return distressFirebaseMessagingService;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.distressApp = new Distress(this.distressInterface, null, new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$initBehaviour$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Distress distress;
                DistressPlugin distressPlugin = DistressPlugin.this;
                Context context2 = context;
                distress = distressPlugin.distressApp;
                if (distress != null) {
                    return Boolean.valueOf(!BehaviourPluginKt.showFeatureIssueNotification(distressPlugin, context2, distress.getTitle().app()));
                }
                Intrinsics.throwUninitializedPropertyAccessException("distressApp");
                throw null;
            }
        }, new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$initBehaviour$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(!DistressPlugin.this.isConfigured());
            }
        }, 2, null);
        DistressModel companion = DistressModel.Companion.getInstance(context);
        this.distressModel = companion;
        if (companion != null) {
            DistressInterface distressInterface = this.distressInterface;
            Intrinsics.checkNotNull(distressInterface, "null cannot be cast to non-null type com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener");
            companion.addOnChangeListener((DistressModel.OnChangeListener) distressInterface);
            DistressModel distressModel = this.distressModel;
            if (distressModel != null) {
                if (distressModel.isActive()) {
                    DistressService.Companion.start(context);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("distressModel");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("distressModel");
        throw null;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean isConfigured() {
        DistressModel distressModel = this.distressModel;
        if (distressModel != null) {
            return distressModel.isSetUp();
        }
        Intrinsics.throwUninitializedPropertyAccessException("distressModel");
        throw null;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean shouldTintIcon() {
        return true;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Distress getBehaviour() {
        return (Distress) this.behaviour$delegate.getValue();
    }
}

package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.activity.result.ActivityResult;
import com.animaconnected.draganddrop.provider.ItemChangedListener;
import com.animaconnected.draganddrop.provider.model.ClickListener;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: BehaviourConfigurationBasePresenter.kt */
/* loaded from: classes3.dex */
public abstract class BehaviourConfigurationBasePresenter implements ClickListener, ItemChangedListener<Behaviour>, NotificationUtil.DialogListener, ConfigurationChecker.DialogListener {
    public static final int $stable = 8;
    public BehaviourItemDragAndDropProvider behaviourItemProvider;
    private final Behaviours behaviours;
    private int centerX;
    private int centerY;
    private final Context context;
    private BehaviourPlugin<Behaviour> currentBehaviourPlugin;
    private int currentGroup;
    private final BroadcastReceiver gpsSwitchStateReceiver;
    private final Handler handler;
    private boolean initialOnboardingStarted;
    private final PermissionCompat.PermissionHelper permissionHelper;
    private final BehaviourConfigurationView pushersComplicationsView;
    private final CoroutineScope scope;
    private final Runnable showOnboardingRunnable;
    private State state;

    /* compiled from: BehaviourConfigurationBasePresenter.kt */
    /* loaded from: classes3.dex */
    public interface BehaviourConfigurationView {
        CustomActivityResult<Intent, ActivityResult> getActivityLauncher();

        void onItemChanged();

        void requestPermissions(String[] strArr);

        void showDetailsFragment(String str, Slot slot, int r3, int r4, int r5, int r6);

        void showOnboardingDialog(boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BehaviourConfigurationBasePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG = new State("SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG", 0);
        public static final State WAITING_FOR_READ_NOTIFICATIONS_PERMISSION = new State("WAITING_FOR_READ_NOTIFICATIONS_PERMISSION", 1);
        public static final State SHOWING_NEEDS_CONFIGURATION_DIALOG = new State("SHOWING_NEEDS_CONFIGURATION_DIALOG", 2);
        public static final State SHOWING_DETAIL_FRAGMENT = new State("SHOWING_DETAIL_FRAGMENT", 3);
        public static final State IDLE = new State("IDLE", 4);

        private static final /* synthetic */ State[] $values() {
            return new State[]{SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG, WAITING_FOR_READ_NOTIFICATIONS_PERMISSION, SHOWING_NEEDS_CONFIGURATION_DIALOG, SHOWING_DETAIL_FRAGMENT, IDLE};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* compiled from: BehaviourConfigurationBasePresenter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FeatureIssue.values().length];
            try {
                r0[FeatureIssue.NotificationAccess.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FeatureIssue.BackgroundLocationPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FeatureIssue.LocationPermission.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FeatureIssue.GeneralPermissions.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FeatureIssue.GeneralPermission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[FeatureIssue.LocationDisabled.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public BehaviourConfigurationBasePresenter(Context context, BehaviourConfigurationView pushersComplicationsView, PermissionCompat.PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pushersComplicationsView, "pushersComplicationsView");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        this.context = context;
        this.pushersComplicationsView = pushersComplicationsView;
        this.permissionHelper = permissionHelper;
        this.behaviours = ProviderFactory.getWatch().getWatchManager().getBehaviours();
        this.scope = KronabyApplication.Companion.getScope();
        this.handler = new Handler(Looper.getMainLooper());
        this.showOnboardingRunnable = new Runnable() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BehaviourConfigurationBasePresenter.showOnboardingRunnable$lambda$0(BehaviourConfigurationBasePresenter.this);
            }
        };
        this.state = State.IDLE;
        this.currentGroup = -1;
        this.gpsSwitchStateReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$gpsSwitchStateReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().initData();
                BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().notifyDataChanged();
            }
        };
    }

    private final void behaviourThatNeedsConfigurationEnabled() {
        this.state = State.SHOWING_NEEDS_CONFIGURATION_DIALOG;
        Context context = this.context;
        BehaviourPlugin<Behaviour> behaviourPlugin = this.currentBehaviourPlugin;
        Intrinsics.checkNotNull(behaviourPlugin);
        ConfigurationChecker.showNeedsConfigurationDialog(context, behaviourPlugin.getConfigurationDescription(), this);
    }

    private final void behaviourThatNeedsNotificationsPermissionEnabled() {
        if (!NotificationUtil.isEnabled(this.context)) {
            this.state = State.SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG;
            NotificationUtil.showNeedsReadNotificationsPermissionDialog(this.context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public final void checkAndConfigureBehaviour() {
        String[] strArr;
        BehaviourPlugin<Behaviour> behaviourPlugin = this.currentBehaviourPlugin;
        if (behaviourPlugin == null || (strArr = behaviourPlugin.getRequiredPermissions()) == null) {
            strArr = new String[0];
        }
        List<String> filterMissingPermissions = PermissionProvider.Companion.filterMissingPermissions(strArr, this.context);
        switch (WhenMappings.$EnumSwitchMapping$0[FeatureIssue.Companion.calculateIssue(strArr, this.context).ordinal()]) {
            case 1:
                behaviourThatNeedsNotificationsPermissionEnabled();
                return;
            case 2:
                showPrePermissionDialog(R.layout.dialog_needs_background_location_permission, (String[]) filterMissingPermissions.toArray(new String[0]));
                return;
            case 3:
                showPrePermissionDialog(R.layout.dialog_needs_location_permission, (String[]) filterMissingPermissions.toArray(new String[0]));
                return;
            case 4:
                showPrePermissionDialog(R.layout.dialog_needs_general_plural_permission, (String[]) filterMissingPermissions.toArray(new String[0]));
                return;
            case 5:
                showPrePermissionDialog(R.layout.dialog_needs_general_singular_permission, (String[]) filterMissingPermissions.toArray(new String[0]));
                return;
            case 6:
                showPreLocationDisabledDialog();
                return;
            default:
                if (!ConfigurationChecker.isConfigured(this.currentBehaviourPlugin)) {
                    behaviourThatNeedsConfigurationEnabled();
                    return;
                } else {
                    getBehaviourItemProvider().initItemData();
                    getBehaviourItemProvider().notifyDataChanged();
                    return;
                }
        }
    }

    private final void checkIfCurrentBehaviourIsConfigured() {
        if (!ConfigurationChecker.isConfigured(this.currentBehaviourPlugin)) {
            getBehaviourItemProvider().initItemData();
            getBehaviourItemProvider().notifyDataChanged();
        }
        this.state = State.IDLE;
    }

    private final boolean checkNotificationsEnabled() {
        if (NotificationUtil.isEnabled(this.context)) {
            return true;
        }
        this.state = State.IDLE;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Future onItemClicked$lambda$1(DragAndDropItem dragAndDropItem, BehaviourConfigurationBasePresenter this$0, String behaviourType, Slot slot) {
        Intrinsics.checkNotNullParameter(dragAndDropItem, "$dragAndDropItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(behaviourType, "$behaviourType");
        if (((DragAndDropDroppableItem) dragAndDropItem).getGroup() != -1) {
            return this$0.getSlotFromBehaviourType(behaviourType);
        }
        return FutureUtils.just(slot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onItemClicked$lambda$2(View clickedView, BehaviourConfigurationBasePresenter this$0, String behaviourType, Slot slot) {
        Intrinsics.checkNotNullParameter(clickedView, "$clickedView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(behaviourType, "$behaviourType");
        Point viewCenterOnScreen = ScreenLocationHelper.getViewCenterOnScreen(clickedView);
        Size screenSize = ScreenLocationHelper.getScreenSize(this$0.context);
        Intrinsics.checkNotNullExpressionValue(screenSize, "getScreenSize(...)");
        Intrinsics.checkNotNull(slot);
        this$0.showDetailsFragment(behaviourType, slot, viewCenterOnScreen.x, viewCenterOnScreen.y, screenSize.getWidth(), screenSize.getHeight());
    }

    private final void showDetailsFragment(String str, Slot slot, int r11, int r12, int r13, int r14) {
        this.state = State.SHOWING_DETAIL_FRAGMENT;
        this.pushersComplicationsView.showDetailsFragment(str, slot, r11, r12, r13, r14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOnboardingRunnable$lambda$0(BehaviourConfigurationBasePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initialOnboardingStarted = true;
        this$0.pushersComplicationsView.showOnboardingDialog(false);
    }

    private final void showPreLocationDisabledDialog() {
        BottomSheetKt.showBottomDialog(this.context, R.layout.dialog_needs_location_disabled, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$showPreLocationDisabledDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                BehaviourConfigurationBasePresenter.BehaviourConfigurationView behaviourConfigurationView;
                if (z) {
                    behaviourConfigurationView = BehaviourConfigurationBasePresenter.this.pushersComplicationsView;
                    CustomActivityResult.launch$default(behaviourConfigurationView.getActivityLauncher(), new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), null, 2, null);
                } else {
                    BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().initData();
                    BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().notifyDataChanged();
                }
            }
        });
    }

    private final void showPrePermissionDialog(int r3, final String[] strArr) {
        BottomSheetKt.showBottomDialog(this.context, r3, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$showPrePermissionDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PermissionCompat.PermissionHelper permissionHelper;
                if (z) {
                    permissionHelper = BehaviourConfigurationBasePresenter.this.permissionHelper;
                    final String[] strArr2 = strArr;
                    final BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = BehaviourConfigurationBasePresenter.this;
                    permissionHelper.requestPermissionOrGoToSettings(strArr2, new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$showPrePermissionDialog$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr3) {
                            invoke2(strArr3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String[] it) {
                            BehaviourConfigurationBasePresenter.BehaviourConfigurationView behaviourConfigurationView;
                            Intrinsics.checkNotNullParameter(it, "it");
                            behaviourConfigurationView = BehaviourConfigurationBasePresenter.this.pushersComplicationsView;
                            behaviourConfigurationView.requestPermissions(strArr2);
                        }
                    });
                    return;
                }
                BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().initData();
                BehaviourConfigurationBasePresenter.this.getBehaviourItemProvider().notifyDataChanged();
            }
        });
    }

    public final BehaviourItemDragAndDropProvider getBehaviourItemProvider() {
        BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider = this.behaviourItemProvider;
        if (behaviourItemDragAndDropProvider != null) {
            return behaviourItemDragAndDropProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviourItemProvider");
        throw null;
    }

    public final Context getContext() {
        return this.context;
    }

    public abstract Future<Slot> getSlotFromBehaviourType(String str);

    public abstract Slot getSlotFromGroup(int r1);

    @Override // com.animaconnected.draganddrop.provider.model.ClickListener
    public void onItemClicked(final DragAndDropItem dragAndDropItem, final View clickedView) {
        Intrinsics.checkNotNullParameter(dragAndDropItem, "dragAndDropItem");
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        Object data = dragAndDropItem.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
        final String str = (String) data;
        this.currentBehaviourPlugin = ProviderFactory.getBehaviourFactory().getPlugin(str);
        FutureUtils.just(Slot.Unknown).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future onItemClicked$lambda$1;
                onItemClicked$lambda$1 = BehaviourConfigurationBasePresenter.onItemClicked$lambda$1(DragAndDropItem.this, this, str, (Slot) obj);
                return onItemClicked$lambda$1;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                BehaviourConfigurationBasePresenter.onItemClicked$lambda$2(clickedView, this, str, (Slot) obj);
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker.DialogListener
    public void onNeedsConfigurationAccept() {
        Behaviour behaviour;
        Point point;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        BehaviourPlugin<Behaviour> behaviourPlugin = this.currentBehaviourPlugin;
        if (behaviourPlugin != null && (behaviour = behaviourPlugin.getBehaviour()) != null) {
            Object systemService = this.context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
                point = new Point(bounds.width(), bounds.height());
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                point = new Point();
                defaultDisplay.getSize(point);
            }
            showDetailsFragment(behaviour.getType(), getSlotFromGroup(this.currentGroup), this.centerX, this.centerY, point.x, point.y);
        }
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker.DialogListener
    public void onNeedsConfigurationCancel() {
        if (this.state == State.SHOWING_NEEDS_CONFIGURATION_DIALOG) {
            checkIfCurrentBehaviourIsConfigured();
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNeedsReadNotificationsPermissionCancel() {
        if (this.state == State.SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG) {
            checkNotificationsEnabled();
            getBehaviourItemProvider().initItemData();
            getBehaviourItemProvider().notifyDataChanged();
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNotificationSettingsLaunched() {
        if (this.state == State.SHOWING_NEEDS_READ_NOTIFICATIONS_PERMISSION_DIALOG) {
            this.state = State.WAITING_FOR_READ_NOTIFICATIONS_PERMISSION;
        }
    }

    public final void onPause() {
        getBehaviourItemProvider().unregisterItemsChangedListener(this);
        this.handler.removeCallbacks(this.showOnboardingRunnable);
        try {
            this.context.unregisterReceiver(this.gpsSwitchStateReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void onPrePermissionGranted() {
        checkAndConfigureBehaviour();
    }

    public final void onResume() {
        if (this.state == State.WAITING_FOR_READ_NOTIFICATIONS_PERMISSION && checkNotificationsEnabled()) {
            checkAndConfigureBehaviour();
        }
        getBehaviourItemProvider().registerItemsChangedListener(this);
        getBehaviourItemProvider().initData();
        getBehaviourItemProvider().notifyDataChanged();
        BehaviourConfigurationView behaviourConfigurationView = this.pushersComplicationsView;
        Intrinsics.checkNotNull(behaviourConfigurationView, "null cannot be cast to non-null type com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment");
        if (!((BehaviourConfigurationBaseFragment) behaviourConfigurationView).getOnboardingDone() && !this.initialOnboardingStarted) {
            this.handler.postDelayed(this.showOnboardingRunnable, this.context.getResources().getInteger(R.integer.screen_transition_duration_horizontal));
        }
        this.context.registerReceiver(this.gpsSwitchStateReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
    }

    public final void onRevealedFragmentClosed() {
        if (this.state == State.SHOWING_DETAIL_FRAGMENT) {
            this.state = State.IDLE;
        }
    }

    public final void onViewCreated() {
        getBehaviourItemProvider().notifyViewCreated();
        getBehaviourItemProvider().notifyDataChanged();
    }

    public final void setBehaviourItemProvider(BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider) {
        Intrinsics.checkNotNullParameter(behaviourItemDragAndDropProvider, "<set-?>");
        this.behaviourItemProvider = behaviourItemDragAndDropProvider;
    }

    public final void syncUiWithStorage() {
        getBehaviourItemProvider().syncUiWithStorage();
    }

    @Override // com.animaconnected.draganddrop.provider.ItemChangedListener
    public void onItemChanged(Behaviour behaviour, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        this.currentBehaviourPlugin = ProviderFactory.getBehaviourFactory().getPlugin(behaviour.getType());
        this.currentGroup = r4;
        this.centerX = r5;
        this.centerY = r6;
        CoroutineScope coroutineScope = this.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new BehaviourConfigurationBasePresenter$onItemChanged$1(r4, this, behaviour, null), 2);
    }
}

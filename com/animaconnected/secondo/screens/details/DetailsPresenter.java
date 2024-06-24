package com.animaconnected.secondo.screens.details;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCaller;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.secondo.screens.details.DetailsPresenter;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailsPresenter.kt */
/* loaded from: classes3.dex */
public final class DetailsPresenter {
    public static final int $stable = 8;
    private final Context context;
    private final BroadcastReceiver gpsSwitchStateReceiver;
    private final PermissionCompat.PermissionHelper permissionHelper;
    private final BehaviourPlugin<?> plugin;
    private final Slot slot;
    private final DetailsView view;

    /* compiled from: DetailsPresenter.kt */
    /* loaded from: classes3.dex */
    public interface DetailsView {
        CustomActivityResult<Intent, ActivityResult> getActivityLauncher();

        void hideBottomDialog();

        void requestPermissions(String[] strArr);

        void setFragment(BaseDetailsFragment baseDetailsFragment);

        void showBottomDialog(int r1, int r2, int r3, int r4, int r5);

        void startRefreshing();

        void stopRefreshing();
    }

    /* compiled from: DetailsPresenter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FeatureIssue.values().length];
            try {
                r0[FeatureIssue.LocationDisabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FeatureIssue.GeneralPermissions.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FeatureIssue.GeneralPermission.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FeatureIssue.LocationPermission.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FeatureIssue.BackgroundLocationPermission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[FeatureIssue.NotificationAccess.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[FeatureIssue.None.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DetailsPresenter(Context context, DetailsView view, BehaviourPlugin<?> behaviourPlugin, Slot slot, PermissionCompat.PermissionHelper permissionHelper, boolean z) {
        ActivityResultCaller activityResultCaller;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        this.context = context;
        this.view = view;
        this.plugin = behaviourPlugin;
        this.slot = slot;
        this.permissionHelper = permissionHelper;
        this.gpsSwitchStateReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.details.DetailsPresenter$gpsSwitchStateReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                DetailsPresenter.this.updateBottomDialog();
            }
        };
        if (z) {
            if (behaviourPlugin != null) {
                activityResultCaller = behaviourPlugin.createFragment(slot);
            } else {
                activityResultCaller = null;
            }
            view.setFragment(activityResultCaller instanceof BaseDetailsFragment ? (BaseDetailsFragment) activityResultCaller : null);
        }
    }

    private final FeatureIssue getFeatureIssue() {
        String[] requiredPermissions;
        BehaviourPlugin<?> behaviourPlugin = this.plugin;
        if (behaviourPlugin != null && (requiredPermissions = behaviourPlugin.getRequiredPermissions()) != null) {
            return FeatureIssue.Companion.calculateIssue(requiredPermissions, this.context);
        }
        return FeatureIssue.None;
    }

    private final void maybeShowNewFeatureDialog() {
        BehaviourPlugin<?> behaviourPlugin = this.plugin;
        boolean z = false;
        if (behaviourPlugin != null && behaviourPlugin.isNew()) {
            z = true;
        }
        if (z) {
            this.view.showBottomDialog(R.color.paletteGreenDark, R.drawable.badge_dw_positive, R.string.bottom_dialog_new_feature_title, R.string.camera_whats_new, R.string.button_label_got_it);
        } else {
            this.view.hideBottomDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomDialog() {
        Slot slot = this.slot;
        if (slot != Slot.Unknown && slot != Slot.NotInitialized) {
            switch (WhenMappings.$EnumSwitchMapping$0[getFeatureIssue().ordinal()]) {
                case 1:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_location_title, R.string.bottom_dialog_location_description, R.string.button_label_turn_on_location);
                    return;
                case 2:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_general_plural_title, R.string.bottom_dialog_general_plural_description, R.string.button_label_give_access);
                    return;
                case 3:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_general_singular_title, R.string.bottom_dialog_general_singular_description, R.string.button_label_give_access);
                    return;
                case 4:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_location_permission_title, R.string.bottom_dialog_location_permission_description, R.string.button_label_give_access);
                    return;
                case 5:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.location_permission_background_title, R.string.location_permission_background_is_missing_with_features, R.string.button_label_give_access);
                    return;
                case 6:
                    this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_notification_title, R.string.bottom_dialog_notification_description, R.string.button_label_give_access);
                    return;
                case 7:
                    maybeShowNewFeatureDialog();
                    return;
                default:
                    return;
            }
        }
        maybeShowNewFeatureDialog();
    }

    public final void onBottomDialogClicked() {
        String[] requiredPermissions;
        switch (WhenMappings.$EnumSwitchMapping$0[getFeatureIssue().ordinal()]) {
            case 1:
                CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), null, 2, null);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                BehaviourPlugin<?> behaviourPlugin = this.plugin;
                if (behaviourPlugin != null && (requiredPermissions = behaviourPlugin.getRequiredPermissions()) != null) {
                    this.permissionHelper.requestPermissionOrGoToSettings(requiredPermissions, new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.details.DetailsPresenter$onBottomDialogClicked$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                            invoke2(strArr);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String[] it) {
                            DetailsPresenter.DetailsView detailsView;
                            Intrinsics.checkNotNullParameter(it, "it");
                            detailsView = DetailsPresenter.this.view;
                            detailsView.requestPermissions(it);
                        }
                    });
                    return;
                }
                return;
            case 6:
                if (CompanionDeviceUtils.INSTANCE.hasAssociatedDevice(this.context)) {
                    NotificationUtil.INSTANCE.showDialog(this.context);
                    return;
                } else {
                    NotificationUtil.showNeedsReadNotificationsPermissionDialog(this.context, null);
                    return;
                }
            default:
                BehaviourPlugin<?> behaviourPlugin2 = this.plugin;
                boolean z = false;
                if (behaviourPlugin2 != null && behaviourPlugin2.isNew()) {
                    z = true;
                }
                if (z) {
                    this.plugin.acceptNewFeature();
                    this.view.hideBottomDialog();
                    return;
                }
                return;
        }
    }

    public final void onPause() {
        this.view.stopRefreshing();
        this.context.unregisterReceiver(this.gpsSwitchStateReceiver);
    }

    public final void onResume() {
        this.view.startRefreshing();
        updateBottomDialog();
        this.context.registerReceiver(this.gpsSwitchStateReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
    }
}

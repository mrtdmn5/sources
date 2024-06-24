package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationDetailsPresenter.kt */
/* loaded from: classes3.dex */
public final class NotificationDetailsPresenter {
    public static final int $stable = 8;
    private final Context context;
    private final boolean dropped;
    private final PermissionCompat.PermissionHelper permissionHelper;
    private final int type;
    private final NotificationView view;

    /* compiled from: NotificationDetailsPresenter.kt */
    /* loaded from: classes3.dex */
    public interface NotificationView {
        void hideBottomDialog();

        void requestPermissions(String[] strArr);

        void showBottomDialog(int r1, int r2, int r3, int r4, int r5);
    }

    /* compiled from: NotificationDetailsPresenter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FeatureIssue.values().length];
            try {
                r0[FeatureIssue.GeneralPermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FeatureIssue.GeneralPermissions.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FeatureIssue.NotificationAccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public NotificationDetailsPresenter(NotificationView view, Context context, int r4, boolean z, PermissionCompat.PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        this.view = view;
        this.context = context;
        this.type = r4;
        this.dropped = z;
        this.permissionHelper = permissionHelper;
    }

    private final FeatureIssue getFeatureIssue() {
        FeatureIssue.Companion companion = FeatureIssue.Companion;
        String[] requiredPermissions = NotificationItemConstants.requiredPermissions(this.type);
        Intrinsics.checkNotNullExpressionValue(requiredPermissions, "requiredPermissions(...)");
        FeatureIssue calculateIssue = companion.calculateIssue(requiredPermissions, this.context);
        if (calculateIssue == FeatureIssue.None && NotificationItemConstants.needNotificationAccess(this.type) && !NotificationUtil.isEnabled(this.context)) {
            return FeatureIssue.NotificationAccess;
        }
        return calculateIssue;
    }

    private final void updateBottomDialog() {
        if (this.dropped) {
            int r0 = WhenMappings.$EnumSwitchMapping$0[getFeatureIssue().ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        this.view.hideBottomDialog();
                        return;
                    } else {
                        this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_notification_title, R.string.bottom_dialog_notification_description, R.string.button_label_give_access);
                        return;
                    }
                }
                this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_general_plural_title, R.string.bottom_dialog_general_plural_description, R.string.button_label_give_access);
                return;
            }
            this.view.showBottomDialog(R.color.paletteWheat, R.drawable.ic_badge_attention, R.string.bottom_dialog_general_singular_title, R.string.bottom_dialog_general_singular_description, R.string.button_label_give_access);
            return;
        }
        this.view.hideBottomDialog();
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getType() {
        return this.type;
    }

    public final NotificationView getView() {
        return this.view;
    }

    public final void onDialogButtonClicked() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getFeatureIssue().ordinal()];
        if (r0 != 1 && r0 != 2) {
            if (r0 == 3) {
                if (CompanionDeviceUtils.INSTANCE.hasAssociatedDevice(this.context)) {
                    NotificationUtil.INSTANCE.showDialog(this.context);
                    return;
                } else {
                    NotificationUtil.showNeedsReadNotificationsPermissionDialog(this.context, null);
                    return;
                }
            }
            return;
        }
        PermissionCompat.PermissionHelper permissionHelper = this.permissionHelper;
        String[] requiredPermissions = NotificationItemConstants.requiredPermissions(this.type);
        Intrinsics.checkNotNullExpressionValue(requiredPermissions, "requiredPermissions(...)");
        permissionHelper.requestPermissionOrGoToSettings(requiredPermissions, new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter$onDialogButtonClicked$1
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
                Intrinsics.checkNotNullParameter(it, "it");
                NotificationDetailsPresenter.NotificationView view = NotificationDetailsPresenter.this.getView();
                String[] requiredPermissions2 = NotificationItemConstants.requiredPermissions(NotificationDetailsPresenter.this.getType());
                Intrinsics.checkNotNullExpressionValue(requiredPermissions2, "requiredPermissions(...)");
                view.requestPermissions(requiredPermissions2);
            }
        });
    }

    public final void onResume() {
        updateBottomDialog();
    }
}

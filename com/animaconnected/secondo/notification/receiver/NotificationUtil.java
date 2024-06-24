package com.animaconnected.secondo.notification.receiver;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: NotificationUtil.kt */
/* loaded from: classes3.dex */
public final class NotificationUtil {
    private static boolean dismissed;
    public static final NotificationUtil INSTANCE = new NotificationUtil();
    public static final int $stable = 8;

    /* compiled from: NotificationUtil.kt */
    /* loaded from: classes3.dex */
    public interface DialogListener {
        void onNeedsReadNotificationsPermissionCancel();

        void onNotificationSettingsLaunched();
    }

    private NotificationUtil() {
    }

    private final void gotoNotificationSettings(Context context) {
        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static final boolean isEnabled(Context context) {
        Collection collection;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        if (CompanionDeviceUtils.INSTANCE.hasNotificationAccess(context)) {
            return true;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (string != null) {
            String packageName = context.getPackageName();
            List split = new Regex("(:)|(/)").split(0, string);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        collection = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            collection = EmptyList.INSTANCE;
            for (String str : (String[]) collection.toArray(new String[0])) {
                if (StringsKt__StringsJVMKt.equals(str, packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final BottomSheetDialog showNeedsReadNotificationsPermissionDialog(final Context context, final DialogListener dialogListener) {
        WindowInsetsControllerCompat$Impl windowInsetsControllerCompat$Impl23;
        Intrinsics.checkNotNullParameter(context, "context");
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        dismissed = false;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        Window window = bottomSheetDialog.getWindow();
        Intrinsics.checkNotNull(window);
        Window window2 = bottomSheetDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(window2.getDecorView());
        int r4 = Build.VERSION.SDK_INT;
        if (r4 >= 30) {
            windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl30(window, softwareKeyboardControllerCompat);
        } else if (r4 >= 26) {
            windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl26(window, softwareKeyboardControllerCompat);
        } else {
            windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl23(window, softwareKeyboardControllerCompat);
        }
        windowInsetsControllerCompat$Impl23.hide();
        windowInsetsControllerCompat$Impl23.setSystemBarsBehavior();
        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.dialog_needs_read_notifications_permission, (ViewGroup) null, false));
        if (CompanionDeviceUtils.INSTANCE.hasAssociatedDevice(context)) {
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.tv_description);
            if (textView != null) {
                textView.setText(context.getString(R.string.bottom_dialog_notification_description));
            }
            View findViewById = bottomSheetDialog.findViewById(R.id.ntf_image_description);
            if (findViewById != null) {
                ViewKt.gone(findViewById);
            }
        }
        View findViewById2 = bottomSheetDialog.findViewById(R.id.btn_approve);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.notification.receiver.NotificationUtil$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationUtil.showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$1(NotificationUtil.DialogListener.this, context, bottomSheetDialog, view);
                }
            });
        }
        View findViewById3 = bottomSheetDialog.findViewById(R.id.btn_cancel);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.notification.receiver.NotificationUtil$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationUtil.showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$2(BottomSheetDialog.this, view);
                }
            });
        }
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.notification.receiver.NotificationUtil$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NotificationUtil.showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$3(NotificationUtil.DialogListener.this, dialogInterface);
            }
        });
        bottomSheetDialog.setOnShowListener(new NotificationUtil$$ExternalSyntheticLambda3());
        bottomSheetDialog.show();
        return bottomSheetDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$1(DialogListener dialogListener, Context context, BottomSheetDialog this_apply, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (dialogListener != null) {
            dialogListener.onNotificationSettingsLaunched();
        }
        INSTANCE.openNotificationAccess(context);
        dismissed = true;
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$2(BottomSheetDialog this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$3(DialogListener dialogListener, DialogInterface dialogInterface) {
        if (!dismissed && dialogListener != null) {
            dialogListener.onNeedsReadNotificationsPermissionCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNeedsReadNotificationsPermissionDialog$lambda$6$lambda$5(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialog).findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setPeekHeight(frameLayout.getHeight());
            ((CoordinatorLayout) parent).getParent().requestLayout();
        }
    }

    public final void openNotificationAccess(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (CompanionDeviceUtils.INSTANCE.hasAssociatedDevice(context)) {
            showDialog(context);
        } else {
            gotoNotificationSettings(context);
        }
    }

    public final void showDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CompanionDeviceUtils.INSTANCE.requestNotificationAccess(context);
    }
}

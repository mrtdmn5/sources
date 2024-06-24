package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.distress.detail.DistressFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.watch.behaviour.Behaviour;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kronaby.watch.app.R;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ConfigurationChecker {
    private static boolean sDismissed;

    /* loaded from: classes3.dex */
    public interface DialogListener {
        void onNeedsConfigurationAccept();

        void onNeedsConfigurationCancel();
    }

    public static boolean isConfigured(BehaviourPlugin<Behaviour> behaviourPlugin) {
        return behaviourPlugin.isConfigured();
    }

    public static /* synthetic */ void lambda$showNeedsConfigurationDialog$0(DialogListener dialogListener, BottomSheetDialog bottomSheetDialog, View view) {
        dialogListener.onNeedsConfigurationAccept();
        sDismissed = true;
        bottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void lambda$showNeedsConfigurationDialog$1(DialogListener dialogListener, BottomSheetDialog bottomSheetDialog, View view) {
        dialogListener.onNeedsConfigurationCancel();
        sDismissed = true;
        bottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void lambda$showNeedsConfigurationDialog$2(DialogListener dialogListener, DialogInterface dialogInterface) {
        if (!sDismissed) {
            dialogListener.onNeedsConfigurationCancel();
        }
    }

    public static void showNeedsConfigurationDialog(Context context, int r5, final DialogListener dialogListener) {
        sDismissed = false;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        Objects.requireNonNull(layoutInflater);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.getWindow().setFlags(1024, 1024);
        bottomSheetDialog.setContentView(layoutInflater.inflate(r5, (ViewGroup) null, false));
        bottomSheetDialog.show();
        bottomSheetDialog.findViewById(R.id.btn_ok).setOnClickListener(new DistressFragment$$ExternalSyntheticLambda0(dialogListener, bottomSheetDialog, 1));
        View findViewById = bottomSheetDialog.findViewById(R.id.btn_cancel);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfigurationChecker.lambda$showNeedsConfigurationDialog$1(ConfigurationChecker.DialogListener.this, bottomSheetDialog, view);
                }
            });
        }
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ConfigurationChecker.lambda$showNeedsConfigurationDialog$2(ConfigurationChecker.DialogListener.this, dialogInterface);
            }
        });
    }

    public static boolean isConfigured(Context context, ConfigurationItem configurationItem) {
        return MiniOnboardingStorage.getConfigured(context, NotificationItemConstants.getNotificationName(configurationItem.getType()));
    }
}

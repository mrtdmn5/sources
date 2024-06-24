package com.animaconnected.secondo.screens.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CantConnectDialogFragment.kt */
/* loaded from: classes3.dex */
public final class CantConnectDialogFragment extends BottomSheetBaseDialogFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$1$lambda$0(CantConnectDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProviderFactory.getAppAnalytics().sendAction(HelpCenterProvider.ANALYTICS_FAQ_ONBOARDING_TAPPED);
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this$0.getString(R.string.faq_help_center_onboarding_uri))));
        this$0.dismiss();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_onboarding_cant_connect, null);
        inflate.findViewById(R.id.cant_connect_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.CantConnectDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CantConnectDialogFragment.onCreateDialogView$lambda$1$lambda$0(CantConnectDialogFragment.this, view);
            }
        });
        return inflate;
    }
}

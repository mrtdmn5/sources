package com.animaconnected.secondo.screens.status.distress;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.FailCallback;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$$ExternalSyntheticLambda2;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.kronaby.watch.app.R;
import kotlin.Unit;

/* loaded from: classes3.dex */
public class WaitingForResponseFragment extends BaseStatusFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        if (getContext() != null) {
            tryToCancelInvitation(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tryToCancelInvitation$1(Unit unit) {
        ProviderFactory.getDistressProvider().setNotConfigured();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tryToCancelInvitation$2(Context context, Throwable th) {
        Toast.makeText(context, context.getString(R.string.distress_unavailable), 0).show();
    }

    private void tryToCancelInvitation(final Context context) {
        DistressApi.getInstance(context).cancelInvitationFuture().success(new WaitingForResponseFragment$$ExternalSyntheticLambda0()).fail(new FailCallback() { // from class: com.animaconnected.secondo.screens.status.distress.WaitingForResponseFragment$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                WaitingForResponseFragment.lambda$tryToCancelInvitation$2(context, th);
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_distress_waiting_for_response, viewGroup, false);
        inflate.findViewById(R.id.btn_cancel_request).setOnClickListener(new DebugImagePreview$$ExternalSyntheticLambda2(this, 2));
        return inflate;
    }
}

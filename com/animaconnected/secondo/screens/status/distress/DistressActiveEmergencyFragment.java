package com.animaconnected.secondo.screens.status.distress;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.FailCallback;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.rememberthisspot.RememberThisSpotFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.provider.status.ActiveEmergencyStatus;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DistressActiveEmergencyFragment extends BaseStatusFragment {
    private ActiveEmergencyStatus mStatus;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onEmergencyOverClicked$1(Context context, Throwable th) {
        Toast.makeText(context, context.getString(R.string.distress_unavailable), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        onEmergencyOverClicked();
    }

    private void onEmergencyOverClicked() {
        if (this.mStatus != null) {
            final Context applicationContext = getContext().getApplicationContext();
            DistressApi.getInstance(applicationContext).safeFuture().fail(new FailCallback() { // from class: com.animaconnected.secondo.screens.status.distress.DistressActiveEmergencyFragment$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    DistressActiveEmergencyFragment.lambda$onEmergencyOverClicked$1(applicationContext, th);
                }
            });
        }
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getStatus() instanceof ActiveEmergencyStatus) {
            this.mStatus = (ActiveEmergencyStatus) getStatus();
        } else {
            this.mStatus = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_status_distress_emergency, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((Button) view.findViewById(R.id.btn_safe)).setOnClickListener(new RememberThisSpotFragment$$ExternalSyntheticLambda0(this, 1));
    }
}

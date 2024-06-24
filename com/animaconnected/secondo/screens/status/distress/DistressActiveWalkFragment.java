package com.animaconnected.secondo.screens.status.distress;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.service.DistressService;
import com.animaconnected.secondo.provider.status.ActiveWalkStatus;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DistressActiveWalkFragment extends BaseStatusFragment {
    private TextView mDescriptionText;
    private ActiveWalkStatus mStatus;

    /* JADX INFO: Access modifiers changed from: private */
    public void checkState() {
        if (DistressModel.getInstance(KronabyApplication.getContext()).getState() == WalkMeHomeState.Active && isAdded()) {
            this.mDescriptionText.setVisibility(0);
            this.mDescriptionText.setText(String.format(getString(R.string.distress_description_status_active), this.mStatus.getObserver().getFirstName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onArriveHomeClicked$2(Context context, Throwable th) {
        Toast.makeText(context, context.getString(R.string.distress_unavailable), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        onArriveHomeClicked();
    }

    private void onArriveHomeClicked() {
        if (this.mStatus != null) {
            final Context context = KronabyApplication.getContext();
            DistressApi.getInstance(context).homeFuture().success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.status.distress.DistressActiveWalkFragment$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    DistressService.stop(context);
                }
            }).fail(new FailCallback() { // from class: com.animaconnected.secondo.screens.status.distress.DistressActiveWalkFragment$$ExternalSyntheticLambda1
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    DistressActiveWalkFragment.lambda$onArriveHomeClicked$2(context, th);
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
        if (getStatus() instanceof ActiveWalkStatus) {
            this.mStatus = (ActiveWalkStatus) getStatus();
        } else {
            this.mStatus = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_status_distress_walk, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.status_board_desc);
        this.mDescriptionText = textView;
        textView.setVisibility(4);
        ((Button) view.findViewById(R.id.btn_safe)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.distress.DistressActiveWalkFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DistressActiveWalkFragment.this.lambda$onViewCreated$0(view2);
            }
        });
        DistressModel.getInstance(KronabyApplication.getContext()).addOnChangeListener(new DistressModel.OnChangeListener() { // from class: com.animaconnected.secondo.screens.status.distress.DistressActiveWalkFragment.1
            @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
            public void onChanged() {
                DistressActiveWalkFragment.this.checkState();
            }

            @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
            public void onMissingObserver() {
            }
        });
        checkState();
    }
}

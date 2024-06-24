package com.animaconnected.secondo.screens.status.connection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider;
import com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.watch.HybridWatch;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DisconnectedStatusFragment extends BaseStatusFragment implements HelpCenterStateChangedListener {
    private Button mButtonTextView;
    private TextView mDescriptionTextView;
    private final HelpCenterProvider mProvider = ProviderFactory.getHelpCenterProvider();
    private TextView mStatusTextView;

    /* renamed from: com.animaconnected.secondo.screens.status.connection.DisconnectedStatusFragment$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState;

        static {
            int[] r0 = new int[HelpCenterProvider.HelpState.values().length];
            $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState = r0;
            try {
                r0[HelpCenterProvider.HelpState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.START_GUIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void goToHelpCenterGuide() {
        this.mProvider.goToNextState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        goToHelpCenterGuide();
    }

    private void updateViews(HelpCenterProvider.HelpState helpState) {
        if (helpState == HelpCenterProvider.HelpState.START_GUIDE && !(ProviderFactory.getWatch().getWatch() instanceof HybridWatch)) {
            return;
        }
        int r4 = AnonymousClass1.$SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[helpState.ordinal()];
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 == 3) {
                    this.mDescriptionTextView.setText(R.string.dashboard_description_start_help_center);
                    this.mStatusTextView.setVisibility(8);
                    this.mButtonTextView.setVisibility(0);
                    return;
                }
                return;
            }
            this.mStatusTextView.setText(R.string.dashboard_description_connecting);
            this.mStatusTextView.setVisibility(0);
            this.mButtonTextView.setVisibility(8);
            return;
        }
        this.mStatusTextView.setText(R.string.dashboard_description_trying);
        this.mStatusTextView.setVisibility(0);
        this.mButtonTextView.setVisibility(8);
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_disconnected, viewGroup, false);
        this.mStatusTextView = (TextView) inflate.findViewById(R.id.connection_status);
        this.mDescriptionTextView = (TextView) inflate.findViewById(R.id.status_board_description);
        Button button = (Button) inflate.findViewById(R.id.start_help_center_button);
        this.mButtonTextView = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.connection.DisconnectedStatusFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisconnectedStatusFragment.this.lambda$onCreateView$0(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mProvider.unregisterHelpCenterListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mProvider.registerHelpCenterListener(this);
        updateViews(this.mProvider.getCurrentState());
    }

    @Override // com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener
    public void onStateChanged(HelpCenterProvider.HelpState helpState, HelpCenterProvider.HelpState helpState2) {
        updateViews(helpState2);
    }
}

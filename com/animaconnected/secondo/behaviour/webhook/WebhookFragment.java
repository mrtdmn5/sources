package com.animaconnected.secondo.behaviour.webhook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.webhook.WebhookAction;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class WebhookFragment extends BaseDetailsFragment {
    public static BaseDetailsFragment newInstance(Slot slot) {
        WebhookFragment webhookFragment = new WebhookFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", Webhook.TYPE);
        webhookFragment.setArguments(bundle);
        return webhookFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_webhook, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.webhook_actions_content);
        for (WebhookAction webhookAction : ProviderFactory.getWebhookProvider().getWebhookActions()) {
            WebhookActionView webhookActionView = (WebhookActionView) getLayoutInflater().inflate(R.layout.webhook_action, (ViewGroup) linearLayout, false);
            linearLayout.addView(webhookActionView);
            webhookActionView.setupView(webhookAction);
        }
        return inflate;
    }
}

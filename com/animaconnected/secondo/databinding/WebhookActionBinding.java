package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.behaviour.webhook.WebhookActionView;
import com.google.android.material.textfield.TextInputEditText;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WebhookActionBinding implements ViewBinding {
    private final WebhookActionView rootView;
    public final TextView webhookActionTitle;
    public final TextInputEditText webhookUrlEditText;

    private WebhookActionBinding(WebhookActionView webhookActionView, TextView textView, TextInputEditText textInputEditText) {
        this.rootView = webhookActionView;
        this.webhookActionTitle = textView;
        this.webhookUrlEditText = textInputEditText;
    }

    public static WebhookActionBinding bind(View view) {
        int r0 = R.id.webhook_action_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.webhook_action_title, view);
        if (textView != null) {
            r0 = R.id.webhook_url_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.webhook_url_edit_text, view);
            if (textInputEditText != null) {
                return new WebhookActionBinding((WebhookActionView) view, textView, textInputEditText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WebhookActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WebhookActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.webhook_action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public WebhookActionView getRoot() {
        return this.rootView;
    }
}

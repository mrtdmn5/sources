package com.animaconnected.secondo.behaviour.webhook;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.webhook.WebhookAction;
import com.animaconnected.secondo.provider.webhook.WebhookProvider;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class WebhookActionView extends LinearLayout {
    private WebhookAction mAction;
    private EditText mEditText;
    private WebhookProvider mProvider;
    private final View.OnFocusChangeListener mUrlOnFocusChanged;
    private final TextWatcher mUrlTextWatcher;

    public WebhookActionView(Context context) {
        super(context);
        this.mUrlTextWatcher = new TextWatcher() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WebhookActionView.this.updateUrl();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
            }
        };
        this.mUrlOnFocusChanged = new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                WebhookActionView.this.lambda$new$0(view, z);
            }
        };
        init();
    }

    private void init() {
        this.mProvider = ProviderFactory.getWebhookProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, boolean z) {
        if (!z) {
            updateUrl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUrl() {
        this.mProvider.setActionUrlString(getContext(), this.mAction, this.mEditText.getText().toString());
    }

    public void setupView(WebhookAction webhookAction) {
        this.mAction = webhookAction;
        ((TextView) findViewById(R.id.webhook_action_title)).setText(this.mAction.getNameResource());
        EditText editText = (EditText) findViewById(R.id.webhook_url_edit_text);
        this.mEditText = editText;
        editText.addTextChangedListener(this.mUrlTextWatcher);
        this.mEditText.setOnFocusChangeListener(this.mUrlOnFocusChanged);
        this.mEditText.setText(this.mProvider.getActionUrlString(getContext(), this.mAction));
    }

    public WebhookActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUrlTextWatcher = new TextWatcher() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WebhookActionView.this.updateUrl();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
            }
        };
        this.mUrlOnFocusChanged = new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                WebhookActionView.this.lambda$new$0(view, z);
            }
        };
        init();
    }

    public WebhookActionView(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mUrlTextWatcher = new TextWatcher() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WebhookActionView.this.updateUrl();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int r2, int r32, int r4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int r2, int r32, int r4) {
            }
        };
        this.mUrlOnFocusChanged = new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookActionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                WebhookActionView.this.lambda$new$0(view, z);
            }
        };
        init();
    }
}

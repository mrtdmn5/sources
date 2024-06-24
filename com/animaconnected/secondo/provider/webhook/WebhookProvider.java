package com.animaconnected.secondo.provider.webhook;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.watch.device.ButtonAction;
import com.kronaby.watch.app.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class WebhookProvider {
    private static final List<WebhookAction> WEBHOOK_ACTIONS = Collections.unmodifiableList(Arrays.asList(new WebhookAction(ButtonAction.Press, R.string.action_press_single), new WebhookAction(ButtonAction.DoublePress, R.string.action_press_double), new WebhookAction(ButtonAction.TriplePress, R.string.action_press_triple), new WebhookAction(ButtonAction.QuadruplePress, R.string.action_press_quadruple), new WebhookAction(ButtonAction.LongPress, R.string.action_press_hold)));
    private final WebhookStorage mStorage = new WebhookStorage();

    /* loaded from: classes3.dex */
    public static class WebhookStorage {
        private static final String WEBHOOK_STORAGE = "webhookStorage";
        private static final String WEBHOOK_URL_KEY = "url_";

        private WebhookStorage() {
        }

        private String getActionKey(WebhookAction webhookAction) {
            return WEBHOOK_URL_KEY + webhookAction.getButtonAction().getId();
        }

        private SharedPreferences getSharedPreferences(Context context) {
            return context.getSharedPreferences(WEBHOOK_STORAGE, 0);
        }

        public String getActionUrlString(Context context, WebhookAction webhookAction) {
            return getSharedPreferences(context).getString(getActionKey(webhookAction), null);
        }

        public void setActionUrlString(Context context, WebhookAction webhookAction, String str) {
            getSharedPreferences(context).edit().putString(getActionKey(webhookAction), str).apply();
        }
    }

    private WebhookAction getWebhookAction(ButtonAction buttonAction) {
        for (WebhookAction webhookAction : WEBHOOK_ACTIONS) {
            if (webhookAction.getButtonAction() == buttonAction) {
                return webhookAction;
            }
        }
        return null;
    }

    public String getActionUrlString(Context context, WebhookAction webhookAction) {
        return this.mStorage.getActionUrlString(context, webhookAction);
    }

    public String getUrlStringForButtonAction(Context context, ButtonAction buttonAction) {
        WebhookAction webhookAction = getWebhookAction(buttonAction);
        if (webhookAction != null) {
            return getActionUrlString(context, webhookAction);
        }
        return null;
    }

    public List<WebhookAction> getWebhookActions() {
        return WEBHOOK_ACTIONS;
    }

    public boolean isButtonActionValid(ButtonAction buttonAction) {
        if (getWebhookAction(buttonAction) != null) {
            return true;
        }
        return false;
    }

    public void setActionUrlString(Context context, WebhookAction webhookAction, String str) {
        this.mStorage.setActionUrlString(context, webhookAction, str);
    }
}

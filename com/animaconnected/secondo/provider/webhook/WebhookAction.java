package com.animaconnected.secondo.provider.webhook;

import com.animaconnected.watch.device.ButtonAction;

/* loaded from: classes3.dex */
public class WebhookAction {
    private final ButtonAction mButtonAction;
    private final int mNameResource;

    public WebhookAction(ButtonAction buttonAction, int r2) {
        this.mButtonAction = buttonAction;
        this.mNameResource = r2;
    }

    public ButtonAction getButtonAction() {
        return this.mButtonAction;
    }

    public int getNameResource() {
        return this.mNameResource;
    }
}

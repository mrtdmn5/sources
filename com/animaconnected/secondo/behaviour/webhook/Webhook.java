package com.animaconnected.secondo.behaviour.webhook;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.webhook.WebhookProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.behaviour.util.VibratorPatterns;
import com.animaconnected.watch.device.ButtonAction;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Webhook.kt */
/* loaded from: classes3.dex */
public final class Webhook implements Pusher {
    private static final int CONNECTION_TIMEOUT_MS = 10000;
    private final String analyticsName;
    private final Context context;
    private final WebhookProvider provider;
    private final String type;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    public static final String TYPE = "Webhook";

    /* compiled from: Webhook.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Webhook(Context context, WebhookProvider provider, WatchProvider watchProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        this.context = context;
        this.provider = provider;
        this.watchProvider = watchProvider;
        this.type = TYPE;
        this.analyticsName = "webhook";
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        URL url;
        Intrinsics.checkNotNullParameter(action, "action");
        if (!this.provider.isButtonActionValid(action)) {
            return false;
        }
        try {
            url = new URL(this.provider.getUrlStringForButtonAction(this.context, action));
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null) {
            this.watchProvider.startVibratorWithPattern(VibratorPatterns.getError());
            return false;
        }
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), Dispatchers.IO, null, new Webhook$execute$1(url, this, null), 2);
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}

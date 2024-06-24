package com.animaconnected.secondo.behaviour.webhook;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebhookPlugin.kt */
/* loaded from: classes3.dex */
public final class WebhookPlugin implements BehaviourPlugin<Webhook> {
    public static final int $stable = 8;
    private Webhook webhook;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Webhook>() { // from class: com.animaconnected.secondo.behaviour.webhook.WebhookPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Webhook invoke() {
            Webhook webhook;
            webhook = WebhookPlugin.this.webhook;
            if (webhook != null) {
                return webhook;
            }
            Intrinsics.throwUninitializedPropertyAccessException("webhook");
            throw null;
        }
    });
    private final String type = Webhook.TYPE;
    private final int nameId = R.string.behaviour_name_webhook;
    private final int iconResourceId = R.drawable.ic_webhooks;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = WebhookFragment.newInstance(slot);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.webhook = new Webhook(context, ProviderFactory.getWebhookProvider(), ProviderFactory.getWatch());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Webhook getBehaviour() {
        return (Webhook) this.behaviour$delegate.getValue();
    }
}

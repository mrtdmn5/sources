package com.animaconnected.secondo.behaviour.ifttt;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.cloud.util.CloudIfttt;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.animaconnected.watch.behaviour.types.IftttApi;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.location.Spot;
import com.kronaby.watch.app.R;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IftttPlugin.kt */
/* loaded from: classes3.dex */
public final class IftttPlugin implements BehaviourPlugin<Ifttt> {
    public static final int $stable = 8;
    private Ifttt ifttt;
    private final Cloud cloud = ProviderFactory.getCloudProvider();
    private final IftttPlugin$api$1 api = new IftttApi() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$api$1
        @Override // com.animaconnected.watch.behaviour.types.IftttApi
        public void sendIftttTrigger(ButtonAction action, Spot spot, Function3<? super Boolean, ? super String, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(callback, "callback");
            IftttPlugin.this.sendTrigger(action, spot, callback);
        }

        @Override // com.animaconnected.watch.behaviour.types.IftttApi
        public void setup(Function1<? super String, Unit> url) {
            Intrinsics.checkNotNullParameter(url, "url");
            IftttPlugin.this.setupButtonClick(url);
        }
    };
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Ifttt>() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Ifttt invoke() {
            Ifttt ifttt;
            ifttt = IftttPlugin.this.ifttt;
            if (ifttt != null) {
                return ifttt;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ifttt");
            throw null;
        }
    });
    private final String type = Ifttt.TYPE;
    private final int nameId = R.string.behaviour_name_ifttt;
    private final int iconResourceId = R.drawable.ic_ifttt;
    private final int configurationDescription = R.layout.dialog_ifttt;

    /* compiled from: IftttPlugin.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ButtonAction.values().length];
            try {
                r0[ButtonAction.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ButtonAction.DoublePress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ButtonAction.TriplePress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendTrigger(ButtonAction buttonAction, Spot spot, final Function3<? super Boolean, ? super String, ? super String, Unit> function3) {
        Double d;
        final CloudIfttt.TRIGGER_E iftttTrigger = toIftttTrigger(buttonAction);
        if (iftttTrigger == null) {
            function3.invoke(Boolean.FALSE, "", "Failed to send trigger. Could not map ButtonAction to IFTTT trigger");
            return;
        }
        Cloud cloud = this.cloud;
        CloudIfttt.ACTION_E r1 = CloudIfttt.ACTION_E.TRIGGER_PRESSED;
        Double d2 = null;
        if (spot != null) {
            d = Double.valueOf(spot.longitude);
        } else {
            d = null;
        }
        if (spot != null) {
            d2 = Double.valueOf(spot.latitude);
        }
        cloud.sendIftttTriggerPressed(r1, iftttTrigger, d, d2).success(new SuccessCallback() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                IftttPlugin.sendTrigger$lambda$0(this, iftttTrigger, function3, (Void) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                IftttPlugin.sendTrigger$lambda$1(this, function3, iftttTrigger, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendTrigger$lambda$0(IftttPlugin this$0, CloudIfttt.TRIGGER_E r9, Function3 callback, Void r11) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        LogKt.debug$default((Object) this$0, "Successfully sent trigger " + r9.name(), (String) null, (Throwable) null, false, 14, (Object) null);
        callback.invoke(Boolean.TRUE, r9.name(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendTrigger$lambda$1(IftttPlugin this$0, Function3 callback, CloudIfttt.TRIGGER_E r10, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        LogKt.debug$default((Object) this$0, "Failed to send trigger", (String) null, th, false, 10, (Object) null);
        callback.invoke(Boolean.FALSE, r10.name(), th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupButtonClick(final Function1<? super String, Unit> function1) {
        this.cloud.getIftttSetupUrl().success(new SuccessCallback() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                IftttPlugin.setupButtonClick$lambda$2(IftttPlugin.this, function1, (URL) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttPlugin$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                IftttPlugin.setupButtonClick$lambda$3(IftttPlugin.this, function1, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonClick$lambda$2(IftttPlugin this$0, Function1 callbackSetupUrl, URL url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callbackSetupUrl, "$callbackSetupUrl");
        LogKt.debug$default((Object) this$0, "IFTTT setup url = " + url, (String) null, (Throwable) null, false, 14, (Object) null);
        if (url != null) {
            MiniOnboardingStorage.setConfigured(KronabyApplication.Companion.getContext(), true, "ifttt");
            callbackSetupUrl.invoke(url.toExternalForm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonClick$lambda$3(IftttPlugin this$0, Function1 callbackSetupUrl, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callbackSetupUrl, "$callbackSetupUrl");
        LogKt.debug$default((Object) this$0, "Failed to get setup url for IFTTT", (String) null, th, false, 10, (Object) null);
        callbackSetupUrl.invoke(null);
    }

    private final CloudIfttt.TRIGGER_E toIftttTrigger(ButtonAction buttonAction) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    return null;
                }
                return CloudIfttt.TRIGGER_E.TRIPLE;
            }
            return CloudIfttt.TRIGGER_E.DOUBLE;
        }
        return CloudIfttt.TRIGGER_E.SINGLE;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return IftttFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getConfigurationDescription() {
        return this.configurationDescription;
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
    public RemoteMessageReceiver getRemoteMessageReceiver() {
        IftttActionReceiver iftttActionReceiver = IftttActionReceiver.getInstance();
        Intrinsics.checkNotNullExpressionValue(iftttActionReceiver, "getInstance(...)");
        return iftttActionReceiver;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.ifttt = new Ifttt(this.api);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean isConfigured() {
        return MiniOnboardingStorage.getConfigured(KronabyApplication.Companion.getContext(), "ifttt");
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean shouldTintIcon() {
        return true;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Ifttt getBehaviour() {
        return (Ifttt) this.behaviour$delegate.getValue();
    }
}

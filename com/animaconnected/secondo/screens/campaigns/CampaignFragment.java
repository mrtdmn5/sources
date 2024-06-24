package com.animaconnected.secondo.screens.campaigns;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: CampaignFragment.kt */
/* loaded from: classes3.dex */
public final class CampaignFragment extends BaseFragment implements Dismissible {
    private View campaignContent;
    private int centerX;
    private int centerY;
    private int finalHeight;
    private int finalWidth;
    private final String name = "CampaignFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CampaignFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CampaignFragment newInstance(int r4, int r5, int r6, int r7) {
            CampaignFragment campaignFragment = new CampaignFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(CampaignFragmentKt.FRAGMENT_CENTER_X, r4);
            bundle.putInt(CampaignFragmentKt.FRAGMENT_CENTER_Y, r5);
            bundle.putInt(CampaignFragmentKt.FRAGMENT_FINAL_WIDTH, r6);
            bundle.putInt(CampaignFragmentKt.FRAGMENT_FINAL_HEIGHT, r7);
            campaignFragment.setArguments(bundle);
            return campaignFragment;
        }

        private Companion() {
        }
    }

    public static final void dismiss$lambda$3(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onDismissed();
    }

    public static final CampaignFragment newInstance(int r1, int r2, int r3, int r4) {
        return Companion.newInstance(r1, r2, r3, r4);
    }

    public static final void onCreateView$lambda$1$lambda$0(CampaignFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new CampaignFragment$onCreateView$1$1$1(this$0, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object openWebsite(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.campaigns.CampaignFragment$openWebsite$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.campaigns.CampaignFragment$openWebsite$1 r0 = (com.animaconnected.secondo.screens.campaigns.CampaignFragment$openWebsite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.campaigns.CampaignFragment$openWebsite$1 r0 = new com.animaconnected.secondo.screens.campaigns.CampaignFragment$openWebsite$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.campaigns.CampaignFragment r0 = (com.animaconnected.secondo.screens.campaigns.CampaignFragment) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4a
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.WatchProvider r5 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.future.Future r5 = r5.getDeviceInformation()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            java.util.Map r5 = (java.util.Map) r5
            com.animaconnected.watch.device.DeviceInfo r1 = com.animaconnected.watch.device.DeviceInfo.SerialNumber
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L71
            java.lang.String r1 = "https://www.lotus-watches.com/lotus-tidal?sn="
            java.lang.String r5 = r1.concat(r5)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r1.<init>(r2, r5)
            r0.startActivity(r1)
            com.animaconnected.firebase.AppEvents r5 = com.animaconnected.secondo.provider.ProviderFactory.getAppAnalytics()
            r5.giftRedeemTapped()
        L71:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.campaigns.CampaignFragment.openWebsite(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        int r3 = this.centerX;
        int r4 = this.centerY;
        int r5 = this.finalWidth;
        int r6 = this.finalHeight;
        View view = this.campaignContent;
        if (view != null) {
            AnimationFactoryKotlinKt.startCircularRevealExitAnimation(requireContext, requireView, r3, r4, r5, r6, view, new Rgb$$ExternalSyntheticLambda3(listener));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("campaignContent");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.tidal_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        if (context != null) {
            Object obj = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_close);
        }
        return null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int r1;
        int r12;
        int r13;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        int r0 = 0;
        if (arguments != null) {
            r1 = arguments.getInt(CampaignFragmentKt.FRAGMENT_CENTER_X, 0);
        } else {
            r1 = 0;
        }
        this.centerX = r1;
        if (arguments != null) {
            r12 = arguments.getInt(CampaignFragmentKt.FRAGMENT_CENTER_Y, 0);
        } else {
            r12 = 0;
        }
        this.centerY = r12;
        if (arguments != null) {
            r13 = arguments.getInt(CampaignFragmentKt.FRAGMENT_FINAL_WIDTH, 0);
        } else {
            r13 = 0;
        }
        this.finalWidth = r13;
        if (arguments != null) {
            r0 = arguments.getInt(CampaignFragmentKt.FRAGMENT_FINAL_HEIGHT, 0);
        }
        this.finalHeight = r0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_campaign, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.campaignContent = findViewById;
        ((Button) inflate.findViewById(R.id.campaign_primary_button)).setOnClickListener(new CampaignFragment$$ExternalSyntheticLambda0(this, 0));
        View findViewById2 = inflate.findViewById(R.id.campaign_secondary_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        onClick(findViewById2, new CampaignFragment$onCreateView$1$2(this, null));
        Context context = inflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int r3 = this.centerX;
        int r4 = this.centerY;
        int r5 = this.finalWidth;
        int r6 = this.finalHeight;
        View view = this.campaignContent;
        if (view != null) {
            AnimationFactoryKotlinKt.registerCircularRevealAnimation(context, inflate, r3, r4, r5, r6, view);
            return inflate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("campaignContent");
        throw null;
    }
}

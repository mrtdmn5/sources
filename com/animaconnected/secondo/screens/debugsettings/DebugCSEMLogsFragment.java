package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentDebugCsemLogsBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.device.WatchIODebug;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugCSEMLogsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugCSEMLogsFragment extends BaseFragment {
    private FragmentDebugCsemLogsBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final WatchIODebug watchDebugIo = ProviderFactory.getWatch().getWatch().getDebugIo();
    private final String name = "CSEMLogs";

    /* compiled from: DebugCSEMLogsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugCSEMLogsFragment newInstance() {
            return new DebugCSEMLogsFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void updateText() {
        FragmentDebugCsemLogsBinding fragmentDebugCsemLogsBinding = this.binding;
        if (fragmentDebugCsemLogsBinding != null) {
            fragmentDebugCsemLogsBinding.textAmount.setText("Collected logs: " + (CSEMLogsFileSaver.INSTANCE.size() / 1024) + " KB");
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return false;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDebugCsemLogsBinding inflate = FragmentDebugCsemLogsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Button btnEnable = inflate.btnEnable;
        Intrinsics.checkNotNullExpressionValue(btnEnable, "btnEnable");
        onClick(btnEnable, new DebugCSEMLogsFragment$onCreateView$1$1(this, null));
        Button btnDisable = inflate.btnDisable;
        Intrinsics.checkNotNullExpressionValue(btnDisable, "btnDisable");
        onClick(btnDisable, new DebugCSEMLogsFragment$onCreateView$1$2(this, null));
        Button btnClear = inflate.btnClear;
        Intrinsics.checkNotNullExpressionValue(btnClear, "btnClear");
        onClick(btnClear, new DebugCSEMLogsFragment$onCreateView$1$3(this, null));
        Button btnExport = inflate.btnExport;
        Intrinsics.checkNotNullExpressionValue(btnExport, "btnExport");
        onClick(btnExport, new DebugCSEMLogsFragment$onCreateView$1$4(this, null));
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(this);
        BuildersKt.launch$default(lifecycleScope, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(lifecycleScope, new DebugCSEMLogsFragment$onResume$1(this, null), null), 3);
    }
}

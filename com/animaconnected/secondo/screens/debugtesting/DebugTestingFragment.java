package com.animaconnected.secondo.screens.debugtesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugTestingFragment.kt */
/* loaded from: classes3.dex */
public final class DebugTestingFragment extends BaseTestingFragment implements DebugTestingPresenter.DebugTestingView {
    private Button coilButton;
    private DebugTestingPresenter mPresenter;
    private final String name = "DebugTesting";
    private Button testPerpetualButton;
    private Button testTimeSpeedup;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugTestingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance() {
            return new DebugTestingFragment();
        }

        private Companion() {
        }
    }

    public static final BaseFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        DebugTestingPresenter debugTestingPresenter = new DebugTestingPresenter(this, requireActivity);
        this.mPresenter = debugTestingPresenter;
        setPresenter(debugTestingPresenter);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_debugtesting, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        setupViewElements(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DebugTestingPresenter debugTestingPresenter = this.mPresenter;
        if (debugTestingPresenter != null) {
            debugTestingPresenter.onStart();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.DebugTestingView
    public void setCoilStatus(String str) {
        Button button = this.coilButton;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("coilButton");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.DebugTestingView
    public void setPerpetualStatus(String str) {
        Button button = this.testPerpetualButton;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testPerpetualButton");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.DebugTestingView
    public void setTimeSpeedup(String str) {
        Button button = this.testTimeSpeedup;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testTimeSpeedup");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingFragment
    public void setupViewElements(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setupViewElements(view);
        View findViewById = view.findViewById(R.id.test_coil_button);
        Button button = (Button) findViewById;
        Intrinsics.checkNotNull(button);
        onClick(button, new DebugTestingFragment$setupViewElements$1$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.coilButton = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.deplete_batteries_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        onClick(findViewById2, new DebugTestingFragment$setupViewElements$2(this, null));
        View findViewById3 = view.findViewById(R.id.test_perpetual);
        Button button2 = (Button) findViewById3;
        Intrinsics.checkNotNull(button2);
        onClick(button2, new DebugTestingFragment$setupViewElements$3$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById3, "apply(...)");
        this.testPerpetualButton = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.test_time_speedup);
        Button button3 = (Button) findViewById4;
        Intrinsics.checkNotNull(button3);
        onClick(button3, new DebugTestingFragment$setupViewElements$4$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById4, "apply(...)");
        this.testTimeSpeedup = (Button) findViewById4;
    }
}

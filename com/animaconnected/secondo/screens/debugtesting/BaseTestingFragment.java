package com.animaconnected.secondo.screens.debugtesting;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.image.Kolors;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: BaseTestingFragment.kt */
@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public abstract class BaseTestingFragment extends BaseFragment implements BaseTestingPresenter.BaseTestingView, WatchProvider.WatchProviderListener {
    public static final int $stable = 8;
    private Button bottomTestView;
    private Button buttonTopTestView;
    private BaseTestingPresenter presenter;
    private Button testFcteButton;
    private Button testMovementButton;
    private Button testRssiButton;
    private Button testVibrator;

    /* compiled from: BaseTestingFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Slot.values().length];
            try {
                r0[Slot.TopPusher.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Slot.BottomPusher.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final void handleButtonAction(Slot slot, ButtonAction buttonAction) {
        int r4;
        final Button button;
        Handler handler = new Handler(Looper.getMainLooper());
        if (slot == null) {
            r4 = -1;
        } else {
            r4 = WhenMappings.$EnumSwitchMapping$0[slot.ordinal()];
        }
        if (r4 != 1) {
            if (r4 != 2) {
                return;
            }
            button = this.bottomTestView;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTestView");
                throw null;
            }
        } else {
            button = this.buttonTopTestView;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonTopTestView");
                throw null;
            }
        }
        button.setBackgroundColor(Kolors.green);
        button.setText(((Object) button.getText()) + ": " + buttonAction.getReadableName());
        handler.postDelayed(new Runnable() { // from class: com.animaconnected.secondo.screens.debugtesting.BaseTestingFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseTestingFragment.handleButtonAction$lambda$5$lambda$4(button, button);
            }
        }, 750L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleButtonAction$lambda$5$lambda$4(Button this_with, Button current) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(current, "$current");
        this_with.setBackgroundColor(0);
        String substring = current.getText().toString().substring(0, StringsKt__StringsKt.indexOf$default((CharSequence) current.getText().toString(), ":", 0, false, 6) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        this_with.setText(substring);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(action, "action");
        handleButtonAction(slot, action);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ProviderFactory.getWatch().unregisterListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ProviderFactory.getWatch().registerListener(this);
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.BaseTestingView
    public void setFcteStatus(String str) {
        Button button = this.testFcteButton;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testFcteButton");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.BaseTestingView
    public void setMovementTestStatus(String str) {
        Button button = this.testMovementButton;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testMovementButton");
            throw null;
        }
    }

    public final void setPresenter(BaseTestingPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.BaseTestingView
    public void setRssiStatus(String str) {
        Button button = this.testRssiButton;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testRssiButton");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.BaseTestingView
    public void setVibratorStatus(String str) {
        Button button = this.testVibrator;
        if (button != null) {
            button.setText(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("testVibrator");
            throw null;
        }
    }

    public void setupViewElements(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.test_vibrator);
        Button button = (Button) findViewById;
        Intrinsics.checkNotNull(button);
        onClick(button, new BaseTestingFragment$setupViewElements$1$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.testVibrator = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.test_movement);
        Button button2 = (Button) findViewById2;
        Intrinsics.checkNotNull(button2);
        onClick(button2, new BaseTestingFragment$setupViewElements$2$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
        this.testMovementButton = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.test_rssi);
        Button button3 = (Button) findViewById3;
        Intrinsics.checkNotNull(button3);
        onClick(button3, new BaseTestingFragment$setupViewElements$3$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById3, "apply(...)");
        this.testRssiButton = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.test_fcte);
        Button button4 = (Button) findViewById4;
        Intrinsics.checkNotNull(button4);
        onClick(button4, new BaseTestingFragment$setupViewElements$4$1(this, null));
        Intrinsics.checkNotNullExpressionValue(findViewById4, "apply(...)");
        this.testFcteButton = (Button) findViewById4;
        View findViewById5 = view.findViewById(R.id.top_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.buttonTopTestView = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.bottom_button);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.bottomTestView = (Button) findViewById6;
    }
}

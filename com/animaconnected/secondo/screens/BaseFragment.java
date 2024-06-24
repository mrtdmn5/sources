package com.animaconnected.secondo.screens;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.google.common.collect.Hashing;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: BaseFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment {
    public static final int $stable = 8;
    public CustomActivityResult<Intent, ActivityResult> activityLauncher;
    private final String parentFragmentName;
    private AnimatedToolbar toolbar;

    private final int getActionBarHeight() {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return 0;
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
    }

    public static final void onClick$lambda$4(BaseFragment this$0, Function2 onClick, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new BaseFragment$onClick$1$1(onClick, view, null), 3);
    }

    private final void setupToolbar(View view) {
        AppCompatActivity appCompatActivity;
        AnimatedToolbar animatedToolbar;
        FragmentActivity activity = getActivity();
        ActionBar actionBar = null;
        if (activity instanceof AppCompatActivity) {
            appCompatActivity = (AppCompatActivity) activity;
        } else {
            appCompatActivity = null;
        }
        if (appCompatActivity == null) {
            return;
        }
        View findViewById = view.findViewById(com.kronaby.watch.app.R.id.animated_toolbar);
        if (findViewById instanceof AnimatedToolbar) {
            animatedToolbar = (AnimatedToolbar) findViewById;
        } else {
            animatedToolbar = null;
        }
        if (animatedToolbar == null) {
            return;
        }
        this.toolbar = animatedToolbar;
        appCompatActivity.setSupportActionBar(animatedToolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            Drawable toolbarBackDrawable = getToolbarBackDrawable();
            if (toolbarBackDrawable != null) {
                animatedToolbar.setBackDrawable(toolbarBackDrawable);
            }
            supportActionBar.setHomeAsUpIndicator(animatedToolbar.getBackDrawable());
            supportActionBar.setDisplayShowTitleEnabled();
            supportActionBar.setDisplayHomeAsUpEnabled(RemoteConfigController.Companion.getInstance(KronabyApplication.Companion.getContext()).getAppToolBarBackButtonEnable());
            actionBar = supportActionBar;
        }
        if (actionBar == null) {
            LogKt.debug$default((Object) this, "setupToolbar: no support toolbar available", (String) null, (Throwable) null, false, 14, (Object) null);
        }
        TextView textView = (TextView) view.findViewById(com.kronaby.watch.app.R.id.toolbar_title);
        if (textView != null) {
            textView.setText(getFeaturePathName());
        } else {
            LogKt.debug$default((Object) this, "setupToolbar: no toolbar title available", (String) null, (Throwable) null, false, 14, (Object) null);
        }
    }

    public boolean accessEvenIfDisconnected() {
        return false;
    }

    public final CustomActivityResult<Intent, ActivityResult> getActivityLauncher() {
        CustomActivityResult<Intent, ActivityResult> customActivityResult = this.activityLauncher;
        if (customActivityResult != null) {
            return customActivityResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activityLauncher");
        throw null;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public String getFeaturePathName() {
        String string = getString(com.kronaby.watch.app.R.string.secondo_app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final MainController getMainController() {
        Object activity = getActivity();
        if (activity instanceof MainController) {
            return (MainController) activity;
        }
        throw new IllegalArgumentException(("Containing Activity " + activity + " needs to implement MainController").toString());
    }

    public abstract String getName();

    public String getParentFragmentName() {
        return this.parentFragmentName;
    }

    public int getTab() {
        return 2;
    }

    public final AnimatedToolbar getToolbar() {
        return this.toolbar;
    }

    public Drawable getToolbarBackDrawable() {
        return null;
    }

    public final int getWatchYOffset(int r5) {
        return MathKt__MathJVMKt.roundToInt((r5 * 0.5f) - (((r5 - getActionBarHeight()) - getResources().getDimension(com.kronaby.watch.app.R.dimen.drop_target_top_margin)) * 0.5f));
    }

    public boolean hasTabs() {
        return false;
    }

    public boolean onBack() {
        return true;
    }

    public final void onClick(View view, final Function2<? super View, ? super Continuation<? super Unit>, ? extends Object> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.BaseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseFragment.onClick$lambda$4(BaseFragment.this, onClick, view2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setActivityLauncher(CustomActivityResult.Companion.registerForActivityResult(this, new ActivityResultContracts$StartActivityForResult()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupToolbar(view);
    }

    public final void setActivityLauncher(CustomActivityResult<Intent, ActivityResult> customActivityResult) {
        Intrinsics.checkNotNullParameter(customActivityResult, "<set-?>");
        this.activityLauncher = customActivityResult;
    }

    public final void setToolbar(AnimatedToolbar animatedToolbar) {
        this.toolbar = animatedToolbar;
    }

    public final Unit showToolbarUpIndicator(boolean z) {
        AppCompatActivity appCompatActivity;
        ActionBar supportActionBar;
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            appCompatActivity = (AppCompatActivity) activity;
        } else {
            appCompatActivity = null;
        }
        if (appCompatActivity == null || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return null;
        }
        supportActionBar.setDisplayHomeAsUpEnabled(z);
        return Unit.INSTANCE;
    }

    public void onRevealedFragmentClosed() {
    }

    public void onRevealedFragmentOpened() {
    }
}

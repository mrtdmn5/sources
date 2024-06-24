package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.screens.BaseFragment;
import com.kronaby.watch.app.R;
import java.io.FileNotFoundException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public class LottiePreviewFragment extends BaseFragment {
    private static final String TAG = "LottiePreviewFragment";
    private LottieAnimationView mLottieAnimationView;
    private TextView mTextLoadTime;
    final ActivityResultLauncher<String> storagePermissionLauncher = PermissionCompatKt.registerPermission(this, new Function0() { // from class: com.animaconnected.secondo.screens.debugsettings.LottiePreviewFragment$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit lambda$new$0;
            lambda$new$0 = LottiePreviewFragment.this.lambda$new$0();
            return lambda$new$0;
        }
    }, new LottiePreviewFragment$$ExternalSyntheticLambda2());

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$0() {
        showFilePicker();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$new$1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onCreateView$2(View view) {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.storagePermissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
        } else {
            showFilePicker();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilePicker$3(long j, LottieComposition lottieComposition) {
        this.mTextLoadTime.setText("Time to load: " + (SystemClock.uptimeMillis() - j) + " ms");
        this.mLottieAnimationView.setProgress(0.0f);
        this.mLottieAnimationView.setComposition(lottieComposition);
        this.mLottieAnimationView.setRepeatCount(-1);
        this.mLottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit lambda$showFilePicker$4(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null) {
            Uri data = intent.getData();
            final long uptimeMillis = SystemClock.uptimeMillis();
            try {
                Lottie.loadAnimation(data, requireContext()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.LottiePreviewFragment$$ExternalSyntheticLambda3
                    @Override // com.animaconnected.future.SuccessCallback
                    public final void onSuccess(Object obj) {
                        LottiePreviewFragment.this.lambda$showFilePicker$3(uptimeMillis, (LottieComposition) obj);
                    }
                });
                return null;
            } catch (FileNotFoundException e) {
                Log.w(TAG, e);
                return null;
            }
        }
        return null;
    }

    public static LottiePreviewFragment newInstance() {
        return new LottiePreviewFragment();
    }

    private void showFilePicker() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        getActivityLauncher().launch(intent, new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.LottiePreviewFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$showFilePicker$4;
                lambda$showFilePicker$4 = LottiePreviewFragment.this.lambda$showFilePicker$4((ActivityResult) obj);
                return lambda$showFilePicker$4;
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_settings);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "LottiePreview";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_lottie_preview, viewGroup, false);
        this.mLottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottie_animation_view);
        this.mTextLoadTime = (TextView) inflate.findViewById(R.id.lottie_load_time);
        inflate.findViewById(R.id.select_lottie_button).setOnClickListener(new LottiePreviewFragment$$ExternalSyntheticLambda0(this, 0));
        return inflate;
    }
}

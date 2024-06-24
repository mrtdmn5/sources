package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.screens.BaseFragment;
import com.kronaby.watch.app.R;
import java.util.Map;

/* loaded from: classes3.dex */
public class RemoteConfigFragment extends BaseFragment {
    private static final int GREEN_COLOR = Color.rgb(0, 200, 0);
    private static final int RED_COLOR = Color.rgb(200, 0, 0);
    private TextView mText;

    public static RemoteConfigFragment create(Context context) {
        return new RemoteConfigFragment();
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
        return "RemoteConfig";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_remoteconfig, viewGroup, false);
        this.mText = (TextView) inflate.findViewById(R.id.remoteconfig_text);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mText.setText("");
        Map<String, String> all = RemoteConfigController.getInstance(KronabyApplication.getContext()).getAll();
        for (String str : all.keySet()) {
            String str2 = all.get(str);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, str.length(), 0);
            spannableString.setSpan(new StyleSpan(1), 0, str.length(), 0);
            SpannableString spannableString2 = new SpannableString(str2);
            spannableString2.setSpan(new AbsoluteSizeSpan(12, true), 0, str2.length(), 0);
            if (str2.equalsIgnoreCase("true")) {
                spannableString2.setSpan(new ForegroundColorSpan(GREEN_COLOR), 0, str2.length(), 0);
            } else if (str2.equalsIgnoreCase("false")) {
                spannableString2.setSpan(new ForegroundColorSpan(RED_COLOR), 0, str2.length(), 0);
            }
            this.mText.append(TextUtils.concat(spannableString, "\n", spannableString2, "\n"));
        }
    }
}

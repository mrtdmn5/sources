package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.SectionLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentWatchSettingsBinding implements ViewBinding {
    public final Button activateWatch;
    public final ProgressBar connectingProgressbar;
    public final RelativeLayout imageContainer;
    private final LinearLayout rootView;
    public final ImageView skuImage;
    public final ImageView watchSettingsBatteryFlashImage;
    public final ImageView watchSettingsBatteryImage;
    public final TextView watchSettingsBatteryPercent;
    public final SectionLayout watchSettingsCalibrate;
    public final SectionLayout watchSettingsForgetWatch;
    public final SectionLayout watchSettingsLostWatch;
    public final SectionLayout watchSettingsStrongerVibration;
    public final TextView watchSettingsTitle;
    public final SectionLayout watchSettingsUpdate;
    public final TextView watchStatus;

    private FragmentWatchSettingsBinding(LinearLayout linearLayout, Button button, ProgressBar progressBar, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, SectionLayout sectionLayout, SectionLayout sectionLayout2, SectionLayout sectionLayout3, SectionLayout sectionLayout4, TextView textView2, SectionLayout sectionLayout5, TextView textView3) {
        this.rootView = linearLayout;
        this.activateWatch = button;
        this.connectingProgressbar = progressBar;
        this.imageContainer = relativeLayout;
        this.skuImage = imageView;
        this.watchSettingsBatteryFlashImage = imageView2;
        this.watchSettingsBatteryImage = imageView3;
        this.watchSettingsBatteryPercent = textView;
        this.watchSettingsCalibrate = sectionLayout;
        this.watchSettingsForgetWatch = sectionLayout2;
        this.watchSettingsLostWatch = sectionLayout3;
        this.watchSettingsStrongerVibration = sectionLayout4;
        this.watchSettingsTitle = textView2;
        this.watchSettingsUpdate = sectionLayout5;
        this.watchStatus = textView3;
    }

    public static FragmentWatchSettingsBinding bind(View view) {
        int r1 = R.id.activate_watch;
        Button button = (Button) ViewBindings.findChildViewById(R.id.activate_watch, view);
        if (button != null) {
            r1 = R.id.connecting_progressbar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.connecting_progressbar, view);
            if (progressBar != null) {
                r1 = R.id.image_container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.image_container, view);
                if (relativeLayout != null) {
                    r1 = R.id.sku_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.sku_image, view);
                    if (imageView != null) {
                        r1 = R.id.watch_settings_battery_flash_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.watch_settings_battery_flash_image, view);
                        if (imageView2 != null) {
                            r1 = R.id.watch_settings_battery_image;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.watch_settings_battery_image, view);
                            if (imageView3 != null) {
                                r1 = R.id.watch_settings_battery_percent;
                                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.watch_settings_battery_percent, view);
                                if (textView != null) {
                                    r1 = R.id.watch_settings_calibrate;
                                    SectionLayout sectionLayout = (SectionLayout) ViewBindings.findChildViewById(R.id.watch_settings_calibrate, view);
                                    if (sectionLayout != null) {
                                        r1 = R.id.watch_settings_forget_watch;
                                        SectionLayout sectionLayout2 = (SectionLayout) ViewBindings.findChildViewById(R.id.watch_settings_forget_watch, view);
                                        if (sectionLayout2 != null) {
                                            r1 = R.id.watch_settings_lost_watch;
                                            SectionLayout sectionLayout3 = (SectionLayout) ViewBindings.findChildViewById(R.id.watch_settings_lost_watch, view);
                                            if (sectionLayout3 != null) {
                                                r1 = R.id.watch_settings_stronger_vibration;
                                                SectionLayout sectionLayout4 = (SectionLayout) ViewBindings.findChildViewById(R.id.watch_settings_stronger_vibration, view);
                                                if (sectionLayout4 != null) {
                                                    r1 = R.id.watch_settings_title;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.watch_settings_title, view);
                                                    if (textView2 != null) {
                                                        r1 = R.id.watch_settings_update;
                                                        SectionLayout sectionLayout5 = (SectionLayout) ViewBindings.findChildViewById(R.id.watch_settings_update, view);
                                                        if (sectionLayout5 != null) {
                                                            r1 = R.id.watch_status;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.watch_status, view);
                                                            if (textView3 != null) {
                                                                return new FragmentWatchSettingsBinding((LinearLayout) view, button, progressBar, relativeLayout, imageView, imageView2, imageView3, textView, sectionLayout, sectionLayout2, sectionLayout3, sectionLayout4, textView2, sectionLayout5, textView3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentWatchSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWatchSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_watch_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}

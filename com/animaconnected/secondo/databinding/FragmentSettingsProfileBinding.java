package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentSettingsProfileBinding implements ViewBinding {
    public final Button btnCreateAccount;
    public final Button btnLogIn;
    public final LinearLayout containerBottom;
    public final RelativeLayout detailLayout;
    public final LinearLayout layoutAccSettings;
    public final LinearLayout layoutAttributes;
    public final LinearLayout layoutSignIn;
    public final LinearLayout layoutUnits;
    public final LinearLayout profileBirthContainer;
    public final TextView profileBirthValue;
    public final LinearLayout profileGenderContainer;
    public final TextView profileGenderValue;
    public final LinearLayout profileHeightContainer;
    public final TextView profileHeightValue;
    public final LinearLayout profileWeightContainer;
    public final TextView profileWeightValue;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final TopFadeScrollView scrollView;
    public final CustomToolbar toolbar;
    public final TextView tvAboutYouDescription;
    public final TextView tvAccountTitle;
    public final TextView tvDateOfBirth;
    public final TextView tvHeight;
    public final TextView tvMeasurement;
    public final TextView tvSex;
    public final TextView tvTemperature;
    public final TextView tvWeight;
    public final LinearLayout unitsMeasurementsContainer;
    public final TextView unitsMeasurementsValue;
    public final LinearLayout unitsTemperatureContainer;
    public final TextView unitsTemperatureValue;

    private FragmentSettingsProfileBinding(RelativeLayout relativeLayout, Button button, Button button2, LinearLayout linearLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView, LinearLayout linearLayout7, TextView textView2, LinearLayout linearLayout8, TextView textView3, LinearLayout linearLayout9, TextView textView4, ProgressBar progressBar, TopFadeScrollView topFadeScrollView, CustomToolbar customToolbar, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, LinearLayout linearLayout10, TextView textView13, LinearLayout linearLayout11, TextView textView14) {
        this.rootView = relativeLayout;
        this.btnCreateAccount = button;
        this.btnLogIn = button2;
        this.containerBottom = linearLayout;
        this.detailLayout = relativeLayout2;
        this.layoutAccSettings = linearLayout2;
        this.layoutAttributes = linearLayout3;
        this.layoutSignIn = linearLayout4;
        this.layoutUnits = linearLayout5;
        this.profileBirthContainer = linearLayout6;
        this.profileBirthValue = textView;
        this.profileGenderContainer = linearLayout7;
        this.profileGenderValue = textView2;
        this.profileHeightContainer = linearLayout8;
        this.profileHeightValue = textView3;
        this.profileWeightContainer = linearLayout9;
        this.profileWeightValue = textView4;
        this.progressBar = progressBar;
        this.scrollView = topFadeScrollView;
        this.toolbar = customToolbar;
        this.tvAboutYouDescription = textView5;
        this.tvAccountTitle = textView6;
        this.tvDateOfBirth = textView7;
        this.tvHeight = textView8;
        this.tvMeasurement = textView9;
        this.tvSex = textView10;
        this.tvTemperature = textView11;
        this.tvWeight = textView12;
        this.unitsMeasurementsContainer = linearLayout10;
        this.unitsMeasurementsValue = textView13;
        this.unitsTemperatureContainer = linearLayout11;
        this.unitsTemperatureValue = textView14;
    }

    public static FragmentSettingsProfileBinding bind(View view) {
        int r1 = R.id.btn_create_account;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_create_account, view);
        if (button != null) {
            r1 = R.id.btn_log_in;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_log_in, view);
            if (button2 != null) {
                r1 = R.id.container_bottom;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container_bottom, view);
                if (linearLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    r1 = R.id.layout_acc_settings;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_acc_settings, view);
                    if (linearLayout2 != null) {
                        r1 = R.id.layout_attributes;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_attributes, view);
                        if (linearLayout3 != null) {
                            r1 = R.id.layout_sign_in;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_sign_in, view);
                            if (linearLayout4 != null) {
                                r1 = R.id.layout_units;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_units, view);
                                if (linearLayout5 != null) {
                                    r1 = R.id.profile_birth_container;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(R.id.profile_birth_container, view);
                                    if (linearLayout6 != null) {
                                        r1 = R.id.profile_birth_value;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.profile_birth_value, view);
                                        if (textView != null) {
                                            r1 = R.id.profile_gender_container;
                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(R.id.profile_gender_container, view);
                                            if (linearLayout7 != null) {
                                                r1 = R.id.profile_gender_value;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.profile_gender_value, view);
                                                if (textView2 != null) {
                                                    r1 = R.id.profile_height_container;
                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(R.id.profile_height_container, view);
                                                    if (linearLayout8 != null) {
                                                        r1 = R.id.profile_height_value;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.profile_height_value, view);
                                                        if (textView3 != null) {
                                                            r1 = R.id.profile_weight_container;
                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(R.id.profile_weight_container, view);
                                                            if (linearLayout9 != null) {
                                                                r1 = R.id.profile_weight_value;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.profile_weight_value, view);
                                                                if (textView4 != null) {
                                                                    r1 = R.id.progress_bar;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                                                                    if (progressBar != null) {
                                                                        r1 = R.id.scroll_view;
                                                                        TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.scroll_view, view);
                                                                        if (topFadeScrollView != null) {
                                                                            r1 = R.id.toolbar;
                                                                            CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar, view);
                                                                            if (customToolbar != null) {
                                                                                r1 = R.id.tv_about_you_description;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_about_you_description, view);
                                                                                if (textView5 != null) {
                                                                                    r1 = R.id.tv_account_title;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_account_title, view);
                                                                                    if (textView6 != null) {
                                                                                        r1 = R.id.tv_date_of_birth;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(R.id.tv_date_of_birth, view);
                                                                                        if (textView7 != null) {
                                                                                            r1 = R.id.tv_height;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(R.id.tv_height, view);
                                                                                            if (textView8 != null) {
                                                                                                r1 = R.id.tv_measurement;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(R.id.tv_measurement, view);
                                                                                                if (textView9 != null) {
                                                                                                    r1 = R.id.tv_sex;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(R.id.tv_sex, view);
                                                                                                    if (textView10 != null) {
                                                                                                        r1 = R.id.tv_temperature;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(R.id.tv_temperature, view);
                                                                                                        if (textView11 != null) {
                                                                                                            r1 = R.id.tv_weight;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(R.id.tv_weight, view);
                                                                                                            if (textView12 != null) {
                                                                                                                r1 = R.id.units_measurements_container;
                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(R.id.units_measurements_container, view);
                                                                                                                if (linearLayout10 != null) {
                                                                                                                    r1 = R.id.units_measurements_value;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(R.id.units_measurements_value, view);
                                                                                                                    if (textView13 != null) {
                                                                                                                        r1 = R.id.units_temperature_container;
                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(R.id.units_temperature_container, view);
                                                                                                                        if (linearLayout11 != null) {
                                                                                                                            r1 = R.id.units_temperature_value;
                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(R.id.units_temperature_value, view);
                                                                                                                            if (textView14 != null) {
                                                                                                                                return new FragmentSettingsProfileBinding(relativeLayout, button, button2, linearLayout, relativeLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView, linearLayout7, textView2, linearLayout8, textView3, linearLayout9, textView4, progressBar, topFadeScrollView, customToolbar, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, linearLayout10, textView13, linearLayout11, textView14);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentSettingsProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSettingsProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}

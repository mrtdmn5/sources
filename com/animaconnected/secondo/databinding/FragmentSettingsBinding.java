package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.SectionLayout;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentSettingsBinding implements ViewBinding {
    public final Button addWatch;
    public final SectionLayout debugSettingsButton;
    public final SectionLayout displayAppDetailsTitle;
    public final TopFadeScrollView fragmentContainer;
    public final SectionLayout licence;
    private final LinearLayout rootView;
    public final LinearLayout settingsAccount;
    public final SectionLayout settingsAccountLayout;
    public final SectionLayout settingsContactSupport;
    public final LinearLayout settingsDebugLayout;
    public final SectionLayout settingsDebugging;
    public final SectionLayout settingsFacebook;
    public final SectionLayout settingsHowToVideos;
    public final SectionLayout settingsInstagram;
    public final SectionLayout settingsLabsButton;
    public final SectionLayout settingsLabsContactButton;
    public final LinearLayout settingsLabsLayout;
    public final SectionLayout settingsLabsMoreNumbers;
    public final SectionLayout settingsNotificationsCalls;
    public final LinearLayout settingsNotificationsLayout;
    public final SectionLayout settingsNotificationsQuietHours;
    public final SectionLayout settingsOpenFaq;
    public final SectionLayout settingsPrivacyPolicyButton;
    public final SectionLayout settingsRateUsButton;
    public final LinearLayout settingsRateUsLayout;
    public final LinearLayout settingsSocialMediaLayout;
    public final SectionLayout settingsTermsOfUseButton;
    public final LinearLayout settingsWatches;
    public final TextView settingsWatchesTitle;
    public final SectionLayout tipsAndTricksButton;

    private FragmentSettingsBinding(LinearLayout linearLayout, Button button, SectionLayout sectionLayout, SectionLayout sectionLayout2, TopFadeScrollView topFadeScrollView, SectionLayout sectionLayout3, LinearLayout linearLayout2, SectionLayout sectionLayout4, SectionLayout sectionLayout5, LinearLayout linearLayout3, SectionLayout sectionLayout6, SectionLayout sectionLayout7, SectionLayout sectionLayout8, SectionLayout sectionLayout9, SectionLayout sectionLayout10, SectionLayout sectionLayout11, LinearLayout linearLayout4, SectionLayout sectionLayout12, SectionLayout sectionLayout13, LinearLayout linearLayout5, SectionLayout sectionLayout14, SectionLayout sectionLayout15, SectionLayout sectionLayout16, SectionLayout sectionLayout17, LinearLayout linearLayout6, LinearLayout linearLayout7, SectionLayout sectionLayout18, LinearLayout linearLayout8, TextView textView, SectionLayout sectionLayout19) {
        this.rootView = linearLayout;
        this.addWatch = button;
        this.debugSettingsButton = sectionLayout;
        this.displayAppDetailsTitle = sectionLayout2;
        this.fragmentContainer = topFadeScrollView;
        this.licence = sectionLayout3;
        this.settingsAccount = linearLayout2;
        this.settingsAccountLayout = sectionLayout4;
        this.settingsContactSupport = sectionLayout5;
        this.settingsDebugLayout = linearLayout3;
        this.settingsDebugging = sectionLayout6;
        this.settingsFacebook = sectionLayout7;
        this.settingsHowToVideos = sectionLayout8;
        this.settingsInstagram = sectionLayout9;
        this.settingsLabsButton = sectionLayout10;
        this.settingsLabsContactButton = sectionLayout11;
        this.settingsLabsLayout = linearLayout4;
        this.settingsLabsMoreNumbers = sectionLayout12;
        this.settingsNotificationsCalls = sectionLayout13;
        this.settingsNotificationsLayout = linearLayout5;
        this.settingsNotificationsQuietHours = sectionLayout14;
        this.settingsOpenFaq = sectionLayout15;
        this.settingsPrivacyPolicyButton = sectionLayout16;
        this.settingsRateUsButton = sectionLayout17;
        this.settingsRateUsLayout = linearLayout6;
        this.settingsSocialMediaLayout = linearLayout7;
        this.settingsTermsOfUseButton = sectionLayout18;
        this.settingsWatches = linearLayout8;
        this.settingsWatchesTitle = textView;
        this.tipsAndTricksButton = sectionLayout19;
    }

    public static FragmentSettingsBinding bind(View view) {
        int r1 = R.id.add_watch;
        Button button = (Button) ViewBindings.findChildViewById(R.id.add_watch, view);
        if (button != null) {
            r1 = R.id.debug_settings_button;
            SectionLayout sectionLayout = (SectionLayout) ViewBindings.findChildViewById(R.id.debug_settings_button, view);
            if (sectionLayout != null) {
                r1 = R.id.display_app_details_title;
                SectionLayout sectionLayout2 = (SectionLayout) ViewBindings.findChildViewById(R.id.display_app_details_title, view);
                if (sectionLayout2 != null) {
                    r1 = R.id.fragment_container;
                    TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.fragment_container, view);
                    if (topFadeScrollView != null) {
                        r1 = R.id.licence;
                        SectionLayout sectionLayout3 = (SectionLayout) ViewBindings.findChildViewById(R.id.licence, view);
                        if (sectionLayout3 != null) {
                            r1 = R.id.settings_account;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_account, view);
                            if (linearLayout != null) {
                                r1 = R.id.settings_account_layout;
                                SectionLayout sectionLayout4 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_account_layout, view);
                                if (sectionLayout4 != null) {
                                    r1 = R.id.settings_contact_support;
                                    SectionLayout sectionLayout5 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_contact_support, view);
                                    if (sectionLayout5 != null) {
                                        r1 = R.id.settings_debug_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_debug_layout, view);
                                        if (linearLayout2 != null) {
                                            r1 = R.id.settings_debugging;
                                            SectionLayout sectionLayout6 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_debugging, view);
                                            if (sectionLayout6 != null) {
                                                r1 = R.id.settings_facebook;
                                                SectionLayout sectionLayout7 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_facebook, view);
                                                if (sectionLayout7 != null) {
                                                    r1 = R.id.settings_how_to_videos;
                                                    SectionLayout sectionLayout8 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_how_to_videos, view);
                                                    if (sectionLayout8 != null) {
                                                        r1 = R.id.settings_instagram;
                                                        SectionLayout sectionLayout9 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_instagram, view);
                                                        if (sectionLayout9 != null) {
                                                            r1 = R.id.settings_labs_button;
                                                            SectionLayout sectionLayout10 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_labs_button, view);
                                                            if (sectionLayout10 != null) {
                                                                r1 = R.id.settings_labs_contact_button;
                                                                SectionLayout sectionLayout11 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_labs_contact_button, view);
                                                                if (sectionLayout11 != null) {
                                                                    r1 = R.id.settings_labs_layout;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_labs_layout, view);
                                                                    if (linearLayout3 != null) {
                                                                        r1 = R.id.settings_labs_more_numbers;
                                                                        SectionLayout sectionLayout12 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_labs_more_numbers, view);
                                                                        if (sectionLayout12 != null) {
                                                                            r1 = R.id.settings_notifications_calls;
                                                                            SectionLayout sectionLayout13 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_notifications_calls, view);
                                                                            if (sectionLayout13 != null) {
                                                                                r1 = R.id.settings_notifications_layout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_notifications_layout, view);
                                                                                if (linearLayout4 != null) {
                                                                                    r1 = R.id.settings_notifications_quiet_hours;
                                                                                    SectionLayout sectionLayout14 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_notifications_quiet_hours, view);
                                                                                    if (sectionLayout14 != null) {
                                                                                        r1 = R.id.settings_open_faq;
                                                                                        SectionLayout sectionLayout15 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_open_faq, view);
                                                                                        if (sectionLayout15 != null) {
                                                                                            r1 = R.id.settings_privacy_policy_button;
                                                                                            SectionLayout sectionLayout16 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_privacy_policy_button, view);
                                                                                            if (sectionLayout16 != null) {
                                                                                                r1 = R.id.settings_rate_us_button;
                                                                                                SectionLayout sectionLayout17 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_rate_us_button, view);
                                                                                                if (sectionLayout17 != null) {
                                                                                                    r1 = R.id.settings_rate_us_layout;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_rate_us_layout, view);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        r1 = R.id.settings_social_media_layout;
                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_social_media_layout, view);
                                                                                                        if (linearLayout6 != null) {
                                                                                                            r1 = R.id.settings_terms_of_use_button;
                                                                                                            SectionLayout sectionLayout18 = (SectionLayout) ViewBindings.findChildViewById(R.id.settings_terms_of_use_button, view);
                                                                                                            if (sectionLayout18 != null) {
                                                                                                                r1 = R.id.settings_watches;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(R.id.settings_watches, view);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    r1 = R.id.settings_watches_title;
                                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.settings_watches_title, view);
                                                                                                                    if (textView != null) {
                                                                                                                        r1 = R.id.tips_and_tricks_button;
                                                                                                                        SectionLayout sectionLayout19 = (SectionLayout) ViewBindings.findChildViewById(R.id.tips_and_tricks_button, view);
                                                                                                                        if (sectionLayout19 != null) {
                                                                                                                            return new FragmentSettingsBinding((LinearLayout) view, button, sectionLayout, sectionLayout2, topFadeScrollView, sectionLayout3, linearLayout, sectionLayout4, sectionLayout5, linearLayout2, sectionLayout6, sectionLayout7, sectionLayout8, sectionLayout9, sectionLayout10, sectionLayout11, linearLayout3, sectionLayout12, sectionLayout13, linearLayout4, sectionLayout14, sectionLayout15, sectionLayout16, sectionLayout17, linearLayout5, linearLayout6, sectionLayout18, linearLayout7, textView, sectionLayout19);
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

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
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

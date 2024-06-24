package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDashboardBinding implements ViewBinding {
    public final Button btnActivity;
    public final Button btnApps;
    public final Button btnNotification;
    public final Button btnPushers;
    public final Button btnSettings;
    public final Button btnWatchFace;
    public final RelativeLayout layoutActivity;
    public final RelativeLayout layoutApps;
    public final RelativeLayout layoutNotification;
    public final RelativeLayout layoutPushers;
    public final RelativeLayout layoutSettings;
    public final RelativeLayout layoutWatchFace;
    public final ImageView quietHoursBadge;
    private final LinearLayout rootView;
    public final TextView settingsButton;
    public final ImageView updateAvailableBadge;

    private FragmentDashboardBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, ImageView imageView, TextView textView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.btnActivity = button;
        this.btnApps = button2;
        this.btnNotification = button3;
        this.btnPushers = button4;
        this.btnSettings = button5;
        this.btnWatchFace = button6;
        this.layoutActivity = relativeLayout;
        this.layoutApps = relativeLayout2;
        this.layoutNotification = relativeLayout3;
        this.layoutPushers = relativeLayout4;
        this.layoutSettings = relativeLayout5;
        this.layoutWatchFace = relativeLayout6;
        this.quietHoursBadge = imageView;
        this.settingsButton = textView;
        this.updateAvailableBadge = imageView2;
    }

    public static FragmentDashboardBinding bind(View view) {
        int r1 = R.id.btn_activity;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_activity, view);
        if (button != null) {
            r1 = R.id.btn_apps;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_apps, view);
            if (button2 != null) {
                r1 = R.id.btn_notification;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_notification, view);
                if (button3 != null) {
                    r1 = R.id.btn_pushers;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.btn_pushers, view);
                    if (button4 != null) {
                        r1 = R.id.btn_settings;
                        Button button5 = (Button) ViewBindings.findChildViewById(R.id.btn_settings, view);
                        if (button5 != null) {
                            r1 = R.id.btn_watch_face;
                            Button button6 = (Button) ViewBindings.findChildViewById(R.id.btn_watch_face, view);
                            if (button6 != null) {
                                r1 = R.id.layout_activity;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_activity, view);
                                if (relativeLayout != null) {
                                    r1 = R.id.layout_apps;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_apps, view);
                                    if (relativeLayout2 != null) {
                                        r1 = R.id.layout_notification;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_notification, view);
                                        if (relativeLayout3 != null) {
                                            r1 = R.id.layout_pushers;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_pushers, view);
                                            if (relativeLayout4 != null) {
                                                r1 = R.id.layout_settings;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_settings, view);
                                                if (relativeLayout5 != null) {
                                                    r1 = R.id.layout_watch_face;
                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_watch_face, view);
                                                    if (relativeLayout6 != null) {
                                                        r1 = R.id.quiet_hours_badge;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.quiet_hours_badge, view);
                                                        if (imageView != null) {
                                                            r1 = R.id.settings_button;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.settings_button, view);
                                                            if (textView != null) {
                                                                r1 = R.id.update_available_badge;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.update_available_badge, view);
                                                                if (imageView2 != null) {
                                                                    return new FragmentDashboardBinding((LinearLayout) view, button, button2, button3, button4, button5, button6, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, imageView, textView, imageView2);
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

    public static FragmentDashboardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDashboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_dashboard, viewGroup, false);
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

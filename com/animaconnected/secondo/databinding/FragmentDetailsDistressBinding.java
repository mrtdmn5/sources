package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsDistressBinding implements ViewBinding {
    public final FrameLayout avatar;
    public final TextView avatarText;
    public final Button cancelInvitationBtn;
    public final MorseCodeView emergencyMorseCode;
    public final Button inviteSafetyContactBtn;
    public final DetailLottieViewPager lottieAnimationPager;
    public final LinearLayout notStarted;
    public final RelativeLayout observer;
    public final TextView observerName;
    public final Space observerSpace;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    public final Button removeBtn;
    private final LinearLayout rootView;
    public final ProgressBar setupProgressbar;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;
    public final TextView tvSafetyContact;
    public final LinearLayout waitForReply;

    private FragmentDetailsDistressBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, Button button, MorseCodeView morseCodeView, Button button2, DetailLottieViewPager detailLottieViewPager, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView2, Space space, ImageView imageView, TextView textView3, Button button3, ProgressBar progressBar, TextView textView4, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.avatar = frameLayout;
        this.avatarText = textView;
        this.cancelInvitationBtn = button;
        this.emergencyMorseCode = morseCodeView;
        this.inviteSafetyContactBtn = button2;
        this.lottieAnimationPager = detailLottieViewPager;
        this.notStarted = linearLayout2;
        this.observer = relativeLayout;
        this.observerName = textView2;
        this.observerSpace = space;
        this.overviewEndLine = imageView;
        this.pusherHeaderTitle = textView3;
        this.removeBtn = button3;
        this.setupProgressbar = progressBar;
        this.titleTextView = textView4;
        this.triggerContainer = linearLayout3;
        this.tvSafetyContact = textView5;
        this.waitForReply = linearLayout4;
    }

    public static FragmentDetailsDistressBinding bind(View view) {
        int r1 = R.id.avatar;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.avatar, view);
        if (frameLayout != null) {
            r1 = R.id.avatar_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.avatar_text, view);
            if (textView != null) {
                r1 = R.id.cancel_invitation_btn;
                Button button = (Button) ViewBindings.findChildViewById(R.id.cancel_invitation_btn, view);
                if (button != null) {
                    r1 = R.id.emergency_morse_code;
                    MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.emergency_morse_code, view);
                    if (morseCodeView != null) {
                        r1 = R.id.invite_safety_contact_btn;
                        Button button2 = (Button) ViewBindings.findChildViewById(R.id.invite_safety_contact_btn, view);
                        if (button2 != null) {
                            r1 = R.id.lottie_animation_pager;
                            DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
                            if (detailLottieViewPager != null) {
                                r1 = R.id.not_started;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.not_started, view);
                                if (linearLayout != null) {
                                    r1 = R.id.observer;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.observer, view);
                                    if (relativeLayout != null) {
                                        r1 = R.id.observer_name;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.observer_name, view);
                                        if (textView2 != null) {
                                            r1 = R.id.observer_space;
                                            Space space = (Space) ViewBindings.findChildViewById(R.id.observer_space, view);
                                            if (space != null) {
                                                r1 = R.id.overview_end_line;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                                                if (imageView != null) {
                                                    r1 = R.id.pusher_header_title;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                                                    if (textView3 != null) {
                                                        r1 = R.id.remove_btn;
                                                        Button button3 = (Button) ViewBindings.findChildViewById(R.id.remove_btn, view);
                                                        if (button3 != null) {
                                                            r1 = R.id.setup_progressbar;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.setup_progressbar, view);
                                                            if (progressBar != null) {
                                                                r1 = R.id.title_text_view;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                                                if (textView4 != null) {
                                                                    r1 = R.id.trigger_container;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                                                                    if (linearLayout2 != null) {
                                                                        r1 = R.id.tv_safety_contact;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_safety_contact, view);
                                                                        if (textView5 != null) {
                                                                            r1 = R.id.wait_for_reply;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.wait_for_reply, view);
                                                                            if (linearLayout3 != null) {
                                                                                return new FragmentDetailsDistressBinding((LinearLayout) view, frameLayout, textView, button, morseCodeView, button2, detailLottieViewPager, linearLayout, relativeLayout, textView2, space, imageView, textView3, button3, progressBar, textView4, linearLayout2, textView5, linearLayout3);
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

    public static FragmentDetailsDistressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsDistressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_distress, viewGroup, false);
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

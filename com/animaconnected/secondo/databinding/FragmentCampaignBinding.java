package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentCampaignBinding implements ViewBinding {
    public final TextView campaignDescription;
    public final TextView campaignHeader;
    public final Button campaignPrimaryButton;
    public final Button campaignSecondaryButton;
    public final TextView campaignTitle;
    public final LinearLayout content;
    private final LinearLayout rootView;

    private FragmentCampaignBinding(LinearLayout linearLayout, TextView textView, TextView textView2, Button button, Button button2, TextView textView3, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.campaignDescription = textView;
        this.campaignHeader = textView2;
        this.campaignPrimaryButton = button;
        this.campaignSecondaryButton = button2;
        this.campaignTitle = textView3;
        this.content = linearLayout2;
    }

    public static FragmentCampaignBinding bind(View view) {
        int r0 = R.id.campaign_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.campaign_description, view);
        if (textView != null) {
            r0 = R.id.campaign_header;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.campaign_header, view);
            if (textView2 != null) {
                r0 = R.id.campaign_primary_button;
                Button button = (Button) ViewBindings.findChildViewById(R.id.campaign_primary_button, view);
                if (button != null) {
                    r0 = R.id.campaign_secondary_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(R.id.campaign_secondary_button, view);
                    if (button2 != null) {
                        r0 = R.id.campaign_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.campaign_title, view);
                        if (textView3 != null) {
                            r0 = R.id.content;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.content, view);
                            if (linearLayout != null) {
                                return new FragmentCampaignBinding((LinearLayout) view, textView, textView2, button, button2, textView3, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentCampaignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCampaignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_campaign, viewGroup, false);
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

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
public final class FragmentProfileSettingsBinding implements ViewBinding {
    public final Button btnDeleteAcc;
    public final RelativeLayout btnDownloadData;
    public final Button btnEditEmail;
    public final Button btnLogOut;
    public final Button btnPasswordSettings;
    public final ImageView ivMarbleDownload;
    public final LinearLayout layoutTextsDownload;
    private final LinearLayout rootView;
    public final TextView tvExpirationDownloadData;
    public final TextView tvSubtitleDownloadData;
    public final TextView tvTitleDownloadData;

    private FragmentProfileSettingsBinding(LinearLayout linearLayout, Button button, RelativeLayout relativeLayout, Button button2, Button button3, Button button4, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnDeleteAcc = button;
        this.btnDownloadData = relativeLayout;
        this.btnEditEmail = button2;
        this.btnLogOut = button3;
        this.btnPasswordSettings = button4;
        this.ivMarbleDownload = imageView;
        this.layoutTextsDownload = linearLayout2;
        this.tvExpirationDownloadData = textView;
        this.tvSubtitleDownloadData = textView2;
        this.tvTitleDownloadData = textView3;
    }

    public static FragmentProfileSettingsBinding bind(View view) {
        int r0 = R.id.btn_delete_acc;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_delete_acc, view);
        if (button != null) {
            r0 = R.id.btn_download_data;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.btn_download_data, view);
            if (relativeLayout != null) {
                r0 = R.id.btn_edit_email;
                Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_edit_email, view);
                if (button2 != null) {
                    r0 = R.id.btn_log_out;
                    Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_log_out, view);
                    if (button3 != null) {
                        r0 = R.id.btn_password_settings;
                        Button button4 = (Button) ViewBindings.findChildViewById(R.id.btn_password_settings, view);
                        if (button4 != null) {
                            r0 = R.id.iv_marble_download;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.iv_marble_download, view);
                            if (imageView != null) {
                                r0 = R.id.layout_texts_download;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_texts_download, view);
                                if (linearLayout != null) {
                                    r0 = R.id.tv_expiration_download_data;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_expiration_download_data, view);
                                    if (textView != null) {
                                        r0 = R.id.tv_subtitle_download_data;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_subtitle_download_data, view);
                                        if (textView2 != null) {
                                            r0 = R.id.tv_title_download_data;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_title_download_data, view);
                                            if (textView3 != null) {
                                                return new FragmentProfileSettingsBinding((LinearLayout) view, button, relativeLayout, button2, button3, button4, imageView, linearLayout, textView, textView2, textView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentProfileSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentProfileSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile_settings, viewGroup, false);
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

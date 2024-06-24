package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugImagePreviewBinding implements ViewBinding {
    public final CheckBox allowAlpha;
    public final Button debugImageImportFile;
    public final GridLayout debugImageList;
    public final EditText debugImageX;
    public final EditText debugImageY;
    public final Spinner formatType;
    public final Spinner palette;
    public final ProgressBar progress;
    private final ScrollView rootView;
    public final ImageView selectedImage;
    public final Button upload;

    private FragmentDebugImagePreviewBinding(ScrollView scrollView, CheckBox checkBox, Button button, GridLayout gridLayout, EditText editText, EditText editText2, Spinner spinner, Spinner spinner2, ProgressBar progressBar, ImageView imageView, Button button2) {
        this.rootView = scrollView;
        this.allowAlpha = checkBox;
        this.debugImageImportFile = button;
        this.debugImageList = gridLayout;
        this.debugImageX = editText;
        this.debugImageY = editText2;
        this.formatType = spinner;
        this.palette = spinner2;
        this.progress = progressBar;
        this.selectedImage = imageView;
        this.upload = button2;
    }

    public static FragmentDebugImagePreviewBinding bind(View view) {
        int r0 = R.id.allow_alpha;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(R.id.allow_alpha, view);
        if (checkBox != null) {
            r0 = R.id.debug_image_import_file;
            Button button = (Button) ViewBindings.findChildViewById(R.id.debug_image_import_file, view);
            if (button != null) {
                r0 = R.id.debug_image_list;
                GridLayout gridLayout = (GridLayout) ViewBindings.findChildViewById(R.id.debug_image_list, view);
                if (gridLayout != null) {
                    r0 = R.id.debug_image_x;
                    EditText editText = (EditText) ViewBindings.findChildViewById(R.id.debug_image_x, view);
                    if (editText != null) {
                        r0 = R.id.debug_image_y;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(R.id.debug_image_y, view);
                        if (editText2 != null) {
                            r0 = R.id.formatType;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(R.id.formatType, view);
                            if (spinner != null) {
                                r0 = R.id.palette;
                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(R.id.palette, view);
                                if (spinner2 != null) {
                                    r0 = R.id.progress;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress, view);
                                    if (progressBar != null) {
                                        r0 = R.id.selectedImage;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.selectedImage, view);
                                        if (imageView != null) {
                                            r0 = R.id.upload;
                                            Button button2 = (Button) ViewBindings.findChildViewById(R.id.upload, view);
                                            if (button2 != null) {
                                                return new FragmentDebugImagePreviewBinding((ScrollView) view, checkBox, button, gridLayout, editText, editText2, spinner, spinner2, progressBar, imageView, button2);
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

    public static FragmentDebugImagePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugImagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_image_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}

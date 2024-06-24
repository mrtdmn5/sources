package com.animaconnected.secondo.screens.calibration;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class CalibrationAbortedDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String TAG = "CalibrationAbortedDialogFragment";

    /* loaded from: classes3.dex */
    public interface CalibrationAbortedDialogParent {
        void onCalibrationAbortedDialogCanceled();
    }

    private CalibrationAbortedDialogParent getCalibrationAbortedDialogParent() {
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment instanceof CalibrationAbortedDialogParent) {
            return (CalibrationAbortedDialogParent) parentFragment;
        }
        return null;
    }

    public static CalibrationAbortedDialogFragment newInstance() {
        return new CalibrationAbortedDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (getCalibrationAbortedDialogParent() != null) {
            getCalibrationAbortedDialogParent().onCalibrationAbortedDialogCanceled();
        } else {
            Log.w(TAG, "No compatible parent fragment...");
        }
        super.onCancel(dialogInterface);
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        return View.inflate(getContext(), R.layout.dialogfragment_calibration_aborted, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.flags |= 2;
        window.setAttributes(attributes);
    }
}

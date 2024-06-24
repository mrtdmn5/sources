package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowCompat$Api16Impl;
import androidx.core.view.WindowCompat$Api30Impl;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.animaconnected.watch.image.Kolors;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.kronaby.watch.app.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public MaterialShapeDrawable background;
    public MaterialCalendar<S> calendar;
    public CalendarConstraints calendarConstraints;
    public Button confirmButton;
    public DateSelector<S> dateSelector;
    public boolean edgeToEdgeEnabled;
    public boolean fullscreen;
    public TextView headerSelectionText;
    public CheckableImageButton headerToggleButton;
    public int inputMode;
    public CharSequence negativeButtonText;
    public int negativeButtonTextResId;
    public int overrideThemeResId;
    public PickerFragment<S> pickerFragment;
    public CharSequence positiveButtonText;
    public int positiveButtonTextResId;
    public CharSequence titleText;
    public int titleTextResId;
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();

    public static int getPaddedPickerWidth(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(UtcDates.getTodayCalendar());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int r1 = month.daysInWeek;
        return ((r1 - 1) * dimensionPixelOffset2) + (dimensionPixelSize * r1) + (dimensionPixelOffset * 2);
    }

    public static boolean isFullscreen(Context context) {
        return readMaterialCalendarStyleBoolean(context, android.R.attr.windowFullscreen);
    }

    public static boolean readMaterialCalendarStyleBoolean(Context context, int r3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()), new int[]{r3});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final DateSelector<S> getDateSelector() {
        if (this.dateSelector == null) {
            this.dateSelector = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.dateSelector;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.titleTextResId = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.titleText = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.inputMode = bundle.getInt("INPUT_MODE_KEY");
        this.positiveButtonTextResId = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.positiveButtonText = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.negativeButtonTextResId = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.negativeButtonText = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        requireContext();
        int r1 = this.overrideThemeResId;
        if (r1 == 0) {
            r1 = getDateSelector().getDefaultThemeResId();
        }
        Dialog dialog = new Dialog(requireContext, r1);
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(R.attr.colorSurface, context, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, 2132083803);
        this.background = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        this.background.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        MaterialShapeDrawable materialShapeDrawable2 = this.background;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        materialShapeDrawable2.setElevation(ViewCompat.Api21Impl.getElevation(decorView));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int r8;
        boolean z;
        if (this.fullscreen) {
            r8 = R.layout.mtrl_picker_fullscreen;
        } else {
            r8 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(r8, viewGroup);
        Context context = inflate.getContext();
        if (this.fullscreen) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api19Impl.setAccessibilityLiveRegion(textView, 1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.titleTextResId);
        }
        this.headerToggleButton.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.headerToggleButton;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.headerToggleButton;
        if (this.inputMode != 0) {
            z = true;
        } else {
            z = false;
        }
        checkableImageButton2.setChecked(z);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
                materialDatePicker.headerToggleButton.toggle();
                materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
                materialDatePicker.startPickerFragment();
            }
        });
        this.confirmButton = (Button) inflate.findViewById(R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence2 = this.positiveButtonText;
        if (charSequence2 != null) {
            this.confirmButton.setText(charSequence2);
        } else {
            int r7 = this.positiveButtonTextResId;
            if (r7 != 0) {
                this.confirmButton.setText(r7);
            }
        }
        this.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                Iterator<MaterialPickerOnPositiveButtonClickListener<? super S>> it = materialDatePicker.onPositiveButtonClickListeners.iterator();
                while (it.hasNext()) {
                    MaterialPickerOnPositiveButtonClickListener<? super S> next = it.next();
                    materialDatePicker.getDateSelector().getSelection();
                    next.onPositiveButtonClick();
                }
                materialDatePicker.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.negativeButtonText;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int r82 = this.negativeButtonTextResId;
            if (r82 != 0) {
                button.setText(r82);
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                Iterator<View.OnClickListener> it = materialDatePicker.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    it.next().onClick(view);
                }
                materialDatePicker.dismiss();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Month create;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        Month month = this.calendar.current;
        if (month != null) {
            builder.openAt = Long.valueOf(month.timeInMillis);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", builder.validator);
        Month create2 = Month.create(builder.start);
        Month create3 = Month.create(builder.end);
        CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = builder.openAt;
        if (l == null) {
            create = null;
        } else {
            create = Month.create(l.longValue());
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(create2, create3, dateValidator, create));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.positiveButtonTextResId);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.positiveButtonText);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.negativeButtonTextResId);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.negativeButtonText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        Integer num;
        boolean z;
        int r3;
        boolean z2;
        WindowInsetsControllerCompat$Impl windowInsetsControllerCompat$Impl23;
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
            if (!this.edgeToEdgeEnabled) {
                final View findViewById = requireView().findViewById(R.id.fullscreen_header);
                if (findViewById.getBackground() instanceof ColorDrawable) {
                    num = Integer.valueOf(((ColorDrawable) findViewById.getBackground()).getColor());
                } else {
                    num = null;
                }
                int r32 = Build.VERSION.SDK_INT;
                boolean z3 = false;
                if (num != null && num.intValue() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                int color = MaterialColors.getColor(window.getContext(), android.R.attr.colorBackground, Kolors.black);
                if (z) {
                    num = Integer.valueOf(color);
                }
                Integer valueOf = Integer.valueOf(color);
                if (r32 >= 30) {
                    WindowCompat$Api30Impl.setDecorFitsSystemWindows(window, false);
                } else {
                    WindowCompat$Api16Impl.setDecorFitsSystemWindows(window, false);
                }
                window.getContext();
                Context context = window.getContext();
                if (r32 < 27) {
                    r3 = ColorUtils.setAlphaComponent(MaterialColors.getColor(context, android.R.attr.navigationBarColor, Kolors.black), 128);
                } else {
                    r3 = 0;
                }
                window.setStatusBarColor(0);
                window.setNavigationBarColor(r3);
                boolean isColorLight = MaterialColors.isColorLight(num.intValue());
                if (!MaterialColors.isColorLight(0) && !isColorLight) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                boolean isColorLight2 = MaterialColors.isColorLight(valueOf.intValue());
                if (MaterialColors.isColorLight(r3) || (r3 == 0 && isColorLight2)) {
                    z3 = true;
                }
                SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(window.getDecorView());
                int r33 = Build.VERSION.SDK_INT;
                if (r33 >= 30) {
                    windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl30(window, softwareKeyboardControllerCompat);
                } else if (r33 >= 26) {
                    windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl26(window, softwareKeyboardControllerCompat);
                } else {
                    windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl23(window, softwareKeyboardControllerCompat);
                }
                windowInsetsControllerCompat$Impl23.setAppearanceLightStatusBars(z2);
                windowInsetsControllerCompat$Impl23.setAppearanceLightNavigationBars(z3);
                final int paddingTop = findViewById.getPaddingTop();
                final int r2 = findViewById.getLayoutParams().height;
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int r5 = windowInsetsCompat.getInsets(7).top;
                        View view2 = findViewById;
                        int r1 = r2;
                        if (r1 >= 0) {
                            view2.getLayoutParams().height = r1 + r5;
                            view2.setLayoutParams(view2.getLayoutParams());
                        }
                        view2.setPadding(view2.getPaddingLeft(), paddingTop + r5, view2.getPaddingRight(), view2.getPaddingBottom());
                        return windowInsetsCompat;
                    }
                };
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, onApplyWindowInsetsListener);
                this.edgeToEdgeEnabled = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.pickerFragment.onSelectionChangedListeners.clear();
        super.onStop();
    }

    public final void startPickerFragment() {
        PickerFragment<S> pickerFragment;
        requireContext();
        int r0 = this.overrideThemeResId;
        if (r0 == 0) {
            r0 = getDateSelector().getDefaultThemeResId();
        }
        DateSelector<S> dateSelector = getDateSelector();
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        MaterialCalendar<S> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", r0);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.openAt);
        materialCalendar.setArguments(bundle);
        this.calendar = materialCalendar;
        if (this.headerToggleButton.isChecked()) {
            DateSelector<S> dateSelector2 = getDateSelector();
            CalendarConstraints calendarConstraints2 = this.calendarConstraints;
            pickerFragment = new MaterialTextInputPicker<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", r0);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            pickerFragment.setArguments(bundle2);
        } else {
            pickerFragment = this.calendar;
        }
        this.pickerFragment = pickerFragment;
        updateHeader();
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(childFragmentManager);
        backStackRecord.replace(R.id.mtrl_calendar_frame, this.pickerFragment, null);
        if (!backStackRecord.mAddToBackStack) {
            backStackRecord.mAllowAddToBackStack = false;
            backStackRecord.mManager.execSingleAction(backStackRecord, false);
            this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
                @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                public final void onSelectionChanged(S s) {
                    int r2 = MaterialDatePicker.$r8$clinit;
                    MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                    materialDatePicker.updateHeader();
                    materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
                }
            });
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final void updateHeader() {
        DateSelector<S> dateSelector = getDateSelector();
        getContext();
        String selectionDisplayString = dateSelector.getSelectionDisplayString();
        this.headerSelectionText.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), selectionDisplayString));
        this.headerSelectionText.setText(selectionDisplayString);
    }

    public final void updateToggleContentDescription(CheckableImageButton checkableImageButton) {
        String string;
        if (this.headerToggleButton.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(string);
    }
}

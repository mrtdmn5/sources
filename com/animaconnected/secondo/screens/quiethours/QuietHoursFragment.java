package com.animaconnected.secondo.screens.quiethours;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.FeedbackView$$ExternalSyntheticLambda1;
import com.animaconnected.secondo.screens.notification.alarm.widget.TextTime;
import com.animaconnected.secondo.screens.pickerdialog.TimePickerShower;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import com.kronaby.watch.app.R;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuietHoursFragment.kt */
/* loaded from: classes3.dex */
public final class QuietHoursFragment extends BaseFragment {
    private static final String BACK_DRAWABLE_RES_ID = "backDrawable";
    private static final String BUNDLE_KEY_PATH = "keyPath";
    private static final float DISABLED_ALPHA = 0.5f;
    private int backDrawableResId;
    private View endContainer;
    private TextTime endTextTime;
    private String pathName;
    private View startContainer;
    private TextTime startTextTime;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final QuietHoursProvider quietHoursProvider = ProviderFactory.INSTANCE.getQuietHoursProvider();
    private final Locale locale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
    private final boolean hasDisplay = ProviderFactory.getWatch().getWatch().getCommandCenter().hasDisplay();

    /* compiled from: QuietHoursFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuietHoursFragment newInstance(String pathName, int r5) {
            Intrinsics.checkNotNullParameter(pathName, "pathName");
            QuietHoursFragment quietHoursFragment = new QuietHoursFragment();
            Bundle bundle = new Bundle();
            bundle.putString(QuietHoursFragment.BUNDLE_KEY_PATH, pathName);
            bundle.putInt(QuietHoursFragment.BACK_DRAWABLE_RES_ID, r5);
            quietHoursFragment.setArguments(bundle);
            return quietHoursFragment;
        }

        private Companion() {
        }
    }

    public static final QuietHoursFragment newInstance(String str, int r2) {
        return Companion.newInstance(str, r2);
    }

    public static final void onCreateView$lambda$0(QuietHoursFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.quietHoursProvider.setEnabled(z);
        this$0.updateTextTimeViews();
    }

    public static final void onCreateView$lambda$1(final QuietHoursFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showTimePickerIfEnabled(this$0.quietHoursProvider.getStartHour(), this$0.quietHoursProvider.getStartMinutes(), new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.quiethours.QuietHoursFragment$onCreateView$2$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r2, int r3) {
                QuietHoursProvider quietHoursProvider;
                quietHoursProvider = QuietHoursFragment.this.quietHoursProvider;
                quietHoursProvider.setStartTime(r2, r3);
                QuietHoursFragment.this.updateTextTimeViews();
            }
        });
    }

    public static final void onCreateView$lambda$2(final QuietHoursFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showTimePickerIfEnabled(this$0.quietHoursProvider.getEndHour(), this$0.quietHoursProvider.getEndMinutes(), new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.quiethours.QuietHoursFragment$onCreateView$3$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r2, int r3) {
                QuietHoursProvider quietHoursProvider;
                quietHoursProvider = QuietHoursFragment.this.quietHoursProvider;
                quietHoursProvider.setEndTime(r2, r3);
                QuietHoursFragment.this.updateTextTimeViews();
            }
        });
    }

    private final void showTimePickerIfEnabled(int r2, int r3, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (this.quietHoursProvider.isEnabled()) {
            TimePickerShower.showTimeEditDialog(this, r2, r3, function2);
        }
    }

    public final void updateTextTimeViews() {
        float f;
        if (this.quietHoursProvider.isEnabled()) {
            f = 1.0f;
        } else {
            f = DISABLED_ALPHA;
        }
        View view = this.startContainer;
        if (view != null) {
            view.setAlpha(f);
            View view2 = this.endContainer;
            if (view2 != null) {
                view2.setAlpha(f);
                TextTime textTime = this.startTextTime;
                if (textTime != null) {
                    textTime.setTime(this.quietHoursProvider.getStartHour(), this.quietHoursProvider.getStartMinutes());
                    TextTime textTime2 = this.endTextTime;
                    if (textTime2 != null) {
                        textTime2.setTime(this.quietHoursProvider.getEndHour(), this.quietHoursProvider.getEndMinutes());
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("endTextTime");
                        throw null;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("startTextTime");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("endContainer");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String str = this.pathName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pathName");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "quiethours";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        if (context != null) {
            int r1 = this.backDrawableResId;
            Object obj = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context, r1);
        }
        return null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments(...)");
        String string = requireArguments.getString(BUNDLE_KEY_PATH);
        Intrinsics.checkNotNull(string);
        this.pathName = string;
        this.backDrawableResId = requireArguments.getInt(BACK_DRAWABLE_RES_ID);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_quiet_hours, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        if (ProviderFactory.getWatch().getWatch().getCommandCenter().hasDisplay()) {
            Context requireContext = requireContext();
            Object obj = ContextCompat.sLock;
            inflate.setBackgroundColor(ContextCompat.Api23Impl.getColor(requireContext, R.color.transparent));
        }
        View findViewById = inflate.findViewById(R.id.quiet_hours_switch);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        SwitchCompat switchCompat = (SwitchCompat) findViewById;
        switchCompat.setChecked(this.quietHoursProvider.isEnabled());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.quiethours.QuietHoursFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                QuietHoursFragment.onCreateView$lambda$0(QuietHoursFragment.this, compoundButton, z);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.quiet_hours_start_time_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.startContainer = findViewById2;
        findViewById2.setOnClickListener(new FeedbackView$$ExternalSyntheticLambda1(1, this));
        View findViewById3 = inflate.findViewById(R.id.quiet_hours_end_time_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.endContainer = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.quiethours.QuietHoursFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuietHoursFragment.onCreateView$lambda$2(QuietHoursFragment.this, view);
            }
        });
        boolean is24HourFormat = DateFormat.is24HourFormat(getContext());
        View findViewById4 = inflate.findViewById(R.id.quiet_hours_start_time);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        TextTime textTime = (TextTime) findViewById4;
        this.startTextTime = textTime;
        textTime.setFormatOpts(this.locale, is24HourFormat);
        View findViewById5 = inflate.findViewById(R.id.quiet_hours_end_time);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        TextTime textTime2 = (TextTime) findViewById5;
        this.endTextTime = textTime2;
        textTime2.setFormatOpts(this.locale, is24HourFormat);
        if (this.hasDisplay) {
            ((TextView) inflate.findViewById(R.id.description)).setText(R.string.quiet_hours_description_display_watch);
        }
        updateTextTimeViews();
        return inflate;
    }
}

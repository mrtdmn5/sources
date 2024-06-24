package com.animaconnected.secondo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SectionLayout.kt */
/* loaded from: classes3.dex */
public final class SectionLayout extends LinearLayout {
    public static final int $stable = 8;
    private View bottomLine;
    private ImageView chevron;
    private TextView description;
    private int descriptionStyle;
    private final float disabledAlpha;
    private ImageView icon;
    private ProgressBar progressbar;

    /* renamed from: switch, reason: not valid java name */
    private SwitchCompat f106switch;
    private TextView title;
    private View topLine;
    private LinearLayout touchView;
    private int warningStyle;

    /* compiled from: SectionLayout.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LayoutState.values().length];
            try {
                r0[LayoutState.Enabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LayoutState.WarningEnabled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[LayoutState.Disabled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[LayoutState.WarningDisabled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[LayoutState.DisabledButtonEnabled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public SectionLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Integer getResourceIdOrNull(TypedArray typedArray, int r3) {
        int resourceId = typedArray.getResourceId(r3, -1);
        if (resourceId == -1) {
            return null;
        }
        return Integer.valueOf(resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnCheckedChangeListener$lambda$5(Function1 function1, SectionLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this$0.f106switch.isChecked()));
        }
    }

    public final void setChecked(boolean z) {
        this.f106switch.setChecked(z);
    }

    public final void setDescriptionText(String str) {
        boolean z;
        TextView textView = this.description;
        int r1 = 0;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            r1 = 8;
        }
        textView.setVisibility(r1);
        this.description.setText(str);
    }

    public final void setIconBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.icon.setImageBitmap(bitmap);
    }

    public final void setLayoutState(LayoutState state) {
        int r9;
        boolean z;
        boolean z2;
        int r0;
        Intrinsics.checkNotNullParameter(state, "state");
        int r02 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        float f = 1.0f;
        boolean z3 = true;
        if (r02 != 1 && r02 != 2) {
            if (r02 == 3 || r02 == 4 || r02 == 5) {
                if (state == LayoutState.DisabledButtonEnabled) {
                    z = true;
                } else {
                    z = false;
                }
                if (state == LayoutState.WarningDisabled) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.title.setEnabled(false);
                TextView textView = this.description;
                if (state == LayoutState.Disabled) {
                    z3 = false;
                }
                textView.setEnabled(z3);
                this.f106switch.setEnabled(false);
                this.touchView.setEnabled(z);
                Drawable drawable = this.title.getCompoundDrawables()[0];
                if (drawable != null) {
                    drawable.setAlpha((int) (this.disabledAlpha * 255));
                }
                this.icon.setAlpha(this.disabledAlpha);
                this.f106switch.setAlpha(this.disabledAlpha);
                ImageView imageView = this.chevron;
                if (!z) {
                    f = this.disabledAlpha;
                }
                imageView.setAlpha(f);
                TextView textView2 = this.description;
                if (z2) {
                    r0 = this.warningStyle;
                } else {
                    r0 = this.descriptionStyle;
                }
                textView2.setTextAppearance(r0);
                return;
            }
            return;
        }
        this.title.setEnabled(true);
        this.description.setEnabled(true);
        this.touchView.setEnabled(true);
        this.f106switch.setEnabled(true);
        this.f106switch.setAlpha(1.0f);
        Drawable drawable2 = this.title.getCompoundDrawables()[0];
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        this.icon.setAlpha(1.0f);
        this.chevron.setAlpha(1.0f);
        TextView textView3 = this.description;
        if (state == LayoutState.WarningEnabled) {
            r9 = this.warningStyle;
        } else {
            r9 = this.descriptionStyle;
        }
        textView3.setTextAppearance(r9);
    }

    public final void setOnCheckedChangeListener(final Function1<? super Boolean, Unit> function1) {
        this.f106switch.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.widget.SectionLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SectionLayout.setOnCheckedChangeListener$lambda$5(Function1.this, this, view);
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.touchView.setOnClickListener(onClickListener);
    }

    public final void setTitleIcon(Integer num) {
        int r3;
        TextView textView = this.title;
        if (num != null) {
            r3 = num.intValue();
        } else {
            r3 = 0;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(r3, 0, 0, 0);
        Drawable drawable = this.title.getCompoundDrawables()[0];
        if (drawable != null) {
            drawable.mutate();
        }
    }

    public final void setTitleText(String str) {
        this.title.setText(str);
    }

    public final void setTopAndBottomPadding(int r4, int r5) {
        LinearLayout linearLayout = this.touchView;
        linearLayout.setPadding(linearLayout.getPaddingLeft(), r4, this.touchView.getPaddingRight(), r5);
    }

    public final void showBottomLine(boolean z) {
        int r2;
        View view = this.bottomLine;
        if (z) {
            r2 = 0;
        } else {
            r2 = 8;
        }
        view.setVisibility(r2);
    }

    public final void showProgressBar(boolean z) {
        int r2;
        ProgressBar progressBar = this.progressbar;
        int r1 = 0;
        if (z) {
            r2 = 0;
        } else {
            r2 = 8;
        }
        progressBar.setVisibility(r2);
        ImageView imageView = this.chevron;
        if (z) {
            r1 = 4;
        }
        imageView.setVisibility(r1);
    }

    public final void showTopLine(boolean z) {
        int r2;
        View view = this.topLine;
        if (z) {
            r2 = 0;
        } else {
            r2 = 8;
        }
        view.setVisibility(r2);
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public SectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SectionLayout(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SectionLayout(Context context, AttributeSet attributeSet, int r8) {
        super(context, attributeSet, r8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.disabledAlpha = 0.3f;
        View.inflate(context, R.layout.widget_section_layout, this);
        View findViewById = findViewById(R.id.section_layout_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.title = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.section_layout_description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.description = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.section_layout_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.icon = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.section_layout_chevron);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.chevron = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.section_layout_switch);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.f106switch = (SwitchCompat) findViewById5;
        View findViewById6 = findViewById(R.id.section_layout_progressbar);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.progressbar = (ProgressBar) findViewById6;
        View findViewById7 = findViewById(R.id.section_layout_touch_area);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.touchView = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.section_layout_top_line);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.topLine = findViewById8;
        View findViewById9 = findViewById(R.id.section_layout_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.bottomLine = findViewById9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.animaconnected.secondo.R.styleable.SectionLayout, r8, r8);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        Integer resourceIdOrNull = getResourceIdOrNull(obtainStyledAttributes, 14);
        if (resourceIdOrNull != null) {
            int intValue = resourceIdOrNull.intValue();
            this.topLine.setBackgroundResource(intValue);
            this.bottomLine.setBackgroundResource(intValue);
        }
        this.warningStyle = obtainStyledAttributes.getResourceId(3, -1);
        this.descriptionStyle = obtainStyledAttributes.getResourceId(1, -1);
        this.title.setTextAppearance(obtainStyledAttributes.getResourceId(12, -1));
        setTitleText(obtainStyledAttributes.getString(13));
        setTitleIcon(Integer.valueOf(obtainStyledAttributes.getResourceId(11, 0)));
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(15, 8);
        setTopAndBottomPadding(dimensionPixelOffset, dimensionPixelOffset);
        if (obtainStyledAttributes.getBoolean(17, false)) {
            this.chevron.setVisibility(8);
            this.f106switch.setVisibility(0);
        }
        setDescriptionText(obtainStyledAttributes.getString(2));
        this.icon.setImageDrawable(obtainStyledAttributes.getDrawable(4));
        Integer resourceIdOrNull2 = getResourceIdOrNull(obtainStyledAttributes, 5);
        if (resourceIdOrNull2 != null) {
            int intValue2 = resourceIdOrNull2.intValue();
            ImageView imageView = this.icon;
            Object obj = ContextCompat.sLock;
            imageView.setColorFilter(ContextCompat.Api23Impl.getColor(context, intValue2), PorterDuff.Mode.SRC_IN);
        }
        Integer resourceIdOrNull3 = getResourceIdOrNull(obtainStyledAttributes, 0);
        if (resourceIdOrNull3 != null) {
            int intValue3 = resourceIdOrNull3.intValue();
            ImageView imageView2 = this.chevron;
            Object obj2 = ContextCompat.sLock;
            imageView2.setColorFilter(ContextCompat.Api23Impl.getColor(context, intValue3), PorterDuff.Mode.SRC_IN);
        }
        Integer resourceIdOrNull4 = getResourceIdOrNull(obtainStyledAttributes, 9);
        if (resourceIdOrNull4 != null) {
            this.f106switch.setThumbResource(resourceIdOrNull4.intValue());
        }
        Integer resourceIdOrNull5 = getResourceIdOrNull(obtainStyledAttributes, 10);
        if (resourceIdOrNull5 != null) {
            this.f106switch.setTrackResource(resourceIdOrNull5.intValue());
        }
        this.icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.touchView.setBackground(obtainStyledAttributes.getDrawable(16));
        this.topLine.setVisibility(obtainStyledAttributes.getBoolean(8, true) ? 0 : 8);
        this.bottomLine.setVisibility(obtainStyledAttributes.getBoolean(7, true) ? 0 : 8);
        setLayoutState((LayoutState) LayoutState.getEntries().get(obtainStyledAttributes.getInt(6, 0)));
        obtainStyledAttributes.recycle();
    }
}

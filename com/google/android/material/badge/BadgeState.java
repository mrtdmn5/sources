package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.kronaby.watch.app.R;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public final class BadgeState {
    public final float badgeRadius;
    public final float badgeWidePadding;
    public final float badgeWithTextRadius;
    public final State currentState = new State();
    public final State overridingState;

    public BadgeState(Context context) {
        AttributeSet attributeSet;
        int r3;
        int r6;
        boolean z;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int next;
        State state = new State();
        int r2 = state.badgeResId;
        if (r2 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(r2);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    if (TextUtils.equals(xml.getName(), DetailBottomDialog.keyBadge)) {
                        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                        r3 = asAttributeSet.getStyleAttribute();
                        attributeSet = asAttributeSet;
                    } else {
                        throw new XmlPullParserException("Must have a <" + ((Object) DetailBottomDialog.keyBadge) + "> start tag");
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r2));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            r3 = 0;
        }
        if (r3 == 0) {
            r6 = 2132083761;
        } else {
            r6 = r3;
        }
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.Badge, R.attr.badgeStyle, r6, new int[0]);
        Resources resources = context.getResources();
        this.badgeRadius = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
        this.badgeWidePadding = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.badgeWithTextRadius = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
        State state2 = this.currentState;
        int r62 = state.alpha;
        state2.alpha = r62 == -2 ? 255 : r62;
        CharSequence charSequence = state.contentDescriptionNumberless;
        state2.contentDescriptionNumberless = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        State state3 = this.currentState;
        int r63 = state.contentDescriptionQuantityStrings;
        state3.contentDescriptionQuantityStrings = r63 == 0 ? R.plurals.mtrl_badge_content_description : r63;
        int r64 = state.contentDescriptionExceedsMaxBadgeNumberRes;
        state3.contentDescriptionExceedsMaxBadgeNumberRes = r64 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : r64;
        Boolean bool = state.isVisible;
        if (bool != null && !bool.booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        state3.isVisible = Boolean.valueOf(z);
        State state4 = this.currentState;
        int r65 = state.maxCharacterCount;
        state4.maxCharacterCount = r65 == -2 ? obtainStyledAttributes.getInt(8, 4) : r65;
        int r32 = state.number;
        if (r32 != -2) {
            this.currentState.number = r32;
        } else if (obtainStyledAttributes.hasValue(9)) {
            this.currentState.number = obtainStyledAttributes.getInt(9, 0);
        } else {
            this.currentState.number = -1;
        }
        State state5 = this.currentState;
        Integer num = state.backgroundColor;
        if (num == null) {
            intValue = MaterialResources.getColorStateList(context, obtainStyledAttributes, 0).getDefaultColor();
        } else {
            intValue = num.intValue();
        }
        state5.backgroundColor = Integer.valueOf(intValue);
        Integer num2 = state.badgeTextColor;
        if (num2 != null) {
            this.currentState.badgeTextColor = num2;
        } else if (obtainStyledAttributes.hasValue(3)) {
            this.currentState.badgeTextColor = Integer.valueOf(MaterialResources.getColorStateList(context, obtainStyledAttributes, 3).getDefaultColor());
        } else {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(2132083286, R$styleable.TextAppearance);
            obtainStyledAttributes2.getDimension(0, 0.0f);
            ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes2, 3);
            MaterialResources.getColorStateList(context, obtainStyledAttributes2, 4);
            MaterialResources.getColorStateList(context, obtainStyledAttributes2, 5);
            obtainStyledAttributes2.getInt(2, 0);
            obtainStyledAttributes2.getInt(1, 1);
            int r4 = obtainStyledAttributes2.hasValue(12) ? 12 : 10;
            obtainStyledAttributes2.getResourceId(r4, 0);
            obtainStyledAttributes2.getString(r4);
            obtainStyledAttributes2.getBoolean(14, false);
            MaterialResources.getColorStateList(context, obtainStyledAttributes2, 6);
            obtainStyledAttributes2.getFloat(7, 0.0f);
            obtainStyledAttributes2.getFloat(8, 0.0f);
            obtainStyledAttributes2.getFloat(9, 0.0f);
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(2132083286, R$styleable.MaterialTextAppearance);
            obtainStyledAttributes3.hasValue(0);
            obtainStyledAttributes3.getFloat(0, 0.0f);
            obtainStyledAttributes3.recycle();
            this.currentState.badgeTextColor = Integer.valueOf(colorStateList.getDefaultColor());
        }
        State state6 = this.currentState;
        Integer num3 = state.badgeGravity;
        if (num3 == null) {
            intValue2 = obtainStyledAttributes.getInt(1, 8388661);
        } else {
            intValue2 = num3.intValue();
        }
        state6.badgeGravity = Integer.valueOf(intValue2);
        State state7 = this.currentState;
        Integer num4 = state.horizontalOffsetWithoutText;
        if (num4 == null) {
            intValue3 = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
        } else {
            intValue3 = num4.intValue();
        }
        state7.horizontalOffsetWithoutText = Integer.valueOf(intValue3);
        State state8 = this.currentState;
        if (state.horizontalOffsetWithoutText == null) {
            intValue4 = obtainStyledAttributes.getDimensionPixelOffset(10, 0);
        } else {
            intValue4 = state.verticalOffsetWithoutText.intValue();
        }
        state8.verticalOffsetWithoutText = Integer.valueOf(intValue4);
        State state9 = this.currentState;
        Integer num5 = state.horizontalOffsetWithText;
        if (num5 == null) {
            intValue5 = obtainStyledAttributes.getDimensionPixelOffset(7, state9.horizontalOffsetWithoutText.intValue());
        } else {
            intValue5 = num5.intValue();
        }
        state9.horizontalOffsetWithText = Integer.valueOf(intValue5);
        State state10 = this.currentState;
        Integer num6 = state.verticalOffsetWithText;
        if (num6 == null) {
            intValue6 = obtainStyledAttributes.getDimensionPixelOffset(11, state10.verticalOffsetWithoutText.intValue());
        } else {
            intValue6 = num6.intValue();
        }
        state10.verticalOffsetWithText = Integer.valueOf(intValue6);
        State state11 = this.currentState;
        Integer num7 = state.additionalHorizontalOffset;
        if (num7 == null) {
            intValue7 = 0;
        } else {
            intValue7 = num7.intValue();
        }
        state11.additionalHorizontalOffset = Integer.valueOf(intValue7);
        State state12 = this.currentState;
        Integer num8 = state.additionalVerticalOffset;
        state12.additionalVerticalOffset = Integer.valueOf(num8 != null ? num8.intValue() : 0);
        obtainStyledAttributes.recycle();
        Locale locale = state.numberLocale;
        if (locale == null) {
            this.currentState.numberLocale = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.currentState.numberLocale = locale;
        }
        this.overridingState = state;
    }

    /* loaded from: classes3.dex */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new AnonymousClass1();
        public Integer additionalHorizontalOffset;
        public Integer additionalVerticalOffset;
        public int alpha;
        public Integer backgroundColor;
        public Integer badgeGravity;
        public int badgeResId;
        public Integer badgeTextColor;
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        public CharSequence contentDescriptionNumberless;
        public int contentDescriptionQuantityStrings;
        public Integer horizontalOffsetWithText;
        public Integer horizontalOffsetWithoutText;
        public Boolean isVisible;
        public int maxCharacterCount;
        public int number;
        public Locale numberLocale;
        public Integer verticalOffsetWithText;
        public Integer verticalOffsetWithoutText;

        /* renamed from: com.google.android.material.badge.BadgeState$State$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            public final State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final State[] newArray(int r1) {
                return new State[r1];
            }
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            String charSequence;
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            CharSequence charSequence2 = this.contentDescriptionNumberless;
            if (charSequence2 == null) {
                charSequence = null;
            } else {
                charSequence = charSequence2.toString();
            }
            parcel.writeString(charSequence);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
        }

        public State(Parcel parcel) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = Boolean.TRUE;
            this.badgeResId = parcel.readInt();
            this.backgroundColor = (Integer) parcel.readSerializable();
            this.badgeTextColor = (Integer) parcel.readSerializable();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithText = (Integer) parcel.readSerializable();
            this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
            this.additionalVerticalOffset = (Integer) parcel.readSerializable();
            this.isVisible = (Boolean) parcel.readSerializable();
            this.numberLocale = (Locale) parcel.readSerializable();
        }
    }
}

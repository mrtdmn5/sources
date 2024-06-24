package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.common.hash.AbstractHasher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {
    public CharSequence accessibilityClassName;
    public ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public boolean ensureMinTouchTargetSize;
    public final AnonymousClass1 fontCallback;
    public InsetDrawable insetBackgroundDrawable;
    public int lastLayoutDirection;
    public int minTouchTargetSize;
    public MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListenerInternal;
    public View.OnClickListener onCloseIconClickListener;
    public final Rect rect;
    public final RectF rectF;
    public RippleDrawable ripple;
    public final ChipTouchHelper touchHelper;
    public boolean touchHelperEnabled;
    public static final Rect EMPTY_BOUNDS = new Rect();
    public static final int[] SELECTED_STATE = {R.attr.state_selected};
    public static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};

    /* loaded from: classes3.dex */
    public class ChipTouchHelper extends ExploreByTouchHelper {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void getVisibleVirtualViews(ArrayList arrayList) {
            boolean z = false;
            arrayList.add(0);
            Rect rect = Chip.EMPTY_BOUNDS;
            Chip chip = Chip.this;
            if (chip.hasCloseIcon()) {
                ChipDrawable chipDrawable = chip.chipDrawable;
                if (chipDrawable != null && chipDrawable.closeIconVisible) {
                    z = true;
                }
                if (z && chip.onCloseIconClickListener != null) {
                    arrayList.add(1);
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void onPopulateNodeForVirtualView(int r7, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            CharSequence charSequence = "";
            if (r7 == 1) {
                Chip chip = Chip.this;
                CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = chip.getText();
                    Context context = chip.getContext();
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    accessibilityNodeInfo.setContentDescription(context.getString(com.kronaby.watch.app.R.string.mtrl_chip_close_icon_content_description, objArr).trim());
                }
                accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfo.setEnabled(chip.isEnabled());
                return;
            }
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.material.chip.Chip$1] */
    public Chip(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.kronaby.watch.app.R.attr.chipStyle, 2132083784), attributeSet, com.kronaby.watch.app.R.attr.chipStyle);
        TextAppearance textAppearance;
        MotionSpec motionSpec;
        int resourceId;
        int resourceId2;
        int resourceId3;
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AbstractHasher() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.common.hash.AbstractHasher
            public final void onFontRetrieved(Typeface typeface, boolean z) {
                CharSequence text;
                Chip chip = Chip.this;
                ChipDrawable chipDrawable = chip.chipDrawable;
                if (chipDrawable.shouldDrawText) {
                    text = chipDrawable.text;
                } else {
                    text = chip.getText();
                }
                chip.setText(text);
                chip.requestLayout();
                chip.invalidate();
            }

            @Override // com.google.common.hash.AbstractHasher
            public final void onFontRetrievalFailed(int r1) {
            }
        };
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                            if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                                if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                    Log.w("Chip", "Chip text must be vertically center and start aligned");
                                }
                            } else {
                                throw new UnsupportedOperationException("Chip does not support multi-line text");
                            }
                        } else {
                            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                        }
                    } else {
                        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                    }
                } else {
                    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
                }
            } else {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
        }
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet);
        Context context3 = chipDrawable.context;
        int[] r12 = R$styleable.Chip;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context3, attributeSet, r12, com.kronaby.watch.app.R.attr.chipStyle, 2132083784, new int[0]);
        chipDrawable.isShapeThemingEnabled = obtainStyledAttributes.hasValue(37);
        Context context4 = chipDrawable.context;
        ColorStateList colorStateList = MaterialResources.getColorStateList(context4, obtainStyledAttributes, 24);
        if (chipDrawable.chipSurfaceColor != colorStateList) {
            chipDrawable.chipSurfaceColor = colorStateList;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context4, obtainStyledAttributes, 11);
        if (chipDrawable.chipBackgroundColor != colorStateList2) {
            chipDrawable.chipBackgroundColor = colorStateList2;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        float dimension = obtainStyledAttributes.getDimension(19, 0.0f);
        if (chipDrawable.chipMinHeight != dimension) {
            chipDrawable.chipMinHeight = dimension;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        if (obtainStyledAttributes.hasValue(12)) {
            chipDrawable.setChipCornerRadius(obtainStyledAttributes.getDimension(12, 0.0f));
        }
        chipDrawable.setChipStrokeColor(MaterialResources.getColorStateList(context4, obtainStyledAttributes, 22));
        chipDrawable.setChipStrokeWidth(obtainStyledAttributes.getDimension(23, 0.0f));
        chipDrawable.setRippleColor(MaterialResources.getColorStateList(context4, obtainStyledAttributes, 36));
        String text = obtainStyledAttributes.getText(5);
        text = text == null ? "" : text;
        boolean equals = TextUtils.equals(chipDrawable.text, text);
        TextDrawableHelper textDrawableHelper = chipDrawable.textDrawableHelper;
        if (!equals) {
            chipDrawable.text = text;
            textDrawableHelper.textWidthDirty = true;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        MotionSpec motionSpec2 = null;
        if (obtainStyledAttributes.hasValue(0) && (resourceId3 = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            textAppearance = new TextAppearance(context4, resourceId3);
        } else {
            textAppearance = null;
        }
        textAppearance.textSize = obtainStyledAttributes.getDimension(1, textAppearance.textSize);
        textDrawableHelper.setTextAppearance(textAppearance, context4);
        int r6 = obtainStyledAttributes.getInt(3, 0);
        if (r6 != 1) {
            if (r6 != 2) {
                if (r6 == 3) {
                    chipDrawable.truncateAt = TextUtils.TruncateAt.END;
                }
            } else {
                chipDrawable.truncateAt = TextUtils.TruncateAt.MIDDLE;
            }
        } else {
            chipDrawable.truncateAt = TextUtils.TruncateAt.START;
        }
        chipDrawable.setChipIconVisible(obtainStyledAttributes.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            chipDrawable.setChipIconVisible(obtainStyledAttributes.getBoolean(15, false));
        }
        chipDrawable.setChipIcon(MaterialResources.getDrawable(context4, obtainStyledAttributes, 14));
        if (obtainStyledAttributes.hasValue(17)) {
            chipDrawable.setChipIconTint(MaterialResources.getColorStateList(context4, obtainStyledAttributes, 17));
        }
        chipDrawable.setChipIconSize(obtainStyledAttributes.getDimension(16, -1.0f));
        chipDrawable.setCloseIconVisible(obtainStyledAttributes.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            chipDrawable.setCloseIconVisible(obtainStyledAttributes.getBoolean(26, false));
        }
        chipDrawable.setCloseIcon(MaterialResources.getDrawable(context4, obtainStyledAttributes, 25));
        chipDrawable.setCloseIconTint(MaterialResources.getColorStateList(context4, obtainStyledAttributes, 30));
        chipDrawable.setCloseIconSize(obtainStyledAttributes.getDimension(28, 0.0f));
        chipDrawable.setCheckable(obtainStyledAttributes.getBoolean(6, false));
        chipDrawable.setCheckedIconVisible(obtainStyledAttributes.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            chipDrawable.setCheckedIconVisible(obtainStyledAttributes.getBoolean(8, false));
        }
        chipDrawable.setCheckedIcon(MaterialResources.getDrawable(context4, obtainStyledAttributes, 7));
        if (obtainStyledAttributes.hasValue(9)) {
            chipDrawable.setCheckedIconTint(MaterialResources.getColorStateList(context4, obtainStyledAttributes, 9));
        }
        if (obtainStyledAttributes.hasValue(39) && (resourceId2 = obtainStyledAttributes.getResourceId(39, 0)) != 0) {
            motionSpec = MotionSpec.createFromResource(context4, resourceId2);
        } else {
            motionSpec = null;
        }
        chipDrawable.showMotionSpec = motionSpec;
        if (obtainStyledAttributes.hasValue(33) && (resourceId = obtainStyledAttributes.getResourceId(33, 0)) != 0) {
            motionSpec2 = MotionSpec.createFromResource(context4, resourceId);
        }
        chipDrawable.hideMotionSpec = motionSpec2;
        float dimension2 = obtainStyledAttributes.getDimension(21, 0.0f);
        if (chipDrawable.chipStartPadding != dimension2) {
            chipDrawable.chipStartPadding = dimension2;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        chipDrawable.setIconStartPadding(obtainStyledAttributes.getDimension(35, 0.0f));
        chipDrawable.setIconEndPadding(obtainStyledAttributes.getDimension(34, 0.0f));
        float dimension3 = obtainStyledAttributes.getDimension(41, 0.0f);
        if (chipDrawable.textStartPadding != dimension3) {
            chipDrawable.textStartPadding = dimension3;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        float dimension4 = obtainStyledAttributes.getDimension(40, 0.0f);
        if (chipDrawable.textEndPadding != dimension4) {
            chipDrawable.textEndPadding = dimension4;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        chipDrawable.setCloseIconStartPadding(obtainStyledAttributes.getDimension(29, 0.0f));
        chipDrawable.setCloseIconEndPadding(obtainStyledAttributes.getDimension(27, 0.0f));
        float dimension5 = obtainStyledAttributes.getDimension(13, 0.0f);
        if (chipDrawable.chipEndPadding != dimension5) {
            chipDrawable.chipEndPadding = dimension5;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        chipDrawable.maxWidth = obtainStyledAttributes.getDimensionPixelSize(4, Integer.MAX_VALUE);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, r12, com.kronaby.watch.app.R.attr.chipStyle, 2132083784, new int[0]);
        this.ensureMinTouchTargetSize = obtainStyledAttributes2.getBoolean(32, false);
        this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes2.getDimension(20, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        obtainStyledAttributes2.recycle();
        setChipDrawable(chipDrawable);
        chipDrawable.setElevation(ViewCompat.Api21Impl.getElevation(this));
        TypedArray obtainStyledAttributes3 = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, r12, com.kronaby.watch.app.R.attr.chipStyle, 2132083784, new int[0]);
        boolean hasValue = obtainStyledAttributes3.hasValue(37);
        obtainStyledAttributes3.recycle();
        this.touchHelper = new ChipTouchHelper(this);
        updateAccessibilityDelegate();
        if (!hasValue) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public final void getOutline(View view, Outline outline) {
                    ChipDrawable chipDrawable2 = Chip.this.chipDrawable;
                    if (chipDrawable2 != null) {
                        chipDrawable2.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.deferredCheckedValue);
        setText(chipDrawable.text);
        setEllipsize(chipDrawable.truncateAt);
        updateTextPaintDrawState();
        if (!this.chipDrawable.shouldDrawText) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        updatePaddingInternal();
        if (this.ensureMinTouchTargetSize) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = ViewCompat.Api17Impl.getLayoutDirection(this);
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.rectF;
        rectF.setEmpty();
        if (hasCloseIcon() && this.onCloseIconClickListener != null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            Rect bounds = chipDrawable.getBounds();
            rectF.setEmpty();
            if (chipDrawable.showsCloseIcon()) {
                float f = chipDrawable.chipEndPadding + chipDrawable.closeIconEndPadding + chipDrawable.closeIconSize + chipDrawable.closeIconStartPadding + chipDrawable.textEndPadding;
                if (DrawableCompat$Api23Impl.getLayoutDirection(chipDrawable) == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int r1 = (int) closeIconTouchBounds.left;
        int r2 = (int) closeIconTouchBounds.top;
        int r3 = (int) closeIconTouchBounds.right;
        int r0 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.rect;
        rect.set(r1, r2, r3, r0);
        return rect;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.textDrawableHelper.textAppearance;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:            if (r1 != Integer.MIN_VALUE) goto L34;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.touchHelperEnabled
            if (r0 != 0) goto L9
            boolean r11 = super.dispatchHoverEvent(r11)
            return r11
        L9:
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r10.touchHelper
            android.view.accessibility.AccessibilityManager r1 = r0.mManager
            boolean r2 = r1.isEnabled()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L70
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L1c
            goto L70
        L1c:
            int r1 = r11.getAction()
            r2 = 256(0x100, float:3.59E-43)
            r5 = 128(0x80, float:1.8E-43)
            r6 = 7
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r6) goto L42
            r6 = 9
            if (r1 == r6) goto L42
            r6 = 10
            if (r1 == r6) goto L32
            goto L70
        L32:
            int r1 = r0.mHoveredVirtualViewId
            if (r1 == r7) goto L70
            if (r1 != r7) goto L39
            goto L6e
        L39:
            r0.mHoveredVirtualViewId = r7
            r0.sendEventForVirtualView(r7, r5)
            r0.sendEventForVirtualView(r1, r2)
            goto L6e
        L42:
            float r1 = r11.getX()
            float r6 = r11.getY()
            com.google.android.material.chip.Chip r8 = com.google.android.material.chip.Chip.this
            boolean r9 = r8.hasCloseIcon()
            if (r9 == 0) goto L5e
            android.graphics.RectF r8 = r8.getCloseIconTouchBounds()
            boolean r1 = r8.contains(r1, r6)
            if (r1 == 0) goto L5e
            r1 = r3
            goto L5f
        L5e:
            r1 = r4
        L5f:
            int r6 = r0.mHoveredVirtualViewId
            if (r6 != r1) goto L64
            goto L6c
        L64:
            r0.mHoveredVirtualViewId = r1
            r0.sendEventForVirtualView(r1, r5)
            r0.sendEventForVirtualView(r6, r2)
        L6c:
            if (r1 == r7) goto L70
        L6e:
            r0 = r3
            goto L71
        L70:
            r0 = r4
        L71:
            if (r0 != 0) goto L7b
            boolean r11 = super.dispatchHoverEvent(r11)
            if (r11 == 0) goto L7a
            goto L7b
        L7a:
            r3 = r4
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.touchHelperEnabled) {
            return super.dispatchKeyEvent(keyEvent);
        }
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        chipTouchHelper.getClass();
        boolean z = false;
        int r2 = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int r5 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode != 19) {
                                    if (keyCode != 21) {
                                        if (keyCode != 22) {
                                            r5 = com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup;
                                        }
                                    } else {
                                        r5 = 17;
                                    }
                                } else {
                                    r5 = 33;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z2 = false;
                                while (r2 < repeatCount && chipTouchHelper.moveFocus(r5, null)) {
                                    r2++;
                                    z2 = true;
                                }
                                z = z2;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int r1 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
                    if (r1 != Integer.MIN_VALUE) {
                        Chip chip = Chip.this;
                        if (r1 == 0) {
                            chip.performClick();
                        } else if (r1 == 1) {
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.onCloseIconClickListener;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.touchHelperEnabled) {
                                chip.touchHelper.sendEventForVirtualView(1, 1);
                            }
                        }
                    }
                    z = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z = chipTouchHelper.moveFocus(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z = chipTouchHelper.moveFocus(1, null);
            }
        }
        if (z && chipTouchHelper.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int r3;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean z = false;
        if (chipDrawable != null && ChipDrawable.isStateful(chipDrawable.closeIcon)) {
            ChipDrawable chipDrawable2 = this.chipDrawable;
            ?? isEnabled = isEnabled();
            int r2 = isEnabled;
            if (this.closeIconFocused) {
                r2 = isEnabled + 1;
            }
            int r22 = r2;
            if (this.closeIconHovered) {
                r22 = r2 + 1;
            }
            int r23 = r22;
            if (this.closeIconPressed) {
                r23 = r22 + 1;
            }
            int r24 = r23;
            if (isChecked()) {
                r24 = r23 + 1;
            }
            int[] r25 = new int[r24];
            if (isEnabled()) {
                r25[0] = 16842910;
                r3 = 1;
            } else {
                r3 = 0;
            }
            if (this.closeIconFocused) {
                r25[r3] = 16842908;
                r3++;
            }
            if (this.closeIconHovered) {
                r25[r3] = 16843623;
                r3++;
            }
            if (this.closeIconPressed) {
                r25[r3] = 16842919;
                r3++;
            }
            if (isChecked()) {
                r25[r3] = 16842913;
            }
            if (!Arrays.equals(chipDrawable2.closeIconStateSet, r25)) {
                chipDrawable2.closeIconStateSet = r25;
                if (chipDrawable2.showsCloseIcon()) {
                    z = chipDrawable2.onStateChange(chipDrawable2.getState(), r25);
                }
            }
        }
        if (z) {
            invalidate();
        }
    }

    public final void ensureAccessibleTouchTarget(int r11) {
        int r8;
        this.minTouchTargetSize = r11;
        int r2 = 0;
        if (!this.ensureMinTouchTargetSize) {
            InsetDrawable insetDrawable = this.insetBackgroundDrawable;
            if (insetDrawable != null) {
                if (insetDrawable != null) {
                    this.insetBackgroundDrawable = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    updateFrameworkRippleBackground();
                    return;
                }
                return;
            }
            updateFrameworkRippleBackground();
            return;
        }
        int max = Math.max(0, r11 - ((int) this.chipDrawable.chipMinHeight));
        int max2 = Math.max(0, r11 - this.chipDrawable.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.insetBackgroundDrawable;
            if (insetDrawable2 != null) {
                if (insetDrawable2 != null) {
                    this.insetBackgroundDrawable = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    updateFrameworkRippleBackground();
                    return;
                }
                return;
            }
            updateFrameworkRippleBackground();
            return;
        }
        if (max2 > 0) {
            r8 = max2 / 2;
        } else {
            r8 = 0;
        }
        if (max > 0) {
            r2 = max / 2;
        }
        int r9 = r2;
        if (this.insetBackgroundDrawable != null) {
            Rect rect = new Rect();
            this.insetBackgroundDrawable.getPadding(rect);
            if (rect.top == r9 && rect.bottom == r9 && rect.left == r8 && rect.right == r8) {
                updateFrameworkRippleBackground();
                return;
            }
        }
        if (getMinHeight() != r11) {
            setMinHeight(r11);
        }
        if (getMinWidth() != r11) {
            setMinWidth(r11);
        }
        this.insetBackgroundDrawable = new InsetDrawable((Drawable) this.chipDrawable, r8, r9, r8, r9);
        updateFrameworkRippleBackground();
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        boolean z;
        if (!TextUtils.isEmpty(this.accessibilityClassName)) {
            return this.accessibilityClassName;
        }
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.checkable) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ViewParent parent = getParent();
            if ((parent instanceof ChipGroup) && ((ChipGroup) parent).checkableGroup.singleSelection) {
                return "android.widget.RadioButton";
            }
            return "android.widget.CompoundButton";
        }
        if (isClickable()) {
            return "android.widget.Button";
        }
        return "android.view.View";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        if (insetDrawable == null) {
            return this.chipDrawable;
        }
        return insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.checkedIcon;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.checkedIconTint;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipBackgroundColor;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            return 0.0f;
        }
        return Math.max(0.0f, chipDrawable.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipEndPadding;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null || (drawable = chipDrawable.chipIcon) == 0) {
            return null;
        }
        boolean z = drawable instanceof WrappedDrawable;
        Drawable drawable2 = drawable;
        if (z) {
            drawable2 = ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        return drawable2;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipIconSize;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipIconTint;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipMinHeight;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipStrokeColor;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.chipStrokeWidth;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null || (drawable = chipDrawable.closeIcon) == 0) {
            return null;
        }
        boolean z = drawable instanceof WrappedDrawable;
        Drawable drawable2 = drawable;
        if (z) {
            drawable2 = ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        return drawable2;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.closeIconContentDescription;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.closeIconEndPadding;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.closeIconSize;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.closeIconStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.closeIconTint;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.truncateAt;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.touchHelperEnabled) {
            ChipTouchHelper chipTouchHelper = this.touchHelper;
            if (chipTouchHelper.mKeyboardFocusedVirtualViewId == 1 || chipTouchHelper.mAccessibilityFocusedVirtualViewId == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.hideMotionSpec;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.iconEndPadding;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.iconStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.drawableState.shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.showMotionSpec;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.textEndPadding;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.textStartPadding;
        }
        return 0.0f;
    }

    public final boolean hasCloseIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            Object obj = chipDrawable.closeIcon;
            if (obj != null) {
                if (obj instanceof WrappedDrawable) {
                    obj = ((WrappedDrawable) obj).getWrappedDrawable();
                }
            } else {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        zzav.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public final void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r2) {
        boolean z;
        int[] onCreateDrawableState = super.onCreateDrawableState(r2 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
        }
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.checkable) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int r5, Rect rect) {
        super.onFocusChanged(z, r5, rect);
        if (this.touchHelperEnabled) {
            ChipTouchHelper chipTouchHelper = this.touchHelper;
            int r1 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
            if (r1 != Integer.MIN_VALUE) {
                chipTouchHelper.clearKeyboardFocusForVirtualView(r1);
            }
            if (z) {
                chipTouchHelper.moveFocus(r5, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z;
        int r3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.checkable) {
            z = true;
        } else {
            z = false;
        }
        accessibilityNodeInfo.setCheckable(z);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            int r4 = -1;
            if (chipGroup.singleLine) {
                r3 = 0;
                for (int r1 = 0; r1 < chipGroup.getChildCount(); r1++) {
                    if (chipGroup.getChildAt(r1) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(r1)) == this) {
                            break;
                        } else {
                            r3++;
                        }
                    }
                }
            }
            r3 = -1;
            Object tag = getTag(com.kronaby.watch.app.R.id.row_index_key);
            if (tag instanceof Integer) {
                r4 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r4, 1, r3, 1, isChecked()).mInfo);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int r3) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public final void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (this.lastLayoutDirection != r2) {
            this.lastLayoutDirection = r2;
            updatePaddingInternal();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:            if (r0 != 3) goto L28;     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L49
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L44
            goto L50
        L21:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L50
            if (r1 != 0) goto L4e
            r5.setCloseIconPressed(r3)
            goto L4e
        L2b:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L44
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.onCloseIconClickListener
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            boolean r0 = r5.touchHelperEnabled
            if (r0 == 0) goto L42
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r5.touchHelper
            r0.sendEventForVirtualView(r2, r2)
        L42:
            r0 = r2
            goto L45
        L44:
            r0 = r3
        L45:
            r5.setCloseIconPressed(r3)
            goto L51
        L49:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
        L4e:
            r0 = r2
            goto L51
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.accessibilityClassName = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckable(z);
        }
    }

    public void setCheckableResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckable(chipDrawable.context.getResources().getBoolean(r3));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            this.deferredCheckedValue = z;
            return;
        }
        if (chipDrawable.checkable) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.onCheckedChangeListenerInternal) != null) {
                CheckableGroup.AnonymousClass1 anonymousClass1 = (CheckableGroup.AnonymousClass1) onCheckedChangeListener;
                anonymousClass1.getClass();
                CheckableGroup checkableGroup = CheckableGroup.this;
                if (z) {
                    if (!checkableGroup.checkInternal(this)) {
                        return;
                    }
                } else if (!checkableGroup.uncheckInternal(this, checkableGroup.selectionRequired)) {
                    return;
                }
                checkableGroup.onCheckedStateChanged();
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int r1) {
        setCheckedIconVisible(r1);
    }

    public void setCheckedIconResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIcon(AppCompatResources.getDrawable(chipDrawable.context, r3));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTint(AppCompatResources.getColorStateList(chipDrawable.context, r3));
        }
    }

    public void setCheckedIconVisible(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(chipDrawable.context.getResources().getBoolean(r3));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.chipBackgroundColor != colorStateList) {
            chipDrawable.chipBackgroundColor = colorStateList;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
    }

    public void setChipBackgroundColorResource(int r3) {
        ColorStateList colorStateList;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.chipBackgroundColor != (colorStateList = AppCompatResources.getColorStateList(chipDrawable.context, r3))) {
            chipDrawable.chipBackgroundColor = colorStateList;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadius(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadius(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != chipDrawable) {
            if (chipDrawable2 != null) {
                chipDrawable2.delegate = new WeakReference<>(null);
            }
            this.chipDrawable = chipDrawable;
            chipDrawable.shouldDrawText = false;
            chipDrawable.delegate = new WeakReference<>(this);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.chipEndPadding != f) {
            chipDrawable.chipEndPadding = f;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            float dimension = chipDrawable.context.getResources().getDimension(r3);
            if (chipDrawable.chipEndPadding != dimension) {
                chipDrawable.chipEndPadding = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.onSizeChange();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int r1) {
        setChipIconVisible(r1);
    }

    public void setChipIconResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIcon(AppCompatResources.getDrawable(chipDrawable.context, r3));
        }
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSize(f);
        }
    }

    public void setChipIconSizeResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSize(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTint(AppCompatResources.getColorStateList(chipDrawable.context, r3));
        }
    }

    public void setChipIconVisible(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(chipDrawable.context.getResources().getBoolean(r3));
        }
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.chipMinHeight != f) {
            chipDrawable.chipMinHeight = f;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
    }

    public void setChipMinHeightResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            float dimension = chipDrawable.context.getResources().getDimension(r3);
            if (chipDrawable.chipMinHeight != dimension) {
                chipDrawable.chipMinHeight = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.onSizeChange();
            }
        }
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.chipStartPadding != f) {
            chipDrawable.chipStartPadding = f;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            float dimension = chipDrawable.context.getResources().getDimension(r3);
            if (chipDrawable.chipStartPadding != dimension) {
                chipDrawable.chipStartPadding = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.onSizeChange();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColor(AppCompatResources.getColorStateList(chipDrawable.context, r3));
        }
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidth(f);
        }
    }

    public void setChipStrokeWidthResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidth(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int r2) {
        setText(getResources().getString(r2));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIcon(drawable);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        BidiFormatter bidiFormatter;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.closeIconContentDescription != charSequence) {
            String str = BidiFormatter.LRM_STRING;
            Locale locale = Locale.getDefault();
            int r2 = TextUtilsCompat.$r8$clinit;
            boolean z = true;
            if (TextUtilsCompat.Api17Impl.getLayoutDirectionFromLocale(locale) != 1) {
                z = false;
            }
            if (z) {
                bidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
            } else {
                bidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
            }
            chipDrawable.closeIconContentDescription = bidiFormatter.unicodeWrap(charSequence, bidiFormatter.mDefaultTextDirectionHeuristicCompat);
            chipDrawable.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int r1) {
        setCloseIconVisible(r1);
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPadding(f);
        }
    }

    public void setCloseIconEndPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPadding(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setCloseIconResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIcon(AppCompatResources.getDrawable(chipDrawable.context, r3));
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSize(f);
        }
    }

    public void setCloseIconSizeResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSize(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPadding(f);
        }
    }

    public void setCloseIconStartPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPadding(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTint(AppCompatResources.getColorStateList(chipDrawable.context, r3));
        }
    }

    public void setCloseIconVisible(int r2) {
        setCloseIconVisible(getResources().getBoolean(r2));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (r3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (r3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setElevation(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.truncateAt = truncateAt;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int r2) {
        if (r2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(r2);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.hideMotionSpec = motionSpec;
        }
    }

    public void setHideMotionSpecResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.hideMotionSpec = MotionSpec.createFromResource(chipDrawable.context, r3);
        }
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPadding(f);
        }
    }

    public void setIconEndPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPadding(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPadding(f);
        }
    }

    public void setIconStartPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPadding(chipDrawable.context.getResources().getDimension(r3));
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    public void setInternalOnCheckedChangeListener(MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int r2) {
        if (this.chipDrawable == null) {
            return;
        }
        super.setLayoutDirection(r2);
    }

    @Override // android.widget.TextView
    public void setLines(int r2) {
        if (r2 <= 1) {
            super.setLines(r2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r2) {
        if (r2 <= 1) {
            super.setMaxLines(r2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r2) {
        super.setMaxWidth(r2);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.maxWidth = r2;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int r2) {
        if (r2 <= 1) {
            super.setMinLines(r2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColor(colorStateList);
        }
        if (!this.chipDrawable.useCompatRipple) {
            updateFrameworkRippleBackground();
        }
    }

    public void setRippleColorResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColor(AppCompatResources.getColorStateList(chipDrawable.context, r3));
            if (!this.chipDrawable.useCompatRipple) {
                updateFrameworkRippleBackground();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.chipDrawable.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.showMotionSpec = motionSpec;
        }
    }

    public void setShowMotionSpecResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.showMotionSpec = MotionSpec.createFromResource(chipDrawable.context, r3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (chipDrawable.shouldDrawText) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && !TextUtils.equals(chipDrawable2.text, charSequence)) {
            chipDrawable2.text = charSequence;
            chipDrawable2.textDrawableHelper.textWidthDirty = true;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.textDrawableHelper.setTextAppearance(textAppearance, chipDrawable.context);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int r2) {
        setTextAppearance(getContext(), r2);
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.textEndPadding != f) {
            chipDrawable.textEndPadding = f;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            float dimension = chipDrawable.context.getResources().getDimension(r3);
            if (chipDrawable.textEndPadding != dimension) {
                chipDrawable.textEndPadding = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.onSizeChange();
            }
        }
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.textStartPadding != f) {
            chipDrawable.textStartPadding = f;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int r3) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            float dimension = chipDrawable.context.getResources().getDimension(r3);
            if (chipDrawable.textStartPadding != dimension) {
                chipDrawable.textStartPadding = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.onSizeChange();
            }
        }
    }

    public final void updateAccessibilityDelegate() {
        boolean z;
        if (hasCloseIcon()) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.closeIconVisible) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.onCloseIconClickListener != null) {
                ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
                this.touchHelperEnabled = true;
                return;
            }
        }
        ViewCompat.setAccessibilityDelegate(this, null);
        this.touchHelperEnabled = false;
    }

    public final void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.rippleColor), getBackgroundDrawable(), null);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable.useCompatRipple) {
            chipDrawable.useCompatRipple = false;
            chipDrawable.compatRippleColor = null;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        RippleDrawable rippleDrawable = this.ripple;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setBackground(this, rippleDrawable);
        updatePaddingInternal();
    }

    public final void updatePaddingInternal() {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable = this.chipDrawable) != null) {
            int calculateCloseIconWidth = (int) (chipDrawable.calculateCloseIconWidth() + chipDrawable.chipEndPadding + chipDrawable.textEndPadding);
            ChipDrawable chipDrawable2 = this.chipDrawable;
            int calculateChipIconWidth = (int) (chipDrawable2.calculateChipIconWidth() + chipDrawable2.chipStartPadding + chipDrawable2.textStartPadding);
            if (this.insetBackgroundDrawable != null) {
                Rect rect = new Rect();
                this.insetBackgroundDrawable.getPadding(rect);
                calculateChipIconWidth += rect.left;
                calculateCloseIconWidth += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api17Impl.setPaddingRelative(this, calculateChipIconWidth, paddingTop, calculateCloseIconWidth, paddingBottom);
        }
    }

    public final void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconVisible(z);
        }
        updateAccessibilityDelegate();
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(z);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int r4) {
        super.setTextAppearance(context, r4);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            Context context2 = chipDrawable.context;
            chipDrawable.textDrawableHelper.setTextAppearance(new TextAppearance(context2, r4), context2);
        }
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r4) {
        super.setTextAppearance(r4);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            Context context = chipDrawable.context;
            chipDrawable.textDrawableHelper.setTextAppearance(new TextAppearance(context, r4), context);
        }
        updateTextPaintDrawState();
    }
}

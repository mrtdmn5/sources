package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import com.animaconnected.watch.image.Kolors;
import com.google.android.material.R$styleable;
import com.google.common.hash.AbstractHasher;

/* loaded from: classes3.dex */
public final class TextAppearance {
    public Typeface font;
    public final String fontFamily;
    public final int fontFamilyResourceId;
    public boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public ColorStateList textColor;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int r7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(r7, R$styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(0, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 3);
        MaterialResources.getColorStateList(context, obtainStyledAttributes, 4);
        MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
        this.textStyle = obtainStyledAttributes.getInt(2, 0);
        this.typeface = obtainStyledAttributes.getInt(1, 1);
        int r3 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(r3, 0);
        this.fontFamily = obtainStyledAttributes.getString(r3);
        obtainStyledAttributes.getBoolean(14, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 6);
        this.shadowDx = obtainStyledAttributes.getFloat(7, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(r7, R$styleable.MaterialTextAppearance);
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(0);
        this.letterSpacing = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void createFallbackFont() {
        String str;
        Typeface typeface = this.font;
        int r1 = this.textStyle;
        if (typeface == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, r1);
        }
        if (this.font == null) {
            int r2 = this.typeface;
            if (r2 != 1) {
                if (r2 != 2) {
                    if (r2 != 3) {
                        this.font = Typeface.DEFAULT;
                    } else {
                        this.font = Typeface.MONOSPACE;
                    }
                } else {
                    this.font = Typeface.SERIF;
                }
            } else {
                this.font = Typeface.SANS_SERIF;
            }
            this.font = Typeface.create(this.font, r1);
        }
    }

    public final Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font;
                if (font != null) {
                    this.font = Typeface.create(font, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.fontFamily, e);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public final void getFontAsync(Context context, final AbstractHasher abstractHasher) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        int r2 = this.fontFamilyResourceId;
        if (r2 == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            abstractHasher.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void onFontRetrievalFailed(int r3) {
                    TextAppearance.this.fontResolved = true;
                    abstractHasher.onFontRetrievalFailed(r3);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    textAppearance.fontResolved = true;
                    abstractHasher.onFontRetrieved(textAppearance.font, false);
                }
            };
            ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
            if (context.isRestricted()) {
                fontCallback.callbackFailAsync(-4);
            } else {
                ResourcesCompat.loadFont(context, r2, new TypedValue(), 0, fontCallback, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            abstractHasher.onFontRetrievalFailed(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.fontFamily, e);
            this.fontResolved = true;
            abstractHasher.onFontRetrievalFailed(-3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldLoadFontSynchronously(android.content.Context r8) {
        /*
            r7 = this;
            int r1 = r7.fontFamilyResourceId
            if (r1 == 0) goto L1c
            java.lang.ThreadLocal<android.util.TypedValue> r0 = androidx.core.content.res.ResourcesCompat.sTempTypedValue
            boolean r0 = r8.isRestricted()
            if (r0 == 0) goto Ld
            goto L1c
        Ld:
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r0 = r8
            android.graphics.Typeface r8 = androidx.core.content.res.ResourcesCompat.loadFont(r0, r1, r2, r3, r4, r5, r6)
            goto L1d
        L1c:
            r8 = 0
        L1d:
            if (r8 == 0) goto L21
            r8 = 1
            goto L22
        L21:
            r8 = 0
        L22:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.TextAppearance.shouldLoadFontSynchronously(android.content.Context):boolean");
    }

    public final void updateDrawState(Context context, TextPaint textPaint, AbstractHasher abstractHasher) {
        int r3;
        int r32;
        updateMeasureState(context, textPaint, abstractHasher);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            r3 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            r3 = Kolors.black;
        }
        textPaint.setColor(r3);
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            r32 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            r32 = 0;
        }
        textPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, r32);
    }

    public final void updateMeasureState(final Context context, final TextPaint textPaint, final AbstractHasher abstractHasher) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(context, textPaint, getFont(context));
            return;
        }
        createFallbackFont();
        updateTextPaintMeasureState(context, textPaint, this.font);
        getFontAsync(context, new AbstractHasher() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.common.hash.AbstractHasher
            public final void onFontRetrievalFailed(int r2) {
                abstractHasher.onFontRetrievalFailed(r2);
            }

            @Override // com.google.common.hash.AbstractHasher
            public final void onFontRetrieved(Typeface typeface, boolean z) {
                TextAppearance.this.updateTextPaintMeasureState(context, textPaint, typeface);
                abstractHasher.onFontRetrieved(typeface, z);
            }
        });
    }

    public final void updateTextPaintMeasureState(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z;
        float f;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context.getResources().getConfiguration(), typeface);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface);
        int r1 = (~typeface.getStyle()) & this.textStyle;
        if ((r1 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        textPaint.setFakeBoldText(z);
        if ((r1 & 2) != 0) {
            f = -0.25f;
        } else {
            f = 0.0f;
        }
        textPaint.setTextSkewX(f);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }
}

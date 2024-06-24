package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextViewCompat {

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static boolean getIncludeFontPadding(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        public static int getMaxLines(TextView textView) {
            return textView.getMaxLines();
        }

        public static int getMinLines(TextView textView) {
            return textView.getMinLines();
        }
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static int getLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        public static int getTextDirection(View view) {
            return view.getTextDirection();
        }

        public static Locale getTextLocale(TextView textView) {
            return textView.getTextLocale();
        }

        public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void setTextDirection(View view, int r1) {
            view.setTextDirection(r1);
        }

        public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int r1, int r2, int r3, int r4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static int getBreakStrategy(TextView textView) {
            return textView.getBreakStrategy();
        }

        public static ColorStateList getCompoundDrawableTintList(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        public static int getHyphenationFrequency(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        public static void setBreakStrategy(TextView textView, int r1) {
            textView.setBreakStrategy(r1);
        }

        public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void setHyphenationFrequency(TextView textView, int r1) {
            textView.setHyphenationFrequency(r1);
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static DecimalFormatSymbols getInstance(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    /* loaded from: classes.dex */
    public static class OreoCallback implements ActionMode.Callback {
        public final ActionMode.Callback mCallback;
        public boolean mCanUseMenuBuilderReferences;
        public boolean mInitializedMenuBuilderReferences = false;
        public Class<?> mMenuBuilderClass;
        public Method mMenuBuilderRemoveItemAtMethod;
        public final TextView mTextView;

        public OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00d2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00a0 A[SYNTHETIC] */
        @Override // android.view.ActionMode.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onPrepareActionMode(android.view.ActionMode r14, android.view.Menu r15) {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.TextViewCompat.OreoCallback.onPrepareActionMode(android.view.ActionMode, android.view.Menu):boolean");
        }
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(textView));
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = Api23Impl.getBreakStrategy(textView);
        int hyphenationFrequency = Api23Impl.getHyphenationFrequency(textView);
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z = true;
            if (r0 >= 28 && (textView.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(textView)))[0].codePointAt(0));
                if (directionality != 1 && directionality != 2) {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                }
            } else {
                if (Api17Impl.getLayoutDirection(textView) != 1) {
                    z = false;
                }
                switch (Api17Impl.getTextDirection(textView)) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        }
                }
            }
        }
        return new PrecomputedTextCompat.Params(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int r4) {
        int r0;
        Preconditions.checkArgumentNonnegative(r4);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setFirstBaselineToTopHeight(textView, r4);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.getIncludeFontPadding(textView)) {
            r0 = fontMetricsInt.top;
        } else {
            r0 = fontMetricsInt.ascent;
        }
        if (r4 > Math.abs(r0)) {
            textView.setPadding(textView.getPaddingLeft(), r4 + r0, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int r4) {
        int r0;
        Preconditions.checkArgumentNonnegative(r4);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.getIncludeFontPadding(textView)) {
            r0 = fontMetricsInt.bottom;
        } else {
            r0 = fontMetricsInt.descent;
        }
        if (r4 > Math.abs(r0)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), r4 - r0);
        }
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            precomputedTextCompat.getClass();
            textView.setText(Api28Impl.castToCharSequence(null));
        } else {
            PrecomputedTextCompat.Params textMetricsParams = getTextMetricsParams(textView);
            precomputedTextCompat.getClass();
            textMetricsParams.equalsWithoutTextDirection(null);
            throw null;
        }
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        if ((callback instanceof OreoCallback) && Build.VERSION.SDK_INT >= 26) {
            return ((OreoCallback) callback).mCallback;
        }
        return callback;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(ActionMode.Callback callback, TextView textView) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26 && r0 <= 27 && !(callback instanceof OreoCallback) && callback != null) {
            return new OreoCallback(callback, textView);
        }
        return callback;
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params getTextMetricsParams(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static void setFirstBaselineToTopHeight(TextView textView, int r1) {
            textView.setFirstBaselineToTopHeight(r1);
        }

        public static CharSequence castToCharSequence(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }
}

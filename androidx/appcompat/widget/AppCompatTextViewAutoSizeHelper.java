package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class AppCompatTextViewAutoSizeHelper {
    public static final RectF TEMP_RECTF = new RectF();

    @SuppressLint({"BanConcurrentHashMap"})
    public static final ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();
    public final Context mContext;
    public final Impl23 mImpl;
    public TextPaint mTempTextPaint;
    public final TextView mTextView;
    public int mAutoSizeTextType = 0;
    public boolean mNeedsAutoSizeText = false;
    public float mAutoSizeStepGranularityInPx = -1.0f;
    public float mAutoSizeMinTextSizeInPx = -1.0f;
    public float mAutoSizeMaxTextSizeInPx = -1.0f;
    public int[] mAutoSizeTextSizesInPx = new int[0];
    public boolean mHasPresetAutoSizeValues = false;

    /* loaded from: classes.dex */
    public static class Impl {
        public boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, Boolean.FALSE, "getHorizontallyScrolling")).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class Impl23 extends Impl {
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, TextDirectionHeuristics.FIRSTSTRONG_LTR, "getTextDirectionHeuristic"));
        }
    }

    /* loaded from: classes.dex */
    public static class Impl29 extends Impl23 {
        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    static {
        new ConcurrentHashMap();
    }

    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl23();
        }
    }

    public static int[] cleanupAutoSizePresetSizes(int[] r6) {
        int length = r6.length;
        if (length == 0) {
            return r6;
        }
        Arrays.sort(r6);
        ArrayList arrayList = new ArrayList();
        for (int r4 : r6) {
            if (r4 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(r4)) < 0) {
                arrayList.add(Integer.valueOf(r4));
            }
        }
        if (length == arrayList.size()) {
            return r6;
        }
        int size = arrayList.size();
        int[] r0 = new int[size];
        for (int r2 = 0; r2 < size; r2++) {
            r0[r2] = ((Integer) arrayList.get(r2)).intValue();
        }
        return r0;
    }

    public static Method getTextViewMethod(String str) {
        try {
            ConcurrentHashMap<String, Method> concurrentHashMap = sTextViewMethodByNameCache;
            Method method = concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public static Object invokeAndReturnWithDefault(Object obj, Object obj2, String str) {
        try {
            return getTextViewMethod(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    public final void autoSizeText() {
        boolean z;
        int measuredWidth;
        if (supportsAutoSizeText() && this.mAutoSizeTextType != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        if (this.mNeedsAutoSizeText) {
            if (this.mTextView.getMeasuredHeight() > 0 && this.mTextView.getMeasuredWidth() > 0) {
                if (this.mImpl.isHorizontallyScrollable(this.mTextView)) {
                    measuredWidth = Constants.MB;
                } else {
                    measuredWidth = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                }
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = TEMP_RECTF;
                    synchronized (rectF) {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float findLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                        if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                            setTextSizeInternal(findLargestTextSizeWhichFits, 0);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.mNeedsAutoSizeText = true;
    }

    public final int findLargestTextSizeWhichFits(RectF rectF) {
        int r11;
        boolean z;
        CharSequence transformation;
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length != 0) {
            int r0 = length - 1;
            int r3 = 1;
            int r4 = 0;
            while (r3 <= r0) {
                int r42 = (r3 + r0) / 2;
                int r5 = this.mAutoSizeTextSizesInPx[r42];
                TextView textView = this.mTextView;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    text = transformation;
                }
                int maxLines = textView.getMaxLines();
                TextPaint textPaint = this.mTempTextPaint;
                if (textPaint == null) {
                    this.mTempTextPaint = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.mTempTextPaint.set(textView.getPaint());
                this.mTempTextPaint.setTextSize(r5);
                Layout.Alignment alignment = (Layout.Alignment) invokeAndReturnWithDefault(textView, Layout.Alignment.ALIGN_NORMAL, "getLayoutAlignment");
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, 0, text.length(), this.mTempTextPaint, Math.round(rectF.right));
                StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
                if (maxLines == -1) {
                    r11 = Integer.MAX_VALUE;
                } else {
                    r11 = maxLines;
                }
                hyphenationFrequency.setMaxLines(r11);
                try {
                    this.mImpl.computeAndSetTextDirection(obtain, textView);
                } catch (ClassCastException unused) {
                    Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
                }
                StaticLayout build = obtain.build();
                if ((maxLines != -1 && (build.getLineCount() > maxLines || build.getLineEnd(build.getLineCount() - 1) != text.length())) || build.getHeight() > rectF.bottom) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    int r43 = r42 + 1;
                    r4 = r3;
                    r3 = r43;
                } else {
                    r4 = r42 - 1;
                    r0 = r4;
                }
            }
            return this.mAutoSizeTextSizesInPx[r4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final void setTextSizeInternal(float f, int r5) {
        Resources resources;
        Context context = this.mContext;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(r5, f, resources.getDisplayMetrics());
        TextView textView = this.mTextView;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(textView, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean setupAutoSizeText() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                int[] r3 = new int[floor];
                for (int r1 = 0; r1 < floor; r1++) {
                    r3[r1] = Math.round((r1 * this.mAutoSizeStepGranularityInPx) + this.mAutoSizeMinTextSizeInPx);
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r3);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    public final boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z;
        if (this.mAutoSizeTextSizesInPx.length > 0) {
            z = true;
        } else {
            z = false;
        }
        this.mHasPresetAutoSizeValues = z;
        if (z) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = r0[0];
            this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z;
    }

    public final boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    public final void validateAndSetAutoSizeTextTypeUniformConfiguration(float f, float f2, float f3) throws IllegalArgumentException {
        if (f > 0.0f) {
            if (f2 > f) {
                if (f3 > 0.0f) {
                    this.mAutoSizeTextType = 1;
                    this.mAutoSizeMinTextSizeInPx = f;
                    this.mAutoSizeMaxTextSizeInPx = f2;
                    this.mAutoSizeStepGranularityInPx = f3;
                    this.mHasPresetAutoSizeValues = false;
                    return;
                }
                throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("The auto-size step granularity (", f3, "px) is less or equal to (0px)"));
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("Minimum auto-size text size (", f, "px) is less or equal to (0px)"));
    }
}

package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class TypedArrayUtils {
    public static ColorStateList getNamedColorStateList(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        if (!hasAttribute(xmlPullParser, "tint")) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(1, typedValue);
        int r2 = typedValue.type;
        if (r2 != 2) {
            if (r2 >= 28 && r2 <= 31) {
                return ColorStateList.valueOf(typedValue.data);
            }
            Resources resources = typedArray.getResources();
            int resourceId = typedArray.getResourceId(1, 0);
            ThreadLocal<TypedValue> threadLocal = ColorStateListInflaterCompat.sTempTypedValue;
            try {
                return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(resourceId), theme);
            } catch (Exception e) {
                Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                return null;
            }
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int r7) {
        ComplexColorCompat complexColorCompat;
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(r7, typedValue);
            int r1 = typedValue.type;
            if (r1 >= 28 && r1 <= 31) {
                return new ComplexColorCompat(null, null, typedValue.data);
            }
            try {
                complexColorCompat = ComplexColorCompat.createFromXml(typedArray.getResources(), typedArray.getResourceId(r7, 0), theme);
            } catch (Exception e) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                complexColorCompat = null;
            }
            if (complexColorCompat != null) {
                return complexColorCompat;
            }
        }
        return new ComplexColorCompat(null, null, 0);
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int r3, float f) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f;
        }
        return typedArray.getFloat(r3, f);
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int r3, int r4) {
        if (!hasAttribute(xmlPullParser, str)) {
            return r4;
        }
        return typedArray.getInt(r3, r4);
    }

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] r3) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, r3);
        }
        return theme.obtainStyledAttributes(attributeSet, r3, 0, 0);
    }
}

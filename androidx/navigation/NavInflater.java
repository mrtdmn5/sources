package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.NavType;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class NavInflater {
    public static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    public final Context mContext;
    public final NavigatorProvider mNavigatorProvider;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    public static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType != null && navType != navType2) {
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
        }
        if (navType == null) {
            return navType2;
        }
        return navType;
    }

    public static NavArgument inflateArgument(TypedArray typedArray, Resources resources, int r29) throws XmlPullParserException {
        boolean z;
        NavType navType;
        NavType navType2;
        NavType navType3;
        boolean z2;
        NavType navType4;
        boolean z3;
        Object obj;
        NavType navType5;
        NavType checkNavType;
        Object valueOf;
        boolean z4;
        NavType navType6;
        String str;
        boolean z5 = typedArray.getBoolean(3, false);
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(2);
        NavType navType7 = NavType.ReferenceType;
        NavType navType8 = NavType.FloatArrayType;
        NavType navType9 = NavType.StringArrayType;
        NavType navType10 = NavType.BoolArrayType;
        NavType navType11 = NavType.LongArrayType;
        NavType navType12 = NavType.IntArrayType;
        NavType navType13 = NavType.LongType;
        NavType navType14 = NavType.StringType;
        NavType navType15 = NavType.BoolType;
        NavType navType16 = NavType.FloatType;
        NavType navType17 = NavType.IntType;
        NavType navType18 = null;
        if (string != null) {
            navType = navType12;
            String resourcePackageName = resources.getResourcePackageName(r29);
            if ("integer".equals(string)) {
                z = z5;
                navType2 = navType13;
                navType3 = navType17;
            } else {
                z = z5;
                if ("integer[]".equals(string)) {
                    navType2 = navType13;
                    navType3 = navType;
                } else if ("long".equals(string)) {
                    navType3 = navType13;
                    navType2 = navType3;
                } else if ("long[]".equals(string)) {
                    navType2 = navType13;
                    navType3 = navType11;
                } else if ("boolean".equals(string)) {
                    navType2 = navType13;
                    navType3 = navType15;
                } else if ("boolean[]".equals(string)) {
                    navType2 = navType13;
                    navType3 = navType10;
                } else {
                    if (!"string".equals(string)) {
                        if ("string[]".equals(string)) {
                            navType2 = navType13;
                            navType3 = navType9;
                        } else if ("float".equals(string)) {
                            navType2 = navType13;
                            navType3 = navType16;
                        } else if ("float[]".equals(string)) {
                            navType2 = navType13;
                            navType3 = navType8;
                        } else if ("reference".equals(string)) {
                            navType3 = navType7;
                            navType2 = navType13;
                        } else if (!string.isEmpty()) {
                            try {
                                if (string.startsWith(InstructionFileId.DOT) && resourcePackageName != null) {
                                    str = resourcePackageName.concat(string);
                                } else {
                                    str = string;
                                }
                                if (string.endsWith("[]")) {
                                    navType2 = navType13;
                                    str = str.substring(0, str.length() - 2);
                                    Class<?> cls = Class.forName(str);
                                    if (Parcelable.class.isAssignableFrom(cls)) {
                                        navType3 = new NavType.ParcelableArrayType(cls);
                                    } else {
                                        if (Serializable.class.isAssignableFrom(cls)) {
                                            navType3 = new NavType.SerializableArrayType(cls);
                                        }
                                        throw new IllegalArgumentException(str + " is not Serializable or Parcelable.");
                                    }
                                } else {
                                    navType2 = navType13;
                                    Class<?> cls2 = Class.forName(str);
                                    if (Parcelable.class.isAssignableFrom(cls2)) {
                                        navType3 = new NavType.ParcelableType(cls2);
                                    } else if (Enum.class.isAssignableFrom(cls2)) {
                                        navType3 = new NavType.EnumType(cls2);
                                    } else {
                                        if (Serializable.class.isAssignableFrom(cls2)) {
                                            navType3 = new NavType.SerializableType(cls2);
                                        }
                                        throw new IllegalArgumentException(str + " is not Serializable or Parcelable.");
                                    }
                                }
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    navType2 = navType13;
                    navType3 = navType14;
                }
            }
        } else {
            z = z5;
            navType = navType12;
            navType2 = navType13;
            navType3 = null;
        }
        if (typedArray.getValue(1, typedValue)) {
            if (navType3 == navType7) {
                int r0 = typedValue.resourceId;
                if (r0 != 0) {
                    obj = Integer.valueOf(r0);
                    navType4 = navType2;
                    z2 = true;
                    z3 = false;
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    z3 = false;
                    obj = 0;
                    navType6 = navType3;
                    navType3 = navType6;
                    navType4 = navType2;
                    z2 = true;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType3.getName() + ". Must be a reference to a resource.");
                }
            } else {
                z3 = false;
                int r6 = typedValue.resourceId;
                if (r6 != 0) {
                    if (navType3 == null) {
                        obj = Integer.valueOf(r6);
                        navType6 = navType7;
                        navType3 = navType6;
                        navType4 = navType2;
                        z2 = true;
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType3.getName() + ". You must use a \"reference\" type to reference other resources.");
                    }
                } else {
                    if (navType3 == navType14) {
                        z2 = true;
                        obj = typedArray.getString(1);
                    } else {
                        z2 = true;
                        int r02 = typedValue.type;
                        if (r02 != 3) {
                            if (r02 != 4) {
                                if (r02 != 5) {
                                    if (r02 != 18) {
                                        if (r02 >= 16 && r02 <= 31) {
                                            if (navType3 == navType16) {
                                                checkNavType = checkNavType(typedValue, navType3, navType16, string, "float");
                                                valueOf = Float.valueOf(typedValue.data);
                                            } else {
                                                checkNavType = checkNavType(typedValue, navType3, navType17, string, "integer");
                                                valueOf = Integer.valueOf(typedValue.data);
                                            }
                                        } else {
                                            throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                                        }
                                    } else {
                                        checkNavType = checkNavType(typedValue, navType3, navType15, string, "boolean");
                                        if (typedValue.data != 0) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        valueOf = Boolean.valueOf(z4);
                                    }
                                } else {
                                    checkNavType = checkNavType(typedValue, navType3, navType17, string, "dimension");
                                    valueOf = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                                }
                            } else {
                                checkNavType = checkNavType(typedValue, navType3, navType16, string, "float");
                                valueOf = Float.valueOf(typedValue.getFloat());
                            }
                            Object obj2 = valueOf;
                            navType3 = checkNavType;
                            obj = obj2;
                        } else {
                            String charSequence = typedValue.string.toString();
                            if (navType3 == null) {
                                try {
                                    navType17.parseValue(charSequence);
                                    navType3 = navType17;
                                } catch (IllegalArgumentException unused) {
                                    navType4 = navType2;
                                    try {
                                        try {
                                            try {
                                                navType4.parseValue(charSequence);
                                                navType3 = navType4;
                                            } catch (IllegalArgumentException unused2) {
                                                navType16.parseValue(charSequence);
                                                navType3 = navType16;
                                            }
                                        } catch (IllegalArgumentException unused3) {
                                            navType15.parseValue(charSequence);
                                            navType3 = navType15;
                                        }
                                    } catch (IllegalArgumentException unused4) {
                                        navType3 = navType14;
                                    }
                                }
                            }
                            navType4 = navType2;
                            obj = navType3.parseValue(charSequence);
                        }
                    }
                    navType4 = navType2;
                }
            }
        } else {
            z2 = true;
            navType4 = navType2;
            z3 = false;
            obj = null;
        }
        if (obj == null) {
            z2 = z3;
            obj = null;
        }
        if (navType3 != null) {
            navType18 = navType3;
        }
        if (navType18 == null) {
            if (!(obj instanceof Integer)) {
                if (obj instanceof int[]) {
                    navType5 = navType;
                } else if (obj instanceof Long) {
                    navType5 = navType4;
                } else if (obj instanceof long[]) {
                    navType5 = navType11;
                } else if (obj instanceof Float) {
                    navType5 = navType16;
                } else if (obj instanceof float[]) {
                    navType5 = navType8;
                } else if (obj instanceof Boolean) {
                    navType5 = navType15;
                } else if (obj instanceof boolean[]) {
                    navType5 = navType10;
                } else if (!(obj instanceof String) && obj != null) {
                    if (obj instanceof String[]) {
                        navType5 = navType9;
                    } else if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                        navType17 = new NavType.ParcelableArrayType(obj.getClass().getComponentType());
                    } else if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                        navType17 = new NavType.SerializableArrayType(obj.getClass().getComponentType());
                    } else if (obj instanceof Parcelable) {
                        navType17 = new NavType.ParcelableType(obj.getClass());
                    } else if (obj instanceof Enum) {
                        navType17 = new NavType.EnumType(obj.getClass());
                    } else if (obj instanceof Serializable) {
                        navType17 = new NavType.SerializableType(obj.getClass());
                    } else {
                        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
                    }
                } else {
                    navType5 = navType14;
                }
            }
            navType5 = navType17;
        } else {
            navType5 = navType18;
        }
        return new NavArgument(navType5, z, obj, z2);
    }

    @SuppressLint({"ResourceType"})
    public final NavGraph inflate(int r7) {
        int next;
        Resources resources = this.mContext.getResources();
        XmlResourceParser xml = resources.getXml(r7);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(r7) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            NavDestination inflate = inflate(resources, xml, asAttributeSet, r7);
            if (inflate instanceof NavGraph) {
                return (NavGraph) inflate;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x022f, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.navigation.NavDestination inflate(android.content.res.Resources r25, android.content.res.XmlResourceParser r26, android.util.AttributeSet r27, int r28) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, int):androidx.navigation.NavDestination");
    }
}

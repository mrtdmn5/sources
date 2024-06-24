package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class<?> mFontFamily;
    public final Constructor<?> mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = obtainAddFontFromAssetManagerMethod(cls);
            method3 = obtainAddFontFromBufferMethod(cls);
            method4 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method5 = obtainCreateFromFamiliesWithDefaultMethod(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method2;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method4;
        this.mAbortCreation = method;
        this.mCreateFromFamiliesWithDefault = method5;
    }

    public static Method obtainAddFontFromAssetManagerMethod(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public static Method obtainAddFontFromBufferMethod(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public final boolean addFontFromAssetManager(Context context, Object obj, String str, int r7, int r8, int r9, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int r15) {
        Object obj;
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, r15);
        }
        try {
            obj = this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.mEntries) {
            if (!addFontFromAssetManager(context, obj, fontFileResourceEntry.mFileName, fontFileResourceEntry.mTtcIndex, fontFileResourceEntry.mWeight, fontFileResourceEntry.mItalic ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.mVariationSettings))) {
                try {
                    this.mAbortCreation.invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
                return null;
            }
        }
        if (!freeze(obj)) {
            return null;
        }
        return createFromFamiliesWithDefault(obj);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int r19) {
        Object obj;
        Typeface createFromFamiliesWithDefault;
        boolean z;
        if (fontsContractCompat$FontInfoArr.length < 1) {
            return null;
        }
        if (!isFontFamilyPrivateAPIAvailable()) {
            FontsContractCompat$FontInfo findBestInfo = findBestInfo(r19, fontsContractCompat$FontInfoArr);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.mUri, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.mWeight).setItalic(findBestInfo.mItalic).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            HashMap hashMap = new HashMap();
            for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                if (fontsContractCompat$FontInfo.mResultCode == 0) {
                    Uri uri = fontsContractCompat$FontInfo.mUri;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, TypefaceCompatUtil.mmap(context, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            try {
                obj = this.mFontFamilyCtor.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused2) {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            int length = fontsContractCompat$FontInfoArr.length;
            int r9 = 0;
            boolean z2 = false;
            while (true) {
                Method method = this.mAbortCreation;
                if (r9 < length) {
                    FontsContractCompat$FontInfo fontsContractCompat$FontInfo2 = fontsContractCompat$FontInfoArr[r9];
                    ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(fontsContractCompat$FontInfo2.mUri);
                    if (byteBuffer != null) {
                        try {
                            z = ((Boolean) this.mAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(fontsContractCompat$FontInfo2.mTtcIndex), null, Integer.valueOf(fontsContractCompat$FontInfo2.mWeight), Integer.valueOf(fontsContractCompat$FontInfo2.mItalic ? 1 : 0))).booleanValue();
                        } catch (IllegalAccessException | InvocationTargetException unused3) {
                            z = false;
                        }
                        if (!z) {
                            try {
                                method.invoke(obj, new Object[0]);
                                return null;
                            } catch (IllegalAccessException | InvocationTargetException unused4) {
                                return null;
                            }
                        }
                        z2 = true;
                    }
                    r9++;
                    z2 = z2;
                } else {
                    if (!z2) {
                        try {
                            method.invoke(obj, new Object[0]);
                            return null;
                        } catch (IllegalAccessException | InvocationTargetException unused5) {
                            return null;
                        }
                    }
                    if (!freeze(obj) || (createFromFamiliesWithDefault = createFromFamiliesWithDefault(obj)) == null) {
                        return null;
                    }
                    return Typeface.create(createFromFamiliesWithDefault, r19);
                }
            }
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromResourcesFontFile(Context context, Resources resources, int r11, String str, int r13) {
        Object obj;
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, r11, str, r13);
        }
        try {
            obj = this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        if (!addFontFromAssetManager(context, obj, str, 0, -1, -1, null)) {
            try {
                this.mAbortCreation.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
            return null;
        }
        if (!freeze(obj)) {
            return null;
        }
        return createFromFamiliesWithDefault(obj);
    }

    public final boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean isFontFamilyPrivateAPIAvailable() {
        Method method = this.mAddFontFromAssetManager;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    public static final Method sAddFontWeightStyle;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class<?> sFontFamily;
    public static final Constructor<?> sFontFamilyCtor;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    public static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int r5, int r6, boolean z) {
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, byteBuffer, Integer.valueOf(r5), null, Integer.valueOf(r6), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[SYNTHETIC] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context r18, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry r19, android.content.res.Resources r20, int r21) {
        /*
            r17 = this;
            r1 = 0
            r2 = 0
            java.lang.reflect.Constructor<?> r0 = androidx.core.graphics.TypefaceCompatApi24Impl.sFontFamilyCtor     // Catch: java.lang.Throwable -> Lc
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lc
            java.lang.Object r0 = r0.newInstance(r3)     // Catch: java.lang.Throwable -> Lc
            r3 = r0
            goto Ld
        Lc:
            r3 = r1
        Ld:
            if (r3 != 0) goto L10
            return r1
        L10:
            r0 = r19
            androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry[] r4 = r0.mEntries
            int r5 = r4.length
            r6 = r2
        L16:
            if (r6 >= r5) goto L71
            r7 = r4[r6]
            int r0 = r7.mResourceId
            java.io.File r8 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r18)
            r9 = r20
            if (r8 != 0) goto L25
            goto L2e
        L25:
            boolean r0 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r8, r9, r0)     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L30
            r8.delete()
        L2e:
            r0 = r1
            goto L59
        L30:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            r10.<init>(r8)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            java.nio.channels.FileChannel r11 = r10.getChannel()     // Catch: java.lang.Throwable -> L49
            long r15 = r11.size()     // Catch: java.lang.Throwable -> L49
            java.nio.channels.FileChannel$MapMode r12 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L49
            r13 = 0
            java.nio.MappedByteBuffer r0 = r11.map(r12, r13, r15)     // Catch: java.lang.Throwable -> L49
            r10.close()     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            goto L56
        L49:
            r0 = move-exception
            r11 = r0
            r10.close()     // Catch: java.lang.Throwable -> L4f
            goto L54
        L4f:
            r0 = move-exception
            r10 = r0
            r11.addSuppressed(r10)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
        L54:
            throw r11     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
        L55:
            r0 = r1
        L56:
            r8.delete()
        L59:
            if (r0 != 0) goto L5c
            return r1
        L5c:
            int r8 = r7.mWeight
            boolean r10 = r7.mItalic
            int r7 = r7.mTtcIndex
            boolean r0 = addFontWeightStyle(r3, r0, r7, r8, r10)
            if (r0 != 0) goto L69
            return r1
        L69:
            int r6 = r6 + 1
            goto L16
        L6c:
            r0 = move-exception
            r8.delete()
            throw r0
        L71:
            java.lang.Class<?> r0 = androidx.core.graphics.TypefaceCompatApi24Impl.sFontFamily     // Catch: java.lang.Throwable -> L88
            r4 = 1
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r4)     // Catch: java.lang.Throwable -> L88
            java.lang.reflect.Array.set(r0, r2, r3)     // Catch: java.lang.Throwable -> L88
            java.lang.reflect.Method r2 = androidx.core.graphics.TypefaceCompatApi24Impl.sCreateFromFamiliesWithDefault     // Catch: java.lang.Throwable -> L88
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L88
            java.lang.Object r0 = r2.invoke(r1, r0)     // Catch: java.lang.Throwable -> L88
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0     // Catch: java.lang.Throwable -> L88
            r1 = r0
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi24Impl.createFromFontFamilyFilesResourceEntry(android.content.Context, androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry, android.content.res.Resources, int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int r13) {
        Object obj;
        Typeface typeface;
        try {
            obj = sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
            Uri uri = fontsContractCompat$FontInfo.mUri;
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.getOrDefault(uri, null);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.mmap(context, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (byteBuffer == null) {
                return null;
            }
            if (!addFontWeightStyle(obj, byteBuffer, fontsContractCompat$FontInfo.mTtcIndex, fontsContractCompat$FontInfo.mWeight, fontsContractCompat$FontInfo.mItalic)) {
                return null;
            }
        }
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            typeface = (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            typeface = null;
        }
        if (typeface == null) {
            return null;
        }
        return Typeface.create(typeface, r13);
    }
}

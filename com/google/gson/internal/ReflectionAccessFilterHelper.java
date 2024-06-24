package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class ReflectionAccessFilterHelper {

    /* loaded from: classes3.dex */
    public static abstract class AccessChecker {
        public static final AccessChecker INSTANCE;

        /* renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass2 extends AccessChecker {
            @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
            public final boolean canAccess(Object obj, AccessibleObject accessibleObject) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
        static {
            /*
                int r0 = com.google.gson.internal.JavaVersion.majorJavaVersion
                r1 = 9
                r2 = 1
                r3 = 0
                if (r0 < r1) goto La
                r0 = r2
                goto Lb
            La:
                r0 = r3
            Lb:
                if (r0 == 0) goto L21
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L21
                java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
                r2[r3] = r4     // Catch: java.lang.NoSuchMethodException -> L21
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L21
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1     // Catch: java.lang.NoSuchMethodException -> L21
                r1.<init>()     // Catch: java.lang.NoSuchMethodException -> L21
                goto L22
            L21:
                r1 = 0
            L22:
                if (r1 != 0) goto L29
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2
                r1.<init>()
            L29:
                com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.INSTANCE = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.<clinit>():void");
        }

        public abstract boolean canAccess(Object obj, AccessibleObject accessibleObject);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(Class cls, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult check = ((ReflectionAccessFilter) it.next()).check();
            if (check != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return check;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}

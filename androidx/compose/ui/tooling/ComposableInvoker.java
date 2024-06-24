package androidx.compose.ui.tooling;

import android.util.Log;
import androidx.compose.runtime.Composer;
import com.animaconnected.firebase.AnalyticsConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposableInvoker.kt */
/* loaded from: classes.dex */
public final class ComposableInvoker {
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be A[LOOP:2: B:32:0x0088->B:39:0x00be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method findComposableMethod(java.lang.Class r10, java.lang.String r11, java.lang.Object... r12) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:            if (r4 == false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003f, code lost:            if (kotlin.text.StringsKt__StringsJVMKt.startsWith(r4, r13 + '-', false) != false) goto L8;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0097, code lost:            r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0098, code lost:            if (r7 == false) goto L31;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class r12, java.lang.String r13, java.lang.Class... r14) {
        /*
            int r0 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r0)
            java.lang.Class[] r14 = (java.lang.Class[]) r14
            java.lang.reflect.Method[] r12 = r12.getDeclaredMethods()
            java.lang.String r0 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            int r0 = r12.length
            r1 = 0
            r2 = r1
        L13:
            if (r2 >= r0) goto L9f
            r3 = r12[r2]
            java.lang.String r4 = r3.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r4)
            if (r4 != 0) goto L41
            java.lang.String r4 = r3.getName()
            java.lang.String r5 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r13)
            r6 = 45
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith(r4, r5, r1)
            if (r4 == 0) goto L97
        L41:
            java.lang.Class[] r4 = r3.getParameterTypes()
            java.lang.String r5 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            int r5 = r4.length
            int r6 = r14.length
            r7 = 1
            if (r5 != r6) goto L93
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r4.length
            r5.<init>(r6)
            int r6 = r4.length
            r8 = r1
            r9 = r8
        L58:
            if (r8 >= r6) goto L6f
            r10 = r4[r8]
            int r11 = r9 + 1
            r9 = r14[r9]
            boolean r9 = r10.isAssignableFrom(r9)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r5.add(r9)
            int r8 = r8 + 1
            r9 = r11
            goto L58
        L6f:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L76
            goto L8e
        L76:
            java.util.Iterator r4 = r5.iterator()
        L7a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L8e
            java.lang.Object r5 = r4.next()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L7a
            r4 = r1
            goto L8f
        L8e:
            r4 = r7
        L8f:
            if (r4 == 0) goto L93
            r4 = r7
            goto L94
        L93:
            r4 = r1
        L94:
            if (r4 == 0) goto L97
            goto L98
        L97:
            r7 = r1
        L98:
            if (r7 == 0) goto L9b
            goto La0
        L9b:
            int r2 = r2 + 1
            goto L13
        L9f:
            r3 = 0
        La0:
            if (r3 == 0) goto La3
            return r3
        La3:
            java.lang.NoSuchMethodException r12 = new java.lang.NoSuchMethodException
            java.lang.String r14 = " not found"
            java.lang.String r13 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r13, r14)
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Class<?> cls = Class.forName(className);
            Method findComposableMethod = findComposableMethod(cls, methodName, Arrays.copyOf(args, args.length));
            findComposableMethod.setAccessible(true);
            if (Modifier.isStatic(findComposableMethod.getModifiers())) {
                invokeComposableMethod(findComposableMethod, null, composer, Arrays.copyOf(args, args.length));
            } else {
                invokeComposableMethod(findComposableMethod, cls.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(args, args.length));
            }
        } catch (ReflectiveOperationException e) {
            String message = "Failed to invoke Composable Method '" + className + '.' + methodName + '\'';
            Intrinsics.checkNotNullParameter(message, "message");
            Log.w("PreviewLogger", message, null);
            throw e;
        }
    }

    public static void invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        int r4;
        int ceil;
        boolean z;
        int r7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj2;
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int r3 = length - 1;
                if (Intrinsics.areEqual(parameterTypes[length], Composer.class)) {
                    break;
                } else if (r3 < 0) {
                    break;
                } else {
                    length = r3;
                }
            }
        }
        length = -1;
        if (obj != null) {
            r4 = 1;
        } else {
            r4 = 0;
        }
        if (length == 0) {
            ceil = 1;
        } else {
            ceil = (int) Math.ceil((r4 + length) / 10.0d);
        }
        int r5 = length + 1;
        int r42 = ceil + r5;
        int length2 = method.getParameterTypes().length;
        if (length2 != r42) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            r7 = (int) Math.ceil(length / 31.0d);
        } else {
            r7 = 0;
        }
        if (r7 + r42 == length2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Object[] objArr2 = new Object[length2];
            for (int r8 = 0; r8 < length2; r8++) {
                if (r8 >= 0 && r8 < length) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (r8 >= 0) {
                        Intrinsics.checkNotNullParameter(objArr, "<this>");
                        if (r8 <= objArr.length - 1) {
                            obj2 = objArr[r8];
                        }
                    }
                    Class<?> cls = method.getParameterTypes()[r8];
                    Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                    String name = cls.getName();
                    switch (name.hashCode()) {
                        case -1325958191:
                            if (name.equals(AnalyticsConstants.KEY_DOUBLE)) {
                                obj2 = Double.valueOf(0.0d);
                                break;
                            }
                            break;
                        case 104431:
                            if (name.equals("int")) {
                                obj2 = 0;
                                break;
                            }
                            break;
                        case 3039496:
                            if (name.equals("byte")) {
                                obj2 = (byte) 0;
                                break;
                            }
                            break;
                        case 3052374:
                            if (name.equals("char")) {
                                obj2 = (char) 0;
                                break;
                            }
                            break;
                        case 3327612:
                            if (name.equals("long")) {
                                obj2 = 0L;
                                break;
                            }
                            break;
                        case 64711720:
                            if (name.equals("boolean")) {
                                obj2 = Boolean.FALSE;
                                break;
                            }
                            break;
                        case 97526364:
                            if (name.equals("float")) {
                                obj2 = Float.valueOf(0.0f);
                                break;
                            }
                            break;
                        case 109413500:
                            if (name.equals("short")) {
                                obj2 = (short) 0;
                                break;
                            }
                            break;
                    }
                    obj2 = null;
                } else if (r8 == length) {
                    obj2 = composer;
                } else {
                    if (r5 <= r8 && r8 < r42) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        obj2 = 0;
                    } else {
                        if (r42 <= r8 && r8 < length2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            obj2 = 2097151;
                        } else {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                    }
                }
                objArr2[r8] = obj2;
            }
            method.invoke(obj, Arrays.copyOf(objArr2, length2));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}

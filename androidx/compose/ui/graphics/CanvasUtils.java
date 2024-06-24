package androidx.compose.ui.graphics;

import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CanvasUtils.android.kt */
/* loaded from: classes.dex */
public final class CanvasUtils {
    public static Method inorderBarrierMethod;
    public static boolean orderMethodsFetched;
    public static Method reorderBarrierMethod;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void enableZ(android.graphics.Canvas canvas, boolean z) {
        Method method;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) {
            CanvasZHelper.INSTANCE.enableZ(canvas, z);
            return;
        }
        if (!orderMethodsFetched) {
            try {
                if (r0 == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    reorderBarrierMethod = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertReorderBarrier", new Class[0]);
                    inorderBarrierMethod = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    reorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    inorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                }
                Method method2 = reorderBarrierMethod;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = inorderBarrierMethod;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            orderMethodsFetched = true;
        }
        if (z) {
            try {
                Method method4 = reorderBarrierMethod;
                if (method4 != null) {
                    method4.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (!z && (method = inorderBarrierMethod) != null) {
            method.invoke(canvas, new Object[0]);
        }
    }
}

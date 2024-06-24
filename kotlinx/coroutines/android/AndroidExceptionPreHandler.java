package kotlinx.coroutines.android;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: AndroidExceptionPreHandler.kt */
/* loaded from: classes4.dex */
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
        this._preHandler = this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:            if (java.lang.reflect.Modifier.isStatic(r6.getModifiers()) != false) goto L18;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:            if (r1 != false) goto L21;     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleException(kotlin.coroutines.CoroutineContext r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            r1 = 1
            r2 = 0
            if (r0 > r6) goto Le
            r0 = 28
            if (r6 >= r0) goto Le
            r6 = r1
            goto Lf
        Le:
            r6 = r2
        Lf:
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5._preHandler
            r0 = 0
            if (r6 == r5) goto L19
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            goto L3f
        L19:
            java.lang.Class<java.lang.Thread> r6 = java.lang.Thread.class
            java.lang.String r3 = "getUncaughtExceptionPreHandler"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L3c
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L3c
            int r3 = r6.getModifiers()     // Catch: java.lang.Throwable -> L3c
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L38
            int r3 = r6.getModifiers()     // Catch: java.lang.Throwable -> L3c
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L38
            goto L39
        L38:
            r1 = r2
        L39:
            if (r1 == 0) goto L3c
            goto L3d
        L3c:
            r6 = r0
        L3d:
            r5._preHandler = r6
        L3f:
            if (r6 == 0) goto L48
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Object r6 = r6.invoke(r0, r1)
            goto L49
        L48:
            r6 = r0
        L49:
            boolean r1 = r6 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r1 == 0) goto L50
            r0 = r6
            java.lang.Thread$UncaughtExceptionHandler r0 = (java.lang.Thread.UncaughtExceptionHandler) r0
        L50:
            if (r0 == 0) goto L59
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r0.uncaughtException(r6, r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.android.AndroidExceptionPreHandler.handleException(kotlin.coroutines.CoroutineContext, java.lang.Throwable):void");
    }
}

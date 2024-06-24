package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes4.dex */
public class Platform {
    public static final Platform PLATFORM;
    public final boolean hasJava8Types = true;
    public final Constructor<MethodHandles.Lookup> lookupConstructor;

    /* loaded from: classes4.dex */
    public static final class Android extends Platform {

        /* loaded from: classes4.dex */
        public static final class MainThreadExecutor implements Executor {
            public final Handler handler = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        @Override // retrofit2.Platform
        public final Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        public final Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.invokeDefaultMethod(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    static {
        Platform platform;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            platform = new Android();
        } else {
            platform = new Platform();
        }
        PLATFORM = platform;
    }

    public Platform() {
        Constructor<MethodHandles.Lookup> constructor;
        try {
            constructor = Platform$$ExternalSyntheticApiModelOutline0.m().getDeclaredConstructor(Class.class, Integer.TYPE);
            try {
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        } catch (NoClassDefFoundError | NoSuchMethodException unused2) {
            constructor = null;
        }
        this.lookupConstructor = constructor;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    @IgnoreJRERequirement
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandles.Lookup lookup;
        MethodHandle unreflectSpecial;
        MethodHandle bindTo;
        Object invokeWithArguments;
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        if (constructor == null) {
            lookup = MethodHandles.lookup();
        } else {
            lookup = Platform$$ExternalSyntheticApiModelOutline1.m(constructor.newInstance(cls, -1));
        }
        unreflectSpecial = lookup.unreflectSpecial(method, cls);
        bindTo = unreflectSpecial.bindTo(obj);
        invokeWithArguments = bindTo.invokeWithArguments(objArr);
        return invokeWithArguments;
    }
}

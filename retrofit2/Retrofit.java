package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes4.dex */
public final class Retrofit {
    public final HttpUrl baseUrl;
    public final List<CallAdapter.Factory> callAdapterFactories;
    public final Call.Factory callFactory;
    public final List<Converter.Factory> converterFactories;
    public final ConcurrentHashMap serviceMethodCache = new ConcurrentHashMap();
    public final boolean validateEagerly = false;

    /* loaded from: classes4.dex */
    public static final class Builder {
        public HttpUrl baseUrl;
        public final ArrayList callAdapterFactories;
        public Call.Factory callFactory;
        public final ArrayList converterFactories;
        public final Platform platform;

        public Builder() {
            Platform platform = Platform.PLATFORM;
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = platform;
        }

        public final void baseUrl(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.parse$okhttp(null, str);
            HttpUrl build = builder.build();
            if ("".equals(build.pathSegments.get(r0.size() - 1))) {
                this.baseUrl = build;
            } else {
                throw new IllegalArgumentException("baseUrl must end in /: " + build);
            }
        }

        public final Retrofit build() {
            List singletonList;
            List emptyList;
            if (this.baseUrl != null) {
                Call.Factory factory = this.callFactory;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Platform platform = this.platform;
                Executor defaultCallbackExecutor = platform.defaultCallbackExecutor();
                ArrayList arrayList = new ArrayList(this.callAdapterFactories);
                DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(defaultCallbackExecutor);
                boolean z = platform.hasJava8Types;
                if (z) {
                    singletonList = Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory);
                } else {
                    singletonList = Collections.singletonList(defaultCallAdapterFactory);
                }
                arrayList.addAll(singletonList);
                ArrayList arrayList2 = this.converterFactories;
                ArrayList arrayList3 = new ArrayList(arrayList2.size() + 1 + (z ? 1 : 0));
                arrayList3.add(new BuiltInConverters());
                arrayList3.addAll(arrayList2);
                if (z) {
                    emptyList = Collections.singletonList(OptionalConverterFactory.INSTANCE);
                } else {
                    emptyList = Collections.emptyList();
                }
                arrayList3.addAll(emptyList);
                return new Retrofit(factory, this.baseUrl, Collections.unmodifiableList(arrayList3), Collections.unmodifiableList(arrayList));
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    public Retrofit(Call.Factory factory, HttpUrl httpUrl, List list, List list2) {
        this.callFactory = factory;
        this.baseUrl = httpUrl;
        this.converterFactories = list;
        this.callAdapterFactories = list2;
    }

    public final CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List<CallAdapter.Factory> list = this.callAdapterFactories;
        int indexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int r3 = indexOf; r3 < size; r3++) {
            CallAdapter<?, ?> callAdapter = list.get(r3).get(type, annotationArr);
            if (callAdapter != null) {
                return callAdapter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(list.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final <T> T create(final Class<T> cls) {
        boolean z;
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<T> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls2.getName());
                    if (cls2 != cls) {
                        sb.append(" which is an interface of ");
                        sb.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.validateEagerly) {
                Platform platform = Platform.PLATFORM;
                for (Method method : cls.getDeclaredMethods()) {
                    if (platform.hasJava8Types && method.isDefault()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z && !Modifier.isStatic(method.getModifiers())) {
                        loadServiceMethod(method);
                    }
                }
            }
            return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1
                public final Platform platform = Platform.PLATFORM;
                public final Object[] emptyArgs = new Object[0];

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                    boolean z2;
                    if (method2.getDeclaringClass() == Object.class) {
                        return method2.invoke(this, objArr);
                    }
                    if (objArr == null) {
                        objArr = this.emptyArgs;
                    }
                    Platform platform2 = this.platform;
                    if (platform2.hasJava8Types && method2.isDefault()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return platform2.invokeDefaultMethod(method2, cls, obj, objArr);
                    }
                    return Retrofit.this.loadServiceMethod(method2).invoke(objArr);
                }
            });
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public final ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> serviceMethod;
        ServiceMethod<?> serviceMethod2 = (ServiceMethod) this.serviceMethodCache.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.serviceMethodCache) {
            serviceMethod = (ServiceMethod) this.serviceMethodCache.get(method);
            if (serviceMethod == null) {
                serviceMethod = ServiceMethod.parseAnnotations(this, method);
                this.serviceMethodCache.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    public final <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List<Converter.Factory> list = this.converterFactories;
        int indexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int r2 = indexOf; r2 < size; r2++) {
            Converter<T, RequestBody> requestBodyConverter = list.get(r2).requestBodyConverter(type, annotationArr);
            if (requestBodyConverter != null) {
                return requestBodyConverter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(list.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List<Converter.Factory> list = this.converterFactories;
        int indexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int r3 = indexOf; r3 < size; r3++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) list.get(r3).responseBodyConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = list.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(list.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final void stringConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        List<Converter.Factory> list = this.converterFactories;
        int size = list.size();
        for (int r0 = 0; r0 < size; r0++) {
            list.get(r0).getClass();
        }
    }
}

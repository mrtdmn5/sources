package retrofit2;

import java.lang.annotation.Annotation;

/* loaded from: classes4.dex */
public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    public static final SkipCallbackExecutorImpl INSTANCE = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }
}

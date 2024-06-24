package kotlin.reflect;

/* compiled from: KClass.kt */
/* loaded from: classes.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    String getSimpleName();

    boolean isInstance(Object obj);
}

package aws.smithy.kotlin.runtime.retries.policy;

import java.lang.Throwable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.reflect.KClass;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public final class EvaluationStrategy<T extends Throwable> {
    public final KClass<T> clazz;
    public final Function1<T, RetryDirective> evaluator;

    public EvaluationStrategy(ClassReference classReference, Function1 function1) {
        this.clazz = classReference;
        this.evaluator = function1;
    }
}

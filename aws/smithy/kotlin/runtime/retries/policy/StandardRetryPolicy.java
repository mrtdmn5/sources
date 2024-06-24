package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import java.util.Iterator;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public class StandardRetryPolicy implements RetryPolicy<Object> {
    public static final StandardRetryPolicy Default = new StandardRetryPolicy();
    public final Sequence<EvaluationStrategy<? extends Throwable>> evaluationStrategies = SequencesKt__SequencesKt.sequenceOf(new EvaluationStrategy(Reflection.getOrCreateKotlinClass(Throwable.class), new StandardRetryPolicy$evaluationStrategies$1(this)), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(SdkBaseException.class), new StandardRetryPolicy$evaluationStrategies$2(this)), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(ServiceException.class), new StandardRetryPolicy$evaluationStrategies$3(this)), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(ClientException.class), new StandardRetryPolicy$evaluationStrategies$4(this)), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(Throwable.class), new StandardRetryPolicy$evaluationStrategies$5(this)));

    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public final RetryDirective evaluate(Object obj) {
        RetryDirective retryDirective;
        Throwable th;
        if (!(obj instanceof Result.Failure)) {
            return RetryDirective.TerminateAndSucceed.INSTANCE;
        }
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(m1661exceptionOrNullimpl);
        Iterator<EvaluationStrategy<? extends Throwable>> it = this.evaluationStrategies.iterator();
        do {
            retryDirective = null;
            if (!it.hasNext()) {
                break;
            }
            EvaluationStrategy<? extends Throwable> next = it.next();
            next.getClass();
            KClass<? extends Throwable> kClass = next.clazz;
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            if (kClass.isInstance(m1661exceptionOrNullimpl)) {
                th = m1661exceptionOrNullimpl;
            } else {
                th = null;
            }
            if (th != null) {
                retryDirective = next.evaluator.invoke(th);
            }
        } while (retryDirective == null);
        RetryDirective retryDirective2 = retryDirective;
        if (retryDirective2 == null) {
            return RetryDirective.TerminateAndFail.INSTANCE;
        }
        return retryDirective2;
    }

    public RetryDirective evaluateSpecificExceptions(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        return null;
    }
}

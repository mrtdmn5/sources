package aws.smithy.kotlin.runtime.operation;

import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.Attributes;
import aws.smithy.kotlin.runtime.util.AttributesImpl;
import java.util.Set;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* compiled from: ExecutionContext.kt */
/* loaded from: classes.dex */
public final class ExecutionContext implements Attributes, CoroutineScope {
    public final /* synthetic */ Attributes $$delegate_0;
    public final JobImpl coroutineContext;

    /* compiled from: ExecutionContext.kt */
    /* loaded from: classes.dex */
    public static final class ExecutionContextBuilder {
        public Attributes attributes;

        public ExecutionContextBuilder() {
            int r0 = Attributes.$r8$clinit;
            this.attributes = new AttributesImpl();
        }
    }

    public ExecutionContext(ExecutionContextBuilder executionContextBuilder) {
        this.$$delegate_0 = executionContextBuilder.attributes;
        this.coroutineContext = JobKt.Job$default();
        Attributes attributes = executionContextBuilder.attributes;
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.$$delegate_0.contains(key);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final Set<AttributeKey<?>> getKeys() {
        return this.$$delegate_0.getKeys();
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.$$delegate_0.getOrNull(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void remove(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.$$delegate_0.remove(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.$$delegate_0.set(key, value);
    }

    public ExecutionContext() {
        this(new ExecutionContextBuilder());
    }
}

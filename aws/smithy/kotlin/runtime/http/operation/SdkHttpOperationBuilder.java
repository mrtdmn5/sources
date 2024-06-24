package aws.smithy.kotlin.runtime.http.operation;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.Attributes;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: SdkHttpOperation.kt */
/* loaded from: classes.dex */
public final class SdkHttpOperationBuilder<I, O> {
    public HttpDeserialize<O> deserializer;
    public final KClass<?> inputType;
    public final KClass<?> outputType;
    public HttpSerialize<I> serializer;
    public final SdkOperationExecution<I, O> execution = new SdkOperationExecution<>();
    public final HttpOperationContext.Builder context = new HttpOperationContext.Builder();

    public SdkHttpOperationBuilder(ClassReference classReference, ClassReference classReference2) {
        this.inputType = classReference;
        this.outputType = classReference2;
    }

    public final SdkHttpOperation<I, O> build() {
        HttpSerialize<I> httpSerialize = this.serializer;
        if (httpSerialize != null) {
            HttpDeserialize<O> httpDeserialize = this.deserializer;
            if (httpDeserialize != null) {
                OperationTypeInfo operationTypeInfo = new OperationTypeInfo(this.inputType, this.outputType);
                SdkOperationExecution<I, O> sdkOperationExecution = this.execution;
                final HttpOperationContext.Builder builder = this.context;
                for (AttributeKey<?> attributeKey : builder.requiredKeys) {
                    if (!builder.options.contains(attributeKey)) {
                        throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("ClientOptionsBuilder: "), attributeKey.name, " is a required property"));
                    }
                }
                Function1<ExecutionContext.ExecutionContextBuilder, Unit> function1 = new Function1<ExecutionContext.ExecutionContextBuilder, Unit>() { // from class: aws.smithy.kotlin.runtime.client.ClientOptionsBuilder$build$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ExecutionContext.ExecutionContextBuilder executionContextBuilder) {
                        ExecutionContext.ExecutionContextBuilder build = executionContextBuilder;
                        Intrinsics.checkNotNullParameter(build, "$this$build");
                        Attributes attributes = builder.options;
                        Intrinsics.checkNotNullParameter(attributes, "<set-?>");
                        build.attributes = attributes;
                        return Unit.INSTANCE;
                    }
                };
                ExecutionContext.ExecutionContextBuilder executionContextBuilder = new ExecutionContext.ExecutionContextBuilder();
                function1.invoke(executionContextBuilder);
                return new SdkHttpOperation<>(sdkOperationExecution, new ExecutionContext(executionContextBuilder), httpSerialize, httpDeserialize, operationTypeInfo);
            }
            throw new IllegalArgumentException("SdkHttpOperation.deserializer must not be null".toString());
        }
        throw new IllegalArgumentException("SdkHttpOperation.serializer must not be null".toString());
    }
}

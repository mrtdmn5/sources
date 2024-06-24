package aws.smithy.kotlin.runtime.http.operation;

import androidx.compose.ui.semantics.SemanticsPropertiesKt$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.client.ClientOptionsBuilder;
import aws.smithy.kotlin.runtime.client.DelegatedClientOption;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.Attributes;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.List;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KProperty;

/* compiled from: HttpOperationContext.kt */
/* loaded from: classes.dex */
public final class HttpOperationContext {
    public static final AttributeKey<Integer> ExpectedHttpStatus = new AttributeKey<>("ExpectedHttpStatus");
    public static final AttributeKey<String> HostPrefix = new AttributeKey<>("HostPrefix");
    public static final AttributeKey<List<HttpCall>> HttpCallList = new AttributeKey<>("HttpCallList");
    public static final AttributeKey<String> SdkRequestId = new AttributeKey<>("SdkRequestId");

    /* compiled from: HttpOperationContext.kt */
    /* loaded from: classes.dex */
    public static class Builder extends ClientOptionsBuilder {
        public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        public final DelegatedClientOption expectedHttpStatus$delegate;
        public final DelegatedClientOption operationName$delegate;
        public final DelegatedClientOption service$delegate;

        static {
            MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(Builder.class, AnalyticsConstants.KEY_SERVICE, "getService()Ljava/lang/String;", 0);
            ReflectionFactory reflectionFactory = Reflection.factory;
            reflectionFactory.getClass();
            $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(Builder.class, "operationName", "getOperationName()Ljava/lang/String;", 0, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(Builder.class, "expectedHttpStatus", "getExpectedHttpStatus()Ljava/lang/Integer;", 0, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(Builder.class, "hostPrefix", "getHostPrefix()Ljava/lang/String;", 0, reflectionFactory)};
        }

        public Builder() {
            AttributeKey key = SetsKt__SetsKt.ServiceName;
            Intrinsics.checkNotNullParameter(key, "key");
            this.requiredKeys.add(key);
            this.service$delegate = new DelegatedClientOption(key, this.options);
            AttributeKey key2 = SetsKt__SetsKt.OperationName;
            Intrinsics.checkNotNullParameter(key2, "key");
            this.requiredKeys.add(key2);
            this.operationName$delegate = new DelegatedClientOption(key2, this.options);
            AttributeKey<Integer> key3 = HttpOperationContext.ExpectedHttpStatus;
            Intrinsics.checkNotNullParameter(key3, "key");
            this.expectedHttpStatus$delegate = new DelegatedClientOption(key3, this.options);
            Intrinsics.checkNotNullParameter(HttpOperationContext.HostPrefix, "key");
            Attributes into = this.options;
            Intrinsics.checkNotNullParameter(into, "into");
        }

        public final void setExpectedHttpStatus(Integer num) {
            this.expectedHttpStatus$delegate.setValue(this, $$delegatedProperties[2], num);
        }

        public final void setOperationName(String str) {
            this.operationName$delegate.setValue(this, $$delegatedProperties[1], str);
        }

        public final void setService(String str) {
            this.service$delegate.setValue(this, $$delegatedProperties[0], str);
        }
    }
}

package aws.smithy.kotlin.runtime.serde;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: SdkObjectDescriptor.kt */
/* loaded from: classes.dex */
public final class SdkObjectDescriptor extends SdkFieldDescriptor {
    public final ArrayList fields;

    /* compiled from: SdkObjectDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public final ArrayList fields = new ArrayList();
        public final LinkedHashSet traits = new LinkedHashSet();

        public final void field(SdkFieldDescriptor sdkFieldDescriptor) {
            ArrayList arrayList = this.fields;
            sdkFieldDescriptor.index = arrayList.size();
            arrayList.add(sdkFieldDescriptor);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SdkObjectDescriptor(aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor.Builder r4) {
        /*
            r3 = this;
            aws.smithy.kotlin.runtime.serde.SerialKind$Struct r0 = aws.smithy.kotlin.runtime.serde.SerialKind.Struct.INSTANCE
            java.util.LinkedHashSet r1 = r4.traits
            java.lang.String r2 = "kind"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "traits"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r3.<init>(r0, r1)
            java.util.ArrayList r4 = r4.fields
            r3.fields = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor.<init>(aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor$Builder):void");
    }
}

package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: JsonFieldTraits.kt */
/* loaded from: classes.dex */
public final class JsonFieldTraitsKt {
    public static final String getSerialName(SdkFieldDescriptor sdkFieldDescriptor) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.traits.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FieldTrait) obj).getClass() == JsonSerialName.class) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) obj;
        if (fieldTrait != null) {
            return ((JsonSerialName) fieldTrait).name;
        }
        throw new IllegalArgumentException(("Expected to find trait " + Reflection.getOrCreateKotlinClass(JsonSerialName.class) + " in " + sdkFieldDescriptor + " but was not present.").toString());
    }
}

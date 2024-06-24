package aws.smithy.kotlin.runtime.serde.json;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonFieldTraits.kt */
/* loaded from: classes.dex */
public final class JsonSerialName implements FieldTrait {
    public final String name;

    public JsonSerialName(String str) {
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof JsonSerialName) && Intrinsics.areEqual(this.name, ((JsonSerialName) obj).name)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("JsonSerialName(name="), this.name, ')');
    }
}

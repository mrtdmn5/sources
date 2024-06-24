package aws.smithy.kotlin.runtime.serde.json;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonToken.kt */
/* loaded from: classes.dex */
public abstract class JsonToken {

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class BeginArray extends JsonToken {
        public static final BeginArray INSTANCE = new BeginArray();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class BeginObject extends JsonToken {
        public static final BeginObject INSTANCE = new BeginObject();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class Bool extends JsonToken {
        public final boolean value;

        public Bool(boolean z) {
            this.value = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Bool) && this.value == ((Bool) obj).value) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public final java.lang.String toString() {
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("Bool(value="), this.value, ')');
        }
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class EndArray extends JsonToken {
        public static final EndArray INSTANCE = new EndArray();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class EndDocument extends JsonToken {
        public static final EndDocument INSTANCE = new EndDocument();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class EndObject extends JsonToken {
        public static final EndObject INSTANCE = new EndObject();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class Name extends JsonToken {
        public final java.lang.String value;

        public Name(java.lang.String str) {
            this.value = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Name) && Intrinsics.areEqual(this.value, ((Name) obj).value)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public final java.lang.String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Name(value="), this.value, ')');
        }
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class Null extends JsonToken {
        public static final Null INSTANCE = new Null();
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class Number extends JsonToken {
        public final java.lang.String value;

        public Number(java.lang.String str) {
            this.value = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Number) && Intrinsics.areEqual(this.value, ((Number) obj).value)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public final java.lang.String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Number(value="), this.value, ')');
        }
    }

    /* compiled from: JsonToken.kt */
    /* loaded from: classes.dex */
    public static final class String extends JsonToken {
        public final java.lang.String value;

        public String(java.lang.String str) {
            this.value = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof String) && Intrinsics.areEqual(this.value, ((String) obj).value)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public final java.lang.String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("String(value="), this.value, ')');
        }
    }

    public java.lang.String toString() {
        if (Intrinsics.areEqual(this, BeginArray.INSTANCE)) {
            return "BeginArray";
        }
        if (Intrinsics.areEqual(this, EndArray.INSTANCE)) {
            return "EndArray";
        }
        if (Intrinsics.areEqual(this, BeginObject.INSTANCE)) {
            return "BeginObject";
        }
        if (Intrinsics.areEqual(this, EndObject.INSTANCE)) {
            return "EndObject";
        }
        if (this instanceof Name) {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Name("), ((Name) this).value, ')');
        }
        if (this instanceof String) {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("String("), ((String) this).value, ')');
        }
        if (this instanceof Number) {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Number("), ((Number) this).value, ')');
        }
        if (this instanceof Bool) {
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("Bool("), ((Bool) this).value, ')');
        }
        if (Intrinsics.areEqual(this, Null.INSTANCE)) {
            return "Null";
        }
        if (Intrinsics.areEqual(this, EndDocument.INSTANCE)) {
            return "EndDocument";
        }
        throw new NoWhenBranchMatchedException();
    }
}

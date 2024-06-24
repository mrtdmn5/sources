package kotlin.jvm.internal;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int r8, Class cls, String str, String str2, int r12) {
        this(r8, CallableReference.NO_RECEIVER, cls, str, str2, r12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics.areEqual(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            Reflection.factory.getClass();
            return new PackageReference(cls);
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        int r0;
        int r1;
        Object obj = this.receiver;
        int r12 = 0;
        if (obj != null) {
            r0 = obj.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        Class cls = this.owner;
        if (cls != null) {
            r12 = cls.hashCode();
        }
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.signature, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, (r02 + r12) * 31, 31), 31);
        if (this.isTopLevel) {
            r1 = 1231;
        } else {
            r1 = 1237;
        }
        return ((((m + r1) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        Reflection.factory.getClass();
        return ReflectionFactory.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int r1, Object obj, Class cls, String str, String str2, int r6) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (r6 & 1) == 1;
        this.arity = r1;
        this.flags = r6 >> 1;
    }
}

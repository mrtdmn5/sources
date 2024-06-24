package kotlinx.serialization.json.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: JsonPath.kt */
/* loaded from: classes4.dex */
public final class JsonPath {
    public int currentDepth;
    public Object[] currentObjectPath = new Object[8];
    public int[] indicies;

    /* compiled from: JsonPath.kt */
    /* loaded from: classes4.dex */
    public static final class Tombstone {
        public static final Tombstone INSTANCE = new Tombstone();
    }

    public JsonPath() {
        int[] r1 = new int[8];
        for (int r2 = 0; r2 < 8; r2++) {
            r1[r2] = -1;
        }
        this.indicies = r1;
        this.currentDepth = -1;
    }

    public final String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int r1 = this.currentDepth + 1;
        for (int r2 = 0; r2 < r1; r2++) {
            Object obj = this.currentObjectPath[r2];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.LIST.INSTANCE)) {
                    if (this.indicies[r2] != -1) {
                        sb.append("[");
                        sb.append(this.indicies[r2]);
                        sb.append("]");
                    }
                } else {
                    int r4 = this.indicies[r2];
                    if (r4 >= 0) {
                        sb.append(InstructionFileId.DOT);
                        sb.append(serialDescriptor.getElementName(r4));
                    }
                }
            } else if (obj != Tombstone.INSTANCE) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void resize() {
        int r0 = this.currentDepth * 2;
        Object[] copyOf = Arrays.copyOf(this.currentObjectPath, r0);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.currentObjectPath = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.indicies, r0);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.indicies = copyOf2;
    }

    public final String toString() {
        return getPath();
    }
}

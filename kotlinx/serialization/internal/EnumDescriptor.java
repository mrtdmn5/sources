package kotlinx.serialization.internal;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt$elementNames$1$1;
import kotlinx.serialization.descriptors.SerialDescriptorKt$special$$inlined$Iterable$2;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: Enums.kt */
/* loaded from: classes4.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    public final SynchronizedLazyImpl elementDescriptors$delegate;
    public final SerialKind.ENUM kind;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int r3) {
        super(name, null, r3);
        Intrinsics.checkNotNullParameter(name, "name");
        this.kind = SerialKind.ENUM.INSTANCE;
        this.elementDescriptors$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor[] invoke() {
                int r0 = r3;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[r0];
                for (int r32 = 0; r32 < r0; r32++) {
                    serialDescriptorArr[r32] = SerialDescriptorsKt.buildSerialDescriptor(name + '.' + this.names[r32], StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE);
                }
                return serialDescriptorArr;
            }
        });
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (serialDescriptor.getKind() != SerialKind.ENUM.INSTANCE) {
            return false;
        }
        if (Intrinsics.areEqual(this.serialName, serialDescriptor.getSerialName()) && Intrinsics.areEqual(Platform_commonKt.cachedSerialNames(this), Platform_commonKt.cachedSerialNames(serialDescriptor))) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int r2) {
        return ((SerialDescriptor[]) this.elementDescriptors$delegate.getValue())[r2];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        int r3;
        int hashCode = this.serialName.hashCode();
        SerialDescriptorKt$elementNames$1$1 serialDescriptorKt$elementNames$1$1 = new SerialDescriptorKt$elementNames$1$1(this);
        int r2 = 1;
        while (serialDescriptorKt$elementNames$1$1.hasNext()) {
            int r22 = r2 * 31;
            String str = (String) serialDescriptorKt$elementNames$1$1.next();
            if (str != null) {
                r3 = str.hashCode();
            } else {
                r3 = 0;
            }
            r2 = r22 + r3;
        }
        return (hashCode * 31) + r2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(new SerialDescriptorKt$special$$inlined$Iterable$2(this), ", ", OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder(), this.serialName, '('), ")", null, 56);
    }
}

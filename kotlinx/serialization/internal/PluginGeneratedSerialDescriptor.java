package kotlinx.serialization.internal;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.JsonNames;

/* compiled from: PluginGeneratedSerialDescriptor.kt */
/* loaded from: classes4.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    public final Lazy _hashCode$delegate;
    public int added;
    public final Lazy childSerializers$delegate;
    public final int elementsCount;
    public final boolean[] elementsOptionality;
    public final GeneratedSerializer<?> generatedSerializer;
    public Map<String, Integer> indices;
    public final String[] names;
    public final List<Annotation>[] propertiesAnnotations;
    public final String serialName;
    public final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer<?> generatedSerializer, int r4) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = r4;
        this.added = -1;
        String[] strArr = new String[r4];
        for (int r3 = 0; r3 < r4; r3++) {
            strArr[r3] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int r2 = this.elementsCount;
        this.propertiesAnnotations = new List[r2];
        this.elementsOptionality = new boolean[r2];
        this.indices = EmptyMap.INSTANCE;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.childSerializers$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<KSerializer<?>[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<?>[] invoke() {
                KSerializer<?>[] childSerializers;
                GeneratedSerializer<?> generatedSerializer2 = PluginGeneratedSerialDescriptor.this.generatedSerializer;
                if (generatedSerializer2 == null || (childSerializers = generatedSerializer2.childSerializers()) == null) {
                    return Preconditions.EMPTY_SERIALIZER_ARRAY;
                }
                return childSerializers;
            }
        });
        this.typeParameterDescriptors$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$typeParameterDescriptors$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor[] invoke() {
                ArrayList arrayList;
                KSerializer<?>[] typeParametersSerializers;
                GeneratedSerializer<?> generatedSerializer2 = PluginGeneratedSerialDescriptor.this.generatedSerializer;
                if (generatedSerializer2 != null && (typeParametersSerializers = generatedSerializer2.typeParametersSerializers()) != null) {
                    arrayList = new ArrayList(typeParametersSerializers.length);
                    for (KSerializer<?> kSerializer : typeParametersSerializers) {
                        arrayList.add(kSerializer.getDescriptor());
                    }
                } else {
                    arrayList = null;
                }
                return Platform_commonKt.compactArray(arrayList);
            }
        });
        this._hashCode$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<Integer>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$_hashCode$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                return Integer.valueOf(PluginGeneratedSerialDescriptorKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
            }
        });
    }

    public final void addElement(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        int r0 = this.added + 1;
        this.added = r0;
        String[] strArr = this.names;
        strArr[r0] = name;
        this.elementsOptionality[r0] = z;
        this.propertiesAnnotations[r0] = null;
        if (r0 == this.elementsCount - 1) {
            HashMap hashMap = new HashMap();
            int length = strArr.length;
            for (int r02 = 0; r02 < length; r02++) {
                hashMap.put(strArr[r02], Integer.valueOf(r02));
            }
            this.indices = hashMap;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PluginGeneratedSerialDescriptor)) {
                return false;
            }
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (!Intrinsics.areEqual(this.serialName, serialDescriptor.getSerialName()) || !Arrays.equals((SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue(), (SerialDescriptor[]) ((PluginGeneratedSerialDescriptor) obj).typeParameterDescriptors$delegate.getValue())) {
                return false;
            }
            int elementsCount = serialDescriptor.getElementsCount();
            int r2 = this.elementsCount;
            if (r2 != elementsCount) {
                return false;
            }
            for (int r6 = 0; r6 < r2; r6++) {
                if (!Intrinsics.areEqual(getElementDescriptor(r6).getSerialName(), serialDescriptor.getElementDescriptor(r6).getSerialName()) || !Intrinsics.areEqual(getElementDescriptor(r6).getKind(), serialDescriptor.getElementDescriptor(r6).getKind())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getAnnotations() {
        return EmptyList.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getElementAnnotations(int r2) {
        List<Annotation> list = this.propertiesAnnotations[r2];
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int r2) {
        return ((KSerializer[]) this.childSerializers$delegate.getValue())[r2].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.indices.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int r2) {
        return this.names[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return StructureKind.CLASS.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int r2) {
        return this.elementsOptionality[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return false;
    }

    public final void pushAnnotation(JsonNames jsonNames) {
        int r0 = this.added;
        List<Annotation>[] listArr = this.propertiesAnnotations;
        List<Annotation> list = listArr[r0];
        if (list == null) {
            list = new ArrayList<>(1);
            listArr[this.added] = list;
        }
        list.add(jsonNames);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(RangesKt___RangesKt.until(0, this.elementsCount), ", ", OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder(), this.serialName, '('), ")", new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$toString$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Integer num) {
                int intValue = num.intValue();
                StringBuilder sb = new StringBuilder();
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                sb.append(pluginGeneratedSerialDescriptor.names[intValue]);
                sb.append(": ");
                sb.append(pluginGeneratedSerialDescriptor.getElementDescriptor(intValue).getSerialName());
                return sb.toString();
            }
        }, 24);
    }
}

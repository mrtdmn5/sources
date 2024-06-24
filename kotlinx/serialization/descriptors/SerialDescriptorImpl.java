package kotlinx.serialization.descriptors;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import io.ktor.http.ContentTypesKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes4.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    public final SynchronizedLazyImpl _hashCode$delegate;
    public final List<Annotation> annotations;
    public final List<Annotation>[] elementAnnotations;
    public final SerialDescriptor[] elementDescriptors;
    public final String[] elementNames;
    public final boolean[] elementOptionality;
    public final int elementsCount;
    public final SerialKind kind;
    public final Map<String, Integer> name2Index;
    public final String serialName;
    public final HashSet serialNames;
    public final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int r5, List<? extends SerialDescriptor> list, ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = r5;
        this.annotations = classSerialDescriptorBuilder.annotations;
        ArrayList arrayList = classSerialDescriptorBuilder.elementNames;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        HashSet hashSet = new HashSet(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 12)));
        CollectionsKt___CollectionsKt.toCollection(arrayList, hashSet);
        this.serialNames = hashSet;
        int r52 = 0;
        this.elementNames = (String[]) arrayList.toArray(new String[0]);
        this.elementDescriptors = Platform_commonKt.compactArray(classSerialDescriptorBuilder.elementDescriptors);
        this.elementAnnotations = (List[]) classSerialDescriptorBuilder.elementAnnotations.toArray(new List[0]);
        ArrayList arrayList2 = classSerialDescriptorBuilder.elementOptionality;
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        boolean[] zArr = new boolean[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            zArr[r52] = ((Boolean) it.next()).booleanValue();
            r52++;
        }
        this.elementOptionality = zArr;
        final String[] strArr = this.elementNames;
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        IndexingIterable indexingIterable = new IndexingIterable(new Function0<Iterator<Object>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<Object> invoke() {
                return ContentTypesKt.iterator(strArr);
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it2 = indexingIterable.iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it2;
            if (indexingIterator.hasNext()) {
                IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                arrayList3.add(new Pair(indexedValue.value, Integer.valueOf(indexedValue.index)));
            } else {
                this.name2Index = MapsKt__MapsKt.toMap(arrayList3);
                this.typeParametersDescriptors = Platform_commonKt.compactArray(list);
                this._hashCode$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
                    }
                });
                return;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) obj).typeParametersDescriptors) && getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount = getElementsCount();
                for (int r1 = 0; r1 < elementsCount; r1++) {
                    if (Intrinsics.areEqual(getElementDescriptor(r1).getSerialName(), serialDescriptor.getElementDescriptor(r1).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(r1).getKind(), serialDescriptor.getElementDescriptor(r1).getKind())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getElementAnnotations(int r2) {
        return this.elementAnnotations[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int r2) {
        return this.elementDescriptors[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int r2) {
        return this.elementNames[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set<String> getSerialNames() {
        return this.serialNames;
    }

    public final int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int r2) {
        return this.elementOptionality[r2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return false;
    }

    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(RangesKt___RangesKt.until(0, this.elementsCount), ", ", OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder(), this.serialName, '('), ")", new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$toString$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Integer num) {
                int intValue = num.intValue();
                StringBuilder sb = new StringBuilder();
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                sb.append(serialDescriptorImpl.elementNames[intValue]);
                sb.append(": ");
                sb.append(serialDescriptorImpl.elementDescriptors[intValue].getSerialName());
                return sb.toString();
            }
        }, 24);
    }
}

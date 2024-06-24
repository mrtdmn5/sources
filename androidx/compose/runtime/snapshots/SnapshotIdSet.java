package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceBuilderIterator;

/* compiled from: SnapshotIdSet.kt */
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    public final int[] belowBound;
    public final int lowerBound;
    public final long lowerSet;
    public final long upperSet;

    public SnapshotIdSet(long j, long j2, int r5, int[] r6) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = r5;
        this.belowBound = r6;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        int[] r7;
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        int r6 = this.lowerBound;
        if (bits.lowerBound == r6 && bits.belowBound == (r7 = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet & (~bits.upperSet), (~bits.lowerSet) & this.lowerSet, r6, r7);
        }
        Iterator<Integer> it = bits.iterator();
        SnapshotIdSet snapshotIdSet2 = this;
        while (it.hasNext()) {
            snapshotIdSet2 = snapshotIdSet2.clear(it.next().intValue());
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet clear(int r19) {
        int[] r2;
        int binarySearch;
        int r6 = this.lowerBound;
        int r22 = r19 - r6;
        if (r22 >= 0 && r22 < 64) {
            long j = 1 << r22;
            long j2 = this.lowerSet;
            if ((j2 & j) != 0) {
                return new SnapshotIdSet(this.upperSet, j2 & (~j), r6, this.belowBound);
            }
        } else if (r22 >= 64 && r22 < 128) {
            long j3 = 1 << (r22 - 64);
            long j4 = this.upperSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet(j4 & (~j3), this.lowerSet, r6, this.belowBound);
            }
        } else if (r22 < 0 && (r2 = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(r2, r19)) >= 0) {
            int length = r2.length - 1;
            if (length == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] r4 = new int[length];
            if (binarySearch > 0) {
                ArraysKt___ArraysJvmKt.copyInto(0, 0, r2, r4, binarySearch);
            }
            if (binarySearch < length) {
                ArraysKt___ArraysJvmKt.copyInto(binarySearch, binarySearch + 1, r2, r4, length + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, r4);
        }
        return this;
    }

    public final boolean get(int r11) {
        int[] r0;
        int r02 = r11 - this.lowerBound;
        boolean z = true;
        if (r02 >= 0 && r02 < 64) {
            if (((1 << r02) & this.lowerSet) != 0) {
                return true;
            }
            return false;
        }
        if (r02 >= 64 && r02 < 128) {
            if (((1 << (r02 - 64)) & this.upperSet) != 0) {
                return true;
            }
            return false;
        }
        if (r02 > 0 || (r0 = this.belowBound) == null) {
            return false;
        }
        if (SnapshotIdSetKt.binarySearch(r0, r11) < 0) {
            z = false;
        }
        return z;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this, null);
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.nextStep = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(snapshotIdSet$iterator$1, sequenceBuilderIterator, sequenceBuilderIterator);
        return sequenceBuilderIterator;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        int[] r7;
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        int r6 = this.lowerBound;
        if (bits.lowerBound == r6 && bits.belowBound == (r7 = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, r6, r7);
        }
        if (this.belowBound == null) {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                bits = bits.set(it.next().intValue());
            }
            return bits;
        }
        Iterator<Integer> it2 = bits.iterator();
        SnapshotIdSet snapshotIdSet2 = this;
        while (it2.hasNext()) {
            snapshotIdSet2 = snapshotIdSet2.set(it2.next().intValue());
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet set(int r24) {
        long j;
        int r21;
        int r6 = this.lowerBound;
        int r2 = r24 - r6;
        long j2 = this.lowerSet;
        if (r2 >= 0 && r2 < 64) {
            long j3 = 1 << r2;
            if ((j2 & j3) == 0) {
                return new SnapshotIdSet(this.upperSet, j2 | j3, r6, this.belowBound);
            }
        } else {
            long j4 = this.upperSet;
            if (r2 >= 64 && r2 < 128) {
                long j5 = 1 << (r2 - 64);
                if ((j4 & j5) == 0) {
                    return new SnapshotIdSet(j4 | j5, j2, r6, this.belowBound);
                }
            } else {
                int[] r15 = this.belowBound;
                if (r2 >= 128) {
                    if (!get(r24)) {
                        int r22 = ((r24 + 1) / 64) * 64;
                        int r62 = this.lowerBound;
                        ArrayList arrayList = null;
                        long j6 = j4;
                        while (true) {
                            if (r62 < r22) {
                                if (j2 != 0) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                        if (r15 != null) {
                                            for (int r0 : r15) {
                                                arrayList.add(Integer.valueOf(r0));
                                            }
                                        }
                                    }
                                    for (int r11 = 0; r11 < 64; r11++) {
                                        if (((1 << r11) & j2) != 0) {
                                            arrayList.add(Integer.valueOf(r11 + r62));
                                        }
                                    }
                                }
                                if (j6 == 0) {
                                    r21 = r22;
                                    j = 0;
                                    break;
                                }
                                r62 += 64;
                                j2 = j6;
                                j6 = 0;
                            } else {
                                j = j2;
                                r21 = r62;
                                break;
                            }
                        }
                        if (arrayList != null) {
                            r15 = CollectionsKt___CollectionsKt.toIntArray(arrayList);
                        }
                        return new SnapshotIdSet(j6, j, r21, r15).set(r24);
                    }
                } else {
                    if (r15 == null) {
                        return new SnapshotIdSet(j4, j2, r6, new int[]{r24});
                    }
                    int binarySearch = SnapshotIdSetKt.binarySearch(r15, r24);
                    if (binarySearch < 0) {
                        int r23 = -(binarySearch + 1);
                        int length = r15.length + 1;
                        int[] r10 = new int[length];
                        ArraysKt___ArraysJvmKt.copyInto(0, 0, r15, r10, r23);
                        ArraysKt___ArraysJvmKt.copyInto(r23 + 1, r23, r15, r10, length - 1);
                        r10[r23] = r24;
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, r10);
                    }
                }
            }
        }
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(this, 10));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int size = arrayList.size();
        int r7 = 0;
        for (int r6 = 0; r6 < size; r6++) {
            Object obj = arrayList.get(r6);
            boolean z = true;
            r7++;
            if (r7 > 1) {
                sb2.append((CharSequence) ", ");
            }
            if (obj != null) {
                z = obj instanceof CharSequence;
            }
            if (z) {
                sb2.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb2.append(((Character) obj).charValue());
            } else {
                sb2.append((CharSequence) String.valueOf(obj));
            }
        }
        sb2.append((CharSequence) "");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "fastJoinTo(StringBuilder…form)\n        .toString()");
        sb.append(sb3);
        sb.append(']');
        return sb.toString();
    }
}

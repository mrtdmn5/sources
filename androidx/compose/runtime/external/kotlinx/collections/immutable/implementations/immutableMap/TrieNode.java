package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.JobKt;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: TrieNode.kt */
/* loaded from: classes.dex */
public final class TrieNode<K, V> {
    public static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0], null);
    public Object[] buffer;
    public int dataMap;
    public int nodeMap;
    public final JobKt ownedBy;

    /* compiled from: TrieNode.kt */
    /* loaded from: classes.dex */
    public static final class ModificationResult<K, V> {
        public TrieNode<K, V> node;
        public final int sizeDelta;

        public ModificationResult(TrieNode<K, V> node, int r3) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.sizeDelta = r3;
        }
    }

    public TrieNode(int r1, int r2, Object[] objArr, JobKt jobKt) {
        this.dataMap = r1;
        this.nodeMap = r2;
        this.ownedBy = jobKt;
        this.buffer = objArr;
    }

    public static TrieNode makeNode(int r12, Object obj, Object obj2, int r15, Object obj3, Object obj4, int r18, JobKt jobKt) {
        Object[] objArr;
        if (r18 > 30) {
            return new TrieNode(0, 0, new Object[]{obj, obj2, obj3, obj4}, jobKt);
        }
        int r10 = (r12 >> r18) & 31;
        int r3 = (r15 >> r18) & 31;
        if (r10 != r3) {
            if (r10 < r3) {
                objArr = new Object[]{obj, obj2, obj3, obj4};
            } else {
                objArr = new Object[]{obj3, obj4, obj, obj2};
            }
            return new TrieNode((1 << r10) | (1 << r3), 0, objArr, jobKt);
        }
        return new TrieNode(0, 1 << r10, new Object[]{makeNode(r12, obj, obj2, r15, obj3, obj4, r18 + 5, jobKt)}, jobKt);
    }

    public final Object[] bufferMoveEntryToNode(int r12, int r13, int r14, K k, V v, int r17, JobKt jobKt) {
        int r3;
        Object obj = this.buffer[r12];
        if (obj != null) {
            r3 = obj.hashCode();
        } else {
            r3 = 0;
        }
        TrieNode makeNode = makeNode(r3, obj, valueAtKeyIndex(r12), r14, k, v, r17 + 5, jobKt);
        int nodeIndex$runtime_release = nodeIndex$runtime_release(r13) + 1;
        Object[] objArr = this.buffer;
        int r6 = nodeIndex$runtime_release - 2;
        Object[] objArr2 = new Object[(objArr.length - 2) + 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r12, 6);
        ArraysKt___ArraysJvmKt.copyInto(r12, r12 + 2, nodeIndex$runtime_release, objArr, objArr2);
        objArr2[r6] = makeNode;
        ArraysKt___ArraysJvmKt.copyInto(r6 + 1, nodeIndex$runtime_release, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int bitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int r1 = bitCount * 2; r1 < length; r1++) {
            bitCount += nodeAtIndex$runtime_release(r1).calculateSize();
        }
        return bitCount;
    }

    public final boolean collisionContainsKey(K k) {
        IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int r2 = step.first;
        int r3 = step.last;
        int r0 = step.step;
        if ((r0 > 0 && r2 <= r3) || (r0 < 0 && r3 <= r2)) {
            while (!Intrinsics.areEqual(k, this.buffer[r2])) {
                if (r2 != r3) {
                    r2 += r0;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsKey(int r3, int r4, Object obj) {
        int r0 = 1 << ((r3 >> r4) & 31);
        if (hasEntryAt$runtime_release(r0)) {
            return Intrinsics.areEqual(obj, this.buffer[entryKeyIndex$runtime_release(r0)]);
        }
        if (hasNodeAt(r0)) {
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(r0));
            if (r4 == 30) {
                return nodeAtIndex$runtime_release.collisionContainsKey(obj);
            }
            return nodeAtIndex$runtime_release.containsKey(r3, r4 + 5, obj);
        }
        return false;
    }

    public final boolean elementsIdentityEquals(TrieNode<K, V> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap != trieNode.nodeMap || this.dataMap != trieNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int r2 = 0; r2 < length; r2++) {
            if (this.buffer[r2] != trieNode.buffer[r2]) {
                return false;
            }
        }
        return true;
    }

    public final int entryKeyIndex$runtime_release(int r2) {
        return Integer.bitCount((r2 - 1) & this.dataMap) * 2;
    }

    public final Object get(int r5, int r6, Object obj) {
        int r0 = 1 << ((r5 >> r6) & 31);
        if (hasEntryAt$runtime_release(r0)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r0);
            if (!Intrinsics.areEqual(obj, this.buffer[entryKeyIndex$runtime_release])) {
                return null;
            }
            return valueAtKeyIndex(entryKeyIndex$runtime_release);
        }
        if (!hasNodeAt(r0)) {
            return null;
        }
        TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(r0));
        if (r6 == 30) {
            IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, nodeAtIndex$runtime_release.buffer.length), 2);
            int r62 = step.first;
            int r1 = step.last;
            int r52 = step.step;
            if ((r52 <= 0 || r62 > r1) && (r52 >= 0 || r1 > r62)) {
                return null;
            }
            while (!Intrinsics.areEqual(obj, nodeAtIndex$runtime_release.buffer[r62])) {
                if (r62 == r1) {
                    return null;
                }
                r62 += r52;
            }
            return nodeAtIndex$runtime_release.valueAtKeyIndex(r62);
        }
        return nodeAtIndex$runtime_release.get(r5, r6 + 5, obj);
    }

    public final boolean hasEntryAt$runtime_release(int r2) {
        if ((r2 & this.dataMap) != 0) {
            return true;
        }
        return false;
    }

    public final boolean hasNodeAt(int r2) {
        if ((r2 & this.nodeMap) != 0) {
            return true;
        }
        return false;
    }

    public final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int r4, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.getClass();
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size - 1);
        persistentHashMapBuilder.operationResult = valueAtKeyIndex(r4);
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        if (this.ownedBy == persistentHashMapBuilder.ownership) {
            this.buffer = MessageFormatter.access$removeEntryAtIndex(r4, objArr);
            return this;
        }
        return new TrieNode<>(0, 0, MessageFormatter.access$removeEntryAtIndex(r4, objArr), persistentHashMapBuilder.ownership);
    }

    public final TrieNode<K, V> mutablePut(int r11, K k, V v, int r14, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> mutablePut;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int r0 = 1 << ((r11 >> r14) & 31);
        boolean hasEntryAt$runtime_release = hasEntryAt$runtime_release(r0);
        JobKt jobKt = this.ownedBy;
        if (hasEntryAt$runtime_release) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r0);
            if (Intrinsics.areEqual(k, this.buffer[entryKeyIndex$runtime_release])) {
                mutator.operationResult = valueAtKeyIndex(entryKeyIndex$runtime_release);
                if (valueAtKeyIndex(entryKeyIndex$runtime_release) == v) {
                    return this;
                }
                if (jobKt == mutator.ownership) {
                    this.buffer[entryKeyIndex$runtime_release + 1] = v;
                    return this;
                }
                mutator.modCount++;
                Object[] objArr = this.buffer;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[entryKeyIndex$runtime_release + 1] = v;
                return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, mutator.ownership);
            }
            mutator.setSize(mutator.size + 1);
            JobKt jobKt2 = mutator.ownership;
            if (jobKt == jobKt2) {
                this.buffer = bufferMoveEntryToNode(entryKeyIndex$runtime_release, r0, r11, k, v, r14, jobKt2);
                this.dataMap ^= r0;
                this.nodeMap |= r0;
                return this;
            }
            return new TrieNode<>(this.dataMap ^ r0, this.nodeMap | r0, bufferMoveEntryToNode(entryKeyIndex$runtime_release, r0, r11, k, v, r14, jobKt2), jobKt2);
        }
        if (hasNodeAt(r0)) {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(r0);
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (r14 == 30) {
                IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, nodeAtIndex$runtime_release.buffer.length), 2);
                int r4 = step.first;
                int r5 = step.last;
                int r112 = step.step;
                if ((r112 > 0 && r4 <= r5) || (r112 < 0 && r5 <= r4)) {
                    while (!Intrinsics.areEqual(k, nodeAtIndex$runtime_release.buffer[r4])) {
                        if (r4 != r5) {
                            r4 += r112;
                        }
                    }
                    mutator.operationResult = nodeAtIndex$runtime_release.valueAtKeyIndex(r4);
                    if (nodeAtIndex$runtime_release.ownedBy == mutator.ownership) {
                        nodeAtIndex$runtime_release.buffer[r4 + 1] = v;
                        mutablePut = nodeAtIndex$runtime_release;
                    } else {
                        mutator.modCount++;
                        Object[] objArr2 = nodeAtIndex$runtime_release.buffer;
                        Object[] copyOf2 = Arrays.copyOf(objArr2, objArr2.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                        copyOf2[r4 + 1] = v;
                        mutablePut = new TrieNode<>(0, 0, copyOf2, mutator.ownership);
                    }
                }
                mutator.setSize(mutator.size + 1);
                mutablePut = new TrieNode<>(0, 0, MessageFormatter.access$insertEntryAtIndex(nodeAtIndex$runtime_release.buffer, 0, k, v), mutator.ownership);
                break;
            }
            mutablePut = nodeAtIndex$runtime_release.mutablePut(r11, k, v, r14 + 5, mutator);
            if (nodeAtIndex$runtime_release == mutablePut) {
                return this;
            }
            return mutableUpdateNodeAtIndex(nodeIndex$runtime_release, mutablePut, mutator.ownership);
        }
        mutator.setSize(mutator.size + 1);
        JobKt jobKt3 = mutator.ownership;
        int entryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(r0);
        if (jobKt == jobKt3) {
            this.buffer = MessageFormatter.access$insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release2, k, v);
            this.dataMap |= r0;
            return this;
        }
        return new TrieNode<>(this.dataMap | r0, this.nodeMap, MessageFormatter.access$insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release2, k, v), jobKt3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r28v0, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V>, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode] */
    /* JADX WARN: Type inference failed for: r4v18, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode] */
    /* JADX WARN: Type inference failed for: r4v22, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode] */
    /* JADX WARN: Type inference failed for: r4v23, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> trieNode, int r30, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> mutator) {
        boolean z;
        TrieNode<K, V> trieNode2;
        ?? r18;
        int r12;
        int r20;
        int r23;
        TrieNode<K, V> trieNode3;
        int r7;
        int r5;
        int r182;
        int r202;
        boolean z2;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == trieNode) {
            deltaCounter.count += calculateSize();
            return this;
        }
        int r122 = 0;
        if (r30 > 30) {
            JobKt jobKt = mutator.ownership;
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            int length = this.buffer.length;
            IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, trieNode.buffer.length), 2);
            int r8 = step.first;
            int r9 = step.last;
            int r52 = step.step;
            if ((r52 > 0 && r8 <= r9) || (r52 < 0 && r9 <= r8)) {
                while (true) {
                    if (!collisionContainsKey(trieNode.buffer[r8])) {
                        Object[] objArr2 = trieNode.buffer;
                        copyOf[length] = objArr2[r8];
                        copyOf[length + 1] = objArr2[r8 + 1];
                        length += 2;
                    } else {
                        deltaCounter.count++;
                    }
                    if (r8 == r9) {
                        break;
                    }
                    r8 += r52;
                }
            }
            if (length == this.buffer.length) {
                return this;
            }
            if (length == trieNode.buffer.length) {
                return trieNode;
            }
            if (length == copyOf.length) {
                return new TrieNode<>(0, 0, copyOf, jobKt);
            }
            Object[] copyOf2 = Arrays.copyOf(copyOf, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            return new TrieNode<>(0, 0, copyOf2, jobKt);
        }
        int r4 = this.nodeMap | trieNode.nodeMap;
        int r6 = this.dataMap;
        int r72 = trieNode.dataMap;
        int r82 = (r6 ^ r72) & (~r4);
        int r62 = r6 & r72;
        int r13 = r82;
        while (r62 != 0) {
            int lowestOneBit = Integer.lowestOneBit(r62);
            if (Intrinsics.areEqual(this.buffer[entryKeyIndex$runtime_release(lowestOneBit)], trieNode.buffer[trieNode.entryKeyIndex$runtime_release(lowestOneBit)])) {
                r13 |= lowestOneBit;
            } else {
                r4 |= lowestOneBit;
            }
            r62 ^= lowestOneBit;
        }
        if ((r4 & r13) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (Intrinsics.areEqual(this.ownedBy, mutator.ownership) && this.dataMap == r13 && this.nodeMap == r4) {
                trieNode2 = this;
            } else {
                trieNode2 = new TrieNode<>(r13, r4, new Object[Integer.bitCount(r4) + (Integer.bitCount(r13) * 2)], null);
            }
            int r15 = r4;
            int r16 = 0;
            while (r15 != 0) {
                int lowestOneBit2 = Integer.lowestOneBit(r15);
                Object[] objArr3 = trieNode2.buffer;
                int length2 = (objArr3.length - 1) - r16;
                if (hasNodeAt(lowestOneBit2)) {
                    ?? nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(lowestOneBit2));
                    if (trieNode.hasNodeAt(lowestOneBit2)) {
                        z2 = (TrieNode<K, V>) nodeAtIndex$runtime_release.mutablePutAll(trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(lowestOneBit2)), r30 + 5, deltaCounter, mutator);
                    } else {
                        z2 = nodeAtIndex$runtime_release;
                        if (trieNode.hasEntryAt$runtime_release(lowestOneBit2)) {
                            int entryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(lowestOneBit2);
                            Object obj = trieNode.buffer[entryKeyIndex$runtime_release];
                            V valueAtKeyIndex = trieNode.valueAtKeyIndex(entryKeyIndex$runtime_release);
                            int r53 = mutator.size;
                            if (obj != null) {
                                r182 = obj.hashCode();
                            } else {
                                r182 = r122;
                            }
                            int r54 = r182;
                            Object[] objArr4 = objArr3;
                            r202 = lowestOneBit2;
                            TrieNode mutablePut = nodeAtIndex$runtime_release.mutablePut(r54, obj, valueAtKeyIndex, r30 + 5, mutator);
                            trieNode3 = mutablePut;
                            r18 = objArr4;
                            if (mutator.size == r53) {
                                deltaCounter.count++;
                                trieNode3 = mutablePut;
                                r18 = objArr4;
                            }
                            r12 = r202;
                        }
                    }
                    r18 = objArr3;
                    r202 = lowestOneBit2;
                    trieNode3 = z2;
                    r12 = r202;
                } else {
                    r18 = objArr3;
                    r12 = lowestOneBit2;
                    if (trieNode.hasNodeAt(r12)) {
                        trieNode3 = trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(r12));
                        if (hasEntryAt$runtime_release(r12)) {
                            int entryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(r12);
                            Object obj2 = this.buffer[entryKeyIndex$runtime_release2];
                            if (obj2 != null) {
                                r7 = obj2.hashCode();
                            } else {
                                r7 = 0;
                            }
                            int r83 = r30 + 5;
                            if (trieNode3.containsKey(r7, r83, obj2)) {
                                deltaCounter.count++;
                            } else {
                                Object valueAtKeyIndex2 = valueAtKeyIndex(entryKeyIndex$runtime_release2);
                                if (obj2 != null) {
                                    r5 = obj2.hashCode();
                                } else {
                                    r5 = 0;
                                }
                                trieNode3 = (TrieNode<K, V>) trieNode3.mutablePut(r5, obj2, valueAtKeyIndex2, r83, mutator);
                            }
                        }
                    } else {
                        int entryKeyIndex$runtime_release3 = entryKeyIndex$runtime_release(r12);
                        Object obj3 = this.buffer[entryKeyIndex$runtime_release3];
                        Object valueAtKeyIndex3 = valueAtKeyIndex(entryKeyIndex$runtime_release3);
                        int entryKeyIndex$runtime_release4 = trieNode.entryKeyIndex$runtime_release(r12);
                        Object obj4 = trieNode.buffer[entryKeyIndex$runtime_release4];
                        V valueAtKeyIndex4 = trieNode.valueAtKeyIndex(entryKeyIndex$runtime_release4);
                        if (obj3 != null) {
                            r20 = obj3.hashCode();
                        } else {
                            r20 = 0;
                        }
                        if (obj4 != null) {
                            r23 = obj4.hashCode();
                        } else {
                            r23 = 0;
                        }
                        trieNode3 = (TrieNode<K, V>) makeNode(r20, obj3, valueAtKeyIndex3, r23, obj4, valueAtKeyIndex4, r30 + 5, mutator.ownership);
                    }
                }
                r18[length2] = trieNode3;
                r16++;
                r15 ^= r12;
                r122 = 0;
            }
            int r123 = 0;
            while (r13 != 0) {
                int lowestOneBit3 = Integer.lowestOneBit(r13);
                int r42 = r123 * 2;
                if (!trieNode.hasEntryAt$runtime_release(lowestOneBit3)) {
                    int entryKeyIndex$runtime_release5 = entryKeyIndex$runtime_release(lowestOneBit3);
                    Object[] objArr5 = trieNode2.buffer;
                    objArr5[r42] = this.buffer[entryKeyIndex$runtime_release5];
                    objArr5[r42 + 1] = valueAtKeyIndex(entryKeyIndex$runtime_release5);
                } else {
                    int entryKeyIndex$runtime_release6 = trieNode.entryKeyIndex$runtime_release(lowestOneBit3);
                    Object[] objArr6 = trieNode2.buffer;
                    objArr6[r42] = trieNode.buffer[entryKeyIndex$runtime_release6];
                    objArr6[r42 + 1] = trieNode.valueAtKeyIndex(entryKeyIndex$runtime_release6);
                    if (hasEntryAt$runtime_release(lowestOneBit3)) {
                        deltaCounter.count++;
                    }
                }
                r123++;
                r13 ^= lowestOneBit3;
            }
            if (elementsIdentityEquals(trieNode2)) {
                return this;
            }
            if (trieNode.elementsIdentityEquals(trieNode2)) {
                return trieNode;
            }
            return trieNode2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final TrieNode<K, V> mutableRemove(int r9, K k, int r11, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> mutableRemove;
        TrieNode<K, V> trieNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int r6 = 1 << ((r9 >> r11) & 31);
        if (hasEntryAt$runtime_release(r6)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r6);
            return Intrinsics.areEqual(k, this.buffer[entryKeyIndex$runtime_release]) ? mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, r6, mutator) : this;
        }
        if (!hasNodeAt(r6)) {
            return this;
        }
        int nodeIndex$runtime_release = nodeIndex$runtime_release(r6);
        TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
        if (r11 == 30) {
            IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, nodeAtIndex$runtime_release.buffer.length), 2);
            int r112 = step.first;
            int r0 = step.last;
            int r92 = step.step;
            if ((r92 > 0 && r112 <= r0) || (r92 < 0 && r0 <= r112)) {
                while (!Intrinsics.areEqual(k, nodeAtIndex$runtime_release.buffer[r112])) {
                    if (r112 != r0) {
                        r112 += r92;
                    }
                }
                mutableRemove = nodeAtIndex$runtime_release.mutableCollisionRemoveEntryAtIndex(r112, mutator);
            }
            trieNode = nodeAtIndex$runtime_release;
            return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, r6, mutator.ownership);
        }
        mutableRemove = nodeAtIndex$runtime_release.mutableRemove(r9, k, r11 + 5, mutator);
        trieNode = mutableRemove;
        return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, r6, mutator.ownership);
    }

    public final TrieNode<K, V> mutableRemoveEntryAtIndex(int r4, int r5, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.getClass();
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size - 1);
        persistentHashMapBuilder.operationResult = valueAtKeyIndex(r4);
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        if (this.ownedBy == persistentHashMapBuilder.ownership) {
            this.buffer = MessageFormatter.access$removeEntryAtIndex(r4, objArr);
            this.dataMap ^= r5;
            return this;
        }
        return new TrieNode<>(r5 ^ this.dataMap, this.nodeMap, MessageFormatter.access$removeEntryAtIndex(r4, objArr), persistentHashMapBuilder.ownership);
    }

    public final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int r5, int r6, JobKt jobKt) {
        JobKt jobKt2 = this.ownedBy;
        if (trieNode2 == null) {
            Object[] objArr = this.buffer;
            if (objArr.length == 1) {
                return null;
            }
            if (jobKt2 == jobKt) {
                this.buffer = MessageFormatter.access$removeNodeAtIndex(r5, objArr);
                this.nodeMap ^= r6;
            } else {
                return new TrieNode<>(this.dataMap, r6 ^ this.nodeMap, MessageFormatter.access$removeNodeAtIndex(r5, objArr), jobKt);
            }
        } else if (jobKt2 == jobKt || trieNode != trieNode2) {
            return mutableUpdateNodeAtIndex(r5, trieNode2, jobKt);
        }
        return this;
    }

    public final TrieNode<K, V> mutableUpdateNodeAtIndex(int r4, TrieNode<K, V> trieNode, JobKt jobKt) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && trieNode.buffer.length == 2 && trieNode.nodeMap == 0) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        if (this.ownedBy == jobKt) {
            objArr[r4] = trieNode;
            return this;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[r4] = trieNode;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, jobKt);
    }

    public final TrieNode<K, V> nodeAtIndex$runtime_release(int r2) {
        Object obj = this.buffer[r2];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    public final int nodeIndex$runtime_release(int r3) {
        return (this.buffer.length - 1) - Integer.bitCount((r3 - 1) & this.nodeMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult put(int r12, int r13, java.lang.Object r14, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links r15) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.put(int, int, java.lang.Object, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode$ModificationResult");
    }

    public final TrieNode remove(int r10, int r11, Object obj) {
        TrieNode<K, V> remove;
        int r0 = 1 << ((r10 >> r11) & 31);
        if (hasEntryAt$runtime_release(r0)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r0);
            if (Intrinsics.areEqual(obj, this.buffer[entryKeyIndex$runtime_release])) {
                Object[] objArr = this.buffer;
                if (objArr.length == 2) {
                    return null;
                }
                return new TrieNode(this.dataMap ^ r0, this.nodeMap, MessageFormatter.access$removeEntryAtIndex(entryKeyIndex$runtime_release, objArr), null);
            }
            return this;
        }
        if (hasNodeAt(r0)) {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(r0);
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (r11 == 30) {
                IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, nodeAtIndex$runtime_release.buffer.length), 2);
                int r6 = step.first;
                int r7 = step.last;
                int r102 = step.step;
                if ((r102 > 0 && r6 <= r7) || (r102 < 0 && r7 <= r6)) {
                    while (!Intrinsics.areEqual(obj, nodeAtIndex$runtime_release.buffer[r6])) {
                        if (r6 != r7) {
                            r6 += r102;
                        }
                    }
                    Object[] objArr2 = nodeAtIndex$runtime_release.buffer;
                    if (objArr2.length == 2) {
                        remove = null;
                    } else {
                        remove = new TrieNode<>(0, 0, MessageFormatter.access$removeEntryAtIndex(r6, objArr2), null);
                    }
                }
                remove = nodeAtIndex$runtime_release;
                break;
            }
            remove = nodeAtIndex$runtime_release.remove(r10, r11 + 5, obj);
            if (remove == null) {
                Object[] objArr3 = this.buffer;
                if (objArr3.length == 1) {
                    return null;
                }
                return new TrieNode(this.dataMap, r0 ^ this.nodeMap, MessageFormatter.access$removeNodeAtIndex(nodeIndex$runtime_release, objArr3), null);
            }
            if (nodeAtIndex$runtime_release != remove) {
                return updateNodeAtIndex(nodeIndex$runtime_release, r0, remove);
            }
            return this;
        }
        return this;
    }

    public final TrieNode<K, V> updateNodeAtIndex(int r9, int r10, TrieNode<K, V> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 2 && trieNode.nodeMap == 0) {
            if (this.buffer.length == 1) {
                trieNode.dataMap = this.nodeMap;
                return trieNode;
            }
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r10);
            Object[] objArr2 = this.buffer;
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length + 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            ArraysKt___ArraysJvmKt.copyInto(r9 + 2, r9 + 1, objArr2.length, copyOf, copyOf);
            ArraysKt___ArraysJvmKt.copyInto(entryKeyIndex$runtime_release + 2, entryKeyIndex$runtime_release, r9, copyOf, copyOf);
            copyOf[entryKeyIndex$runtime_release] = obj;
            copyOf[entryKeyIndex$runtime_release + 1] = obj2;
            return new TrieNode<>(this.dataMap ^ r10, r10 ^ this.nodeMap, copyOf, null);
        }
        Object[] objArr3 = this.buffer;
        Object[] copyOf2 = Arrays.copyOf(objArr3, objArr3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        copyOf2[r9] = trieNode;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf2, null);
    }

    public final V valueAtKeyIndex(int r2) {
        return (V) this.buffer[r2 + 1];
    }

    public final TrieNode<K, V> mutableRemove(int r12, K k, V v, int r15, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> mutableRemove;
        TrieNode<K, V> trieNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int r8 = 1 << ((r12 >> r15) & 31);
        if (hasEntryAt$runtime_release(r8)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(r8);
            return (Intrinsics.areEqual(k, this.buffer[entryKeyIndex$runtime_release]) && Intrinsics.areEqual(v, valueAtKeyIndex(entryKeyIndex$runtime_release))) ? mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, r8, mutator) : this;
        }
        if (!hasNodeAt(r8)) {
            return this;
        }
        int nodeIndex$runtime_release = nodeIndex$runtime_release(r8);
        TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
        if (r15 == 30) {
            IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, nodeAtIndex$runtime_release.buffer.length), 2);
            int r1 = step.first;
            int r4 = step.last;
            int r0 = step.step;
            if ((r0 > 0 && r1 <= r4) || (r0 < 0 && r4 <= r1)) {
                while (true) {
                    if (!Intrinsics.areEqual(k, nodeAtIndex$runtime_release.buffer[r1]) || !Intrinsics.areEqual(v, nodeAtIndex$runtime_release.valueAtKeyIndex(r1))) {
                        if (r1 == r4) {
                            break;
                        }
                        r1 += r0;
                    } else {
                        mutableRemove = nodeAtIndex$runtime_release.mutableCollisionRemoveEntryAtIndex(r1, mutator);
                        break;
                    }
                }
            }
            trieNode = nodeAtIndex$runtime_release;
            return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, r8, mutator.ownership);
        }
        mutableRemove = nodeAtIndex$runtime_release.mutableRemove(r12, k, v, r15 + 5, mutator);
        trieNode = mutableRemove;
        return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, r8, mutator.ownership);
    }
}

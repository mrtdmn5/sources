package com.squareup.moshi;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final AnonymousClass1 NATURAL_ORDER = new AnonymousClass1();
    public LinkedHashTreeMap<K, V>.EntrySet entrySet;
    public LinkedHashTreeMap<K, V>.KeySet keySet;
    public int size = 0;
    public int modCount = 0;
    public final Comparator<? super K> comparator = NATURAL_ORDER;
    public final Node<K, V> header = new Node<>();
    public Node<K, V>[] table = new Node[16];
    public int threshold = 12;

    /* renamed from: com.squareup.moshi.LinkedHashTreeMap$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class AvlBuilder<K, V> {
        public int leavesSkipped;
        public int leavesToSkip;
        public int size;
        public Node<K, V> stack;

        public final void add(Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int r1 = this.leavesToSkip;
            if (r1 > 0) {
                int r2 = this.size;
                if ((r2 & 1) == 0) {
                    this.size = r2 + 1;
                    this.leavesToSkip = r1 - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int r6 = this.size + 1;
            this.size = r6;
            int r12 = this.leavesToSkip;
            if (r12 > 0 && (r6 & 1) == 0) {
                this.size = r6 + 1;
                this.leavesToSkip = r12 - 1;
                this.leavesSkipped++;
            }
            int r62 = 4;
            while (true) {
                int r22 = r62 - 1;
                if ((this.size & r22) == r22) {
                    int r13 = this.leavesSkipped;
                    if (r13 == 0) {
                        Node<K, V> node2 = this.stack;
                        Node<K, V> node3 = node2.parent;
                        Node<K, V> node4 = node3.parent;
                        node3.parent = node4.parent;
                        this.stack = node3;
                        node3.left = node4;
                        node3.right = node2;
                        node3.height = node2.height + 1;
                        node4.parent = node3;
                        node2.parent = node3;
                    } else if (r13 == 1) {
                        Node<K, V> node5 = this.stack;
                        Node<K, V> node6 = node5.parent;
                        this.stack = node6;
                        node6.right = node5;
                        node6.height = node5.height + 1;
                        node5.parent = node6;
                        this.leavesSkipped = 0;
                    } else if (r13 == 2) {
                        this.leavesSkipped = 0;
                    }
                    r62 *= 2;
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) { // from class: com.squareup.moshi.LinkedHashTreeMap.EntrySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public final Object next() {
                    return nextNode();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            LinkedHashTreeMap linkedHashTreeMap;
            Node<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = (linkedHashTreeMap = LinkedHashTreeMap.this).findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            linkedHashTreeMap.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.squareup.moshi.LinkedHashTreeMap.KeySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    return nextNode().key;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                com.squareup.moshi.LinkedHashTreeMap r0 = com.squareup.moshi.LinkedHashTreeMap.this
                r0.getClass()
                r1 = 0
                if (r4 == 0) goto Ld
                com.squareup.moshi.LinkedHashTreeMap$Node r4 = r0.find(r4, r1)     // Catch: java.lang.ClassCastException -> Ld
                goto Le
            Ld:
                r4 = 0
            Le:
                r2 = 1
                if (r4 == 0) goto L14
                r0.removeInternal(r4, r2)
            L14:
                if (r4 == 0) goto L17
                r1 = r2
            L17:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.KeySet.remove(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public int expectedModCount;
        public Node<K, V> lastReturned = null;
        public Node<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next != LinkedHashTreeMap.this.header) {
                return true;
            }
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount == this.expectedModCount) {
                    this.next = node.next;
                    this.lastReturned = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                linkedHashTreeMap.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = linkedHashTreeMap.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        Node<K, V> node2 = node.next;
        while (node2 != node) {
            Node<K, V> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsKey(java.lang.Object r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L8
            com.squareup.moshi.LinkedHashTreeMap$Node r2 = r1.find(r2, r0)     // Catch: java.lang.ClassCastException -> L8
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto Lc
            r0 = 1
        Lc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.containsKey(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    public final Node<K, V> find(K k, boolean z) {
        Node<K, V> node;
        int r13;
        Node<K, V> node2;
        Node<K, V> node3;
        Node<K, V> node4;
        Node<K, V> node5;
        Node<K, V> node6;
        Comparable comparable;
        int compare;
        Node<K, V> node7;
        Node<K, V>[] nodeArr = this.table;
        int hashCode = k.hashCode();
        int r1 = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        int r4 = (r1 >>> 4) ^ ((r1 >>> 7) ^ r1);
        int length = r4 & (nodeArr.length - 1);
        Node<K, V> node8 = nodeArr[length];
        AnonymousClass1 anonymousClass1 = NATURAL_ORDER;
        Node<K, V> node9 = null;
        Comparator<? super K> comparator = this.comparator;
        if (node8 != null) {
            if (comparator == anonymousClass1) {
                comparable = (Comparable) k;
            } else {
                comparable = null;
            }
            while (true) {
                K k2 = node8.key;
                if (comparable != null) {
                    compare = comparable.compareTo(k2);
                } else {
                    compare = comparator.compare(k, k2);
                }
                if (compare == 0) {
                    return node8;
                }
                if (compare < 0) {
                    node7 = node8.left;
                } else {
                    node7 = node8.right;
                }
                if (node7 == null) {
                    r13 = compare;
                    node = node8;
                    break;
                }
                node8 = node7;
            }
        } else {
            node = node8;
            r13 = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node10 = this.header;
        if (node == null) {
            if (comparator == anonymousClass1 && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName().concat(" is not Comparable"));
            }
            node2 = new Node<>(node, k, r4, node10, node10.prev);
            nodeArr[length] = node2;
        } else {
            Node<K, V> node11 = new Node<>(node, k, r4, node10, node10.prev);
            if (r13 < 0) {
                node.left = node11;
            } else {
                node.right = node11;
            }
            rebalance(node, true);
            node2 = node11;
        }
        int r12 = this.size;
        this.size = r12 + 1;
        if (r12 > this.threshold) {
            Node<K, V>[] nodeArr2 = this.table;
            int length2 = nodeArr2.length;
            int r3 = length2 * 2;
            Node<K, V>[] nodeArr3 = new Node[r3];
            AvlBuilder avlBuilder = new AvlBuilder();
            AvlBuilder avlBuilder2 = new AvlBuilder();
            for (int r7 = 0; r7 < length2; r7++) {
                Node<K, V> node12 = nodeArr2[r7];
                if (node12 != null) {
                    Node<K, V> node13 = node9;
                    for (Node<K, V> node14 = node12; node14 != null; node14 = node14.left) {
                        node14.parent = node13;
                        node13 = node14;
                    }
                    int r122 = 0;
                    int r15 = 0;
                    while (true) {
                        if (node13 == null) {
                            node3 = node13;
                            node13 = node9;
                        } else {
                            node3 = node13.parent;
                            node13.parent = node9;
                            Node<K, V> node15 = node13.right;
                            while (node15 != null) {
                                node15.parent = node3;
                                Node<K, V> node16 = node15;
                                node15 = node15.left;
                                node3 = node16;
                            }
                        }
                        if (node13 == null) {
                            break;
                        }
                        if ((node13.hash & length2) == 0) {
                            r122++;
                        } else {
                            r15++;
                        }
                        node13 = node3;
                        node9 = null;
                    }
                    avlBuilder.leavesToSkip = ((Integer.highestOneBit(r122) * 2) - 1) - r122;
                    avlBuilder.size = 0;
                    avlBuilder.leavesSkipped = 0;
                    avlBuilder.stack = null;
                    avlBuilder2.leavesToSkip = ((Integer.highestOneBit(r15) * 2) - 1) - r15;
                    avlBuilder2.size = 0;
                    avlBuilder2.leavesSkipped = 0;
                    avlBuilder2.stack = null;
                    Node<K, V> node17 = null;
                    while (node12 != null) {
                        node12.parent = node17;
                        Node<K, V> node18 = node12;
                        node12 = node12.left;
                        node17 = node18;
                    }
                    while (true) {
                        if (node17 == null) {
                            node4 = node17;
                            node17 = null;
                            node9 = null;
                        } else {
                            Node<K, V> node19 = node17.parent;
                            node9 = null;
                            node17.parent = null;
                            Node<K, V> node20 = node17.right;
                            while (true) {
                                Node<K, V> node21 = node20;
                                node4 = node19;
                                node19 = node21;
                                if (node19 == null) {
                                    break;
                                }
                                node19.parent = node4;
                                node20 = node19.left;
                            }
                        }
                        if (node17 == null) {
                            break;
                        }
                        if ((node17.hash & length2) == 0) {
                            avlBuilder.add(node17);
                        } else {
                            avlBuilder2.add(node17);
                        }
                        node17 = node4;
                    }
                    if (r122 > 0) {
                        node5 = avlBuilder.stack;
                        if (node5.parent != null) {
                            throw new IllegalStateException();
                        }
                    } else {
                        node5 = node9;
                    }
                    nodeArr3[r7] = node5;
                    int r8 = r7 + length2;
                    if (r15 > 0) {
                        node6 = avlBuilder2.stack;
                        if (node6.parent != null) {
                            throw new IllegalStateException();
                        }
                    } else {
                        node6 = node9;
                    }
                    nodeArr3[r8] = node6;
                }
            }
            this.table = nodeArr3;
            this.threshold = (r3 / 4) + (r3 / 2);
        }
        this.modCount++;
        return node2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.squareup.moshi.LinkedHashTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.getKey()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto Ld
            com.squareup.moshi.LinkedHashTreeMap$Node r0 = r5.find(r0, r1)     // Catch: java.lang.ClassCastException -> Ld
            goto Le
        Ld:
            r0 = r2
        Le:
            if (r0 == 0) goto L28
            V r3 = r0.value
            java.lang.Object r6 = r6.getValue()
            r4 = 1
            if (r3 == r6) goto L24
            if (r3 == 0) goto L22
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L22
            goto L24
        L22:
            r6 = r1
            goto L25
        L24:
            r6 = r4
        L25:
            if (r6 == 0) goto L28
            r1 = r4
        L28:
            if (r1 == 0) goto L2b
            r2 = r0
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.findByEntry(java.util.Map$Entry):com.squareup.moshi.LinkedHashTreeMap$Node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            com.squareup.moshi.LinkedHashTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto Le
            V r0 = r3.value
        Le:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedHashTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (k != null) {
            Node<K, V> find = find(k, true);
            V v2 = find.value;
            find.value = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final void rebalance(Node<K, V> node, boolean z) {
        int r3;
        int r4;
        int r32;
        int r33;
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int r2 = 0;
            if (node2 != null) {
                r3 = node2.height;
            } else {
                r3 = 0;
            }
            if (node3 != null) {
                r4 = node3.height;
            } else {
                r4 = 0;
            }
            int r5 = r3 - r4;
            if (r5 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                if (node5 != null) {
                    r33 = node5.height;
                } else {
                    r33 = 0;
                }
                if (node4 != null) {
                    r2 = node4.height;
                }
                int r22 = r2 - r33;
                if (r22 != -1 && (r22 != 0 || z)) {
                    rotateRight(node3);
                    rotateLeft(node);
                } else {
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (r5 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                if (node7 != null) {
                    r32 = node7.height;
                } else {
                    r32 = 0;
                }
                if (node6 != null) {
                    r2 = node6.height;
                }
                int r23 = r2 - r32;
                if (r23 != 1 && (r23 != 0 || z)) {
                    rotateLeft(node2);
                    rotateRight(node);
                } else {
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (r5 == 0) {
                node.height = r3 + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(r3, r4) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            com.squareup.moshi.LinkedHashTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto L10
            r1 = 1
            r2.removeInternal(r3, r1)
        L10:
            if (r3 == 0) goto L14
            V r0 = r3.value
        L14:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.remove(java.lang.Object):java.lang.Object");
    }

    public final void removeInternal(Node<K, V> node, boolean z) {
        Node<K, V> node2;
        Node<K, V> node3;
        int r2;
        if (z) {
            Node<K, V> node4 = node.prev;
            node4.next = node.next;
            node.next.prev = node4;
            node.prev = null;
            node.next = null;
        }
        Node<K, V> node5 = node.left;
        Node<K, V> node6 = node.right;
        Node<K, V> node7 = node.parent;
        int r3 = 0;
        if (node5 != null && node6 != null) {
            if (node5.height > node6.height) {
                Node<K, V> node8 = node5.right;
                while (true) {
                    Node<K, V> node9 = node8;
                    node3 = node5;
                    node5 = node9;
                    if (node5 == null) {
                        break;
                    } else {
                        node8 = node5.right;
                    }
                }
            } else {
                Node<K, V> node10 = node6.left;
                while (true) {
                    node2 = node6;
                    node6 = node10;
                    if (node6 == null) {
                        break;
                    } else {
                        node10 = node6.left;
                    }
                }
                node3 = node2;
            }
            removeInternal(node3, false);
            Node<K, V> node11 = node.left;
            if (node11 != null) {
                r2 = node11.height;
                node3.left = node11;
                node11.parent = node3;
                node.left = null;
            } else {
                r2 = 0;
            }
            Node<K, V> node12 = node.right;
            if (node12 != null) {
                r3 = node12.height;
                node3.right = node12;
                node12.parent = node3;
                node.right = null;
            }
            node3.height = Math.max(r2, r3) + 1;
            replaceInParent(node, node3);
            return;
        }
        if (node5 != null) {
            replaceInParent(node, node5);
            node.left = null;
        } else if (node6 != null) {
            replaceInParent(node, node6);
            node.right = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node7, false);
        this.size--;
        this.modCount++;
    }

    public final void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
                return;
            } else {
                node3.right = node2;
                return;
            }
        }
        this.table[node.hash & (r0.length - 1)] = node2;
    }

    public final void rotateLeft(Node<K, V> node) {
        int r0;
        int r2;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int r4 = 0;
        if (node2 != null) {
            r0 = node2.height;
        } else {
            r0 = 0;
        }
        if (node4 != null) {
            r2 = node4.height;
        } else {
            r2 = 0;
        }
        int max = Math.max(r0, r2) + 1;
        node.height = max;
        if (node5 != null) {
            r4 = node5.height;
        }
        node3.height = Math.max(max, r4) + 1;
    }

    public final void rotateRight(Node<K, V> node) {
        int r1;
        int r3;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int r4 = 0;
        if (node3 != null) {
            r1 = node3.height;
        } else {
            r1 = 0;
        }
        if (node5 != null) {
            r3 = node5.height;
        } else {
            r3 = 0;
        }
        int max = Math.max(r1, r3) + 1;
        node.height = max;
        if (node4 != null) {
            r4 = node4.height;
        }
        node2.height = Math.max(max, r4) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    /* loaded from: classes3.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        public final int hash;
        public int height;
        public final K key;
        public Node<K, V> left;
        public Node<K, V> next;
        public Node<K, V> parent;
        public Node<K, V> prev;
        public Node<K, V> right;
        public V value;

        public Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.key;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.value;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            int r0 = 0;
            K k = this.key;
            if (k == null) {
                hashCode = 0;
            } else {
                hashCode = k.hashCode();
            }
            V v = this.value;
            if (v != null) {
                r0 = v.hashCode();
            }
            return r0 ^ hashCode;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node<K, V> node, K k, int r3, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.hash = r3;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}

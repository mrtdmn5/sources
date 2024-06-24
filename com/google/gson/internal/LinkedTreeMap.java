package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final AnonymousClass1 NATURAL_ORDER = new AnonymousClass1();
    public final boolean allowNullValues;
    public final Comparator<? super K> comparator;
    public LinkedTreeMap<K, V>.EntrySet entrySet;
    public final Node<K, V> header;
    public LinkedTreeMap<K, V>.KeySet keySet;
    public int modCount;
    public Node<K, V> root;
    public int size;

    /* renamed from: com.google.gson.internal.LinkedTreeMap$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes3.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: com.google.gson.internal.LinkedTreeMap$EntrySet$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 extends LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>> {
            public AnonymousClass1(EntrySet entrySet) {
                super();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return nextNode();
            }
        }

        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap;
            Node<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = (linkedTreeMap = LinkedTreeMap.this).findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            linkedTreeMap.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
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
                com.google.gson.internal.LinkedTreeMap r0 = com.google.gson.internal.LinkedTreeMap.this
                r0.getClass()
                r1 = 0
                if (r4 == 0) goto Ld
                com.google.gson.internal.LinkedTreeMap$Node r4 = r0.find(r4, r1)     // Catch: java.lang.ClassCastException -> Ld
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.KeySet.remove(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public int expectedModCount;
        public Node<K, V> lastReturned = null;
        public Node<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.expectedModCount) {
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
                LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                linkedTreeMap.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = linkedTreeMap.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap(boolean z) {
        AnonymousClass1 anonymousClass1 = NATURAL_ORDER;
        this.size = 0;
        this.modCount = 0;
        this.comparator = anonymousClass1;
        this.allowNullValues = z;
        this.header = new Node<>(z);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
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
            com.google.gson.internal.LinkedTreeMap$Node r2 = r1.find(r2, r0)     // Catch: java.lang.ClassCastException -> L8
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto Lc
            r0 = 1
        Lc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.containsKey(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    public final Node<K, V> find(K k, boolean z) {
        int r5;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Node<K, V> node3 = this.root;
        AnonymousClass1 anonymousClass1 = NATURAL_ORDER;
        Comparator<? super K> comparator = this.comparator;
        if (node3 != null) {
            if (comparator == anonymousClass1) {
                comparable = (Comparable) k;
            } else {
                comparable = null;
            }
            while (true) {
                K k2 = node3.key;
                if (comparable != null) {
                    r5 = comparable.compareTo(k2);
                } else {
                    r5 = comparator.compare(k, k2);
                }
                if (r5 == 0) {
                    return node3;
                }
                if (r5 < 0) {
                    node2 = node3.left;
                } else {
                    node2 = node3.right;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            r5 = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node3 == null) {
            if (comparator == anonymousClass1 && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName().concat(" is not Comparable"));
            }
            node = new Node<>(this.allowNullValues, node3, k, node4, node4.prev);
            this.root = node;
        } else {
            node = new Node<>(this.allowNullValues, node3, k, node4, node4.prev);
            if (r5 < 0) {
                node3.left = node;
            } else {
                node3.right = node;
            }
            rebalance(node3, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.gson.internal.LinkedTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto Ld
            com.google.gson.internal.LinkedTreeMap$Node r0 = r4.find(r0, r1)     // Catch: java.lang.ClassCastException -> Ld
            goto Le
        Ld:
            r0 = r2
        Le:
            if (r0 == 0) goto L1d
            V r3 = r0.value
            java.lang.Object r5 = r5.getValue()
            boolean r5 = java.util.Objects.equals(r3, r5)
            if (r5 == 0) goto L1d
            r1 = 1
        L1d:
            if (r1 == 0) goto L20
            r2 = r0
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.findByEntry(java.util.Map$Entry):com.google.gson.internal.LinkedTreeMap$Node");
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
            com.google.gson.internal.LinkedTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto Le
            V r0 = r3.value
        Le:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (k != null) {
            if (v == null && !this.allowNullValues) {
                throw new NullPointerException("value == null");
            }
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
            com.google.gson.internal.LinkedTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.remove(java.lang.Object):java.lang.Object");
    }

    public final void removeInternal(Node<K, V> node, boolean z) {
        Node<K, V> node2;
        Node<K, V> node3;
        int r1;
        if (z) {
            Node<K, V> node4 = node.prev;
            node4.next = node.next;
            node.next.prev = node4;
        }
        Node<K, V> node5 = node.left;
        Node<K, V> node6 = node.right;
        Node<K, V> node7 = node.parent;
        int r2 = 0;
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
                r1 = node11.height;
                node3.left = node11;
                node11.parent = node3;
                node.left = null;
            } else {
                r1 = 0;
            }
            Node<K, V> node12 = node.right;
            if (node12 != null) {
                r2 = node12.height;
                node3.right = node12;
                node12.parent = node3;
                node.right = null;
            }
            node3.height = Math.max(r1, r2) + 1;
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
        this.root = node2;
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
        public final boolean allowNullValue;
        public int height;
        public final K key;
        public Node<K, V> left;
        public Node<K, V> next;
        public Node<K, V> parent;
        public Node<K, V> prev;
        public Node<K, V> right;
        public V value;

        public Node(boolean z) {
            this.key = null;
            this.allowNullValue = z;
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
            if (v == null && !this.allowNullValue) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }

        public Node(boolean z, Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.allowNullValue = z;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }

    public LinkedTreeMap() {
        this(true);
    }
}

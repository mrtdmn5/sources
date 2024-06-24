package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class Pending {
    public int groupIndex;
    public final HashMap<Integer, GroupInfo> groupInfos;
    public final List<KeyInfo> keyInfos;
    public final SynchronizedLazyImpl keyMap$delegate;
    public final int startIndex;
    public final ArrayList usedKeys;

    public Pending(ArrayList arrayList, int r7) {
        boolean z;
        this.keyInfos = arrayList;
        this.startIndex = r7;
        if (r7 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.usedKeys = new ArrayList();
            HashMap<Integer, GroupInfo> hashMap = new HashMap<>();
            int size = arrayList.size();
            int r1 = 0;
            for (int r0 = 0; r0 < size; r0++) {
                KeyInfo keyInfo = this.keyInfos.get(r0);
                Integer valueOf = Integer.valueOf(keyInfo.location);
                int r2 = keyInfo.nodes;
                hashMap.put(valueOf, new GroupInfo(r0, r1, r2));
                r1 += r2;
            }
            this.groupInfos = hashMap;
            this.keyMap$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Object, LinkedHashSet<KeyInfo>>>() { // from class: androidx.compose.runtime.Pending$keyMap$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final HashMap<Object, LinkedHashSet<KeyInfo>> invoke() {
                    Object valueOf2;
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    HashMap<Object, LinkedHashSet<KeyInfo>> hashMap2 = new HashMap<>();
                    Pending pending = Pending.this;
                    int size2 = pending.keyInfos.size();
                    for (int r3 = 0; r3 < size2; r3++) {
                        KeyInfo keyInfo2 = pending.keyInfos.get(r3);
                        Object obj = keyInfo2.objectKey;
                        int r6 = keyInfo2.key;
                        if (obj != null) {
                            valueOf2 = new JoinedKey(Integer.valueOf(r6), keyInfo2.objectKey);
                        } else {
                            valueOf2 = Integer.valueOf(r6);
                        }
                        LinkedHashSet<KeyInfo> linkedHashSet = hashMap2.get(valueOf2);
                        if (linkedHashSet == null) {
                            linkedHashSet = new LinkedHashSet<>();
                            hashMap2.put(valueOf2, linkedHashSet);
                        }
                        linkedHashSet.add(keyInfo2);
                    }
                    return hashMap2;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Invalid start index".toString());
    }

    public final int nodePositionOf(KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.location));
        if (groupInfo != null) {
            return groupInfo.nodeIndex;
        }
        return -1;
    }

    public final boolean updateNodeCount(int r5, int r6) {
        int r3;
        HashMap<Integer, GroupInfo> hashMap = this.groupInfos;
        GroupInfo groupInfo = hashMap.get(Integer.valueOf(r5));
        if (groupInfo != null) {
            int r1 = groupInfo.nodeIndex;
            int r2 = r6 - groupInfo.nodeCount;
            groupInfo.nodeCount = r6;
            if (r2 != 0) {
                Collection<GroupInfo> values = hashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
                for (GroupInfo groupInfo2 : values) {
                    if (groupInfo2.nodeIndex >= r1 && !Intrinsics.areEqual(groupInfo2, groupInfo) && (r3 = groupInfo2.nodeIndex + r2) >= 0) {
                        groupInfo2.nodeIndex = r3;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}

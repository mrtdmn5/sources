package androidx.profileinstaller;

import java.util.TreeMap;

/* loaded from: classes.dex */
public final class DexProfileData {
    public final String apkName;
    public int classSetSize;
    public int[] classes;
    public final long dexChecksum;
    public final String dexName;
    public final int hotMethodRegionSize;
    public long mTypeIdCount = 0;
    public final TreeMap<Integer, Integer> methods;
    public final int numMethodIds;

    public DexProfileData(String str, String str2, long j, int r5, int r6, int r7, int[] r8, TreeMap treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j;
        this.classSetSize = r5;
        this.hotMethodRegionSize = r6;
        this.numMethodIds = r7;
        this.classes = r8;
        this.methods = treeMap;
    }
}

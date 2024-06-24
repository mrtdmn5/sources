package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();
    public int mArgCount;
    public final int[] mBindingTypes;
    public final byte[][] mBlobBindings;
    public final int mCapacity;
    public final double[] mDoubleBindings;
    public final long[] mLongBindings;
    public volatile String mQuery;
    public final String[] mStringBindings;

    public RoomSQLiteQuery(int r2) {
        this.mCapacity = r2;
        int r22 = r2 + 1;
        this.mBindingTypes = new int[r22];
        this.mLongBindings = new long[r22];
        this.mDoubleBindings = new double[r22];
        this.mStringBindings = new String[r22];
        this.mBlobBindings = new byte[r22];
    }

    public static RoomSQLiteQuery acquire(int r3, String str) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(r3));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.mQuery = str;
                value.mArgCount = r3;
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(r3);
            roomSQLiteQuery.mQuery = str;
            roomSQLiteQuery.mArgCount = r3;
            return roomSQLiteQuery;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int r3, byte[] bArr) {
        this.mBindingTypes[r3] = 5;
        this.mBlobBindings[r3] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int r3, double d) {
        this.mBindingTypes[r3] = 3;
        this.mDoubleBindings[r3] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int r3, long j) {
        this.mBindingTypes[r3] = 2;
        this.mLongBindings[r3] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int r3) {
        this.mBindingTypes[r3] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int r3, String str) {
        this.mBindingTypes[r3] = 4;
        this.mStringBindings[r3] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        for (int r1 = 1; r1 <= this.mArgCount; r1++) {
            int r2 = this.mBindingTypes[r1];
            if (r2 != 1) {
                if (r2 != 2) {
                    if (r2 != 3) {
                        if (r2 != 4) {
                            if (r2 == 5) {
                                frameworkSQLiteProgram.bindBlob(r1, this.mBlobBindings[r1]);
                            }
                        } else {
                            frameworkSQLiteProgram.bindString(r1, this.mStringBindings[r1]);
                        }
                    } else {
                        frameworkSQLiteProgram.bindDouble(r1, this.mDoubleBindings[r1]);
                    }
                } else {
                    frameworkSQLiteProgram.bindLong(r1, this.mLongBindings[r1]);
                }
            } else {
                frameworkSQLiteProgram.bindNull(r1);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        return this.mQuery;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int r3 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = r3;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}

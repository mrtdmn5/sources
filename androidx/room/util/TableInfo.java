package androidx.room.util;

import android.database.Cursor;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class TableInfo {
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    /* loaded from: classes.dex */
    public static class Column {
        public final int affinity;
        public final String defaultValue;
        public final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z, int r4, String str3, int r6) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = r4;
            int r1 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    r1 = 3;
                } else if (!upperCase.contains("CHAR") && !upperCase.contains("CLOB") && !upperCase.contains("TEXT")) {
                    if (!upperCase.contains("BLOB")) {
                        r1 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                    }
                } else {
                    r1 = 2;
                }
            }
            this.affinity = r1;
            this.defaultValue = str3;
            this.mCreatedFrom = r6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Column.class != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            String str = this.defaultValue;
            int r4 = this.mCreatedFrom;
            int r5 = column.mCreatedFrom;
            String str2 = column.defaultValue;
            if (r4 == 1 && r5 == 2 && str != null && !str.equals(str2)) {
                return false;
            }
            if (r4 == 2 && r5 == 1 && str2 != null && !str2.equals(str)) {
                return false;
            }
            if ((r4 == 0 || r4 != r5 || (str == null ? str2 == null : str.equals(str2))) && this.affinity == column.affinity) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int r1;
            int hashCode = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull) {
                r1 = 1231;
            } else {
                r1 = 1237;
            }
            return ((hashCode + r1) * 31) + this.primaryKeyPosition;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.defaultValue, "'}");
        }
    }

    /* loaded from: classes.dex */
    public static class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ForeignKey.class != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (!this.referenceTable.equals(foreignKey.referenceTable) || !this.onDelete.equals(foreignKey.onDelete) || !this.onUpdate.equals(foreignKey.onUpdate) || !this.columnNames.equals(foreignKey.columnNames)) {
                return false;
            }
            return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
        }

        public final int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.onUpdate, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.onDelete, this.referenceTable.hashCode() * 31, 31), 31)) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ForeignKey{referenceTable='");
            sb.append(this.referenceTable);
            sb.append("', onDelete='");
            sb.append(this.onDelete);
            sb.append("', onUpdate='");
            sb.append(this.onUpdate);
            sb.append("', columnNames=");
            sb.append(this.columnNames);
            sb.append(", referenceColumnNames=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.referenceColumnNames, '}');
        }
    }

    /* loaded from: classes.dex */
    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        public final String mFrom;
        public final int mId;
        public final int mSequence;
        public final String mTo;

        public ForeignKeyWithSequence(int r1, int r2, String str, String str2) {
            this.mId = r1;
            this.mSequence = r2;
            this.mFrom = str;
            this.mTo = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            ForeignKeyWithSequence foreignKeyWithSequence2 = foreignKeyWithSequence;
            int r1 = this.mId - foreignKeyWithSequence2.mId;
            if (r1 == 0) {
                return this.mSequence - foreignKeyWithSequence2.mSequence;
            }
            return r1;
        }
    }

    /* loaded from: classes.dex */
    public static class Index {
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String str, List list, boolean z) {
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Index.class != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                return false;
            }
            String str = this.name;
            boolean startsWith = str.startsWith("index_");
            String str2 = index.name;
            if (startsWith) {
                return str2.startsWith("index_");
            }
            return str.equals(str2);
        }

        public final int hashCode() {
            int hashCode;
            String str = this.name;
            if (str.startsWith("index_")) {
                hashCode = -1184239155;
            } else {
                hashCode = str.hashCode();
            }
            return this.columns.hashCode() + (((hashCode * 31) + (this.unique ? 1 : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Index{name='");
            sb.append(this.name);
            sb.append("', unique=");
            sb.append(this.unique);
            sb.append(", columns=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.columns, '}');
        }
    }

    public TableInfo(String str, HashMap hashMap, HashSet hashSet, HashSet hashSet2) {
        Set<Index> unmodifiableSet;
        this.name = str;
        this.columns = Collections.unmodifiableMap(hashMap);
        this.foreignKeys = Collections.unmodifiableSet(hashSet);
        if (hashSet2 == null) {
            unmodifiableSet = null;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(hashSet2);
        }
        this.indices = unmodifiableSet;
    }

    public static TableInfo read(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) {
        HashSet hashSet;
        boolean z;
        int r17;
        int r18;
        ArrayList arrayList;
        int r20;
        boolean z2;
        Cursor query = frameworkSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    if (query.getInt(columnIndex3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    hashMap.put(string, new Column(string, string2, z2, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            query.close();
            HashSet hashSet2 = new HashSet();
            query = frameworkSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = query.getColumnIndex(ConfigurationItem.COLUMN_NAME_ID);
                int columnIndex7 = query.getColumnIndex("seq");
                int columnIndex8 = query.getColumnIndex("table");
                int columnIndex9 = query.getColumnIndex("on_delete");
                int columnIndex10 = query.getColumnIndex("on_update");
                ArrayList readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
                int count = query.getCount();
                int r15 = 0;
                while (r15 < count) {
                    query.moveToPosition(r15);
                    if (query.getInt(columnIndex7) != 0) {
                        r17 = columnIndex6;
                        r18 = columnIndex7;
                        arrayList = readForeignKeyFieldMappings;
                        r20 = count;
                    } else {
                        int r6 = query.getInt(columnIndex6);
                        r17 = columnIndex6;
                        ArrayList arrayList2 = new ArrayList();
                        r18 = columnIndex7;
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = readForeignKeyFieldMappings.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList4 = readForeignKeyFieldMappings;
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) it.next();
                            int r202 = count;
                            if (foreignKeyWithSequence.mId == r6) {
                                arrayList2.add(foreignKeyWithSequence.mFrom);
                                arrayList3.add(foreignKeyWithSequence.mTo);
                            }
                            count = r202;
                            readForeignKeyFieldMappings = arrayList4;
                        }
                        arrayList = readForeignKeyFieldMappings;
                        r20 = count;
                        hashSet2.add(new ForeignKey(query.getString(columnIndex8), query.getString(columnIndex9), query.getString(columnIndex10), arrayList2, arrayList3));
                    }
                    r15++;
                    columnIndex6 = r17;
                    columnIndex7 = r18;
                    count = r20;
                    readForeignKeyFieldMappings = arrayList;
                }
                query.close();
                query = frameworkSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = query.getColumnIndex("name");
                    int columnIndex12 = query.getColumnIndex("origin");
                    int columnIndex13 = query.getColumnIndex("unique");
                    if (columnIndex11 != -1 && columnIndex12 != -1 && columnIndex13 != -1) {
                        hashSet = new HashSet();
                        while (query.moveToNext()) {
                            if ("c".equals(query.getString(columnIndex12))) {
                                String string3 = query.getString(columnIndex11);
                                if (query.getInt(columnIndex13) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Index readIndex = readIndex(frameworkSQLiteDatabase, string3, z);
                                if (readIndex != null) {
                                    hashSet.add(readIndex);
                                }
                            }
                        }
                        return new TableInfo(str, hashMap, hashSet2, hashSet);
                    }
                    query.close();
                    hashSet = null;
                    return new TableInfo(str, hashMap, hashSet2, hashSet);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static ArrayList readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(ConfigurationItem.COLUMN_NAME_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int r6 = 0; r6 < count; r6++) {
            cursor.moveToPosition(r6);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Index readIndex(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, boolean z) {
        Cursor query = frameworkSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (query.moveToNext()) {
                    if (query.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(query.getInt(columnIndex)), query.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new Index(str, arrayList, z);
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    public final boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || TableInfo.class != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = tableInfo.name;
        String str2 = this.name;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        Map<String, Column> map = tableInfo.columns;
        Map<String, Column> map2 = this.columns;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        Set<ForeignKey> set2 = tableInfo.foreignKeys;
        Set<ForeignKey> set3 = this.foreignKeys;
        if (set3 == null ? set2 != null : !set3.equals(set2)) {
            return false;
        }
        Set<Index> set4 = this.indices;
        if (set4 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set4.equals(set);
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r0 = 0;
        String str = this.name;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        Map<String, Column> map = this.columns;
        if (map != null) {
            r2 = map.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Set<ForeignKey> set = this.foreignKeys;
        if (set != null) {
            r0 = set.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}

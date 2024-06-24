package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;

/* loaded from: classes.dex */
public final class DBUtil {
    public static Cursor query(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z) {
        int r0;
        Cursor query = roomDatabase.query(roomSQLiteQuery);
        if (z && (query instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
            int count = abstractWindowedCursor.getCount();
            if (abstractWindowedCursor.hasWindow()) {
                r0 = abstractWindowedCursor.getWindow().getNumRows();
            } else {
                r0 = count;
            }
            if (r0 < count) {
                try {
                    MatrixCursor matrixCursor = new MatrixCursor(abstractWindowedCursor.getColumnNames(), abstractWindowedCursor.getCount());
                    while (abstractWindowedCursor.moveToNext()) {
                        Object[] objArr = new Object[abstractWindowedCursor.getColumnCount()];
                        for (int r02 = 0; r02 < abstractWindowedCursor.getColumnCount(); r02++) {
                            int type = abstractWindowedCursor.getType(r02);
                            if (type != 0) {
                                if (type != 1) {
                                    if (type != 2) {
                                        if (type != 3) {
                                            if (type == 4) {
                                                objArr[r02] = abstractWindowedCursor.getBlob(r02);
                                            } else {
                                                throw new IllegalStateException();
                                            }
                                        } else {
                                            objArr[r02] = abstractWindowedCursor.getString(r02);
                                        }
                                    } else {
                                        objArr[r02] = Double.valueOf(abstractWindowedCursor.getDouble(r02));
                                    }
                                } else {
                                    objArr[r02] = Long.valueOf(abstractWindowedCursor.getLong(r02));
                                }
                            } else {
                                objArr[r02] = null;
                            }
                        }
                        matrixCursor.addRow(objArr);
                    }
                    return matrixCursor;
                } finally {
                    abstractWindowedCursor.close();
                }
            }
        }
        return query;
    }

    public static int readVersion(File file) throws IOException {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int r10 = allocate.getInt();
                channel.close();
                return r10;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}

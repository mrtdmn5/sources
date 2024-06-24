package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class SerializableType extends BaseDataType {
    public static final SerializableType singleTon = new SerializableType();

    public SerializableType() {
        super(SqlType.SERIALIZABLE);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Class<?> getPrimaryClass() {
        return Serializable.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    throw SupervisorKt.create("Could not write serialized object to byte array: " + obj, e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.cursor.getBlob(r2);
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0043: MOVE (r6 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]) (LINE:68), block:B:15:0x0043 */
    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r6) throws SQLException {
        Exception e;
        Closeable closeable;
        ObjectInputStream objectInputStream;
        byte[] bArr = (byte[]) obj;
        Closeable closeable2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(closeable2);
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                IOUtils.closeQuietly(objectInputStream);
                return readObject;
            } catch (Exception e3) {
                e = e3;
                throw SupervisorKt.create("Could not read serialized object from byte array: " + Arrays.toString(bArr) + "(len " + bArr.length + ")", e);
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            IOUtils.closeQuietly(closeable2);
            throw th;
        }
    }
}

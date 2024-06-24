package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Table {
    public ByteBuffer bb;
    public int bb_pos;
    public int vtable_size;
    public int vtable_start;

    public Table() {
        if (Utf8Safe.DEFAULT == null) {
            Utf8Safe.DEFAULT = new Utf8Safe();
        }
    }

    public final int __offset(int r3) {
        if (r3 < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + r3);
        }
        return 0;
    }

    public final void __reset(int r1, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = r1;
            int r12 = r1 - byteBuffer.getInt(r1);
            this.vtable_start = r12;
            this.vtable_size = this.bb.getShort(r12);
            return;
        }
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }
}

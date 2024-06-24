package okio;

import java.util.ArrayList;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* compiled from: Options.kt */
/* loaded from: classes4.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;
    public final int[] trie;

    /* compiled from: Options.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static void buildTrieRecursive(long j, Buffer buffer, int r24, ArrayList arrayList, int r26, int r27, ArrayList arrayList2) {
            int r7;
            int r2;
            int r5;
            int r17;
            Buffer buffer2;
            long j2;
            int r1 = r24;
            if (r26 < r27) {
                for (int r52 = r26; r52 < r27; r52++) {
                    if (!(((ByteString) arrayList.get(r52)).getSize$okio() >= r1)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) arrayList.get(r26);
                ByteString byteString2 = (ByteString) arrayList.get(r27 - 1);
                int r13 = -1;
                if (r1 == byteString.getSize$okio()) {
                    int intValue = ((Number) arrayList2.get(r26)).intValue();
                    int r22 = r26 + 1;
                    ByteString byteString3 = (ByteString) arrayList.get(r22);
                    r7 = r22;
                    r2 = intValue;
                    byteString = byteString3;
                } else {
                    r7 = r26;
                    r2 = -1;
                }
                if (byteString.internalGet$okio(r1) != byteString2.internalGet$okio(r1)) {
                    int r4 = 1;
                    for (int r3 = r7 + 1; r3 < r27; r3++) {
                        if (((ByteString) arrayList.get(r3 - 1)).internalGet$okio(r1) != ((ByteString) arrayList.get(r3)).internalGet$okio(r1)) {
                            r4++;
                        }
                    }
                    long j3 = 4;
                    long j4 = (r4 * 2) + (buffer.size / j3) + j + 2;
                    buffer.m1735writeInt(r4);
                    buffer.m1735writeInt(r2);
                    for (int r23 = r7; r23 < r27; r23++) {
                        int internalGet$okio = ((ByteString) arrayList.get(r23)).internalGet$okio(r1);
                        if (r23 == r7 || internalGet$okio != ((ByteString) arrayList.get(r23 - 1)).internalGet$okio(r1)) {
                            buffer.m1735writeInt(internalGet$okio & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (r7 < r27) {
                        byte internalGet$okio2 = ((ByteString) arrayList.get(r7)).internalGet$okio(r1);
                        int r32 = r7 + 1;
                        int r42 = r32;
                        while (true) {
                            if (r42 >= r27) {
                                r5 = r27;
                                break;
                            } else {
                                if (internalGet$okio2 != ((ByteString) arrayList.get(r42)).internalGet$okio(r1)) {
                                    r5 = r42;
                                    break;
                                }
                                r42++;
                            }
                        }
                        if (r32 == r5 && r1 + 1 == ((ByteString) arrayList.get(r7)).getSize$okio()) {
                            buffer.m1735writeInt(((Number) arrayList2.get(r7)).intValue());
                            r17 = r5;
                            buffer2 = buffer3;
                            j2 = j3;
                        } else {
                            buffer.m1735writeInt(((int) ((buffer3.size / j3) + j4)) * r13);
                            r17 = r5;
                            buffer2 = buffer3;
                            j2 = j3;
                            buildTrieRecursive(j4, buffer3, r1 + 1, arrayList, r7, r17, arrayList2);
                        }
                        buffer3 = buffer2;
                        r7 = r17;
                        j3 = j2;
                        r13 = -1;
                    }
                    buffer.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.getSize$okio(), byteString2.getSize$okio());
                int r132 = 0;
                for (int r9 = r1; r9 < min && byteString.internalGet$okio(r9) == byteString2.internalGet$okio(r9); r9++) {
                    r132++;
                }
                long j5 = 4;
                long j6 = (buffer.size / j5) + j + 2 + r132 + 1;
                buffer.m1735writeInt(-r132);
                buffer.m1735writeInt(r2);
                int r6 = r1 + r132;
                while (r1 < r6) {
                    buffer.m1735writeInt(byteString.internalGet$okio(r1) & 255);
                    r1++;
                }
                if (r7 + 1 == r27) {
                    if (r6 == ((ByteString) arrayList.get(r7)).getSize$okio()) {
                        buffer.m1735writeInt(((Number) arrayList2.get(r7)).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer4 = new Buffer();
                buffer.m1735writeInt(((int) ((buffer4.size / j5) + j6)) * (-1));
                buildTrieRecursive(j6, buffer4, r6, arrayList, r7, r27, arrayList2);
                buffer.writeAll(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00e9, code lost:            continue;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static okio.Options of(okio.ByteString... r11) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }
    }

    public Options(ByteString[] byteStringArr, int[] r2) {
        this.byteStrings = byteStringArr;
        this.trie = r2;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return super.contains((ByteString) obj);
    }

    @Override // java.util.List
    public final Object get(int r2) {
        return this.byteStrings[r2];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return super.indexOf((ByteString) obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return super.lastIndexOf((ByteString) obj);
    }
}

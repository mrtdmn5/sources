package com.animaconnected.watch.display;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class ImageCommand extends DrawCommand {
    private final byte[] bytes;
    private final String bytesHash;
    private final Integer color;
    private final Integer colorOpa;
    private final Integer contID;
    private final int height;
    private final String imgName;
    private final String imgNameReference;
    private final String link;
    private final int width;
    private final int x;
    private final int y;

    public /* synthetic */ ImageCommand(int r13, int r14, int r15, int r16, byte[] bArr, String str, String str2, Integer num, int r21, DefaultConstructorMarker defaultConstructorMarker) {
        this((r21 & 1) != 0 ? 0 : r13, (r21 & 2) != 0 ? 0 : r14, r15, r16, bArr, str, (r21 & 64) != 0 ? null : str2, (r21 & 128) != 0 ? null : num);
    }

    public static /* synthetic */ ImageCommand copy$default(ImageCommand imageCommand, int r10, int r11, int r12, int r13, byte[] bArr, String str, String str2, Integer num, int r18, Object obj) {
        int r2;
        int r3;
        int r4;
        int r5;
        byte[] bArr2;
        String str3;
        String str4;
        Integer num2;
        if ((r18 & 1) != 0) {
            r2 = imageCommand.x;
        } else {
            r2 = r10;
        }
        if ((r18 & 2) != 0) {
            r3 = imageCommand.y;
        } else {
            r3 = r11;
        }
        if ((r18 & 4) != 0) {
            r4 = imageCommand.width;
        } else {
            r4 = r12;
        }
        if ((r18 & 8) != 0) {
            r5 = imageCommand.height;
        } else {
            r5 = r13;
        }
        if ((r18 & 16) != 0) {
            bArr2 = imageCommand.bytes;
        } else {
            bArr2 = bArr;
        }
        if ((r18 & 32) != 0) {
            str3 = imageCommand.bytesHash;
        } else {
            str3 = str;
        }
        if ((r18 & 64) != 0) {
            str4 = imageCommand.link;
        } else {
            str4 = str2;
        }
        if ((r18 & 128) != 0) {
            num2 = imageCommand.contID;
        } else {
            num2 = num;
        }
        return imageCommand.copy(r2, r3, r4, r5, bArr2, str3, str4, num2);
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.y;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final byte[] component5() {
        return this.bytes;
    }

    public final String component6() {
        return this.bytesHash;
    }

    public final String component7() {
        return this.link;
    }

    public final Integer component8() {
        return this.contID;
    }

    public final ImageCommand copy(int r11, int r12, int r13, int r14, byte[] bytes, String bytesHash, String str, Integer num) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(bytesHash, "bytesHash");
        return new ImageCommand(r11, r12, r13, r14, bytes, bytesHash, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageCommand)) {
            return false;
        }
        ImageCommand imageCommand = (ImageCommand) obj;
        if (this.x == imageCommand.x && this.y == imageCommand.y && this.width == imageCommand.width && this.height == imageCommand.height && Intrinsics.areEqual(this.bytes, imageCommand.bytes) && Intrinsics.areEqual(this.bytesHash, imageCommand.bytesHash) && Intrinsics.areEqual(this.link, imageCommand.link) && Intrinsics.areEqual(this.contID, imageCommand.contID)) {
            return true;
        }
        return false;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final String getBytesHash() {
        return this.bytesHash;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Integer getContID() {
        return this.contID;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImgName() {
        return this.imgName;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        int hashCode;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.bytesHash, (Arrays.hashCode(this.bytes) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.height, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.width, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y, Integer.hashCode(this.x) * 31, 31), 31), 31)) * 31, 31);
        String str = this.link;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num = this.contID;
        if (num != null) {
            r2 = num.hashCode();
        }
        return r0 + r2;
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Image), new Pair(Parameter.Data, this.imgNameReference), new Pair(Parameter.X, Integer.valueOf(this.x)), new Pair(Parameter.Y, Integer.valueOf(this.y)));
        Integer num = this.contID;
        if (num != null) {
            mutableMapOf.put(Parameter.Id, num);
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageCommand(x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", bytes=");
        sb.append(Arrays.toString(this.bytes));
        sb.append(", bytesHash=");
        sb.append(this.bytesHash);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", contID=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.contID, ')');
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCommand(int r2, int r3, int r4, int r5, byte[] bytes, String bytesHash, String str, Integer num) {
        super(null);
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(bytesHash, "bytesHash");
        this.x = r2;
        this.y = r3;
        this.width = r4;
        this.height = r5;
        this.bytes = bytes;
        this.bytesHash = bytesHash;
        this.link = str;
        this.contID = num;
        this.imgName = str == null ? bytesHash : str;
        this.imgNameReference = str != null ? ConstraintSet$$ExternalSyntheticOutline0.m("$", str) : bytesHash;
    }
}

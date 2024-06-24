package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: Composers.kt */
/* loaded from: classes4.dex */
public final class ComposerWithPrettyPrint extends Composer {
    public final Json json;
    public int level;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(JsonToStringWriter jsonToStringWriter, Json json) {
        super(jsonToStringWriter);
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void indent() {
        this.writingFirst = true;
        this.level++;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void nextItem() {
        this.writingFirst = false;
        print("\n");
        int r1 = this.level;
        for (int r0 = 0; r0 < r1; r0++) {
            print(this.json.configuration.prettyPrintIndent);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void space() {
        print(' ');
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void unIndent() {
        this.level--;
    }
}

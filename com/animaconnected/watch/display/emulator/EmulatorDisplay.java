package com.animaconnected.watch.display.emulator;

import com.animaconnected.watch.display.BackCommand;
import com.animaconnected.watch.display.ButtonCommand;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.ContainerCommand;
import com.animaconnected.watch.display.DrawCommand;
import com.animaconnected.watch.display.ImageCommand;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.LineCommand;
import com.animaconnected.watch.display.PascalDisplay;
import com.animaconnected.watch.display.ProgressBarCommand;
import com.animaconnected.watch.display.RectCommand;
import com.animaconnected.watch.display.TextCommand;
import com.animaconnected.watch.display.WatchKanvas;
import com.animaconnected.watch.image.ImageBuilder;
import com.animaconnected.watch.image.Kolors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmulatorDisplay.kt */
/* loaded from: classes3.dex */
public final class EmulatorDisplay implements EmulatedDisplay {
    private List<? extends DrawCommand> commands;
    private Map<Integer, ContainerCommand> containers;
    private final Function0<Unit> drawCallback;
    private Kanvas kanvas;
    private CanvasPaint linePaint;
    private boolean pascalFull;
    private CanvasPaint textPaint;

    public EmulatorDisplay(Kanvas kanvas, CanvasPaint linePaint, CanvasPaint textPaint, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(linePaint, "linePaint");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.kanvas = kanvas;
        this.linePaint = linePaint;
        this.textPaint = textPaint;
        this.drawCallback = function0;
        int r0 = 0;
        kanvas.setDisplayMultiplier(new WatchKanvas(r0, r0, 3, null).getDisplayMultiplier());
        this.commands = EmptyList.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Pair<Float, Float> calculateOffset(DrawCommand drawCommand) {
        int r3;
        int r0;
        Pair pair;
        int r7;
        int r72;
        boolean z = this.pascalFull;
        int r1 = 0;
        if (z) {
            r3 = 0;
        } else {
            r3 = 20;
        }
        if (z) {
            r0 = 0;
        } else {
            r0 = PascalDisplay.marginTop;
        }
        ContainerCommand containerCommand = null;
        if (drawCommand instanceof TextCommand) {
            Integer containerId = ((TextCommand) drawCommand).getContainerId();
            if (containerId != null) {
                int intValue = containerId.intValue();
                Map<Integer, ContainerCommand> map = this.containers;
                if (map != null) {
                    containerCommand = map.get(Integer.valueOf(intValue));
                }
            }
            if (containerCommand != null) {
                r72 = containerCommand.getX();
            } else {
                r72 = 0;
            }
            if (containerCommand != null) {
                r1 = containerCommand.getY();
            }
            pair = new Pair(Integer.valueOf(r72), Integer.valueOf(r1));
        } else if (drawCommand instanceof ButtonCommand) {
            int contID = ((ButtonCommand) drawCommand).getContID();
            Map<Integer, ContainerCommand> map2 = this.containers;
            if (map2 != null) {
                containerCommand = map2.get(Integer.valueOf(contID));
            }
            if (containerCommand != null) {
                r7 = containerCommand.getX();
            } else {
                r7 = 0;
            }
            if (containerCommand != null) {
                r1 = containerCommand.getY();
            }
            pair = new Pair(Integer.valueOf(r7), Integer.valueOf(r1));
        } else if (drawCommand instanceof ContainerCommand) {
            ContainerCommand containerCommand2 = (ContainerCommand) drawCommand;
            pair = new Pair(Integer.valueOf(containerCommand2.getX()), Integer.valueOf(containerCommand2.getY()));
        } else {
            pair = new Pair(0, 0);
        }
        return new Pair<>(Float.valueOf(r3 + ((Number) pair.first).intValue()), Float.valueOf(r0 + ((Number) pair.second).intValue()));
    }

    private final void preparePaint(DrawCommand drawCommand) {
        if (drawCommand instanceof LineCommand) {
            this.linePaint.setColor(((LineCommand) drawCommand).getColor());
            this.linePaint.setWidth(r3.getThickness());
            return;
        }
        if (drawCommand instanceof RectCommand) {
            RectCommand rectCommand = (RectCommand) drawCommand;
            this.textPaint.setColor(rectCommand.getColor());
            this.linePaint.setColor(rectCommand.getColor());
            this.linePaint.setWidth(rectCommand.getThickness());
            return;
        }
        if (drawCommand instanceof TextCommand) {
            this.textPaint.setColor(((TextCommand) drawCommand).getColor());
            return;
        }
        if (drawCommand instanceof ImageCommand) {
            Integer color = ((ImageCommand) drawCommand).getColor();
            if (color != null) {
                this.textPaint.setColor(color.intValue());
                return;
            }
            return;
        }
        if (drawCommand instanceof ButtonCommand) {
            ((ButtonCommand) drawCommand).getColor();
        } else if (!(drawCommand instanceof ContainerCommand) && !(drawCommand instanceof ProgressBarCommand)) {
            boolean z = drawCommand instanceof BackCommand;
        }
    }

    public final void draw() {
        draw(new RectCommand(0, 0, 390, 390, true, 0, Kolors.black, 32, null));
        if (this.commands.isEmpty()) {
            return;
        }
        Iterator<T> it = this.commands.iterator();
        while (it.hasNext()) {
            draw((DrawCommand) it.next());
        }
    }

    public final Kanvas getKanvas() {
        return this.kanvas;
    }

    public final boolean getPascalFull() {
        return this.pascalFull;
    }

    @Override // com.animaconnected.watch.display.emulator.EmulatedDisplay
    public void setDrawCommands(List<? extends DrawCommand> drawCommands) {
        Intrinsics.checkNotNullParameter(drawCommands, "drawCommands");
        List<? extends DrawCommand> list = drawCommands;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ContainerCommand) {
                arrayList.add(obj);
            }
        }
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj2 : arrayList) {
            linkedHashMap.put(Integer.valueOf(((ContainerCommand) obj2).getId()), obj2);
        }
        this.containers = linkedHashMap;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add((DrawCommand) it.next());
        }
        this.commands = arrayList2;
        Function0<Unit> function0 = this.drawCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setKanvas(Kanvas kanvas) {
        Intrinsics.checkNotNullParameter(kanvas, "<set-?>");
        this.kanvas = kanvas;
    }

    public final void setPascalFull(boolean z) {
        this.pascalFull = z;
        draw();
    }

    private final void draw(DrawCommand drawCommand) {
        preparePaint(drawCommand);
        Pair<Float, Float> calculateOffset = calculateOffset(drawCommand);
        float floatValue = calculateOffset.first.floatValue();
        float floatValue2 = calculateOffset.second.floatValue();
        if (drawCommand instanceof LineCommand) {
            LineCommand lineCommand = (LineCommand) drawCommand;
            this.kanvas.drawLine(lineCommand.getX1() + floatValue, lineCommand.getY1() + floatValue2, lineCommand.getX2() + floatValue, lineCommand.getY2() + floatValue2, this.linePaint);
            return;
        }
        if (drawCommand instanceof RectCommand) {
            preparePaint(drawCommand);
            this.kanvas.drawRect(r0.getX() + floatValue, r0.getY() + floatValue2, r0.getWidth() + r0.getX() + floatValue, r0.getHeight() + r0.getY() + floatValue2, ((RectCommand) drawCommand).getFill() ? this.textPaint : this.linePaint);
            return;
        }
        if (drawCommand instanceof TextCommand) {
            Kanvas.drawText$default(this.kanvas, ((TextCommand) drawCommand).getText(), r0.getX() + floatValue, r0.getY() + 10 + floatValue2, 0.0f, null, this.textPaint, 24, null);
            return;
        }
        if (drawCommand instanceof ImageCommand) {
            preparePaint(drawCommand);
            try {
                Kanvas.drawImage$default(this.kanvas, ((ImageCommand) drawCommand).getX() + floatValue, ((ImageCommand) drawCommand).getY() + floatValue2, r11.getWidth(), r11.getHeight(), ImageBuilder.INSTANCE.decodeToMitmap(((ImageCommand) drawCommand).getBytes()), null, 32, null);
                return;
            } catch (Exception e) {
                Kanvas kanvas = this.kanvas;
                String obj = e.toString();
                ImageCommand imageCommand = (ImageCommand) drawCommand;
                Kanvas.drawText$default(kanvas, obj, imageCommand.getX() + floatValue, imageCommand.getY() + floatValue2, 0.0f, null, this.textPaint, 24, null);
                return;
            }
        }
        if (drawCommand instanceof ButtonCommand) {
            String upperCase = ((ButtonCommand) drawCommand).getText().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            draw(new TextCommand(upperCase, (int) floatValue, (int) floatValue2, 0, null, null, null, null, null, 504, null));
        } else {
            if (drawCommand instanceof ContainerCommand) {
                return;
            }
            if (drawCommand instanceof ProgressBarCommand) {
                preparePaint(drawCommand);
                ProgressBarCommand progressBarCommand = (ProgressBarCommand) drawCommand;
                this.kanvas.drawRect(progressBarCommand.getX() + floatValue, progressBarCommand.getY() + floatValue2, progressBarCommand.getWidth() + progressBarCommand.getX() + floatValue, progressBarCommand.getHeight() + progressBarCommand.getY() + floatValue2, this.textPaint);
                return;
            }
            boolean z = drawCommand instanceof BackCommand;
        }
    }

    public /* synthetic */ EmulatorDisplay(Kanvas kanvas, CanvasPaint canvasPaint, CanvasPaint canvasPaint2, Function0 function0, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(kanvas, canvasPaint, canvasPaint2, (r5 & 8) != 0 ? null : function0);
    }
}

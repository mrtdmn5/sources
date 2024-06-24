package com.animaconnected.watch.display.view;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.BackCommand;
import com.animaconnected.watch.display.ButtonCommand;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.ContainerCommand;
import com.animaconnected.watch.display.DrawCommand;
import com.animaconnected.watch.display.HidCommand;
import com.animaconnected.watch.display.LineCommand;
import com.animaconnected.watch.display.Point;
import com.animaconnected.watch.display.ProgressBarCommand;
import com.animaconnected.watch.display.RectCommand;
import com.animaconnected.watch.display.TextCommand;
import com.animaconnected.watch.display.VarType;
import com.animaconnected.watch.display.WatchPaint;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Mitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class DisplayDefinitionKt {

    /* compiled from: DisplayDefinition.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Position.values().length];
            try {
                r0[Position.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Position.Left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Position.BottomLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Position.Top.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Position.Center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Position.Bottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[Position.TopRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[Position.Right.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r0[Position.BottomRight.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final int adjustXtoPosition(Element element, int r3, int r4) {
        switch (WhenMappings.$EnumSwitchMapping$0[element.getPosition().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return r3;
            case 4:
            case 5:
            case 6:
                return r3 + ((r4 / 2) - (Math.min(r4, element.getWidth()) / 2));
            case 7:
            case 8:
            case 9:
                return (r3 + r4) - Math.min(r4, element.getWidth());
            default:
                return r3 + element.getX();
        }
    }

    private static final int adjustYtoPosition(Element element, int r3, int r4) {
        switch (WhenMappings.$EnumSwitchMapping$0[element.getPosition().ordinal()]) {
            case 1:
            case 4:
            case 7:
                return r3;
            case 2:
            case 5:
            case 8:
                return r3 + ((r4 / 2) - (Math.min(r4, element.getHeight()) / 2));
            case 3:
            case 6:
            case 9:
                return (r3 + r4) - Math.min(r4, element.getHeight());
            default:
                return r3 + element.getY();
        }
    }

    public static final Rectangle bottomContainer(Display display, int r5, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(display, new Rectangle(r5 + 36, 230, 318 - (r5 * 2), 79), init);
    }

    public static /* synthetic */ Rectangle bottomContainer$default(Display display, int r1, Function1 function1, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = 0;
        }
        return bottomContainer(display, r1, function1);
    }

    public static final BottomPusher bottomPusher(Display display, Function1<? super BottomPusher, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (BottomPusher) initElement(display, new BottomPusher(-1), init);
    }

    public static /* synthetic */ BottomPusher bottomPusher$default(Display display, Function1 function1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            function1 = new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$bottomPusher$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BottomPusher bottomPusher) {
                    Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                    invoke2(bottomPusher);
                    return Unit.INSTANCE;
                }
            };
        }
        return bottomPusher(display, function1);
    }

    public static final Button button(Display display, DisplayString text, Function1<? super Button, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Button) initElement(display, new Button(text.firmware(), 0, 2, null), init);
    }

    public static /* synthetic */ Button button$default(Display display, DisplayString displayString, Function1 function1, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            function1 = new Function1<Button, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$button$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Button button) {
                    Intrinsics.checkNotNullParameter(button, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                    invoke2(button);
                    return Unit.INSTANCE;
                }
            };
        }
        return button(display, displayString, function1);
    }

    public static final CanvasPaint createColorPaint(int r2, boolean z, float f) {
        WatchPaint watchPaint = new WatchPaint(Kolor.m1537constructorimpl(r2), z, null);
        watchPaint.setWidth(f);
        return watchPaint;
    }

    public static /* synthetic */ CanvasPaint createColorPaint$default(int r0, boolean z, float f, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = false;
        }
        if ((r3 & 4) != 0) {
            f = 1.0f;
        }
        return createColorPaint(r0, z, f);
    }

    public static final Display display(Function1<? super Display, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Display display = new Display();
        init.invoke(display);
        return display;
    }

    public static final void drawBack(List<DrawCommand> list, int r2, Integer num) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.add(new BackCommand(r2, num));
    }

    public static final void drawButton(List<DrawCommand> list, String text, int r14, int r15, int r16, List<? extends HidCommand> list2, Integer num, Integer num2, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        list.add(new ButtonCommand(text, r14, 0, null, list2, num, num2, 12, null));
    }

    public static final void drawContainer(List<DrawCommand> list, int r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.add(new ContainerCommand(r8, r9, r10, r11, r12));
    }

    public static /* synthetic */ void drawContainer$default(List list, int r8, int r9, int r10, int r11, int r12, int r13, Object obj) {
        int r5;
        int r6;
        if ((r13 & 8) != 0) {
            r5 = 0;
        } else {
            r5 = r11;
        }
        if ((r13 & 16) != 0) {
            r6 = 0;
        } else {
            r6 = r12;
        }
        drawContainer(list, r8, r9, r10, r5, r6);
    }

    public static final void drawImage(List<DrawCommand> list, int r2, int r3, Mitmap mitmap, String str, Integer num) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        list.add(GraphicsKt.toImageCommand(mitmap, r2, r3, str, num));
    }

    public static /* synthetic */ void drawImage$default(List list, int r8, int r9, Mitmap mitmap, String str, Integer num, int r13, Object obj) {
        String str2;
        Integer num2;
        if ((r13 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((r13 & 16) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        drawImage(list, r8, r9, mitmap, str2, num2);
    }

    public static final void drawLine(List<DrawCommand> list, int r9, int r10, int r11, int r12, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        list.add(new LineCommand(r9, r10, r11, r12, (int) paint.getWidth(), paint.getColor()));
    }

    public static final void drawProgressBar(List<DrawCommand> list, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.add(new ProgressBarCommand(r2, r3, r4, r5));
    }

    public static /* synthetic */ void drawProgressBar$default(List list, int r2, int r3, int r4, int r5, int r6, Object obj) {
        if ((r6 & 4) != 0) {
            r4 = 0;
        }
        if ((r6 & 8) != 0) {
            r5 = 0;
        }
        drawProgressBar(list, r2, r3, r4, r5);
    }

    public static final void drawRect(List<DrawCommand> list, int r13, int r14, int r15, int r16, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        list.add(new RectCommand(r13, r14, r13 - r15, r16 - r14, paint.getFill(), 0, paint.getColor(), 32, null));
    }

    public static final void drawText(List<DrawCommand> list, String text, int r16, int r17, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        list.add(new TextCommand(text, r16, r17, 0, paint.getFont(), null, null, null, null, 488, null));
    }

    public static final void drawWatchText(List<DrawCommand> list, String text, int r16, int r17, CanvasPaint paint, Integer num, Integer num2, Integer num3, String str) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        list.add(new TextCommand(text, r16, r17, 0, paint.getFont(), num, num2, num3, str, 8, null));
    }

    public static /* synthetic */ void drawWatchText$default(List list, String str, int r12, int r13, CanvasPaint canvasPaint, Integer num, Integer num2, Integer num3, String str2, int r19, Object obj) {
        String str3;
        if ((r19 & 128) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        drawWatchText(list, str, r12, r13, canvasPaint, num, num2, num3, str3);
    }

    public static final Rectangle fullDisplayArea(Display display, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(display, new Rectangle(0, 0, 390, 390), init);
    }

    public static final Image image(ScrollContainer scrollContainer, int r2, int r3, Mitmap mitmap, String str, Function1<? super Image, Unit> init) {
        Intrinsics.checkNotNullParameter(scrollContainer, "<this>");
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Image) initElement(scrollContainer, new Image(r2, r3, mitmap, str), init);
    }

    public static /* synthetic */ Image image$default(ScrollContainer scrollContainer, int r8, int r9, Mitmap mitmap, String str, Function1 function1, int r13, Object obj) {
        int r2 = (r13 & 1) != 0 ? 0 : r8;
        int r3 = (r13 & 2) != 0 ? 0 : r9;
        if ((r13 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((r13 & 16) != 0) {
            function1 = new Function1<Image, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$image$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Image image) {
                    Intrinsics.checkNotNullParameter(image, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                    invoke2(image);
                    return Unit.INSTANCE;
                }
            };
        }
        return image(scrollContainer, r2, r3, mitmap, str2, (Function1<? super Image, Unit>) function1);
    }

    public static final <T extends Element> T initElement(Container container, T element, Function1<? super T, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(init, "init");
        init.invoke(element);
        container.getChildren().add(element);
        return element;
    }

    public static /* synthetic */ Element initElement$default(Container container, Element element, Function1 function1, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            function1 = new Function1() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$initElement$1
                public final void invoke(Element element2) {
                    Intrinsics.checkNotNullParameter(element2, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Element) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return initElement(container, element, function1);
    }

    public static final Line line(Container container, int r2, int r3, int r4, int r5, Function1<? super Line, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Line) initElement(container, new Line(r2, r3, r4, r5), init);
    }

    public static /* synthetic */ Line line$default(Container container, int r7, int r8, int r9, int r10, Function1 function1, int r12, Object obj) {
        if ((r12 & 16) != 0) {
            function1 = new Function1<Line, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$line$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Line line) {
                    Intrinsics.checkNotNullParameter(line, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Line line) {
                    invoke2(line);
                    return Unit.INSTANCE;
                }
            };
        }
        return line(container, r7, r8, r9, r10, function1);
    }

    public static final ListView listView(Container container, int r2, int r3, int r4, int r5, Function1<? super ListView, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (ListView) initElement(container, new ListView(r2, r3, r4, r5), init);
    }

    public static /* synthetic */ ListView listView$default(Container container, int r8, int r9, int r10, int r11, Function1 function1, int r13, Object obj) {
        int r2;
        int r3;
        if ((r13 & 1) != 0) {
            r2 = 0;
        } else {
            r2 = r8;
        }
        if ((r13 & 2) != 0) {
            r3 = 0;
        } else {
            r3 = r9;
        }
        return listView(container, r2, r3, r10, r11, function1);
    }

    private static final void parseElements(int r24, int r25, int r26, int r27, Orientation orientation, List<? extends Element> list, List<DrawCommand> list2, Integer num) {
        int r10;
        int r11;
        boolean z;
        Element element;
        int r112;
        int r102;
        int r7;
        int y;
        int x2;
        int y2;
        int r72;
        int r73;
        Text text;
        ListView listView;
        int adjustXtoPosition;
        int adjustYtoPosition;
        int r0 = r24;
        int r1 = r25;
        Orientation orientation2 = orientation;
        int r16 = 0;
        int r17 = 0;
        for (Element element2 : list) {
            if (element2.getX() != Integer.MIN_VALUE && element2.getY() != Integer.MIN_VALUE) {
                if (orientation2 == Orientation.Horizontal) {
                    adjustXtoPosition = r0 + r16;
                } else {
                    adjustXtoPosition = adjustXtoPosition(element2, r0, r26);
                }
                if (orientation2 == Orientation.Vertical) {
                    adjustYtoPosition = r1 + r17;
                } else {
                    adjustYtoPosition = adjustYtoPosition(element2, r1, r27);
                }
                r11 = adjustXtoPosition;
                r10 = adjustYtoPosition;
            } else {
                r10 = 0;
                r11 = 0;
            }
            boolean z2 = element2 instanceof Rectangle;
            Integer num2 = null;
            Orientation orientation3 = null;
            if (z2) {
                int min = Math.min(r26, element2.getWidth());
                int min2 = Math.min(r27, element2.getHeight());
                if (element2 instanceof ListView) {
                    listView = (ListView) element2;
                } else {
                    listView = null;
                }
                if (listView != null) {
                    orientation3 = listView.getOrientation();
                }
                Rectangle rectangle = (Rectangle) element2;
                z = z2;
                int r13 = r10;
                int r02 = r11;
                element = element2;
                parseElements(r11, r10, min, min2, orientation3, rectangle.getChildren(), list2, num);
                Kolor m1113getColorXHNnPzI = rectangle.m1113getColorXHNnPzI();
                if (m1113getColorXHNnPzI != null) {
                    drawRect(list2, r02, r13, r02 + min, r13 + min2, createColorPaint(m1113getColorXHNnPzI.m1546unboximpl(), rectangle.getFill(), rectangle.getThickness()));
                }
                r16 += min;
                r17 += min2;
            } else {
                z = z2;
                int r132 = r10;
                int r03 = r11;
                element = element2;
                boolean z3 = element instanceof Text;
                boolean z4 = true;
                if (z3) {
                    if (element.getX() != 0) {
                        r03 = element.getX();
                    }
                    if (element.getY() != 0) {
                        r132 = element.getY();
                    }
                    if (z3) {
                        text = (Text) element;
                    } else {
                        text = null;
                    }
                    if (text == null || text.getMultiLines()) {
                        z4 = false;
                    }
                    if (z4) {
                        num2 = Integer.valueOf(element.getHeight());
                    }
                    Text text2 = (Text) element;
                    drawWatchText(list2, text2.getText(), r03, r132, text2.getPaint(), num, Integer.valueOf(Math.min(r26, element.getWidth())), num2, text2.getLink());
                } else if (element instanceof Button) {
                    Button button = (Button) element;
                    String text3 = button.getText();
                    if (num != null) {
                        r73 = num.intValue();
                    } else {
                        r73 = -1;
                    }
                    drawButton(list2, text3, r73, element.getX(), element.getY(), button.getHidCommands(), button.getNavCommand(), button.getAnimation(), button.getPaint());
                } else if (element instanceof BottomPusher) {
                    BottomPusher bottomPusher = (BottomPusher) element;
                    drawBack(list2, bottomPusher.getNavCommand(), bottomPusher.getAnimation());
                } else if (element instanceof ScrollContainer) {
                    List<DrawCommand> list3 = list2;
                    if ((list3 instanceof Collection) && list3.isEmpty()) {
                        r72 = 0;
                    } else {
                        Iterator<T> it = list3.iterator();
                        r72 = 0;
                        while (it.hasNext()) {
                            if ((((DrawCommand) it.next()) instanceof ContainerCommand) && (r72 = r72 + 1) < 0) {
                                CollectionsKt__CollectionsKt.throwCountOverflow();
                                throw null;
                            }
                        }
                    }
                    int r18 = r72 + 1;
                    int min3 = Math.min(r26, element.getWidth());
                    int min4 = Math.min(r27, element.getHeight());
                    drawContainer$default(list2, r18, r03, r132, min3, 0, 16, null);
                    parseElements(0, 0, min3, min4, null, ((ScrollContainer) element).getChildren(), list2, Integer.valueOf(r18));
                } else if (element instanceof Variable) {
                    drawText(list2, ((Variable) element).getType().name(), r03, r132, createColorPaint$default(-1, false, 0.0f, 6, null));
                } else if (element instanceof Line) {
                    if (element.getX() != Integer.MIN_VALUE) {
                        r03 = element.getX();
                    }
                    if (element.getY() == Integer.MIN_VALUE) {
                        y = r132;
                    } else {
                        y = element.getY();
                    }
                    Line line = (Line) element;
                    if (line.getX2() == Integer.MIN_VALUE) {
                        x2 = element.getWidth() + r03;
                    } else {
                        x2 = line.getX2();
                    }
                    if (line.getY2() == Integer.MIN_VALUE) {
                        y2 = element.getHeight() + y;
                    } else {
                        y2 = line.getY2();
                    }
                    drawLine(list2, r03, y, x2, y2, createColorPaint$default(line.m1111getColorIpmnaRI(), false, line.getThickness(), 2, null));
                } else if (element instanceof Image) {
                    if (element.getX() != 0) {
                        r03 = element.getX();
                    }
                    int r6 = r03;
                    if (element.getY() != 0) {
                        r7 = element.getY();
                    } else {
                        r7 = r132;
                    }
                    Image image = (Image) element;
                    drawImage(list2, r6, r7, image.getMitmap(), image.getLink(), num);
                } else if (element instanceof ProgressBar) {
                    if (element.getX() != 0) {
                        r112 = element.getX();
                    } else {
                        r112 = r03;
                    }
                    if (element.getY() != 0) {
                        r102 = element.getY();
                    } else {
                        r102 = r132;
                    }
                    drawProgressBar(list2, r112, r102, Math.min(r26, element.getWidth()), Math.min(r27, element.getHeight()));
                }
            }
            if (!z) {
                r16 = element.getWidth() + r16;
                r17 = element.getHeight() + r17;
            }
            r0 = r24;
            r1 = r25;
            orientation2 = orientation;
        }
    }

    public static /* synthetic */ void parseElements$default(int r9, int r10, int r11, int r12, Orientation orientation, List list, List list2, Integer num, int r17, Object obj) {
        Integer num2;
        if ((r17 & 128) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        parseElements(r9, r10, r11, r12, orientation, list, list2, num2);
    }

    public static final ProgressBar progressbar(Container container, int r2, int r3, int r4, int r5, Function1<? super ProgressBar, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (ProgressBar) initElement(container, new ProgressBar(r2, r3, r4, r5), init);
    }

    public static /* synthetic */ ProgressBar progressbar$default(Container container, int r2, int r3, int r4, int r5, Function1 function1, int r7, Object obj) {
        if ((r7 & 1) != 0) {
            r2 = 0;
        }
        if ((r7 & 2) != 0) {
            r3 = 0;
        }
        if ((r7 & 4) != 0) {
            r4 = 0;
        }
        if ((r7 & 8) != 0) {
            r5 = 0;
        }
        if ((r7 & 16) != 0) {
            function1 = new Function1<ProgressBar, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$progressbar$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProgressBar progressBar) {
                    Intrinsics.checkNotNullParameter(progressBar, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProgressBar progressBar) {
                    invoke2(progressBar);
                    return Unit.INSTANCE;
                }
            };
        }
        return progressbar(container, r2, r3, r4, r5, function1);
    }

    public static final Rectangle rectangle(Container container, int r2, int r3, int r4, int r5, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(container, new Rectangle(r2, r3, r4, r5), init);
    }

    public static /* synthetic */ Rectangle rectangle$default(Container container, int r8, int r9, int r10, int r11, Function1 function1, int r13, Object obj) {
        int r2;
        int r3;
        if ((r13 & 1) != 0) {
            r2 = 0;
        } else {
            r2 = r8;
        }
        if ((r13 & 2) != 0) {
            r3 = 0;
        } else {
            r3 = r9;
        }
        return rectangle(container, r2, r3, r10, r11, function1);
    }

    public static final ScrollContainer scrollContainer(Container container, int r9, int r10, Function1<? super ScrollContainer, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (ScrollContainer) initElement(container, new ScrollContainer(r9, r10, 0, 0, 12, null), init);
    }

    public static /* synthetic */ ScrollContainer scrollContainer$default(Container container, int r2, int r3, Function1 function1, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r2 = 0;
        }
        if ((r5 & 2) != 0) {
            r3 = 0;
        }
        if ((r5 & 4) != 0) {
            function1 = new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$scrollContainer$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ScrollContainer scrollContainer) {
                    Intrinsics.checkNotNullParameter(scrollContainer, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ScrollContainer scrollContainer) {
                    invoke2(scrollContainer);
                    return Unit.INSTANCE;
                }
            };
        }
        return scrollContainer(container, r2, r3, function1);
    }

    public static final Rectangle space(Container container, int r4, int r5, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(container, new Rectangle(container.getX(), container.getY(), r4, r5), init);
    }

    public static /* synthetic */ Rectangle space$default(Container container, int r2, int r3, Function1 function1, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r2 = 0;
        }
        if ((r5 & 2) != 0) {
            r3 = 0;
        }
        if ((r5 & 4) != 0) {
            function1 = new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$space$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Rectangle rectangle) {
                    Intrinsics.checkNotNullParameter(rectangle, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                    invoke2(rectangle);
                    return Unit.INSTANCE;
                }
            };
        }
        return space(container, r2, r3, function1);
    }

    public static final Rectangle subDisplayArea(Display display, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(display, new Rectangle(0, 0, 348, R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail), init);
    }

    public static final Rectangle subDisplaySafeArea(Display display, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(display, new Rectangle(76, 10, 196, R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail), init);
    }

    public static final Text text(Container container, DisplayString text, CanvasPaint paint, boolean z, String str, Function1<? super Text, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Text) initElement(container, new Text(text.firmware(), paint, z, str, null, 16, null), init);
    }

    public static /* synthetic */ Text text$default(Container container, DisplayString displayString, CanvasPaint canvasPaint, boolean z, String str, Function1 function1, int r12, Object obj) {
        if ((r12 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((r12 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((r12 & 16) != 0) {
            function1 = new Function1<Text, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$text$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Text text) {
                    Intrinsics.checkNotNullParameter(text, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                    invoke2(text);
                    return Unit.INSTANCE;
                }
            };
        }
        return text(container, displayString, canvasPaint, z2, str2, function1);
    }

    public static final List<DrawCommand> toDrawCommands(Display display) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        ArrayList arrayList = new ArrayList();
        parseElements$default(display.getX(), display.getY(), display.getWidth(), display.getHeight(), null, display.getChildren(), arrayList, null, 128, null);
        return arrayList;
    }

    public static final Rectangle topContainer(Display display, Function1<? super Rectangle, Unit> init) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Rectangle) initElement(display, new Rectangle(36, 108, 318, 79), init);
    }

    public static final Variable variable(Container container, VarType type, Function1<? super Variable, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Variable) initElement(container, new Variable(type), init);
    }

    public static /* synthetic */ Variable variable$default(Container container, VarType varType, Function1 function1, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            function1 = new Function1<Variable, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$variable$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Variable variable) {
                    Intrinsics.checkNotNullParameter(variable, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                    invoke2(variable);
                    return Unit.INSTANCE;
                }
            };
        }
        return variable(container, varType, function1);
    }

    public static final Image image(Container container, int r2, int r3, Mitmap mitmap, String str, Function1<? super Image, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Image) initElement(container, new Image(r2, r3, mitmap, str), init);
    }

    public static /* synthetic */ Image image$default(Container container, int r8, int r9, Mitmap mitmap, String str, Function1 function1, int r13, Object obj) {
        int r2 = (r13 & 1) != 0 ? 0 : r8;
        int r3 = (r13 & 2) != 0 ? 0 : r9;
        if ((r13 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((r13 & 16) != 0) {
            function1 = new Function1<Image, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$image$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Image image) {
                    Intrinsics.checkNotNullParameter(image, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                    invoke2(image);
                    return Unit.INSTANCE;
                }
            };
        }
        return image(container, r2, r3, mitmap, str2, (Function1<? super Image, Unit>) function1);
    }

    public static final Line line(Container container, Point p1, Point p2, Function1<? super Line, Unit> init) {
        Intrinsics.checkNotNullParameter(container, "<this>");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(init, "init");
        return (Line) initElement(container, new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY()), init);
    }

    public static /* synthetic */ Line line$default(Container container, Point point, Point point2, Function1 function1, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            function1 = new Function1<Line, Unit>() { // from class: com.animaconnected.watch.display.view.DisplayDefinitionKt$line$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Line line) {
                    Intrinsics.checkNotNullParameter(line, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Line line) {
                    invoke2(line);
                    return Unit.INSTANCE;
                }
            };
        }
        return line(container, point, point2, function1);
    }
}

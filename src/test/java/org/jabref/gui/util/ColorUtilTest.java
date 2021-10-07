package org.jabref.gui.util;

import java.util.stream.Stream;

import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorUtilTest {

    private static final Color C1 = Color.color(0.2, 0.4, 1);
    private static final Color C2 = Color.rgb(255, 255, 255);
    private static final Color C3 = Color.color(0, 0, 0, 0);
    private static final Color C4 = Color.color(1, 1, 1, 1);
    private static final Color C5 = Color.color(0.6, 0.8, 0.5, 0.3);

    private static final Color C7 = Color.rgb(255, 255, 255, 0);
    private static final Color C8 = Color.color(1, 1, 1, 1);

    private static final Color C6 = Color.BLUE;
    private static final Color C9 = Color.hsb(240, 1, 1, 1);
    private static final Color C10 = Color.rgb(0, 0, 255);
    private static final Color C11 = Color.web("0x0000FF",1.0);

    private ColorUtil colorUtil = new ColorUtil();

    @Test
    public void toRGBCodeTest() {
        assertEquals("#3366FF", ColorUtil.toRGBCode(C1));
        assertEquals("#FFFFFF", ColorUtil.toRGBCode(C2));
    }

    @Test
    public void toRGBSimpleCodeTest() {
        assertEquals("#0000FF", ColorUtil.toRGBCode(C6));
    }

    @Test
    public void toRGBCodeNoOpacityTest() {
        String noOpacity = "#FFFFFF";
        assertEquals(noOpacity, ColorUtil.toRGBCode(C7));
        assertEquals(noOpacity, ColorUtil.toRGBCode(C8));
    }

    @Test
    public void toRGBCodeDifferentDeclarations() {
        String differentDefinitions = "#0000FF";
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C6));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C9));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C10));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C11));
    }

    @ParameterizedTest
    @MethodSource("provideToRGBACodeTest")
    public void toRGBACodeTest(Color color, String expected) {
        assertEquals(expected, ColorUtil.toRGBACode(color));
    }

    private static Stream<Arguments> provideToRGBACodeTest() {
        return Stream.of(
                Arguments.of(C1, String.format("rgba(51,102,255,%f)", 1.0)),
                Arguments.of(C2, String.format("rgba(255,255,255,%f)", 1.0)),
                Arguments.of(C3, String.format("rgba(0,0,0,%f)", 0.0)),
                Arguments.of(C4, String.format("rgba(255,255,255,%f)", 1.0)),
                Arguments.of(C5, String.format("rgba(153,204,127,%f)", 0.3))
        );
    }

    @Test
    public void toHexTest() {
        assertEquals("#000001", ColorUtil.toHex(C1));
        assertEquals("#010101", ColorUtil.toHex(C2));
    }

    @Test
    public void toHexSimpleTest() {
        assertEquals("#000001", ColorUtil.toHex(C6));
    }

    @Test
    public void toHexCodeNoOpacityTest() {
        String noOpacity = "#FFFFFF";
        assertEquals(noOpacity, ColorUtil.toRGBCode(C7));
        assertEquals(noOpacity, ColorUtil.toRGBCode(C8));
    }

    @Test
    public void toHexCodeDifferentDeclarations() {
        String differentDefinitions = "#0000FF";
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C6));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C9));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C10));
        assertEquals(differentDefinitions, ColorUtil.toRGBCode(C11));
    }
}

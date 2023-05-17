package com.d23alex.lab311;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

public class AreaCheckingTest {
    private final double R = 10;

    private Set<AreaChecking.Point> belongTopLeftQuarter = Set.of(
            new AreaChecking.Point(-1, 1),
            new AreaChecking.Point(-2, 2),
            new AreaChecking.Point(-4, 1),
            new AreaChecking.Point(-4.99, 0.01),
            new AreaChecking.Point(-0.01, 4.99)
    );

    private Set<AreaChecking.Point> doNotBelongTopLeftQuarter = Set.of(
            new AreaChecking.Point(-5, 5),
            new AreaChecking.Point(-5.01, 0.01),
            new AreaChecking.Point(-0.01, 5.01),
            new AreaChecking.Point(-3, 4.01),
            new AreaChecking.Point(-999, 999)
    );

    private Set<AreaChecking.Point> belongBottomLeftQuarter = Set.of(
            new AreaChecking.Point(-1, -1),
            new AreaChecking.Point(-4.99, -9.99),
            new AreaChecking.Point(-4, -3),
            new AreaChecking.Point(-4.99, -0.01),
            new AreaChecking.Point(-3, -4)
    );

    private Set<AreaChecking.Point> doNotBelongBottomLeftQuarter = Set.of(
            new AreaChecking.Point(-999, -999),
            new AreaChecking.Point(-5.09, -9.99),
            new AreaChecking.Point(-40, -3),
            new AreaChecking.Point(-4.99, -10.01),
            new AreaChecking.Point(-55, -4)
    );

    private Set<AreaChecking.Point> belongBottomRightQuarter = Set.of(
            new AreaChecking.Point(1, -1),
            new AreaChecking.Point(4.98, -0.01),
            new AreaChecking.Point(2, -2),
            new AreaChecking.Point(0.01, -4.98),
            new AreaChecking.Point(2, -0.01)
    );

    private Set<AreaChecking.Point> doNotBelongBottomRightQuarter = Set.of(
            new AreaChecking.Point(3.01, -2.01),
            new AreaChecking.Point(4.98, -0.03),
            new AreaChecking.Point(2, -5),
            new AreaChecking.Point(0.01, -9999999),
            new AreaChecking.Point(999999, -0.01)
    );

    private Set<AreaChecking.Point> doNotBelongTopRightQuarter = Set.of(
            new AreaChecking.Point(0.1, 0.1),
            new AreaChecking.Point(4.98, 0.03),
            new AreaChecking.Point(2, 5),
            new AreaChecking.Point(0.01, 9999999),
            new AreaChecking.Point(999999, 0.01)
    );

    @Test
    public void topLeftQuarterChecking() {
        assertTrue(belongTopLeftQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).allMatch(AreaChecking.Check::areaContainsPoint));

        assertFalse(doNotBelongTopLeftQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).anyMatch(AreaChecking.Check::areaContainsPoint));
    }

    @Test
    public void bottomLeftQuarterChecking() {
        assertTrue(belongBottomLeftQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).allMatch(AreaChecking.Check::areaContainsPoint));

        assertFalse(doNotBelongBottomLeftQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).anyMatch(AreaChecking.Check::areaContainsPoint));
    }

    @Test
    public void bottomRightQuarterChecking() {
        assertTrue(belongBottomRightQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).allMatch(AreaChecking.Check::areaContainsPoint));

        assertFalse(doNotBelongBottomRightQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).anyMatch(AreaChecking.Check::areaContainsPoint));
    }

    @Test
    public void topRightQuarterChecking() {
        assertFalse(doNotBelongTopRightQuarter.stream().map(point -> AreaChecking.constructCheck(
                new AreaChecking.UserInputs(point, R), Initialization.area())
        ).anyMatch(AreaChecking.Check::areaContainsPoint));
    }
}

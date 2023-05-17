package com.d23alex.lab311;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTanslation {
    @Test
    public void areaCheckTranslatesToJSON() {
        final AreaChecking.Check check = new AreaChecking.Check(new AreaChecking.UserInputs(new AreaChecking.Point(1.0, 2.0), 3.0),
                true,
                new Date(),
                new Time(12345));
        final String JSONOutput = "{"
                + "\"x\": " + 1.0
                + ", \"y\": " + 2.0
                + ", \"r\": " + 3.0
                + ", \"areaContainsPoint\": " + "\"" + true + "\""
                + ", \"requestDate\": " + "\"" +  check.requestDate() + "\""
                + ", \"calculationTime\": " + "\"" + new Time(12345) + "\""
                + "}";
        assertEquals(JSONOutput, ResultDisplay.toJSON(check));

    }
}

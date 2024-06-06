package com.makers.makersbnb;

import com.makers.makersbnb.model.Space;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getterTest {
    @Nested
    class SpaceTest {
        @Test
        public void testGetPrice() {
            Space space = new Space();
            space.setPrice(100.0);
            assertEquals(100.0, space.getPrice(), 0.0);
        }
    }
}

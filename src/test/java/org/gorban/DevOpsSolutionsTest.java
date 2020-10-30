package org.gorban;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class DevOpsSolutionsTest {

    @Test
    void checkUndoRedoIntArray() {
        UndoRedoArray<Integer> undoRedoArray = new UndoRedoArray<>(new ArrayList<>(Arrays.asList(0, 0, 0)));
        undoRedoArray.setItem(0, 1);
        undoRedoArray.setItem(1, 2);
        assertEquals(Arrays.asList(1, 0, 0), undoRedoArray.undo());
        assertEquals(Arrays.asList(0, 0, 0), undoRedoArray.undo());
        assertEquals(Arrays.asList(1, 0, 0), undoRedoArray.redo());
    }

    @Test
    void checkUndoRedoStringArray() {
        UndoRedoArray<String> undoRedoArray = new UndoRedoArray<>(new ArrayList<>(Arrays.asList("zero", "zero", "zero")));
        undoRedoArray.setItem(0, "one");
        undoRedoArray.setItem(1, "two");
        assertEquals(Arrays.asList("one", "zero", "zero"), undoRedoArray.undo());
        assertEquals(Arrays.asList("zero", "zero", "zero"), undoRedoArray.undo());
        assertEquals(Arrays.asList("one", "zero", "zero"), undoRedoArray.redo());
    }

}
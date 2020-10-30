package org.gorban;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndoRedoArray<T> extends Array<T> {
    ArrayList<T> arr;
    Stack<ArrayCell> undoStack = new Stack<>();
    Stack<ArrayCell> redoStack = new Stack<>();
    public UndoRedoArray(ArrayList<T> array) {
        arr = array;
    }
    @Override
    public void setItem(int index, T item) {
        undoStack.push(new ArrayCell<T>(index, arr.get(index)));
        arr.set(index, item);
    }

    @Override
    public T getItem(int index) {
        return arr.get(index);
    }

    public List<T> undo() {
        ArrayCell arrayCell = undoStack.pop();
        redoStack.push(new ArrayCell<T>(arrayCell.arrayIndex, arr.get(arrayCell.arrayIndex)));
        arr.set(arrayCell.arrayIndex, (T) arrayCell.arrayValue);
        return arr;
    }
    public List<T> redo() {
        ArrayCell arrayCell = redoStack.pop();
        arr.set(arrayCell.arrayIndex, (T) arrayCell.arrayValue);
        return arr;
    }

    private class ArrayCell<T> {
        public int arrayIndex;
        public T arrayValue;
        ArrayCell(int arrayIndex, T arrayValue) {
            this.arrayIndex = arrayIndex;
            this.arrayValue = arrayValue;
        }
    }

}

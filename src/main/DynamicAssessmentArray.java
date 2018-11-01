/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

package lab5;

/**
* Represents a dynamic array for Assessment objects.
*/
public class DynamicAssessmentArray {
    /**
    * The underlying array.
    */
    private Assessment[] array;
    private int currentCapacity;

    /**
    * Initialises a new dynamic array with the specified initial capacity.
    */
    public DynamicAssessmentArray(int initialCapacity) {
        this.array = new Assessment[initialCapacity];
    }

    /**
    * Gets the number of elements stored in this dynamic array.
    */
    public int getSize() {
        return this.currentCapacity;
    }

    /**
    * Gets the current capacity of this dynamic array.
    */
    public int getCapacity() {
        return this.array.length;
    }

    /**
    * Increases the size of the underlying array by initialising a new array
    * and copies all elements from the old array into the new one.
    */
    private void resize() {
        Assessment[] newArray = new Assessment[this.array.length * 2];
        for (int i = 0; i < this.currentCapacity; i++) {
          newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    /**
    * Adds a new element to this dynamic array.
    */
    public void add(Assessment assessment) {
        if (this.currentCapacity == this.array.length) {
          resize();
        }
        this.array[this.currentCapacity] = assessment;
        this.currentCapacity += 1;
    }

    /**
    * Gets the element at the specified index. If the index is out of bounds,
    * this method returns null.
    */
    public Assessment get(int index) {
        if (index >= this.currentCapacity) {
          return null;
        } else {
          return this.array[index];
        }
    }
}

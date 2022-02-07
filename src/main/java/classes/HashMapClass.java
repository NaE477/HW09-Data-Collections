package classes;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapClass<K, V>{

    K[] keys;
    V[] values;

    /**
     * defines the last index that has been added.
     * because there is no remove method,this value only goes forward.
     */
    int currentPosition;

    /**
     * Current size of K[] and V[], Multiplying by two when current positions reaches its threshold.
     */
    int arraySize;

    /**
     * Initiated as false,is set to true when currentPosition + 1 reaches arraySize
     */
    boolean filled = false;

    public HashMapClass() {
        setArraySize(16);
        keys = (K[]) new Object[arraySize];
        values = (V[]) new Object[arraySize];
        currentPosition = 0;
    }

    /**
     * Public method for putting an item in list
     * @param key key
     * @param val value
     * @return the inserted set's value
     */
    public V put(K key, V val) {
        return putVal(key, val, filled, keyExists(key) != -1);
    }

    /**
     * Initiates a set with objects containing only one key and value, so it's readable.
     * @return a Set,which each element contains one element of the whole map
     */
    public Set<HashMapClass<K,V>> wholeMapSet() {
        Set<HashMapClass<K,V>> outputSet = new HashSet<>();
        for(int i = 0; i < this.size(); i++){
                HashMapClass<K,V> newMap = new HashMapClass<>();
                newMap.put(getKeys()[i],getValues()[i]);
                outputSet.add(newMap);
        }
        return outputSet;
    }

    /**
     * Public method for putting another instance of class into it
     * @param inputMap same instance of the class
     */
    public void putAll(HashMapClass<? extends K, ? extends V> inputMap) {
        for (int i = 0; i < inputMap.size(); i++) {
            putVal(inputMap.getKeys()[i], inputMap.getValues()[i], filled, keyExists(inputMap.getKeys()[i]) != -1);
        }
    }


    /**
     * Initial method to fill the map with one set of key and value.
     * @param key key
     * @param val value
     * @param filled checks if keys/values arrays are filled threshold
     * @param keyContainment should contain the bool value of a key existing in the collection
     * @return the inserted set's value
     */
    private V putVal(K key, V val, boolean filled, boolean keyContainment) {
        if (!filled) {
            if (!keyContainment) {
                keys[currentPosition] = key;
                values[currentPosition] = val;
                currentPosition++;
                setFilled(currentPosition + 1 > arraySize);
            } else {
                int existing = keyExists(key);
                values[existing] = val;
            }
        } else {
            if (!keyContainment) {
                filledCondition();
                return put(key, val);
            } else {
                int existing = keyExists(key);
                values[existing] = val;
            }
        }
        return val;
    }

    /**
     * @param key to Find
     * @return Containing Value / null if key is absent
     */
    public V get(K key) {
        if (keyExists(key) != -1) return values[keyExists(key)];
        else return null;
    }

    /**
     * Before replacing a new value,checks if key exists or not
     * @param key to change value
     * @param newValue New Value
     * @return true if replaced/false if key was not found
     */
    public boolean replace(K key,V newValue) {
        if (contains(key)) {
            return replace(key, newValue, get(key));
        } else return false;
    }

    /**
     * same as replace method but with old value,basically changing if only old value is known by the input
     * @param key to change value
     * @param newValue New Value
     * @param oldValue Old Value
     * @return true if replaced/false if operation failed
     */
    public boolean replace(K key, V newValue, V oldValue){
        int keyIndex = keyExists(key);

        if (keyIndex != -1 && // key existence
                (!newValue.equals(oldValue))  && //new value should not equal to old value
                (!values[keyIndex].equals(oldValue)) //old value should be equal to the found value
        ) {
            return false;
        } else {
            values[keyIndex] = newValue;
            return true;
        }
    }

    /**
     * -1/index based key finder
     * @param key to Find
     * @return index of key if existed or -1 if key does not exist
     */
    private int keyExists(K key) {
        if (size() > 0) {
            for (int i = 0; i < currentPosition; i++) {
                if (keys[i].equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @return emptiness of size
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return currentPosition aka forward modifications to the map
     */
    public int size() {
        return currentPosition;
    }

    /**
     * checks containment of a key using keyExists method
     * @param key to Find
     * @return true if key exists/false if not
     */
    public boolean contains(K key){
        return keyExists(key) != -1;
    }

    /**
     * Once called:
     *
     * 1-arraySize property used to choose Key and Value's array size is doubled.
     * 2-Two other methods are called to change size of key and value arrays.
     * 3-before calling,filled property should be set to true,this method turns it back to false.
     */
    private void filledCondition() {
        arraySize *= 2;
        changeKeySize();
        changeValueSize();
        setFilled(false);
    }

    /**
     * once called,copies K[] array elements to a new array with the size of local arraySize,and sets the K = newK
     */
    private void changeKeySize() {
        K[] newKey = (K[]) new Object[arraySize];
        System.arraycopy(keys, 0, newKey, 0, keys.length);
        setKeys(newKey);
    }

    /**
     * once called,copies V[] array elements to a new array with the size of local arraySize,and sets the V = newV
     */
    private void changeValueSize() {
        V[] newVal = (V[]) new Object[arraySize];
        System.arraycopy(values, 0, newVal, 0, values.length);
        setValues(newVal);
    }


    //Getters & Setters
    public K[] getKeys() {
        return keys;
    }
    public V[] getValues() {
        return values;
    }
    public void setKeys(K[] keys) {
        this.keys = keys;
    }
    public void setValues(V[] values) {
        this.values = values;
    }
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
            return "Key: " + keys[0] +
                    " , Value: " + values[0];
    }
}

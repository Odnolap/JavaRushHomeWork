package com.javarush.test.level33.lesson15.big01.strategies;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private long bucketSizeLimit = 10000;

    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    {
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }
    int size;

    int hash(Long k){
        return k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    Entry getEntry(Long key){
        if (size == 0) {
            return null;
        }

        int hash = (key == null) ? 0 : hash(key);

        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    void resize(int newCapacity){
        int MAXIMUM_CAPACITY = 1 << 30;
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            return;
        }
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        for (FileBucket fb : table) {
            fb.remove();
        }
        table = newTable;
    }

    // TODO
    void transfer(FileBucket[] newTable){
        int newCapacity = newTable.length;
        Entry[] newEntryArray = new Entry[newCapacity];
        FileBucket[] oltTable = table;
        for (int i = 0; i < oltTable.length ; i++) {
            for (Entry e = oltTable[i].getEntry() ; e != null ; ) {
                Entry next = e.next;
                int newIndex = indexFor(e.hash, newCapacity);
                e.next = newEntryArray[newIndex];
                newEntryArray[newIndex] = e;
                e = next;
            }
        }
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new FileBucket();
            if (newEntryArray[i] != null) {
                newTable[i].putEntry(newEntryArray[i]);
            }
        }

    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        if ((null != table[bucketIndex]) && (table[bucketIndex].getFileSize() > bucketSizeLimit)) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    //////////////////////////////////////

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) {
            return false;
        }
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++) {
            for (Entry e = tab[i].getEntry() ; e != null ; e = e.next) {
                if (value.equals(e.value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null) return; // ???
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        Entry startEntry = table[i].getEntry();
        for (Entry e = startEntry; e != null; e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                e.value = value;
                table[i].putEntry(startEntry);
                return;
            }
        }

        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++) {
            for (Entry e = tab[i].getEntry() ; e != null ; e = e.next) {
                if (value == e.value || value.equals(e.value)){
                    return e.getKey();
                }
            }
        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry e = getEntry(key);
        if (e == null) {
            return null;
        }
        else {
            return e.getValue();
        }
    }
}

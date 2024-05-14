class LFUCache {
    int capacity, currentSize, minFrequency;
    HashMap<Integer, DLLNode> cache;
    HashMap<Integer, DoubleLinkedList> freqMap;

    /*
    * @param capacity: total capacity of LFU Cache
    * @param currentSize: current size of LFU cache
    * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
    * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
    * @param freqMap: a hash map that has key to linked list mapping, which used for storing all
    * double linked list by their frequencies
    * */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.minFrequency = 0;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null) {
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        } else {
            currentSize++;
            if (currentSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currentSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList newList = freqMap.getOrDefault(1, new DoubleLinkedList());
            newList.addNode(newNode);
            cache.put(key, newNode);
            freqMap.put(1, newList);
        }
    }

    public void updateNode(DLLNode currNode) {
        int currFreq = currNode.frequency;
        DoubleLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(currNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (currFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }

        currNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = freqMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        freqMap.put(currNode.frequency, newList);
    }

    /*
    * @param key: node key
    * @param val: node value
    * @param frequency: frequency count of current node
    * (all nodes connected in same double linked list has same frequency)
    * @param prev: previous pointer of current node
    * @param next: next pointer of current node
    * */
    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode next;
        DLLNode prev;

        public DLLNode(int k, int v) {
            this.key = k;
            this.val = v;
            this.frequency = 1;  // Corrected initial frequency to 1
        }
    }

    /*
    * @param listSize: current size of double linked list
    * @param head: head node of double linked list
    * @param tail: tail node of double linked list
    * */
    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLLNode currNode) {
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            head.next = currNode;
            nextNode.prev = currNode;
            currNode.prev = head;
            listSize++;
        }

        /** remove input node and decrease list size by 1 **/
        public void removeNode(DLLNode currNode) {
            DLLNode nextNode = currNode.next;
            DLLNode prevNode = currNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */

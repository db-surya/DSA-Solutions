class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : hand) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        while (!treeMap.isEmpty()) {
            int first = treeMap.firstKey();
            if (treeMap.get(first) == 1)
                treeMap.remove(first);
            else
                treeMap.put(first, treeMap.get(first) - 1);
            for (int i = first + 1; i < first + groupSize; i++) {
                if (!treeMap.containsKey(i))
                    return false;
                if (treeMap.get(i) == 1)
                    treeMap.remove(i);
                else
                    treeMap.put(i, treeMap.get(i) - 1);
            }
        }
        return true;
    }
}

/* Things to note
 * Treemap has map.firstKey() to get the first key
 * Sort and split won't work in this sum
 * You cannot convert treemap into treeSet and meanwhile delete the treemap content
 * Because it creates the view of treeMap and that won't work
*/
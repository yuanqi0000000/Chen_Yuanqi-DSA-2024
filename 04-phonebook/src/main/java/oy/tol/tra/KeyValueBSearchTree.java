package oy.tol.tra;

public class KeyValueBSearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {



    private TreeNode<K, V> root;
    private int count = 0;
    private int maxTreeDepth = 0;

    @Override
    public Type getType() {
        return Type.BST;
    }

    @Override
    public int size() {
        return this.count;
    }


    @Override
    public String getStatus() {
        String toReturn = "Tree has max depth of " + maxTreeDepth + ".\n";
        toReturn += "Longest collision chain in a tree node is " + TreeNode.longestCollisionChain + "\n";
        TreeAnalyzerVisitor<K, V> visitor = new TreeAnalyzerVisitor<>();
        root.accept(visitor);
        toReturn += "Min path height to bottom: " + visitor.minHeight + "\n";
        toReturn += "Max path height to bottom: " + visitor.maxHeight + "\n";
        toReturn += "Ideal height if balanced: " + Math.ceil(Math.log(count)) + "\n";
        return toReturn;
    }


    @Override
    public boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError {

        if (null == key || value == null) {
            throw new IllegalArgumentException("Key or Value cannot be null");
        }
        else if (null == this.root) {
            this.root = new TreeNode<K,V>(key,value);
            count++;
            return true;
        }
        else{
            int add = this.root.insert(key,value,key.hashCode());
            count += add;
            return true;
        }
        
    }

    @Override
    public V find(K key) throws IllegalArgumentException {
        if (null == key) throw new IllegalArgumentException("Key to find cannot be null");
        V value = this.root.find(key, key.hashCode());
        return value;
    }

    @Override
    public void ensureCapacity(int size) throws OutOfMemoryError {
    }

    @Override
    public Pair<K, V>[] toSortedArray() {
        TreeToArrayVisitor<K, V> visitor = new TreeToArrayVisitor<>(count);
        root.accept(visitor);
        Pair<K, V>[] sorted = visitor.getArray();
        Algorithms.fastSort(sorted);
        return sorted;
    }

    @Override
    public void compress() throws OutOfMemoryError {

    }

}

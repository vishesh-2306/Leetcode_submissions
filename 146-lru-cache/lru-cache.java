
class LRUCache {
    class Node {
            int key;
            int value;
            Node prev;
            Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int cap;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>() ;
        cap = capacity ;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }
    private void add(Node node){
        Node nxt = head.next;

        head.next = node ;
        node.prev = head ;

        node.next = nxt ;
        nxt.prev = node ;

    }
    

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key) ;

        remove(node) ;

        add(node) ;
        return node.value ;
    }
    
    public void put(int key, int value) {

        if( map.containsKey(key) ){
            Node node = map.get(key) ;

            node.value = value;
            remove(node) ;
            add(node) ;

            return ;
        }

        if( map.size() == cap ){
            Node last = tail.prev ;

            remove(last) ;
            map.remove(last.key) ;
        }
        Node node = new Node(key,value) ;
        map.put(key,node) ;

        add(node) ;

        return ;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
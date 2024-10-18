package dev.omedia;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    protected abstract ListItem next();
    protected abstract ListItem setNext(ListItem item);
    protected abstract ListItem previous();
    protected abstract ListItem setPrevious(ListItem item);
    protected abstract int compareTo(ListItem item);
}

class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

   @Override
   protected ListItem next(){
        return rightLink;
    }

   @Override
   protected ListItem setNext(ListItem item){
        rightLink = item;
        return rightLink;
    }

   @Override
   protected ListItem previous(){
        return leftLink;
    }

   @Override
   protected ListItem setPrevious(ListItem item){
        leftLink = item;
        return leftLink;
    }

   @Override
   protected int compareTo(ListItem item){
        int val1 = Integer.parseInt(String.valueOf(this.value));
       int val2 = Integer.parseInt(String.valueOf(item.getValue()));
        if(val1 > val2){
            return 1;
        }else if(val1 < val2){
            return -1;
        }else{
            return 0;
        }
    }
}

class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item){
        if(root == null){
            root = item;
            return true;
        }

        ListItem current = root;
        while(true){
            if(current.next() == null){
                current.setNext(item);
                item.setPrevious(current);
                return true;
            }

            if(current.next() != null){
                current = current.next();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean removeItem(ListItem item){
        if(root == null){
            return false;
        }
        ListItem current = root;
        while(true){
            if(current.compareTo(item) == 0){
                current.previous().setNext(null);
                return true;
            }
            current = current.next();
            if(current == null){
                return false;
            }
        }
    }

    @Override
    public void traverse(ListItem root){
        if(root == null){
            System.out.println("The list is empty");
        }else {
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}

class SearchTree implements NodeList{
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }
    private void performRemoval(ListItem parent, ListItem child){
        if(child.next() == null){
            if(parent.next() == child){
                parent.setNext(child.previous());
            }else if(parent.previous() == child){
                parent.setPrevious(child.previous());
            }else{
                root = child.previous();
            }
        }else if(child.previous() == null){
            if(parent.next() == child){
                parent.setNext(child.next());
            }else if(parent.previous() == child){
                parent.setPrevious(child.next());
            }else {
                root = child.next();
            }
        }else {
            ListItem curr = child.next();
            ListItem leftParent = child;
            while(curr.previous() != null){
                leftParent = curr;
                curr = curr.previous();
            }
            child.setValue(curr.getValue());
            if(leftParent == child){
                child.setNext(curr.next());
            }else {
                leftParent.setPrevious(curr.next());
            }
        }

    }

    @Override
    public boolean addItem(ListItem item){
        if(root == null){
            root = item;
            return true;
        }

        ListItem current = root;
        while(true){
            if(current.next() == null){
                current.setNext(item);
                item.setPrevious(current);
                return true;
            }

            if(current.next() != null){
                current = current.next();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean removeItem(ListItem item){
        if(item == null || root == null){
            return false;
        }

        ListItem prev = null;
        while(true){
            if(item.compareTo(root) == 0){
                performRemoval(item, prev);
                return  true;
            }

            if(root.next() == null){
                return false;
            }
            prev = root;
            root = root.next();
        }
    }
    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            return;
        }
        traverse(root.previous());
        System.out.println(root.getValue());
        traverse(root.next());
    }
}
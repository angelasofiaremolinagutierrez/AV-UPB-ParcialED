package co.edu.upb.list;

import java.util.Iterator;

public interface DoubleListInterface {

    /*
    essential operations
    */
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public Object get(DoubleListNode node);

    public Object search(Object object);

    public boolean add(Object object);

    public boolean insert(DoubleListNode node, Object object);

    public boolean insert(Object ob, Object object);

    public boolean insertHead(Object object);

    public boolean insertTail(Object object);

    public boolean set(DoubleListNode node, Object object);

    public boolean remove(DoubleListNode node);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Iterator<DoubleListNode> iterator();

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    //algunos de los metodos de getBeforeTo y getNextTo fueron transladados a la clase DoubleListNode

    public Object getBeforeTo(DoubleListNode node);

    public Object getNextTo(DoubleListNode node);

    public DoubleList subList(DoubleListNode from, DoubleListNode to);

    public DoubleList sortList();
}

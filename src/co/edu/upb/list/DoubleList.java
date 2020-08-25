package co.edu.upb.list;

import java.util.Arrays;
import java.util.Iterator;

public class DoubleList implements DoubleListInterface, Iterable<DoubleListNode> {
    public DoubleListNode head;
    public DoubleListNode tail;

    private DoubleListNode inode;
    int size = 0;

    public DoubleList() {
        this.head = null;
        this.head = null;
    }

    public DoubleList(Object object) {
        insertTail(object);
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() { //todo preguntar por este metodo
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return head;
    }

    @Override
    public Object getTail() {
        return tail;
    }

    @Override
    public Object get(DoubleListNode node) {
        return node.getObject();
    }

    @Override
    public DoubleListNode search(Object object) {
        DoubleListNode n = head;
        while (n != null) {
            if (n.getObject().toString().equals(object.toString())) {
                return n;
            } else {
                n = n.next;
            }
        }
        System.out.println("Ese objeto no se encuentra en la lista");
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleListNode nodoAtras, Object object) {
        if (nodoAtras.isEquals(this.tail)) {
            return insertTail(object);
        } else if (nodoAtras.isEquals(this.head)) {
            return insertHead(object);
        } else {

            DoubleListNode nuevoNodo = new DoubleListNode(object);
            nuevoNodo.prev = nodoAtras; //el nuevo agarra al de atras
            nuevoNodo.next = nodoAtras.next; // el nuevo agarra al siguiente
            nodoAtras.next = nuevoNodo; //el de atrás agarra al nuevo y suelta al siguiente
            nuevoNodo.next.prev = nuevoNodo; //el siguiente agarra al nuevo y suelta el de atrás

            size += 1;
            return true;
        }
    }

    @Override
    public boolean insert(Object object, Object objectRef) {
        DoubleListNode nuevoNodo = new DoubleListNode(object);
        DoubleListNode nodoRef = this.search(objectRef);

        nuevoNodo.next = nodoRef.next;// el nuevo agarra al siguiente
        nuevoNodo.prev = nodoRef; //el nuevo agarra al de atras
        nodoRef.next = nuevoNodo; //el de atrás agarra al nuevo y suelta al siguiente
        nuevoNodo.next.prev = nuevoNodo;//el siguiente agarra al nuevo y suelta el de atrás

        size += 1;
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleListNode nuevo = new DoubleListNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = head;
        } else {
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
        }
        size += 1;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleListNode nuevo = new DoubleListNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = head;
        } else {
            nuevo.prev = tail;
            tail.next = nuevo;
            tail = nuevo;
        }
        size += 1;
        return true;
    }

    @Override
    public boolean set(DoubleListNode node, Object object) {
        node.setObject(object);
        return true;
    }

    @Override
    public boolean remove(DoubleListNode node) {
        DoubleListNode n = head;
        if (node.isEquals(head)) {
            head = head.next;

        }
        while (n != null) {
            if (n.isEquals(node)) {
                DoubleListNode anterior = n.prev;
                DoubleListNode siguiente = n.next;

                anterior.next = siguiente;
                siguiente.prev = anterior;
                n = null;
            } else {
                n = n.next;
            }
        }
        size -= 1;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        DoubleListNode node = this.head;
        while (node != null) {
            if (node.getObject().toString().equals(object.toString())) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<DoubleListNode> iterator() {

        inode = head;
        Iterator<DoubleListNode> i = new Iterator<DoubleListNode>() {

            @Override
            public boolean hasNext() {

                return inode.next != null ? true : false;
            }

            @Override
            public DoubleListNode next() {
                if (hasNext()) {
                    DoubleListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
        return i;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        this.toArray(array);
        return array;
    }

    @Override
    public Object[] toArray(Object[] array) {
        if (array.length == this.size) {
            DoubleListNode node = this.head;
            for (int i = 1; i < size; i++) {
                array[i] = node.getObject();
                node = node.next;
            }
            return array;
        } else {
            System.out.println("El array en el que se quiere insertar la lista no es del mismo tamaño que la lista");
            return null;
        }
    }

    //algunos de los metodos getNextTo y getBeforeTo fueron trasladados a la clase DoubleListNode

    @Override
    public Object getBeforeTo(DoubleListNode node) {
        return node.getBeforeTo();
    }

    @Override
    public Object getNextTo(DoubleListNode node) {
        return node.getNextTo();
    }

    @Override
    public DoubleList subList(DoubleListNode from, DoubleListNode to) {
        DoubleList subList = new DoubleList();
        DoubleListNode n = this.head;
        while (n != null) {
            if (n.isEquals(from)) {
                subList.add(n.getObject());
                n = n.next;
                while (n != null) {
                    subList.add(n.getObject());
                    if (n.isEquals(to)) {
                        return subList;
                    } else {
                        n = n.next;
                    }
                }
            } else {
                n = n.next;
            }
        }
        return null;
    }

    @Override
    public DoubleList sortList() {
        Object[] listaAOrdenar = this.toArray();
        Arrays.sort(listaAOrdenar);

        DoubleList listaOrdenada = new DoubleList();
        for (Object n : listaAOrdenar) {
            listaOrdenada.add(n);
        }

        this.head = listaOrdenada.head;
        this.tail = listaOrdenada.tail;
        return this;
    }
}

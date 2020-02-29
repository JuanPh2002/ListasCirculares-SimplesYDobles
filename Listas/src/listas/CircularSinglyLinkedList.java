/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s103e28
 */
public class CircularSinglyLinkedList<T extends Comparable> implements Ilist<T> {

    Node<T> head;
    Node<T> tail;

    public CircularSinglyLinkedList() {
        head = tail = null;
    }

    private Node<T> addNode(T d) {
        Node<T> newNode = new Node<>(d);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.setNextNode(newNode);
        } else {
            newNode.setNextNode(head);
            tail.setNextNode(newNode);
        }
        return newNode;
    }

    //añade datos ordenados de mayor a menor, valida antes si el dato existe
    public void addOrderedMToM(T d) {
        if (!isEmpty() && searchData(d)) {
            System.out.println("No se puede agregar, el dato ya existe");
        } else {
            if (isEmpty() || d.compareTo(head.getData()) == 1) {
                add(d);
                return;
            }
            if (d.compareTo(tail.getData()) == -1) {
                addLast(d);
                return;
            }
            Node<T> current = head.getNextNode();
            Node<T> aux = current.getNextNode();
            Node<T> newNode;
            while (aux.getData().compareTo(d) == 1) {
                current = current.getNextNode();
                aux = aux.getNextNode();
            }
            newNode = new Node<>(d);
            newNode.setNextNode(aux);
            current.setNextNode(newNode);
        }
    }

    //Muestra los datos de la lista desde un dato especifico
    public String recorrerDesde(T d) {
        String data = "";
        if (isEmpty() || !searchData(d)) {
            System.out.println("El dato no existe");
        } else {
            Node<T> current = this.head;
            while (current.getNextNode().getData() != head && current.getNextNode().getData() != d) {
                current = current.getNextNode();
            }
            while (current.getNextNode() != head) {
                current = current.getNextNode();
                data = data + current.getData() + " ";
            }
        }
        return data;
    }
    
     public void update(T dv, T dn) throws Exception {
        if(!searchData(dv)) {
            throw new Exception("El dato a reemplazar no se encuentra en la lista");
        }
        else {
            Node<T> current = head;
            while(dv.compareTo(current.getData()) != 0) {
                current = current.getNextNode();
            }
            current.setData(dn);
        }
    }

     public void deleteSpecific(T data) throws Exception {
        if(!searchData(data)) {
            throw new Exception("El dato a eliminar no se encuentra en la lista");
        }
        else {
            if(head.getData().compareTo(data) == 0) {
                delete();
            }
            else {
                if(tail.getData().compareTo(data) == 0) {
                    deleteLast();
                }
                else {
                    Node<T> current = head;

                    while(data.compareTo(current.getNextNode().getData()) != 0) {
                        current = current.getNextNode();
                    }

                    current.setNextNode(current.getNextNode().getNextNode());
                }
            }
        }
    }
    
    //Crea una nueva lista a partir de dos ya creadas, retorna la nueva lista
    public CircularSinglyLinkedList unirListas(CircularSinglyLinkedList list2) {
        CircularSinglyLinkedList newList = new CircularSinglyLinkedList();
        newList.head = this.head;
        this.tail.setNextNode(list2.head);
        newList.tail = list2.tail;
        list2.tail.setNextNode(this.head);
        return newList;
    }

    @Override
    public void add(T d) {
        head = addNode(d);
    }

    @Override
    public void addLast(T d) {
        tail = addNode(d);
    }

    @Override
    public void addOrdered(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean searchData(T d) {
        Node<T> current = this.head;
        do {
            if (current.getData().compareTo(d) == 0) {
                return true;
            }
            current = current.getNextNode();
        } while (current != this.head);
        return false;
    }

    @Override
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == tail) {
            head = null;
        } else {
            tail.setNextNode(head.getNextNode());
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String showData() {
        String data = "";
        Node<T> current = this.head;
        do {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }

}

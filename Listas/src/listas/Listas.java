/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Stack;

/**
 *
 * @author s208e19
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        //LISTAS CIRCULARES SIMPLES
//        CircularSinglyLinkedList<Integer> myCSLL = new CircularSinglyLinkedList<>();
//        CircularSinglyLinkedList<Integer> myCSLL2 = new CircularSinglyLinkedList<>();
//        CircularSinglyLinkedList<Integer> myCSLL3 = new CircularSinglyLinkedList<>();
//        
//        myCSLL.add(99);
//        myCSLL.addOrderedMToM(10);
//        myCSLL.addOrderedMToM(55);
//        myCSLL.addOrderedMToM(44);
//        myCSLL.addOrderedMToM(85);
//        
//        myCSLL2.add(109);
//        myCSLL2.add(98);
//        myCSLL2.add(56);
//        myCSLL2.addOrderedMToM(35);
//        myCSLL2.addOrderedMToM(15);
//        myCSLL2.addOrderedMToM(50);
//        
//        System.out.println("Contenido de la primera lista circular simple: " + myCSLL.showData());
//        System.out.println("Contenido de la segunda lista circular simple: " + myCSLL2.showData());
//        System.out.println("Recorrer lista circular simple desde (Ingrese dato): ");
//        int d = teclado.nextInt();
//        System.out.println("Contenido de la lista circular simple desde " + d + ": " + myCSLL.recorrerDesde(d));
//        System.out.println("\n Uniendo lista 1 con lista 2 \n");
//        Thread.sleep(1000);
//        myCSLL3 = myCSLL.unirListas(myCSLL2);
//        System.out.println("Contenido de la tercer lista circular simple: " + myCSLL3.showData());
        
        
          //LISTAS CIRCULARES DOBLES
        CircularDoublyLinkedList<Integer> myCDLL = new CircularDoublyLinkedList<>();
        CircularDoublyLinkedList<Integer> listResultante = new CircularDoublyLinkedList<>();
       
        myCDLL.addLast(77);
       
        myCDLL.addOrdered(78);
        myCDLL.addOrdered(15);
        myCDLL.addOrdered(39);
        myCDLL.addOrdered(100);
        myCDLL.addOrdered(10);

        System.out.println("Contenido de la primer lista circular doble: " + myCDLL.showData());
         
        System.out.println("Ingrese un dato especifico para dividir la lista");
        int d2 = teclado.nextInt();
        listResultante = myCDLL.dividirLista(d2);
        System.out.println("\n Dividiendo la lista en  \n");
        Thread.sleep(1000);
        System.out.println("Contenido del resultante al dividir la lista: " + listResultante.showData());
        
        //CASO PRACTICO
        System.out.println("CASO PRACTICO - - - EMULADOR DE VIDEOS");
        ListaReproduccion lr = new ListaReproduccion();
        lr.menuPrincipal();
        
        int option = lr.menuPrincipal();
        
        while(option != 6) {
            switch (option) {
                case 1:
                    lr.add();
                    break;
                case 2:
                    lr.delete();
                    break;
                case 3:
                    lr.update();
                    break;
                case 4:
                    lr.verLista();
                    break;
                case 5:
                    lr.reproducir();
                    break;
            }
            
            option = lr.menuPrincipal();
        }
               
    }
}

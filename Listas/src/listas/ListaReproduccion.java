/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ListaReproduccion {
     Scanner teclado = new Scanner(System.in);
    CircularSinglyLinkedList lista = new CircularSinglyLinkedList();
    
    public ListaReproduccion() {}
    
    public int menuPrincipal() {
        
        System.out.println("Lista de reproducción de video");
        System.out.println("1. Agregar video");
        System.out.println("2. Eliminar");
        System.out.println("3. Actualizar");
        System.out.println("4. Ver lista");
        System.out.println("5. Repproducción automática");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción de 1 a 6: ");
        
        int option = Integer.parseInt(teclado.nextLine());
        
        System.out.println();
        
        return option;
    }
    
    public void add() {
        System.out.print("Ingrese nombre del video a agregar: ");
        String video = teclado.nextLine();
        
        lista.addLast(video);
        System.out.println("Video agregado con éxito");
        System.out.println();
    }
    
    public void delete() {
        System.out.print("Ingrese nombre del video a eliminar: ");
        String video = teclado.nextLine();
        
        try {        
            lista.deleteSpecific(video);
            System.out.println("Video eliminado con éxito");
        }
        catch (Exception ex) {
            System.out.println("El video a eliminar no se encuentra en la lista");  
        }
        
        System.out.println();
    }
    
    public void update() {
        System.out.print("Ingrese nombre del video a actualizar: ");
        String v1 = teclado.nextLine();
        
        System.out.print("Ingrese nombre del video actualizado: ");
        String v2 = teclado.nextLine();
        
        try {
            lista.update(v1, v2);
            System.out.println("Video actualizado con éxito");
        }
        catch (Exception ex) {
            System.out.println("El video a actualizar no se encuentra en la lista");
        }
    }
    
    public void verLista() {
        System.out.println("Lista actual: ");
        
        try {
            System.out.print(lista.showData());
        }
        catch (Exception ex) {
            System.out.println("La lista está vacía");
        }
    }
    
    public void reproducir() {
        if(!lista.isEmpty()) {
            Node current  = lista.head;

            do {
                System.out.println("Reproduciendo: " + current.getData());
                
                current = current.getNextNode();
                
                try {
                    Thread.sleep(2500);
                }
                catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } while(current != lista.head);
            
            System.out.print("Fin de lista. Iniciar nuevamente? S/N: ");
            String option = teclado.nextLine();
            
            if(option.equals("S")) {
                reproducir();
            }
        }
        else {
            System.out.println("La lista de reproducción esta vacía");
        }
    }
}

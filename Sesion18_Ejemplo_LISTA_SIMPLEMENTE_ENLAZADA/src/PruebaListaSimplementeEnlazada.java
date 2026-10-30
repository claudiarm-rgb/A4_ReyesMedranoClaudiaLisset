class Nodo{
	
	private int dato;
	private Nodo nodoSig;
	
	public Nodo(int dato) {
		super();
		this.dato = dato;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSig() {
		return nodoSig;
	}
	public void setNodoSig(Nodo nodoSig) {
		this.nodoSig = nodoSig;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSig=" + nodoSig + "]";
	}
}

class ListaEnlazada{
	private Nodo nodoFin, nodoInicio;


	//1)Crear
	public ListaEnlazada() {
		nodoFin=nodoInicio=null;
	}
	
	//2)Agregar primer elemento (al inicio)
	public void  agregarElementoAlInicio(int dato) {
		
		if(nodoInicio==null) {
			System.out.println("Lista Vacia");
			
			Nodo nuevoNodo=new Nodo(7);
			nodoFin=nuevoNodo;
			nodoInicio=nuevoNodo;
		}else { /// Ya exiten nodos (elementos en la lista)
		
			Nodo nuevoNodo=new Nodo(dato);
			nuevoNodo.setNodoSig(nodoInicio);
			nodoInicio=nuevoNodo;
			
		}
	}//Metodo agregar al inicio
	
	
	//4) Agregar Elementos (recorrido)
	public void mostrarElementos() {
		Nodo nodoActual=nodoInicio;
		
		while(nodoActual!=null) {
			System.out.print("["+nodoActual.getDato()+"]===>");
			nodoActual=nodoActual .getNodoSig();
		}
	}
	
	//4.1) Agregar al final
	
	public void agregarAlFinal(int dato) {
		
		Nodo nuevoNodo=new Nodo(dato);
		
		if(nodoFin!=null) {
			
			nodoFin.setNodoSig(nuevoNodo);
		}
	}
	
	
	//Agregar en posicion especifica
	
	public void agregarEnPosicionEspecifica(int posicion, int dato) {
		
		
		
		if(nodoInicio==null || posicion==1) {
			agregarElementoAlInicio(dato);
		}else if(nodoFin==null) {
			agregarElementoAlInicio(dato);
		}else {
			 
			int contador=1;
			Nodo nodoActual=nodoInicio;
			
			while(nodoActual.getNodoSig()!=null && contador<posicion-1) {
				
				nodoActual=nodoActual.getNodoSig();
				contador++;
			}
			
			if(nodoActual==nodoFin) {
				agregarAlFinal(dato);
			}else {
			
			Nodo nuevoNodo=new Nodo(dato);
			nuevoNodo=nodoActual.getNodoSig();
			nodoActual.setNodoSig(nuevoNodo.getNodoSig());
				
			}
		}
	}
	
	
	
	
	
	
	//4.2) Eliminar al inicio 
	
	public void eliminarAlInicio(){
		
		if(nodoInicio!=null) {
			nodoInicio=nodoInicio.getNodoSig();
			
		}
	}
	
	//Eliminar elemento al final
	
	public void eliminarAlFinal() {
		
		
		if (nodoInicio==null) {
			System.out.println("Lista Vacia");
		}else if(nodoInicio.getNodoSig()==null) {
			nodoInicio=null;
		}else {
			
			Nodo nodoAnterior=nodoInicio ,nodoPosterior=nodoInicio.getNodoSig();
			
			while(nodoPosterior.getNodoSig()!=null) {
				
				nodoAnterior=nodoPosterior;
				nodoPosterior=nodoPosterior.getNodoSig();
				}
			
			nodoAnterior.setNodoSig(null);
			nodoFin=nodoAnterior;
		}
		
	}	
		

	//Posicion especifica
	
	
	
	
	
	//3.3) Eliminar datoEspecifico 
	public void eliminarDatoEspecifico(int dato) {
		
		//Si la lista esta vacia 
		if (nodoInicio==null) {
			System.out.println("Lista Vacia");
		}else if(dato==nodoInicio.getDato()) {
				System.out.println("Dato encontrado en el primer NODO");
				nodoInicio=nodoInicio.getNodoSig();
				System.out.println("Nodo eliminado correctamente");
			}else {
				
				Nodo nodoAnterior=nodoInicio, nodoPosterior=nodoInicio.getNodoSig();
				//Buscar el dato mientras que no se acabe la lista 
				while(dato!=nodoPosterior.getDato() && nodoPosterior.getNodoSig()!=null) {
					nodoAnterior=nodoPosterior;
					nodoPosterior=nodoPosterior.getNodoSig();
				}
				
				if(dato==nodoPosterior.getDato()) {
					
					nodoAnterior.setNodoSig(nodoPosterior.getNodoSig());
					nodoPosterior=nodoPosterior.getNodoSig();
					
					
				}else {
				System.out.println("Dato no encontrado");
			}
		
		
		///MIENTRAS QUE NO ENCONTRADO Y NO NULO 
		Nodo nodoActual=nodoInicio;
	
		
		if(dato==nodoActual.getDato()) {
			nodoActual=nodoActual.getNodoSig();
		}
		
		}
	}
	
	
}

public class PruebaListaSimplementeEnlazada {
	public static void main(String[]args) {
		
		ListaEnlazada le=new ListaEnlazada();
		
	
		System.out.println("Recorriendo Lista cuando esta vacia");
		le.mostrarElementos();
		System.out.println("Agregando un primier elemento");
		le.agregarElementoAlInicio(7);
		System.out.println("Recorriendo la lisa cuando no esta vacia");
		le.mostrarElementos();
		
		System.out.println("Agregar elemento al Inicio --------------");
		le.agregarElementoAlInicio(9);
		le.agregarElementoAlInicio(1);
		le.agregarElementoAlInicio(5);
		le.mostrarElementos();
		System.out.println();
		System.out.println("Agregar al final --------------");
		le.agregarAlFinal(3);
		le.eliminarAlInicio();
		le.mostrarElementos();
		System.out.println();
		System.out.println("Eliminar elemento Especifico --------------");
		le.eliminarDatoEspecifico(1);
		le.mostrarElementos();
		System.out.println();
		System.out.println("Eliminar al final --------------");
		le.eliminarAlFinal();
		System.out.println();
		le.mostrarElementos();
		System.out.println();
		System.out.println("Agregar en posicion especifica --------------");
		le.agregarEnPosicionEspecifica(2, 3);
		le.mostrarElementos();
		le.agregarEnPosicionEspecifica(1, 2);
		le.mostrarElementos();
		/*
		System.out.println("=== ELEMENTOS FINALES ====");	
		le.agregarAlFinal(33);
		le.agregarAlFinal(3);
		le.agregarAlFinal(44);
		le.agregarAlFinal(16);
		le.mostrarElementos();
		
	*/
		
		
	}

}

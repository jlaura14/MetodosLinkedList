package linkedList;
import java.awt.print.PrinterAbortException;
import java.util.Scanner;

import node.node;
public class linkedList<T> {
	Scanner leer = new Scanner(System.in);
	transient int size = 0 ;
	private node<T> sentinel=null;
	public node<T> front;
	public linkedList(){
		sentinel = new node<T>();
		sentinel.setIndex(-1);	
	}
	public linkedList(T value) {
		this();
		node<T> tmp = new node<T>(value);
		tmp.setIndex(1);
		sentinel.setNext(tmp);
	}
	public void addStart(T value) {
		node<T> tmp  = sentinel.getNext();   //creamos un temporal con valor get next del sentinel
		node<T> _new = new node<T>(value);   //creamos un nuevo valor
		_new.setNext(tmp);					// temporal sera el getnext de _new
		sentinel.setNext(_new);				// y new sera el get next de sentinel
	}
	///////////////////////////////////////////////////////////////////////////////
	public void addEnd(T value) {
		node<T>tmp =sentinel;					//Creamos un temporal
		while (tmp.getNext()!=null) 			// mientras getnext de temporal sea nulo
			tmp = tmp.getNext();				//temporal sera = a tmp.getnext();
		tmp.setNext(new node<T>(value));		// asignamos el valor ingresado a la posision final
	}
	//////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	public boolean remove (T value) {
		node<T> tmp= sentinel;
		while (tmp.getNext()!=null)
		{
			if (tmp.getNext().getValue().equals(value))
			{
				tmp.setNext(tmp.getNext().getNext());
				return true;
			}else
			{
				tmp=tmp.getNext();
			}
		}
	return false;
	}
	public boolean remover(T value)
	{
		return remover(value,sentinel);
	}
   private boolean remover (T value, node<T> lista){
		if (lista.getNext()==null)
		return false;
		if(lista.getNext().getValue().equals(value)) {
			lista.setNext(lista.getNext().getNext());
			return true;}
		return remover(value, lista.getNext());
	}
	public node <T> remmove (T value) {
		node<T> tmp= sentinel;
		while (tmp.getNext()!=null)
		{
			if (tmp.getNext().getValue().equals(value))
			{
				tmp.setNext(tmp.getNext().getNext());
				return tmp;
			}else
			{
				tmp=tmp.getNext();
			}
		}
	return null;
	}	
	public node<T> search(T value)
	{
		
		return search(value,sentinel);  //recibimos un valor y returnamos el mismo valor y el sentinel
	}

	public node<T> search(T value, node<T> lista) //recibimos el valor y el sentinela
	{
		if (lista.getNext()==null)return null;			//si lista.getnext es igual a nulo returnamos nulo
		if(lista.getNext().getValue().equals(value))return lista.getNext(); //si el valor de lista.getnext es igual al
		//valor recibido returnamos lista.getnext
		return search(value, lista.getNext()); //si no se cumplen regresamos al metodo pero ahora lista avanza getnext
	}
	public boolean buuscar(T value, node<T> lista)
	{
		if (lista.getNext()==null)return false;
		if(lista.getNext().getValue().equals(value))return true; 
		return buuscar(value, lista.getNext());
	}

	public void printer() {
		printer(sentinel);
	}
	public void pronter() {
		node<T> tmp = sentinel;			//creamos un temporal
		while (tmp.getNext()!=null) {	// mientras el temporal sea diferente a nullo
			tmp = tmp.getNext();		//temporal avanzara una posicion
			System.out.println(tmp.getValue());//imprimimos el valor que hay en esta posicion
		}
		System.gc();
	}
	private void printer(node<T> tmp) {
		if (tmp.getNext()== null)
			return;
		else{
			System.out.println(tmp.getNext().getValue());
		    printer(tmp.getNext());
		}
		System.gc();
	}
	public boolean addLast(T value, T newvalue)
	{
		node<T> finder =search(value);	 
		if(finder!=null)
			return addLast (new node<T>(newvalue),finder);
		else
			return false;
	}
	public boolean addLast(T value, node<T> nodo) {
		node<T> finder =search(value);
		if(finder!=null)
			return addLast (nodo,finder);
		else
			return false;
	}
	public boolean addLast(node<T> nodo, node<T> lista)
	{
		nodo.setNext(lista.getNext());
		lista.setNext(nodo);
		return true;		
	}
	public boolean addBefore(T value, T newvalue)
	{
		node<T>tmp =sentinel;
		while (tmp.getNext()!=null  && !tmp.getNext().getValue().equals(value)) 
		{
			tmp = tmp.getNext();
		}
		return (tmp!=null)?addLast(new node<T>(newvalue),tmp):false;
	}
	
	
	
///////////////////////////////////////////////////////////////	
	public long indexof(T value)
	{
		node<T> temp= sentinel;					//creamos un temporal de sentinel
		while(temp.getNext()!=null){			//mientras temporal.getnext sea diferente a nulo entra al if
		if (temp.getNext().getValue().equals(value)){//si el valor del getnext de temporal es igual al valor recibido
			return temp.getIndex()+2;}				//returnamos la posicion en donde se encuentra
		else{
			temp=temp.getNext();					//si no avanzamos una posicion y volvemos a recorrer
		}
			
		}
		return 0;
	}
//////////////////////////////////////////////////////////////////	
	public void reIndex() {
		int aux=0;								//tenemos un auxiliar que nos ayudara a obtener la cantidad en la lista
		node<T> tmp = sentinel;					//creamos un temporal
		while (tmp.getNext()!=null) {			//mientras temporal.getnext sea diferente a null
			tmp = tmp.getNext();				//temporal avanzara una posicion
			tmp.setIndex(aux);				
			System.out.println(aux);			//imprimimos la el auxiliar
			aux++;								//aumentamos 1 al aux 
			
		}
		System.gc();
		
	}
//////////////////////////////////////////////////////////////////	
	public void size() {
		int aux=0;						//tenemos un auxiliar que nos ayudara a obtener la cantidad en la lista
		node<T> tmp = sentinel;			//creamos un temporal
		while (tmp.getNext()!=null) {//mientras temporal.getnext sea diferente a null
			tmp = tmp.getNext();		//temporal avanzara una posicion
			tmp.setIndex(aux);
			
			aux++;
			
		}
		System.out.println(aux); 		//Se muestra el total que se acumulo en el auxiliar
		System.gc();
		
	}
//////////////////////////////////////////////////////////////////	
	 public String isEmpty(){
	  
	  if(sentinel.getNext()==null){ return "La lista esta vacia ";} //si sentinel.getnext es igual a nulo es igual
	  //a la lista vacia
	  else{return "La lista no esta vacia";//si no la lista contiene datos.
	  
	  }
	
	 }
	 
//////////////////////////////////////////////////////////////////
		public void getfirst(){
			node<T> tmp  = sentinel;						//creamos una variable temporal
			if(tmp.getNext()!=null){						//si la temporal en su getnext es diferente a nullo
				System.out.println(tmp.getNext().getValue());// imprime el valor de tmp.getnext().getValue()
			}
			
		}
		
///////////////////////////////////////////////////////////////////
		public node <T> replace (T value, T newvalor) {
			node<T> tmp= sentinel;                    //creamos una variable temporal
			while (tmp.getNext() != null){				//mientras la temporal en su getnext es diferente a nullo
				if(tmp.getNext().getValue().equals(value)){		//entra al if y si tmp.getnext.getvalue es igual al valor
					tmp.getNext().setValue(newvalor);	//temporal.getnext tendra un nuevo valor
				}
				tmp=tmp.getNext();				//si no tmp avanza una posicion y vuelve a recorrer 
			}
			return null;	
		}
		
////////////////////////////////////////////////////////////////////
		public void removelast() {
			node<T>tmp =sentinel;//creamos una variable temporal
			if(tmp.getNext()!=null){	//si la temporal en su getnext es diferente a nullo
			while (tmp.getNext().getNext()!=null){		//tmp da dos saltos y si es diferente a nulo
				tmp = tmp.getNext();				//temporal avanza una posicion
			}
			tmp.setNext(null);						// si no avanza le asigamos un valor nulo a la ultima posicion
			}
		}
		
////////////////////////////////////////////////////////////
		public void getlast() {
			node<T>tmp =sentinel;				//creamos una variable temporal
			if(tmp.getNext()!=null){			//si la temporal en su getnext es diferente a nullo
			while (tmp.getNext().getNext()!=null){		//tmp da dos saltos y si es diferente a nulo
				tmp = tmp.getNext();		//temporal avanza una posicion
			}
			
			}
			System.out.println(tmp.getNext().getValue());//imprimimos el valor que recolectamos 
		}
		
////////////////////////////////////////////////////////////		
		 public void clear(){
				sentinel.setNext(null);		//le damos un valor nulo al next del sentinel
			 }
////////////////////////////////////////////////////////////	
		 public void removefirs() {
				sentinel=sentinel.getNext(); //recorremos el sentinel para eliminar el primer nodo
			}
		 
////////////////////////////////////////////////////////////7
		 
		 public T removebefore(T value){
			 
			 return removebefore(value,sentinel); //recibimos un valor y retornamos el valor y el sentinel
			 
		 }
		 private T removebefore(T value, node<T> lista){//Recibimos el valor y el sentinel
			 node<T> tmp = lista;			//creamos un temporal de sentinel
			 
			 if(tmp.getNext()==null){		//si tmp.getnext es igual a nulo regresamos el valor que recibimos
				 return value;
			 }
			 lista=lista.getNext();
			 if(lista.getNext().getValue().equals(value)){
				 tmp.setNext(tmp.getNext().getNext()); //cambiamos el valor del mnodo que esta anterior del lista 
			 }else{
				 return removebefore(value,lista); // regresamos para volver a recorrer
			 }
			 return value;
		 }
///////////////////////////////////////////////////////////
		 
		 
		 public T removeafter(T value){
			 
			 return removeafter(value,sentinel);  //recibimos un valor y retornamos el valor y el sentinel
			 
		 }
		 private T removeafter(T value, node<T> tmp){
			 
			 if(tmp.getNext()==null){   //si tmp.getnext es igual a nulo regresamos el valor que recibimos
				 return value;
			 }
			 if(tmp.getNext().getValue().equals(value)){  //si el valor de tmp.getnext es igual al que recibimos
				 tmp=tmp.getNext();							//temporal avanza una posicion
				 tmp.setNext(tmp.getNext().getNext());		//y tmp da dos saltos para eliminar el que esta delante de el
			 }else{
				 return removeafter(value,tmp.getNext());
			 }
			 return value;
		 }
		 
}
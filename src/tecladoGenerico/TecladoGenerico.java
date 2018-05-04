package tecladoGenerico;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TecladoGenerico <T>   {
	

		public static Scanner scan= new Scanner(System.in);
		public static enum Operador{MENOR,MAYOR,MAYORIGUAL,MENORIGUAL}
		public static enum Rango{ AMBOSIN, AMBOSOUT, MININMAXOUT, MINOUTMAXIN}
		public static enum Numero{INT,DOUBLE,FLOAT,BYTE,LONG,SHORT,STRING, CHAR}

public static <T> T leerRangoDeterminado(T max, T min, Rango elegido, Numero numero) throws IllegalArgumentException {
	T digito;
	boolean salir = false;
	

			do {
				
				digito= leerTeclado(numero);
				
					switch(numero) {
						case INT:
							
								if((Integer)min>(Integer)max) {
									IllegalArgumentException exception = new IllegalArgumentException();
									throw exception;
								}else {
								  switch(elegido) {
									case AMBOSIN:
										if((Integer)digito<(Integer)min || (Integer)digito>(Integer)max) {
											System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
										}else {
											salir=true;
										}
									break;
									
									case AMBOSOUT:
										if((Integer)digito<=(Integer)min || (Integer)digito>=(Integer)max) {
											System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
										}else {
											salir=true;
										}
									break;
									
									case MININMAXOUT:
										if((Integer)digito<(Integer)min || (Integer)digito>=(Integer)max) {
											System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
										}else {
											salir=true;
										}
									break;
									
									case MINOUTMAXIN:
										if((Integer)digito<=(Integer)min || (Integer)digito>(Integer)max) {
											System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
										}else {
											salir=true;
										}
									break;
									
								}
							}
					break;
					
					case DOUBLE:
						
							if((Double)min>(Double)max) {
								IllegalArgumentException exception = new IllegalArgumentException();
								throw exception;
							}else {
								switch(elegido) {
								case AMBOSIN:
									if((Double)digito<(Double)min || (Double)digito>(Double)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case AMBOSOUT:
									if((Double)digito<=(Double)min || (Double)digito>=(Double)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MININMAXOUT:
									if((Double)digito<(Double)min || (Double)digito>=(Double)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MINOUTMAXIN:
									if((Double)digito<=(Double)min || (Double)digito>(Double)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
							}
						}
					break;
					
					case FLOAT:
						
							if((Float)min>(Float)max) {
								IllegalArgumentException exception = new IllegalArgumentException();
								throw exception;
							}else {
								switch(elegido) {
								case AMBOSIN:
									if((Float)digito<(Float)min || (Float)digito>(Float)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case AMBOSOUT:
									if((Float)digito<=(Float)min || (Float)digito>=(Float)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MININMAXOUT:
									if((Float)digito<(Float)min || (Float)digito>=(Float)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MINOUTMAXIN:
									if((Float)digito<=(Float)min || (Float)digito>(Float)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
							}
					    }
						
					break;
						
					case BYTE:
						
							if((Byte)min>(Byte)max) {
								IllegalArgumentException exception = new IllegalArgumentException();
								throw exception;
							}else {
								switch(elegido) {
								case AMBOSIN:
									if((Byte)digito<(Byte)min || (Byte)digito>(Byte)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case AMBOSOUT:
									if((Byte)digito<=(Byte)min || (Byte)digito>=(Byte)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MININMAXOUT:
									if((Byte)digito<(Byte)min || (Byte)digito>=(Byte)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MINOUTMAXIN:
									if((Byte)digito<=(Byte)min || (Byte)digito>(Byte)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
							}
						}	
					break;
						
					case SHORT:
						
							if((Short)min>(Short)max) {
								IllegalArgumentException exception = new IllegalArgumentException();
								throw exception;
							}else {
								switch(elegido) {
								case AMBOSIN:
									if((Short)digito<(Short)min || (Short)digito>(Short)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case AMBOSOUT:
									if((Short)digito<=(Short)min || (Short)digito>=(Short)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MININMAXOUT:
									if((Short)digito<(Short)min || (Short)digito>=(Short)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MINOUTMAXIN:
									if((Short)digito<=(Short)min || (Short)digito>(Short)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
							}
						}
						
					break;
						
					case LONG:
						
							if((Long)min>(Long)max) {
								IllegalArgumentException exception = new IllegalArgumentException();
								throw exception;
							}else {
							switch(elegido) {
								case AMBOSIN:
									if((Long)digito<(Long)min || (Long)digito>(Long)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case AMBOSOUT:
									if((Long)digito<=(Long)min || (Long)digito>=(Long)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MININMAXOUT:
									if((Long)digito<(Long)min || (Long)digito>=(Long)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
								case MINOUTMAXIN:
									if((Long)digito<=(Long)min || (Long)digito>(Long)max) {
										System.out.println("el numero debe de estar entre el rango: "+min+"-"+max);
									}else {
										salir=true;
									}
								break;
								
							}
						
						}
				  break;
					
					
					}	
			
			 }while(!salir);
			
		
			 return digito;
	
		}
		
	
	public static <T> T leerRango(T elemento,Numero numero, Operador operar) {
		boolean salir=false;
		int digito=0;
		T generico;
		do {
			generico=leerTeclado(numero);
			
			switch(operar) {
			
			case MAYOR:
				switch(numero) {
					case INT:
						digito=((Integer)generico).compareTo((Integer) elemento);
						
					break;
				
					case DOUBLE:
						digito=((Double)generico).compareTo((Double) elemento);
						
					break;
		
					case SHORT:
						digito=((Short)generico).compareTo((Short) elemento);
						
					break;
				
					case LONG:
						digito=((Long)generico).compareTo((Long) elemento);
						
					break;
				
					case BYTE:
						digito=((Byte)generico).compareTo((Byte) elemento);
						
					break;
				
					case FLOAT:
						digito=((Float)generico).compareTo((Float) elemento);
				   break;
			
				}
				if(digito<=0) {
					System.out.println("el numero debe de ser mayor a: "+elemento);
				}else {
					salir=true;
				}
			break;
			case MENOR:
				switch(numero) {
					case INT:
						digito=((Integer)generico).compareTo((Integer) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
			
					case DOUBLE:
						digito=((Double)generico).compareTo((Double) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
	
					case SHORT:
						digito=((Short)generico).compareTo((Short) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case LONG:
						digito=((Long)generico).compareTo((Long) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case BYTE:
						digito=((Byte)generico).compareTo((Byte) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case FLOAT:
						digito=((Float)generico).compareTo((Float) elemento);
						if(digito>=0) {
							System.out.println("el numero debe de ser menor a: "+elemento);
						}else {
							salir=true;
						}
					break;
				}
				if(digito>=0) {
					System.out.println("el numero debe de ser menor a: "+elemento);
				}else {
					salir=true;
				}
			break;
			case MAYORIGUAL:
				switch(numero) {
					case INT:
						digito=((Integer)generico).compareTo((Integer) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case DOUBLE:
						digito=((Double)generico).compareTo((Double) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
		
					case SHORT:
						digito=((Short)generico).compareTo((Short) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case LONG:
						digito=((Long)generico).compareTo((Long) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case BYTE:
						digito=((Byte)generico).compareTo((Byte) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case FLOAT:
						digito=((Float)generico).compareTo((Float) elemento);
						if(digito<0) {
							System.out.println("el numero debe de ser mayor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
			
				}
			break;
			case MENORIGUAL:
				switch(numero) {
					case INT:
						digito=((Integer)generico).compareTo((Integer) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case DOUBLE:
						digito=((Double)generico).compareTo((Double) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
		
					case SHORT:
						digito=((Short)generico).compareTo((Short) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case LONG:
						digito=((Long)generico).compareTo((Long) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case BYTE:
						digito=((Byte)generico).compareTo((Byte) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				
					case FLOAT:
						digito=((Float)generico).compareTo((Float) elemento);
						if(digito>0) {
							System.out.println("el numero debe de ser menor o igual: "+elemento);
						}else {
							salir=true;
						}
					break;
				}
		 break;
		}
		}while(!salir);
		
		
		return generico;
		
	}
public static <T> T leerTeclado(Numero numero) {
	T elemento=null;
	boolean salir=false;
	do {
				
		try {
			switch(numero){
			
				case INT:
						elemento=(T) Integer.valueOf(scan.nextInt());
					break;
					
				case DOUBLE:
						elemento=(T) Double.valueOf(scan.nextDouble());
					break;
				case STRING:
						elemento=(T) String.valueOf(scan.nextLine());
					break;
				case CHAR:
						elemento=(T) Character.valueOf(scan.next().charAt(0));
					break;
					
				case SHORT:
						elemento=(T) Short.valueOf(scan.nextShort());
					break;
					
				case LONG:
						elemento=(T) Long.valueOf(scan.nextLong());
					break;
					
				case BYTE:
						elemento=(T) Byte.valueOf(scan.nextByte());
					break;
					
				case FLOAT:
						elemento=(T) Float.valueOf(scan.nextFloat());
					break;
			}
		salir=true;
			
		}catch(InputMismatchException e) {
			System.out.println("introduzca una opcion valida");
		}finally {
			if(numero!=Numero.STRING) {
				scan.nextLine();
			}
		}
	}while(!salir);
			
			return elemento;
}

	public static boolean leerBolean(String mensaje1) {
			
			boolean opcion = false;
			String respuesta="";
			boolean salir = false;
		
			do {
				
				try {
					
					System.out.println(mensaje1);
					respuesta=leerTeclado(Numero.STRING);
					if(respuesta.equals("s")) {
						opcion= true;
						salir= true;
					}
					if(respuesta.equals("n")) {
						opcion= false;
						salir = true;
					}
				}catch(InputMismatchException e) {
					System.out.println("introduzca una opcion valida");
				}
				finally {
					//scan.nextLine();
					
				}
			
			}while(!salir);
			
			return opcion;
		
		}
	public static boolean leerBolean(String mensaje1, String mensaje2, String mensaje3) {
			boolean opcion = false;
			int respuesta=0;
			boolean salir = false;
			do {
				
				try {
					System.out.println(mensaje1);
					System.out.println("1.-"+ mensaje2);
					System.out.println("2.-"+mensaje3);
					respuesta=leerTeclado(Numero.INT);
					if(respuesta==1) {
						opcion= true;
						salir= true;
					}
					if(respuesta==2) {
						opcion= false;
						salir = true;
					}
				}catch(InputMismatchException e) {
					System.out.println("introduzca una opcion valida");
				}finally {
					//scan.nextLine();
				}
			
			}while(!salir);
		
			return opcion;
			
		}
		
		
	public static void cerrarTeclado() {
			scan.close();
			
		}
		
		
		
	
	
	
	
	
	}




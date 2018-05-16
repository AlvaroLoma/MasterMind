package masterMindLidia;
public final class Color {

	public static final String RESET = "\u001B[0m";
	public static final String NEGRO = "\u001B[30m";	
	public static final String ROJO = "\u001B[31m";	
	public static final String VERDE = "\u001B[32m";	
	public static final String AMARILLO = "\u001B[33m";	
	public static final String AZUL = "\u001B[34m";	
	public static final String MORADO = "\u001B[35m";	
	public static final String CELESTE = "\u001B[36m";		
	public static final String GRISCLARO = "\u001B[37m";
	
	public static final String FONDO_NEGRO = "\u001B[40m";
	public static final String FONDO_GRISOSCURO = "\u001B[100m";
	public static final String FONDO_ROJO = "\u001B[41m";
	public static final String FONDO_ROJOCLARO = "\u001B[101m";
	public static final String FONDO_VERDE = "\u001B[42m";
	public static final String FONDO_VERDECLARO = "\u001B[102m";
	public static final String FONDO_AMARILLO = "\u001B[43m";
	public static final String FONDO_AMARILLOCLARO = "\u001B[103m";
	public static final String FONDO_AZUL = "\u001B[44m";
	public static final String FONDO_AZULCLARO = "\u001B[104m";
	public static final String FONDO_MORADO = "\u001B[45m";
	public static final String FONDO_MORADOCLARO = "\u001B[105m";
	public static final String FONDO_CELESTE = "\u001B[46m";
	public static final String FONDO_CELESTECLARO = "\u001B[106m";
	public static final String FONDO_GRISCLARO = "\u001B[47m";
	public static final String FONDO_BLANCO= "\u001B[107m";
	
	public static void main(String[] args) {
		System.out.print(FONDO_NEGRO + "  " + RESET);
		System.out.print(FONDO_ROJO + "  " + RESET);
		System.out.print(FONDO_VERDE + "  " + RESET);
		System.out.print(FONDO_AMARILLO + "  " + RESET);
		System.out.print(FONDO_AZUL + "  " + RESET);
		System.out.print(FONDO_MORADO + "  " + RESET);
		System.out.print(FONDO_CELESTE + "  " + RESET);
		System.out.print(FONDO_BLANCO + "  " + RESET);
		System.out.println("");
		System.out.print(FONDO_GRISOSCURO + "  " + RESET);
		System.out.print(FONDO_ROJOCLARO + "  " + RESET);
		System.out.print(FONDO_VERDECLARO + "  " + RESET);
		System.out.print(FONDO_AMARILLOCLARO + "  " + RESET);
		System.out.print(FONDO_AZULCLARO + "  " + RESET);
		System.out.print(FONDO_MORADOCLARO + "  " + RESET);
		System.out.print(FONDO_CELESTECLARO + "  " + RESET);
		System.out.print(FONDO_GRISCLARO + "  " + RESET);
	}
	
}

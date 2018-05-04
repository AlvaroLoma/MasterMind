package masterMind;

public class Casilla {
	

	Colores color;
	
	public Casilla(int color2) {
		color=new Colores(color2);
	}
	public String dibujar() {
		// TODO Auto-generated method stub
		return color.dibujarColor();
	}
	public boolean equals(Casilla combinacion) {
		
		return color.equals(combinacion.color);
		
	}
	public String getColor() {
		
		return color.getColor();
	}
	public void setColor(String value) {
		color.setColores(value);
		
	}
	public int getNumero() {
		
		return color.getNumero();
	}
}

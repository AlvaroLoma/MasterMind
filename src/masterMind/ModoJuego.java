package masterMind;

public enum ModoJuego {

		FACIL(10,4,false,8),
		MEDIO(15,6,false,8),
		DIFICIL(10000,8,true,10);
		
		private int intentos;
		private int numCasillas;
		private boolean repetirColores;
		private int maxColores;
		
		ModoJuego(int intentos, int numCasillas, boolean repetirColores,int maxColores) {
			this.intentos=intentos;
			this.numCasillas=numCasillas;
			this.repetirColores=repetirColores;
			this.maxColores=maxColores;
			
		}

		public int getIntentos() {
			return intentos;
		}
		public int getNumCasillas() {
			return numCasillas;
		}

		public boolean isRepetirColores() {
			return repetirColores;
		}

		public int getMaxColores() {
		
			return this.maxColores;
		}

		
	
}

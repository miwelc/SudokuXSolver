//Title:       SudokuSolver
//Version:     0.1
//Copyright:   2011
//Author:      Miguel Cantón Cortés
//E-mail:      miwelc@correo.ugr.es


/**
 * Implementación de la resolución de un Sudoku.
 * 
 * @author Miguel Cantón Cortés
 */

public class SudokuSolver 
{
	int tablero[][] = new int[9][9];
	
	//Qué valores pueden, por ahora, ir en esa pos
	//Consideramos 0 como asignación posible, para aprovechar
	//el valor de inicialización
	int valoresNoPosibles[][][] = new int[9][9][9];
	
	//Cuantos valores podrían ir en esa casilla
	int numValPosibles[][] = new int[9][9];
	
	public void printTablero() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++)
				System.out.print(tablero[j][i]);
			System.out.print('\n');
		}
		System.out.print('\n');
	}

	/**
	 * Constructor
	 * @param template Cadena representando una plantilla de sudoku
	 */
	public SudokuSolver(String template) {
		int pos = 0;
		char c;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				do {
					c = template.charAt(pos++);
				} while(c <= 44); //Caracteres especiales
				if(c != '.' && c != '-') {
					numValPosibles[j][i] = 9;
					tablero[j][i] = c-'0';
				}
			}
		}
	}
	
	private void inicializarRestricciones() {
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if(tablero[i][j] > 0)
					propagarRestricciones(i, j, tablero[i][j]);
	}
	
	public void actualizarRestriccionesCasilla(int casX, int casY, int nuevoValor, int operador) {
		if(tablero[casX][casY] != 0)
			return;
		final int res = (valoresNoPosibles[casX][casY][nuevoValor-1] += operador);
		if(res == 0)
			++numValPosibles[casX][casY];
		else if(res == 1 && operador == 1)
			--numValPosibles[casX][casY];
	}
	
	public void propagarRestricciones(int casX, int casY, int nuevoValor) {
		int operador, recX, recY;
		if(nuevoValor == 0) {
			operador = -1;
			nuevoValor = tablero[casX][casY];
		}
		else {
			operador = 1;
			tablero[casX][casY] = nuevoValor;
		}
		
		//Comprobamos recuadro
		recX =  ((casX/3)*3);
		recY =  ((casY/3)*3);
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				actualizarRestriccionesCasilla(i+recX, j+recY, nuevoValor, operador);
		
		for(int i = 0; i < 9; i++) {
			//Comprobamos en la misma columna
			actualizarRestriccionesCasilla(i, casY, nuevoValor, operador);
			//Comprobamos en la misma fila
			actualizarRestriccionesCasilla(casX, i, nuevoValor, operador);
		}
		
		//Comprobamos diagonales principales
		if(casX == casY) //Si está en la diagonal arr-abj
			for(int i = 0; i < 9; i++)
				actualizarRestriccionesCasilla(i, i, nuevoValor, operador);
		if(casX+casY == 8) //Si está en la diagonal abj-arr
			for(int i = 0; i < 9; i++)
				actualizarRestriccionesCasilla(i, 8-i, nuevoValor, operador);
		
		if(operador == -1)
			tablero[casX][casY] = 0;
	}
	
	/**
	 * Resolución de sudokus
	 */
	public void solve() {
		inicializarRestricciones();
		buscarSolucion();
	}
	
	public boolean buscarSolucion() {
		int mintmp, min = 1000, casMinX = 0, casMinY = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				mintmp = numValPosibles[j][i];
				if(mintmp < min && tablero[j][i] == 0) { //No asignado y con pocos val posibles
					if(mintmp == 0)
						return false;//NO QUEDAN POSIBLES VALORES PARA LA CASILLA
					min = mintmp;
					casMinX = j;
					casMinY = i;
				}
			}
		}

		if(min == 1000) //Se ha encontrado solución
			return true;
		
		for(int i = 0; i < 9; i++) {
			if(valoresNoPosibles[casMinX][casMinY][i] == 0) {
				propagarRestricciones(casMinX, casMinY, (i+1)); //También pone la casilla a i+1
				if(buscarSolucion())
					return true;
				propagarRestricciones(casMinX, casMinY, 0); //También pone casilla a 0
			}
		}
		
		return false;
	}
	
	
	/**
     * Representación del sudoku como una cadena de caracteres
	 * @see java.lang.Object#toString()
	 */
	public String toString () {
		String cad = "";
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				cad += tablero[j][i];
		return cad;
	}

}
 
                
 

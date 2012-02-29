//Title:       SudokuTester
//Version:     0.1
//Copyright:   2011
//Author:      Miguel Cant�n Cort�s
//E-mail:      miwelc@correo.ugr.es

import java.util.Date;

/**
* Prueba b�sica de un set de Sudokus
* 
* @author Miguel Cant�n Cort�s
*/

public class Test 
{
	public static final String SET_SUDOKUS = "008704900020005000065080400000000007003000600500000000059060130000800040001309700060000030007000000309000806030504080005000100020907050102000408000000503040000070000361000000409125800020004000000009000000000500000000600030000798206000000857000302010004000325000001007000000000000260000035000000000009800400000094000600700208000000900300097008020000001000200000012603490000709000700000010000315004001000000000010080000000200350000000002301600500000007004608300000000003001000000070000000010032000700000000000000000050406080049080106060709020000000000000000008000060050000000000800900004700401205300009007000000000200800009903108402100702003000000000900500007700000001000100200010300000000700000000008060006009000200800000500003000000040000001030609000201000012000500056000100003000470000607000005000700000000000009010300000004090000603000900700001600000035100009002000406000070200010000070600000000001000002030004000000000500000610000000070000000000000007005000000008000400000000001000002030004000000000500600300000000070000000000000078006000000005000000000000001000002030040000000005000000000004600200000000070000000000000050060000008000000001000002030040500000000000000600070000000000000050000000000030060002000800000000001000002030400000000050000000036000000000007000700000000800000000000000450000000001000002300004000000000500000010000000670000000000000006005000080003000000000000001000002300004000000000500000100000000670000000000000006005000080003000000000000001000002300004000000050000000610000000000007000000000085007000000002000000000000001000002300004000000050000000610000000000007000000000085007000000003000000000000001000010000002000000000000340000000020050600000700000008000000006004000000000000001000020000003000000000000000000000400100500000000000065000000002074080000000000001000020000003000000000000040000000530000600000780000009000000006004000000000000001000020000003000040000400500160000000700000000000000007005000000008000000000000001000020000003000400000000050000000600000070000280000070000300000000005000000000001000020000003004000050000000610000000000007000000000050007000000004000800000000001000020000010000034000000000000050200006000000000000700400000000038000000000000001000020000030000000000400000001000000506000000040000000000000006070000890000000001000020000030000045000000000000060200001000000000000700500000080040000000000000001000020000300000040000000050000000620000700000000000007000000008054000000000000001000020000340000050000000000001060000000000000002000708000003000000005000000000001000020000340000050000000000001060000000000000007000208000003000000005000000000001000020030040000000005000000000004600700000000080000000000000050060000002000000001000020300004000000000000000200000000000005000000600072008000000035000000000000001000020300004000000000500000100000000670000000000000006005000080003000000000000001000020300004000000000500000160000000700000000000000007005000080003000000000000001002000000030000004000000000000050006400000000000000070000060000000008230000000001002000000030000004000000000000050006400000000000700000000060000080000230000000001002000000030000004000000000000050006400000000070000000000060000080000230000000001002000000030000004000000000000050006400000000070000000000060800000000230000000001002000000030000004000000000000050006407000000000000080000060000000000230000000001002000000300000000000000000000000000000004500640000700000080000000210030000000001002000000300000000000000000040050000000000260600000000700000003000008004000000001002000000300000000000000040050060000000000780800000000400000000000002005000000001002000000340000000000000000000050000600000307000010000000080000000000240000000001002000000340000000000000000000050000600000708000010000000090000000000240000000001002000000340000005000000000000060007500000000800000000000070000000000240000000001002000000340005000000000000000060000500000007000010000000080000000000240000000001002000000340005000000000000000060000507000000000080000000100000000000240000000001002000000340005000000000060000070000500000000000080000000100000000000240000000001002000300004000000000000000500000000000006000000200075008000000036000000000000001002003000340000000000000000000056000700000000000010000000080000000000240000000001002003000340000000000000000000560000700000000000010000000080000000000240000000001002003000340000000500000000000670000000000000000010000000080000000000240000000001020000000003000040000500000601000000007000000050000000000000708040000000000000001020000000300000040000000050000000620000700000000000007000000008035000000000000001020000000300000040000000050000000620000700000000000007000000008053000000000000001020000000300000040000000050000000620000700000000000007000000008054000000000000001020000003400000000000000000000000030000500000000000006000000405037008000000000001020000300400000000000005000000000000060000000007000045000320000000800000000000001020000300400000000000500000100000000607000000080000090000000006050000000000000001020003000400000000000000000000000050000600000000000007000000406058300000000000001020003000400000000000005000000000060000000000000000007000000405068300000000000001020003000400000000000005000000000260000000700000000005008000004070000000000000001020030000400000000000000500006000230000700000000000007000000008050000000000000001023000000400000000000000560000000200007800000000000008000000004050000000000000001200000000300000000000000020010040000000000530600000000007000000000080009000000010000000002030000000000004000000000000050600000700000000108000020000003400000000010000000002034000000000000000005060000000000700210000030000050000000000800000000010000000023400000000000000500003000000000060400000002000700000080060000000000000010000000200000003000000100000400000005000000000000000046000000003072800000000000010000000200000030000000000000000000400050600000000700056204000000008000000000000010000000200003004000000500600700000000810000000000000008006000000002000000000000010000000200030000000000000000040000000000005600000000043506007000000000080000000010000000200030000040005000006000000000100002000000000007060000008000500000000000010000000200030000405000000000000000000000006000000070000602000080000340000000000010000002000000000030000300000004000500000000000610700000000000204000000800000000010000002000000000030000300000004000500000000000610700000000000804000000200000000010000002000034000000000000005000000604700800000000000030005000000000000080000000010000020000034000000000000500000000406700800000000000030005000000000000080";
	public static final int TAM_SET = 80;
		
	public static void main (String args[])
	{
		SudokuSolver sudoku;
		long   inicio, fin, tiempo = 0;
		
		for(int i = 0; i < TAM_SET; i++) {
			// Resoluci�n del sudoku
			inicio = (new Date()).getTime();
	
			sudoku = new SudokuSolver(SET_SUDOKUS.substring(i*81, i*81+81));
			sudoku.solve();
			
			fin = (new Date()).getTime();
			tiempo += fin - inicio;
			

			// Resultado
			//System.out.println("Soluci�n:");
			//System.out.println(sudoku.toString());
			//System.out.println("Tiempo: "+tiempo+" milisegundos.");
		}
		System.out.println("Tiempo: "+tiempo+" milisegundos.");
	}
}
 
                
 

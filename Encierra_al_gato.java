

import java.util.Scanner;

public class Encierra_al_gato {

	public static final String ROJO     = "\033[31m";
	public static final String VERDE    = "\033[32m";
	public static final String AMARILLO = "\033[33m";
	public static final String AZUL     = "\033[34m";
	public static final String MORADO   = "\033[35m";
	public static final String TURQUESA = "\033[36m";
	public static final String BLANCO   = "\033[37m"; 
	public static final String NEGRO   = "\u001B[0m";

	public static final int GATO = 2;
	public static final int BARRERA = 1;
	public static final int LIBRE = 0;

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int[][] m = asignarDatos();
		String respuesta;
		boolean parar = false;
		int reiniciar = 0;



		menu();

		System.out.printf("\t\t\t\t\t\t%s", "Introduce un número: ");
		int opcion = teclado.nextInt();
		teclado.nextLine();

		//Comprobar que se introduce un numero valido del menu
		do {

			if(opcion < 0 || opcion > 3) {

				System.out.println();
				System.out.printf("\t%s", "Por favor, introduzca un número válido: ");
				opcion = teclado.nextInt();
				teclado.nextLine();

			}

		}while( opcion < 0 || opcion > 3);

		do {
			switch (opcion) {

			case 1:

				//Imprimir ayuda de juego
				System.out.println();

				normasjuego();

				//Preguntar al usuario si quiere jugar
				System.out.println();
				System.out.printf("\t\t%s","Quieres jugar?(s/n): ");
				respuesta = teclado.nextLine();

				//Comprobar que se introducen algunas de las letras indicadas
				while(!respuesta.equals("s") || !respuesta.equals("n")){

					//Si es s para el while
					if(respuesta.equals("s")) {

						break;

						//Si es q no muestra el mensaje de despedida y sale del while
					}else if(respuesta.equals("n")) {

						System.out.println();
						System.out.println(AZUL + "				 _    _           _____ _______          _____  _____   ____  _   _ _______ ____  _ ");
						System.out.println("			| |  | |   /\\    / ____|__   __|/\\      |  __ \\|  __ \\ / __ \\| \\ | |__   __/ __ \\| |");
						System.out.println("			| |__| |  /  \\  | (___    | |  /  \\     | |__) | |__) | |  | |  \\| |  | | | |  | | |");
						System.out.println("			|  __  | / /\\ \\  \\___ \\   | | / /\\ \\    |  ___/|  _  /| |  | | . ` |  | | | |  | | |");
						System.out.println("			| |  | |/ ____ \\ ____) |  | |/ ____ \\   | |    | | \\ \\| |__| | |\\  |  | | | |__| |_|");
						System.out.println("			|_|  |_/_/    \\_\\_____/   |_/_/    \\_\\  |_|    |_|  \\_\\\\____/|_| \\_|  |_|  \\____/(_)" + BLANCO);
						System.out.println();

						break;
					}

					//En caso de que no sea ninguna de las dos letras, vuelve a pedir los datos
					System.out.println();
					System.out.printf("\t\t%s","Por favor indique con (s/n) si quiere o no jugar: ");
					respuesta = teclado.nextLine();

				}

				//Si es que no para el programa
				if(respuesta.equals("n")) {

					break;

				}



			case 2:

				//Imprimir tablero y jugar
				System.out.println();

				do {

					imprimirTablero(m);
					parar = jugar(m);

				}while(!parar);

				System.out.printf("\t%s","Quieres volver a jugar? (-1 para confirmar, cualquier otro para salir): ");
				reiniciar = teclado.nextInt();
				System.out.println();

				if(reiniciar != -1) {

					//				  _    _           _____ _______          _____  _____   ____  _   _ _______ ____  _ 
					//				 | |  | |   /\    / ____|__   __|/\      |  __ \|  __ \ / __ \| \ | |__   __/ __ \| | 
					//				 | |__| |  /  \  | (___    | |  /  \     | |__) | |__) | |  | |  \| |  | | | |  | | |
					//				 |  __  | / /\ \  \___ \   | | / /\ \    |  ___/|  _  /| |  | | . ` |  | | | |  | | |
					//				 | |  | |/ ____ \ ____) |  | |/ ____ \   | |    | | \ \| |__| | |\  |  | | | |__| |_|
					//				 |_|  |_/_/    \_\_____/   |_/_/    \_\  |_|    |_|  \_\\____/|_| \_|  |_|  \____/(_)

					System.out.println(AZUL + "		         _    _           _____ _______          _____  _____   ____  _   _ _______ ____  _ ");
					System.out.println("			| |  | |   /\\    / ____|__   __|/\\      |  __ \\|  __ \\ / __ \\| \\ | |__   __/ __ \\| |");
					System.out.println("			| |__| |  /  \\  | (___    | |  /  \\     | |__) | |__) | |  | |  \\| |  | | | |  | | |");
					System.out.println("			|  __  | / /\\ \\  \\___ \\   | | / /\\ \\    |  ___/|  _  /| |  | | . ` |  | | | |  | | |");
					System.out.println("			| |  | |/ ____ \\ ____) |  | |/ ____ \\   | |    | | \\ \\| |__| | |\\  |  | | | |__| |_|");
					System.out.println("			|_|  |_/_/    \\_\\_____/   |_/_/    \\_\\  |_|    |_|  \\_\\\\____/|_| \\_|  |_|  \\____/(_)" + BLANCO);
					System.out.println();

				}else {

					m = asignarDatos();
					opcion = 2;

				}

				break;

			case 3:

				//Cerrar el programa
				System.out.println();
				System.out.println(AZUL + "		         _    _           _____ _______          _____  _____   ____  _   _ _______ ____  _ ");
				System.out.println("			| |  | |   /\\    / ____|__   __|/\\      |  __ \\|  __ \\ / __ \\| \\ | |__   __/ __ \\| |");
				System.out.println("			| |__| |  /  \\  | (___    | |  /  \\     | |__) | |__) | |  | |  \\| |  | | | |  | | |");
				System.out.println("			|  __  | / /\\ \\  \\___ \\   | | / /\\ \\    |  ___/|  _  /| |  | | . ` |  | | | |  | | |");
				System.out.println("			| |  | |/ ____ \\ ____) |  | |/ ____ \\   | |    | | \\ \\| |__| | |\\  |  | | | |__| |_|");
				System.out.println("			|_|  |_/_/    \\_\\_____/   |_/_/    \\_\\  |_|    |_|  \\_\\\\____/|_| \\_|  |_|  \\____/(_)" + BLANCO);
				System.out.println();
				break;

			}

		}while(reiniciar == -1);

	}

	public static void menu() {

		//		  _____ _   _  ____ ___ _____ ____  ____      _          _    _        ____    _  _________
		//		 | ____| \ | |/ ___|_ _| ____|  _ \|  _ \    / \        / \  | |      / ___|  / \|_   _/ _ \ 
		//		 |  _| |  \| | |    | ||  _| | |_) | |_) |  / _ \      / _ \ | |     | |  _  / _ \ | || | | |
		//		 | |___| |\  | |___ | || |___|  _ <|  _ <  / ___ \    / ___ \| |___  | |_| |/ ___ \| || |_| |
		//		 |_____|_| \_|\____|___|_____|_| \_\_| \_\/_/   \_\  /_/   \_\_____|  \____/_/   \_\_| \___/

		//asciiart

		System.out.println(BLANCO);
		System.out.println("		  _____ _   _  ____ ___ _____ ____  ____      _          _    _        ____    _  _________");
		System.out.println("		 | ____| \\ | |/ ___|_ _| ____|  _ \\|  _ \\    / \\        / \\  | |      / ___|  / \\|_   _/ _ \\ ");
		System.out.println("		 |  _| |  \\| | |    | ||  _| | |_) | |_) |  / _ \\      / _ \\ | |     | |  _  / _ \\ | || | | |");
		System.out.println("		 | |___| |\\  | |___ | || |___|  _ <|  _ <  / ___ \\    / ___ \\| |___  | |_| |/ ___ \\| || |_| |");
		System.out.println("		 |_____|_| \\_|\\____|___|_____|_| \\_\\_| \\_\\/_/   \\_\\  /_/   \\_\\_____|  \\____/_/   \\_\\_| \\___/");
		System.out.println();

		System.out.println("       ______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println();

		System.out.printf("\t\t\t\t\t\t%s%n", "1.- Aprende a jugar");
		System.out.printf("\t\t\t\t\t\t%s%n", "2.- Jugar");
		System.out.printf("\t\t\t\t\t\t%s%n", "3.- Salir");
		System.out.println();

	}
	public static void normasjuego() {

		System.out.printf("\t ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════╗%n");
		System.out.printf("\t ║ Es sencillo, tenemos un gato que se ira moviendo dependiendo de las casillas que tu marques como barreras. ║%n");
		System.out.printf("\t ║ Las barreras son las casillas en las cuales el gato no se puede colocar.                                   ║%n");
		System.out.printf("\t ║ Ganas si consigues encerrarlo y pierdes en el caso que el gato llegue a tocar alguna de las esquinas.      ║%n");
		System.out.printf("\t ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════╝%n");

	}
	public static int[][] asignarDatos(){

		int[][] m = new int[10][10];

		int min = 0;
		int max = 9;

		int fila;
		int columna;

		//Rellenar todo a ceros menos la casilla inicial

		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < m[0].length; j++) {


				m[i][j] = LIBRE;

			}

			fila = (int) (Math.random() * (max - min + 1) + min);
			columna = (int) (Math.random() * (max - min + 1) + min);

			m[fila][columna] = BARRERA;

		}

		m[5][5] = GATO;

		return m;
	}
	public static void imprimirTablero(int m[][]) {

		int contador = 1;
		
		System.out.println();
		System.out.printf("%47s", " ");
		System.out.println(" 1   2   3   4   5   6   7   8   9   10 ");
		
		//Imprimir numeros laterales
		for (int i = 0; i < m.length; i++) {

			System.out.printf("%43s", " ");

            if(contador == 10){

                System.out.print(contador);

            }else{

                System.out.print(contador + " ");

            }
			
			contador++;
			
			for (int j = 0; j < m[0].length; j++) {

				if(i % 2 == 0) {

					if(j == 0) {

						System.out.printf("%2s", " ");

					}

				}

				//LIBRE-BARRERA-GATO
				
				if(m[i][j] == LIBRE) {

					System.out.printf("%s ", " 🔵" + BLANCO);

				}else if(m[i][j] == GATO){

					System.out.printf(" %s ", "🐈" + BLANCO);

				}else if(m[i][j] == BARRERA) {

					System.out.printf("%s "," ⚪️");

				}

			}
			System.out.printf("%n");

		}	
		System.out.println();
		System.out.println();

	}
	public static boolean jugar(int m[][]) {

		Scanner teclado = new Scanner(System.in);

		boolean fin = false;
		boolean movimientos;
		int fila;
		int columna;

		//Pedir al usuario la casilla la cual quiere poner como barrera y comprobar todos los errores posibles

		System.out.printf("\tPor favor, introduce la fila: ");
		fila = teclado.nextInt();
		fila -= 1;

		System.out.printf("\tPor favor, introduce la columna: ");
		columna = teclado.nextInt();
		columna -= 1;

		System.out.println();

		do {

			if(fila < 0 ) {

				System.out.printf("\t%s","No se permiten numeros negativos o 0, introduce de nuevo la fila: ");
				fila = teclado.nextInt();
				fila -= 1;

			}

			if(columna < 0) {

				System.out.printf("\t%s","No se permiten numeros negativos o 0, introduce de nuevo la columna: ");
				columna = teclado.nextInt();
				columna -= 1;

			}

			if(fila > 9) {

				System.out.printf("\tFila fuera del rango, por favor introduce de nuevo la fila: ");
				fila = teclado.nextInt();
				fila -= 1;

			}

			if(columna > 9) {

				System.out.printf("\tColumna fuera del rango, por favor introduce de nuevo la columna: ");
				columna = teclado.nextInt();
				columna -= 1;

			}

			if(m[fila][columna] == GATO) {

				System.out.printf("\t%s%n","No puedes cambiar la posición en la cual esta el gato, indique otra casilla.");
				System.out.println();

				System.out.printf("\tPor favor, introduce de nuevo la fila: ");
				fila = teclado.nextInt();
				fila -= 1;

				System.out.printf("\tPor favor, introduce de nuevo la columna: ");
				columna = teclado.nextInt();
				columna -= 1;

			}

			if(m[fila][columna] == BARRERA) {

				System.out.printf("\t%s%n","Esta casilla ya ha sido marcada como barrera, por favor indica otra casilla.");
				System.out.println();

				System.out.printf("\tPor favor, introduce de nuevo la fila: ");
				fila = teclado.nextInt();
				fila -= 1;

				System.out.printf("\tPor favor, introduce de nuevo la columna: ");
				columna = teclado.nextInt();
				columna -= 1;

			}


		}while(fila < 0 || columna < 0 || m[fila][columna] == GATO || fila > 9 || columna > 9 || m[fila][columna] == BARRERA);

		m[fila][columna] = BARRERA;

		//Hacer los movimiento y determinar si gana o no

		movimientos = moverGato(m);
		System.out.println();

		if(!movimientos) {

			fin = true;

		}

		return fin;

	}
	public static boolean moverGato(int[][] m) {

		boolean movimientos = true;
		int gatoFila = 0;
		int gatoColumna = 0;

		int min = 0;
		int max = 5;

		int random;
		boolean movido = false;

		//Encontrar al gato
		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < m[0].length; j++) {

				if(m[i][j] == GATO){

					gatoFila = i;
					gatoColumna = j;

				}
			}
		}

		if(ganar_Perder(m, gatoFila, gatoColumna)) {

			movimientos = false;

		}else {

			//Mover aleatoriamente el gato en todas las direcciones posibles (0-5) siempre q sea posible
			do {
				random = (int) (Math.random() * (max - min + 1) + min);

				switch(random) {

				case 0:

					//Derecha
					if(m[gatoFila][gatoColumna+1] == LIBRE) {

						m[gatoFila][gatoColumna+1] = GATO;
						m[gatoFila][gatoColumna] = LIBRE;
						movido = true;

					}	

					break;

				case 1:

					if(gatoFila % 2 == 0) {

						//Abajo derecha
						if(m[gatoFila+1][gatoColumna+1] == LIBRE) {

							m[gatoFila+1][gatoColumna+1] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}else {

						//Abajo derecha
						if(m[gatoFila+1][gatoColumna] == LIBRE) {

							m[gatoFila+1][gatoColumna] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}
					}

					break;

				case 2:

					if(gatoFila % 2 == 0) {

						//Abajo izquierda
						if(m[gatoFila+1][gatoColumna] == LIBRE) {

							m[gatoFila+1][gatoColumna] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}else {

						//Abajo izquierda
						if(m[gatoFila+1][gatoColumna-1] == LIBRE) {

							m[gatoFila+1][gatoColumna-1] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}

					break;

				case 3:

					if(gatoFila % 2 == 0) {

						//Arriba derecha
						if(m[gatoFila-1][gatoColumna+1] == LIBRE ) {

							m[gatoFila-1][gatoColumna+1] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}else {

						//Arriba derecha
						if(m[gatoFila-1][gatoColumna] == LIBRE ) {

							m[gatoFila-1][gatoColumna] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}

					break;

				case 4:

					if(gatoFila % 2 == 0) {

						//Arriba izquierda
						if(m[gatoFila-1][gatoColumna] == LIBRE) {

							m[gatoFila-1][gatoColumna] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}else {

						//Arriba izquierda
						if(m[gatoFila-1][gatoColumna-1] == LIBRE) {

							m[gatoFila-1][gatoColumna-1] = GATO;
							m[gatoFila][gatoColumna] = LIBRE;
							movido = true;

						}

					}

					break;

				case 5:

					//Izquierda
					if(m[gatoFila][gatoColumna-1] == LIBRE) {

						m[gatoFila][gatoColumna-1] = GATO;
						m[gatoFila][gatoColumna] = LIBRE;
						movido = true;

					}

					break;
				}

			}while(!movido);

		}
		return movimientos;
	}
	public static boolean ganar_Perder(int[][] m, int gatoFila, int gatoColumna) {

		boolean fin = false;

		//Comprobar si el gato se ha escapado
		if(gatoFila+1 > 9 || gatoColumna+1 > 9 || gatoFila-1 < 0 || gatoColumna-1 < 0) {

			imprimirTablero(m);

			//			  _    _           _____   _____  ______ _____  _____ _____ _____   ____  
			//			 | |  | |   /\    / ____| |  __ \|  ____|  __ \|  __ \_   _|  __ \ / __ \ 
			//			 | |__| |  /  \  | (___   | |__) | |__  | |__) | |  | || | | |  | | |  | |
			//			 |  __  | / /\ \  \___ \  |  ___/|  __| |  _  /| |  | || | | |  | | |  | |
			//			 | |  | |/ ____ \ ____) | | |    | |____| | \ \| |__| || |_| |__| | |__| |
			//			 |_|  |_/_/    \_\_____/  |_|    |______|_|  \_\_____/_____|_____/ \____/ 

			System.out.println(ROJO + "			  _    _           _____   _____  ______ _____  _____ _____ _____   ____");
			System.out.println("			 | |  | |   /\\    / ____| |  __ \\|  ____|  __ \\|  __ \\_   _|  __ \\ / __ \\ ");
			System.out.println("			 | |__| |  /  \\  | (___   | |__) | |__  | |__) | |  | || | | |  | | |  | |");
			System.out.println("			 |  __  | / /\\ \\  \\___ \\  |  ___/|  __| |  _  /| |  | || | | |  | | |  | |");
			System.out.println("			 | |  | |/ ____ \\ ____) | | |    | |____| | \\ \\| |__| || |_| |__| | |__| |");
			System.out.println("			 |_|  |_/_/    \\_\\_____/  |_|    |______|_|  \\_\\_____/_____|_____/ \\____/" + NEGRO);
			System.out.println();

			fin = true;

			//Comprobar si el gato esta en una linea par o impar
		}else if(gatoFila % 2 == 0){

			if(m[gatoFila][gatoColumna+1] == BARRERA && m[gatoFila+1][gatoColumna+1] == BARRERA && m[gatoFila+1][gatoColumna] == BARRERA && m[gatoFila-1][gatoColumna+1] == BARRERA && m[gatoFila-1][gatoColumna] == BARRERA && m[gatoFila][gatoColumna-1] == BARRERA) {

				imprimirTablero(m);

				//				  _    _           _____    _____          _   _          _____   ____  
				//				 | |  | |   /\    / ____|  / ____|   /\   | \ | |   /\   |  __ \ / __ \ 
				//				 | |__| |  /  \  | (___   | |  __   /  \  |  \| |  /  \  | |  | | |  | |
				//				 |  __  | / /\ \  \___ \  | | |_ | / /\ \ | . ` | / /\ \ | |  | | |  | |
				//				 | |  | |/ ____ \ ____) | | |__| |/ ____ \| |\  |/ ____ \| |__| | |__| |
				//				 |_|  |_/_/    \_\_____/   \_____/_/    \_\_| \_/_/    \_\_____/ \____/ 

				System.out.println(VERDE + "				  _    _           _____    _____          _   _          _____   ____");
				System.out.println("				 | |  | |   /\\    / ____|  / ____|   /\\   | \\ | |   /\\   |  __ \\ / __ \\ ");
				System.out.println("				 | |__| |  /  \\  | (___   | |  __   /  \\  |  \\| |  /  \\  | |  | | |  | |");
				System.out.println("				 |  __  | / /\\ \\  \\___ \\  | | |_ | / /\\ \\ | . ` | / /\\ \\ | |  | | |  | |");
				System.out.println("				 | |  | |/ ____ \\ ____) | | |__| |/ ____ \\| |\\  |/ ____ \\| |__| | |__| |");
				System.out.println("				 |_|  |_/_/    \\_\\_____/   \\_____/_/    \\_\\_| \\_/_/    \\_\\_____/ \\____/" + BLANCO);

				fin = true;

			}

		}else if(gatoFila % 2 != 0){

			if(m[gatoFila][gatoColumna+1] == BARRERA && m[gatoFila+1][gatoColumna] == BARRERA && m[gatoFila+1][gatoColumna-1] == BARRERA && m[gatoFila][gatoColumna-1] == BARRERA && m[gatoFila-1][gatoColumna-1] == BARRERA && m[gatoFila-1][gatoColumna] == BARRERA ) {

				imprimirTablero(m);

				//				  _    _           _____    _____          _   _          _____   ____  
				//				 | |  | |   /\    / ____|  / ____|   /\   | \ | |   /\   |  __ \ / __ \ 
				//				 | |__| |  /  \  | (___   | |  __   /  \  |  \| |  /  \  | |  | | |  | |
				//				 |  __  | / /\ \  \___ \  | | |_ | / /\ \ | . ` | / /\ \ | |  | | |  | |
				//				 | |  | |/ ____ \ ____) | | |__| |/ ____ \| |\  |/ ____ \| |__| | |__| |
				//				 |_|  |_/_/    \_\_____/   \_____/_/    \_\_| \_/_/    \_\_____/ \____/ 

				System.out.println(VERDE + "				  _    _           _____    _____          _   _          _____   ____");
				System.out.println("				 | |  | |   /\\    / ____|  / ____|   /\\   | \\ | |   /\\   |  __ \\ / __ \\ ");
				System.out.println("				 | |__| |  /  \\  | (___   | |  __   /  \\  |  \\| |  /  \\  | |  | | |  | |");
				System.out.println("				 |  __  | / /\\ \\  \\___ \\  | | |_ | / /\\ \\ | . ` | / /\\ \\ | |  | | |  | |");
				System.out.println("				 | |  | |/ ____ \\ ____) | | |__| |/ ____ \\| |\\  |/ ____ \\| |__| | |__| |");
				System.out.println("				 |_|  |_/_/    \\_\\_____/   \\_____/_/    \\_\\_| \\_/_/    \\_\\_____/ \\____/" + BLANCO);

				fin = true;

			}

		}


		return fin;
	}
}

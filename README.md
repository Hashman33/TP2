[![Build Status](https://travis-ci.org/Hashman33/TP2.svg?branch=master)](https://travis-ci.org/Hashman33/TP2)
# TP2 - AlgoCraft

Grupo #13 - Turno Noche

ESTADO DEL TP:
	
	Implementado y testeado:
	- Herramientas se crean correctamente dependiendo de su tipo y material.
	- Los materiales se desgastan de manera correcta dependiendo de la herramienta (DOUBLE DISPACH).
	- Las herramientas se desgastan correctamente.
	- Jugador se crea correctamente con un Hacha de Madera equipada.
	- Se implementó un Mapa (singleton) que está compuesta por una Matriz que admite Celdas compuestas por un Material o Jugador.
	- El Mapa se inicia con Materiales dentro del mismo insertados manualmente.
	- El Jugador puede insertarse en el Mapa en el Origen (0,0) o en una posición dada.
	- El Jugador puede moverese libremente en el mapa mientras la celda a ocupar este vacía.
	- El Jugador posee un inventario de materiales y herramientas, puede incorporar y remover elementos del mismo.
	
	En implentación:
	- Clase MesaDeTrabajo para la creación de herramientas.
	- Clase Juego con el inicio del juego.
	
	
SUPUESTOS:

No se puede desgastar madera con un pico fino.

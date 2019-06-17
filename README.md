[![Build Status](https://travis-ci.org/Hashman33/TP2.svg?branch=master)](https://travis-ci.org/Hashman33/TP2)
# TP2 - AlgoCraft

Grupo #13 - Turno Noche

ESTADO DEL TP:
	
	Implementado y testeado:
	- Herramientas se crean correctamente dependiendo de su tipo y material.
	- Los materiales se desgastan de manera correcta dependiendo de la herramienta (DOUBLE DISPACH).
	- Las herramientas se desgastan correctamente.
	- Jugador se crea correctamente con un Hacha de Madera equipada.
	- Se implementó un Mapa (singleton) que está compuesta por una Matriz compuesta por Celdas que admiten un Material o Jugador.
	- El Mapa se inicia con Materiales dentro del mismo insertados manualmente.
	- El Jugador puede insertarse en el Mapa en el Origen (0,0) o en una posición dada.
	- El Jugador puede moverese libremente en el mapa mientras la celda a ocupar este vacía.
	- El Jugador posee un inventario de materiales y herramientas, puede incorporar y remover elementos del mismo.
	- Clase MesaDeTrabajo para la creación de herramientas.
    - El jugador puede obtener materiales del mapa correctamente y sus herramientas se rompen con el uso.
	
	En implentación:
	- Clase MapaRandom 
	- Clase Juego con el inicio del juego.
	
	
SUPUESTOS:

No se puede desgastar madera con un pico fino.
El material se obtiene en el momento que se su durabilidad llega a 0.
La herramienta se rompe en el intento de uso posterior al llegar a durabilidad 0 y aparece la mano equipada(este "uso" no desgasta material).

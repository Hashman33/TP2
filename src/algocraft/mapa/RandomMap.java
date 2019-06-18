package algocraft.mapa;

import algocraft.material.*;
import algocraft.utilidades.VectorPosicion2I;

import java.util.Random;

public class RandomMap {

    private Mapa mapa;
    private int ancho;
    private int largo;


    public RandomMap(Mapa mapavacio,int anchomapa, int largomapa){

        mapa = mapavacio;
        ancho = anchomapa;
        largo = largomapa;

    }

    public void disponerMaterialMadera( int max, int min){

        Random generator = new Random();
        int cantidad = generator.nextInt(max - min + 1) + min;

        int candidadActual = 0;

        int cantidadPorGrupo = cantidad/3;

        while(candidadActual < cantidad){

            int cantidadGrupo = generator.nextInt(cantidadPorGrupo) + 1;
            if ((candidadActual + cantidadGrupo) > cantidad){ cantidadGrupo = cantidad - candidadActual;}
            Material maderas[] = new Material[cantidadGrupo];

            for(int i = 0; i< cantidadGrupo; i++){
                maderas[i] = new Madera();
            }
            candidadActual += patronCuadrado(maderas, cantidadGrupo);

        }


    }

    public void disponerMaterialPiedra( int max, int min){      // 20 6  4

        Random generator = new Random();
        int cantidad = generator.nextInt(max - min + 1 ) + min;

        int candidadActual = 0;

        int cantidadPorGrupo = cantidad/3;


        while(candidadActual < (cantidad )){

            int cantidadGrupo = generator.nextInt(cantidadPorGrupo) + 1;
            if ((candidadActual + cantidadGrupo) > cantidad){ cantidadGrupo = cantidad - candidadActual;}
            Material piedras[] = new Material[cantidadGrupo];

            for(int i = 0; i< cantidadGrupo; i++){
                piedras[i] = new Piedra();
            }
            candidadActual += patronCuadrado(piedras, cantidadGrupo);


        }


    }

    public void disponerMaterialMetal( int max, int min){

        Random generator = new Random();
        int cantidad = generator.nextInt(max - min + 1 ) + min;

        int candidadActual = 0;

        int cantidadPorGrupo = cantidad/3;

        while(candidadActual < (cantidad )){

            int cantidadGrupo = generator.nextInt(cantidadPorGrupo) + 1;
            if ((candidadActual + cantidadGrupo) > cantidad){ cantidadGrupo = cantidad - candidadActual;}
            Material metales[] = new Material[cantidadGrupo];

            for(int i = 0; i< cantidadGrupo; i++){
                metales[i] = new Metal();
            }
            candidadActual += patronCuadrado(metales, cantidadGrupo);

        }

    }

    public void disponerMaterialDiamante( int max, int min){

        Random generator = new Random();
        int cantidad = generator.nextInt(max - min + 1 ) + min;

        int candidadActual = 0;

        int cantidadPorGrupo = cantidad/2;

        while(candidadActual < cantidad ){

            int cantidadGrupo = generator.nextInt(cantidadPorGrupo) + 1;
            if ((candidadActual + cantidadGrupo) > cantidad){ cantidadGrupo = cantidad - candidadActual;}
            Material diamantes[] = new Material[cantidadGrupo];

            for(int i = 0; i< cantidadGrupo; i++){
                diamantes[i] = new Diamante();
            }
            candidadActual += patronCuadrado(diamantes, cantidadGrupo);

        }

    }





    public int patronCuadrado(Material listamateriales[], int cantidad ){
        Random generator = new Random();

        int x = generator.nextInt(ancho);
        int y = generator.nextInt(largo);
        int indexMaterial = 0;
        if( cantidad == 1){
            if(mapa.insertarMaterial(listamateriales[indexMaterial],new VectorPosicion2I(x,y))){
                indexMaterial++;
            }

            return indexMaterial;
        }
        for (int i = 0; i < cantidad/2 ; i++ ) {
            if (x + i >= largo) break;

            for (int j = 0; j < cantidad / 2; j++) {
                if (y + j >= ancho) break;
                if (indexMaterial>= cantidad) break;
                if (mapa.insertarMaterial(listamateriales[indexMaterial], new VectorPosicion2I(x + i, y + j))) {
                    indexMaterial++;
                }

            }
        }

        return indexMaterial;

    }





}

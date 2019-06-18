package algocraft.randomMap;

import algocraft.mapa.Mapa;
import algocraft.material.Diamante;
import algocraft.material.Madera;
import algocraft.material.Metal;
import algocraft.material.Piedra;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

public class MapaRandomSeCreaCorrectamente {

    @Test
    public void test01MapaGeneradoAleatoriamenteContieneNumeroDeMaderaIndicado(){
        int anchoMapa = 20;
        int largoMapa = 20; //  por el momento la clase Mapa no tiene metodo para dar a conocer su largo ni su ancho.
        int cantMadera = 0;
        int cantPiedra = 0;
        int cantMetal = 0;
        int cantDiamante = 0;
        Mapa mapa = Mapa.obtenerInstancia();
        mapa.maparandom();
        for (int i = 0; i< largoMapa; i++){

            for( int j = 0; j< anchoMapa; j++){

                if(mapa.obtenerMaterial(new VectorPosicion2I(i,j)) == null){continue;}

                if(mapa.obtenerMaterial(new VectorPosicion2I(i,j)).getClass() == Madera.class ){ cantMadera ++; continue;}

                if(mapa.obtenerMaterial(new VectorPosicion2I(i,j)).getClass() == Piedra.class ){ cantPiedra ++; continue;}

                if(mapa.obtenerMaterial(new VectorPosicion2I(i,j)).getClass() == Metal.class ){ cantMetal ++; continue;}

                if(mapa.obtenerMaterial(new VectorPosicion2I(i,j)).getClass() == Diamante.class ){ cantDiamante ++;}


            }
        }

        assert( cantMadera >= 20 && cantMadera <= 30 );


        assert( cantPiedra >= 15  && cantPiedra <= 25 );

        assert( cantMetal >=10 && cantMetal <= 20 );

        assert(cantDiamante >= 4 && cantDiamante <= 6 );


    }






}

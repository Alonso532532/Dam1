package Java.Basicos.Prueba1;

public class pelota {
    int posiciony;
    int posicionx;
    int[] velocidad = {0,0};
    //Compruebo que la velocidad es posible
    public static int[] compVel(int posx, int posy, int[] vel){
        if (posx + vel[0] > 9){
            vel[0] = -1;
        }else if (posx + vel[0] < 0 ){
            vel[0] = 1;
        }
        if (posy + vel[1] > 4){
            vel[1] = -1;
        }else if (posy + vel[1] < 0 ){
            vel[1] = 1;
        }
        return vel;
    }
    //Mueve la pelota sumandole o restandole a su eje y e x dependiendo de su velocidad
    public static int moverx(int pos, int[] vel){
        pos += vel[0];
        return pos;
    }
    public static int movery(int pos, int[] vel){
        pos += vel[1];
        return pos;
    }
}

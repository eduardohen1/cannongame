package br.com.progiv.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

//Canhao
public class Cannon {
    private int baseRadius; //raio da base do canhão
    private int barrelLegth; //comprimento do cano
    private Point barrelEnd = new Point(); //ponto estremo do cano do canhão
    private double barrelAngle; //ângulo do cano do canhão
    private CannonBall cannonBall; //a bala do canhão
    private Paint paint = new Paint(); //objeto desenhar o canho
    private CannonView view;//view

    //construtor
    public Cannon(CannonView view, int baseRadius, int barrelLegth, int barrelWidth){
        this.view = view;
        this.baseRadius = baseRadius;
        this.barrelLegth = barrelLegth;
        paint.setStrokeWidth(barrelWidth); //configura a largura do cano
        paint.setColor(Color.BLACK);
        align(Math.PI / 2);//cano do canhõa voltado diretamete para a direita
    }

    //métod align - alinhar o cano do canhão com o ângulo
    public void align(double barrelAngle){
        this.barrelAngle = barrelAngle;
        barrelEnd.x = (int)(barrelLegth * Math.sin(barrelAngle));
        barrelEnd.y = (int)(-barrelLegth * Math.cos(barrelAngle)) + view.getScreenHeight() / 2;
    }

    //criar e disparar a bala na direção apontada pelo canhão
    public void fireCannonBall(){
        //calcular o componente X de velocidade da bala
        int velocityX = (int)(CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth() * Math.sin(barrelAngle));
        //Calcular o componente Y de velocidade da bala
        int velocityY = (int)(CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth() * -Math.cos(barrelAngle));
        //calcular o raio da bala
        int radius = (int)(view.getScreenHeight() * CannonView.CANNONBALL_RADIUS_PERCENT);
        //constroi a bala e a posiciona no canhão
        cannonBall = new CannonBall(
                view,
                Color.BLACK,
                CannonView.CANNON_SOUND_ID,
                -radius,
                view.getScreenHeight() / 2 -radius,
                radius,
                velocityX,
                velocityY
        );
        //reproduz o som de disparo
        cannonBall.playSound();
    }

    //desenhar o canhão no objeto Canvas:
    public void draw(Canvas canvas){
        //desenhar o cano do canhão
        canvas.drawLine(0, view.getScreenHeight() /2, barrelEnd.x, barrelEnd.y, paint);
        //desenhar a base do canhão
        canvas.drawCircle(0, (int)view.getScreenHeight() / 2, (int)baseRadius, paint);
    }

    //retorna a bala disparada pelo canhão
    public CannonBall getCannonBall(){
        return cannonBall;
    }
    //remover a bala do jogo
    public void removeCannonBall(){
        cannonBall = null;
    }

}

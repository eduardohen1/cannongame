package br.com.progiv.cannongame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameElement {
    protected CannonView view; // a view que contém esse GameElement
    protected Paint paint = new Paint(); //objet Paint para desenhar
    protected Rect shape; //os limites retangulares do GameElement
    protected float velocityY; //velocidade vertical
    protected int soundId;// id do som associado

    //construtor:
    public GameElement(CannonView view, int color, int soundId, int x, int y, int width, int length, float velocityY){
        this.view = view;
        paint.setColor(color);
        shape = new Rect(x, y, x + width, y + length);
        this.soundId = soundId;
        this.velocityY = velocityY;
    }

    //atualizar a posição de GameElement e verificar se há colisões com a parede
    public void update(double interval){
        //atualizar a posição vertical
        shape.offset(0, (int)(velocityY * interval));

        //se esse GameElement colide com a parede, inverte a direção:
        if(shape.top < 0 && velocityY < 0 || shape.bottom > view.getScreenHeight() && velocityY > 0)
            velocityY *= -1;
    }

    //desenhar o objeto Canvas
    public void draw(Canvas canvas){
        canvas.drawRect(shape, paint);
    }
    //reproduzir o som correspondente a esse tipo de objeto
    public void playSound(){
        view.playSound(soundId);
    }

}

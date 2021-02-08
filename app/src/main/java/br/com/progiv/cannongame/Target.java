package br.com.progiv.cannongame;

//alvo
public class Target extends GameElement {
    private int hitReward; //recompensa por acertar o alvo

    //Construtor
    public Target(CannonView view, int color, int hitReward, int x, int y, int width, int length, float velocityY){
        super(view, color, CannonView.TARGET_SOUND_ID, x, y, width, length, velocityY);
        this.hitReward = hitReward;
    }

    //retornar a recompensa por acerto para este alvo
    public  int getHitReward(){
        return this.hitReward;
    }

}

package br.com.progiv.cannongame;

//barreira
public class Blocker extends GameElement {
    private int missPenalty; //a penalidade por erro para essa barreira

    //construtor
    public Blocker(CannonView view, int color, int missPenalty, int x, int y, int width, int length, float velocityY) {
        super(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length, velocityY);
        this.missPenalty = missPenalty;
    }

    public int getMissPenalty(){
        return this.missPenalty;
    }

}

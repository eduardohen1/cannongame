package br.com.progiv.cannongame;

import android.app.Activity;
import android.graphics.Paint;
import android.media.SoundPool;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class CannonView extends SurfaceView
    implements SurfaceHolder.Callback{

    private static final String TAG = "CannonView"; //para registrar erros

    //constantes para interação do jogo
    public static final int MISS_PENALTY = 2; //segundos subtraídos em caso de erro
    public static final int HIT_REWARD = 3; //segundos adicionados em caso de acerto

    //constantes para o canhõa
    public static final double CANNON_BASE_RADIUS_PERCENT = 3.0 / 40;
    public static final double CANNON_BARREL_WIDTH_PERCENT = 3.0 / 40;
    public static final double CANNON_BARREL_LENGTH_PERCENT = 1.0 / 10;

    //constantes para a bala:
    public static final double CANNONBALL_RADIUS_PERCENT = 3.0 / 80;
    public static final double CANNONBALL_SPEED_PERCENT = 3.0 / 2;

    //constantes para os alvos
    public static final double TARGET_WIDTH_PERCENT = 1.0 / 40;
    public static final double TARGET_LENGTH_PERCENT = 3.0 / 20;
    public static final double TARGET_FIRST_X_PERCENT = 3.0 / 5;
    public static final double TARGET_SPACING_PERCENT = 1.0 / 60;
    public static final double TARGET_PIECES = 9;
    public static final double TARGET_MIN_SPEED_PERCENT = 3.0 / 4;
    public static final double TARGET_MAX_SPEED_PERCENT = 6.0 / 4;

    //constantes para a barreira
    public static final double BLOCKER_WIDTH_PERCENT = 1.0 / 40;
    public static final double BLOCKER_LENGTH_PERCENT = 1.0 / 4;
    public static final double BLOCKER_X_PERCENT = 1.0 / 2;
    public static final double BLOCKER_SPEED_PERCENT = 1.0;

    //o tamanho do texto é 1/18 da largura da tela
    public static final double TEXT_SIZE_PERCENT = 1.0 / 18;

    private CannonThread cannonThread; //controla o loop do jogo - threads
    private Activity activity; // para exibir a caixa de diálogo GameOver na Thread da tela
    private boolean dialogDisplayed = false;

    //objetos do jogo
    private Cannon cannon;
    private Blocker blocker;
    private ArrayList<Target> targets;

    //variáveis de dimensão
    private int screenWidth;
    private int screenHeight;

    //variáveis para loop do jogo e controle de estatísticas:
    private boolean gameOver;
    private double timeLeft; //tempo restante, em segundos
    private int shotsFired; //tiros disparados pelo usuários
    private double totalElapsedTime; //segundos decorridos

    //constantes e variáveis para gerenciar sons
    public static final int TARGET_SOUND_ID = 0;
    public static final int CANNON_SOUND_ID = 1;
    public static final int BLOCKER_SOUND_ID = 2;
    private SoundPool soundPool; //reproduz os efeitos sonoros
    private SparseIntArray soundMap; //mapeia os identificadores para soundPool

    //variáveis paint utilizadas ao desenhar cada item na tela
    private Paint textPaint; //objeto Paint usado para desenhar texto
    private Paint backgroundPaint; //objeto Paint usado para limpar a área de desenho

}

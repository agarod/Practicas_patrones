package varios;


import org.newdawn.slick.state.StateBasedGame;

import es.ull.patrones.Characters.BadLemming;


/*
 * Carga y el mundo, devuelve las ID de los niveles y gestiona la interaccion del personje
 * y de los enemigos
 * 
 */
public class World {

    Level[] levels;
    Level NivelActual;
    float initialX, initialY;
    PlayerInteraction InteraccionJugador;
    NPCInteraction InteraccionNPC;
    String IDNivelActual;
    NPCAI npcAI;
    long delta;

    public World(String IDNivelActual, float initialX, float initialY, Level[] niveles){
        this.IDNivelActual = IDNivelActual;
        this.initialX = initialX;
        this.initialY = initialY;
        this.levels = niveles;
    }

    public void ChangeCurrentLevel(){
        NextLevelInformation nextLevelInfo = InteraccionJugador.GetNextLevelInfo();

        for (Level level: levels){
            if(nextLevelInfo.GetLevelID().equals(level.GetLevelID())){
                NivelActual = level;
                break;
            }
        }

        NivelActual.player.SetNewCoordinates(InteraccionJugador.GetNextLevelInfo().GetStartX(),
                InteraccionJugador.GetNextLevelInfo().GetStartY());

        RenderCurrentLevel();
        InteraccionJugador = new PlayerInteraction(NivelActual);
        npcAI = new NPCAI(NivelActual);
        InteraccionNPC = new NPCInteraction(NivelActual, npcAI);
    }

    public void RenderCurrentLevel(){
        NivelActual.Render();
    }

    public Level GetCurrentLevel(){
        return NivelActual;
    }

    public BadLemming[] GetEnemyArray(){
        return GetCurrentLevel().enemies;
    }

    public void UpdatePlayer(int key, long delta, StateBasedGame sbg){
        this.delta = delta;
        InteraccionJugador.HandleEvents(key, delta);
        if( InteraccionJugador.GetSwitchLevel() ){
            ChangeCurrentLevel();
        }
        if(InteraccionJugador.GetGameOver()){
            sbg.enterState(2);
        }
        if(InteraccionJugador.GetGameWin()){
            sbg.enterState(3);
        }
    }

    public void UpdatePlayer(StateBasedGame sbg){
        InteraccionJugador.HandleEvents();
        if( InteraccionJugador.GetSwitchLevel() ){
            ChangeCurrentLevel();
        }
        if(InteraccionJugador.GetGameOver()){
            sbg.enterState(2);
        }
        if(InteraccionJugador.GetGameWin()){
            sbg.enterState(3);
        }
    }

    public void UpdateWorld(long delta, NPCAI npcAI){
        this.delta = delta;
        this.npcAI = npcAI;
        InteraccionNPC.HandleEvents(delta);
    }

    public void InitializeFirstLevel(){
        NextLevelInformation initialLevelInfo = new NextLevelInformation(IDNivelActual, initialX, initialY);
        NivelActual = levels[0];
        RenderCurrentLevel();
        InteraccionJugador = new PlayerInteraction(NivelActual);
        InteraccionNPC = new NPCInteraction(NivelActual, npcAI);
     }

    public PlayerInteraction GetPlayerInteraction(){
        return InteraccionJugador;
    }
}

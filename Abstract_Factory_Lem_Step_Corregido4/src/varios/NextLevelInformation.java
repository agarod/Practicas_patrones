package varios;

/*
 * Devuelve las posicion donde comienza en el siguiente nivel
 */

public class NextLevelInformation {
    String levelID;
    float startX, startY;
    NextLevelInformation initialLevelInfo;

    public NextLevelInformation(String IDNivel, float startX, float startY){
        this.levelID = IDNivel;
        this.startX = startX;
        this.startY = startY;
    }

    public String GetLevelID(){
        return levelID;
    }

    public float GetStartX(){
        return startX;
    }

    public float GetStartY(){
        return startY;
    }
}

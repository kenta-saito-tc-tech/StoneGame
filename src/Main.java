public class Main {
    public static void main(String[] args) {
        StoneGame sg = new StoneGame();
        StonePlayer sp = new StonePlayer();

        sg.gameSetting();
        sp.peopleSetting();
        sg.gameSettingShow(sp.getHowManyPeople(), sp.getName());

        while (sg.getHowManyStone() > 0){
            for(int i = 0; i < sp.getName().length; i++){
                int stoneNum = sg.playerTurn(sp.getName()[i]);
                if(stoneNum == -999){
                    i -= 1;
                    continue;
                } else if (stoneNum <= 0) {
                    break;
                }
            }
        }
    }
}
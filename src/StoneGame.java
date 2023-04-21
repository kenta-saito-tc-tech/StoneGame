import java.util.Scanner;

public class StoneGame {
    //フィールド
    private int howManyStone;
    private String StoneInitial;
    private int howManySteal;

    //コンストラクタ
    public StoneGame() {
        //
    }

    //ゲッター、セッター
    public int getHowManyStone() {
        return howManyStone;
    }

    public void setHowManyStone(int howManyStone) {
        this.howManyStone = howManyStone;
    }
    public void changeHowManyStone(int num){
        this.howManyStone -= num;
    }

    public String getStoneInitial() {
        return StoneInitial;
    }

    public void setStoneInitial(String stoneInitial) {
        StoneInitial = stoneInitial;
    }

    public int getHowManySteal() {
        return howManySteal;
    }

    public void setHowManySteal(int howManySteal) {
        this.howManySteal = howManySteal;
    }

    //メソッド

    /**
     * ゲームのセッティングをするメソッド
     */
    public void gameSetting() {
        BasicMethod.oneNewBorderLine();
        Scanner scn = new Scanner(System.in);
        System.out.println("石取りゲームを開始します。");
        System.out.print("石の総数は?>>");
        setHowManyStone(scn.nextInt()); //総数セット
        System.out.print("石のイニシャルは?>>");
        setStoneInitial(scn.next()); //イニシャルセット
        System.out.print("１度に取れる石の数は?>>");
        setHowManySteal(scn.nextInt()); //取れる個数セット
    }

    /**
     * ゲームのセッティング内容を表示するメソッド
     */
    public void gameSettingShow(int num, String[] str) {
        StonePlayer sp = new StonePlayer();
        BasicMethod.oneNewBorderLine();
        System.out.println("ゲームセッティング内容");
        System.out.println("石の総数:" + getHowManyStone());
        stoneShow(getHowManyStone());
        System.out.println("１度に取れる石の数:" + getHowManySteal());
        System.out.println("プレイヤー一覧");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + "人目:" + str[i] + "さん");
        }
        System.out.println("合計:" + num + "人");
        System.out.println("上記の内容でゲームを開始します");
    }

    /**
     * 石の残数表示メソッド
     * @param num 石の数（getHowManyStone）
     */
    public void stoneShow(int num){
        for(int i = 1; i <= num; i++){
            System.out.print(getStoneInitial());
        }
        System.out.println();
    }

    /**
     * 各プレイヤーのターンメソッド
     * @param str そのターンのプレイヤー名
     * @return -999の場合、例外発生　その他の場合、残りの石の数
     */
    public int playerTurn(String str) {
        BasicMethod.oneNewBorderLine();
        Scanner scn = new Scanner(System.in);
        System.out.println(str+"さんの番");
        System.out.println("石の数を入力してください。（1〜"+getHowManySteal()+"まで入力可能です。）");
        String numStr = scn.nextLine();
        try {
            int stealNum = Integer.parseInt(numStr);
            if (stealNum >0 && stealNum <= getHowManySteal()){
                changeHowManyStone(stealNum);
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            } else if (stealNum <= 0) {
                changeHowManyStone(1);
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            }else if(stealNum > getHowManySteal()){
                changeHowManyStone(getHowManySteal());
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            }
        } catch (NumberFormatException e) {
            System.out.println(numStr + "は数値ではありません。");
            return -999;
        }
        return getHowManyStone();
    }

    /**
     * 勝者と敗者を表示するメソッド
     * @param winName 勝者の名前
     * @param looseName 敗者の名前
     */
    public void winLooseShow(String winName, String looseName){
        Scanner scn = new Scanner(System.in);
        System.out.println("勝者:" +winName);
        System.out.println("敗者:" + looseName);
        scn.close();
    }
}


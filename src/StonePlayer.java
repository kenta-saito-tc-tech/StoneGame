import java.util.Scanner;

public class StonePlayer {
    //フィールド
    private String[] name;
    private int howManyPeople;

    //コンストラクタ
    public StonePlayer() {
        //
    }

    //ゲッター、セッター

    public String[] getName() {
        return this.name;
    }

    public void setName(String name, int i) {
        this.name[i] = name;
    }

    public int getHowManyPeople() {
        // howManyPeople = name.length;
        return this.howManyPeople;
    }

    public void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
        this.name = new String[this.howManyPeople];
    }

    //メソッド

    /**
     * 人数と名前のセッティングメソッド
     */
    public void peopleSetting() {
        BasicMethod.oneNewBorderLine();
        Scanner scn = new Scanner(System.in);
        System.out.print("何人参加しますか?>>");
        setHowManyPeople(scn.nextInt());
        System.out.println("参加する方の名前を入力してください↓");
        for (int i = 0; i < getHowManyPeople(); i++) {
            setName(scn.next(), i);
        }
    }
}

// メインクラス

import java.util.*;

// 抽象クラスを作成する
interface Game {

    // 抽象メソッド(orei)を作成する
    public void orei(String str);

    // 抽象メソッド(end)を作成する
    public void end();
}

// ゲームで遊び終わった後のメッセージ
class Orei implements Game {

    // oeriメソッドをオーバーライドする
    @Override
    public void orei(String str) {
        System.out.println(str + "で遊んでくれてありがとうございます！");
        System.out.println("またのご利用をお待ちしております！");
    }

    // endメソッドをオーバーライドする
    @Override
    public void end() {
        System.out.println("システムを終了します。");
    }
}

// スーパークラスを継承したメインクラス
public class GameCenter extends Orei {
    public static void main(String[] args) {

        // クラスの呼び出し
        Orei orei = new Orei();
        Scanner stdIn = new Scanner(System.in);

        // 初期値をゼロにする
        int retry = 0;

        // 0が入力されるまでループを繰り返す
        do {

            // ユーザに遊ぶゲームを選んでもらう
            // 例外処理を行う
            try {
                System.out.println("どのゲームで遊びますか？");
                System.out.println("1:数当てゲーム");
                System.out.println("2:ジャンケンゲーム");
                System.out.println("3:ラッキーアイテム");
                System.out.println("4:コラッツ予想ゲーム");
                System.out.println("0:終了する");
                System.out.print("1~4の数字を入力してください：");
                retry = stdIn.nextInt();

            } catch (InputMismatchException ex) {
                System.out.println("範囲内の数字を入力してください。");
            } catch (NoSuchElementException ex) {
                System.out.println("範囲内の数字を入力してください。");
            }

            // 1を選んだ場合数当てゲームへ移動する
            if (retry == 1) {
                HitNum.hitnum();
                orei.orei("数当てゲーム");

            // 2を選んだ場合ジャンケンゲームへ移動する
            } else if (retry == 2) {
                Janken.janken();
                orei.orei("ジャンケンゲーム");

            // 3を選んだ場合ラッキーアイテムへ移動する
            } else if (retry == 3) {
                LuckyItem.luckyitem();
                orei.orei("ラッキーアイテム");

            // 4を選んだ場合コラッツ予想ゲームへ移動する
            } else if (retry == 4) {
                Collatz.collatz();
                orei.orei("コラッツ予想ゲーム");

            // 5以上が入力された場合正しい値を入力してもらう
            } else if (3 < retry) {
                System.out.println("範囲内の数字を入力してください");
            }

        } while (retry != 0);

        // メソッドを呼び出し出力する
        orei.end();

        stdIn.close();
    }
}
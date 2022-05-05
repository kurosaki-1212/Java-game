// 数当てゲーム

import java.util.*;

// 数当てのゲームのメインクラス
public class HitNum {
    public static int hitnum() {

        // 入力準備
        Scanner stdIn = new Scanner(System.in);

        // コンピュータが数を選ぶ
        int a = (int) (Math.random() * 50) + 1;

        // カウンターの初期化
        int count = 1;

        // 初期値を0にする
        int retry = 0;

        // ゲーム名の表示
        System.out.println("数当てゲーム！");

        // retryが1の時ループ処理をする
        do {
            try {
                System.out.print("1~50のなかから当ててください！：");
                int x = stdIn.nextInt();

                // 当たるまで繰り返し
                while (x != a) {

                    // ヒントの表示
                    if (x > a) {
                        System.out.println(x + "より小さいです。");
                    } else {
                        System.out.println(x + "より大きいです。");
                    }

                    // カウントを1増やす
                    count++;

                    // 数を入力
                    System.out.print("数字を入力してください：");
                    x = stdIn.nextInt();
                }

                // 最後のメッセージ
                System.out.println("当たりです！");
                System.out.println(count + "回目で当てました。");

            } catch (InputMismatchException ex) {
                System.out.println("整数を入力してください。");
            } catch (NoSuchElementException ex) {
                System.out.println("範囲内の数字を入力してください。");
            }

            // もう一度行うかどうかを確認
            do {
                System.out.print("もう一度やりますか？ (0)いいえ　(1)はい：");

                // 例外処理を行う
                try {
                    retry = stdIn.nextInt();

                } catch (InputMismatchException ex) {
                    System.out.println("0か1を入力して下さい。");
                } catch (NoSuchElementException ex) {
                    System.out.println("範囲内の数字を入力してください。");
                }

            } while (retry != 0 && retry != 1);

        } while (retry == 1);

        // retryが0の場合値を返却してメインクラスに返す
        return retry;
    }

}
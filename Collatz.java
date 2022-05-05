// コラッツ予想ゲーム

import java.util.*;

// コラッツ予想ゲームのメインクラス
public class Collatz {
    public static int collatz() {

        // 入力準備
        Scanner stdIn = new Scanner(System.in);

        // 初期値を0にする
        int retry = 0;

        // コラッツ予想についての説明
        System.out.println("コラッツ予想ゲーム！");
        System.out.println("コラッツ予想とはXが偶数なら2で割る");
        System.out.println("コラッツ予想とはXが奇数なら3倍して1足す");
        System.out.println("その最終的な結果が１になるというもの");

        // retryが1の時ループ処理をする
        // 整数を入力してもらう
        do {

            // 例外処理を行う
            try {
                System.out.print("整数を入力してください：");
                long x = stdIn.nextLong();

                // 1になるまでループ処理をする
                while (x != 1) {
                    System.out.print(x + " ");

                    // 0だけは対象外なので除外する
                    if (x == 0) {
                        System.out.println("を入力しないでください。");
                        break;

                    // 余りが０の時、2で割る
                    } else if (x % 2 == 0) {
                        x = x / 2;

                    // それ以外は奇数なので3倍して1を足す
                    } else {
                        x = 3 * x + 1;
                    }
                }

                // 途中の計算を表示する
                System.out.println(x);

            } catch (InputMismatchException ex) {
                System.out.println("整数を入力してください。");
            } catch (NoSuchElementException ex) {
                System.out.println("整数を入力してください。");
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

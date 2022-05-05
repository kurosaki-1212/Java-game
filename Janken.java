// ジャンケンゲーム

import java.util.*;

// ジャンケンゲームのメインクラス
public class Janken {
    public static int janken() {

        // ゲーム名の表示
        System.out.println("ジャンケンゲーム");

        // 入力準備
        Scanner stdIn = new Scanner(System.in);

        // 乱数の準備
        Random rand = new Random();

        // 出す手のリスト生成
        String[] hands = { "グー", "チョキ", "パー" };

        // 初期値を0にする
        int retry = 0;

        // retryが1の時ループ処理をする
        do {

            // コンピューターの手（0, 1, 2の乱数）
            int comp = rand.nextInt(3);

            // プレイヤーの手（0, 1, 2で読み込む）
            int user;

            // 例外処理を行う
            try {

                // 0,1,2のどれかが入力されるまでループ処理をする
                do {
                    System.out.print("じゃんけんポン！：");

                    // 三回選択肢を表示
                    for (int i = 0; i < 3; i++)
                        System.out.printf("(%d)%s ", i, hands[i]);
                    System.out.print("：");

                    // ユーザに数字で入力してもらう
                    user = stdIn.nextInt();
                } while (user < 0 || user > 2);

                // 両者の手を表示
                System.out.printf("私は%sで、あなたは%sです。・\n", hands[comp], hands[user]);

                // 判定
                int judge = (user - comp + 3) % 3;

                // 結果によって勝ち負けを表示する
                switch (judge) {
                    case 0:
                        System.out.println("引き分けです。");
                        break;
                    case 1:
                        System.out.println("あなたの負けです。");
                        break;
                    case 2:
                        System.out.println("あなたの勝ちです。");
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("整数を入力して下さい。");
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

        // retryが0の場合値を返却しメインクラスに返す
        return retry;
    }
}
package DotComGame;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom(); // 初始化一个SimpleDotCom对象

        int[] loactions = {2, 3, 4}; // 创建带有dot com位置的数组
        dot.setLocationCells(loactions); // 调用dot com的setter

        /* String userGuess = "2"; // make a false user guess

          String result = dot.checkYourself(userGuess); // 调用被测的方法并传入数据

          String testResult = "failed";

        if(result.equals("hit")) {
            testResult = "passed"; // 测试返回”hit“才算成功
        }

        System.out.println(testResult); // 输出测试结果 */
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);

    }
}

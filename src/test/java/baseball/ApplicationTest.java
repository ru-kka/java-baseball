package baseball;

import baseball.count.Count;
import baseball.generateRandomNum.GenerateRandomNum;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 컴퓨터_랜덤숫자_생성() {
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();
        List<Integer> randomNum = generateRandomNum.generate();

        assertThat(3).isEqualTo(randomNum.size());
        System.out.println(randomNum);
    }

    @Test
    void 판정_카운트() {
        Count count = new Count();
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();

        List<Integer> computer = generateRandomNum.generate();
        List<Integer> player = generateRandomNum.generate();

        String result = count.count(computer,player);

        System.out.println(computer);
        System.out.println(player);
        System.out.println(result);
    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

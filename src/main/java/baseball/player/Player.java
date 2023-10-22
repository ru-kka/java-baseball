package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> enter() throws IllegalArgumentException {
        List<Integer> player = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String playerString = Console.readLine();
        if(playerString.length() != 3){
            throw new IllegalArgumentException("입력은 세자리로 이루어져야합니다.");
        }

        for(int i = 0; i <playerString.length(); i++){
            char digitChar = playerString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            for(int j = 0; j <player.size(); j++){
                if(player.get(j) == digit){
                    throw new IllegalArgumentException("입력은 중복되지 않은 숫자로 이루어져야합니다.");
                }
            }
            if(!(digit >=1 && digit <= 9)){
                throw new IllegalArgumentException("입력은 1~9의 숫자로 이루어져야합니다.");
            }
            player.add(digit);
        }

        return player;
    }
}

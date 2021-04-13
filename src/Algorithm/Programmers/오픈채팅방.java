package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = solution(record);
        for(String s : result) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] record) {
        int len = 0;
        for(String s : record) {
            if(!s.contains("Change"))
                len++;
        }

        String[] answer = new String[len];
        Map<String, String> usrList = new HashMap<>();
        for(String s : record) {
            String[] buf = s.split(" ");
            if(buf[0].equals("Enter") || buf[0].equals("Change")) {
                setUser(buf, usrList);
            }
        }

        int index = 0;
        for(int i = 0; i < record.length; i++) {
            String[] buf = record[i].split(" ");
            if(buf[0].equals("Enter")) {
                answer[index] = usrList.get(buf[1]) + "님이 들어왔습니다.";
                index++;
            } else if(buf[0].equals("Leave")) {
                answer[index] = usrList.get(buf[1]) + "님이 나갔습니다.";
                index++;
            }
        }

        return answer;
    }

    private static void changeNickName(String[] buf, Map<String, String> usrList) {
        usrList.put(buf[1], buf[2]);
    }

    private static void setUser(String[] buf, Map<String, String> usrList) {
        if(usrList.containsKey(buf[1])) {
            changeNickName(buf, usrList);
        } else {
            usrList.put(buf[1], buf[2]);
        }
    }
}

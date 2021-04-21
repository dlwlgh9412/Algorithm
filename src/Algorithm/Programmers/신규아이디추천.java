package Algorithm.Programmers;



public class 신규아이디추천 {
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }

    private static String solution(String new_id) {
        int len = new_id.length();
        //1. 대문자 -> 소문자 치환
        new_id = new_id.toLowerCase();
        //2. 알파벳 소문자, 숫자, 빼기 , 밑줄, 마침표 제외 문자 제거
        for(int i = 0; i < new_id.length(); i++) {
            if (!(97 <= new_id.charAt(i) && new_id.charAt(i) <= 122)
                    && !(48 <= new_id.charAt(i) && new_id.charAt(i) <= 57)
                    && new_id.charAt(i) != 45 && new_id.charAt(i) != 46
                    && new_id.charAt(i) != 95) {
                new_id = new_id.replace(Character.toString(new_id.charAt(i)), "");
                i--;
            }
        }

        //3. 마침표 2개 이상인 경우 한개로
        for(int i = 0; i < new_id.length(); i++) {
            if(new_id.charAt(i) == 46 && i != new_id.length() - 1) {
                int idx = i + 1;
                while(idx != new_id.length() && new_id.charAt(idx) == 46) {
                    if(new_id.charAt(idx) == 46) {
                        idx++;
                    }
                }
                new_id = new_id.replace(new_id.substring(i, idx), ".");
            }
        }

        //4. 마침표가 처음이나 끝에 위치 일 경우 제거
        if(0 < new_id.length()) {
            if (new_id.charAt(0) == 46) {
                new_id = new_id.substring(1, new_id.length());
            }
        }
        if(1 < new_id.length()) {
            if (new_id.charAt(new_id.length() - 1) == 46) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        //5. 빈문자열일 경우 a를 대입
        if(new_id.equals("")) {
            new_id += "a";
        }

        //6. 아이디의길이 16자 이상이면 처음 15자를 제외한 나머지 문자 제거
        if(16 <= new_id.length()) {
            new_id = new_id.substring(0, 15);
        }

        //7. 아이디의 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될때까지 반복해서 붙인다.
        if(new_id.length() <= 2) {
            String last = Character.toString(new_id.charAt(new_id.length() - 1));
            for(int i = new_id.length(); i < 3; i++) {
                new_id += last;
            }
        }

        if(0 < new_id.length()) {
            if (new_id.charAt(0) == 46) {
                new_id = new_id.substring(1, new_id.length());
            }
        }
        if(1 < new_id.length()) {
            if (new_id.charAt(new_id.length() - 1) == 46) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        return new_id;
    }
}


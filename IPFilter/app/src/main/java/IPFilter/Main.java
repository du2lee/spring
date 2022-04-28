package IPFilter;

import java.util.*;
/* *
특정 IP를 입력하여 필터링 대상 여부를 확인하는 IP Filter Class를 작성 하시오.
	필터링 IP 규칙은 ###.###.###.### 나 ###.###.###.0/24 와 같은 형태로 지정한다.
	Test Class를 작성하시오.
@TODO
 - IP 차단 리스트가 있다.
 - 차단 형식 1. 1~255 랜덤. 1~255 랜덤, 1~255 랜덤, 1~255 랜덤
 - 차단 형식 2. 1~255 랜덤. 1~255 랜덤, 1~255 랜덤, 0/24
 - (마지막에)차단하고 싶은 IP를 추가할 수 있도록 한다.
 - IP 차단 리스트랑 match가 되면 IP : 이 아이피는 차단되었습니다.
 - 차단 형식 1, 2 중에 랜덤으로 테스트 진행
 - 테스트 IP는 정규식 검증을 통해 올바르게 들어와야 한다.
 - 테스트 IP가 들어오면 이 아이피는 블랙 리스트 입니다, 화이트 리스트 입니다. 알려주도록 프린트
 - ** 결국엔 차단 리스트가 100만개가 있는데 여기서 100만개중에 1개가 있는지 없는지 반복하는것이기때문에
 - ** 자료구조중에 1개를 빨리 찾는 로직을 선택한다.
 - for문에 synchronized로 차단 필터 진행할것.

 [
 100,324.342.342,
 100,324.342.342,
 100,324.342.0/24,
 ]

JSON 형식의 트리 구조 형태로 차단 리스트를 저장하면 될듯.
{
    100: {
        150: {
            200: [250, 251],
            205: [250]
        }
    },
    105: {
        110: {
            115: [120]
        },
        115: {
            150: [200]
        }
    }
}

* */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IPFilter ipFilter = new IPFilter("hi");
        ipFilter.randomIpAddress(true);
        ipFilter.randomIpAddress(false);

        System.out.println("차단 하고 싶은 IP주소를 입력하시오");
        String inputIp = sc.next();
        System.out.println(ipFilter.addIpAddress(inputIp));

        System.out.println("차단 여부를 확인하고 싶은 IP주소를 입력하시오");
        inputIp = sc.next();
        ipFilter.findIPAddress(inputIp);

    }
}

package IPFilter;

import java.util.*;

/* *
특정 IP를 입력하여 필터링 대상 여부를 확인하는 IP Filter Class를 작성 하시오.
	필터링 IP 규칙은 ###.###.###.### 나 ###.###.###.0/24 와 같은 형태로 지정한다.
	Test Class를 작성하시오.
* */


public class IPFilter {
    private String ip = "0.0.0.0";
    private ArrayList<String> blackList =  new ArrayList<String>();

    public IPFilter(String ip) {
        this.ip = ip;
    }

    public String getFilteredIp() {
        String filteredIP = "hi:" + this.ip;
        return filteredIP;
    }


    public ArrayList<String> randomIpAddress(boolean type){
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
    
        for (int idx = 0; idx < 10; idx++){
            String ipAddress = "";

            for(int i = 0; i < 4; i++){
                int num = rand.nextInt(256);
                
                if(i >= 3) {
                    if (type == true) ipAddress = ipAddress + Integer.toString(num);
                    else ipAddress = ipAddress + "0/24";
                }
                else ipAddress = ipAddress + Integer.toString(num) + ".";

            }
            blackList.add(ipAddress);
        }

        return blackList;
    }

    public ArrayList<String> addIpAddress(String ipAddress){
            blackList.add(ipAddress);
        return blackList;
    }

    public void findIPAddress(String ipAddress){

        if(blackList.contains(ipAddress)){
            System.out.println("차단되었습니다");
        }
        else{
            System.out.println("사용가능합니다.");
        }
        
    }

}

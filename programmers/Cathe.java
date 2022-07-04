import java.util.Iterator;
import java.util.LinkedList;

// 2018 블라인드 카카오 1차 문제 중 캐시 문제
class Cathe {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int storeSize = 0;
        if( cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> store = new LinkedList<String>();
        int citySize = cities.length;
        Iterator<String> it = store.iterator();
        for (int i = 0; i < citySize; ++i) {
            storeSize = store.size();
            it = store.iterator();
          	while(true) {
                
                if(!it.hasNext()) {
                    if(storeSize == cacheSize) {
                        store.removeFirst();   
                    }
	    	        store.addLast(cities[i]);
                    answer += 5;
                    break;
                }
                
			    String str = it.next();
                if(str.equalsIgnoreCase(cities[i]))
                {
                    store.remove(str);
		            store.addLast(cities[i]);
                    answer++;
                    break;
                }
             
		    }
            
            
        }
        
        return answer;
    }
}